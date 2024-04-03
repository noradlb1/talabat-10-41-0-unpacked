package com.rd.utils;

import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

public class IdUtils {
    private static final AtomicInteger nextGeneratedId = new AtomicInteger(1);

    private static int generateId() {
        AtomicInteger atomicInteger;
        int i11;
        int i12;
        do {
            atomicInteger = nextGeneratedId;
            i11 = atomicInteger.get();
            i12 = i11 + 1;
            if (i12 > 16777215) {
                i12 = 1;
            }
        } while (!atomicInteger.compareAndSet(i11, i12));
        return i11;
    }

    public static int generateViewId() {
        return View.generateViewId();
    }
}
