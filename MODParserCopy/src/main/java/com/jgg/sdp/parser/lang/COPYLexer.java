/* The following code was generated by JFlex 1.6.1 */

package com.jgg.sdp.parser.lang;

import java_cup.runtime.Symbol;

import com.jgg.sdp.core.ctes.*;
import com.jgg.sdp.core.exceptions.*;
import com.jgg.sdp.parser.base.*;

import static com.jgg.sdp.parser.lang.COPYSym.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>P:/SDP/Java/MODParserCopy/config/COPYLexer.lex</tt>
 */
public class COPYLexer extends GenericLexer implements GenericScanner, java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int TOKEN = 2;
  public static final int EQUALS = 4;
  public static final int QUOTE_STRING = 6;
  public static final int DQUOTE_STRING = 8;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4, 4
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\26\1\31\1\31\1\31\22\0\1\2\1\0\1\30"+
    "\4\0\1\27\10\0\12\1\3\0\1\25\3\0\1\13\1\21\1\14"+
    "\1\1\1\11\1\24\1\20\1\1\1\16\2\1\1\12\1\1\1\17"+
    "\1\23\1\7\1\1\1\10\1\5\1\1\1\6\3\1\1\22\1\1"+
    "\6\0\1\13\1\21\1\14\1\1\1\11\1\24\1\20\1\1\1\16"+
    "\2\1\1\12\1\1\1\17\1\23\1\7\1\1\1\10\1\5\1\1"+
    "\1\6\3\1\1\22\1\1\12\0\1\31\252\0\2\15\115\0\1\4"+
    "\u1ea8\0\1\31\1\31\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\2\2\6\1\1\2\1\3\1\4\2\5"+
    "\2\6\1\5\2\7\2\0\1\10\1\11\1\12\1\13"+
    "\12\0\1\14\1\0\1\15";

  private static int [] zzUnpackAction() {
    int [] result = new int[43];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\32\0\64\0\116\0\150\0\202\0\234\0\266"+
    "\0\320\0\352\0\u0104\0\u011e\0\u0138\0\u0152\0\202\0\202"+
    "\0\202\0\202\0\u016c\0\u0186\0\202\0\u01a0\0\u01ba\0\u01d4"+
    "\0\u01ee\0\u0208\0\202\0\202\0\202\0\202\0\u0222\0\u023c"+
    "\0\u0256\0\u0270\0\u028a\0\u02a4\0\u02be\0\u02d8\0\u02f2\0\u030c"+
    "\0\202\0\u0326\0\202";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[43];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\2\6\1\7\1\10\2\11\2\6\1\12\4\6\2\13"+
    "\2\6\1\14\1\6\1\15\1\6\1\16\1\17\1\20"+
    "\1\21\1\0\1\22\1\23\1\24\2\22\10\23\1\22"+
    "\7\23\1\22\1\25\2\22\1\0\25\22\1\26\1\0"+
    "\2\22\1\0\27\22\1\27\32\22\1\30\1\22\34\0"+
    "\1\7\32\0\1\10\34\0\1\31\34\0\1\32\37\0"+
    "\1\33\34\0\1\34\33\0\1\35\32\0\1\36\5\0"+
    "\1\23\3\0\10\23\1\0\7\23\7\0\1\24\54\0"+
    "\1\25\33\0\1\22\32\0\1\22\10\0\1\37\31\0"+
    "\1\40\31\0\1\41\34\0\1\42\27\0\1\43\34\0"+
    "\1\44\27\0\1\45\34\0\1\46\21\0\2\47\41\0"+
    "\2\50\17\0\2\51\43\0\1\52\32\0\1\53\11\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[832];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\1\11\10\1\4\11\2\1\1\11\3\1\2\0"+
    "\4\11\12\0\1\11\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[43];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;
  
  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** the stack of open (nested) input streams to read from */
  private java.util.Stack<ZzFlexStreamInfo> zzStreams
    = new java.util.Stack<ZzFlexStreamInfo>();

  /**
   * inner class used to store info for nested
   * input streams
   */
  private static final class ZzFlexStreamInfo {
    java.io.Reader zzReader;
    int zzEndRead;
    int zzStartRead;
    int zzCurrentPos;
    int zzMarkedPos;
    int yyline;
    int yychar;
    int yycolumn;
    char [] zzBuffer;
    boolean zzAtBOL;
    boolean zzAtEOF;
    boolean zzEOFDone;
    int zzFinalHighSurrogate;

    /** sets all values stored in this class */
    ZzFlexStreamInfo(java.io.Reader zzReader, int zzEndRead, int zzStartRead,
                  int zzCurrentPos, int zzMarkedPos, char [] zzBuffer, 
                  boolean zzAtBOL, boolean zzAtEOF, boolean zzEOFDone,
                  int zzFinalHighSurrogate, int yyline, int yychar, int yycolumn) {
      this.zzReader      = zzReader;
      this.zzEndRead     = zzEndRead;
      this.zzStartRead   = zzStartRead;
      this.zzCurrentPos  = zzCurrentPos;
      this.zzMarkedPos   = zzMarkedPos;
      this.zzBuffer      = zzBuffer;
      this.zzAtBOL       = zzAtBOL;
      this.zzAtEOF       = zzAtEOF;
      this.zzEOFDone     = zzEOFDone;
      this.zzFinalHighSurrogate = zzFinalHighSurrogate;
      this.yyline        = yyline;
      this.yychar        = yychar;
      this.yycolumn      = yycolumn;
    }
  }

  /* user code: */

   public Symbol literal(String txt) {
       return null;
   }
   
   public Symbol symbol(int code){
      return symbol(code, yytext());
   }
   
   public Symbol symbol(String txt){
      return symbol(0, txt);
   }

   public Symbol token(int code) {
             print("Devuelve SYMBOL " + code + " (" + (cadLine + 1) + "," + cadCol + ") " + cadena.toString());
       return symbolFactory.newSymbol(cadena.toString(), code, new Symbol(code, cadLine + 1, cadCol, cadena.toString()));
   }   

   public Symbol symbol(int code, String txt) {
      data = true;
      int col = yycolumn + COLOFFSET;
      
      if (txt.indexOf('\t') != -1) checkSymbol(symbol("TAB")); 
      
      if (code != 0) {      
          print("Devuelve SYMBOL " + code + " (" + (yyline + 1) + "," + col + ") " + txt);
      }    
      return symbolFactory.newSymbol(txt, code, new Symbol(code, yyline + 1, col, txt));
   }


  private void excepcion(int code) {
      throw new NotSupportedException(code, info.module.getName(), yyline + info.getOffset() + 1, yycolumn + 1, yytext());
  }
  


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public COPYLexer(java.io.Reader in) {
     initLexer();
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 180) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {      
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Stores the current input stream on a stack, and
   * reads from a new stream. Lexical state, line,
   * char, and column counting remain untouched.
   *
   * The current input stream can be restored with
   * yypopStream (usually in an <<EOF>> action).
   *
   * @param reader the new input stream to read from
   *
   * @see #yypopStream()
   */
  public final void yypushStream(java.io.Reader reader) {
    zzStreams.push(
      new ZzFlexStreamInfo(zzReader, zzEndRead, zzStartRead, zzCurrentPos,
                        zzMarkedPos, zzBuffer, zzAtBOL, zzAtEOF, zzEOFDone,
                        zzFinalHighSurrogate, yyline, yychar, yycolumn)
    );
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzBuffer = new char[ZZ_BUFFERSIZE];
    zzReader = reader;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
  }
    

  /**
   * Closes the current input stream and continues to
   * read from the one on top of the stream stack. 
   *
   * @throws java.util.EmptyStackException
   *         if there is no further stream to read from.
   *
   * @throws java.io.IOException
   *         if there was an error in closing the stream.
   *
   * @see #yypushStream(java.io.Reader)
   */
  public final void yypopStream() throws java.io.IOException {
    zzReader.close();
    ZzFlexStreamInfo s = (ZzFlexStreamInfo) zzStreams.pop();
    zzBuffer      = s.zzBuffer;
    zzReader      = s.zzReader;
    zzEndRead     = s.zzEndRead;
    zzStartRead   = s.zzStartRead;
    zzCurrentPos  = s.zzCurrentPos;
    zzMarkedPos   = s.zzMarkedPos;
    zzAtBOL       = s.zzAtBOL;
    zzAtEOF       = s.zzAtEOF;
    zzEOFDone     = s.zzEOFDone;
    zzFinalHighSurrogate = s.zzFinalHighSurrogate;
    yyline        = s.yyline;
    yychar        = s.yychar;
    yycolumn      = s.yycolumn;
  }


  /**
   * Returns true iff there are still streams left 
   * to read from on the stream stack.
   */
  public final boolean yymoreStreams() {
    return !zzStreams.isEmpty();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   *
   * @see #yypushStream(java.io.Reader)
   * @see #yypopStream()
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) throws ParseException {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new ParseException(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  throws ParseException {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException, ParseException {
    int zzInput;
    int zzAction;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      // cached fields:
      int zzCurrentPosL;
      int zzMarkedPosL = zzMarkedPos;
      int zzEndReadL = zzEndRead;
      char [] zzBufferL = zzBuffer;
      char [] zzCMapL = ZZ_CMAP;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
            switch (zzLexicalState) {
            case TOKEN: {
              popState(); return token(ID);
            }
            case 44: break;
            default:
              {
                return symbol(EOF);
              }
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { cadena.append(yytext()); pushState(TOKEN);
            }
          case 14: break;
          case 2: 
            { /* nothing */
            }
          case 15: break;
          case 3: 
            { resetCadena(yyline, yycolumn); pushState(QUOTE_STRING);
            }
          case 16: break;
          case 4: 
            { resetCadena(yyline, yycolumn); pushState(DQUOTE_STRING);
            }
          case 17: break;
          case 5: 
            { cadena.append(yytext());
            }
          case 18: break;
          case 6: 
            { popState(); return token(ID);
            }
          case 19: break;
          case 7: 
            { popState();  return token(ID);
            }
          case 20: break;
          case 8: 
            { return symbol(IN);
            }
          case 21: break;
          case 9: 
            { /* eat */
            }
          case 22: break;
          case 10: 
            { return symbol(OF);
            }
          case 23: break;
          case 11: 
            { resetCadena(yyline, yycolumn); pushState(EQUALS);
            }
          case 24: break;
          case 12: 
            { return symbol(SUPPRESS);
            }
          case 25: break;
          case 13: 
            { return symbol(REPLACING);
            }
          case 26: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
