package com.example.com.haoran20190120.model;

import com.example.com.haoran20190120.contract.MyContract;
import com.example.com.haoran20190120.util.Util;

public class MyModel implements MyContract.CartModel {
    @Override
    public void getData(ModelCallBack modelCallBack) {
        Util util = new Util();
        util.getData(modelCallBack);
    }

    public interface ModelCallBack {
        void success(String success);

        void error(String error);
    }
}
