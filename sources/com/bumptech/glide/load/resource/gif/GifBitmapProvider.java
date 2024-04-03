package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class GifBitmapProvider implements GifDecoder.BitmapProvider {
    @Nullable
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool bitmapPool2) {
        this(bitmapPool2, (ArrayPool) null);
    }

    @NonNull
    public Bitmap obtain(int i11, int i12, @NonNull Bitmap.Config config) {
        return this.bitmapPool.getDirty(i11, i12, config);
    }

    @NonNull
    public byte[] obtainByteArray(int i11) {
        ArrayPool arrayPool2 = this.arrayPool;
        if (arrayPool2 == null) {
            return new byte[i11];
        }
        return (byte[]) arrayPool2.get(i11, byte[].class);
    }

    @NonNull
    public int[] obtainIntArray(int i11) {
        ArrayPool arrayPool2 = this.arrayPool;
        if (arrayPool2 == null) {
            return new int[i11];
        }
        return (int[]) arrayPool2.get(i11, int[].class);
    }

    public void release(@NonNull Bitmap bitmap) {
        this.bitmapPool.put(bitmap);
    }

    public GifBitmapProvider(BitmapPool bitmapPool2, @Nullable ArrayPool arrayPool2) {
        this.bitmapPool = bitmapPool2;
        this.arrayPool = arrayPool2;
    }

    public void release(@NonNull byte[] bArr) {
        ArrayPool arrayPool2 = this.arrayPool;
        if (arrayPool2 != null) {
            arrayPool2.put(bArr);
        }
    }

    public void release(@NonNull int[] iArr) {
        ArrayPool arrayPool2 = this.arrayPool;
        if (arrayPool2 != null) {
            arrayPool2.put(iArr);
        }
    }
}
