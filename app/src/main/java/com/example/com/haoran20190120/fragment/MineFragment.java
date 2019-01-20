package com.example.com.haoran20190120.fragment;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.com.haoran20190120.R;

/**
 * A fragment with a Google +1 button.
 */
public class MineFragment extends Fragment {


    private ImageView tuoxiang;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        initView(view);
        ObjectAnimator rotation = new ObjectAnimator().ofFloat(tuoxiang, "rotation", 0f, 180f);
        rotation.setDuration(2000);
        rotation.start();

        ObjectAnimator rotation1 = new ObjectAnimator().ofFloat(tuoxiang, "scaleX", 1, 2);
        rotation1.setDuration(2000);
        rotation1.start();

        ObjectAnimator rotation2 = new ObjectAnimator().ofFloat(tuoxiang, "scaleY", 1, 2);
        rotation2.setDuration(2000);
        rotation2.start();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }


    private void initView(View view) {
        tuoxiang = (ImageView) view.findViewById(R.id.tuoxiang);
    }
}
