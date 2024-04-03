package com.apptimize;

import android.widget.TextView;
import java.lang.reflect.Method;

public abstract class iv implements iw<Integer, TextView> {

    /* renamed from: a  reason: collision with root package name */
    public static final iv f43083a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final iv f43084b = new b();

    /* access modifiers changed from: private */
    public static void b(TextView textView, int i11, int i12) {
        textView.setGravity((i11 & i12) | (textView.getGravity() & (~i12)));
    }

    public static class a extends iv {
        private a() {
        }

        public Class<TextView> b() {
            return TextView.class;
        }

        public Method a() throws NoSuchMethodException {
            return TextView.class.getMethod("setGravity", new Class[]{Integer.TYPE});
        }

        public void a(TextView textView, Integer num) {
            iv.b(textView, num.intValue(), 7);
        }

        public Integer a(TextView textView) {
            return Integer.valueOf(textView.getGravity() & 7);
        }
    }

    public static class b extends iv {
        private b() {
        }

        public Class<TextView> b() {
            return TextView.class;
        }

        public Method a() throws NoSuchMethodException {
            return TextView.class.getMethod("setGravity", new Class[]{Integer.TYPE});
        }

        public void a(TextView textView, Integer num) {
            iv.b(textView, num.intValue(), 112);
        }

        public Integer a(TextView textView) {
            return Integer.valueOf(textView.getGravity() & 112);
        }
    }
}
