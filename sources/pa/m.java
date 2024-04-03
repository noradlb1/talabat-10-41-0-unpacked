package pa;

import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.concurrent.Callable;

public final /* synthetic */ class m implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RemoteConfigComponent f50708b;

    public /* synthetic */ m(RemoteConfigComponent remoteConfigComponent) {
        this.f50708b = remoteConfigComponent;
    }

    public final Object call() {
        return this.f50708b.getDefault();
    }
}
