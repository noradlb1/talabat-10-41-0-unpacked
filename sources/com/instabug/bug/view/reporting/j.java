package com.instabug.bug.view.reporting;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.instabug.library.util.DeviceStateProvider;

class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f45900b;

    public j(x xVar) {
        this.f45900b = xVar;
    }

    public void run() {
        View findViewByPosition;
        if (this.f45900b.f45922e != null && this.f45900b.f45922e.getLayoutManager() != null && (findViewByPosition = this.f45900b.f45922e.getLayoutManager().findViewByPosition(this.f45900b.f45929m.getItemCount() - 1)) != null && this.f45900b.getActivity() != null) {
            Rect rect = new Rect();
            findViewByPosition.getGlobalVisibleRect(rect);
            DisplayMetrics displayMetrics = DeviceStateProvider.getDisplayMetrics(this.f45900b.getActivity());
            this.f45900b.f45930n.a((((float) (rect.right + rect.left)) / 2.0f) / ((float) displayMetrics.widthPixels), (((float) (rect.top + rect.bottom)) / 2.0f) / ((float) displayMetrics.heightPixels));
        }
    }
}
