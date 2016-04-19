package com.example.brittany.binarysearchtree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by brittany on 4/14/2016.
 */
public class shuntingYard {

    static Stack<Character> postFix(String problem) {

        Stack<Character> operatorStack = new Stack<Character>();
        Stack<Character> outputStack = new Stack<Character>();
        Stack<Character> tempOutputStack = new Stack<Character>();
        Stack<Character> garbStack = new Stack<Character>();


        StringTokenizer inputST = new StringTokenizer(problem);
        String token = inputST.nextToken();
        char currToken;
        for (int i = 0; i < 15; i++)
        {

            currToken = token.charAt(i);
            //System.out.println("HERE" + token.charAt(i));
            do {

                if (currToken == '+' || currToken == '-' || currToken == '/' || currToken == '*' || currToken == ')' || currToken == '(' || currToken == '^') {
                    if (operatorStack.empty() || currToken == '^') {
                        operatorStack.push(currToken);
                        break;
                    } else {

                        if (currToken == ('(')) {
                            garbStack.push(currToken);
                            break;
                        }
                        if (!garbStack.isEmpty() ) {
                            if (currToken == ')') {
                                garbStack.push(currToken);
                                outputStack.push(tempOutputStack.peek());

                                break;

                            }
                            if ( !garbStack.isEmpty() && currToken == '+' || currToken == '-' || currToken == '/' || currToken == '*') {

                                tempOutputStack.push(currToken);
                                garbStack.empty();

                                break;
                            } else {
                                outputStack.push(currToken);
                            }

                          //  outputStack.push(tempOutputStack.peek());
                            tempOutputStack.pop();
                          //  operatorStack.pop();

                        }

                        if (currToken == '*' && operatorStack.peek() == '+' || operatorStack.peek() == '-') {
                            operatorStack.push(currToken);
                            break;
                        } else if (currToken == '*' && operatorStack.peek() == '*' || operatorStack.peek() == '/') {

                            outputStack.push(operatorStack.peek());
                            operatorStack.pop();
                            operatorStack.push(currToken);
                            break;

                        }
                        if (currToken == '/' && operatorStack.peek() == '+' || operatorStack.peek() == '-') {
                            operatorStack.push(currToken);


                        } else {
                            outputStack.push(operatorStack.peek());
                            operatorStack.pop();
                            operatorStack.push(currToken);
                            break;

                        }
                        if (currToken == '+' && operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '+' || operatorStack.peek() == '-') {

                            outputStack.push(operatorStack.peek());
                            operatorStack.pop();
                            operatorStack.push(currToken);
                            break;
                        }

                         /*  while(!operatorStack.isEmpty())
                           {
                               outputStack.push(operatorStack.peek());
                               operatorStack.pop();
                           } */

                        if (currToken == '-' && operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '+' || operatorStack.peek() == '-') {
                            outputStack.push(operatorStack.peek());
                            operatorStack.pop();
                            operatorStack.push(currToken);
                            break;
                        }

                    }
                } else {
                    outputStack.push(currToken);

                }


             //   System.out.println("ops" + operatorStack);
              //  System.out.println("output" + outputStack);



            } while (inputST.hasMoreTokens());


           // System.out.println("opsEND" + operatorStack);
           // System.out.println("outputEND" + outputStack);
            shuntCore.finalOpStack = operatorStack;
           shuntCore.finalOutStack = outputStack;




       /* while(!outputStack.isEmpty())
        {
            answerll.addLast(outputStack.pop());

        }
        System.out.println("answer "+answerll);*/
        }


        return shuntCore.finalOutStack;

    }

   static Stack<Character> combine(Stack out, Stack opp)
   {


       while(!opp.isEmpty())
       {
           out.push(opp.pop());

       }
       System.out.println("answer = " + out);
       return out;
   }
}










