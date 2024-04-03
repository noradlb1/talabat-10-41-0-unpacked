package com.huawei.hms.dtm.core.util;

import android.app.Activity;
import java.util.Iterator;
import java.util.LinkedList;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final c f48621a = new c();

    /* renamed from: b  reason: collision with root package name */
    private LinkedList<a> f48622b = new LinkedList<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Activity f48623a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f48624b;

        public a(Activity activity, boolean z11) {
            this.f48623a = activity;
            this.f48624b = z11;
        }

        public Activity a() {
            return this.f48623a;
        }

        public void a(boolean z11) {
            this.f48624b = z11;
        }

        public boolean b() {
            return this.f48624b;
        }
    }

    private c() {
    }

    public static c a() {
        return f48621a;
    }

    public void a(Activity activity) {
        synchronized (this) {
            Iterator<a> it = this.f48622b.iterator();
            while (it.hasNext()) {
                if (activity == it.next().a()) {
                    it.remove();
                }
            }
        }
    }

    public void a(Activity activity, boolean z11) {
        synchronized (this) {
            this.f48622b.push(new a(activity, z11));
        }
    }

    public Activity b() {
        synchronized (this) {
            if (this.f48622b.isEmpty()) {
                Activity a11 = f.a();
                return a11;
            }
            Iterator<a> it = this.f48622b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.b()) {
                    Activity a12 = next.a();
                    return a12;
                }
            }
            return null;
        }
    }

    public void b(Activity activity, boolean z11) {
        LinkedList<a> linkedList = this.f48622b;
        if (linkedList != null && !linkedList.isEmpty() && activity != null) {
            Iterator<a> it = this.f48622b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (!(next == null || next.a() == null || activity != next.a())) {
                    next.a(z11);
                }
            }
        }
    }
}
