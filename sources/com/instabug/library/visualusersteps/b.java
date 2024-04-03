package com.instabug.library.visualusersteps;

import androidx.annotation.NonNull;

public class b implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    private String f52139a;

    /* renamed from: b  reason: collision with root package name */
    private float f52140b;

    /* renamed from: c  reason: collision with root package name */
    private float f52141c;

    public b(String str, float f11, float f12) {
        this.f52139a = str;
        this.f52140b = f12;
        this.f52141c = f11;
    }

    private float a() {
        return (float) Math.sqrt((double) ((d() * d()) + (b() * b())));
    }

    public float b() {
        return this.f52140b;
    }

    public String c() {
        return this.f52139a;
    }

    public float d() {
        return this.f52141c;
    }

    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        if (a() > bVar.a()) {
            return 1;
        }
        a();
        bVar.a();
        return -1;
    }
}
