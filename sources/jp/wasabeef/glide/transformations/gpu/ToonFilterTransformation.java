package jp.wasabeef.glide.transformations.gpu;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageToonFilter;

public class ToonFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation.1";
    private static final int VERSION = 1;
    private final float quantizationLevels;
    private final float threshold;

    public ToonFilterTransformation() {
        this(0.2f, 10.0f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ToonFilterTransformation) {
            ToonFilterTransformation toonFilterTransformation = (ToonFilterTransformation) obj;
            return toonFilterTransformation.threshold == this.threshold && toonFilterTransformation.quantizationLevels == this.quantizationLevels;
        }
    }

    public int hashCode() {
        return 1209810327 + ((int) (this.threshold * 1000.0f)) + ((int) (this.quantizationLevels * 10.0f));
    }

    public String toString() {
        return "ToonFilterTransformation(threshold=" + this.threshold + ",quantizationLevels=" + this.quantizationLevels + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.threshold + this.quantizationLevels).getBytes(Key.CHARSET));
    }

    public ToonFilterTransformation(float f11, float f12) {
        super(new GPUImageToonFilter());
        this.threshold = f11;
        this.quantizationLevels = f12;
        GPUImageToonFilter gPUImageToonFilter = (GPUImageToonFilter) getFilter();
        gPUImageToonFilter.setThreshold(f11);
        gPUImageToonFilter.setQuantizationLevels(f12);
    }
}
