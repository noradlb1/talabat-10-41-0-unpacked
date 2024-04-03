package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0005R\u0014\u0010\n\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "toString", "", "parallelism", "limitedParallelism", "a", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "immediate", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    @Nullable
    @InternalCoroutinesApi
    public final String a() {
        MainCoroutineDispatcher mainCoroutineDispatcher;
        MainCoroutineDispatcher main = Dispatchers.getMain();
        if (this == main) {
            return "Dispatchers.Main";
        }
        try {
            mainCoroutineDispatcher = main.getImmediate();
        } catch (UnsupportedOperationException unused) {
            mainCoroutineDispatcher = null;
        }
        if (this == mainCoroutineDispatcher) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @NotNull
    public abstract MainCoroutineDispatcher getImmediate();

    @NotNull
    public CoroutineDispatcher limitedParallelism(int i11) {
        LimitedDispatcherKt.checkParallelism(i11);
        return this;
    }

    @NotNull
    public String toString() {
        String a11 = a();
        if (a11 != null) {
            return a11;
        }
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this);
    }
}
