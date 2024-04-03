package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import w7.a;

public abstract class SpliceCommand implements Metadata.Entry {
    public int describeContents() {
        return 0;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return a.a(this);
    }

    public /* synthetic */ Format getWrappedMetadataFormat() {
        return a.b(this);
    }

    public /* synthetic */ void populateMediaMetadata(MediaMetadata.Builder builder) {
        a.c(this, builder);
    }

    public String toString() {
        return "SCTE-35 splice command: type=" + getClass().getSimpleName();
    }
}
