package com.apptimize;

import android.view.View;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class hj<S, T, V> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42943a = "hj";

    /* renamed from: b  reason: collision with root package name */
    private String f42944b;

    /* renamed from: c  reason: collision with root package name */
    private hm<S> f42945c;

    /* renamed from: d  reason: collision with root package name */
    private jj<S, T> f42946d;

    /* renamed from: e  reason: collision with root package name */
    private iw<T, V> f42947e;

    /* renamed from: f  reason: collision with root package name */
    private List<Method> f42948f = new ArrayList();

    private hj(String str, hm<S> hmVar, jj<S, T> jjVar, iw<T, V> iwVar) {
        this.f42944b = str;
        this.f42945c = hmVar;
        this.f42946d = jjVar;
        this.f42947e = iwVar;
    }

    public static <S, T, V> hj<S, T, V> a(String str, hm<S> hmVar, jj<S, T> jjVar, iw<T, V> iwVar) {
        return new hj<>(str, hmVar, jjVar, iwVar);
    }

    public jj<S, T> b() {
        return this.f42946d;
    }

    public iw<T, V> c() {
        return this.f42947e;
    }

    public List<Method> d() {
        return Collections.unmodifiableList(this.f42948f);
    }

    public String toString() {
        return this.f42944b + " type:" + this.f42945c;
    }

    public static <V> hj<Number, Integer, V> a(String str, ho hoVar, iw<Integer, V> iwVar) {
        return a(str, hoVar, new jh(hoVar.b()), iwVar);
    }

    public JSONObject b(View view) throws JSONException, hk {
        Object a11 = a(view);
        if (a11 == null) {
            return null;
        }
        return this.f42945c.a(this.f42944b, a11);
    }

    public static <V> hj<Number, Integer, V> a(String str, ho hoVar, Class<V> cls) {
        return a(str, hoVar, iu.a(cls, Integer.TYPE, str));
    }

    public String a() {
        return this.f42944b;
    }

    public S a(View view) throws JSONException, hk {
        if (this.f42947e.b().isInstance(view)) {
            jj<S, T> jjVar = this.f42946d;
            iw<T, V> iwVar = this.f42947e;
            return jjVar.b(iwVar.a(iwVar.b().cast(view)));
        }
        throw new JSONException(String.format("getJSONValue for property %s expects view of type %s; received %s", new Object[]{this.f42944b, this.f42947e.b(), view}));
    }

    public void a(View view, Object obj) {
        try {
            Class<S> a11 = this.f42945c.a();
            if (!a11.isInstance(obj)) {
                throw new JSONException(String.format("Property %s expected value of type %s from frontend; received %s of type %s", new Object[]{this.f42944b, this.f42945c.a(), obj, obj.getClass()}));
            } else if (this.f42947e.b().isInstance(view)) {
                iw<T, V> iwVar = this.f42947e;
                iwVar.a(iwVar.b().cast(view), this.f42946d.a(a11.cast(obj)));
            } else {
                throw new JSONException(String.format("Property %s expected view of type %s; received %s", new Object[]{this.f42944b, this.f42947e.b(), view}));
            }
        } catch (JSONException e11) {
            bo.f(f42943a, String.format("Error when setting property %s", new Object[]{this.f42944b}), e11);
        } catch (hk e12) {
            bo.f(f42943a, String.format("Error when setting property %s", new Object[]{this.f42944b}), e12);
        }
    }

    public void a(Method method) {
        this.f42948f.add(method);
    }

    public hj a(hl hlVar, Method method) {
        hlVar.a((hj<?, ?, ?>) this, method);
        return this;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r2 = f42943a;
        com.apptimize.bo.e(r2, "Could not find method " + r3 + " on class " + r1.f42947e.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        com.apptimize.gn.x();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.apptimize.hj a(com.apptimize.hl r2, java.lang.String r3, java.lang.Class<?>... r4) {
        /*
            r1 = this;
            boolean r0 = com.apptimize.gn.w()
            if (r0 == 0) goto L_0x0042
            com.apptimize.iw<T, V> r0 = r1.f42947e     // Catch:{ NoSuchMethodException -> 0x0019 }
            java.lang.Class r0 = r0.b()     // Catch:{ NoSuchMethodException -> 0x0019 }
            java.lang.reflect.Method r4 = r0.getDeclaredMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0019 }
            r1.a((com.apptimize.hl) r2, (java.lang.reflect.Method) r4)     // Catch:{ NoSuchMethodException -> 0x0019 }
        L_0x0013:
            com.apptimize.gn.x()
            goto L_0x0042
        L_0x0017:
            r2 = move-exception
            goto L_0x003e
        L_0x0019:
            java.lang.String r2 = f42943a     // Catch:{ all -> 0x0017 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0017 }
            r4.<init>()     // Catch:{ all -> 0x0017 }
            java.lang.String r0 = "Could not find method "
            r4.append(r0)     // Catch:{ all -> 0x0017 }
            r4.append(r3)     // Catch:{ all -> 0x0017 }
            java.lang.String r3 = " on class "
            r4.append(r3)     // Catch:{ all -> 0x0017 }
            com.apptimize.iw<T, V> r3 = r1.f42947e     // Catch:{ all -> 0x0017 }
            java.lang.Class r3 = r3.b()     // Catch:{ all -> 0x0017 }
            r4.append(r3)     // Catch:{ all -> 0x0017 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0017 }
            com.apptimize.bo.e(r2, r3)     // Catch:{ all -> 0x0017 }
            goto L_0x0013
        L_0x003e:
            com.apptimize.gn.x()
            throw r2
        L_0x0042:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.hj.a(com.apptimize.hl, java.lang.String, java.lang.Class[]):com.apptimize.hj");
    }
}
