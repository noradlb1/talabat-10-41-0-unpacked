package jp.wasabeef.glide.transformations.gpu;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImagePixelationFilter;

public class PixelationFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation.1";
    private static final int VERSION = 1;
    private final float pixel;

    public PixelationFilterTransformation() {
        this(10.0f);
    }

    public boolean equals(Object obj) {
        return obj instanceof PixelationFilterTransformation;
    }

    public int hashCode() {
        return 1525023660 + ((int) (this.pixel * 10.0f));
    }

    public String toString() {
        return "PixelationFilterTransformation(pixel=" + this.pixel + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.pixel).getBytes(Key.CHARSET));
    }

    public PixelationFilterTransformation(float f11) {
        super(new GPUImagePixelationFilter());
        this.pixel = f11;
        ((GPUImagePixelationFilter) getFilter()).setPixel(f11);
    }
}
