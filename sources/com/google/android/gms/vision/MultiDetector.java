package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.ArrayList;
import java.util.List;

public class MultiDetector extends Detector<Object> {
    /* access modifiers changed from: private */
    public List<Detector<? extends Object>> zzaw;

    public static class Builder {
        private MultiDetector zzaz = new MultiDetector();

        public Builder add(Detector<? extends Object> detector) {
            this.zzaz.zzaw.add(detector);
            return this;
        }

        public MultiDetector build() {
            if (this.zzaz.zzaw.size() != 0) {
                return this.zzaz;
            }
            throw new RuntimeException("No underlying detectors added to MultiDetector.");
        }
    }

    private MultiDetector() {
        this.zzaw = new ArrayList();
    }

    public SparseArray<Object> detect(Frame frame) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        for (Detector<? extends Object> detect : this.zzaw) {
            SparseArray detect2 = detect.detect(frame);
            int i11 = 0;
            while (true) {
                if (i11 < detect2.size()) {
                    int keyAt = detect2.keyAt(i11);
                    if (sparseArray.get(keyAt) == null) {
                        sparseArray.append(keyAt, detect2.valueAt(i11));
                        i11++;
                    } else {
                        StringBuilder sb2 = new StringBuilder(104);
                        sb2.append("Detection ID overlap for id = ");
                        sb2.append(keyAt);
                        sb2.append("  This means that one of the detectors is not using global IDs.");
                        throw new IllegalStateException(sb2.toString());
                    }
                }
            }
        }
        return sparseArray;
    }

    public boolean isOperational() {
        for (Detector<? extends Object> isOperational : this.zzaw) {
            if (!isOperational.isOperational()) {
                return false;
            }
        }
        return true;
    }

    public void receiveFrame(Frame frame) {
        for (Detector<? extends Object> receiveFrame : this.zzaw) {
            receiveFrame.receiveFrame(frame);
        }
    }

    public void release() {
        for (Detector<? extends Object> release : this.zzaw) {
            release.release();
        }
        this.zzaw.clear();
    }

    public void setProcessor(Detector.Processor<Object> processor) {
        throw new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
    }
}
