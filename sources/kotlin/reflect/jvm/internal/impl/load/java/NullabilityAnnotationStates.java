package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface NullabilityAnnotationStates<T> {
    @NotNull
    public static final Companion Companion = Companion.f24567a;

    public static final class Companion {
        @NotNull
        private static final NullabilityAnnotationStates EMPTY = new NullabilityAnnotationStatesImpl(MapsKt__MapsKt.emptyMap());

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f24567a = new Companion();

        private Companion() {
        }

        @NotNull
        public final NullabilityAnnotationStates getEMPTY() {
            return EMPTY;
        }
    }

    @Nullable
    T get(@NotNull FqName fqName);
}
