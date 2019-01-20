package com.example.com.haoran20190120.bean;

import java.util.List;

public class MyBean {

 
    public String msg;
    public String code;
    public List<DataBean> data;


    public static class DataBean {
  
        public String sellerName;
        public String sellerid;
        public List<Data> list;
        public boolean ischecked;

        public static class Data{
            public String title;
            public String images;
            public double price;
            public boolean ischecked;
        }

    }
}
