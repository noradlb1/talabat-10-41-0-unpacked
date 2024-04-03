package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.locks.Lock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SimpleLock {
    @NotNull
    public static final Companion Companion = Companion.f24923a;

    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f24923a = new Companion();

        private Companion() {
        }

        @NotNull
        public final DefaultSimpleLock simpleLock(@Nullable Runnable runnable, @Nullable Function1<? super InterruptedException, Unit> function1) {
            if (runnable == null || function1 == null) {
                return new DefaultSimpleLock((Lock) null, 1, (DefaultConstructorMarker) null);
            }
            return new CancellableSimpleLock(runnable, function1);
        }
    }

    void lock();

    void unlock();
}
