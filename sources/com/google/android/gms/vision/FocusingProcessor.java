package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;

public abstract class FocusingProcessor<T> implements Detector.Processor<T> {
    private Tracker<T> zzaj;
    private int zzak = 3;
    private boolean zzal = false;
    private int zzam;
    private int zzan = 0;
    private Detector<T> zzt;

    public FocusingProcessor(Detector<T> detector, Tracker<T> tracker) {
        this.zzt = detector;
        this.zzaj = tracker;
    }

    public void receiveDetections(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        if (detectedItems.size() == 0) {
            if (this.zzan == this.zzak) {
                this.zzaj.onDone();
                this.zzal = false;
            } else {
                this.zzaj.onMissing(detections);
            }
            this.zzan++;
            return;
        }
        this.zzan = 0;
        if (this.zzal) {
            T t11 = detectedItems.get(this.zzam);
            if (t11 != null) {
                this.zzaj.onUpdate(detections, t11);
                return;
            } else {
                this.zzaj.onDone();
                this.zzal = false;
            }
        }
        int selectFocus = selectFocus(detections);
        T t12 = detectedItems.get(selectFocus);
        if (t12 == null) {
            StringBuilder sb2 = new StringBuilder(35);
            sb2.append("Invalid focus selected: ");
            sb2.append(selectFocus);
            Log.w("FocusingProcessor", sb2.toString());
            return;
        }
        this.zzal = true;
        this.zzam = selectFocus;
        this.zzt.setFocus(selectFocus);
        this.zzaj.onNewItem(this.zzam, t12);
        this.zzaj.onUpdate(detections, t12);
    }

    public void release() {
        this.zzaj.onDone();
    }

    public abstract int selectFocus(Detector.Detections<T> detections);

    public final void zza(int i11) {
        if (i11 >= 0) {
            this.zzak = i11;
            return;
        }
        StringBuilder sb2 = new StringBuilder(28);
        sb2.append("Invalid max gap: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }
}
