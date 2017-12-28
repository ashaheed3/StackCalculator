/* Ayanna Shaheed
 *Purpose: The purpose of the program is to use a Stack to convert
 *         an infix expression, entered by the user, to postfix then evalaute the
 *         expression using a value of x supplied by the user. 
 *______________________________________________________________________________
 *Solution:     The solution is divided into separate tasks and assigned to twelve 
 *           separate methods;delWhiteSpc,lastCharOperator,firstCharOperator,opdPreOpd,opPreOp
 *           opdBtwOpParen,noOpdBtwExp,containsUnBAlPar,containsIllTok, precedence,
 *           convertToPostfix,and evaluatePostFix. The main method calls these
 *           methods as needed. 
 *              DelWhiteSpace(String x) deletes any spaces within the infix expression
 *           in order to simplify error checking. The method moves through string x
 *           using a for loop. If the loop encouters a character that is not a space,
 *           it adds the character to the end of a new string, that the method will
 *           return.
 *              LastCharOperator(String x),firstCharOperator(String x),opPreOP(String x),
 *           opdPreOpd(String x),opdBtwOpParen(String x), containsUnBAlPar(String x), 
 *           and containsIllTok(String x) evalute the infix expression supplied by the user for errors. 
 *           LastCharOperator(String x) and firstCharOperator(String x),checks 
 *           to see if the last character and first character of the
 *           expression is an operator by comparing the characters to the acceptable 
 *           operators in the linked list.
 *              OpdPreOpd(String x) checks to see if an operand precedes an operand.
 *           The method uses a for loop to move through string x. If loop encounters
 *           an operand, the method checks to see if the next character is also
 *           an operand. Returns true if so.
 *              OpPreOp(String x) checks to see if an operator precedes an operator.
 *           The method uses a for loop to move through string x. If loop encounters
 *           an operator, the method checks to see if the next character is also
 *           an operator. Returns true if so.
 *              opdBtwOpParen(String x) checks to see if an operand is between a 
 *           left or right parenthesis and an operator. The method also uses a for loop to
 *           move through the string. If the loop encounters a '(', it checks to see
 *           the next character is an operator. If so, the method returns true. If
 *           the loop encounters a ')', it checks to see if the previous character
 *           is an operator. If so, the methods returns true.
 *              NoOpdBtwExp(String x) checks to see if there is an operand between
 *           subexpressions. The method moves through string x using a for loop. 
 *           if the loop encounters a ')', it checks to see if the next character is
 *           '('. If so, the method returns true. If the for loop encounters a ')'
 *           at the end of strin x, it catches the Stringoutofboundsexception
 *           and returns false.
 *              containsUnBAlPar(String x) checks for unbalanced parenthesis. Method
 *           counts the number of left and right parenthesis. If values are not
 *           equal, the method returns true.
 *              ContainsIllTok(String x) checks to see if String X contains an illegal
 *           token. The method uses a for loop to compare each character in String 
 *           x to the acceptable tokens in the linked lists. If a 
 *           character in x does not match a element in one of the linked lists,
 *           the method returns true.
 *              Precedence(char x) assigns precedence to binary operators; +, -,
 *           /,%,*. If the character passed to the method is a %,*, or /, the 
 *           method returns a 2, giving the operator the highest possible precedence. If the
 *           character passed to the method is + or -, the method returns a 1, 
 *           giving the operators the lowest precedence. If the character passed
 *           into the method is not a binary operator, the method returns -1.
 *              ConvertToPostfix(String expression) converts the user's infix   
 *           expression to postfix using the convert to postfix algorithm in the
 *           Data structures book. EvaluatePostFix(String valOfX, String postFixExp) also uses 
 *           an algorithm from the book to evaluate the postfix expression.
 *              The main method prompts the user for necessary information like
 *           an infix expression and a value for x, then prints out the results.
 *______________________________________________________________________________
 *Data Structures: One-Deimentional Arrays, Linked Lists, Stacks
 *______________________________________________________________________________
 *Use:  To use the program, the user must first supply an infix expression. 
 *      The expression should not contain numbers with multiple digits or
 *      floating point numbers. Expression should also have correct syntax. If the
 *      expression contains an error, the program prints an error message and quits. 
 *      If the expression is valid, the program converts the expression to postfix.
 *      After that, the program continously prompts the user for a value of x 
 *      the reevalues the expression until the user quits the program by entering
 *      q.
 *______________________________________________________________________________
 * Classses: The main class solves the main problem.   
 *           
 */
package calc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class calc {
    
    
    private  static Character[] legalNum = new Character[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0','x'};
    private  static Character[] legalOP = new Character[] {'/','*','%','+','-'};
    private  static Character[] otherLeg = new Character[] {'(',')'};
    private  static LinkedList nums = new LinkedList(Arrays.asList(legalNum));
    private  static LinkedList ops = new LinkedList(Arrays.asList(legalOP));
    private  static LinkedList legs = new LinkedList(Arrays.asList(otherLeg));
    
    
    /*Precondition: Calling code accepts a string x as an argument.
     *Postcondition: Returns string x with all whitespace deleted 
     */
    public static String delWhiteSpc(String x){
        String newExp = "";
        for(int i = 0; i < x.length(); i++){
            if(x.charAt(i) != ' '){ 
                newExp += x.charAt(i);
                }
            }
        return newExp;
        }
        
    
    /*Precondition: Calling code accepts a string x as an argument.
     *Postcondition: Returns true if last character of x is an operator. 
     */
    public static boolean lastCharOperator(String x){
        if(!ops.contains(x.charAt(x.length()-1))){
            return false;
        }else{
            return true;
        }
    }
    
    /*Precondition: Calling code accepts a string x as an argument.
     *Postcondition: Returns true if first character of x is an operator. 
     */
    public static boolean firstCharOperator(String x){
        if(!ops.contains(x.charAt(0))){
            return false;
        }else{
            return true;
        }
    }
    
     /*Precondition: Calling code accepts a string x as an argument.
     *Postcondition: Returns true if an operand is between a left or right parenthesis
     *               and an operator. 
     */
    public static boolean opdBtwOpParen(String x){
        
        for(int i = 0; i < x.length(); i++){
            if(x.charAt(i) == '('){ 
                if((ops.contains(x.charAt(i+1)))){
                    return true;   
                }
            }
            
            if(x.charAt(i) == ')'){ 
                if((ops.contains(x.charAt(i-1)))){
                    return true;   
                }
            }
        }
        return false;
    }
    
    
    /*Precondition: Calling code accepts a string x as an argument.
     *Postcondition: Returns true if there is no operand between subexpressions.
     */
    public static boolean noOpdBtwExp(String x){
        
        for(int i = 0; i < x.length(); i++){
            if(x.charAt(i) == ')'){ 
                try{
                if((x.charAt(i+1) == '(')){
                    return true;   
                }
                }catch(StringIndexOutOfBoundsException e){return false;}
            }
        }
        return false;
    }
    
    
    
    /*Precondition: Calling code accepts a string x as an argument.
     *Postcondition: Returns true if operand follows an operand. 
     */
    public static boolean opdPreOpd(String x){
        
        for(int i = 0; i < x.length(); i++){
            if(nums.contains(x.charAt(i))){ 
                try{
                if((nums.contains(x.charAt(i+1)))){
                    return true;   
                }
                }catch(StringIndexOutOfBoundsException e){return false;}
            }
        }
        return false;
    }
    
    
    /*Precondition: Calling code accepts a string x as an argument.
     *Postcondition: Returns true if operator follows an operator. 
     */
    public static boolean opPreOp(String x){
        
        for(int i = 0; i < x.length(); i++){
            if(ops.contains(x.charAt(i))){ 
                if((ops.contains(x.charAt(i+1)))){
                    return true;   
                }
            }
        }
        return false;
    }

    
    
    /*Precondition: Calling code accepts a string x as an argument.
     *Postcondition: Returns true if parenthesis are unbalanced. 
     */
    public static boolean containsUnBAlPar(String x){
        int rightPar = 0, leftPar = 0;
        
        for(int i = 0; i < x.length(); i++){
            if(x.charAt(i) == '('){
                leftPar++;    
            }else if(x.charAt(i) == ')'){
                rightPar++;   
            }
        }
        
        if(rightPar == leftPar)
            return false;
        else
            return true;
    }
    
    
    /*Precondition: Calling code accepts a string x as an argument.
     *Postcondition: If string x contains an illegal token method returns true. 
     *               Else returns false.
     */
    public static boolean containsIllTok(String x){  
        for(int i = 0; i < x.length(); i++){
            if(!nums.contains(x.charAt(i))||!ops.contains(x.charAt(i))||!legs.contains(x.charAt(i))){
               return false;
            }
        }
        return true;
    }
    
    
    /*Precondition: Calling code accepts a char x as an argument.
     *Postcondition: If char x = / * or % method returns 2. If x = + or -, method
     *               returns 1. Else the method returns -1.
     */
    public static int precedence(char x){
        switch (x){
            case '/': case'*': case'%':
                return 2;
            case '+': case '-':
                return 1;
            default:
                return -1;
        }
    }
    
    
    /*Precondition: Calling code accepts a String expression as an argument.
     *Postcondition: Method assumes expression is infix and has no errors. Method
     *               retuns postfix expression.
     */
    public static String convertToPostfix(String expression){
        
        Stack<Character> opStack = new Stack<Character>();
        String postFixExp = "";
        
        for(int i = 0; i < expression.length(); i++){
            switch(expression.charAt(i)){
                //Appends operand to end of postFixExp
                case '1':case '2': case '3': case '4': case '5':
                case '6':case '7': case '8': case '9': case '0':
                case 'x': 
                    postFixExp += expression.charAt(i);
                    break;
                    
                //Save '(' on stack    
                case '(':
                    opStack.push(expression.charAt(i));
                    break;
                
                //Pop stack until matching '('    
                case ')':
                    while (opStack.peek()!= '('){
                         postFixExp += opStack.pop();
                    }
                    //Remove open parentheses
                    char openParen = opStack.pop();
                    break;
                    
                //Process stack operators of greater precedence
                case '+': case '-': case'/': case '*': case '%':
                    while ((!opStack.isEmpty()) && (opStack.peek() != '(') && (precedence(expression.charAt(i)) <= precedence(opStack.peek()))){
                        postFixExp += opStack.pop();
                    }
                    opStack.push(expression.charAt(i));
                    break;
                    
                default:
                    break;
            }
        }
        
        //Append to postFixExp the operators remaining in the stack
        while(!opStack.isEmpty()){
            postFixExp += opStack.pop();
        }
        return postFixExp;
    }
    
    
    
    /*Precondition: Calling code accepts String valOfX and String expression as an argument.
     *              Method assumes postfix expression has no spaces.
     *Postcondition: Method retuns value postfix expression.
     */
    public static int evaluatePostFix(String valOfX, String postFixExp){
        
        Stack<Integer> opStack = new Stack<Integer>();
        int op1, op2, result;
        
        for(int i = 0; i < postFixExp.length(); i++){
            
               if(nums.contains(postFixExp.charAt(i))){
                   if(postFixExp.charAt(i)=='x'){
                       opStack.push(Integer.parseInt(valOfX));
                   }else{
                       Character ch = postFixExp.charAt(i);
                       opStack.push(Character.getNumericValue(ch)); 
                   }
               }else{
                   
                   op2 = opStack.pop();
                   op1 = opStack.pop();
                   
                    switch(postFixExp.charAt(i)){    
                        case '+':
                            result = op1 + op2;
                            opStack.push(result);
                            break;
                        case '-':
                            result = op1 - op2;
                            opStack.push(result);
                            break;
                        case '/':
                            result = op1 / op2; 
                            opStack.push(result);
                            break;
                        case '%':
                            result =op1 % op2; 
                            opStack.push(result);
                            break;
                 
                    }                  
                }
            }
        return opStack.peek();
    }
    
    
    public static void main(String[] args) {
        
        boolean run = true;
        String response, postFixexp = "";
        
        //Prompts user for infix notation
        Scanner in = new Scanner(System.in);
        System.out.println("Enter infix expression:");
        response = in.nextLine().trim();
        
        String infixExp = delWhiteSpc(response);
       
        if(firstCharOperator(infixExp)||lastCharOperator(infixExp)||containsIllTok(infixExp)||containsUnBAlPar(infixExp)||opdPreOpd(infixExp)||opdBtwOpParen(infixExp)||noOpdBtwExp(infixExp)||opPreOp(infixExp)){
            System.out.println("Error in Expression");
            run = false;
        }else{
            //Convert to postfix and display result*/
            postFixexp = convertToPostfix(infixExp);
            System.out.println("Converted expression: " + postFixexp );
        }
        
        //Repeatedly prompt user for value of x
        while(run){
            
            System.out.println("Enter value of x(enter q to quit):"  );
            response = in.nextLine().trim();
        
            if (response.equalsIgnoreCase("q"))
                run = false;
            else
                System.out.println("Answer to expression: " + evaluatePostFix(response, postFixexp));
            
        }    
    }
}
    

