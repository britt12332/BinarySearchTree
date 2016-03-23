package com.example.brittany.binarysearchtree;

import java.util.Stack;

public class BST
{
    private BinaryTree root;

    public BST()
    {
        this.root = null;
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
                  if(this.root.getLeftTree() != null)
                  {
                      tempStack.push(this.root.getLeftTree());
                  }
                  if(this.root.getRightTree() != null)
                  {
                    tempStack.push(this.root.getRightTree());
                  }
                    contentStack.push(childStack.peek());
                    childStack.pop();

                   //push the left and right children of peek childStack onto tempStack
                  // pop from childStack and push onto contentStack
                }

                //move contents of tempStack onto childStack in REVERSE
                while(!tempStack.isEmpty())
                {
                   childStack.push(tempStack.peek());
                    tempStack.pop();
                    //pop -> push onto childStack
                }
            }

            //we now know that child and temp stacks are empty and all of our
            //nodes are in contentStack in REVERSE order, so we need to reverse them again
            while(!contentStack.isEmpty())
            {
                answerStack.push(contentStack.peek());
                contentStack.pop();
                //pop -> push onto answerStack
            }

            //our final answer is answerStack, we can visit the nodes in pop order
            while(!answerStack.isEmpty())
            {
               System.out.println("DISPLAY LEVEL ORDER: " + answerStack);

                //pop and display value
            }
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