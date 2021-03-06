package com.jgg.sdp.parser.lang;

import java_cup.runtime.Symbol;

import com.jgg.sdp.core.ctes.*;
import com.jgg.sdp.core.exceptions.*;
import com.jgg.sdp.parser.base.*;

import static com.jgg.sdp.parser.lang.ZCDSym.*;
import static com.jgg.sdp.parser.lang.ZCZSym.*;

%%

%public
%class      ZCDLexer
%extends    GenericLexer
%scanerror  ParseException

%line
%column
%char
%full
%ignorecase
%cup

%xstate  ID_DIVISION , ENV_DIVISION , DATA_DIVISION , PROC_DIVISION
%xstate  CONF_SECT , IO_SECT

%xstate PIC , BLOBSIZE
%xstate ENDLINE , EATLINE 
%xstate STEXEC , EMBEDDED 
%xstate EMBEDDED_QUOTE , EMBEDDED_DQUOTE
%xstate CICSSYM
%xstate ST_FUNCTION

%xstate COMMENT, COMMENT2        
%xstate QUOTE_STRING   
%xstate DQUOTE_STRING 
  
%xstate SDP

// Estados para COPY REPLACING
%xstate COPYS  

%{

   String cpyName = null;
   String cicsVerb = null;
   int    lastSymbol = -1;
   int    prevSymbol = -1;
   int    nPars = 0;
   int    inIndex = 0;
   Symbol begExec = null;

   int    pushBack = 0;
      
   boolean beginPic  = true;   
   boolean prevSpace = false;
         
   public void resetLiteral(String txt) {
      data = true;
      litLine = yyline;
      litColumn = yycolumn;
      cadena = new StringBuilder(txt);
   }

   public Symbol literal(boolean clean) { 
       String txt = cadena.toString();
       if (clean) cadena.setLength(0);
       return literal(txt); 
   }
   
   public Symbol literal(String txt) {
      setLastSymbol(LITERAL);
      print("Devuelve LITERAL - " + txt);
      Symbol s = new Symbol(LITERAL, litLine, litColumn, txt);
      Symbol x = symbolFactory.newSymbol(txt, LITERAL, s);
      for (int idx = 0; idx < txt.length(); idx++) {
          if (txt.charAt(idx) < ' ') {
              checkLiteral(x);
              break;
          } 
      }
      return x;      
   }

   public Symbol symbolDummy(int code) {
      data = true;
      lastSymbol = 0;
      return symbol(code);
   }
                  
   public void checkCharacters() {
      //JGG mirar tabs  No hace nada
   }
     
   public void checkSymbol() {
      // Chequea el uso de SKIP, EJECT, etc
   }                  
   
   public Symbol symbol(int code){
      return symbol(code, yytext());
   }
/*   
   public Symbol symbol(String txt){
      return symbol(0, txt);
   }
   */

   public Symbol symbolCheck(int code) {
      checkSymbol();
      return symbol(code);
   }
   
   public Symbol symbol(int code, String txt) {
      setLastSymbol(code);
      data = true;
      int col = yycolumn + COLOFFSET;
      
//      if (txt.indexOf('\t') != -1) checkSymbol(symbol("TAB")); 
      
      if (code != 0) {      
          print("Devuelve SYMBOL " + code + " (" + (yyline + 1) + "," + col + ") " + txt);
      }    
      return symbolFactory.newSymbol(txt, code, new Symbol(code, yyline + 1, col, txt));
   }

   private void setLastSymbol(int id) {
      prevSymbol = lastSymbol;
      lastSymbol = id;
   }

  private void excepcion(int code) {
      throw new NotSupportedException(code, info.module.getName(), yyline + 1, yycolumn + 1, yytext());
  }
  
%}

%init{
   initLexer(COMMENT);
%init}

%eofval{

    if (yymoreStreams()) {
        info.unit.removeSource();
        info.removeOffset();
        yypopStream();
    }
    else {
         info.addOffset(yyline);
         info.addOffset(yychar - pushBack);
         return new java_cup.runtime.Symbol(ZCDSym.EOF);
    }
        
%eofval}

SPACES=[ ]+
TABS=[\t]+
BLANKS=[ \t]+

// Generico para cargar buffer
WORD=[a-zA-Z0-9\_\-]+
ENDVERB=END-[a-zA-Z]+

ALPHA=[a-zA-Z]+

NUMERO=[+|-]?[0-9]+
DECIMAL=[+|-]?[0-9]+[\.\,][0-9]+
DECIMAL2=[\.\,][0-9]+
HEXVALUE=[xX][\'\"][0-9aAbBcCdDeEfF]+[\'\"]

ALPHANUM=[a-zA-Z0-9]
ID = {ALPHANUM}({ALPHANUM}|\-|\_)*
SP=[ ]{1}
PARAGRAPH  = {SP}{ID} 

SIZE=\({BLANKS}*{NUMERO}[kKmM]?{BLANKS}*\)
PICLEN=[sS\+\-]?[aAxXzZ9]?{SIZE}

SDPD=DESC  | DESCRIPTION
SDPDESC=[>]?[\ \t]+SDP[\ \t]+{SDPD}
SDPEND=[>]?[\ \t]+SDP[\ \t]+END
SDPMASTER=[>]?[\ \t]+SDP[\ \t]+MASTER

%% 

/******************************************************************************/
/******************************************************************************/
/***   INICIO SOLO CONTROLA ID DIVISION                                     ***/
/******************************************************************************/
/******************************************************************************/

 ^[\*]               { commentInit(yytext(), yyline);  }
 ^[\/]               { commentInit(yytext(), yyline);  }  
 ^[dD]               { commentInit(yytext(), yyline);  }
 ^[ ]+SKIP[1-9]?     { checkSymbol();                  }
 ^[ ]+EJECT[ ]*[\.]? { checkSymbol();                  }

IDENTIFICATION{BLANKS}DIVISION  { checkDivision(); 
                                  inDesc = false;
                                  resetState(ID_DIVISION);
                                  return symbol(DIV_ID);
                                }
ID{BLANKS}DIVISION              { checkDivision(); 
                                  inDesc = false;
                                  resetState(ID_DIVISION);
                                  return symbol(DIV_ID);
                                }

COPY         { initEmbedded(); 
               pushState(COPYS); 
               return symbol(ZCZSym.COPY);     
             }
EXECUTE      { begExec = symbolDummy(ZCZSym.EXEC);   pushState(STEXEC);    }
EXEC         { begExec = symbolDummy(ZCZSym.EXEC);   pushState(STEXEC);    }


 ^\*{SDPEND}       { info.module.incComments(true);
                     inDesc = false;
                     data = true;
                   }
                    

 ^\*{SDPDESC}      { resetLiteral("");
                     pushState(SDP);
                     info.module.incComments(true);
                     inDesc = true;
                     data = true;
                     return symbol(SDPDESC);   
                   }

  
 ^\*>               { pushState(COMMENT2);   }

CBL                { checkSymbol(); pushState(EATLINE);  }
REPLACE            { excepcion(MSG.EXCEPTION_NOT_ALLOW); }
{SPACES}           { /* nada */ }
{TABS}             { checkCharacters(); }
{ID}               { checkSymbol();  pushState(EATLINE);    }



\n                 { info.module.incLines(data); data = false; }
\r                 { /* do nothing */ }

  [^]                            { System.out.println("JGGERR INIT caracter: " + yytext() + "(" + yyline + "," + yycolumn + ")"); }
//  .                            { System.out.println("JGGERR INIT caracter: " + yytext()); }                             


/******************************************************************************/
/******************************************************************************/
/***               IDENTIFICATION DIVISION                                  ***/
/******************************************************************************/
/******************************************************************************/

<ID_DIVISION> {
  ^[\*]               { commentInit(yytext(), yyline); }
  ^[\/]               { commentInit(yytext(), yyline); }  
  ^[dD]               { commentInit(yytext(), yyline); }
  ^[ ]+SKIP[1-9]?     { checkSymbol();                 }
  ^[ ]+EJECT[ ]*[\.]? { checkSymbol();                 }

  AUTHOR           { inDesc = false; return symbol(AUTHOR); }
  COMMON           { data = true; }
  
  DATE-WRITTEN     { return symbol(DATEW);    }
  DATE-COMPILED    { return symbol(DATEC);    }  
  
  INITIAL          { data = true; }  
  INSTALLATION     { inDesc = false; return symbol(INSTALLATION); }
  
  PROGRAM-ID       { inDesc = false; return symbol(PGMID);  }
  PROGRAM          { data = true; }  

  RECURSIVE        { data = true; }
  REMARKS          { excepcion(MSG.EXCEPTION_NOT_ALLOW); }
  
  COPY         { initEmbedded(); 
                 pushState(COPYS); 
                 return symbol(ZCZSym.COPY);           
               }
  EXECUTE      { begExec = symbolDummy(ZCZSym.EXEC);  pushState(STEXEC);    }
  EXEC         { begExec = symbolDummy(ZCZSym.EXEC);     pushState(STEXEC);    }

  ENVIRONMENT{BLANKS}DIVISION     { inDesc = false;
                                    resetState(ENV_DIVISION); 
                                    return symbol(DIV_ENV); 
                                  }

  DATA{BLANKS}DIVISION            { resetState(DATA_DIVISION);
                                    inDesc = false;   
                                    return symbol(DIV_DATA);
                                  }

  PROCEDURE{BLANKS}DIVISION       { pushBack = yytext().length(); yyclose(); /*resetState(PROC_DIVISION);
                                    info.setInCode();
                                    inDesc = false;                                  
                                    return symbol(DIVPROC); */
                                  }
  
  {ID}             { return symbol(ZCDSym.ID);     }
  {NUMERO}         { return symbol(ZCDSym.NUMERO); }
  {SPACES}         { /* nada */ }
  {TABS}           { checkCharacters();   }

  \.               { return symbol(ENDP);   }
  "-"              { data = true;  }
  ","              { data = true;  }
  \n               { info.module.incLines(data); data = false; }
  \r               { /* do nothing */ }
  .                { data = true;  }
} 

/******************************************************************************/
/******************************************************************************/
/***             ENVIRONMENT DIVISION                                       ***/
/******************************************************************************/
/******************************************************************************/

<ENV_DIVISION> {

  ^[\*]               { commentInit(yytext(), yyline); }
  ^[\/]               { commentInit(yytext(), yyline); }  
  ^[dD]               { commentInit(yytext(), yyline); }
  ^[ ]+SKIP[1-9]?     { checkSymbol();                 }
  ^[ ]+EJECT[ ]*[\.]? { checkSymbol();                 }
                                   
  CONFIGURATION{BLANKS}SECTION   { pushState(CONF_SECT);   
                                   return symbol(CONF_SECTION); 
                                 }
                                 
  INPUT-OUTPUT{BLANKS}SECTION    { pushState(IO_SECT);
                                   return symbol(IO_SECTION);   
                                 }

  DATA{BLANKS}DIVISION           { resetState(DATA_DIVISION);
                                   inDesc = false;   
                                   return symbol(DIV_DATA);
                                 }

  PROCEDURE{BLANKS}DIVISION      { pushBack = yytext().length(); yyclose(); /* resetState(PROC_DIVISION);
                                   info.setInCode();
                                   inDesc = false;                                  
                                   return symbol(DIVPROC); */
                                 }

  COPY         { initEmbedded(); 
                 pushState(COPYS);   
                 return symbol(ZCZSym.COPY);         
               }
  EXECUTE      { begExec = symbolDummy(ZCZSym.EXEC); pushState(STEXEC);    }
  EXEC         { begExec = symbolDummy(ZCZSym.EXEC);    pushState(STEXEC);    }

  \.               { return symbol(ENDP); }                                   
 
  {SPACES}         { /* nada */          }
  {TABS}           { checkCharacters();   }
  \n               { info.module.incLines(data); data = false; }
  \r               { /* do nothing */ }

  [^]              { data = true; 
                     System.err.println("JGG: " + yyline + "-" + yycolumn + " -" + yytext() + "-"); }

 }

/******************************************************************************/
/******************************************************************************/
/***    CONFIGURATION SECTION                                               ***/
/******************************************************************************/
/******************************************************************************/

<CONF_SECT> {
  ^[\*]               { commentInit(yytext(), yyline); }
  ^[\/]               { commentInit(yytext(), yyline); }  
  ^[dD]               { commentInit(yytext(), yyline); }
  ^[ ]+SKIP[1-9]?     { checkSymbol();                 }
  ^[ ]+EJECT[ ]*[\.]? { checkSymbol();                 }

  \'               { pushState(QUOTE_STRING);  }  
  \"               { pushState(DQUOTE_STRING); }

  CLASS            { return symbol(CLASS); }
  COMMA            { data = true; }
  DEBUGGING        { data = true; }
  DECIMAL-POINT    { return symbol(DEC_POINT); }
  IS               { data = true; }
  MODE             { data = true; }
  OBJECT-COMPUTER  { return symbol(OBJECT_COMPUTER); }
  SOURCE-COMPUTER  { return symbol(SOURCE_COMPUTER); }
  SPECIAL-NAMES    { return symbol(SPECIAL_NAMES);   }
  THRU             { data = true; } 
  WITH             { data = true; }

  COPY         { initEmbedded(); 
                 pushState(COPYS); 
                 return symbol(ZCZSym.COPY);     
               }
  EXECUTE      { begExec = symbolDummy(ZCZSym.EXEC); pushState(STEXEC);    }
  EXEC         { begExec = symbolDummy(ZCZSym.EXEC);    pushState(STEXEC);    }

  INPUT-OUTPUT{BLANKS}SECTION    { popState();
                                   pushState(IO_SECT);
                                   return symbol(IO_SECTION);   
                                 }

  DATA{BLANKS}DIVISION           { resetState(DATA_DIVISION);
                                   inDesc = false;   
                                   return symbol(DIV_DATA);
                                 }

  PROCEDURE{BLANKS}DIVISION      { pushBack = yytext().length(); yyclose(); /*resetState(PROC_DIVISION);
                                   info.setInCode();
                                   inDesc = false;                                  
                                   return symbol(DIVPROC); */
                                 }

  {NUMERO}         { return symbol(ZCDSym.NUMERO); }   
  {ID}             { return symbol(ZCDSym.ID);     }
  {SPACES}         { /* nada */ }
  {TABS}           { checkCharacters();   }
  \.               { return symbol(ENDP);   }
  \,               { data = true; }

  \n               { info.module.incLines(data); data = false; }
  \r               { /* do nothing */ }

  .       { System.err.println("I-O ERROR Configuration Encuentra en (" + yyline + "," + yycolumn + " -" + yytext() + "-"); }
}

/******************************************************************************/
/***    INPUT-OUTPUT SECTION                                                ***/
/******************************************************************************/

<IO_SECT> {
  ^[\*]               { commentInit(yytext(), yyline); }
  ^[\/]               { commentInit(yytext(), yyline); }  
  ^[dD]               { commentInit(yytext(), yyline); }
  ^[ ]+SKIP[1-9]?     { checkSymbol();                 }
  ^[ ]+EJECT[ ]*[\.]? { checkSymbol();                 }

  ACCESS         { return symbol(ACCESS);       }
  ALTERNATE      { return symbol(ALTERNATE);    }  
  ASSIGN         { return symbol(ASSIGN);       }
  DYNAMIC        { return symbol(DYNAMIC);      }
  DISPLAY        { return symbol(ZCDSym.DISPLAY);      }
  DUPLICATES     { data = true;                 }  
  INDEXED        { return symbol(INDEXED);      }
  FILE-CONTROL   { return symbol(FILE_CONTROL); }
  FILE           { data = true;                 }
  IS             { data = true;                 }
  KEY            { data = true;                 }
  LINE           { data = true;                 }
  MODE           { data = true;                 }
  OPTIONAL       { data = true;                 }
  ORGANIZATION   { return symbol(ORGANIZATION); }
  RANDOM         { return symbol(RANDOM);       }
  RECORDING      { return symbol(RECORDING);    }
  RECORD         { return symbol(RECORD);       }
  RELATIVE       { return symbol(RELATIVE);     }
  SELECT         { return symbol(SELECT);       }
  SEQUENTIAL     { return symbol(SEQUENTIAL);   }
  SKIP[1-9]?     { data = true;                 }
  STATUS         { return symbol(STATUS);       }
  TO             { data = true;                 }
  WITH           { data = true;                 }

  COPY         { initEmbedded(); 
                 pushState(COPYS);  
                 return symbol(ZCZSym.COPY);          
               }
  EXECUTE      { begExec = symbolDummy(ZCZSym.EXEC); pushState(STEXEC);    }
  EXEC         { begExec = symbolDummy(ZCZSym.EXEC);    pushState(STEXEC);    }

  DATA{BLANKS}DIVISION           { resetState(DATA_DIVISION);
                                   inDesc = false;   
                                   return symbol(DIV_DATA);
                                 }

  PROCEDURE{BLANKS}DIVISION      { pushBack = yytext().length(); yyclose(); /* resetState(PROC_DIVISION);
                                   info.setInCode();
                                   inDesc = false;                                  
                                   return symbol(DIVPROC);*/
                                 }
  
 ^\*{SDPMASTER}    { pushState(SDP);
                     info.module.incComments(true);
                     inDesc = false;
                     data = true;
                     return symbol(SDPMASTER);   
                   }

  {SPACES}         { /* nada */ }
  {TABS}           { checkCharacters();            }
  {NUMERO}         { return symbol(ZCDSym.NUMERO); }   
  {ID}             { return symbol(ZCDSym.ID);     }
  \.               { return symbol(ENDP);          }
  \,               { data = true; }

  \n               { info.module.incLines(data); data = false; }
  \r               { /* do nothing */ }

  .       { System.err.println("I-O ERROR Encuentra en (" + yyline + "," + yycolumn + " -" + yytext() + "-"); }
}


/******************************************************************************/
/******************************************************************************/
/***                    DATA DIVISION                                       ***/
/******************************************************************************/
/******************************************************************************/

<DATA_DIVISION> {

  ^[\*]                 { commentInit(yytext(), yyline);    }
  ^[\/]                 { commentInit(yytext(), yyline);    }  
  ^[dD]                 { commentInit(yytext(), yyline);    }
  ^[ \t]+SKIP[1-9]?     { checkSymbol();  }
  ^[ \t]+EJECT[ ]*[\.]? { checkSymbol(); }
  ^\-                   { checkSymbol();     }  
  
  FILE{BLANKS}SECTION            { return symbol(FILE_SECTION);    }
  WORKING-STORAGE{BLANKS}SECTION { return symbol(WORKING_SECTION); }
  LOCAL-STORAGE{BLANKS}SECTION   { return symbol(LOCAL_SECTION);   }
  LINKAGE{BLANKS}SECTION         { return symbol(LINKAGE_SECTION); }
  PROCEDURE{BLANKS}DIVISION      { pushBack = yytext().length(); yyclose(); /*resetState(PROC_DIVISION);
                                   info.setInCode();
                                   inDesc = false;                                  
                                   return symbol(DIVPROC); */
                                 }
  
  ALL                            { data = true;              }
  ANY[ ]+LENGTH                  { data = true;              }
  ARE                            { data = true;              }
  ASCENDING                      { return symbol(ORDER);     }

  BASED                          { data = true;              }
  BINARY                         { return symbol(BINARY);    }
  BLANK[ ]+WHEN[ ]+ZERO          { data = true;              }
  BLANK[ ]+ZERO                  { data = true;              }
  BLOB-LOCATOR                   { return symbol(BLOB_LOCATOR); }
  BLOB                           { pushState(BLOBSIZE) ; return symbol(BLOB);   }
  BLOCK                          { return symbol(BLOCK);     }
  BY                             { data = true;              }
  
  CHARACTER[sS]?                 { data = true;              }
  COMPUTATIONAL-1                { return symbol(COMP1);     }
  COMPUTATIONAL-2                { return symbol(COMP2);     }
  COMPUTATIONAL-3                { return symbol(COMP3);     }
  COMPUTATIONAL-4                { return symbol(COMP4);     }
  COMPUTATIONAL-5                { return symbol(COMP5);     }
  COMPUTATIONAL-6                { return symbol(COMP6);     }      
  COMPUTATIONAL                  { return symbol(BINARY);    }
  COMP-1                         { return symbol(COMP1);     }  
  COMP-2                         { return symbol(COMP2);     }
  COMP-3                         { return symbol(COMP3);     }
  COMP-4                         { return symbol(COMP4);     }
  COMP-5                         { return symbol(COMP5);     }
  COMP-6                         { return symbol(COMP6);     }          
  COMP                           { return symbol(BINARY);    }
  CONTAIN[sS]?                   { data = true;              }
     
  DATA                           { return symbol(DATA);      }
  DATE                           { pushState(ENDLINE);       }
  DEPENDING                      { return symbol(ZCDSym.DEPENDING); }
  DESCENDING                     { return symbol(ORDER);     }
  DFHRESP                        { cicsVerb = "DFHRESP";  pushState(CICSSYM);       }  
  DFHVALUE                       { cicsVerb = "DFHvalue"; pushState(CICSSYM);       }
  DISPLAY                        { return symbol(ZCDSym.DISPLAY);   }
           
  EXTERNAL                       { data = true;              }
  
  FD                             { return symbol(FD);        } 
  FILLER                         { return symbol(FILLER);    }
  FROM                           { data = true;              }  
  F                              { return symbol(FILLER);    }

  GLOBAL                         { data = true;              }
    
  INDEXED                        { return symbol(INDEXED);   }
  INDEX                          { return symbol(INDEX);     }
  IN                             { return symbol(ZCDSym.IN);        }  
  IS                             { data = true;              }
  
  JUSTIFIED                      { data = true;              }
  JUST                           { data = true;              }

  KEY                            { data = true;              }
  
  LABEL                          { return symbol(LABEL);     }
  LEADING                        { data = true;              }
  LINAGE                         { return symbol(LINAGE);    }  
  LINE[sS]?                      { data = true;              }
  
  MODE                           { data = true;              }
  
  NULL[sS]?                      { return symbol(ZCDSym.NULL);      }

  OMITTED                        { data = true;              }
        
  RECORDING                      { return symbol(RECORDING); }                  
  RECORDS                        { return symbol(RECORDS);   }
  RECORD                         { return symbol(RECORD);    }
  REDEFINES                      { return symbol(REDEFINES); }
  RENAMES                        { return symbol(RENAMES);   }
  
  OCCURS                         { return symbol(OCCURS);    }
  OF                             { return symbol(ZCDSym.OF); }
  ON                             { data = true;              }

  PACKED-DECIMAL                 { return symbol(PACKED);    }     
  PICTURE                        { beginPic = true; pushState(PIC) ; return symbol(PICTURE);   }
  PIC                            { beginPic = true; pushState(PIC) ; return symbol(PICTURE);   }
  POINTER                        { return symbol(ZCDSym.POINTER); }

  ROWID                          { return symbol(ROWID);   }
  RIGHT                          { data = true;            }
  
  SD                             { return symbol(SD);      }  
  SEPARATE                       { data = true;            }
  SIGN                           { data = true;            }
  SIZE                           { data = true;            }
  SQL                            { data = true;            }
  STANDARD                       { data = true;            }
  SYNCHRONIZED                   { data = true;            }
  SYNC                           { data = true;            }

  TIMES                          { data = true;            }  
  TO                             { return symbol(ZCDSym.TO);      }
  TRAILING                       { data = true;            }
  THROUGH                        { return symbol(ZCDSym.THRU);    }
  THRU                           { return symbol(ZCDSym.THRU);    }
  TYPE                           { data = true;            }
  
  USAGE                          { return symbol(USAGE);   }
    
  VALUE[sS]?                     { return symbol(ZCDSym.VALUE);   }
  VARYING                        { data = true;            }  

  ZERO[sS]?                      { return symbol(ZCDSym.ZERO);    }
  ZEROES                         { return symbol(ZCDSym.ZERO);    }
  SPACE[sS]?                     { return symbol(ZCDSym.SPACES);  }
  LOW\-VALUE[sS]?                { return symbol(ZCDSym.LOWVAL);  }
  HIGH\-VALUE[sS]?               { return symbol(ZCDSym.HIGHVAL); } 
  QUOTE[sS]?                     { return symbol(ZCDSym.QUOTE);   }

  COPY         { initEmbedded(); 
                 pushState(COPYS);         
                 return symbol(ZCZSym.COPY);  
               }
  EXECUTE      { begExec = symbolDummy(ZCZSym.EXEC); pushState(STEXEC);    }
  EXEC         { begExec = symbolDummy(ZCZSym.EXEC); pushState(STEXEC);    }

  {DECIMAL}                      { return symbol(ZCDSym.NUMERO);  }
  {DECIMAL2}       { return symbol(ZCDSym.NUMERO);  }  
  {NUMERO}         { return symbol(ZCDSym.NUMERO);  }
  {HEXVALUE}       { return symbol(ZCDSym.HEX_VAL); }
  {ID}             { return symbol(ZCDSym.ID);      }
  {SPACES}         { /* nada */ }
  {TABS}           { checkCharacters();             }
  {NUMERO}         { return symbol(ZCDSym.NUMERO);  }   
  "("              { return symbol(ZCDSym.LPAR);    }
  ")"              { return symbol(ZCDSym.RPAR);    }
  \.               { return symbol(ENDP);   }
  \,               { data = true; }
  \'               { print("ENTRA EN QUOTE"); pushState(QUOTE_STRING);  }  
  \"               { pushState(DQUOTE_STRING); }

  \n               { info.module.incLines(data); data = false; }
  \r               { /* do nothing */ }

}

/* PICTURE es PIC espacios formato [espacios|punto] con comentarios o sin ellos */
<PIC> {
  ^[\*]                   { commentInit(yytext(), yyline);    }
  ^[\/]                   { commentInit(yytext(), yyline);    }  
  ^[dD][dD][a-zA-Z0-9 ]*  { commentInit(yytext(), yyline);    }

  {SPACES}      { if (beginPic == false) popState();  }
  {TABS}        { checkCharacters();  
                  if (beginPic == false) popState(); 
                }  
  {PICLEN}      { beginPic = false; return symbol(PIC_LEN);      }

  [\.\,\$][\-\+\*\$zZ09]+        { beginPic = false; return symbol(PIC_FMT);      }
  [sS\+\-]?[09bBaAxXzZ\-\+\$]+   { beginPic = false; return symbol(PIC_FMT);      }              
  [Ee][+-]?[9]+                  { beginPic = false; return symbol(PIC_FMT);      }
  [sSvV]+                        { beginPic = false; return symbol(PIC_DEC_EMPTY);      }
  [vV]{NUMERO}                   { beginPic = false; return symbol(PIC_V);        }
  V                              { beginPic = false; return symbol(PIC_DEC_EMPTY);      }

  \.                             { popState(); return symbol(ENDP); }
  
  \n                             { info.module.incLines(data); }
  \r                             { /* do nothing */ }
  [^]                            { System.out.println("JGGERR DATA caracter: " + yytext()); }
  .                            { System.out.println("JGGERR DATA caracter: " + yytext()); }                             
}

<BLOBSIZE> {
  {SIZE}                       { popState(); return symbol(PIC_LEN);      }
}


/*
 * Los literales pueden ser con comillas simples o dobles
 * Puede ser "O'Donell" o bien 'dijo: "Hola"'
 * Por eso hay que distinguir las dos formas
 */
 

<QUOTE_STRING> {
  \'\'          { cadena.append(yytext());  }    
  \'            { popState();  
                  return literal(true); 
                }  
                // Tiene que haber continuacion
  \n            { popState(); } 
  \r            { /* eat */ }

  [^]           { cadena.append(yytext()); }
}


<DQUOTE_STRING> {
  \"\"          { cadena.append(yytext());  }    
  \"            { popState(); 
                  return literal(true); 
                }
                // Tiene que haber continuacion
  \n            { popState(); }
  \r            { /* eat */   }

  [^]           { cadena.append(yytext()); }
}


/* 
  Casos en los que puede haber varios puntos
  Se come hasta fin de linea y devuelve punto
*/
<ENDLINE> {
  {SPACES}      { /* Nada */  }
  {TABS}        { checkCharacters();   }
  \n            { popState(); return symbol(ENDP); }  
  \r            { /* comer */ }
  \.            { /* comer */ }
  .             { /* comer */ }
}

// Se come hasta fin de linea

<EATLINE> {

  {SPACES}      { /* Nada */  }
  {TABS}        { checkCharacters();   }
  \n            { popState(); }  
  \r            { /* comer */ }
  \.            { /* comer */ }
  [^]           { /* comer */ }
}

<COMMENT> {
  {BLANKS}      { commentAppend(yytext()); }
  \n            { commentEnd();            }                 
  [a-zA-Z0-9]+  { commentAppend(yytext()); }
  [^]           { commentAppend(yytext()); }    
}

/*
 * Caso especial para concatenar lineas de descripcion
 */
 
<COMMENT2> {
  {SPACES}      { if (inDesc) cadena.append(yytext());  }
  {TABS}        { checkCharacters();   
                  if (inDesc) cadena.append(yytext());  
                }  
  \n            { info.module.incComments(data);
                  popState();
                  if (inDesc) return literal("");
                }  
\r              { /* do nothing */ }
  [a-zA-Z0-9]+  { if (inDesc) cadena.append(yytext());
                  data = true;  
                }
   .            { if (inDesc) cadena.append(yytext()); 
                  data = true; 
                }    
}
  
 
<COPYS> {
  ^[\*\/]            { pushState(COMMENT);           }
  \.                 { popState(); return symbol(ENDCOPY);  }
  \r                 { info.buffer.append(yytext()); }
  \n                 { info.buffer.append(yytext()); }
  {WORD}             { info.buffer.append(yytext()); }
  .                  { info.buffer.append(yytext()); }  
}


// Transforma DFHRESP(xx) y DFHVALUE(xx) en DFHCICS

<CICSSYM> {
   ")"  { popState(); return symbol(ZCDSym.DFHCICS); }
   .    { /* do nothing */ }
   \r   { /* do nothing */ }
   \n   { info.module.incLines(data); }
   
}

<STEXEC> {
  ^[\*\/dD]       { pushState(COMMENT);       }
   SQL            { info.module.setSQL(); 
                    initEmbedded();  
                    pushState(EMBEDDED);
                    return symbol(SQLDATA);
                  } 
   {SPACES}       { /* DO NOTHING */ }
   {TABS}         { checkCharacters(); }
   \n             { info.module.incLines(data); data = false; }
   \r             { /* do nothing */ }
    
}

<EMBEDDED> {
  ^[\*\/dD]          { pushState(COMMENT);       }
  END-EXEC[ ]*[\.]?  { popState(2); return symbol(ENDSQL); }

  \r           { /* do nothing */ }
  \n           { info.buffer.append(yytext());
                 info.module.incLines(data); 
                 data = false;  
              }
   [^]        { info.buffer.append(yytext()); }                          
}

<EMBEDDED_QUOTE> {
  \'       { info.buffer.append(yytext()); popState(); }
  \r       { info.buffer.append(yytext()); }
  \n       { info.buffer.append(yytext());
             info.module.incLines(data); 
             data = false;  
           }
  [^]      { info.buffer.append(yytext()); }
}

<EMBEDDED_DQUOTE> {
  \"       { info.buffer.append(yytext()); popState(); }
  \r       { info.buffer.append(yytext()); }
  \n       { info.buffer.append(yytext());
             info.module.incLines(data); 
             data = false;  
           }
  [^]      { info.buffer.append(yytext()); }
}

<SDP> {
    .                  { /* Nada */ }
    \r                 { /* Nada */ }
    \n                 { info.module.incLines(data);
                         popState();
                       }
}

/*
[^]                      { throw new ParseException(MSG.EXCEPTION_TOKEN, 
                                   info.module.getName(), yyline + 1, yycolumn + 1, yytext()); 
                       }

*/
