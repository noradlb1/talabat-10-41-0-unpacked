package p9;

import android.os.Bundle;
import com.google.firebase.crashlytics.AnalyticsDeferredProxy;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;

public final /* synthetic */ class b implements AnalyticsEventLogger {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsDeferredProxy f50694a;

    public /* synthetic */ b(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.f50694a = analyticsDeferredProxy;
    }

    public final void logEvent(String str, Bundle bundle) {
        this.f50694a.lambda$getAnalyticsEventLogger$1(str, bundle);
    }
}
