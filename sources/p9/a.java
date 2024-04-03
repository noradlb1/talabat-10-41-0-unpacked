package p9;

import com.google.firebase.crashlytics.AnalyticsDeferredProxy;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;

public final /* synthetic */ class a implements BreadcrumbSource {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsDeferredProxy f50693a;

    public /* synthetic */ a(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.f50693a = analyticsDeferredProxy;
    }

    public final void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        this.f50693a.lambda$getDeferredBreadcrumbSource$0(breadcrumbHandler);
    }
}
