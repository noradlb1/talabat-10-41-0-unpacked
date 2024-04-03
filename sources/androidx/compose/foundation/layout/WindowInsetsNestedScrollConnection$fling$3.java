package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3", f = "WindowInsetsConnection.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WindowInsetsNestedScrollConnection$fling$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2629h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsNestedScrollConnection f2630i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f2631j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f2632k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f2633l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsAnimationController f2634m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f2635n;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3$1", f = "WindowInsetsConnection.android.kt", i = {}, l = {358}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$3$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f2636h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(i11, i12, f11, windowInsetsAnimationController, z11, windowInsetsNestedScrollConnection2, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f2636h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable Animatable$default = AnimatableKt.Animatable$default((float) i11, 0.0f, 2, (Object) null);
                Float boxFloat = Boxing.boxFloat((float) i12);
                Float boxFloat2 = Boxing.boxFloat(f11);
                final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = windowInsetsNestedScrollConnection2;
                AnonymousClass1 r92 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Animatable<Float, AnimationVector1D>) (Animatable) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Animatable<Float, AnimationVector1D> animatable) {
                        Intrinsics.checkNotNullParameter(animatable, "$this$animateTo");
                        windowInsetsNestedScrollConnection.adjustInsets(animatable.getValue().floatValue());
                    }
                };
                this.f2636h = 1;
                if (Animatable.animateTo$default(Animatable$default, boxFloat, (AnimationSpec) null, boxFloat2, r92, this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            windowInsetsAnimationController.finish(z11);
            windowInsetsNestedScrollConnection2.animationController = null;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowInsetsNestedScrollConnection$fling$3(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, int i11, int i12, float f11, WindowInsetsAnimationController windowInsetsAnimationController, boolean z11, Continuation<? super WindowInsetsNestedScrollConnection$fling$3> continuation) {
        super(2, continuation);
        this.f2630i = windowInsetsNestedScrollConnection;
        this.f2631j = i11;
        this.f2632k = i12;
        this.f2633l = f11;
        this.f2634m = windowInsetsAnimationController;
        this.f2635n = z11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WindowInsetsNestedScrollConnection$fling$3 windowInsetsNestedScrollConnection$fling$3 = new WindowInsetsNestedScrollConnection$fling$3(this.f2630i, this.f2631j, this.f2632k, this.f2633l, this.f2634m, this.f2635n, continuation);
        windowInsetsNestedScrollConnection$fling$3.L$0 = obj;
        return windowInsetsNestedScrollConnection$fling$3;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WindowInsetsNestedScrollConnection$fling$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f2629h == 0) {
            ResultKt.throwOnFailure(obj);
            WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = this.f2630i;
            final int i11 = this.f2631j;
            final int i12 = this.f2632k;
            final float f11 = this.f2633l;
            final WindowInsetsAnimationController windowInsetsAnimationController = this.f2634m;
            final boolean z11 = this.f2635n;
            final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection2 = windowInsetsNestedScrollConnection;
            windowInsetsNestedScrollConnection.animationJob = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
