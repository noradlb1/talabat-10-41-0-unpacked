package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.util.ParsableByteArray;

final class StreamNameChunk implements AviChunk {

    /* renamed from: name  reason: collision with root package name */
    public final String f34932name;

    private StreamNameChunk(String str) {
        this.f34932name = str;
    }

    public static StreamNameChunk parseFrom(ParsableByteArray parsableByteArray) {
        return new StreamNameChunk(parsableByteArray.readString(parsableByteArray.bytesLeft()));
    }

    public int getType() {
        return AviExtractor.FOURCC_strn;
    }
}
