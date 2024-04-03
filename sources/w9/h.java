package w9;

import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.internal.InternalTokenResult;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.TokenChangeListener f50788b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InternalTokenResult f50789c;

    public /* synthetic */ h(TokenProvider.TokenChangeListener tokenChangeListener, InternalTokenResult internalTokenResult) {
        this.f50788b = tokenChangeListener;
        this.f50789c = internalTokenResult;
    }

    public final void run() {
        this.f50788b.onTokenChange(this.f50789c.getToken());
    }
}
