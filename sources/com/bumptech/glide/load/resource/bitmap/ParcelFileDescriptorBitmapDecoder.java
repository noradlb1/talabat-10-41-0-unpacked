package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

@RequiresApi(21)
public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {
    private final Downsampler downsampler;

    public ParcelFileDescriptorBitmapDecoder(Downsampler downsampler2) {
        this.downsampler = downsampler2;
    }

    @Nullable
    public Resource<Bitmap> decode(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i11, int i12, @NonNull Options options) throws IOException {
        return this.downsampler.decode(parcelFileDescriptor, i11, i12, options);
    }

    public boolean handles(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull Options options) {
        return this.downsampler.handles(parcelFileDescriptor);
    }
}
