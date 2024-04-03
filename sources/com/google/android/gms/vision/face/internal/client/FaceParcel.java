package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@UsedByNative("wrapper.cc")
@SafeParcelable.Class(creator = "FaceParcelCreator")
public class FaceParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FaceParcel> CREATOR = new zzd();
    @SafeParcelable.Field(id = 3)
    public final float centerX;
    @SafeParcelable.Field(id = 4)
    public final float centerY;
    @SafeParcelable.Field(id = 6)
    public final float height;
    @SafeParcelable.Field(id = 2)

    /* renamed from: id  reason: collision with root package name */
    public final int f44514id;
    @SafeParcelable.VersionField(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(id = 5)
    public final float width;
    @SafeParcelable.Field(id = 10)
    public final float zzce;
    @SafeParcelable.Field(id = 11)
    public final float zzcf;
    @SafeParcelable.Field(id = 12)
    public final float zzcg;
    @SafeParcelable.Field(defaultValue = "-1.0f", id = 15)
    public final float zzch;
    @SafeParcelable.Field(defaultValue = "3.4028235E38f", id = 7)
    public final float zzcz;
    @SafeParcelable.Field(defaultValue = "3.4028235E38f", id = 8)
    public final float zzda;
    @SafeParcelable.Field(defaultValue = "3.4028235E38f", id = 14)
    public final float zzdb;
    @SafeParcelable.Field(id = 9)
    public final LandmarkParcel[] zzdc;
    @SafeParcelable.Field(id = 13)
    public final zza[] zzdd;

    @SafeParcelable.Constructor
    public FaceParcel(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) float f11, @SafeParcelable.Param(id = 4) float f12, @SafeParcelable.Param(id = 5) float f13, @SafeParcelable.Param(id = 6) float f14, @SafeParcelable.Param(id = 7) float f15, @SafeParcelable.Param(id = 8) float f16, @SafeParcelable.Param(id = 14) float f17, @SafeParcelable.Param(id = 9) LandmarkParcel[] landmarkParcelArr, @SafeParcelable.Param(id = 10) float f18, @SafeParcelable.Param(id = 11) float f19, @SafeParcelable.Param(id = 12) float f21, @SafeParcelable.Param(id = 13) zza[] zzaArr, @SafeParcelable.Param(id = 15) float f22) {
        this.versionCode = i11;
        this.f44514id = i12;
        this.centerX = f11;
        this.centerY = f12;
        this.width = f13;
        this.height = f14;
        this.zzcz = f15;
        this.zzda = f16;
        this.zzdb = f17;
        this.zzdc = landmarkParcelArr;
        this.zzce = f18;
        this.zzcf = f19;
        this.zzcg = f21;
        this.zzdd = zzaArr;
        this.zzch = f22;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.f44514id);
        SafeParcelWriter.writeFloat(parcel, 3, this.centerX);
        SafeParcelWriter.writeFloat(parcel, 4, this.centerY);
        SafeParcelWriter.writeFloat(parcel, 5, this.width);
        SafeParcelWriter.writeFloat(parcel, 6, this.height);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzcz);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzda);
        SafeParcelWriter.writeTypedArray(parcel, 9, this.zzdc, i11, false);
        SafeParcelWriter.writeFloat(parcel, 10, this.zzce);
        SafeParcelWriter.writeFloat(parcel, 11, this.zzcf);
        SafeParcelWriter.writeFloat(parcel, 12, this.zzcg);
        SafeParcelWriter.writeTypedArray(parcel, 13, this.zzdd, i11, false);
        SafeParcelWriter.writeFloat(parcel, 14, this.zzdb);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzch);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @UsedByNative("wrapper.cc")
    public FaceParcel(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) float f11, @SafeParcelable.Param(id = 4) float f12, @SafeParcelable.Param(id = 5) float f13, @SafeParcelable.Param(id = 6) float f14, @SafeParcelable.Param(id = 7) float f15, @SafeParcelable.Param(id = 8) float f16, @SafeParcelable.Param(id = 9) LandmarkParcel[] landmarkParcelArr, @SafeParcelable.Param(id = 10) float f17, @SafeParcelable.Param(id = 11) float f18, @SafeParcelable.Param(id = 12) float f19) {
        this(i11, i12, f11, f12, f13, f14, f15, f16, 0.0f, landmarkParcelArr, f17, f18, f19, new zza[0], -1.0f);
    }
}
