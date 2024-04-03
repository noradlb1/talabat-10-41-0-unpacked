package ls;

import android.view.ViewTreeObserver;
import com.talabat.impressions.BatchImpressionTracker;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f62271b;

    public /* synthetic */ b(Function0 function0) {
        this.f62271b = function0;
    }

    public final void onGlobalLayout() {
        BatchImpressionTracker.m10659startTracking$lambda0(this.f62271b);
    }
}
