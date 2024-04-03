package ls;

import android.view.ViewTreeObserver;
import com.talabat.impressions.RecyclerViewImpressionTracker;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f62276b;

    public /* synthetic */ e(Function0 function0) {
        this.f62276b = function0;
    }

    public final void onGlobalLayout() {
        RecyclerViewImpressionTracker.m10664stopTracking$lambda4(this.f62276b);
    }
}
