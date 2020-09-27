# StackCalculator

## Purpose
The purpose of the program is to use a Stack to convert
an infix expression, entered by the user, to postfix then evalaute the expression using a value of x supplied by the user. 


 ## Solution
 The solution is divided into separate tasks and assigned to twelve separate methods:
    1. [delWhiteSpc] (#delWhiteSpc)
    2. [lastCharOperator] (#lastCharOperator)
    3. [firstCharOperator] (#firstCharOperator)
    4. [opdPreOpd] (#opdPreOpd)
    5. [opPreOp] (#opPreOp)
    6. [opdBtwOpParen] (#opdBtwOpParen)
    7. [noOpdBtwExp] (#noOpdBtwExp)
    8. [containsUnBAlPar] (#containsUnBAlPar)
    9. [containsIllTok] (#containsIllTok)
    10. [precedence] (#precedence)
    11. [convertToPostfix] (#convertToPostfix)
    12. [evaluatePostFix] (#evaluatePostFix)
    
 ### delWhiteSpace
 DelWhiteSpace(String x) deletes any spaces within the infix expression in order to simplify error checking. The method moves through string x using a for loop. If the loop encouters a character that is not a space, it adds the character to the end of a new string, that the method will return.

 ### lastCharOperator
 ### firstCharOperator
 LastCharOperator(String x) and firstCharOperator(String x),checks to see if the last character and first character of the expression is an operator by comparing the characters to the acceptable operators in the linked list.

 ### opPreOP
 OpPreOp(String x) checks to see if an operator precedes an operator. The method uses a for loop to move through string x. If loop encounters an operator, the method checks to see if the next character is also an operator. Returns true if so.

 ### opdPreOpd
 OpdPreOpd(String x) checks to see if an operand precedes an operand. The method uses a for loop to move through string x. If loop encounters an operand, the method checks to see if the next character is also an operand. Returns true if so.

 ### opdBtwOpParen
opdBtwOpParen(String x) checks to see if an operand is between a left or right parenthesis and an operator. The method also uses a for loop to move through the string. If the loop encounters a '(', it checks to see the next character is an operator. If so, the method returns true. If
the loop encounters a ')', it checks to see if the previous character is an operator. If so, the methods returns true.

### noOpdBtwExp
NoOpdBtwExp(String x) checks to see if there is an operand between subexpressions. The method moves through string x using a for loop. If the loop encounters a ')', it checks to see if the next character is '('. If so, the method returns true. If the for loop encounters a ')' at the end of strin x, it catches the Stringoutofboundsexception
and returns false.

 ### containsUnBAlPar
 containsUnBAlPar(String x) checks for unbalanced parenthesis. Method counts the number of left and right parenthesis. If values are not equal, the method returns true.

 ### containsIllTok
 ContainsIllTok(String x) checks to see if String X contains an illegal token. The method uses a for loop to compare each character in String x to the acceptable tokens in the linked lists. If a character in x does not match a element in one of the linked lists, the method returns true.

### precedence
Precedence(char x) assigns precedence to binary operators; +, -, /,%,*. If the character passed to the method is a %,*, or /, the method returns a 2, giving the operator the highest possible precedence. If the character passed to the method is + or -, the method returns a 1, giving the operators the lowest precedence. If the character passed into the method is not a binary operator, the method returns -1.

### convertToPostfix
ConvertToPostfix(String expression) converts the user's infix expression to postfix using the convert to postfix algorithm in the Data structures book. 

### evaluatePostFix
 EvaluatePostFix(String valOfX, String postFixExp) also uses an algorithm from the book to evaluate the postfix expression. The main method prompts the user for necessary information like an infix expression and a value for x, then prints out the results.

## Data Structures
 One-Deimentional Arrays, Linked Lists, Stacks

## Use

To use the program, the user must first supply an infix expression. The expression should not contain numbers with multiple digits or floating point numbers. Expression should also have correct syntax. If the expression contains an error, the program prints an error message and quits. 
If the expression is valid, the program converts the expression to postfix. After that, the program continously prompts the user for a value of x the reevalues the expression until the user quits the program by entering
q.
 
## Classes
The main class solves the main problem.   
