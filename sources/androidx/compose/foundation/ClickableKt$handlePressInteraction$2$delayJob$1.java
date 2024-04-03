package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$handlePressInteraction$2$delayJob$1", f = "Clickable.kt", i = {1}, l = {439, 442}, m = "invokeSuspend", n = {"pressInteraction"}, s = {"L$0"})
public final class ClickableKt$handlePressInteraction$2$delayJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f1622h;

    /* renamed from: i  reason: collision with root package name */
    public int f1623i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<Function0<Boolean>> f1624j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f1625k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1626l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableState<PressInteraction.Press> f1627m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$handlePressInteraction$2$delayJob$1(State<? extends Function0<Boolean>> state, long j11, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, Continuation<? super ClickableKt$handlePressInteraction$2$delayJob$1> continuation) {
        super(2, continuation);
        this.f1624j = state;
        this.f1625k = j11;
        this.f1626l = mutableInteractionSource;
        this.f1627m = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ClickableKt$handlePressInteraction$2$delayJob$1(this.f1624j, this.f1625k, this.f1626l, this.f1627m, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ClickableKt$handlePressInteraction$2$delayJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PressInteraction.Press press;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1623i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (((Boolean) this.f1624j.getValue().invoke()).booleanValue()) {
                long tapIndicationDelay = Clickable_androidKt.getTapIndicationDelay();
                this.f1623i = 1;
                if (DelayKt.delay(tapIndicationDelay, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            press = (PressInteraction.Press) this.f1622h;
            ResultKt.throwOnFailure(obj);
            this.f1627m.setValue(press);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PressInteraction.Press press2 = new PressInteraction.Press(this.f1625k, (DefaultConstructorMarker) null);
        MutableInteractionSource mutableInteractionSource = this.f1626l;
        this.f1622h = press2;
        this.f1623i = 2;
        if (mutableInteractionSource.emit(press2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        press = press2;
        this.f1627m.setValue(press);
        return Unit.INSTANCE;
    }
}
