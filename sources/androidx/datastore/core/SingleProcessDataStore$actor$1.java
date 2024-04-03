package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"T", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SingleProcessDataStore$actor$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f35634g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$actor$1(SingleProcessDataStore<T> singleProcessDataStore) {
        super(1);
        this.f35634g = singleProcessDataStore;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2) {
        if (th2 != null) {
            this.f35634g.downstreamFlow.setValue(new Final(th2));
        }
        SingleProcessDataStore.Companion companion = SingleProcessDataStore.Companion;
        Object activeFilesLock$datastore_core = companion.getActiveFilesLock$datastore_core();
        SingleProcessDataStore<T> singleProcessDataStore = this.f35634g;
        synchronized (activeFilesLock$datastore_core) {
            companion.getActiveFiles$datastore_core().remove(singleProcessDataStore.getFile().getAbsolutePath());
            Unit unit = Unit.INSTANCE;
        }
    }
}
