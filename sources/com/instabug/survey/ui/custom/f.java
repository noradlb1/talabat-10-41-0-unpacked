package com.instabug.survey.ui.custom;

import android.util.Log;

public enum f {
    Left(0),
    Right(1);
    

    /* renamed from: e  reason: collision with root package name */
    public int f52471e;

    private f(int i11) {
        this.f52471e = i11;
    }

    public static f a(int i11) {
        for (f fVar : values()) {
            if (fVar.f52471e == i11) {
                return fVar;
            }
        }
        Log.w("RatingView", String.format("Gravity chosen is neither 'left' nor 'right', I will set it to Left", new Object[0]));
        return Left;
    }
}
