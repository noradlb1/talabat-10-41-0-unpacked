package com.google.android.gms.vision.face;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.FocusingProcessor;
import com.google.android.gms.vision.Tracker;

public class LargestFaceFocusingProcessor extends FocusingProcessor<Face> {

    public static class Builder {
        private LargestFaceFocusingProcessor zzcp;

        public Builder(Detector<Face> detector, Tracker<Face> tracker) {
            this.zzcp = new LargestFaceFocusingProcessor(detector, tracker);
        }

        public LargestFaceFocusingProcessor build() {
            return this.zzcp;
        }

        public Builder setMaxGapFrames(int i11) {
            this.zzcp.zza(i11);
            return this;
        }
    }

    public LargestFaceFocusingProcessor(Detector<Face> detector, Tracker<Face> tracker) {
        super(detector, tracker);
    }

    public int selectFocus(Detector.Detections<Face> detections) {
        SparseArray<Face> detectedItems = detections.getDetectedItems();
        if (detectedItems.size() != 0) {
            int keyAt = detectedItems.keyAt(0);
            float width = detectedItems.valueAt(0).getWidth();
            for (int i11 = 1; i11 < detectedItems.size(); i11++) {
                int keyAt2 = detectedItems.keyAt(i11);
                float width2 = detectedItems.valueAt(i11).getWidth();
                if (width2 > width) {
                    keyAt = keyAt2;
                    width = width2;
                }
            }
            return keyAt;
        }
        throw new IllegalArgumentException("No faces for selectFocus.");
    }
}
