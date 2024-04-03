package com.uxcam.internals;

import android.opengl.GLES20;

public class cn {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f13148a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    public int f13149b;

    /* renamed from: c  reason: collision with root package name */
    public int f13150c;

    /* renamed from: d  reason: collision with root package name */
    public fw f13151d;

    public cn(int i11, int i12) {
        this.f13149b = i11;
        this.f13150c = i12;
    }

    public static int a(int i11, String str) {
        int glCreateShader = GLES20.glCreateShader(i11);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }
}
