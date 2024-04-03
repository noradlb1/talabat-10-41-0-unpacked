package com.huawei.agconnect.https.adapter;

import com.huawei.agconnect.https.Adapter;
import java.io.IOException;
import okhttp3.ResponseBody;
import org.json.JSONException;

public class c<T> implements Adapter<ResponseBody, T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f47635a;

    public c(Class<T> cls) {
        this.f47635a = cls;
    }

    /* renamed from: a */
    public T adapter(ResponseBody responseBody) throws IOException {
        if (responseBody != null) {
            try {
                return JSONDecodeUtil.getObject(responseBody.string(), this.f47635a);
            } catch (JSONException unused) {
                throw new IOException("the response is not json");
            } catch (IllegalAccessException e11) {
                throw new IOException("IllegalAccessException:", e11);
            } catch (InstantiationException e12) {
                throw new IOException("InstantiationException", e12);
            }
        } else {
            throw new IOException("responseBody is null");
        }
    }
}
