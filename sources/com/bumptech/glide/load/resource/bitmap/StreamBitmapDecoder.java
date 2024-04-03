package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ExceptionPassthroughInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    private final ArrayPool byteArrayPool;
    private final Downsampler downsampler;

    public static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {
        private final RecyclableBufferedInputStream bufferedStream;
        private final ExceptionPassthroughInputStream exceptionStream;

        public UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionPassthroughInputStream exceptionPassthroughInputStream) {
            this.bufferedStream = recyclableBufferedInputStream;
            this.exceptionStream = exceptionPassthroughInputStream;
        }

        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException exception = this.exceptionStream.getException();
            if (exception != null) {
                if (bitmap != null) {
                    bitmapPool.put(bitmap);
                }
                throw exception;
            }
        }

        public void onObtainBounds() {
            this.bufferedStream.fixMarkLimit();
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler2, ArrayPool arrayPool) {
        this.downsampler = downsampler2;
        this.byteArrayPool = arrayPool;
    }

    public Resource<Bitmap> decode(@NonNull InputStream inputStream, int i11, int i12, @NonNull Options options) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z11;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z11 = false;
        } else {
            z11 = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.byteArrayPool);
        }
        ExceptionPassthroughInputStream obtain = ExceptionPassthroughInputStream.obtain(recyclableBufferedInputStream);
        try {
            return this.downsampler.decode((InputStream) new MarkEnforcingInputStream(obtain), i11, i12, options, (Downsampler.DecodeCallbacks) new UntrustedCallbacks(recyclableBufferedInputStream, obtain));
        } finally {
            obtain.release();
            if (z11) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    public boolean handles(@NonNull InputStream inputStream, @NonNull Options options) {
        return this.downsampler.handles(inputStream);
    }
}
