package com.google.android.exoplayer2.metadata.vorbis;

import android.os.Parcel;
import android.os.Parcelable;

public final class VorbisComment extends com.google.android.exoplayer2.metadata.flac.VorbisComment {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new Parcelable.Creator<VorbisComment>() {
        public VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }

        public VorbisComment[] newArray(int i11) {
            return new VorbisComment[i11];
        }
    };

    public VorbisComment(String str, String str2) {
        super(str, str2);
    }

    public VorbisComment(Parcel parcel) {
        super(parcel);
    }
}
