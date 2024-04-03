package b00;

import com.google.common.util.concurrent.SettableFuture;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f11670b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callable f11671c;

    public /* synthetic */ a(SettableFuture settableFuture, Callable callable) {
        this.f11670b = settableFuture;
        this.f11671c = callable;
    }

    public final void run() {
        PathProviderPlugin.lambda$executeInBackground$0(this.f11670b, this.f11671c);
    }
}
