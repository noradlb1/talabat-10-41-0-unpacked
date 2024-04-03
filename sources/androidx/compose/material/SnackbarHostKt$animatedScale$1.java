package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SnackbarHostKt$animatedScale$1", f = "SnackbarHost.kt", i = {}, l = {363}, m = "invokeSuspend", n = {}, s = {})
public final class SnackbarHostKt$animatedScale$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f5386h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<Float, AnimationVector1D> f5387i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5388j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f5389k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$animatedScale$1(Animatable<Float, AnimationVector1D> animatable, boolean z11, AnimationSpec<Float> animationSpec, Continuation<? super SnackbarHostKt$animatedScale$1> continuation) {
        super(2, continuation);
        this.f5387i = animatable;
        this.f5388j = z11;
        this.f5389k = animationSpec;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SnackbarHostKt$animatedScale$1(this.f5387i, this.f5388j, this.f5389k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SnackbarHostKt$animatedScale$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        float f11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f5386h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Float, AnimationVector1D> animatable = this.f5387i;
            if (this.f5388j) {
                f11 = 1.0f;
            } else {
                f11 = 0.8f;
            }
            Float boxFloat = Boxing.boxFloat(f11);
            AnimationSpec<Float> animationSpec = this.f5389k;
            this.f5386h = 1;
            if (Animatable.animateTo$default(animatable, boxFloat, animationSpec, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
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
