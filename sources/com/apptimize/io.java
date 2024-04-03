package com.apptimize;

import android.graphics.drawable.Drawable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class io {

    /* renamed from: a  reason: collision with root package name */
    private iq f43069a;

    public static class a<E extends io> implements jj<JSONObject, E> {

        /* renamed from: a  reason: collision with root package name */
        private jj<JSONObject, E> f43070a;

        private a(jj<JSONObject, E> jjVar) {
            this.f43070a = jjVar;
        }

        public static <E extends io> a a(jj<JSONObject, E> jjVar) {
            return new a(jjVar);
        }

        public Class<? extends E> b() {
            return this.f43070a.b();
        }

        /* renamed from: a */
        public JSONObject b(E e11) throws JSONException, hk {
            JSONObject b11 = this.f43070a.b(e11);
            e11.a(b11);
            return b11;
        }

        public E a(JSONObject jSONObject) throws JSONException, hk {
            E e11 = (io) this.f43070a.a(jSONObject);
            e11.a(iq.b(jSONObject));
            return e11;
        }

        public Class<JSONObject> a() {
            return JSONObject.class;
        }
    }

    public io(iq iqVar) {
        this.f43069a = iqVar;
    }

    public abstract Drawable a(io ioVar) throws hk;

    public abstract void a(ih ihVar) throws hk;

    public void a(iq iqVar) {
        this.f43069a = iqVar;
    }

    public final Drawable b(io ioVar) throws hk {
        Drawable a11 = a(ioVar);
        if (a11 == null) {
            return null;
        }
        return a(a11);
    }

    public abstract String b();

    public final Object a(Cif ifVar) throws JSONException, hk {
        jj<?, ? extends io> a11 = ifVar.a(b());
        if (a11 == null) {
            throw new hk("Unsupported image tag " + b());
        } else if (a11.b().isInstance(this)) {
            return a(a11);
        } else {
            throw new hk(String.format("Error while serializing %s. Encountered incompatible transformer %sfor tag %s.", new Object[]{this, a11, b()}));
        }
    }

    private <E extends io> Object a(jj<?, E> jjVar) throws JSONException, hk {
        return jjVar.b(jjVar.b().cast(this));
    }

    public void a(JSONObject jSONObject) throws JSONException {
        this.f43069a.a(jSONObject);
    }

    private Drawable a(Drawable drawable) {
        return this.f43069a.c(drawable);
    }
}
