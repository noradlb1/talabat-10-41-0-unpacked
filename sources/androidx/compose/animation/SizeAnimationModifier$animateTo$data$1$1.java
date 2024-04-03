package androidx.compose.animation;

import androidx.compose.animation.SizeAnimationModifier;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationEndReason;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.animation.SizeAnimationModifier$animateTo$data$1$1", f = "AnimationModifier.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
public final class SizeAnimationModifier$animateTo$data$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f1268h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SizeAnimationModifier.AnimData f1269i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f1270j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SizeAnimationModifier f1271k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SizeAnimationModifier$animateTo$data$1$1(SizeAnimationModifier.AnimData animData, long j11, SizeAnimationModifier sizeAnimationModifier, Continuation<? super SizeAnimationModifier$animateTo$data$1$1> continuation) {
        super(2, continuation);
        this.f1269i = animData;
        this.f1270j = j11;
        this.f1271k = sizeAnimationModifier;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SizeAnimationModifier$animateTo$data$1$1(this.f1269i, this.f1270j, this.f1271k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SizeAnimationModifier$animateTo$data$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Function2<IntSize, IntSize, Unit> listener;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1268h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<IntSize, AnimationVector2D> anim = this.f1269i.getAnim();
            IntSize r42 = IntSize.m5630boximpl(this.f1270j);
            AnimationSpec<IntSize> animSpec = this.f1271k.getAnimSpec();
            this.f1268h = 1;
            obj = Animatable.animateTo$default(anim, r42, animSpec, (Object) null, (Function1) null, this, 12, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnimationResult animationResult = (AnimationResult) obj;
        if (animationResult.getEndReason() == AnimationEndReason.Finished && (listener = this.f1271k.getListener()) != null) {
            listener.invoke(IntSize.m5630boximpl(this.f1269i.m92getStartSizeYbymL2g()), animationResult.getEndState().getValue());
        }
        return Unit.INSTANCE;
    }
}
