package com.barclays.webpage.barclaysweb.controllers;
import java.util.HashMap;
import java.util.Map;

public class Response {
    static public Map<String, Object> getResponse(Boolean state, Object data, int errNum) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> meta = new HashMap<>();

        meta.put("copyright", "Copyright 2015 Example Corp.");
        meta.put("authors", "[Federico Wagner]");
        meta.put("status", state);

        response.put("meta", meta);
        if(data != null) response.put("data",data);

        Map<String, Object> error = new HashMap<>();
        error.put("err_number", errNum);
        error.put("message", getErrMsg(errNum));

        if(errNum != 0) response.put("error",error);

        return response;
    }

    static private String getErrMsg(int Err){
        String msg;
        switch (Err){
            case 0:
                msg = "No presence of errors";
                break;
            case 100:
                msg = "Some fields are missing or password mismatch";
                break;
            case 200:
                msg = "Email is already registered";
                break;
            case 300:
                msg = "User or password are incorrect";
                break;
            case 400:
                msg = "Bad data integrity - User not modified";
                break;
            case 500:
                msg = "User not found";
                break;
            default:
                msg = "Error Code does not exist";
                break;
        }
        return msg;
    }
}
