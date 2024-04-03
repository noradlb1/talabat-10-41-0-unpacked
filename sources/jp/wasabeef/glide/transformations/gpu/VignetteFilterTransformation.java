package jp.wasabeef.glide.transformations.gpu;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageVignetteFilter;

public class VignetteFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation.1";
    private static final int VERSION = 1;
    private final PointF center;
    private final float[] vignetteColor;
    private final float vignetteEnd;
    private final float vignetteStart;

    public VignetteFilterTransformation() {
        this(new PointF(0.5f, 0.5f), new float[]{0.0f, 0.0f, 0.0f}, 0.0f, 0.75f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof VignetteFilterTransformation) {
            VignetteFilterTransformation vignetteFilterTransformation = (VignetteFilterTransformation) obj;
            PointF pointF = vignetteFilterTransformation.center;
            PointF pointF2 = this.center;
            if (!pointF.equals(pointF2.x, pointF2.y) || !Arrays.equals(vignetteFilterTransformation.vignetteColor, this.vignetteColor) || vignetteFilterTransformation.vignetteStart != this.vignetteStart || vignetteFilterTransformation.vignetteEnd != this.vignetteEnd) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 1874002103 + this.center.hashCode() + Arrays.hashCode(this.vignetteColor) + ((int) (this.vignetteStart * 100.0f)) + ((int) (this.vignetteEnd * 10.0f));
    }

    public String toString() {
        return "VignetteFilterTransformation(center=" + this.center.toString() + ",color=" + Arrays.toString(this.vignetteColor) + ",start=" + this.vignetteStart + ",end=" + this.vignetteEnd + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.center + Arrays.hashCode(this.vignetteColor) + this.vignetteStart + this.vignetteEnd).getBytes(Key.CHARSET));
    }

    public VignetteFilterTransformation(PointF pointF, float[] fArr, float f11, float f12) {
        super(new GPUImageVignetteFilter());
        this.center = pointF;
        this.vignetteColor = fArr;
        this.vignetteStart = f11;
        this.vignetteEnd = f12;
        GPUImageVignetteFilter gPUImageVignetteFilter = (GPUImageVignetteFilter) getFilter();
        gPUImageVignetteFilter.setVignetteCenter(pointF);
        gPUImageVignetteFilter.setVignetteColor(fArr);
        gPUImageVignetteFilter.setVignetteStart(f11);
        gPUImageVignetteFilter.setVignetteEnd(f12);
    }
}
