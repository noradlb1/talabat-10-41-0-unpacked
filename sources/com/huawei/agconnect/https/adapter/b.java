package com.huawei.agconnect.https.adapter;

import com.huawei.agconnect.https.Adapter;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONException;

public class b<Request> implements Adapter<Request, RequestBody> {

    /* renamed from: a  reason: collision with root package name */
    private static final MediaType f47634a = MediaType.parse("application/json; charset=UTF-8");

    /* renamed from: a */
    public RequestBody adapter(Request request) throws IOException {
        try {
            return RequestBody.create(f47634a, new JSONEncodeUtil().toJson(request));
        } catch (JSONException e11) {
            throw new IOException(e11);
        }
    }
}
