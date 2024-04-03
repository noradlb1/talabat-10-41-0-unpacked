package r9;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;

public final /* synthetic */ class a implements BreadcrumbHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsCore f50764a;

    public /* synthetic */ a(CrashlyticsCore crashlyticsCore) {
        this.f50764a = crashlyticsCore;
    }

    public final void handleBreadcrumb(String str) {
        this.f50764a.log(str);
    }
}
