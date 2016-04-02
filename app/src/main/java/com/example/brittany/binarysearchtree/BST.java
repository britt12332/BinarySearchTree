package com.example.brittany.binarysearchtree;

import java.util.Stack;


public class BST
{
    private BinaryTree root;
    static String outOfBalanceInitial = "right";
    static String outOfBalanceSecondarily;



    public BST()
    {
        this.root = null;
    }

    public boolean isOutOfBalance()
    {
        //boolean-exp?true-stmt:false-stmt
        return this.root.isOutOfBalance();
    }

    public void howAreWeOutOfBalance(char val)
    {
        //where are we out of balance initially? left or right?

        if(val <= this.root.getPayload())
        {
            outOfBalanceInitial = "left";
        }

        //where are we out of balance secondarily? left or right?
         outOfBalanceSecondarily = this.root.outOfBalanceSecondarily(val, "DEFAULT TURN");

        //Finaly print out how we are out of balance
        System.out.println("Out of balance: " + outOfBalanceInitial + " - " + outOfBalanceSecondarily);

    }
    public void fix (String obi, String obs)
    {
        System.out.println( "BEFORE TREE - "+ "ROOT " + this.root.getPayload() + " Left Child " + this.root.getLeftTree().getPayload() + " Left Child " + this.root.getRightTree().getPayload());
        BinaryTree tempTreeHolder = this.root;
        if(obi == "left" && obs == "left")
        {
            this.root = this.root.getLeftTree();
            this.root.setRightTree(tempTreeHolder);
            System.out.println("FIXED LEFT LEFT");
            System.out.println("After Tree - "+"ROOT " + this.root.getPayload() + " Left Child " + this.root.getLeftTree().getPayload() + " Right Child " + this.root.getRightTree().getPayload());
        }
        else if(obi == "right" && obs == "right")
        {
            System.out.println( "BEFORE TREE - "+ "ROOT " + this.root.getPayload() + " Left Child " + this.root.getLeftTree().getPayload() + " Left Child " + this.root.getRightTree().getPayload());
            this.root = this.root.getRightTree();
            this.root.setLeftTree(tempTreeHolder);
            System.out.println("FIXED Right Right");
            System.out.println("After Tree - "+ "ROOT " + this.root.getPayload() + " Left Child " + this.root.getLeftTree().getPayload() + " Left Child " + this.root.getRightTree().getPayload());
        }

    }

    public void add(char payload)
    {
        if(this.root == null)
        {
            this.root = new BinaryTree(payload);
        }
        else
        {
            //we need to add to the tree
            this.root.add(payload);
        }
    }

    public void visitLevelOrder()
    {
        Stack<BinaryTree> answerStack = new Stack<BinaryTree>();
        Stack<BinaryTree> contentStack = new Stack<BinaryTree>();
        Stack<BinaryTree> childStack = new Stack<BinaryTree>();
        Stack<BinaryTree> tempStack = new Stack<BinaryTree>();

        if(this.root == null)
        {
            System.out.println("Empty Tree");
        }
        else
        {
            childStack.push(this.root);
            while(!childStack.isEmpty() || !tempStack.isEmpty())
            {
                //clear child stack by adding its children to tempStack and then popping
                while(!childStack.isEmpty())
                {
                    //push the left and right children of peek childStack onto tempStack
                    if(childStack.peek().getLeftTree() != null)
                    {
                        tempStack.push(childStack.peek().getLeftTree());
                    }
                    if(childStack.peek().getRightTree() != null)
                    {
                        tempStack.push(childStack.peek().getRightTree());
                    }

                    //pop from childStack and push onto contentStack
                    contentStack.push(childStack.pop());
                }

                //move contents of tempStack onto childStack in REVERSE
                while(!tempStack.isEmpty())
                {
                    //pop -> push onto childStack
                    childStack.push(tempStack.pop());
                }
            }

            //we now know that child and temp stacks are empty and all of our
            //nodes are in contentStack in REVERSE order, so we need to reverse them again
            while(!contentStack.isEmpty())
            {
                //pop -> push onto answerStack
                answerStack.push(contentStack.pop());
            }

            //our final answer is answerStack, we can visit the nodes in pop order
            String answer = "";
            while(!answerStack.isEmpty())
            {
                //pop and display value
                answer += answerStack.pop().getPayload() + "\t";
            }
            System.out.println(answer);
        }
    }

    public void visitPreOrder()
    {
        if(this.root == null)
        {
            System.out.println("Empty Tree");
        }
        else
        {
            System.out.println("Pre-Order: " + this.root.displayPreOrder());
        }
    }

    public void visitPostOrder()
    {
        if(this.root == null)
        {
            System.out.println("Empty Tree");
        }
        else
        {
            System.out.println("Post-Order: " + this.root.displayPostOrder());
        }
    }
    public void visitInOrder()
    {
        if(this.root == null)
        {
            System.out.println("Empty Tree");
        }
        else
        {
            System.out.println("In-Order: " + this.root.displayInOrder());
        }
    }
}