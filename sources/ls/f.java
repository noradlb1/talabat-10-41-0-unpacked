package ls;

import android.view.ViewTreeObserver;
import com.talabat.impressions.RecyclerViewImpressionTracker;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class f implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f62277b;

    public /* synthetic */ f(Function0 function0) {
        this.f62277b = function0;
    }

    public final void onGlobalLayout() {
        RecyclerViewImpressionTracker.m10663startTracking$lambda0(this.f62277b);
    }
}
