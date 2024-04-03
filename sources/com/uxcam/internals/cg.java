package com.uxcam.internals;

import android.view.View;
import android.view.ViewGroup;
import io.flutter.embedding.android.FlutterSurfaceView;
import io.flutter.view.FlutterView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class cg implements cf {
    public ce a(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof ViewGroup) {
                ce a11 = a((ViewGroup) childAt);
                List list = a11.f13117b;
                if (list != null) {
                    arrayList2.addAll(list);
                }
                List list2 = a11.f13116a;
                if (list2 != null) {
                    arrayList.addAll(list2);
                }
            } else if (childAt != null) {
                if (childAt instanceof FlutterView) {
                    arrayList.add(new WeakReference((FlutterView) childAt));
                }
                if (childAt instanceof FlutterSurfaceView) {
                    arrayList2.add(new WeakReference((FlutterSurfaceView) childAt));
                }
            }
        }
        return new ce(arrayList, arrayList2);
    }
}
