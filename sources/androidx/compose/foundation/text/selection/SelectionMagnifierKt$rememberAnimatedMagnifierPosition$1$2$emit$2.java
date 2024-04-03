package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.geometry.Offset;
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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2", f = "SelectionMagnifier.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
public final class SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f3701h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<Offset, AnimationVector2D> f3702i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f3703j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2(Animatable<Offset, AnimationVector2D> animatable, long j11, Continuation<? super SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2> continuation) {
        super(2, continuation);
        this.f3702i = animatable;
        this.f3703j = j11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2(this.f3702i, this.f3703j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3701h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Offset, AnimationVector2D> animatable = this.f3702i;
            Offset r102 = Offset.m2665boximpl(this.f3703j);
            SpringSpec access$getMagnifierSpringSpec$p = SelectionMagnifierKt.MagnifierSpringSpec;
            this.f3701h = 1;
            if (Animatable.animateTo$default(animatable, r102, access$getMagnifierSpringSpec$p, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
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
