package w9;

import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;
import com.google.firebase.database.core.TokenProvider;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class f implements AppCheckTokenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f50784a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.TokenChangeListener f50785b;

    public /* synthetic */ f(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.f50784a = executorService;
        this.f50785b = tokenChangeListener;
    }

    public final void onAppCheckTokenChanged(AppCheckTokenResult appCheckTokenResult) {
        this.f50784a.execute(new c(this.f50785b, appCheckTokenResult));
    }
}
