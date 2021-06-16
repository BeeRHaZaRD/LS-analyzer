# Лексический + синтаксический анализатор кода

## Вариант 5

```
<Программа> ::= <Объявление переменных> <Описание вычислений> .
<Описание вычислений> ::= Begin < Список операторов > End
<Объявление переменных> ::= Var <Список переменных>
<Список переменных> ::= <Идент> | <Идент> , <Список переменных>
<Список операторов> ::= <Оператор> | <Оператор> <Список операторов>
<Оператор>::=<Присваивание> |<Сложный оператор> 
<Присваивание> ::= <Идент> := <Выражение>
<Выражение> ::= <Ун.оп.> <Подвыражение> | <Подвыражение>
<Подвыражение> :: = ( <Выражение> ) | <Операнд> |
< Подвыражение > <Бин.оп.> <Подвыражение>
<Ун.оп.> ::= "-"
<Бин.оп.> ::= "-" | "+" | "*" | "/" | ">>" | "<<" | ">" | "<" | "="
<Операнд> ::= <Идент> | <Const>
<Сложный оператор> ::= IF "("< Выражение> ")" Оператор|
 IF "(" <Выражение> ")" <Оператор> ELSE <Оператор>|<Составной оператор> 
<Составной оператор>::= Begin < Список операторов > End
<Идент> ::= <Буква> <Идент> | <Буква>
<Const> ::= <Цифра> <Const> | <Цифра>

комментарий в стиле С++ многострочный
/**********************************
**** строки комментариев **********/
```

### Сборка и запуск:

```
bison SyntaxAnalyser.y
jflex LexicalAnalyser.flex
javac Main.java
java Main ./test/test1
```

### Пример кода:

```
Var a, b, c
Begin
a := 15
c := -10
b := a
b := (a + c) * a / (c - 5)

/* c := -5 */

/* hsfdgjasdhgjsdh
fkgsdhfkgjfdhk
dkfgsjdg */

c := a - b

a := 2 * b - c * 4

IF (a > 10)
Begin
b := a + c
End

IF (a < 10)
Begin
b := a - c
c := a
End
ELSE
Begin
c := b
End

End
```

### Результирующее синтаксическое дерево:

```
(ROOT)
     (Variables Declaration)
      |      +-------[Keyword] (Var)
      |      +-------(Variables list)
      |             +-------[Identifier] (a)
      |             +-------(Variables list)
      |                    +-------[Identifier] (b)
      |                    +-------(Variables list)
      |                           +-------[Identifier] (c)
     (Program Body)
             +-------(Operators)
                    +-------(Operator)
                    |      +-------[Binary operator] (=)
                    |             +-------[Identifier] (a)
                    |             +-------[Const] (15)
                    +-------(Operators)
                           +-------(Operator)
                           |      +-------[Binary operator] (=)
                           |             +-------[Identifier] (c)
                           |             +-------[Expression] (Expression)
                           |                    +-------[Const] (10)
                           |                    +-------[Unary operator] (-)
                           +-------(Operators)
                                  +-------(Operator)
                                  |      +-------[Binary operator] (=)
                                  |             +-------[Identifier] (b)
                                  |             +-------[Identifier] (a)
                                  +-------(Operators)
                                         +-------(Operator)
                                         |      +-------[Binary operator] (=)
                                         |             +-------[Identifier] (b)
                                         |             +-------[Expression] (Expression)
                                         |                    +-------[Expression] (Expression)
                                         |                    |      +-------[Identifier] (a)
                                         |                    |      +-------[Binary operator] (+)
                                         |                    |      +-------[Identifier] (c)
                                         |                    +-------[Binary operator] (*)
                                         |                    +-------[Expression] (Expression)
                                         |                           +-------[Identifier] (a)
                                         |                           +-------[Binary operator] (/)
                                         |                           +-------[Expression] (Expression)
                                         |                                  +-------[Identifier] (c)
                                         |                                  +-------[Binary operator] (-)
                                         |                                  +-------[Const] (5)
                                         +-------(Operators)
                                                +-------(Operator)
                                                |      +-------[Binary operator] (=)
                                                |             +-------[Identifier] (c)
                                                |             +-------[Expression] (Expression)
                                                |                    +-------[Identifier] (a)
                                                |                    +-------[Binary operator] (-)
                                                |                    +-------[Identifier] (b)
                                                +-------(Operators)
                                                       +-------(Operator)
                                                       |      +-------[Binary operator] (=)
                                                       |             +-------[Identifier] (a)
                                                       |             +-------[Expression] (Expression)
                                                       |                    +-------[Const] (2)
                                                       |                    +-------[Binary operator] (*)
                                                       |                    +-------[Expression] (Expression)
                                                       |                           +-------[Identifier] (b)
                                                       |                           +-------[Binary operator] (-)
                                                       |                           +-------[Expression] (Expression)
                                                       |                                  +-------[Identifier] (c)
                                                       |                                  +-------[Binary operator] (*)
                                                       |                                  +-------[Const] (4)
                                                       +-------(Operators)
                                                              +-------(If)
                                                              |      +-------[Expression] (Expression)
                                                              |      |      +-------[Identifier] (a)
                                                              |      |      +-------[Binary operator] (>)
                                                              |      |      +-------[Const] (10)
                                                              |      +-------(Operators)
                                                              |             +-------(Operator)
                                                              |                    +-------[Binary operator] (=)
                                                              |                           +-------[Identifier] (b)
                                                              |                           +-------[Expression] (Expression)
                                                              |                                  +-------[Identifier] (a)
                                                              |                                  +-------[Binary operator] (+)
                                                              |                                  +-------[Identifier] (c)
                                                              +-------(IfElse)
                                                                     +-------[Expression] (Expression)
                                                                     |      +-------[Identifier] (a)
                                                                     |      +-------[Binary operator] (<)
                                                                     |      +-------[Const] (10)
                                                                     +-------(Operators)
                                                                     |      +-------(Operators)
                                                                     |             +-------(Operator)
                                                                     |             |      +-------[Binary operator] (=)
                                                                     |             |             +-------[Identifier] (b)
                                                                     |             |             +-------[Expression] (Expression)
                                                                     |             |                    +-------[Identifier] (a)
                                                                     |             |                    +-------[Binary operator] (-)
                                                                     |             |                    +-------[Identifier] (c)
                                                                     |             +-------(Operator)
                                                                     |                    +-------[Binary operator] (=)
                                                                     |                           +-------[Identifier] (c)
                                                                     |                           +-------[Identifier] (a)
                                                                     +-------(Operators)
                                                                            +-------(Operator)
                                                                                   +-------[Binary operator] (=)
                                                                                          +-------[Identifier] (c)
                                                                                          +-------[Identifier] (b)
```

### Результирующий ассемблерный код:

```
START
a = 15
tmp_0 = - 10
c = tmp_0
b = a
tmp_2 = a + c
tmp_4 = c - 5
tmp_3 = a / tmp_4
tmp_1 = tmp_2 * tmp_3
b = tmp_1
tmp_5 = a - b
c = tmp_5
tmp_8 = c * 4
tmp_7 = b - tmp_8
tmp_6 = 2 * tmp_7
a = tmp_6
tmp_9 = a > 10
if_false tmp_9 goto L0
tmp_10 = a + c
b = tmp_10
L0:
tmp_11 = a < 10
if_false tmp_11 goto L1
tmp_12 = a - c
b = tmp_12
c = a
goto L2
L1:
c = b
L2:
END
```
