package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import w7.a;

public final class HlsTrackMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new Parcelable.Creator<HlsTrackMetadataEntry>() {
        public HlsTrackMetadataEntry createFromParcel(Parcel parcel) {
            return new HlsTrackMetadataEntry(parcel);
        }

        public HlsTrackMetadataEntry[] newArray(int i11) {
            return new HlsTrackMetadataEntry[i11];
        }
    };
    @Nullable
    public final String groupId;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    public final String f35030name;
    public final List<VariantInfo> variantInfos;

    public HlsTrackMetadataEntry(@Nullable String str, @Nullable String str2, List<VariantInfo> list) {
        this.groupId = str;
        this.f35030name = str2;
        this.variantInfos = Collections.unmodifiableList(new ArrayList(list));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HlsTrackMetadataEntry.class != obj.getClass()) {
            return false;
        }
        HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry) obj;
        if (!TextUtils.equals(this.groupId, hlsTrackMetadataEntry.groupId) || !TextUtils.equals(this.f35030name, hlsTrackMetadataEntry.f35030name) || !this.variantInfos.equals(hlsTrackMetadataEntry.variantInfos)) {
            return false;
        }
        return true;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return a.a(this);
    }

    public /* synthetic */ Format getWrappedMetadataFormat() {
        return a.b(this);
    }

    public int hashCode() {
        int i11;
        String str = this.groupId;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        String str2 = this.f35030name;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return ((i13 + i12) * 31) + this.variantInfos.hashCode();
    }

    public /* synthetic */ void populateMediaMetadata(MediaMetadata.Builder builder) {
        a.c(this, builder);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("HlsTrackMetadataEntry");
        if (this.groupId != null) {
            str = " [" + this.groupId + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.f35030name + "]";
        } else {
            str = "";
        }
        sb2.append(str);
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.groupId);
        parcel.writeString(this.f35030name);
        int size = this.variantInfos.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            parcel.writeParcelable(this.variantInfos.get(i12), 0);
        }
    }

    public HlsTrackMetadataEntry(Parcel parcel) {
        this.groupId = parcel.readString();
        this.f35030name = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayList.add((VariantInfo) parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.variantInfos = Collections.unmodifiableList(arrayList);
    }

    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator<VariantInfo> CREATOR = new Parcelable.Creator<VariantInfo>() {
            public VariantInfo createFromParcel(Parcel parcel) {
                return new VariantInfo(parcel);
            }

            public VariantInfo[] newArray(int i11) {
                return new VariantInfo[i11];
            }
        };
        @Nullable
        public final String audioGroupId;
        public final int averageBitrate;
        @Nullable
        public final String captionGroupId;
        public final int peakBitrate;
        @Nullable
        public final String subtitleGroupId;
        @Nullable
        public final String videoGroupId;

        public VariantInfo(int i11, int i12, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.averageBitrate = i11;
            this.peakBitrate = i12;
            this.videoGroupId = str;
            this.audioGroupId = str2;
            this.subtitleGroupId = str3;
            this.captionGroupId = str4;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || VariantInfo.class != obj.getClass()) {
                return false;
            }
            VariantInfo variantInfo = (VariantInfo) obj;
            if (this.averageBitrate != variantInfo.averageBitrate || this.peakBitrate != variantInfo.peakBitrate || !TextUtils.equals(this.videoGroupId, variantInfo.videoGroupId) || !TextUtils.equals(this.audioGroupId, variantInfo.audioGroupId) || !TextUtils.equals(this.subtitleGroupId, variantInfo.subtitleGroupId) || !TextUtils.equals(this.captionGroupId, variantInfo.captionGroupId)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i11;
            int i12;
            int i13;
            int i14 = ((this.averageBitrate * 31) + this.peakBitrate) * 31;
            String str = this.videoGroupId;
            int i15 = 0;
            if (str != null) {
                i11 = str.hashCode();
            } else {
                i11 = 0;
            }
            int i16 = (i14 + i11) * 31;
            String str2 = this.audioGroupId;
            if (str2 != null) {
                i12 = str2.hashCode();
            } else {
                i12 = 0;
            }
            int i17 = (i16 + i12) * 31;
            String str3 = this.subtitleGroupId;
            if (str3 != null) {
                i13 = str3.hashCode();
            } else {
                i13 = 0;
            }
            int i18 = (i17 + i13) * 31;
            String str4 = this.captionGroupId;
            if (str4 != null) {
                i15 = str4.hashCode();
            }
            return i18 + i15;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.averageBitrate);
            parcel.writeInt(this.peakBitrate);
            parcel.writeString(this.videoGroupId);
            parcel.writeString(this.audioGroupId);
            parcel.writeString(this.subtitleGroupId);
            parcel.writeString(this.captionGroupId);
        }

        public VariantInfo(Parcel parcel) {
            this.averageBitrate = parcel.readInt();
            this.peakBitrate = parcel.readInt();
            this.videoGroupId = parcel.readString();
            this.audioGroupId = parcel.readString();
            this.subtitleGroupId = parcel.readString();
            this.captionGroupId = parcel.readString();
        }
    }
}
