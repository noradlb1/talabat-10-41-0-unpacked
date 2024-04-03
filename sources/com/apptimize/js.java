package com.apptimize;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.view.View;
import android.widget.PopupWindow;

public class js {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43142a = "js";

    public static View a(Activity activity) {
        return activity.getWindow().getDecorView().getRootView();
    }

    public static boolean b(View view) {
        return view.getVisibility() == 4 || view.getVisibility() == 8;
    }

    public static View a(Object obj) {
        if (obj instanceof Dialog) {
            return ((Dialog) obj).getWindow().getDecorView().getRootView();
        }
        if (obj instanceof PopupWindow) {
            return ((PopupWindow) obj).getContentView().getRootView();
        }
        String str = f43142a;
        bo.e(str, "Unrecognized popup: " + obj);
        return null;
    }

    public static Point a(View view) {
        if (view != view.getRootView()) {
            return new Point(0, 0);
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Point(iArr[0], iArr[1]);
    }
}
