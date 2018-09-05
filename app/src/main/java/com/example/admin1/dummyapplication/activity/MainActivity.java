package com.example.admin1.dummyapplication.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin1.dummyapplication.R;
import com.example.admin1.dummyapplication.interfaces.ApiServiceCaller;
import com.example.admin1.dummyapplication.utility.App;
import com.example.admin1.dummyapplication.webservice.ApiConstants;
import com.example.admin1.dummyapplication.webservice.JsonResponse;
import com.example.admin1.dummyapplication.webservice.WebRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements ApiServiceCaller, View.OnClickListener {




    Context context;

    EditText edtUserName, edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        context = this;
        edtUserName = findViewById(R.id.edt_user_name);
        edtPassword = findViewById(R.id.edt_password);

        btnLogin = findViewById(R.id.btn);
        btnLogin.setOnClickListener(this);


    }

    private void performLogin() {
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("username", edtUserName.getText().toString());
                jsonObject.put("password", edtPassword.getText().toString());
                JsonObjectRequest request = WebRequest.callPostMethod(context, "", jsonObject, Request.Method.POST, ApiConstants.LOGIN_URL,
                        ApiConstants.REQUEST_LOGIN, this, "");
                App.getInstance().addToRequestQueue(request, ApiConstants.REQUEST_LOGIN);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @Override
    public void onAsyncSuccess(JsonResponse jsonResponse, String label) {
        switch (label) {
            case ApiConstants.REQUEST_LOGIN: {
                if (jsonResponse != null) {
                    if (jsonResponse.result != null && jsonResponse.result.equals(JsonResponse.SUCCESS)) {
                        if (jsonResponse.user_info != null) {
                            Log.d("asasasas","ss: sucessssssssss");
                            Log.i("cheqq",jsonResponse.user_info.get(0).getConsumerAddress());
                            Log.i("cheqq11",jsonResponse.user_info.get(0).getConsumerName());

                        }
                    } else if (jsonResponse.result != null && jsonResponse.result.equals(JsonResponse.FAILTURE)) {
                        Toast.makeText(context, jsonResponse.message, Toast.LENGTH_SHORT).show();
                    }
                }

            }
            break;
        }
        }

    @Override
    public void onAsyncFail(String message, String label, NetworkResponse response) {
        Log.d("asasasas","ss: fail1");
    }

    @Override
    public void onAsyncCompletelyFail(String message, String label) {
        Log.d("asasasas","ss: fail2");
    }

    @Override
    public void onClick(View v) {
        if(v == btnLogin)
            performLogin();
    }
}
