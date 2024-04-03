package com.apptimize;

import java.util.ArrayList;

public class fp<T> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f42459a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f42460b = 0;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f42461c;

    public fp(int i11) {
        this.f42461c = new Object[i11];
    }

    private synchronized void c() {
        this.f42460b = 0;
        this.f42459a = false;
    }

    public synchronized void a(T t11) {
        Object[] objArr = this.f42461c;
        int i11 = this.f42460b;
        objArr[i11] = t11;
        int i12 = i11 + 1;
        this.f42460b = i12;
        if (i12 == objArr.length) {
            this.f42459a = true;
            this.f42460b = 0;
        }
    }

    public synchronized ArrayList<T> b() {
        ArrayList<T> a11;
        a11 = a();
        c();
        return a11;
    }

    public synchronized ArrayList<T> a() {
        ArrayList<T> arrayList;
        int i11;
        arrayList = new ArrayList<>();
        boolean z11 = this.f42459a;
        if (z11) {
            int i12 = this.f42460b;
            if (i12 != 0) {
                while (true) {
                    i11 = this.f42460b;
                    if (i12 == i11 - 1) {
                        break;
                    }
                    Object[] objArr = this.f42461c;
                    if (i12 == objArr.length) {
                        if (i11 - 1 == 0) {
                            break;
                        }
                        i12 = 0;
                    }
                    arrayList.add(objArr[i12]);
                    i12++;
                }
                arrayList.add(this.f42461c[i11 - 1]);
            }
        }
        int length = z11 ? this.f42461c.length : this.f42460b;
        for (int i13 = 0; i13 != length; i13++) {
            arrayList.add(this.f42461c[i13]);
        }
        return arrayList;
    }
}
