package w9;

import com.google.firebase.database.android.AndroidAppCheckTokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class d implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppCheckTokenProvider f50781a;

    public /* synthetic */ d(AndroidAppCheckTokenProvider androidAppCheckTokenProvider) {
        this.f50781a = androidAppCheckTokenProvider;
    }

    public final void handle(Provider provider) {
        this.f50781a.lambda$new$0(provider);
    }
}
