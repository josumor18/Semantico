package analizador_Lexico;
import static analizador_Lexico.Token.*;
import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.LinkedList;
import analizador_Sintactico.Simbolos;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;

/*------------  2da Area: Opciones y Declaraciones ---------*/
%%
%{
    //----> Codigo de usuario en sintaxis java
    public static LinkedList<TError> TablaEL = new LinkedList<TError>(); 
%}
//-------> Directivas
%public
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode

%class Lexer

%eofval{
     return new Symbol(Simbolos.EOF, yycolumn, yyline, yytext());
%eofval}

numero=[0-9]+
L=[a-zA-Z_]
D=[0-9]
O=[0-7]
H=[0-9a-fA-F]
S=","|";"|"++"|"--"|"=="|">="|">"|"?"|"<="|"<"|"!="|"||"|"&&"|"!"|"="|"+"|"-"|"%"|"*"|"/"|"("|")"|"["|"]"|"{"|"}"|":"|"."|"+="|"-="|"*="|"/="|"&"|"^"|"|"|">>"|"<<"|"~"|"%="|"&="|"^="|"|="|"<<="|">>="|"->"|"e"|"E"|"p"|"P"
P="auto"|"break"|"case"|"char"|"const"|"continue"|"default"|"do"|"double"|"else"|"enum"|"extern"|"float"|"for"|"goto"|"if"|"include"|"int"|"long"|"register"|"return"|"short"|"signed"|"sizeof"|"static"|"struct"|"switch"|"typedef"|"union"|"unsigned"|"void"|"volatile"|"while"
T=[\u0023-\u0229]
WHITE=[ \t\r\n]
%{
public String lexeme;
public int linea;

%}
%%
"//" [^\r\n]* {/* ignore */}
"/*" [^*] ~"*/"  {/* ignore */}
{WHITE} {/* ignore */}
//-------> Simbolos



//break, case, char, const, continue, default, do, else, for, if, int, long, return, short, switch, void, while
<YYINITIAL> break         {return new Symbol(Simbolos.rbreak, yycolumn, yyline, yytext());}
<YYINITIAL> case         {return new Symbol(Simbolos.rcase, yycolumn, yyline, yytext());}
<YYINITIAL> char          {return new Symbol(Simbolos.rchar, yycolumn, yyline, yytext());}
<YYINITIAL> const          {return new Symbol(Simbolos.rconst, yycolumn, yyline, yytext());}
<YYINITIAL> continue          {return new Symbol(Simbolos.rcontinue, yycolumn, yyline, yytext());}
<YYINITIAL> default          {return new Symbol(Simbolos.rdefault, yycolumn, yyline, yytext());}
<YYINITIAL> do          {return new Symbol(Simbolos.rdo, yycolumn, yyline, yytext());}
<YYINITIAL> else          {return new Symbol(Simbolos.relse, yycolumn, yyline, yytext());}
<YYINITIAL> for          {return new Symbol(Simbolos.rfor, yycolumn, yyline, yytext());}
<YYINITIAL> if          {return new Symbol(Simbolos.rif, yycolumn, yyline, yytext());}
<YYINITIAL> int         {return new Symbol(Simbolos.rint, yycolumn, yyline, yytext());}
<YYINITIAL> long         {return new Symbol(Simbolos.rlong, yycolumn, yyline, yytext());}
<YYINITIAL> return         {return new Symbol(Simbolos.rreturn, yycolumn, yyline, yytext());}
<YYINITIAL> short         {return new Symbol(Simbolos.rshort, yycolumn, yyline, yytext());}
<YYINITIAL> switch         {return new Symbol(Simbolos.rswitch, yycolumn, yyline, yytext());}
<YYINITIAL> void         {return new Symbol(Simbolos.rvoid, yycolumn, yyline, yytext());}
<YYINITIAL> while          {return new Symbol(Simbolos.rwhile, yycolumn, yyline, yytext());}

<YYINITIAL> read         {return new Symbol(Simbolos.rread, yycolumn, yyline, yytext());}
<YYINITIAL> write          {return new Symbol(Simbolos.rwrite, yycolumn, yyline, yytext());}






//-------> Simbolos


<YYINITIAL> "++"         {return new Symbol(Simbolos.masmas, yycolumn, yyline, yytext());}
<YYINITIAL> "--"         {return new Symbol(Simbolos.menosmenos, yycolumn, yyline, yytext());}
<YYINITIAL> "="          {return new Symbol(Simbolos.igual, yycolumn, yyline, yytext());}
<YYINITIAL> "+"          {return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());}
<YYINITIAL> "-"          {return new Symbol(Simbolos.menos, yycolumn, yyline, yytext());}
<YYINITIAL> "*"          {return new Symbol(Simbolos.por, yycolumn, yyline, yytext());}
<YYINITIAL> "/"          {return new Symbol(Simbolos.div, yycolumn, yyline, yytext());}
<YYINITIAL> "%"          {return new Symbol(Simbolos.mod, yycolumn, yyline, yytext());}
<YYINITIAL> "("          {return new Symbol(Simbolos.para, yycolumn, yyline, yytext());}
<YYINITIAL> ")"          {return new Symbol(Simbolos.parc, yycolumn, yyline, yytext());}
<YYINITIAL> "{"          {return new Symbol(Simbolos.corcha, yycolumn, yyline, yytext());}
<YYINITIAL> "}"          {return new Symbol(Simbolos.corchc, yycolumn, yyline, yytext());}
<YYINITIAL> "+="         {return new Symbol(Simbolos.masigual, yycolumn, yyline, yytext());}
<YYINITIAL> "-="         {return new Symbol(Simbolos.menosigual, yycolumn, yyline, yytext());}
<YYINITIAL> "*="         {return new Symbol(Simbolos.porigual, yycolumn, yyline, yytext());}
<YYINITIAL> "/="         {return new Symbol(Simbolos.divigual, yycolumn, yyline, yytext());}
<YYINITIAL> "=="         {return new Symbol(Simbolos.igualigual, yycolumn, yyline, yytext());}
<YYINITIAL> ">="         {return new Symbol(Simbolos.mayque, yycolumn, yyline, yytext());}
<YYINITIAL> ">"          {return new Symbol(Simbolos.may, yycolumn, yyline, yytext());}
<YYINITIAL> "<="         {return new Symbol(Simbolos.menque, yycolumn, yyline, yytext());}
<YYINITIAL> "<"          {return new Symbol(Simbolos.men, yycolumn, yyline, yytext());}
<YYINITIAL> "!="         {return new Symbol(Simbolos.dif, yycolumn, yyline, yytext());}
<YYINITIAL> "||"         {return new Symbol(Simbolos.or, yycolumn, yyline, yytext());}
<YYINITIAL> "&&"         {return new Symbol(Simbolos.and, yycolumn, yyline, yytext());}
<YYINITIAL> "!"          {return new Symbol(Simbolos.not, yycolumn, yyline, yytext());}


<YYINITIAL> ";"          {return new Symbol(Simbolos.puntoycoma, yycolumn, yyline, yytext());}
<YYINITIAL> "."          {return new Symbol(Simbolos.punto, yycolumn, yyline, yytext());}
<YYINITIAL> ":"          {return new Symbol(Simbolos.dospuntos, yycolumn, yyline, yytext());}
<YYINITIAL> ","          {return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());}

{L}({L}|{D})* {lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.Identificador, yycolumn, yyline, yytext());}
{S} {lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.Operador, yycolumn, yyline, yytext());}
{P} {lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.Palabra_reservada, yycolumn, yyline, yytext());}


("\"")({L}|{D}|{S}|{T}|"."|"'"|" "|[\t]|("\\")("\\"|"\""|{L}|{D}|{S}|{T}|"."|"'"|" "|[\t]))*("\"") {lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.txt, yycolumn, yyline, yytext());}
("'")({L}|{D}|{S}|{T}|"."|"'"|" "|[\t]|("\\")("\\"|"\""|{L}|{D}|{S}|{T}|"."|"'"|" "|[\t]))*("'") {lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.txt, yycolumn, yyline, yytext());}

 //------octal--------------------|-------------decimal---
(("0"|("0"{D}*("."{D}*("f"|"F")?)))|([1-9]{D}*("."{D}*("f"|"F")?)?|([1-9]{D})*("."{D}+)))((("e"|"E")("+"|"-")?{D}+("f"|"F")?)?) {lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.num, yycolumn, yyline, yytext());}
"0"{O}+ {lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.num, yycolumn, yyline, yytext());}
"0x"((({H}+("."{H}*)|("."{H}+))(("p"|"P")("+"|"-")?{D}+))|{H}+((("p"|"P")("+"|"-")?{D}+)?)) {lexeme=yytext(); linea=yyline; return new Symbol(Simbolos.num, yycolumn, yyline, yytext());}



("\""|"'")({L}|{D}|{S}|{T}|"'"|" "|[\t]|("\\")("\\"|{L}|{D}|{S}|{T}|"\""|"'"|" "|[\t]))* {lexeme=yytext(); linea=yyline; TError datos = new TError(yytext(),yyline,yycolumn,"Error Lexico","Simbolo no existe en el lenguaje");
                          TablaEL.add(datos);return new Symbol(Simbolos.error, yycolumn, yyline, yytext());}
(({D}+("."{D}*)?)|("."{D}+))(({L})+{D}*)+ {lexeme=yytext(); linea=yyline; TError datos = new TError(yytext(),yyline,yycolumn,"Error Lexico","Simbolo no existe en el lenguaje");
                          TablaEL.add(datos);return new Symbol(Simbolos.error, yycolumn, yyline, yytext());}
"0"{O}+(([8-9]|{L})+{D}*)+ {lexeme=yytext(); linea=yyline; TError datos = new TError(yytext(),yyline,yycolumn,"Error Lexico","Simbolo no existe en el lenguaje");
                          TablaEL.add(datos);return new Symbol(Simbolos.error, yycolumn, yyline, yytext());}
"0x"(({H}+("."{H}*)?)|("."{H}+)|".")((([g-zG-Z_]){H}*)|"."{H}*)* {lexeme=yytext(); linea=yyline; TError datos = new TError(yytext(),yyline,yycolumn,"Error Lexico","Simbolo no existe en el lenguaje");
                          TablaEL.add(datos);return new Symbol(Simbolos.error, yycolumn, yyline, yytext());}
. {lexeme=yytext(); linea=yyline; TError datos = new TError(yytext(),yyline,yycolumn,"Error Lexico","Simbolo no existe en el lenguaje");
                          TablaEL.add(datos); return new Symbol(Simbolos.error, yycolumn, yyline, yytext());}





//-------> Espacios
[\t\r\n\f] {}



