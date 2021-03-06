
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sun Aug 14 10:58:22 CDT 2016
//----------------------------------------------------

package com.jgg.sdp.parser.lang;

/** CUP generated interface containing symbol constants. */
public interface ZCSym {
  /* terminals */
  public static final int DEPENDING = 65;
  public static final int DISPLAY = 99;
  public static final int IO_SECTION = 20;
  public static final int STOPRUN = 125;
  public static final int SIZE_ERROR = 202;
  public static final int POSITIVE = 83;
  public static final int BLOCK = 33;
  public static final int EXIT = 104;
  public static final int MULT = 201;
  public static final int BLOB = 55;
  public static final int KANJI = 82;
  public static final int UNTIL = 187;
  public static final int LINKAGE_SECTION = 17;
  public static final int ORGANIZATION = 43;
  public static final int RENAMES = 60;
  public static final int REWRITE = 120;
  public static final int INITIALIZE = 109;
  public static final int ORDER = 66;
  public static final int CALL = 92;
  public static final int VALUE = 63;
  public static final int ENDVERB = 153;
  public static final int EXITPGM = 102;
  public static final int WRITE = 131;
  public static final int ENDEVAL = 149;
  public static final int CONVERTING = 142;
  public static final int INTO = 163;
  public static final int SD = 50;
  public static final int END_EXEC = 206;
  public static final int INSTALLATION = 28;
  public static final int TIMES = 186;
  public static final int TEST = 184;
  public static final int RECORD = 47;
  public static final int FD = 36;
  public static final int EXCEPTION = 155;
  public static final int GOTO = 107;
  public static final int LITERAL = 11;
  public static final int DIV_ID = 3;
  public static final int LITCONCAT = 12;
  public static final int SPECIAL_NAMES = 21;
  public static final int ALPHANUMERIC = 87;
  public static final int PIC_LEN = 73;
  public static final int DYNAMIC = 35;
  public static final int PICTURE = 62;
  public static final int READ = 117;
  public static final int PROGRAM = 177;
  public static final int DIV_PROC = 6;
  public static final int ADD = 90;
  public static final int EXEC_SQL = 205;
  public static final int REFERENCE = 178;
  public static final int RELATIVE = 48;
  public static final int LPARID = 192;
  public static final int DUPLICATES = 88;
  public static final int COMPUTE = 96;
  public static final int ATEND = 137;
  public static final int REDEFINES = 59;
  public static final int LPAR = 191;
  public static final int EOP = 154;
  public static final int ASSIGN = 32;
  public static final int LABEL = 39;
  public static final int CONF_SECTION = 19;
  public static final int AFTER = 132;
  public static final int NULL = 85;
  public static final int POINTER = 67;
  public static final int EOF = 0;
  public static final int PIC_DEC = 70;
  public static final int END_PGM = 13;
  public static final int RECORDING = 45;
  public static final int REMARKS = 29;
  public static final int PAGE = 175;
  public static final int VARYING = 189;
  public static final int MOVE = 112;
  public static final int DATEW = 26;
  public static final int COMPN = 57;
  public static final int USING = 188;
  public static final int SIZE = 182;
  public static final int EQUAL = 196;
  public static final int ELSE = 148;
  public static final int OVERFLOW = 174;
  public static final int ACCESS = 30;
  public static final int QUOTE = 80;
  public static final int DATEC = 27;
  public static final int OR = 172;
  public static final int FIRST = 157;
  public static final int COMMIT = 95;
  public static final int LESS = 197;
  public static final int WHEN = 190;
  public static final int TRANSFORM = 128;
  public static final int AND = 135;
  public static final int BINARY = 54;
  public static final int SUBTRACT = 127;
  public static final int COUNT = 143;
  public static final int OF = 171;
  public static final int BY = 139;
  public static final int NEXT = 114;
  public static final int EXITP = 103;
  public static final int BLOB_LOCATOR = 56;
  public static final int PIC_ALPHA = 69;
  public static final int SECTION = 181;
  public static final int CLOSE = 94;
  public static final int POWER = 200;
  public static final int ALSO = 134;
  public static final int RANDOM = 44;
  public static final int NO = 170;
  public static final int DELETE = 98;
  public static final int FILLER = 58;
  public static final int INPUT = 162;
  public static final int ASCENDING = 136;
  public static final int PIC_ALPHANUM = 68;
  public static final int EVALUATE = 101;
  public static final int FILE_SECTION = 14;
  public static final int INVALID = 164;
  public static final int PARAGRAPH = 176;
  public static final int WORKING_SECTION = 15;
  public static final int RELEASE = 118;
  public static final int SEQUENTIAL = 51;
  public static final int UNLOCK = 129;
  public static final int ENDP = 152;
  public static final int ZERO = 77;
  public static final int DELIMITER = 146;
  public static final int PGMID = 24;
  public static final int PLUS = 199;
  public static final int CLASS = 141;
  public static final int NUMERIC = 81;
  public static final int TALLYING = 183;
  public static final int ALL = 133;
  public static final int HIGHVAL = 78;
  public static final int RPAR = 193;
  public static final int MERGE = 111;
  public static final int DELIMITED = 145;
  public static final int DESCENDING = 147;
  public static final int ALLOCATE = 91;
  public static final int PIC_FMT = 72;
  public static final int COPY = 2;
  public static final int OPEN = 115;
  public static final int EXTEND = 156;
  public static final int ACCEPT = 89;
  public static final int INSPECT = 110;
  public static final int SELECT = 52;
  public static final int UNSTRING = 130;
  public static final int ROWID = 74;
  public static final int ROLLBACK = 49;
  public static final int EXEC_CICS = 204;
  public static final int LOCK = 42;
  public static final int SDPMASTER = 208;
  public static final int RETURNING = 180;
  public static final int SEARCH = 121;
  public static final int INDEXED = 37;
  public static final int FREE = 105;
  public static final int ALTERNATE = 31;
  public static final int GOBACK = 106;
  public static final int ENDPERFORM = 151;
  public static final int DATA = 34;
  public static final int PARRAFO = 10;
  public static final int THRU = 185;
  public static final int WITH = 195;
  public static final int HEX_VAL = 9;
  public static final int ENDIF = 150;
  public static final int RECORDS = 46;
  public static final int BEFORE = 138;
  public static final int OUTPUT = 173;
  public static final int GIVING = 161;
  public static final int RETURN = 119;
  public static final int CHARACTER = 140;
  public static final int FOR = 159;
  public static final int REPLACING = 179;
  public static final int FUNCTION = 203;
  public static final int DEC_POINT = 144;
  public static final int AUTHOR = 25;
  public static final int DIVIDE = 100;
  public static final int STRING = 126;
  public static final int FILE_CONTROL = 18;
  public static final int SDPDESC = 207;
  public static final int LINE = 41;
  public static final int LEADING = 168;
  public static final int CONTINUE = 97;
  public static final int NEGATIVE = 84;
  public static final int NUMERO = 8;
  public static final int FROM = 160;
  public static final int OP_REL = 198;
  public static final int OCCURS = 64;
  public static final int SOURCE_COMPUTER = 22;
  public static final int PACKED = 61;
  public static final int OBJECT_COMPUTER = 23;
  public static final int START = 124;
  public static final int LINAGE = 40;
  public static final int LENGTH = 169;
  public static final int DIV_DATA = 5;
  public static final int MULTIPLY = 113;
  public static final int INDEX = 38;
  public static final int IO = 166;
  public static final int PIC_NUM = 71;
  public static final int IN = 165;
  public static final int LOWVAL = 79;
  public static final int DFHCICS = 209;
  public static final int error = 1;
  public static final int STATUS = 53;
  public static final int SORT = 123;
  public static final int IF = 108;
  public static final int ID = 7;
  public static final int DIV_ENV = 4;
  public static final int ALPHABETIC = 86;
  public static final int SET = 122;
  public static final int PERFORM = 116;
  public static final int LOCAL_SECTION = 16;
  public static final int SPACES = 75;
  public static final int TO = 194;
  public static final int FOREVER = 158;
  public static final int KEY = 167;
  public static final int CANCEL = 93;
  public static final int USAGE = 76;
}

