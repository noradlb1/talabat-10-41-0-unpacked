package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2", f = "ScrollExtensions.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollExtensionsKt$animateScrollBy$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2145h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f2146i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f2147j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f2148k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollExtensionsKt$animateScrollBy$2(float f11, AnimationSpec<Float> animationSpec, Ref.FloatRef floatRef, Continuation<? super ScrollExtensionsKt$animateScrollBy$2> continuation) {
        super(2, continuation);
        this.f2146i = f11;
        this.f2147j = animationSpec;
        this.f2148k = floatRef;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ScrollExtensionsKt$animateScrollBy$2 scrollExtensionsKt$animateScrollBy$2 = new ScrollExtensionsKt$animateScrollBy$2(this.f2146i, this.f2147j, this.f2148k, continuation);
        scrollExtensionsKt$animateScrollBy$2.L$0 = obj;
        return scrollExtensionsKt$animateScrollBy$2;
    }

    @Nullable
    public final Object invoke(@NotNull ScrollScope scrollScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ScrollExtensionsKt$animateScrollBy$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2145h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final ScrollScope scrollScope = (ScrollScope) this.L$0;
            float f11 = this.f2146i;
            AnimationSpec<Float> animationSpec = this.f2147j;
            final Ref.FloatRef floatRef = this.f2148k;
            AnonymousClass1 r72 = new Function2<Float, Float, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f11, float f12) {
                    Ref.FloatRef floatRef = floatRef;
                    float f13 = floatRef.element;
                    floatRef.element = f13 + scrollScope.scrollBy(f11 - f13);
                }
            };
            this.f2145h = 1;
            if (SuspendAnimationKt.animate$default(0.0f, f11, 0.0f, animationSpec, r72, this, 4, (Object) null) == coroutine_suspended) {
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
