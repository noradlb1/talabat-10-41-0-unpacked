package jp.wasabeef.glide.transformations.gpu;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageContrastFilter;

public class ContrastFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation.1";
    private static final int VERSION = 1;
    private final float contrast;

    public ContrastFilterTransformation() {
        this(1.0f);
    }

    public boolean equals(Object obj) {
        return obj instanceof ContrastFilterTransformation;
    }

    public int hashCode() {
        return -306633601 + ((int) (this.contrast * 10.0f));
    }

    public String toString() {
        return "ContrastFilterTransformation(contrast=" + this.contrast + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.contrast).getBytes(Key.CHARSET));
    }

    public ContrastFilterTransformation(float f11) {
        super(new GPUImageContrastFilter());
        this.contrast = f11;
        ((GPUImageContrastFilter) getFilter()).setContrast(f11);
    }
}
