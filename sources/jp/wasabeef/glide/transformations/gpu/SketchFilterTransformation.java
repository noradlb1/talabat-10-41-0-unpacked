package jp.wasabeef.glide.transformations.gpu;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSketchFilter;

public class SketchFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation.1";
    private static final int VERSION = 1;

    public SketchFilterTransformation() {
        super(new GPUImageSketchFilter());
    }

    public boolean equals(Object obj) {
        return obj instanceof SketchFilterTransformation;
    }

    public int hashCode() {
        return -1790215191;
    }

    public String toString() {
        return "SketchFilterTransformation()";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID.getBytes(Key.CHARSET));
    }
}
