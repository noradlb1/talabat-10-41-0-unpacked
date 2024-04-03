package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderOutputBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SimpleDecoderOutputBuffer extends DecoderOutputBuffer {
    @Nullable
    public ByteBuffer data;
    private final DecoderOutputBuffer.Owner<SimpleDecoderOutputBuffer> owner;

    public SimpleDecoderOutputBuffer(DecoderOutputBuffer.Owner<SimpleDecoderOutputBuffer> owner2) {
        this.owner = owner2;
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public ByteBuffer init(long j11, int i11) {
        this.timeUs = j11;
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null || byteBuffer.capacity() < i11) {
            this.data = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
        }
        this.data.position(0);
        this.data.limit(i11);
        return this.data;
    }

    public void release() {
        this.owner.releaseOutputBuffer(this);
    }
}
