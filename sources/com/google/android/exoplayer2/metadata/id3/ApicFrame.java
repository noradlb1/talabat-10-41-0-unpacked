package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new Parcelable.Creator<ApicFrame>() {
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        public ApicFrame[] newArray(int i11) {
            return new ApicFrame[i11];
        }
    };
    public static final String ID = "APIC";
    @Nullable
    public final String description;
    public final String mimeType;
    public final byte[] pictureData;
    public final int pictureType;

    public ApicFrame(String str, @Nullable String str2, int i11, byte[] bArr) {
        super(ID);
        this.mimeType = str;
        this.description = str2;
        this.pictureType = i11;
        this.pictureData = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        if (this.pictureType != apicFrame.pictureType || !Util.areEqual(this.mimeType, apicFrame.mimeType) || !Util.areEqual(this.description, apicFrame.description) || !Arrays.equals(this.pictureData, apicFrame.pictureData)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i11;
        int i12 = (527 + this.pictureType) * 31;
        String str = this.mimeType;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i12 + i11) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i13 = str2.hashCode();
        }
        return ((i14 + i13) * 31) + Arrays.hashCode(this.pictureData);
    }

    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        builder.maybeSetArtworkData(this.pictureData, this.pictureType);
    }

    public String toString() {
        return this.f34964id + ": mimeType=" + this.mimeType + ", description=" + this.description;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.pictureType);
        parcel.writeByteArray(this.pictureData);
    }

    public ApicFrame(Parcel parcel) {
        super(ID);
        this.mimeType = (String) Util.castNonNull(parcel.readString());
        this.description = parcel.readString();
        this.pictureType = parcel.readInt();
        this.pictureData = (byte[]) Util.castNonNull(parcel.createByteArray());
    }
}
