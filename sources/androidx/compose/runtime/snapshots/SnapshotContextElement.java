package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalComposeApi
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "Key", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SnapshotContextElement extends CoroutineContext.Element {
    @NotNull
    public static final Key Key = Key.f9526b;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(@NotNull SnapshotContextElement snapshotContextElement, R r11, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return CoroutineContext.Element.DefaultImpls.fold(snapshotContextElement, r11, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull SnapshotContextElement snapshotContextElement, @NotNull CoroutineContext.Key<E> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return CoroutineContext.Element.DefaultImpls.get(snapshotContextElement, key);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull SnapshotContextElement snapshotContextElement, @NotNull CoroutineContext.Key<?> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return CoroutineContext.Element.DefaultImpls.minusKey(snapshotContextElement, key);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull SnapshotContextElement snapshotContextElement, @NotNull CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(coroutineContext, "context");
            return CoroutineContext.Element.DefaultImpls.plus(snapshotContextElement, coroutineContext);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotContextElement$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "()V", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Key implements CoroutineContext.Key<SnapshotContextElement> {

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ Key f9526b = new Key();

        private Key() {
        }
    }
}
