package w9;

import com.google.firebase.database.android.AndroidAuthTokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class j implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAuthTokenProvider f50792a;

    public /* synthetic */ j(AndroidAuthTokenProvider androidAuthTokenProvider) {
        this.f50792a = androidAuthTokenProvider;
    }

    public final void handle(Provider provider) {
        this.f50792a.lambda$new$0(provider);
    }
}
