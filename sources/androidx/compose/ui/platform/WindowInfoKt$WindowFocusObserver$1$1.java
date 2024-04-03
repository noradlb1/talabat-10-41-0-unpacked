package androidx.compose.ui.platform;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowInfoKt$WindowFocusObserver$1$1", f = "WindowInfo.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class WindowInfoKt$WindowFocusObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f10064h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WindowInfo f10065i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<Function1<Boolean, Unit>> f10066j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowInfoKt$WindowFocusObserver$1$1(WindowInfo windowInfo, State<? extends Function1<? super Boolean, Unit>> state, Continuation<? super WindowInfoKt$WindowFocusObserver$1$1> continuation) {
        super(2, continuation);
        this.f10065i = windowInfo;
        this.f10066j = state;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WindowInfoKt$WindowFocusObserver$1$1(this.f10065i, this.f10066j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WindowInfoKt$WindowFocusObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f10064h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final WindowInfo windowInfo = this.f10065i;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Boolean>() {
                @NotNull
                public final Boolean invoke() {
                    return Boolean.valueOf(windowInfo.isWindowFocused());
                }
            });
            final State<Function1<Boolean, Unit>> state = this.f10066j;
            AnonymousClass2 r12 = new FlowCollector<Boolean>() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                @Nullable
                public final Object emit(boolean z11, @NotNull Continuation<? super Unit> continuation) {
                    state.getValue().invoke(Boxing.boxBoolean(z11));
                    return Unit.INSTANCE;
                }
            };
            this.f10064h = 1;
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
