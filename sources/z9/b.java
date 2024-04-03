package z9;

import com.google.firebase.database.core.SyncTree;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SyncTree f50810b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QuerySpec f50811c;

    public /* synthetic */ b(SyncTree syncTree, QuerySpec querySpec) {
        this.f50810b = syncTree;
        this.f50811c = querySpec;
    }

    public final Object call() {
        return this.f50810b.lambda$getServerValue$0(this.f50811c);
    }
}
