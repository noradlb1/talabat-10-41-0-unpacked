package com.huawei.agconnect.https;

import com.huawei.agconnect.https.annotation.Header;
import com.huawei.agconnect.https.annotation.HeaderMap;
import com.huawei.agconnect.https.annotation.Query;
import com.huawei.agconnect.https.annotation.Url;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.InvalidParameterException;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;

abstract class a<Annotation, Builder> {

    /* renamed from: a  reason: collision with root package name */
    private static c f47624a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static b f47625b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static C0058a f47626c = new C0058a();

    /* renamed from: com.huawei.agconnect.https.a$a  reason: collision with other inner class name */
    public static class C0058a extends a<Header, Request.Builder> {
        public <RequestBean> Request.Builder a(Field field, RequestBean requestbean, Request.Builder builder) {
            if (builder != null) {
                try {
                    a.b(field);
                    Object obj = field.get(requestbean);
                    String value = ((Header) field.getAnnotation(Header.class)).value();
                    if (value.isEmpty()) {
                        value = field.getName();
                    }
                    if (String.class.equals(field.getType())) {
                        String str = (String) obj;
                        if (!h.a(str)) {
                            builder.addHeader(value, str);
                        }
                        return builder;
                    }
                    throw new InvalidParameterException("Header should be the annotation of String type");
                } catch (IllegalAccessException e11) {
                    throw new RuntimeException(e11);
                }
            } else {
                throw new IllegalArgumentException("builder cannot be null");
            }
        }
    }

    public static class b extends a<HeaderMap, Request.Builder> {
        public <RequestBean> Request.Builder a(Field field, RequestBean requestbean, Request.Builder builder) {
            if (builder != null) {
                try {
                    a.b(field);
                    Object obj = field.get(requestbean);
                    if (Map.class.isAssignableFrom(field.getType())) {
                        Map map = (Map) obj;
                        if (map != null && !map.isEmpty()) {
                            for (Map.Entry entry : map.entrySet()) {
                                builder.addHeader((String) entry.getKey(), String.valueOf(entry.getValue()));
                            }
                        }
                        return builder;
                    }
                    throw new InvalidParameterException("HeaderMap should be the annotation of Map type");
                } catch (IllegalAccessException e11) {
                    throw new RuntimeException(e11);
                }
            } else {
                throw new IllegalArgumentException("builder cannot be null");
            }
        }
    }

    public static final class c extends a<Query, HttpUrl.Builder> {
        public <RequestBean> HttpUrl.Builder a(Field field, RequestBean requestbean, HttpUrl.Builder builder) {
            if (builder != null) {
                try {
                    a.b(field);
                    Object obj = field.get(requestbean);
                    if (String.class.equals(field.getType())) {
                        Query query = (Query) field.getAnnotation(Query.class);
                        String value = query.value();
                        boolean encoded = query.encoded();
                        if (value == null || value.isEmpty()) {
                            value = field.getName();
                        }
                        if (obj == null) {
                            obj = "";
                        }
                        if (encoded) {
                            builder.addEncodedQueryParameter(value, String.valueOf(obj));
                        } else {
                            builder.addQueryParameter(value, String.valueOf(obj));
                        }
                        return builder;
                    }
                    throw new InvalidParameterException("QueryHandler should be the annotation of String");
                } catch (IllegalAccessException e11) {
                    throw new RuntimeException(e11);
                }
            } else {
                throw new IllegalArgumentException("builder cannot be null");
            }
        }
    }

    public static final class d extends a<Url, HttpUrl.Builder> {
        public <RequestBean> HttpUrl.Builder a(Field field, RequestBean requestbean, HttpUrl.Builder builder) {
            try {
                if (field.isAnnotationPresent(Url.class)) {
                    a.b(field);
                    Object obj = field.get(requestbean);
                    if (String.class.equals(field.getType())) {
                        String str = (String) obj;
                        if (str != null && !str.isEmpty()) {
                            return HttpUrl.parse(str).newBuilder();
                        }
                        throw new IllegalArgumentException("url cannot be null or empty");
                    }
                    throw new InvalidParameterException("Url should be the annotation of String");
                }
                throw new IllegalArgumentException("field is not Url annotation");
            } catch (IllegalAccessException e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    public static <RequestBean> Request.Builder a(RequestBean requestbean) {
        HttpUrl.Builder b11 = b(requestbean);
        Request.Builder builder = new Request.Builder();
        Class cls = requestbean.getClass();
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    b(field);
                    Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                    for (Annotation annotationType : declaredAnnotations) {
                        Class<? extends Annotation> annotationType2 = annotationType.annotationType();
                        if (Query.class.equals(annotationType2)) {
                            f47624a.a(field, requestbean, b11);
                        } else if (HeaderMap.class.equals(annotationType2)) {
                            f47625b.a(field, requestbean, builder);
                        } else if (Header.class.equals(annotationType2)) {
                            f47626c.a(field, requestbean, builder);
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        } while (cls != Object.class);
        return builder.url(b11.build());
    }

    private static <RequestBean> HttpUrl.Builder b(RequestBean requestbean) {
        ArrayList arrayList = new ArrayList(1);
        Class cls = requestbean.getClass();
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field.isAnnotationPresent(Url.class)) {
                        arrayList.add(field);
                    }
                }
            }
            cls = cls.getSuperclass();
        } while (cls != Object.class);
        if (arrayList.size() == 1) {
            return new d().a((Field) arrayList.get(0), requestbean, (HttpUrl.Builder) null);
        }
        throw new IllegalArgumentException("ONLY ONE String Field can be annotated as Url");
    }

    /* access modifiers changed from: private */
    public static void b(final Field field) {
        if (!field.isAccessible()) {
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    field.setAccessible(true);
                    return null;
                }
            });
        }
    }

    public abstract <RequestBean> Builder a(Field field, RequestBean requestbean, Builder builder);
}
