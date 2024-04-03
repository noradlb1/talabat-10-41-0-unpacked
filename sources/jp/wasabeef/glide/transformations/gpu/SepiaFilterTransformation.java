package jp.wasabeef.glide.transformations.gpu;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSepiaToneFilter;

public class SepiaFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation.1";
    private static final int VERSION = 1;
    private final float intensity;

    public SepiaFilterTransformation() {
        this(1.0f);
    }

    public boolean equals(Object obj) {
        return obj instanceof SepiaFilterTransformation;
    }

    public int hashCode() {
        return 895516065 + ((int) (this.intensity * 10.0f));
    }

    public String toString() {
        return "SepiaFilterTransformation(intensity=" + this.intensity + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.intensity).getBytes(Key.CHARSET));
    }

    public SepiaFilterTransformation(float f11) {
        super(new GPUImageSepiaToneFilter());
        this.intensity = f11;
        ((GPUImageSepiaToneFilter) getFilter()).setIntensity(f11);
    }
}
