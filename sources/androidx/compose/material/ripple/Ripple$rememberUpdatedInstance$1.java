package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.ripple.Ripple$rememberUpdatedInstance$1", f = "Ripple.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, s = {})
public final class Ripple$rememberUpdatedInstance$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f6223h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f6224i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RippleIndicationInstance f6225j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Ripple$rememberUpdatedInstance$1(InteractionSource interactionSource, RippleIndicationInstance rippleIndicationInstance, Continuation<? super Ripple$rememberUpdatedInstance$1> continuation) {
        super(2, continuation);
        this.f6224i = interactionSource;
        this.f6225j = rippleIndicationInstance;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Ripple$rememberUpdatedInstance$1 ripple$rememberUpdatedInstance$1 = new Ripple$rememberUpdatedInstance$1(this.f6224i, this.f6225j, continuation);
        ripple$rememberUpdatedInstance$1.L$0 = obj;
        return ripple$rememberUpdatedInstance$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((Ripple$rememberUpdatedInstance$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f6223h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Interaction> interactions = this.f6224i.getInteractions();
            Ripple$rememberUpdatedInstance$1$invokeSuspend$$inlined$collect$1 ripple$rememberUpdatedInstance$1$invokeSuspend$$inlined$collect$1 = new Ripple$rememberUpdatedInstance$1$invokeSuspend$$inlined$collect$1(this.f6225j, (CoroutineScope) this.L$0);
            this.f6223h = 1;
            if (interactions.collect(ripple$rememberUpdatedInstance$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
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
