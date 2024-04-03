package com.uxcam.internals;

import java.util.ArrayList;
import java.util.Iterator;

public class cq {

    /* renamed from: a  reason: collision with root package name */
    public String f13152a;

    /* renamed from: b  reason: collision with root package name */
    public int f13153b;

    /* renamed from: c  reason: collision with root package name */
    public float f13154c;

    /* renamed from: d  reason: collision with root package name */
    public int f13155d;

    /* renamed from: e  reason: collision with root package name */
    public int f13156e;

    /* renamed from: f  reason: collision with root package name */
    public int f13157f;

    /* renamed from: g  reason: collision with root package name */
    public int f13158g;

    /* renamed from: h  reason: collision with root package name */
    public int f13159h;

    /* renamed from: i  reason: collision with root package name */
    public Boolean f13160i = Boolean.FALSE;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13161j = false;

    /* renamed from: k  reason: collision with root package name */
    public boolean f13162k = false;

    /* renamed from: l  reason: collision with root package name */
    public fi f13163l;

    /* renamed from: m  reason: collision with root package name */
    public ArrayList f13164m = new ArrayList();

    public cq() {
    }

    public void a(float f11) {
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        this.f13154c = f11;
    }

    public boolean b() {
        int i11 = this.f13153b;
        return i11 == 4 || i11 == 5 || i11 == 2 || i11 == 3;
    }

    public void c() {
        Iterator it = this.f13164m.iterator();
        while (it.hasNext()) {
            ((cq) it.next()).f13153b = 2;
        }
        if (!this.f13164m.isEmpty()) {
            ((cq) this.f13164m.get(0)).f13153b = 1;
            ArrayList arrayList = this.f13164m;
            ((cq) arrayList.get(arrayList.size() - 1)).f13153b = 3;
        }
    }

    public String toString() {
        Object obj;
        StringBuilder a11 = hl.a("gesture: ");
        a11.append(this.f13153b);
        a11.append(" x: ");
        a11.append(this.f13155d);
        a11.append(" y: ");
        a11.append(this.f13156e);
        a11.append(" time: ");
        a11.append(this.f13154c);
        a11.append(" responsive: ");
        a11.append(this.f13160i);
        a11.append(" screenAction: ");
        fi fiVar = this.f13163l;
        if (fiVar == null) {
            obj = "";
        } else {
            obj = fiVar.a();
        }
        a11.append(obj);
        return a11.toString();
    }

    public cq a() {
        return new cq(this.f13153b, this.f13154c, this.f13155d, this.f13156e, this.f13157f, this.f13158g, this.f13159h, this.f13160i, this.f13161j);
    }

    public cq(int i11, float f11, int i12, int i13, int i14, int i15) {
        this.f13153b = i11;
        this.f13154c = f11;
        this.f13155d = i12;
        this.f13156e = i13;
        this.f13157f = i14;
        this.f13158g = i15;
    }

    public cq(int i11, float f11, int i12, int i13, int i14, int i15, int i16, Boolean bool, boolean z11) {
        this.f13153b = i11;
        this.f13154c = f11;
        this.f13155d = i12;
        this.f13156e = i13;
        this.f13158g = i15;
        this.f13157f = i14;
        this.f13159h = i16;
        this.f13160i = bool;
        this.f13161j = z11;
    }
}
