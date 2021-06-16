  %language "Java"

  %define api.parser.class {SyntaxAnalyser}
  %define api.parser.public

  %type <Tree> Program ProgramBody VariableDeclaration Variables OperatorList Operator Expression

  /* Keyword tokens */
  %token BEGIN_KEYWORD END_KEYWORD VAR_KEYWORD ELSE_KEYWORD IF_KEYWORD

  /* Operator tokens */
  %token ASSIGNMENT_OPERATOR
  %token PLUS_OPERATOR BINARY_MINUS_OPERATOR MULTIPLY_OPERATOR DIVIDE_OPERATOR SHIFT_RIGHT_OPERATOR SHIFT_LEFT_OPERATOR GREATER_OPERATOR LESS_OPERATOR EQUALS_OPERATOR
  %token UNARY_MINUS_OPERATOR

  /* Separator tokens */
  %token OPENING_BRACKET CLOSING_BRACKET
  %token COMMA_SEPARATOR

  /* Constant, identifier and comment tokens */
  %token <Integer> CONSTANT
  %token IDENTIFIER
  %token COMMENT

  %start Program

  %code {
  	public TreeParser treeParser = new TreeParser();
  }

  %%
  
  Program:
      VariableDeclaration ProgramBody { $$ = treeParser.astNode("ROOT", $1, $2); }
      ;

  ProgramBody:
      BEGIN_KEYWORD OperatorList END_KEYWORD { $$ = treeParser.astNode("Program Body", $2); }
      ;

  VariableDeclaration:
      VAR_KEYWORD Variables { $$ = treeParser.astNode("Variables Declaration", new Tree("Var"), $2); }
      ;

  Variables:
      IDENTIFIER { $$ = treeParser.addVariable(yyval.toString(), null); }
      | IDENTIFIER COMMA_SEPARATOR Variables { $$ = treeParser.addVariable(yyval.toString(), $3); }
      ;

  OperatorList:
      Operator { $$ = $1; }
      | Operator OperatorList { $$ = treeParser.astNode("Operators", $1, $2); }
      ;

  Operator:
     IDENTIFIER ASSIGNMENT_OPERATOR Expression { $$ = treeParser.newAppropriation(yyval.toString(), $3); }
     | BEGIN_KEYWORD OperatorList END_KEYWORD { $$ = treeParser.astNode("Operators", $2); }
     | IF_KEYWORD OPENING_BRACKET Expression CLOSING_BRACKET Operator { $$ = treeParser.astNode("If", $3, $5); }
     | IF_KEYWORD OPENING_BRACKET Expression CLOSING_BRACKET Operator ELSE_KEYWORD Operator { $$ = treeParser.astNode("IfElse", $3, $5, $7); }
     ;

  Expression:
      UNARY_MINUS_OPERATOR Expression { $$ = treeParser.astNode("Expression", $2, new Tree("U")); }
      | OPENING_BRACKET Expression CLOSING_BRACKET { $$ = $2; }
      | Expression PLUS_OPERATOR Expression { $$ = treeParser.astNode("Expression", $1, new Tree("+"), $3); }
      | Expression BINARY_MINUS_OPERATOR Expression { $$ = treeParser.astNode("Expression", $1, new Tree("-"), $3); }
      | Expression MULTIPLY_OPERATOR Expression { $$ = treeParser.astNode("Expression", $1, new Tree("*"), $3); }
      | Expression DIVIDE_OPERATOR Expression { $$ = treeParser.astNode("Expression", $1, new Tree("/"), $3); }
      | Expression SHIFT_LEFT_OPERATOR Expression { $$ = treeParser.astNode("Expression", $1, new Tree("<<"), $3); }
      | Expression SHIFT_RIGHT_OPERATOR Expression { $$ = treeParser.astNode("Expression", $1, new Tree(">>"), $3); }
      | Expression GREATER_OPERATOR Expression { $$ = treeParser.astNode("Expression", $1, new Tree(">"), $3); }
      | Expression LESS_OPERATOR Expression { $$ = treeParser.astNode("Expression", $1, new Tree("<"), $3); }
      | Expression EQUALS_OPERATOR Expression { $$ = treeParser.astNode("Expression", $1, new Tree(":="), $3); }
      | IDENTIFIER { $$ = treeParser.identifierReference(yyval.toString()); }
      | CONSTANT { $$ = treeParser.constant(yyval.toString()); }
      ;

  %%