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

        BST tree = new BST();
        String vals = "fbaa";

        for(int i = 0; i < vals.length(); i++)
        {
            tree.add(vals.charAt(i));
            if(tree.isOutOfBalance())
            {
                tree.howAreWeOutOfBalance('a');
            }
        }
        //tree.visitPreOrder();
        //tree.visitPostOrder();
        //tree.visitInOrder();
        //tree.visitLevelOrder();
    }
}