package com.uxcam.internals;

import android.graphics.Bitmap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class al {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f12997c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static al f12998d;

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentLinkedQueue<Bitmap> f12999a = new ConcurrentLinkedQueue<>();

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f13000b;

    public static al a() {
        if (f12998d == null) {
            synchronized (f12997c) {
                if (f12998d == null) {
                    f12998d = new al();
                }
            }
        }
        return f12998d;
    }

    public void a(Bitmap bitmap) {
        this.f13000b = bitmap;
        this.f12999a.add(bitmap);
    }
}
