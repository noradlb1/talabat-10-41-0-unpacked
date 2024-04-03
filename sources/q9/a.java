package q9;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class a implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsNativeComponentDeferredProxy f50710a;

    public /* synthetic */ a(CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy) {
        this.f50710a = crashlyticsNativeComponentDeferredProxy;
    }

    public final void handle(Provider provider) {
        this.f50710a.lambda$new$0(provider);
    }
}
