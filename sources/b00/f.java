package b00;

import io.flutter.plugins.pathprovider.PathProviderPlugin;
import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PathProviderPlugin f11676b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f11677c;

    public /* synthetic */ f(PathProviderPlugin pathProviderPlugin, String str) {
        this.f11676b = pathProviderPlugin;
        this.f11677c = str;
    }

    public final Object call() {
        return this.f11676b.lambda$onMethodCall$5(this.f11677c);
    }
}
