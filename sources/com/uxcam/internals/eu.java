package com.uxcam.internals;

import java.util.ArrayList;

public class eu {

    /* renamed from: a  reason: collision with root package name */
    public final int f13295a;

    /* renamed from: b  reason: collision with root package name */
    public final float f13296b;

    /* renamed from: c  reason: collision with root package name */
    public final int f13297c;

    /* renamed from: d  reason: collision with root package name */
    public final aa f13298d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f13299e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public int f13300f;

    public interface aa {
    }

    public eu(int i11, float f11, int i12, aa aaVar) {
        this.f13295a = i11;
        this.f13296b = f11;
        this.f13297c = i12;
        this.f13298d = aaVar;
    }

    public final void a(cq cqVar) {
        this.f13299e.add(cqVar);
        int i11 = cqVar.f13153b;
        if (i11 == 0) {
            this.f13300f++;
        } else if (i11 == 1) {
            this.f13300f += 2;
        }
    }
}
