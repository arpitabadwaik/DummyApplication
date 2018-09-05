package com.example.admin1.dummyapplication.webservice;

import com.example.admin1.dummyapplication.model.JsonGsonModel;

import java.util.ArrayList;

public class JsonResponse {

       //Message and Success
        public String result;
        public static String SUCCESS = "success";
        public static String FAILTURE = "failure";
        public String message = "message";

        //ArrayList's Models
        public ArrayList<JsonGsonModel> user_info;

}
