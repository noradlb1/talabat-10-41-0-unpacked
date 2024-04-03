package w9;

import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.database.core.TokenProvider;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.TokenChangeListener f50779b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppCheckTokenResult f50780c;

    public /* synthetic */ c(TokenProvider.TokenChangeListener tokenChangeListener, AppCheckTokenResult appCheckTokenResult) {
        this.f50779b = tokenChangeListener;
        this.f50780c = appCheckTokenResult;
    }

    public final void run() {
        this.f50779b.onTokenChange(this.f50780c.getToken());
    }
}
