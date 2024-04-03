package com.huawei.agconnect.https;

import com.huawei.agconnect.https.Adapter;
import com.huawei.agconnect.https.adapter.StringAdapterFactory;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpsResult {
    Response rawResponse;

    public HttpsResult(boolean z11, int i11, Response response) {
        this.rawResponse = response;
    }

    public int code() {
        Response response = this.rawResponse;
        if (response != null) {
            return response.code();
        }
        return -1;
    }

    public String getErrorMsg() {
        if (isSuccess()) {
            return null;
        }
        Response response = this.rawResponse;
        return response == null ? "rawResponse is null" : response.message();
    }

    public <T> T getResponse(Class<T> cls, Adapter.Factory factory) {
        Adapter<ResponseBody, T> responseBodyAdapter = factory == null ? new StringAdapterFactory().responseBodyAdapter(cls) : factory.responseBodyAdapter(cls);
        if (responseBodyAdapter != null) {
            try {
                T adapter = responseBodyAdapter.adapter(this.rawResponse.body());
                if (adapter != null) {
                    return adapter;
                }
                try {
                    return cls.newInstance();
                } catch (IllegalAccessException e11) {
                    throw new RuntimeException(e11);
                } catch (InstantiationException e12) {
                    throw new RuntimeException(e12);
                }
            } catch (IOException e13) {
                throw new RuntimeException(e13);
            } catch (Throwable th2) {
                try {
                    cls.newInstance();
                    throw th2;
                } catch (IllegalAccessException e14) {
                    throw new RuntimeException(e14);
                } catch (InstantiationException e15) {
                    throw new RuntimeException(e15);
                }
            }
        } else {
            throw new IllegalArgumentException("ResponseBodyAdapter should not be null.");
        }
    }

    public String getResponse() {
        try {
            Response response = this.rawResponse;
            return (response == null || response.body() == null) ? "" : this.rawResponse.body().string();
        } catch (IOException unused) {
            return "";
        }
    }

    public boolean isSuccess() {
        Response response = this.rawResponse;
        return response != null && response.isSuccessful();
    }
}
