import java.lang.String;
import java.util.ArrayList;
%%

%class LexicalAnalyser
%implements SyntaxAnalyser.Lexer
%standalone
%line
%column
%state unaryOperation, binaryOperation

%{
    private Object yylval;

    public Object getLVal() {
        return yylval;
    }

    public void yyerror(String message) {
        System.err.println();
        System.err.println("Error:\nSyntax error in line " + (yyline + 1) + "\nUnexpected token: " + yytext());
    }

    private boolean checkForKeyWords(String lexem, int line, int symbol) {
        String[] words = {"Var", "Begin", "End", "Do", "IF", "ELSE"};

        for (int i = 0; i < words.length; i++) {
            if (words[i].toLowerCase().equals(lexem.toLowerCase())) {
                System.err.printf("Could not recognize lexeme: '%s'. Did you mean '%s'?\nLine - %d, start symbol - %d\n", lexem, words[i], line, symbol);
                return true;
            }
        }

        return false;
    }
%}

Keyword = "Begin" | "End" | "Var" | "ELSE"
IfKeyword = "IF"
OpeningBracket = "("
ClosingBracket = ")"
AssignmentOperator = ":="
BinaryOperator = "+" | "*" | "/" | ">>" | "<<" | ">" | "<" | "="
MinusOperator = "-"
CommaSeparator = ","
Constant = [0-9]+
Identifier = [a-zA-Z]+
Whitespace = [ \t\n\r]
Comment = (\/\*)[\S\s]*(\*\/)

%%

{Comment} {
    yylval = new String(yytext());
}

{Keyword} {
    yylval = new String(yytext());
    switch (yytext()) {
        case "Begin" : return SyntaxAnalyser.Lexer.BEGIN_KEYWORD;
        case "End" : return SyntaxAnalyser.Lexer.END_KEYWORD;
        case "Var" : return SyntaxAnalyser.Lexer.VAR_KEYWORD;
        case "ELSE" : return SyntaxAnalyser.Lexer.ELSE_KEYWORD;
    }
}

{IfKeyword} {
    yylval = new String(yytext());
    yybegin(unaryOperation);
    return SyntaxAnalyser.Lexer.IF_KEYWORD;
}

{OpeningBracket} {
    yylval = new String(yytext());
    yybegin(unaryOperation);
    return SyntaxAnalyser.Lexer.OPENING_BRACKET;
}

{AssignmentOperator} {
    yylval = new String(yytext());
    yybegin(unaryOperation);
    return SyntaxAnalyser.Lexer.ASSIGNMENT_OPERATOR;
}

{BinaryOperator} {
    yylval = new String(yytext());
    yybegin(unaryOperation);

    switch (yytext()) {
        case "+" : return SyntaxAnalyser.Lexer.PLUS_OPERATOR;
        case "*" : return SyntaxAnalyser.Lexer.MULTIPLY_OPERATOR;
        case "/" : return SyntaxAnalyser.Lexer.DIVIDE_OPERATOR;
        case ">>" : return SyntaxAnalyser.Lexer.SHIFT_RIGHT_OPERATOR;
        case "<<" : return SyntaxAnalyser.Lexer.SHIFT_LEFT_OPERATOR;
        case ">" : return SyntaxAnalyser.Lexer.GREATER_OPERATOR;
        case "<" : return SyntaxAnalyser.Lexer.LESS_OPERATOR;
        case "=" : return SyntaxAnalyser.Lexer.EQUALS_OPERATOR;
    }
}

{CommaSeparator} {
    yylval = new String(yytext());
    return SyntaxAnalyser.Lexer.COMMA_SEPARATOR;
}

{ClosingBracket} {
    yylval = new String(yytext());
    return SyntaxAnalyser.Lexer.CLOSING_BRACKET;
}


<unaryOperation> {
    {MinusOperator} {
        yylval = new String(yytext());
        yybegin(unaryOperation);
        return SyntaxAnalyser.Lexer.UNARY_MINUS_OPERATOR;
      }

    {OpeningBracket} {
        yylval = new String(yytext());
        yybegin(unaryOperation);
        return SyntaxAnalyser.Lexer.OPENING_BRACKET;
    }

    {Constant} 	{
        yylval = new Integer(yytext());
        yybegin(binaryOperation);
        return SyntaxAnalyser.Lexer.CONSTANT;
    }

    {Identifier} {
        checkForKeyWords(yytext(), yyline+1, yycolumn);
        yylval = new String(yytext());
        yybegin(binaryOperation);
        return SyntaxAnalyser.Lexer.IDENTIFIER;
    }
}

{Constant}  {
    yylval = new Integer(yytext());
    yybegin(binaryOperation);
    return SyntaxAnalyser.Lexer.CONSTANT;
}

{Identifier} {
    checkForKeyWords(yytext(), yyline+1, yycolumn);
    yylval = new String(yytext());
    yybegin(binaryOperation);
    return SyntaxAnalyser.Lexer.IDENTIFIER;
}

<binaryOperation> {
    {MinusOperator} {
        yylval = new String(yytext());
        return SyntaxAnalyser.Lexer.BINARY_MINUS_OPERATOR;
    }
}

{Whitespace} {}

. {
    System.out.println();
    System.out.printf("Error. Unexpected token : %s\nLine: %d\nStart symbol: %d\n", yytext(), yyline+1, yycolumn);
    System.exit(0);
}