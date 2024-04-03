package w9;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class g implements IdTokenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f50786a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.TokenChangeListener f50787b;

    public /* synthetic */ g(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.f50786a = executorService;
        this.f50787b = tokenChangeListener;
    }

    public final void onIdTokenChanged(InternalTokenResult internalTokenResult) {
        this.f50786a.execute(new h(this.f50787b, internalTokenResult));
    }
}
