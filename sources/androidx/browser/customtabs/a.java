package androidx.browser.customtabs;

import android.os.IBinder;
import androidx.browser.customtabs.CustomTabsService;

public final /* synthetic */ class a implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomTabsService.AnonymousClass1 f1007a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CustomTabsSessionToken f1008b;

    public /* synthetic */ a(CustomTabsService.AnonymousClass1 r12, CustomTabsSessionToken customTabsSessionToken) {
        this.f1007a = r12;
        this.f1008b = customTabsSessionToken;
    }

    public final void binderDied() {
        this.f1007a.lambda$newSessionInternal$0(this.f1008b);
    }
}
