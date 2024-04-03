package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2", f = "WindowInsetsConnection.android.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, s = {})
public final class WindowInsetsNestedScrollConnection$fling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2603h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsNestedScrollConnection f2604i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f2605j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f2606k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SplineBasedFloatDecayAnimationSpec f2607l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f2608m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f2609n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f2610o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsAnimationController f2611p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f2612q;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1", f = "WindowInsetsConnection.android.kt", i = {}, l = {332}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f2613h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(i12, f11, splineBasedFloatDecayAnimationSpec, i13, i14, windowInsetsNestedScrollConnection2, floatRef, windowInsetsAnimationController, z11, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f2613h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                float f11 = f11;
                SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec = splineBasedFloatDecayAnimationSpec;
                final int i12 = i13;
                final int i13 = i14;
                final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = windowInsetsNestedScrollConnection2;
                final Ref.FloatRef floatRef = floatRef;
                final WindowInsetsAnimationController windowInsetsAnimationController = windowInsetsAnimationController;
                final boolean z11 = z11;
                AnonymousClass1 r42 = new Function2<Float, Float, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f11, float f12) {
                        float f13 = (float) i12;
                        boolean z11 = false;
                        if (f11 <= ((float) i13) && f13 <= f11) {
                            z11 = true;
                        }
                        if (z11) {
                            windowInsetsNestedScrollConnection.adjustInsets(f11);
                            return;
                        }
                        floatRef.element = f12;
                        windowInsetsAnimationController.finish(z11);
                        windowInsetsNestedScrollConnection.animationController = null;
                        Job access$getAnimationJob$p = windowInsetsNestedScrollConnection.animationJob;
                        if (access$getAnimationJob$p != null) {
                            Job.DefaultImpls.cancel$default(access$getAnimationJob$p, (CancellationException) null, 1, (Object) null);
                        }
                    }
                };
                this.f2613h = 1;
                if (SuspendAnimationKt.animateDecay((float) i12, f11, (FloatDecayAnimationSpec) splineBasedFloatDecayAnimationSpec, (Function2<? super Float, ? super Float, Unit>) r42, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
    public WindowInsetsNestedScrollConnection$fling$2(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, int i11, float f11, SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec, int i12, int i13, Ref.FloatRef floatRef, WindowInsetsAnimationController windowInsetsAnimationController, boolean z11, Continuation<? super WindowInsetsNestedScrollConnection$fling$2> continuation) {
        super(2, continuation);
        this.f2604i = windowInsetsNestedScrollConnection;
        this.f2605j = i11;
        this.f2606k = f11;
        this.f2607l = splineBasedFloatDecayAnimationSpec;
        this.f2608m = i12;
        this.f2609n = i13;
        this.f2610o = floatRef;
        this.f2611p = windowInsetsAnimationController;
        this.f2612q = z11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WindowInsetsNestedScrollConnection$fling$2 windowInsetsNestedScrollConnection$fling$2 = new WindowInsetsNestedScrollConnection$fling$2(this.f2604i, this.f2605j, this.f2606k, this.f2607l, this.f2608m, this.f2609n, this.f2610o, this.f2611p, this.f2612q, continuation);
        windowInsetsNestedScrollConnection$fling$2.L$0 = obj;
        return windowInsetsNestedScrollConnection$fling$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WindowInsetsNestedScrollConnection$fling$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2603h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = this.f2604i;
            final int i12 = this.f2605j;
            final float f11 = this.f2606k;
            final SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec = this.f2607l;
            final int i13 = this.f2608m;
            final int i14 = this.f2609n;
            final Ref.FloatRef floatRef = this.f2610o;
            final WindowInsetsAnimationController windowInsetsAnimationController = this.f2611p;
            final boolean z11 = this.f2612q;
            final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection2 = windowInsetsNestedScrollConnection;
            windowInsetsNestedScrollConnection.animationJob = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            Job access$getAnimationJob$p = this.f2604i.animationJob;
            if (access$getAnimationJob$p != null) {
                this.f2603h = 1;
                if (access$getAnimationJob$p.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f2604i.animationJob = null;
        return Unit.INSTANCE;
    }
}
