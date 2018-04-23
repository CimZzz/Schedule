package com.mobile.schedule.base;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by CimZzz on 26/12/2017.<br>
 * Project Name : YIQIMMM<br>
 * Since : YIQIMMM_1.88<br>
 * Description:<br>
 */
public abstract class BaseRequest<T> implements Callback {
    public int code;

    private final WeakReference<RequestCallback<T>> requestCallbackRef;

    protected BaseRequest() {
        this(null);
    }

    protected BaseRequest(RequestCallback<T> callback) {
        this.requestCallbackRef = new WeakReference<>(callback);
    }

    /*重写方法*/
    @Override
    public final void onFailure(Call call, IOException e) {
        RequestCallback<T> requestCallback = requestCallbackRef.get();
        if(requestCallback != null) {
            requestCallback.onFailure(call,e);
            requestCallback.onResult(false,null,null,e);
        }
    }

    @Override
    public final void onResponse(Call call, Response response) throws IOException {
        RequestCallback<T> requestCallback = requestCallbackRef.get();
        if(requestCallback != null) {
            T result = convertResponse2Result(response);
            requestCallback.onSuccess(call, result, response);
            requestCallback.onResult(true,result,response,null);
        }
    }

    /*内部处理方法*/

    //响应体转换为Json对象
    protected final JSONObject getJSONObjectBody(Response response) throws IOException {
        String result = new String(response.body().bytes(),"utf-8");
        return TextUtils.isEmpty(result) ? null : JSONObject.parseObject(result);
    }


    /*抽象方法*/
    public abstract Request generateRequest();
    public abstract T convertResponse2Result(Response response) throws IOException;

    /*可重写方法*/

    public static abstract class RequestCallback<T> {

        protected void onFailure(Call call,IOException e) {

        }

        protected void onSuccess(Call call,T result,Response response) throws IOException {

        }

        protected void onResult(boolean isSuccess,T result,Response response,Exception e) {

        }
    }
}
