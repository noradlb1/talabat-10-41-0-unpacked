package qa;

import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConfigStorageClient f50720b;

    public /* synthetic */ b(ConfigStorageClient configStorageClient) {
        this.f50720b = configStorageClient;
    }

    public final Object call() {
        return this.f50720b.read();
    }
}
