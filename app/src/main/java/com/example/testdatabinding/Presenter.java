package com.example.testdatabinding;

import android.view.View;
import android.widget.Toast;

/**
 * <p> Created by 宋华 on 2018/2/27.
 */
public class Presenter {
    public void onClick(View view){
        Toast.makeText(view.getContext(), "parent onClick", Toast.LENGTH_SHORT).show();
    }
}
