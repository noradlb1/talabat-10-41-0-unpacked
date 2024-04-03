package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

abstract class Action<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Picasso f53358a;

    /* renamed from: b  reason: collision with root package name */
    public final Request f53359b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<T> f53360c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f53361d;

    /* renamed from: e  reason: collision with root package name */
    public final int f53362e;

    /* renamed from: f  reason: collision with root package name */
    public final int f53363f;

    /* renamed from: g  reason: collision with root package name */
    public final int f53364g;

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f53365h;

    /* renamed from: i  reason: collision with root package name */
    public final String f53366i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f53367j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f53368k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f53369l;

    public static class RequestWeakReference<M> extends WeakReference<M> {

        /* renamed from: a  reason: collision with root package name */
        public final Action f53370a;

        public RequestWeakReference(Action action, M m11, ReferenceQueue<? super M> referenceQueue) {
            super(m11, referenceQueue);
            this.f53370a = action;
        }
    }

    public Action(Picasso picasso, T t11, Request request, int i11, int i12, int i13, Drawable drawable, String str, Object obj, boolean z11) {
        RequestWeakReference requestWeakReference;
        this.f53358a = picasso;
        this.f53359b = request;
        if (t11 == null) {
            requestWeakReference = null;
        } else {
            requestWeakReference = new RequestWeakReference(this, t11, picasso.f53439g);
        }
        this.f53360c = requestWeakReference;
        this.f53362e = i11;
        this.f53363f = i12;
        this.f53361d = z11;
        this.f53364g = i13;
        this.f53365h = drawable;
        this.f53366i = str;
        this.f53367j = obj == null ? this : obj;
    }

    public void a() {
        this.f53369l = true;
    }

    public String b() {
        return this.f53366i;
    }

    public int c() {
        return this.f53362e;
    }

    public abstract void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom);

    public int d() {
        return this.f53363f;
    }

    public Picasso e() {
        return this.f53358a;
    }

    public abstract void error(Exception exc);

    public Picasso.Priority f() {
        return this.f53359b.priority;
    }

    public Request g() {
        return this.f53359b;
    }

    public Object h() {
        return this.f53367j;
    }

    public T i() {
        WeakReference<T> weakReference = this.f53360c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean j() {
        return this.f53369l;
    }

    public boolean k() {
        return this.f53368k;
    }
}
