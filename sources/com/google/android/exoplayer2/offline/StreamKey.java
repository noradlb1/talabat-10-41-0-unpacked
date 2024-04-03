package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new Parcelable.Creator<StreamKey>() {
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        public StreamKey[] newArray(int i11) {
            return new StreamKey[i11];
        }
    };
    public final int groupIndex;
    public final int periodIndex;
    public final int streamIndex;
    @Deprecated
    public final int trackIndex;

    public StreamKey(int i11, int i12) {
        this(0, i11, i12);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamKey.class != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        if (this.periodIndex == streamKey.periodIndex && this.groupIndex == streamKey.groupIndex && this.streamIndex == streamKey.streamIndex) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.periodIndex * 31) + this.groupIndex) * 31) + this.streamIndex;
    }

    public String toString() {
        return this.periodIndex + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + this.groupIndex + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + this.streamIndex;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.periodIndex);
        parcel.writeInt(this.groupIndex);
        parcel.writeInt(this.streamIndex);
    }

    public StreamKey(int i11, int i12, int i13) {
        this.periodIndex = i11;
        this.groupIndex = i12;
        this.streamIndex = i13;
        this.trackIndex = i13;
    }

    public int compareTo(StreamKey streamKey) {
        int i11 = this.periodIndex - streamKey.periodIndex;
        if (i11 != 0) {
            return i11;
        }
        int i12 = this.groupIndex - streamKey.groupIndex;
        return i12 == 0 ? this.streamIndex - streamKey.streamIndex : i12;
    }

    public StreamKey(Parcel parcel) {
        this.periodIndex = parcel.readInt();
        this.groupIndex = parcel.readInt();
        int readInt = parcel.readInt();
        this.streamIndex = readInt;
        this.trackIndex = readInt;
    }
}
