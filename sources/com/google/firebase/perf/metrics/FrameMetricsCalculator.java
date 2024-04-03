package com.google.firebase.perf.metrics;

import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FrameMetricsCalculator {

    public static class PerfFrameMetrics {
        int frozenFrames;
        int slowFrames;
        int totalFrames;

        public PerfFrameMetrics(int i11, int i12, int i13) {
            this.totalFrames = i11;
            this.slowFrames = i12;
            this.frozenFrames = i13;
        }

        public PerfFrameMetrics deltaFrameMetricsFromSnapshot(PerfFrameMetrics perfFrameMetrics) {
            return new PerfFrameMetrics(this.totalFrames - perfFrameMetrics.getTotalFrames(), this.slowFrames - perfFrameMetrics.getSlowFrames(), this.frozenFrames - perfFrameMetrics.getFrozenFrames());
        }

        public int getFrozenFrames() {
            return this.frozenFrames;
        }

        public int getSlowFrames() {
            return this.slowFrames;
        }

        public int getTotalFrames() {
            return this.totalFrames;
        }
    }

    @NonNull
    public static PerfFrameMetrics calculateFrameMetrics(@Nullable SparseIntArray[] sparseIntArrayArr) {
        int i11;
        int i12;
        SparseIntArray sparseIntArray;
        int i13 = 0;
        if (sparseIntArrayArr == null || (sparseIntArray = sparseIntArrayArr[0]) == null) {
            i12 = 0;
            i11 = 0;
        } else {
            int i14 = 0;
            i12 = 0;
            i11 = 0;
            while (i13 < sparseIntArray.size()) {
                int keyAt = sparseIntArray.keyAt(i13);
                int valueAt = sparseIntArray.valueAt(i13);
                i14 += valueAt;
                if (keyAt > 700) {
                    i11 += valueAt;
                }
                if (keyAt > 16) {
                    i12 += valueAt;
                }
                i13++;
            }
            i13 = i14;
        }
        return new PerfFrameMetrics(i13, i12, i11);
    }
}
