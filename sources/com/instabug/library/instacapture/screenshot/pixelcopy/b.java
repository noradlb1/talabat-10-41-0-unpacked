package com.instabug.library.instacapture.screenshot.pixelcopy;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import androidx.annotation.NonNull;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f34396a;

    /* renamed from: b  reason: collision with root package name */
    public int f34397b;

    public b(@NonNull Activity activity) {
        if (activity != null && activity.getWindowManager().getDefaultDisplay() != null && activity.getResources() != null && activity.getResources().getDisplayMetrics() != null) {
            Point a11 = a(activity.getWindowManager().getDefaultDisplay());
            this.f34396a = a11.x;
            this.f34397b = a11.y;
        }
    }

    private Point a(@NonNull Display display) {
        Point point = new Point();
        if (display == null) {
            return point;
        }
        display.getRealSize(point);
        return point;
    }
}
