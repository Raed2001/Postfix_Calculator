/**
 TH Brandenburg
 Dr. Michael Pilgermann

 ACS AlgoDat WS21/22
 Exercise 05 - Task 04

 push value with: pfStack.push(new Integer(__value__));
 pop value from stack: __value__ = ((Integer)pfStack.pop()).intValue();

 **/

import java.util.Stack;

class PostfixCalculator
{
    static Stack pfStack = new Stack();
   static int a;
   static int b;
   char operator;

    public static int evaluatePostfix(Object[] P)
    {
        for (Object o : P)
        {
            if (o instanceof Integer)
            {
                pfStack.push(o);
            } else {

                a=(int)pfStack.pop();
                b=(int)pfStack.pop();
            pfStack.push(evaluateExpression(a,b,o.toString().charAt(0)));


            }
        }
        return (int)pfStack.pop();
    }

    public static int evaluateExpression(int a, int b, char operator)
    {
if (operator=='+'){
    return a+b;
}
else if(operator=='-'){
    return a-b;
}
else if (operator=='*'){
    return a*b;
}
else {
    return a/b;
}
    }

    public static void main (String[] args)
    {

        Object[] formula = {new Integer(3),new Integer(3),  new Integer(5), '+', '*'};
        int res = evaluatePostfix(formula);
        System.out.println(res);
    }
}