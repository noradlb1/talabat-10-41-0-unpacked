package q9;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class b implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f50711a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50712b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f50713c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StaticSessionData f50714d;

    public /* synthetic */ b(String str, String str2, long j11, StaticSessionData staticSessionData) {
        this.f50711a = str;
        this.f50712b = str2;
        this.f50713c = j11;
        this.f50714d = staticSessionData;
    }

    public final void handle(Provider provider) {
        ((CrashlyticsNativeComponent) provider.get()).prepareNativeSession(this.f50711a, this.f50712b, this.f50713c, this.f50714d);
    }
}
