package com.instabug.library.internal.view.floatingactionbutton;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;

class b extends ShapeDrawable.ShaderFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f51245a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f51246b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f51247c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f51248d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f51249e;

    public b(d dVar, int i11, int i12, int i13, int i14, int i15) {
        this.f51245a = i11;
        this.f51246b = i12;
        this.f51247c = i13;
        this.f51248d = i14;
        this.f51249e = i15;
    }

    public Shader resize(int i11, int i12) {
        float f11 = ((float) i11) / 2.0f;
        return new LinearGradient(f11, 0.0f, f11, (float) i12, new int[]{this.f51245a, this.f51246b, this.f51247c, this.f51248d, this.f51249e}, new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
    }
}
