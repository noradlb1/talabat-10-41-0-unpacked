package com.instabug.library.util;

import android.util.Pair;
import java.lang.ref.WeakReference;

public class s extends Pair {
    public s(Object obj, Object obj2) {
        super(new WeakReference(obj), new WeakReference(obj2));
    }
}
