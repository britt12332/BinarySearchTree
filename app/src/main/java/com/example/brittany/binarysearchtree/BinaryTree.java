package com.example.brittany.binarysearchtree;

public class BinaryTree
{
    private char payload;
    private BinaryTree leftTree;
    private BinaryTree rightTree;

    public BinaryTree(char payload)
    {
        this.payload = payload;
        this.leftTree = null;
        this.rightTree = null;
    }

    public void setLeftTree(BinaryTree leftTree)
    {
        this.leftTree = leftTree;
    }

    public void setRightTree(BinaryTree rightTree)
    {
        this.rightTree = rightTree;
    }

    public boolean isOutOfBalance()
    {
        int leftDepth = this.leftTree == null?0:this.leftTree.depth();
        int rightDepth = this.rightTree == null?0:this.rightTree.depth();
        return Math.abs(leftDepth-rightDepth) > 1;
    }

    public String outOfBalanceSecondarily(char val, String lastTurn)
    {
        //are we looking at a matching payload and are we a leaf node
        if(this.payload == val && this.leftTree == null)
        {
            //we are looking at THE last tree added
            //return the last turn we made
            return lastTurn;
        }
        else
        {
            //I might have a payload that matches val, or I am still looking for a matching payload
            //in either case, I am not at THE last leaf added.

            //keep traversing the tree and ultimately return left or right
            if(val <= this.payload)
            {
                //we would have added it to the left
                return this.leftTree.outOfBalanceSecondarily(val, "left");
            }
            else
            {
                return this.rightTree.outOfBalanceSecondarily(val, "right");
            }
        }
    }

    public int depth()
    {
        //boolean-exp?true-stmt:false-stmt
        return 1 + Math.max((this.leftTree == null?0:this.leftTree.depth()),
                (this.rightTree == null?0:this.rightTree.depth()));
    }

    public void add(BinaryTree tree)
    {
        if(tree.payload <= this.payload)
        {
            if(this.leftTree == null)
            {
                this.leftTree = tree;
            }
            else
            {
                this.leftTree.add(tree);
            }
        }
        else
        {
            if(this.rightTree == null)
            {
                this.rightTree = tree;
            }
            else
            {
                this.rightTree.add(tree);
            }
        }
    }

    public void add(char payload)
    {
        BSTCore.grandParent = BSTCore.parent;
        BSTCore.parent = BSTCore.pivot;
        BSTCore.pivot = this;
        if(payload <= this.payload)
        {
            if(this.leftTree == null)
            {
                this.leftTree = new BinaryTree(payload);
                BSTCore.culprit = this.leftTree;
            }
            else
            {
                this.leftTree.add(payload);
            }
        }
        else
        {
            if(this.rightTree == null)
            {
                this.rightTree = new BinaryTree(payload);
                BSTCore.culprit = this.rightTree;
            }
            else
            {
                this.rightTree.add(payload);
            }
        }
    }

    public String displayPreOrder()
    {
        String answer = "" + this.payload + "\t";
        if(this.leftTree != null)
        {
            answer += this.leftTree.displayPreOrder();
        }

        if(this.rightTree != null)
        {
            answer += this.rightTree.displayPreOrder();
        }
        return answer;
    }

    public String displayPostOrder()
    {
        String answer = "";
        if(this.leftTree != null)
        {
            answer += this.leftTree.displayPostOrder();
        }

        if(this.rightTree != null)
        {
            answer += this.rightTree.displayPostOrder();
        }
        return answer + this.payload + "\t";
    }

    public String displayInOrder()
    {
        String answer = "";
        if(this.leftTree != null)
        {
            answer += this.leftTree.displayInOrder();
        }
        answer += this.payload + "\t";
        if(this.rightTree != null)
        {
            answer += this.rightTree.displayInOrder();
        }
        return answer;
    }

    public char getPayload()
    {
        return payload;
    }

    public BinaryTree getLeftTree()
    {
        return leftTree;
    }

    public BinaryTree getRightTree()
    {
        return rightTree;
    }
}