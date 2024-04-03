package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import m0.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0001\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/InfiniteAnimationPolicy;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onInfiniteOperation", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Key", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface InfiniteAnimationPolicy extends CoroutineContext.Element {
    @NotNull
    public static final Key Key = Key.f10039b;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(@NotNull InfiniteAnimationPolicy infiniteAnimationPolicy, R r11, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return CoroutineContext.Element.DefaultImpls.fold(infiniteAnimationPolicy, r11, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull InfiniteAnimationPolicy infiniteAnimationPolicy, @NotNull CoroutineContext.Key<E> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return CoroutineContext.Element.DefaultImpls.get(infiniteAnimationPolicy, key);
        }

        @NotNull
        @Deprecated
        public static CoroutineContext.Key<?> getKey(@NotNull InfiniteAnimationPolicy infiniteAnimationPolicy) {
            return t.a(infiniteAnimationPolicy);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull InfiniteAnimationPolicy infiniteAnimationPolicy, @NotNull CoroutineContext.Key<?> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return CoroutineContext.Element.DefaultImpls.minusKey(infiniteAnimationPolicy, key);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull InfiniteAnimationPolicy infiniteAnimationPolicy, @NotNull CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(coroutineContext, "context");
            return CoroutineContext.Element.DefaultImpls.plus(infiniteAnimationPolicy, coroutineContext);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/platform/InfiniteAnimationPolicy$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/ui/platform/InfiniteAnimationPolicy;", "()V", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Key implements CoroutineContext.Key<InfiniteAnimationPolicy> {

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ Key f10039b = new Key();

        private Key() {
        }
    }

    @NotNull
    CoroutineContext.Key<?> getKey();

    @Nullable
    <R> Object onInfiniteOperation(@NotNull Function1<? super Continuation<? super R>, ? extends Object> function1, @NotNull Continuation<? super R> continuation);
}
