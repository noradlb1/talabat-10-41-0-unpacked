package com.bumptech.glide.load.resource;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.huawei.hms.flutter.map.constants.Param;
import java.io.IOException;

@RequiresApi(api = 28)
public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {
    private static final String TAG = "ImageDecoder";
    final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();

    public abstract Resource<T> decode(ImageDecoder.Source source, int i11, int i12, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    public final boolean handles(@NonNull ImageDecoder.Source source, @NonNull Options options) {
        return true;
    }

    @Nullable
    public final Resource<T> decode(@NonNull ImageDecoder.Source source, int i11, int i12, @NonNull Options options) throws IOException {
        final DecodeFormat decodeFormat = (DecodeFormat) options.get(Downsampler.DECODE_FORMAT);
        final DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        Option option = Downsampler.ALLOW_HARDWARE_CONFIG;
        final boolean z11 = options.get(option) != null && ((Boolean) options.get(option)).booleanValue();
        final PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.get(Downsampler.PREFERRED_COLOR_SPACE);
        final int i13 = i11;
        final int i14 = i12;
        return decode(source, i11, i12, (ImageDecoder.OnHeaderDecodedListener) new ImageDecoder.OnHeaderDecodedListener() {
            @SuppressLint({"Override"})
            public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                ColorSpace.Named named;
                boolean z11 = false;
                if (ImageDecoderResourceDecoder.this.hardwareConfigState.isHardwareConfigAllowed(i13, i14, z11, false)) {
                    imageDecoder.setAllocator(3);
                } else {
                    imageDecoder.setAllocator(1);
                }
                if (decodeFormat == DecodeFormat.PREFER_RGB_565) {
                    imageDecoder.setMemorySizePolicy(0);
                }
                imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() {
                    public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                        return false;
                    }
                });
                Size a11 = imageInfo.getSize();
                int i11 = i13;
                if (i11 == Integer.MIN_VALUE) {
                    i11 = a11.getWidth();
                }
                int i12 = i14;
                if (i12 == Integer.MIN_VALUE) {
                    i12 = a11.getHeight();
                }
                float scaleFactor = downsampleStrategy.getScaleFactor(a11.getWidth(), a11.getHeight(), i11, i12);
                int round = Math.round(((float) a11.getWidth()) * scaleFactor);
                int round2 = Math.round(((float) a11.getHeight()) * scaleFactor);
                if (Log.isLoggable(ImageDecoderResourceDecoder.TAG, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Resizing from [");
                    sb2.append(a11.getWidth());
                    sb2.append(Param.X);
                    sb2.append(a11.getHeight());
                    sb2.append("] to [");
                    sb2.append(round);
                    sb2.append(Param.X);
                    sb2.append(round2);
                    sb2.append("] scaleFactor: ");
                    sb2.append(scaleFactor);
                }
                imageDecoder.setTargetSize(round, round2);
                int i13 = Build.VERSION.SDK_INT;
                if (i13 >= 28) {
                    if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                        z11 = true;
                    }
                    if (z11) {
                        named = ColorSpace.Named.DISPLAY_P3;
                    } else {
                        named = ColorSpace.Named.SRGB;
                    }
                    imageDecoder.setTargetColorSpace(ColorSpace.get(named));
                } else if (i13 >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            }
        });
    }
}
