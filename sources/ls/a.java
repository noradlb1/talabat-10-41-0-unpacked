package ls;

import android.view.ViewTreeObserver;
import com.talabat.impressions.BatchImpressionTracker;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f62270b;

    public /* synthetic */ a(Function0 function0) {
        this.f62270b = function0;
    }

    public final void onGlobalLayout() {
        BatchImpressionTracker.m10660stopTracking$lambda3(this.f62270b);
    }
}
