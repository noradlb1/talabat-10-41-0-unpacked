package androidx.compose.material3;

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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SnackbarHostKt$animatedOpacity$2", f = "SnackbarHost.kt", i = {}, l = {434}, m = "invokeSuspend", n = {}, s = {})
public final class SnackbarHostKt$animatedOpacity$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f8241h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<Float, AnimationVector1D> f8242i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f8243j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f8244k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8245l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$animatedOpacity$2(Animatable<Float, AnimationVector1D> animatable, boolean z11, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Continuation<? super SnackbarHostKt$animatedOpacity$2> continuation) {
        super(2, continuation);
        this.f8242i = animatable;
        this.f8243j = z11;
        this.f8244k = animationSpec;
        this.f8245l = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SnackbarHostKt$animatedOpacity$2(this.f8242i, this.f8243j, this.f8244k, this.f8245l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SnackbarHostKt$animatedOpacity$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        float f11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f8241h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Float, AnimationVector1D> animatable = this.f8242i;
            if (this.f8243j) {
                f11 = 1.0f;
            } else {
                f11 = 0.0f;
            }
            Float boxFloat = Boxing.boxFloat(f11);
            AnimationSpec<Float> animationSpec = this.f8244k;
            this.f8241h = 1;
            if (Animatable.animateTo$default(animatable, boxFloat, animationSpec, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f8245l.invoke();
        return Unit.INSTANCE;
    }
}
