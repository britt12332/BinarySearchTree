package com.example.brittany.binarysearchtree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shuntingYard.postFix("3+4*2/(1-5)^2^3");
        shuntingYard.combine(shuntCore.finalOutStack,shuntCore.finalOpStack);




      /*  BST tree = new BST();
        String vals = "fgh";
        for(int i = 0; i < vals.length(); i++)
        {
            tree.add(vals.charAt(i));
        }

        if(tree.isOutOfBalance())
        {
            System.out.println("Out of balance: " + tree.isOutOfBalance());
            tree.howAreWeOutOfBalance('h');
        }
        tree.rebalance(BSTCore.outOfBalanceInitial, BSTCore.outOfBalanceSecondarily);
        System.out.println("Out of balance: " + tree.isOutOfBalance()); */
        //tree.visitPreOrder();
        //tree.visitPostOrder();
        //tree.visitInOrder();
        //tree.visitLevelOrder();
    }
}