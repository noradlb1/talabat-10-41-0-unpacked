package com.apptimize;

import com.deliveryhero.chatsdk.util.PushNotificationParser;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41315a = "b";

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f41316b;

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f41317c;

    /* renamed from: d  reason: collision with root package name */
    private Class<?> f41318d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f41319e;

    /* renamed from: f  reason: collision with root package name */
    private final Method f41320f;

    /* renamed from: g  reason: collision with root package name */
    private final Method f41321g;

    /* renamed from: h  reason: collision with root package name */
    private final a f41322h;

    /* renamed from: i  reason: collision with root package name */
    private final int f41323i;

    /* renamed from: j  reason: collision with root package name */
    private final List<Object> f41324j = new ArrayList<Object>() {
        {
            add(new Object() {
            });
            add(new Object() {
            });
            add(new Object() {
            });
            add(new Object() {
            });
            add(new Object() {
            });
        }
    };

    public interface a {
        void a(String str, Object obj);
    }

    public b(Class<?> cls, Class<?> cls2, String str, Method method, Method method2, a aVar) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        this.f41316b = cls;
        this.f41317c = cls2;
        this.f41319e = method;
        this.f41320f = method2;
        this.f41322h = aVar;
        this.f41318d = Class.forName("com.urbanairship.push.PushManager");
        this.f41321g = cls.getDeclaredMethod("getPushManager", new Class[0]);
        String[] split = str.split("\\.");
        if (split.length == 0) {
            bo.g(f41315a, "Cannot parse Airship Version");
            this.f41323i = -1;
        } else {
            this.f41323i = Integer.parseInt(split[0]);
        }
        f();
    }

    private void b() {
        String str;
        int i11 = this.f41323i;
        if (i11 <= 14) {
            str = c();
        } else if (i11 <= 16) {
            str = d();
        } else {
            str = null;
        }
        if (str != null) {
            this.f41322h.a("named_user_id", str);
        }
    }

    private String c() {
        try {
            return (String) Class.forName("com.urbanairship.channel.NamedUser").getDeclaredMethod("getId", new Class[0]).invoke(this.f41316b.getDeclaredMethod("getNamedUser", new Class[0]).invoke(this.f41319e.invoke((Object) null, new Object[0]), new Object[0]), new Object[0]);
        } catch (Exception e11) {
            String str = f41315a;
            bo.k(str, "Failed to fetch named user id " + e11.getMessage());
            return null;
        }
    }

    private String d() {
        try {
            return (String) Class.forName("com.urbanairship.contacts.Contact").getDeclaredMethod("getNamedUserId", new Class[0]).invoke(this.f41316b.getDeclaredMethod("getContact", new Class[0]).invoke(this.f41319e.invoke((Object) null, new Object[0]), new Object[0]), new Object[0]);
        } catch (Exception e11) {
            String str = f41315a;
            bo.k(str, "Failed to fetch contact user id " + e11.getMessage());
            return null;
        }
    }

    private void e() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object invoke = this.f41320f.invoke(this.f41319e.invoke((Object) null, new Object[0]), new Object[0]);
        Object invoke2 = this.f41317c.getDeclaredMethod("getTags", new Class[0]).invoke(invoke, new Object[0]);
        if (invoke2 instanceof Set) {
            this.f41322h.a("channel_tags", invoke2);
        }
        Object invoke3 = this.f41317c.getDeclaredMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
        if (invoke3 instanceof String) {
            this.f41322h.a(PushNotificationParser.CHANNEL_ID_KEY, invoke3);
        }
    }

    private void f() {
        this.f41322h.a("airship_push_status", (Object) null);
    }

    public void a() {
        try {
            b();
            e();
        } catch (Exception e11) {
            String str = f41315a;
            bo.k(str, "Failed to sync with Airship. " + e11.getMessage());
        }
    }
}
