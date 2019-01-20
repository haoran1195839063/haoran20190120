package com.example.com.haoran20190120.presenter;

import com.example.com.haoran20190120.contract.MyContract;
import com.example.com.haoran20190120.model.MyModel;

public class MyPresenter {
    private MyModel model;
    private MyContract.CartView view;

    public MyPresenter( MyContract.CartView view) {
        this.model = new MyModel();
        this.view = view;
    }

    public void getPresenter() {
        model.getData(new MyModel.ModelCallBack() {
            @Override
            public void success(String success1) {
                view.success(success1);
            }

            @Override
            public void error(String error) {
                view.error(error);
            }
        });
    }


}