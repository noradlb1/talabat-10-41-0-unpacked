package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.material.ripple.StateLayer$handleInteraction$1", f = "Ripple.kt", i = {}, l = {290}, m = "invokeSuspend", n = {}, s = {})
public final class StateLayer$handleInteraction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f6243h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ StateLayer f6244i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f6245j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f6246k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StateLayer$handleInteraction$1(StateLayer stateLayer, float f11, AnimationSpec<Float> animationSpec, Continuation<? super StateLayer$handleInteraction$1> continuation) {
        super(2, continuation);
        this.f6244i = stateLayer;
        this.f6245j = f11;
        this.f6246k = animationSpec;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StateLayer$handleInteraction$1(this.f6244i, this.f6245j, this.f6246k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StateLayer$handleInteraction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f6243h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable access$getAnimatedAlpha$p = this.f6244i.animatedAlpha;
            Float boxFloat = Boxing.boxFloat(this.f6245j);
            AnimationSpec<Float> animationSpec = this.f6246k;
            this.f6243h = 1;
            if (Animatable.animateTo$default(access$getAnimatedAlpha$p, boxFloat, animationSpec, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
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
