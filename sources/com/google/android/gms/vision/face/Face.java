package com.google.android.gms.vision.face;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

public class Face {
    public static final float UNCOMPUTED_PROBABILITY = -1.0f;
    private float height;

    /* renamed from: id  reason: collision with root package name */
    private int f44513id;
    private float width;
    private PointF zzby;
    private float zzbz;
    private float zzca;
    private float zzcb;
    private List<Landmark> zzcc;
    private final List<Contour> zzcd;
    private float zzce;
    private float zzcf;
    private float zzcg;
    private final float zzch;

    public Face(int i11, PointF pointF, float f11, float f12, float f13, float f14, float f15, Landmark[] landmarkArr, Contour[] contourArr, float f16, float f17, float f18, float f19) {
        this.f44513id = i11;
        this.zzby = pointF;
        this.width = f11;
        this.height = f12;
        this.zzbz = f13;
        this.zzca = f14;
        this.zzcb = f15;
        this.zzcc = Arrays.asList(landmarkArr);
        this.zzcd = Arrays.asList(contourArr);
        this.zzce = zza(f16);
        this.zzcf = zza(f17);
        this.zzcg = zza(f18);
        this.zzch = zza(f19);
    }

    private static float zza(float f11) {
        if (f11 < 0.0f || f11 > 1.0f) {
            return -1.0f;
        }
        return f11;
    }

    public List<Contour> getContours() {
        return this.zzcd;
    }

    public float getEulerY() {
        return this.zzbz;
    }

    public float getEulerZ() {
        return this.zzca;
    }

    public float getHeight() {
        return this.height;
    }

    public int getId() {
        return this.f44513id;
    }

    public float getIsLeftEyeOpenProbability() {
        return this.zzce;
    }

    public float getIsRightEyeOpenProbability() {
        return this.zzcf;
    }

    public float getIsSmilingProbability() {
        return this.zzcg;
    }

    public List<Landmark> getLandmarks() {
        return this.zzcc;
    }

    public PointF getPosition() {
        PointF pointF = this.zzby;
        return new PointF(pointF.x - (this.width / 2.0f), pointF.y - (this.height / 2.0f));
    }

    public float getWidth() {
        return this.width;
    }
}
