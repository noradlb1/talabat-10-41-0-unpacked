package com.apptimize;

import android.os.Looper;
import java.util.concurrent.CountDownLatch;

public class ah extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private static final String f41099a = "ah";

    /* renamed from: b  reason: collision with root package name */
    private final CountDownLatch f41100b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    private Looper f41101c;

    private ah() {
        super("MessengerThread");
    }

    public static ah a() {
        ah ahVar = new ah();
        ahVar.c();
        return ahVar;
    }

    private void c() {
        start();
        try {
            this.f41100b.await();
        } catch (InterruptedException unused) {
        }
        String str = f41099a;
        bo.a(str, "looper " + this.f41101c);
    }

    public Looper b() {
        return this.f41101c;
    }

    public void run() {
        Looper.prepare();
        this.f41101c = Looper.myLooper();
        this.f41100b.countDown();
        Looper.loop();
    }
}
