package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1", f = "LazyNearestItemsRange.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
public final class LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f3053h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Integer> f3054i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Integer> f3055j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Integer> f3056k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableState<IntRange> f3057l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1(Function0<Integer> function0, Function0<Integer> function02, Function0<Integer> function03, MutableState<IntRange> mutableState, Continuation<? super LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1> continuation) {
        super(2, continuation);
        this.f3054i = function0;
        this.f3055j = function02;
        this.f3056k = function03;
        this.f3057l = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1(this.f3054i, this.f3055j, this.f3056k, this.f3057l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3053h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final Function0<Integer> function0 = this.f3054i;
            final Function0<Integer> function02 = this.f3055j;
            final Function0<Integer> function03 = this.f3056k;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<IntRange>() {
                @NotNull
                public final IntRange invoke() {
                    return LazyNearestItemsRangeKt.calculateNearestItemsRange(function0.invoke().intValue(), function02.invoke().intValue(), function03.invoke().intValue());
                }
            });
            final MutableState<IntRange> mutableState = this.f3057l;
            AnonymousClass2 r12 = new FlowCollector<IntRange>() {
                @Nullable
                public final Object emit(@NotNull IntRange intRange, @NotNull Continuation<? super Unit> continuation) {
                    mutableState.setValue(intRange);
                    return Unit.INSTANCE;
                }
            };
            this.f3053h = 1;
            if (snapshotFlow.collect(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
