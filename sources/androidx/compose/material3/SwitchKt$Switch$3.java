package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SwitchKt$Switch$3 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Animatable<Float, AnimationVector1D> f8473g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f8474h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f8475i;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SwitchKt$Switch$3$1", f = "Switch.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.SwitchKt$Switch$3$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f8476h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(animatable, f11, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f8476h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable<Float, AnimationVector1D> animatable = animatable;
                Float boxFloat = Boxing.boxFloat(f11);
                TweenSpec access$getAnimationSpec$p = SwitchKt.AnimationSpec;
                this.f8476h = 1;
                if (Animatable.animateTo$default(animatable, boxFloat, access$getAnimationSpec$p, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchKt$Switch$3(Animatable<Float, AnimationVector1D> animatable, float f11, CoroutineScope coroutineScope) {
        super(1);
        this.f8473g = animatable;
        this.f8474h = f11;
        this.f8475i = coroutineScope;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        float floatValue = this.f8473g.getTargetValue().floatValue();
        final float f11 = this.f8474h;
        if (!(floatValue == f11)) {
            CoroutineScope coroutineScope = this.f8475i;
            final Animatable<Float, AnimationVector1D> animatable = this.f8473g;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        }
        return new SwitchKt$Switch$3$invoke$$inlined$onDispose$1();
    }
}
