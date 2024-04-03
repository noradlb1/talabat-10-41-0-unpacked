package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.material.ripple.CommonRippleIndicationInstance$addRipple$2", f = "CommonRipple.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
public final class CommonRippleIndicationInstance$addRipple$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f6217h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RippleAnimation f6218i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CommonRippleIndicationInstance f6219j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PressInteraction.Press f6220k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonRippleIndicationInstance$addRipple$2(RippleAnimation rippleAnimation, CommonRippleIndicationInstance commonRippleIndicationInstance, PressInteraction.Press press, Continuation<? super CommonRippleIndicationInstance$addRipple$2> continuation) {
        super(2, continuation);
        this.f6218i = rippleAnimation;
        this.f6219j = commonRippleIndicationInstance;
        this.f6220k = press;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommonRippleIndicationInstance$addRipple$2(this.f6218i, this.f6219j, this.f6220k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CommonRippleIndicationInstance$addRipple$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f6217h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            RippleAnimation rippleAnimation = this.f6218i;
            this.f6217h = 1;
            if (rippleAnimation.animate(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                this.f6219j.ripples.remove(this.f6220k);
                throw th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f6219j.ripples.remove(this.f6220k);
        return Unit.INSTANCE;
    }
}
