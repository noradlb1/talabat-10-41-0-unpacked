package o6;

import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.internal.FetchedAppSettings;

public final /* synthetic */ class c implements ViewIndexingTrigger.OnShakeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FetchedAppSettings f34607a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34608b;

    public /* synthetic */ c(FetchedAppSettings fetchedAppSettings, String str) {
        this.f34607a = fetchedAppSettings;
        this.f34608b = str;
    }

    public final void onShake() {
        CodelessManager.m8906onActivityResumed$lambda0(this.f34607a, this.f34608b);
    }
}
