package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.HoverableKt$hoverable$2$2$1", f = "Hoverable.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
public final class HoverableKt$hoverable$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f1684h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f1685i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<HoverInteraction.Enter> f1686j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1687k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HoverableKt$hoverable$2$2$1(boolean z11, MutableState<HoverInteraction.Enter> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super HoverableKt$hoverable$2$2$1> continuation) {
        super(2, continuation);
        this.f1685i = z11;
        this.f1686j = mutableState;
        this.f1687k = mutableInteractionSource;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HoverableKt$hoverable$2$2$1(this.f1685i, this.f1686j, this.f1687k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HoverableKt$hoverable$2$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1684h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.f1685i) {
                MutableState<HoverInteraction.Enter> mutableState = this.f1686j;
                MutableInteractionSource mutableInteractionSource = this.f1687k;
                this.f1684h = 1;
                if (HoverableKt$hoverable$2.invoke$emitExit(mutableState, mutableInteractionSource, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
