package com.example.admin1.dummyapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class JsonGsonModel{

    @SerializedName("city")
    public  String city;

    @SerializedName("consumer_name")
    public  String consumerName;

    @SerializedName("alternate_email_id")
    public  String alternateEmail;

    @SerializedName("email_id")
    public  String emailID;

    @SerializedName("contact_no")
    public  String contactNo;

    @SerializedName("consumer_no")
    public  String consumerNo;

    @SerializedName("alternate_contact_no")
    public  String alternateConatctNO;

    @SerializedName("profile_img")
    public  String profileImg;

    @SerializedName("consumerAddress")
    public  String consumerAddress;
    
    public String getCity() {
        return city;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getEmailID() {
        return emailID;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getConsumerNo() {
        return consumerNo;
    }

    public String getAlternateConatctNO() {
        return alternateConatctNO;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public String getConsumerAddress() {
        return consumerAddress;
    }
}
