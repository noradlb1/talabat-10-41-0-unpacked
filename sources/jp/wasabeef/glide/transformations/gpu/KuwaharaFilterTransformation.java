package jp.wasabeef.glide.transformations.gpu;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageKuwaharaFilter;

public class KuwaharaFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation.1";
    private static final int VERSION = 1;
    private final int radius;

    public KuwaharaFilterTransformation() {
        this(25);
    }

    public boolean equals(Object obj) {
        return obj instanceof KuwaharaFilterTransformation;
    }

    public int hashCode() {
        return -1859800423 + (this.radius * 10);
    }

    public String toString() {
        return "KuwaharaFilterTransformation(radius=" + this.radius + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius).getBytes(Key.CHARSET));
    }

    public KuwaharaFilterTransformation(int i11) {
        super(new GPUImageKuwaharaFilter());
        this.radius = i11;
        ((GPUImageKuwaharaFilter) getFilter()).setRadius(i11);
    }
}
