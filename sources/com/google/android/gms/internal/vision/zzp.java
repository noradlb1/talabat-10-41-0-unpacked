package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.Frame;

@SafeParcelable.Class(creator = "FrameMetadataParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new zzo();
    @SafeParcelable.Field(id = 3)
    public int height;
    @SafeParcelable.Field(id = 4)

    /* renamed from: id  reason: collision with root package name */
    public int f44504id;
    @SafeParcelable.Field(id = 6)
    public int rotation;
    @SafeParcelable.Field(id = 2)
    public int width;
    @SafeParcelable.Field(id = 5)
    public long zzar;

    public zzp() {
    }

    public static zzp zzc(Frame frame) {
        zzp zzp = new zzp();
        zzp.width = frame.getMetadata().getWidth();
        zzp.height = frame.getMetadata().getHeight();
        zzp.rotation = frame.getMetadata().getRotation();
        zzp.f44504id = frame.getMetadata().getId();
        zzp.zzar = frame.getMetadata().getTimestampMillis();
        return zzp;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.width);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.f44504id);
        SafeParcelWriter.writeLong(parcel, 5, this.zzar);
        SafeParcelWriter.writeInt(parcel, 6, this.rotation);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzp(@SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) int i12, @SafeParcelable.Param(id = 4) int i13, @SafeParcelable.Param(id = 5) long j11, @SafeParcelable.Param(id = 6) int i14) {
        this.width = i11;
        this.height = i12;
        this.f44504id = i13;
        this.zzar = j11;
        this.rotation = i14;
    }
}
