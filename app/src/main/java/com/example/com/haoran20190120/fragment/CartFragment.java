package com.example.com.haoran20190120.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.com.haoran20190120.R;
import com.example.com.haoran20190120.adapter.CartAdapter;
import com.example.com.haoran20190120.bean.MyBean;
import com.example.com.haoran20190120.contract.MyContract;
import com.example.com.haoran20190120.presenter.MyPresenter;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * A fragment with a Google +1 button.
 */
public class CartFragment extends Fragment implements MyContract.CartView {


    private XRecyclerView xrecyclerview;
    private CheckBox checkall;
    private TextView heji;
    private TextView pay;
    private Button allcheck;
    private MyBean myBean;
    private CartAdapter cartAdapter;
    private double number=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        MyPresenter myPresenter = new MyPresenter(this);
        myPresenter.getPresenter();


        initView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void success(String data) {
        Gson gson = new Gson();
        myBean = gson.fromJson(data, MyBean.class);
        cartAdapter = new CartAdapter(myBean.data, getActivity());
        xrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        xrecyclerview.setAdapter(cartAdapter);
    }

    @Override
    public void error(String error) {

    }

    private void initView(View view) {
        xrecyclerview = (XRecyclerView) view.findViewById(R.id.xrecyclerview);
        checkall = (CheckBox) view.findViewById(R.id.checkall);
        heji = (TextView) view.findViewById(R.id.heji);
        pay = (TextView) view.findViewById(R.id.pay);
        allcheck = view.findViewById(R.id.allcheck);
        //全选按钮
        allcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (MyBean.DataBean datum : myBean.data) {
                    datum.ischecked = true;
                    for (MyBean.DataBean.Data data : datum.list) {
                        data.ischecked = true;
                    }
                }
                cartAdapter.notifyDataSetChanged();
            }
        });
        //全選全不選
        checkall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (MyBean.DataBean datum : myBean.data) {
                        datum.ischecked = true;
                        for (MyBean.DataBean.Data data : datum.list) {
                            data.ischecked = true;
                        }
                    }
                } else {
                    for (MyBean.DataBean datum : myBean.data) {
                        datum.ischecked = false;
                        for (MyBean.DataBean.Data data : datum.list) {
                            data.ischecked = false;
                        }
                    }
                    number=0;
                }
                getsum();
                heji.setText("合计"+number);
                cartAdapter.notifyDataSetChanged();
            }

            private void getsum() {
                for (MyBean.DataBean datum : myBean.data) {
                    for (MyBean.DataBean.Data data : datum.list) {
                        if (data.ischecked){
                            number+=data.price;
                        }
                    }
                }
            }
        });

    }
}
