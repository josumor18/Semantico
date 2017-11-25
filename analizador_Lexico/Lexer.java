/* The following code was generated by JFlex 1.6.1 */

package analizador_Lexico;
import static analizador_Lexico.Token.*;
import java_cup.runtime.*;

import java.util.ArrayList;
import java.util.LinkedList;

import analizador_Sintactico.Simbolos;
import analizador_Sintactico.TError;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;

/*------------  2da Area: Opciones y Declaraciones ---------*/

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/analizadores/regexp.flex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0, 51, 52, 57, 58, 52,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    51, 13, 53, 50, 50, 16, 15, 54, 19, 20, 17,  7,  5,  8, 24, 18, 
    56,  3,  3,  3,  3,  3,  3,  3,  1,  1, 23,  6, 12,  9, 10, 11, 
    50, 28, 32, 36, 43, 26,  4, 46, 39, 42,  2, 35, 44,  2, 40, 31, 
    27,  2, 33, 38, 30, 29, 49, 48, 45,  2, 47, 11, 55, 11, 25,  2, 
    50, 28, 32, 36, 43, 26,  4, 46, 39, 42,  2, 35, 44,  2, 40, 31, 
    27,  2, 33, 38, 30, 29, 49, 48, 45,  2, 47, 21, 14, 22, 11, 50, 
    50, 50, 50, 50, 50, 59, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 
    50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 
    50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 
    50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 
    50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 
    50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 
    50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 
    50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\2\12\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\12"+
    "\5\3\1\1\1\3\1\1\5\3\1\26\2\27\1\2"+
    "\1\30\1\27\1\2\1\27\1\3\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\0\1\26\1\2\7\3\4\0\3\3\1\45"+
    "\1\0\1\45\2\3\1\46\4\3\1\47\1\27\1\47"+
    "\1\27\1\0\1\2\1\27\2\2\1\0\1\50\2\0"+
    "\1\3\1\0\1\3\1\0\4\3\1\0\3\3\6\0"+
    "\3\3\1\51\1\0\1\51\2\3\1\0\1\3\1\0"+
    "\1\3\1\0\2\3\1\47\1\27\1\2\1\27\2\2"+
    "\1\0\2\52\2\0\1\3\1\53\1\3\1\0\1\3"+
    "\2\54\1\3\1\0\1\3\1\55\6\0\3\3\1\0"+
    "\1\3\1\56\1\0\1\3\1\0\1\3\2\57\1\3"+
    "\3\27\1\2\1\60\2\61\1\3\2\0\1\3\2\62"+
    "\2\0\1\63\3\0\1\63\1\3\1\0\1\3\2\64"+
    "\2\65\1\3\1\2\1\0\1\66\2\0\1\3\2\67"+
    "\1\0\1\3\1\0\1\2\2\0\1\3\1\70\2\71";

  private static int [] zzUnpackAction() {
    int [] result = new int[220];
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
    "\0\0\0\74\0\170\0\264\0\360\0\74\0\74\0\u012c"+
    "\0\u0168\0\u01a4\0\u01e0\0\74\0\u021c\0\u0258\0\u0294\0\u02d0"+
    "\0\u030c\0\u0348\0\u0384\0\74\0\74\0\74\0\74\0\74"+
    "\0\u03c0\0\u030c\0\u03fc\0\u0438\0\u0474\0\u04b0\0\u04ec\0\u0528"+
    "\0\u0564\0\u05a0\0\u05dc\0\u0618\0\u0654\0\u0690\0\u06cc\0\74"+
    "\0\u0708\0\u0744\0\u0780\0\74\0\u07bc\0\u07f8\0\u0834\0\u0870"+
    "\0\74\0\74\0\74\0\74\0\74\0\74\0\74\0\74"+
    "\0\74\0\74\0\74\0\74\0\u08ac\0\u08e8\0\u0924\0\u0960"+
    "\0\u099c\0\u09d8\0\u0a14\0\u0a50\0\u0a8c\0\u0ac8\0\u0b04\0\u0b40"+
    "\0\u0b7c\0\u0bb8\0\u0bf4\0\u0c30\0\u0c6c\0\74\0\u0ca8\0\264"+
    "\0\u0ce4\0\u0d20\0\264\0\u0d5c\0\u0d98\0\u0dd4\0\u0e10\0\74"+
    "\0\u0e4c\0\u0744\0\u0e88\0\u0ec4\0\u0f00\0\u0f3c\0\u0f78\0\u0fb4"+
    "\0\u0ff0\0\264\0\u102c\0\u1068\0\u10a4\0\u10e0\0\u111c\0\u1158"+
    "\0\u1194\0\u11d0\0\u120c\0\u1248\0\u1284\0\u12c0\0\u12fc\0\u1338"+
    "\0\u1374\0\u13b0\0\u13ec\0\u1428\0\u1464\0\u14a0\0\u14dc\0\u1518"+
    "\0\u1554\0\74\0\u1590\0\264\0\u15cc\0\u1608\0\u1644\0\u1680"+
    "\0\u16bc\0\u16f8\0\u1734\0\u1770\0\u17ac\0\u0708\0\u17e8\0\u1824"+
    "\0\u1860\0\u07bc\0\u189c\0\u18d8\0\74\0\264\0\u1914\0\u1950"+
    "\0\u198c\0\264\0\u19c8\0\u1a04\0\u1a40\0\74\0\264\0\u1a7c"+
    "\0\u1ab8\0\u1af4\0\264\0\u1b30\0\u1b6c\0\u1ba8\0\u1be4\0\u1c20"+
    "\0\u1c5c\0\u1c98\0\u1cd4\0\u1d10\0\u1d4c\0\u1d88\0\264\0\u1dc4"+
    "\0\u1e00\0\u1e3c\0\u1e78\0\74\0\264\0\u1eb4\0\u1ef0\0\u1f2c"+
    "\0\u1f68\0\74\0\74\0\74\0\264\0\u1fa4\0\u1fe0\0\u201c"+
    "\0\u2058\0\74\0\264\0\u2094\0\u20d0\0\74\0\u210c\0\u2148"+
    "\0\u2184\0\264\0\u21c0\0\u21fc\0\u2238\0\74\0\264\0\74"+
    "\0\264\0\u2274\0\u22b0\0\u22ec\0\264\0\u2328\0\u2364\0\u23a0"+
    "\0\74\0\264\0\u23dc\0\u2418\0\u2454\0\u22ec\0\u2490\0\u24cc"+
    "\0\u2508\0\264\0\74\0\264";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[220];
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
    "\1\2\1\3\1\4\1\3\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\2\4\1\34\2\4\1\35\1\36"+
    "\1\2\1\4\1\37\1\40\1\41\2\4\1\42\1\43"+
    "\1\44\1\45\3\4\1\46\1\47\1\2\2\50\1\51"+
    "\1\52\1\2\1\53\1\0\1\54\76\0\1\3\1\55"+
    "\1\3\1\55\23\0\1\56\1\0\1\57\7\55\1\0"+
    "\2\55\1\0\3\55\1\0\10\55\6\0\1\3\4\0"+
    "\4\4\25\0\10\4\1\0\2\4\1\0\3\4\1\0"+
    "\10\4\6\0\1\4\4\0\4\4\25\0\5\4\1\60"+
    "\2\4\1\0\2\4\1\0\3\4\1\0\10\4\6\0"+
    "\1\4\12\0\1\61\1\0\1\62\72\0\1\63\1\64"+
    "\1\14\72\0\1\65\73\0\1\66\1\32\72\0\1\67"+
    "\2\0\1\32\70\0\1\70\73\0\1\14\4\0\1\71"+
    "\66\0\1\14\5\0\1\72\65\0\1\14\73\0\1\73"+
    "\73\0\1\74\7\0\1\75\1\76\52\0\1\77\1\0"+
    "\1\77\64\0\1\77\4\0\4\4\25\0\10\4\1\0"+
    "\2\4\1\0\3\4\1\0\2\4\1\100\5\4\6\0"+
    "\1\4\4\0\4\4\25\0\10\4\1\0\2\4\1\0"+
    "\2\4\1\101\1\0\10\4\6\0\1\4\4\0\4\4"+
    "\25\0\7\4\1\102\1\0\2\4\1\0\3\4\1\0"+
    "\10\4\6\0\1\4\4\0\4\4\25\0\1\103\7\4"+
    "\1\0\2\4\1\0\3\4\1\0\10\4\6\0\1\4"+
    "\4\0\4\4\25\0\2\4\1\104\2\4\1\105\2\4"+
    "\1\0\2\4\1\0\1\4\1\106\1\4\1\0\10\4"+
    "\6\0\1\4\41\0\1\107\10\0\1\110\1\0\2\111"+
    "\5\0\1\112\14\0\4\4\25\0\4\4\1\113\3\4"+
    "\1\0\2\4\1\0\1\4\1\114\1\4\1\111\6\4"+
    "\1\115\1\4\6\0\1\4\7\0\1\116\43\0\1\117"+
    "\24\0\3\4\1\120\25\0\10\4\1\0\2\4\1\0"+
    "\2\4\1\121\1\0\10\4\6\0\1\4\4\0\4\4"+
    "\25\0\1\122\4\4\1\123\2\4\1\0\2\4\1\0"+
    "\3\4\1\0\10\4\6\0\1\4\4\0\4\4\25\0"+
    "\5\4\1\124\2\4\1\0\2\4\1\0\3\4\1\0"+
    "\10\4\6\0\1\4\4\0\4\4\25\0\7\4\1\125"+
    "\1\0\2\4\1\0\1\4\1\126\1\4\1\0\10\4"+
    "\6\0\1\4\4\0\4\4\25\0\5\4\1\127\2\4"+
    "\1\0\2\4\1\0\3\4\1\0\10\4\6\0\1\4"+
    "\4\0\41\51\1\0\21\51\1\0\1\130\1\51\1\131"+
    "\1\51\2\0\1\51\1\0\41\52\1\0\21\52\2\0"+
    "\1\132\1\133\1\52\2\0\1\52\1\0\1\134\1\55"+
    "\1\135\1\55\23\0\1\56\1\0\1\57\7\55\1\0"+
    "\2\55\1\0\3\55\1\0\3\55\1\136\4\55\6\0"+
    "\1\135\4\0\4\55\25\0\10\55\1\0\2\55\1\0"+
    "\3\55\1\0\10\55\6\0\1\55\4\0\1\56\1\55"+
    "\1\56\1\137\25\0\1\57\7\55\1\0\2\55\1\0"+
    "\3\55\1\0\10\55\6\0\1\56\4\0\1\140\1\55"+
    "\1\140\1\55\2\0\2\141\21\0\10\55\1\0\2\55"+
    "\1\0\3\55\1\0\10\55\6\0\1\140\4\0\4\4"+
    "\25\0\7\4\1\142\1\0\2\4\1\0\3\4\1\0"+
    "\10\4\6\0\1\4\3\0\21\143\1\0\52\143\64\76"+
    "\1\0\7\76\1\0\1\77\1\55\1\77\1\55\25\0"+
    "\1\57\7\55\1\0\2\55\1\0\3\55\1\0\10\55"+
    "\6\0\1\77\4\0\4\4\25\0\10\4\1\0\2\4"+
    "\1\144\1\145\2\4\1\0\10\4\6\0\1\4\4\0"+
    "\4\4\25\0\10\4\1\0\2\4\1\146\1\147\2\4"+
    "\1\150\10\4\6\0\1\4\4\0\4\4\25\0\1\151"+
    "\7\4\1\0\2\4\1\0\3\4\1\0\10\4\6\0"+
    "\1\4\4\0\4\4\25\0\2\4\1\152\1\4\1\153"+
    "\3\4\1\0\2\4\1\0\3\4\1\0\4\4\1\154"+
    "\3\4\6\0\1\4\4\0\4\4\25\0\10\4\1\0"+
    "\2\4\1\155\1\156\2\4\1\0\10\4\6\0\1\4"+
    "\4\0\4\4\25\0\10\4\1\0\2\4\1\0\2\4"+
    "\1\157\1\0\10\4\6\0\1\4\4\0\4\4\25\0"+
    "\2\4\1\160\5\4\1\0\2\4\1\0\3\4\1\0"+
    "\10\4\6\0\1\4\37\0\1\161\4\0\1\162\71\0"+
    "\1\163\112\0\1\164\1\165\65\0\2\166\22\0\4\4"+
    "\25\0\2\4\1\167\5\4\1\0\2\4\1\0\3\4"+
    "\1\0\10\4\6\0\1\4\4\0\4\4\25\0\5\4"+
    "\1\170\2\4\1\0\2\4\1\0\3\4\1\0\10\4"+
    "\6\0\1\4\4\0\4\4\25\0\10\4\1\0\2\4"+
    "\1\0\3\4\1\166\1\171\7\4\6\0\1\4\41\0"+
    "\1\172\5\0\1\173\30\0\4\4\25\0\4\4\1\174"+
    "\3\4\1\0\2\4\1\0\3\4\1\0\10\4\6\0"+
    "\1\4\4\0\3\4\1\175\25\0\10\4\1\0\2\4"+
    "\1\0\3\4\1\0\10\4\6\0\1\4\4\0\4\4"+
    "\25\0\10\4\1\0\2\4\1\0\2\4\1\176\1\0"+
    "\10\4\6\0\1\4\4\0\4\4\25\0\10\4\1\0"+
    "\2\4\1\0\3\4\1\177\1\200\7\4\6\0\1\4"+
    "\4\0\4\4\25\0\10\4\1\0\2\4\1\0\3\4"+
    "\1\201\1\202\7\4\6\0\1\4\4\0\4\4\25\0"+
    "\10\4\1\0\2\4\1\0\3\4\1\203\1\204\1\4"+
    "\1\205\5\4\6\0\1\4\4\0\41\51\1\0\21\51"+
    "\1\0\1\206\1\51\1\131\1\51\2\0\1\51\1\0"+
    "\41\52\1\0\21\52\1\0\1\52\1\132\1\133\1\52"+
    "\2\0\1\52\1\0\1\134\1\55\1\134\1\55\23\0"+
    "\1\56\1\0\10\55\1\0\2\55\1\0\3\55\1\0"+
    "\10\55\6\0\1\134\4\0\1\207\1\55\1\135\1\55"+
    "\23\0\1\56\1\0\10\55\1\0\2\55\1\0\3\55"+
    "\1\0\10\55\6\0\1\135\4\0\1\210\1\55\2\210"+
    "\23\0\1\211\1\0\1\210\1\55\1\210\3\55\1\210"+
    "\1\55\1\0\1\55\1\210\1\0\3\55\1\0\1\55"+
    "\1\210\6\55\6\0\1\210\4\0\4\55\25\0\1\57"+
    "\7\55\1\0\2\55\1\0\3\55\1\0\10\55\6\0"+
    "\1\55\4\0\1\140\1\55\1\140\1\212\25\0\10\55"+
    "\1\0\2\55\1\0\3\55\1\0\10\55\6\0\1\140"+
    "\4\0\1\213\1\0\1\213\64\0\1\213\3\0\21\143"+
    "\1\214\52\143\32\0\1\215\42\0\4\4\25\0\1\216"+
    "\7\4\1\0\2\4\1\0\3\4\1\0\10\4\6\0"+
    "\1\4\54\0\2\217\22\0\4\4\25\0\10\4\1\0"+
    "\2\4\1\0\3\4\1\217\10\4\6\0\1\4\42\0"+
    "\1\220\35\0\4\4\25\0\2\4\1\221\5\4\1\0"+
    "\2\4\1\0\3\4\1\0\10\4\6\0\1\4\4\0"+
    "\4\4\25\0\10\4\1\0\2\4\1\0\3\4\1\0"+
    "\1\4\1\222\6\4\6\0\1\4\4\0\4\4\25\0"+
    "\3\4\1\223\4\4\1\0\2\4\1\0\3\4\1\0"+
    "\10\4\6\0\1\4\4\0\4\4\25\0\10\4\1\0"+
    "\2\4\1\0\3\4\1\224\1\225\7\4\6\0\1\4"+
    "\35\0\1\226\42\0\4\4\25\0\1\227\7\4\1\0"+
    "\2\4\1\0\3\4\1\0\10\4\6\0\1\4\4\0"+
    "\4\4\25\0\4\4\1\230\3\4\1\0\2\4\1\231"+
    "\1\232\2\4\1\0\10\4\6\0\1\4\4\0\4\4"+
    "\25\0\7\4\1\233\1\0\2\4\1\0\3\4\1\0"+
    "\10\4\6\0\1\4\41\0\1\234\72\0\1\235\77\0"+
    "\1\236\102\0\1\237\55\0\1\240\77\0\1\241\36\0"+
    "\4\4\25\0\4\4\1\242\3\4\1\0\2\4\1\0"+
    "\3\4\1\0\10\4\6\0\1\4\4\0\4\4\25\0"+
    "\7\4\1\243\1\0\2\4\1\0\3\4\1\0\10\4"+
    "\6\0\1\4\4\0\4\4\25\0\4\4\1\244\3\4"+
    "\1\0\2\4\1\0\3\4\1\0\10\4\6\0\1\4"+
    "\57\0\1\245\20\0\4\4\25\0\2\4\1\246\5\4"+
    "\1\0\2\4\1\0\3\4\1\0\10\4\6\0\1\4"+
    "\4\0\4\4\25\0\10\4\1\0\2\4\1\0\3\4"+
    "\1\0\4\4\1\247\3\4\6\0\1\4\41\0\1\250"+
    "\36\0\4\4\25\0\4\4\1\251\3\4\1\0\2\4"+
    "\1\0\3\4\1\0\10\4\6\0\1\4\57\0\1\252"+
    "\20\0\4\4\25\0\10\4\1\0\2\4\1\0\3\4"+
    "\1\0\2\4\1\253\5\4\6\0\1\4\56\0\1\254"+
    "\21\0\4\4\25\0\10\4\1\0\2\4\1\0\3\4"+
    "\1\0\1\4\1\255\6\4\6\0\1\4\4\0\4\4"+
    "\25\0\2\4\1\256\5\4\1\0\2\4\1\0\3\4"+
    "\1\0\10\4\6\0\1\4\4\0\1\207\1\55\1\207"+
    "\1\55\23\0\1\56\1\0\10\55\1\0\2\55\1\0"+
    "\3\55\1\0\10\55\6\0\1\207\4\0\1\210\1\257"+
    "\2\210\23\0\1\260\1\0\1\210\1\261\1\210\3\257"+
    "\1\210\1\257\1\0\1\257\1\210\1\0\3\257\1\0"+
    "\1\257\1\210\6\257\6\0\1\210\4\0\1\260\1\257"+
    "\2\260\23\0\1\257\1\0\1\260\1\257\1\260\3\257"+
    "\1\260\1\257\1\0\1\257\1\260\1\0\3\257\1\0"+
    "\1\257\1\260\6\257\6\0\1\260\4\0\1\213\1\0"+
    "\1\213\1\262\63\0\1\213\3\0\21\143\1\214\1\50"+
    "\51\143\56\0\1\164\65\0\1\263\24\0\4\4\25\0"+
    "\10\4\1\264\1\265\1\4\1\0\3\4\1\0\10\4"+
    "\6\0\1\4\4\0\4\4\25\0\7\4\1\266\1\0"+
    "\2\4\1\0\3\4\1\0\10\4\6\0\1\4\50\0"+
    "\2\267\26\0\4\4\25\0\10\4\1\0\2\4\1\267"+
    "\3\4\1\0\10\4\6\0\1\4\4\0\4\4\25\0"+
    "\10\4\1\0\2\4\1\0\3\4\1\270\1\271\7\4"+
    "\6\0\1\4\41\0\1\272\36\0\4\4\25\0\4\4"+
    "\1\273\3\4\1\0\2\4\1\0\3\4\1\0\10\4"+
    "\6\0\1\4\54\0\2\274\65\0\1\275\65\0\1\276"+
    "\67\0\1\277\100\0\1\300\100\0\1\301\30\0\4\4"+
    "\25\0\10\4\1\0\2\4\1\0\3\4\1\274\10\4"+
    "\6\0\1\4\4\0\4\4\25\0\4\4\1\302\3\4"+
    "\1\0\2\4\1\0\3\4\1\0\10\4\6\0\1\4"+
    "\4\0\4\4\25\0\10\4\1\0\1\4\1\303\1\0"+
    "\3\4\1\0\10\4\6\0\1\4\40\0\1\304\37\0"+
    "\4\4\25\0\3\4\1\305\4\4\1\0\2\4\1\0"+
    "\3\4\1\0\10\4\6\0\1\4\35\0\1\306\42\0"+
    "\4\4\25\0\1\307\7\4\1\0\2\4\1\0\3\4"+
    "\1\0\10\4\6\0\1\4\35\0\1\310\42\0\4\4"+
    "\25\0\1\311\7\4\1\0\2\4\1\0\3\4\1\0"+
    "\10\4\6\0\1\4\4\0\4\4\25\0\4\4\1\312"+
    "\3\4\1\0\2\4\1\0\3\4\1\0\10\4\6\0"+
    "\1\4\4\0\4\257\23\0\1\257\1\0\10\257\1\0"+
    "\2\257\1\0\3\257\1\0\10\257\6\0\1\257\4\0"+
    "\1\260\1\257\2\260\23\0\1\257\1\0\1\260\1\261"+
    "\1\260\3\257\1\260\1\257\1\0\1\257\1\260\1\0"+
    "\3\257\1\0\1\257\1\260\6\257\6\0\1\260\4\0"+
    "\1\313\1\257\1\313\1\257\2\0\2\314\17\0\1\257"+
    "\1\0\10\257\1\0\2\257\1\0\3\257\1\0\10\257"+
    "\6\0\1\313\4\0\4\4\25\0\10\4\1\0\2\4"+
    "\1\0\2\4\1\315\1\0\10\4\6\0\1\4\41\0"+
    "\1\316\105\0\1\317\24\0\4\4\25\0\10\4\1\0"+
    "\2\4\1\0\2\4\1\320\1\0\10\4\6\0\1\4"+
    "\47\0\1\263\65\0\1\263\110\0\1\263\24\0\1\263"+
    "\136\0\1\321\25\0\4\4\25\0\10\4\1\0\2\4"+
    "\1\0\1\4\1\322\1\4\1\0\10\4\6\0\1\4"+
    "\56\0\1\323\21\0\4\4\25\0\10\4\1\0\2\4"+
    "\1\0\3\4\1\0\2\4\1\324\5\4\6\0\1\4"+
    "\4\0\4\4\25\0\10\4\1\0\2\4\1\0\3\4"+
    "\1\325\10\4\6\0\1\4\4\0\1\313\1\257\1\313"+
    "\1\257\23\0\1\257\1\0\10\257\1\0\2\257\1\0"+
    "\3\257\1\0\10\257\6\0\1\313\4\0\1\326\1\0"+
    "\1\326\64\0\1\326\35\0\1\327\76\0\1\330\37\0"+
    "\4\4\25\0\3\4\1\331\4\4\1\0\2\4\1\0"+
    "\3\4\1\0\10\4\6\0\1\4\35\0\1\263\42\0"+
    "\4\4\25\0\4\4\1\332\3\4\1\0\2\4\1\0"+
    "\3\4\1\0\10\4\6\0\1\4\57\0\1\323\60\0"+
    "\1\263\64\0\1\333\42\0\4\4\25\0\1\334\7\4"+
    "\1\0\2\4\1\0\3\4\1\0\10\4\6\0\1\4"+
    "\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[9540];
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
    "\1\0\1\11\3\1\2\11\4\1\1\11\7\1\5\11"+
    "\17\1\1\11\3\1\1\11\4\1\14\11\1\0\11\1"+
    "\4\0\3\1\1\11\1\0\10\1\1\11\3\1\1\0"+
    "\4\1\1\0\1\1\2\0\1\1\1\0\1\1\1\0"+
    "\4\1\1\0\3\1\6\0\3\1\1\11\1\0\3\1"+
    "\1\0\1\1\1\0\1\1\1\0\10\1\1\0\1\11"+
    "\1\1\2\0\3\1\1\0\1\1\1\11\2\1\1\0"+
    "\2\1\6\0\3\1\1\0\2\1\1\0\1\1\1\0"+
    "\1\1\1\11\5\1\3\11\2\1\2\0\1\1\1\11"+
    "\1\1\2\0\1\11\3\0\2\1\1\0\1\1\1\11"+
    "\1\1\1\11\3\1\1\0\1\1\2\0\1\1\1\11"+
    "\1\1\1\0\1\1\1\0\1\1\2\0\2\1\1\11"+
    "\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[220];
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

  /* user code: */
    //----> Codigo de usuario en sintaxis java
    public static LinkedList<TError> TablaEL = new LinkedList<TError>(); 
public String lexeme;
public int linea;



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
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
      char newBuffer[] = new char[zzBuffer.length*2];
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
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
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
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

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
          {      return new Symbol(Simbolos.EOF, yycolumn, yyline, yytext());
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { lexeme=yytext(); linea=yyline; TError datos = new TError(yytext(),yyline,yycolumn,"Error Lexico","Simbolo no existe en el lenguaje");
                          TablaEL.add(datos); return new Symbol(Simbolos.error, yycolumn, yyline, yytext());
            }
          case 58: break;
          case 2: 
            { lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.num, yycolumn, yyline, yytext());
            }
          case 59: break;
          case 3: 
            { lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.Identificador, yycolumn, yyline, yytext());
            }
          case 60: break;
          case 4: 
            { return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());
            }
          case 61: break;
          case 5: 
            { return new Symbol(Simbolos.puntoycoma, yycolumn, yyline, yytext());
            }
          case 62: break;
          case 6: 
            { return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());
            }
          case 63: break;
          case 7: 
            { return new Symbol(Simbolos.menos, yycolumn, yyline, yytext());
            }
          case 64: break;
          case 8: 
            { return new Symbol(Simbolos.igual, yycolumn, yyline, yytext());
            }
          case 65: break;
          case 9: 
            { return new Symbol(Simbolos.may, yycolumn, yyline, yytext());
            }
          case 66: break;
          case 10: 
            { lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.Operador, yycolumn, yyline, yytext());
            }
          case 67: break;
          case 11: 
            { return new Symbol(Simbolos.men, yycolumn, yyline, yytext());
            }
          case 68: break;
          case 12: 
            { return new Symbol(Simbolos.not, yycolumn, yyline, yytext());
            }
          case 69: break;
          case 13: 
            { return new Symbol(Simbolos.mod, yycolumn, yyline, yytext());
            }
          case 70: break;
          case 14: 
            { return new Symbol(Simbolos.por, yycolumn, yyline, yytext());
            }
          case 71: break;
          case 15: 
            { return new Symbol(Simbolos.div, yycolumn, yyline, yytext());
            }
          case 72: break;
          case 16: 
            { return new Symbol(Simbolos.para, yycolumn, yyline, yytext());
            }
          case 73: break;
          case 17: 
            { return new Symbol(Simbolos.parc, yycolumn, yyline, yytext());
            }
          case 74: break;
          case 18: 
            { return new Symbol(Simbolos.corcha, yycolumn, yyline, yytext());
            }
          case 75: break;
          case 19: 
            { return new Symbol(Simbolos.corchc, yycolumn, yyline, yytext());
            }
          case 76: break;
          case 20: 
            { return new Symbol(Simbolos.dospuntos, yycolumn, yyline, yytext());
            }
          case 77: break;
          case 21: 
            { return new Symbol(Simbolos.punto, yycolumn, yyline, yytext());
            }
          case 78: break;
          case 22: 
            { /* ignore */
            }
          case 79: break;
          case 23: 
            { lexeme=yytext(); linea=yyline; TError datos = new TError(yytext(),yyline,yycolumn,"Error Lexico","Simbolo no existe en el lenguaje");
                          TablaEL.add(datos);return new Symbol(Simbolos.error, yycolumn, yyline, yytext());
            }
          case 80: break;
          case 24: 
            { 
            }
          case 81: break;
          case 25: 
            { return new Symbol(Simbolos.masmas, yycolumn, yyline, yytext());
            }
          case 82: break;
          case 26: 
            { return new Symbol(Simbolos.masigual, yycolumn, yyline, yytext());
            }
          case 83: break;
          case 27: 
            { return new Symbol(Simbolos.menosmenos, yycolumn, yyline, yytext());
            }
          case 84: break;
          case 28: 
            { return new Symbol(Simbolos.menosigual, yycolumn, yyline, yytext());
            }
          case 85: break;
          case 29: 
            { return new Symbol(Simbolos.igualigual, yycolumn, yyline, yytext());
            }
          case 86: break;
          case 30: 
            { return new Symbol(Simbolos.mayque, yycolumn, yyline, yytext());
            }
          case 87: break;
          case 31: 
            { return new Symbol(Simbolos.menque, yycolumn, yyline, yytext());
            }
          case 88: break;
          case 32: 
            { return new Symbol(Simbolos.dif, yycolumn, yyline, yytext());
            }
          case 89: break;
          case 33: 
            { return new Symbol(Simbolos.or, yycolumn, yyline, yytext());
            }
          case 90: break;
          case 34: 
            { return new Symbol(Simbolos.and, yycolumn, yyline, yytext());
            }
          case 91: break;
          case 35: 
            { return new Symbol(Simbolos.porigual, yycolumn, yyline, yytext());
            }
          case 92: break;
          case 36: 
            { return new Symbol(Simbolos.divigual, yycolumn, yyline, yytext());
            }
          case 93: break;
          case 37: 
            { return new Symbol(Simbolos.rif, yycolumn, yyline, yytext());
            }
          case 94: break;
          case 38: 
            { return new Symbol(Simbolos.rdo, yycolumn, yyline, yytext());
            }
          case 95: break;
          case 39: 
            { lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.txt, yycolumn, yyline, yytext());
            }
          case 96: break;
          case 40: 
            { return new Symbol(Simbolos.rfor, yycolumn, yyline, yytext());
            }
          case 97: break;
          case 41: 
            { return new Symbol(Simbolos.rint, yycolumn, yyline, yytext());
            }
          case 98: break;
          case 42: 
            { return new Symbol(Simbolos.relse, yycolumn, yyline, yytext());
            }
          case 99: break;
          case 43: 
            { return new Symbol(Simbolos.rread, yycolumn, yyline, yytext());
            }
          case 100: break;
          case 44: 
            { return new Symbol(Simbolos.rcase, yycolumn, yyline, yytext());
            }
          case 101: break;
          case 45: 
            { return new Symbol(Simbolos.rchar, yycolumn, yyline, yytext());
            }
          case 102: break;
          case 46: 
            { return new Symbol(Simbolos.rlong, yycolumn, yyline, yytext());
            }
          case 103: break;
          case 47: 
            { return new Symbol(Simbolos.rvoid, yycolumn, yyline, yytext());
            }
          case 104: break;
          case 48: 
            { lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.Palabra_reservada, yycolumn, yyline, yytext());
            }
          case 105: break;
          case 49: 
            { return new Symbol(Simbolos.rbreak, yycolumn, yyline, yytext());
            }
          case 106: break;
          case 50: 
            { return new Symbol(Simbolos.rconst, yycolumn, yyline, yytext());
            }
          case 107: break;
          case 51: 
            { return new Symbol(Simbolos.rshort, yycolumn, yyline, yytext());
            }
          case 108: break;
          case 52: 
            { return new Symbol(Simbolos.rwrite, yycolumn, yyline, yytext());
            }
          case 109: break;
          case 53: 
            { return new Symbol(Simbolos.rwhile, yycolumn, yyline, yytext());
            }
          case 110: break;
          case 54: 
            { return new Symbol(Simbolos.rreturn, yycolumn, yyline, yytext());
            }
          case 111: break;
          case 55: 
            { return new Symbol(Simbolos.rswitch, yycolumn, yyline, yytext());
            }
          case 112: break;
          case 56: 
            { return new Symbol(Simbolos.rdefault, yycolumn, yyline, yytext());
            }
          case 113: break;
          case 57: 
            { return new Symbol(Simbolos.rcontinue, yycolumn, yyline, yytext());
            }
          case 114: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
