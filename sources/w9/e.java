package w9;

import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class e implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f50782a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.TokenChangeListener f50783b;

    public /* synthetic */ e(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.f50782a = executorService;
        this.f50783b = tokenChangeListener;
    }

    public final void handle(Provider provider) {
        ((InteropAppCheckTokenProvider) provider.get()).addAppCheckTokenListener(new f(this.f50782a, this.f50783b));
    }
}
