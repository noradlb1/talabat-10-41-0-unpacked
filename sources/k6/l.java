package k6;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;

public final /* synthetic */ class l implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FacebookSdk.InitializeCallback f34512b;

    public /* synthetic */ l(FacebookSdk.InitializeCallback initializeCallback) {
        this.f34512b = initializeCallback;
    }

    public final Object call() {
        return FacebookSdk.m8869sdkInitialize$lambda9(this.f34512b);
    }
}
