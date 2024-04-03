package jp.wasabeef.glide.transformations.gpu;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageBrightnessFilter;

public class BrightnessFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation.1";
    private static final int VERSION = 1;
    private final float brightness;

    public BrightnessFilterTransformation() {
        this(0.0f);
    }

    public boolean equals(Object obj) {
        return (obj instanceof BrightnessFilterTransformation) && ((BrightnessFilterTransformation) obj).brightness == this.brightness;
    }

    public int hashCode() {
        return -1311211954 + ((int) ((this.brightness + 1.0f) * 10.0f));
    }

    public String toString() {
        return "BrightnessFilterTransformation(brightness=" + this.brightness + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.brightness).getBytes(Key.CHARSET));
    }

    public BrightnessFilterTransformation(float f11) {
        super(new GPUImageBrightnessFilter());
        this.brightness = f11;
        ((GPUImageBrightnessFilter) getFilter()).setBrightness(f11);
    }
}
