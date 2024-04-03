package com.google.android.gms.vision;

import com.google.android.gms.vision.Detector;

public class Tracker<T> {
    public void onDone() {
    }

    public void onMissing(Detector.Detections<T> detections) {
    }

    public void onNewItem(int i11, T t11) {
    }

    public void onUpdate(Detector.Detections<T> detections, T t11) {
    }
}
