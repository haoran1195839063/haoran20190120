package com.example.com.haoran20190120;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyView extends LinearLayout {


    private TextView jian;
    private TextView num;
    private TextView jia;

    private int number=1;
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.myview, this);
        jian = inflate.findViewById(R.id.jian);
        num = inflate.findViewById(R.id.num);
        jia = inflate.findViewById(R.id.jia);

        jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number==0){
                    Toast.makeText(context, "不可以在减了", Toast.LENGTH_SHORT).show();
                }
                number--;
                num.setText(number+"");
            }
        });

        jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                num.setText(number+"");
            }
        });


    }


}
