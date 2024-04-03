package p9;

import com.google.firebase.crashlytics.AnalyticsDeferredProxy;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class c implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsDeferredProxy f50695a;

    public /* synthetic */ c(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.f50695a = analyticsDeferredProxy;
    }

    public final void handle(Provider provider) {
        this.f50695a.lambda$init$2(provider);
    }
}
