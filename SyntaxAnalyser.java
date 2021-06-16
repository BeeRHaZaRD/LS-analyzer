/* A Bison parser, made by GNU Bison 3.5.1.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2020 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */





/**
 * A Bison parser, automatically generated from <tt>SyntaxAnalyser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class SyntaxAnalyser
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.5.1";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";







  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>SyntaxAnalyser</tt>.
   */
  public interface Lexer {
    /** Token returned by the scanner to signal the end of its input.  */
    public static final int EOF = 0;

/* Tokens.  */
    /** Token number,to be returned by the scanner.  */
    static final int BEGIN_KEYWORD = 258;
    /** Token number,to be returned by the scanner.  */
    static final int END_KEYWORD = 259;
    /** Token number,to be returned by the scanner.  */
    static final int VAR_KEYWORD = 260;
    /** Token number,to be returned by the scanner.  */
    static final int ELSE_KEYWORD = 261;
    /** Token number,to be returned by the scanner.  */
    static final int IF_KEYWORD = 262;
    /** Token number,to be returned by the scanner.  */
    static final int ASSIGNMENT_OPERATOR = 263;
    /** Token number,to be returned by the scanner.  */
    static final int PLUS_OPERATOR = 264;
    /** Token number,to be returned by the scanner.  */
    static final int BINARY_MINUS_OPERATOR = 265;
    /** Token number,to be returned by the scanner.  */
    static final int MULTIPLY_OPERATOR = 266;
    /** Token number,to be returned by the scanner.  */
    static final int DIVIDE_OPERATOR = 267;
    /** Token number,to be returned by the scanner.  */
    static final int SHIFT_RIGHT_OPERATOR = 268;
    /** Token number,to be returned by the scanner.  */
    static final int SHIFT_LEFT_OPERATOR = 269;
    /** Token number,to be returned by the scanner.  */
    static final int GREATER_OPERATOR = 270;
    /** Token number,to be returned by the scanner.  */
    static final int LESS_OPERATOR = 271;
    /** Token number,to be returned by the scanner.  */
    static final int EQUALS_OPERATOR = 272;
    /** Token number,to be returned by the scanner.  */
    static final int UNARY_MINUS_OPERATOR = 273;
    /** Token number,to be returned by the scanner.  */
    static final int OPENING_BRACKET = 274;
    /** Token number,to be returned by the scanner.  */
    static final int CLOSING_BRACKET = 275;
    /** Token number,to be returned by the scanner.  */
    static final int COMMA_SEPARATOR = 276;
    /** Token number,to be returned by the scanner.  */
    static final int CONSTANT = 277;
    /** Token number,to be returned by the scanner.  */
    static final int IDENTIFIER = 278;
    /** Token number,to be returned by the scanner.  */
    static final int COMMENT = 279;


    

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal ();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex () throws java.io.IOException;

    /**
     * Entry point for error reporting.  Emits an error
     * in a user-defined way.
     *
     * 
     * @param msg The string for the error message.
     */
     void yyerror (String msg);
  }

/**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;

  



  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public SyntaxAnalyser (Lexer yylexer) 
  {
    
    this.yylexer = yylexer;
    
  }



  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror (String msg)
  {
    yylexer.yyerror (msg);
  }



  private final class YYStack {
    private int[] stateStack = new int[16];
    
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value                            ) {
      height++;
      if (size == height)
        {
          int[] newStateStack = new int[size * 2];
          System.arraycopy (stateStack, 0, newStateStack, 0, height);
          stateStack = newStateStack;
          

          Object[] newValueStack = new Object[size * 2];
          System.arraycopy (valueStack, 0, newValueStack, 0, height);
          valueStack = newValueStack;

          size *= 2;
        }

      stateStack[height] = state;
      
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
        
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
          out.print (' ');
          out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState (int yystate, int yysym)
  {
    int yyr = yypgoto_[yysym - yyntokens_] + yystate;
    if (0 <= yyr && yyr <= yylast_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - yyntokens_];
  }

  private int yyaction (int yyn, YYStack yystack, int yylen) 
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    Object yyval = (0 < yylen) ? yystack.valueAt (yylen - 1) : yystack.valueAt (0);
    

    switch (yyn)
      {
          case 2:
  if (yyn == 2)
    /* "SyntaxAnalyser.y":34  */
                                      { yyval = treeParser.astNode("ROOT", ((Tree)(yystack.valueAt (1))), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 3:
  if (yyn == 3)
    /* "SyntaxAnalyser.y":38  */
                                             { yyval = treeParser.astNode("Program Body", ((Tree)(yystack.valueAt (1)))); };
  break;
    

  case 4:
  if (yyn == 4)
    /* "SyntaxAnalyser.y":42  */
                            { yyval = treeParser.astNode("Variables Declaration", new Tree("Var"), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 5:
  if (yyn == 5)
    /* "SyntaxAnalyser.y":46  */
                 { yyval = treeParser.addVariable(yyval.toString(), null); };
  break;
    

  case 6:
  if (yyn == 6)
    /* "SyntaxAnalyser.y":47  */
                                             { yyval = treeParser.addVariable(yyval.toString(), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 7:
  if (yyn == 7)
    /* "SyntaxAnalyser.y":51  */
               { yyval = ((Tree)(yystack.valueAt (0))); };
  break;
    

  case 8:
  if (yyn == 8)
    /* "SyntaxAnalyser.y":52  */
                              { yyval = treeParser.astNode("Operators", ((Tree)(yystack.valueAt (1))), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 9:
  if (yyn == 9)
    /* "SyntaxAnalyser.y":56  */
                                               { yyval = treeParser.newAppropriation(yyval.toString(), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 10:
  if (yyn == 10)
    /* "SyntaxAnalyser.y":57  */
                                              { yyval = treeParser.astNode("Operators", ((Tree)(yystack.valueAt (1)))); };
  break;
    

  case 11:
  if (yyn == 11)
    /* "SyntaxAnalyser.y":58  */
                                                                      { yyval = treeParser.astNode("If", ((Tree)(yystack.valueAt (2))), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 12:
  if (yyn == 12)
    /* "SyntaxAnalyser.y":59  */
                                                                                            { yyval = treeParser.astNode("IfElse", ((Tree)(yystack.valueAt (4))), ((Tree)(yystack.valueAt (2))), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 13:
  if (yyn == 13)
    /* "SyntaxAnalyser.y":63  */
                                      { yyval = treeParser.astNode("Expression", ((Tree)(yystack.valueAt (0))), new Tree("U")); };
  break;
    

  case 14:
  if (yyn == 14)
    /* "SyntaxAnalyser.y":64  */
                                                   { yyval = ((Tree)(yystack.valueAt (1))); };
  break;
    

  case 15:
  if (yyn == 15)
    /* "SyntaxAnalyser.y":65  */
                                            { yyval = treeParser.astNode("Expression", ((Tree)(yystack.valueAt (2))), new Tree("+"), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 16:
  if (yyn == 16)
    /* "SyntaxAnalyser.y":66  */
                                                    { yyval = treeParser.astNode("Expression", ((Tree)(yystack.valueAt (2))), new Tree("-"), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 17:
  if (yyn == 17)
    /* "SyntaxAnalyser.y":67  */
                                                { yyval = treeParser.astNode("Expression", ((Tree)(yystack.valueAt (2))), new Tree("*"), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 18:
  if (yyn == 18)
    /* "SyntaxAnalyser.y":68  */
                                              { yyval = treeParser.astNode("Expression", ((Tree)(yystack.valueAt (2))), new Tree("/"), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 19:
  if (yyn == 19)
    /* "SyntaxAnalyser.y":69  */
                                                  { yyval = treeParser.astNode("Expression", ((Tree)(yystack.valueAt (2))), new Tree("<<"), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 20:
  if (yyn == 20)
    /* "SyntaxAnalyser.y":70  */
                                                   { yyval = treeParser.astNode("Expression", ((Tree)(yystack.valueAt (2))), new Tree(">>"), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 21:
  if (yyn == 21)
    /* "SyntaxAnalyser.y":71  */
                                               { yyval = treeParser.astNode("Expression", ((Tree)(yystack.valueAt (2))), new Tree(">"), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 22:
  if (yyn == 22)
    /* "SyntaxAnalyser.y":72  */
                                            { yyval = treeParser.astNode("Expression", ((Tree)(yystack.valueAt (2))), new Tree("<"), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 23:
  if (yyn == 23)
    /* "SyntaxAnalyser.y":73  */
                                              { yyval = treeParser.astNode("Expression", ((Tree)(yystack.valueAt (2))), new Tree(":="), ((Tree)(yystack.valueAt (0)))); };
  break;
    

  case 24:
  if (yyn == 24)
    /* "SyntaxAnalyser.y":74  */
                   { yyval = treeParser.identifierReference(yyval.toString()); };
  break;
    

  case 25:
  if (yyn == 25)
    /* "SyntaxAnalyser.y":75  */
                 { yyval = treeParser.constant(yyval.toString()); };
  break;
    


/* "SyntaxAnalyser.java":475  */

        default: break;
      }

    yystack.pop (yylen);
    yylen = 0;

    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState (yystack.stateAt (0), yyr1_[yyn]);
    yystack.push (yystate, yyval);
    return YYNEWSTATE;
  }





  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse () throws java.io.IOException

  {
    


    /* Lookahead and lookahead in internal form.  */
    int yychar = yyempty_;
    int yytoken = 0;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;

    /* Error handling.  */
    int yynerrs_ = 0;
    

    /* Semantic value of the lookahead.  */
    Object yylval = null;

    yyerrstatus_ = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval );



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:

        /* Accept?  */
        if (yystate == yyfinal_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == yyempty_)
          {

            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal ();

          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);

        /* If the proper action on seeing token YYTOKEN is to reduce or to
           detect an error, take that action.  */
        yyn += yytoken;
        if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
          label = YYDEFAULT;

        /* <= 0 means reduce or error.  */
        else if ((yyn = yytable_[yyn]) <= 0)
          {
            if (yyTableValueIsError (yyn))
              label = YYERRLAB;
            else
              {
                yyn = -yyn;
                label = YYREDUCE;
              }
          }

        else
          {
            /* Shift the lookahead token.  */
            /* Discard the token being shifted.  */
            yychar = yyempty_;

            /* Count tokens shifted since error; after three, turn off error
               status.  */
            if (yyerrstatus_ > 0)
              --yyerrstatus_;

            yystate = yyn;
            yystack.push (yystate, yylval);
            label = YYNEWSTATE;
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction (yyn, yystack, yylen);
        yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs_;
            if (yychar == yyempty_)
              yytoken = yyempty_;
            yyerror (yysyntax_error (yystate, yytoken));
          }

        
        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.EOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.EOF)
                  return false;
              }
            else
              yychar = yyempty_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += yy_error_token_;
                if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yy_error_token_)
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;

            
            yystack.pop ();
            yystate = yystack.stateAt (0);
          }

        if (label == YYABORT)
            /* Leave the switch.  */
            break;



        /* Shift the error token.  */

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  // Generate an error message.
  private String yysyntax_error (int yystate, int tok)
  {
    return "syntax error";
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  private static final byte yypact_ninf_ = -31;
  private static final byte yytable_ninf_ = -1;

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final byte yypact_[] = yypact_init();
  private static final byte[] yypact_init()
  {
    return new byte[]
    {
      -4,   -15,    10,     8,    11,   -31,   -31,    -1,   -31,   -15,
      -1,    25,    37,    29,    -1,   -31,    52,    39,    39,   -31,
     -31,   -31,    39,    39,   -31,   -31,    14,    38,    38,    26,
      39,    39,    39,    39,    39,    39,    39,    39,    39,    -1,
     -31,    38,    38,    38,    38,    38,    38,    38,    38,    38,
      53,    -1,   -31
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte yydefact_[] = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       0,     0,     0,     0,     5,     4,     1,     0,     2,     0,
       0,     0,     0,     0,     7,     6,     0,     0,     0,     3,
       8,    10,     0,     0,    25,    24,     0,     9,    13,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
      14,    15,    16,    17,    18,    20,    19,    21,    22,    23,
      11,     0,    12
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte yypgoto_[] = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -31,   -31,   -31,   -31,    51,    -7,   -30,   -18
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte yydefgoto_[] = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
      -1,     2,     8,     3,     5,    13,    14,    26
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final byte yytable_[] = yytable_init();
  private static final byte[] yytable_init()
  {
    return new byte[]
    {
      27,     1,    10,    16,    28,    29,    11,    20,     4,    50,
       6,     7,    41,    42,    43,    44,    45,    46,    47,    48,
      49,    52,    12,    30,    31,    32,    33,    34,    35,    36,
      37,    38,     9,    19,    39,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    17,    18,    40,    30,    31,    32,
      33,    34,    35,    36,    37,    38,    21,    22,    23,    51,
      15,    24,    25
    };
  }

private static final byte yycheck_[] = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
      18,     5,     3,    10,    22,    23,     7,    14,    23,    39,
       0,     3,    30,    31,    32,    33,    34,    35,    36,    37,
      38,    51,    23,     9,    10,    11,    12,    13,    14,    15,
      16,    17,    21,     4,    20,     9,    10,    11,    12,    13,
      14,    15,    16,    17,    19,     8,    20,     9,    10,    11,
      12,    13,    14,    15,    16,    17,     4,    18,    19,     6,
       9,    22,    23
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte yystos_[] = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     5,    26,    28,    23,    29,     0,     3,    27,    21,
       3,     7,    23,    30,    31,    29,    30,    19,     8,     4,
      30,     4,    18,    19,    22,    23,    32,    32,    32,    32,
       9,    10,    11,    12,    13,    14,    15,    16,    17,    20,
      20,    32,    32,    32,    32,    32,    32,    32,    32,    32,
      31,     6,    31
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte yyr1_[] = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    25,    26,    27,    28,    29,    29,    30,    30,    31,
      31,    31,    31,    32,    32,    32,    32,    32,    32,    32,
      32,    32,    32,    32,    32,    32
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte yyr2_[] = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     2,     3,     2,     1,     3,     1,     2,     3,
       3,     5,     7,     2,     3,     3,     3,     3,     3,     3,
       3,     3,     3,     3,     1,     1
    };
  }


  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "$end", "error", "$undefined", "BEGIN_KEYWORD", "END_KEYWORD",
  "VAR_KEYWORD", "ELSE_KEYWORD", "IF_KEYWORD", "ASSIGNMENT_OPERATOR",
  "PLUS_OPERATOR", "BINARY_MINUS_OPERATOR", "MULTIPLY_OPERATOR",
  "DIVIDE_OPERATOR", "SHIFT_RIGHT_OPERATOR", "SHIFT_LEFT_OPERATOR",
  "GREATER_OPERATOR", "LESS_OPERATOR", "EQUALS_OPERATOR",
  "UNARY_MINUS_OPERATOR", "OPENING_BRACKET", "CLOSING_BRACKET",
  "COMMA_SEPARATOR", "CONSTANT", "IDENTIFIER", "COMMENT", "$accept",
  "Program", "ProgramBody", "VariableDeclaration", "Variables",
  "OperatorList", "Operator", "Expression", null
    };
  }



  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final byte yytranslate_ (int t)
  {
    int user_token_number_max_ = 279;
    byte undef_token_ = 2;

    if (t <= 0)
      return Lexer.EOF;
    else if (t <= user_token_number_max_)
      return yytranslate_table_[t];
    else
      return undef_token_;
  }
  private static final byte yytranslate_table_[] = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24
    };
  }


  private static final byte yy_error_token_ = 1;

  private static final int yylast_ = 62;
  private static final int yynnts_ = 8;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 6;
  private static final int yyntokens_ = 25;

/* User implementation code.  */
/* Unqualified %code blocks.  */
/* "SyntaxAnalyser.y":27  */

  	public TreeParser treeParser = new TreeParser();
  

/* "SyntaxAnalyser.java":962  */

}

/* "SyntaxAnalyser.y":78  */
