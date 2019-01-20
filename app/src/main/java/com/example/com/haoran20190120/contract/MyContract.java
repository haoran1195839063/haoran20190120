package com.example.com.haoran20190120.contract;

import com.example.com.haoran20190120.model.MyModel;

public interface MyContract {

    interface CartModel {
        void getData(MyModel.ModelCallBack modelCallBack);
    }

    interface CartView {
        void success(String data);

        void error(String error);
    }

}
