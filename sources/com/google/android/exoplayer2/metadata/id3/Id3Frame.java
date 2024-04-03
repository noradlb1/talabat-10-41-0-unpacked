package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import w7.a;

public abstract class Id3Frame implements Metadata.Entry {

    /* renamed from: id  reason: collision with root package name */
    public final String f34964id;

    public Id3Frame(String str) {
        this.f34964id = str;
    }

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
        return this.f34964id;
    }
}
