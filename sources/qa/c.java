package qa;

import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConfigCacheClient f50721b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ConfigContainer f50722c;

    public /* synthetic */ c(ConfigCacheClient configCacheClient, ConfigContainer configContainer) {
        this.f50721b = configCacheClient;
        this.f50722c = configContainer;
    }

    public final Object call() {
        return this.f50721b.lambda$put$0(this.f50722c);
    }
}
