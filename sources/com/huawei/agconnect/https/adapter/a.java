package com.huawei.agconnect.https.adapter;

import com.huawei.agconnect.https.Adapter;
import com.huawei.agconnect.https.annotation.Body;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONException;

public class a<Request> implements Adapter<Request, RequestBody> {

    /* renamed from: a  reason: collision with root package name */
    private static final MediaType f47631a = MediaType.parse("application/json; charset=UTF-8");

    private String a(final Field field, Request request) throws IllegalAccessException, JSONException {
        if (!field.isAccessible()) {
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    field.setAccessible(true);
                    return null;
                }
            });
        }
        Object obj = field.get(request);
        if (obj == null) {
            return null;
        }
        return new JSONEncodeUtil(false).toJson(obj);
    }

    /* renamed from: a */
    public RequestBody adapter(Request request) throws IOException {
        try {
            Class cls = request.getClass();
            String str = null;
            boolean z11 = false;
            while (true) {
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields.length > 0) {
                    int length = declaredFields.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        }
                        Field field = declaredFields[i11];
                        if (field.isAnnotationPresent(Body.class)) {
                            str = a(field, request);
                            z11 = true;
                            break;
                        }
                        i11++;
                    }
                    if (z11) {
                        break;
                    }
                }
                cls = cls.getSuperclass();
                if (cls == Object.class) {
                    break;
                }
            }
            MediaType mediaType = f47631a;
            if (str == null) {
                str = "{}";
            }
            return RequestBody.create(mediaType, str);
        } catch (IllegalAccessException e11) {
            throw new IOException("catch IllegalAccessException:" + e11.getMessage());
        } catch (JSONException e12) {
            throw new IOException("catch JSONException:" + e12.getMessage());
        }
    }
}
