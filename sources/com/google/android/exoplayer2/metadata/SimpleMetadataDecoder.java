package com.google.android.exoplayer2.metadata;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

public abstract class SimpleMetadataDecoder implements MetadataDecoder {
    @Nullable
    public final Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        boolean z11;
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(metadataInputBuffer.data);
        if (byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        if (metadataInputBuffer.isDecodeOnly()) {
            return null;
        }
        return decode(metadataInputBuffer, byteBuffer);
    }

    @Nullable
    public abstract Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer);
}
