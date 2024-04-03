package com.huawei.agconnect.https.adapter;

import com.huawei.agconnect.https.Adapter;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.json.JSONException;

public class d<HttpsRequest> implements Adapter<HttpsRequest, RequestBody> {
    private String a(final Field field, HttpsRequest httpsrequest) throws IllegalAccessException, JSONException {
        if (!field.isAccessible()) {
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    field.setAccessible(true);
                    return null;
                }
            });
        }
        Class<?> type = field.getType();
        Object obj = field.get(httpsrequest);
        return d(type) ? obj == null ? "0" : String.valueOf(obj) : c(type) ? obj == null ? "0" : String.valueOf(obj) : b(type) ? obj == null ? "false" : String.valueOf(obj) : a((Class) type) ? obj == null ? "0" : String.valueOf(obj) : type == String.class ? obj == null ? "null" : String.valueOf(obj) : new JSONEncodeUtil().toJson(field.get(httpsrequest));
    }

    private void a(Field field, FormBody.Builder builder, HttpsRequest httpsrequest) {
        try {
            String value = ((com.huawei.agconnect.https.annotation.Field) field.getAnnotation(com.huawei.agconnect.https.annotation.Field.class)).value();
            if (value == null || value.isEmpty()) {
                value = field.getName();
            }
            builder.addEncoded(value, a(field, httpsrequest));
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11);
        } catch (JSONException e12) {
            throw new RuntimeException(e12);
        }
    }

    private static boolean a(Class cls) {
        return cls == Long.TYPE || cls == Long.class;
    }

    private static boolean b(Class cls) {
        return cls == Boolean.TYPE || cls == Boolean.class;
    }

    private static boolean c(Class cls) {
        return cls == Double.TYPE || cls == Double.class || cls == Float.TYPE || cls == Float.class;
    }

    private static boolean d(Class cls) {
        return cls == Integer.TYPE || cls == Integer.class;
    }

    /* renamed from: a */
    public RequestBody adapter(HttpsRequest httpsrequest) {
        FormBody.Builder builder = new FormBody.Builder();
        Class cls = httpsrequest.getClass();
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field.isAnnotationPresent(com.huawei.agconnect.https.annotation.Field.class)) {
                        a(field, builder, httpsrequest);
                    }
                }
            }
            cls = cls.getSuperclass();
        } while (cls != Object.class);
        return builder.build();
    }
}
