package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.unit.Dp;
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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.DefaultButtonElevation$elevation$2", f = "Button.kt", i = {}, l = {551}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultButtonElevation$elevation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f4371h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<Dp, AnimationVector1D> f4372i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f4373j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultButtonElevation$elevation$2(Animatable<Dp, AnimationVector1D> animatable, float f11, Continuation<? super DefaultButtonElevation$elevation$2> continuation) {
        super(2, continuation);
        this.f4372i = animatable;
        this.f4373j = f11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultButtonElevation$elevation$2(this.f4372i, this.f4373j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultButtonElevation$elevation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f4371h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Dp, AnimationVector1D> animatable = this.f4372i;
            Dp r12 = Dp.m5476boximpl(this.f4373j);
            this.f4371h = 1;
            if (animatable.snapTo(r12, this) == coroutine_suspended) {
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
