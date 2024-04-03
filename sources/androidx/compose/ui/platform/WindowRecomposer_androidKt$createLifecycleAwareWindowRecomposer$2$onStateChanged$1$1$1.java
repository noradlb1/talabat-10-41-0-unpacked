package androidx.compose.ui.platform;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1", f = "WindowRecomposer.android.kt", i = {}, l = {386}, m = "invokeSuspend", n = {}, s = {})
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f10089h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ StateFlow<Float> f10090i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MotionDurationScaleImpl f10091j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1(StateFlow<Float> stateFlow, MotionDurationScaleImpl motionDurationScaleImpl, Continuation<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1> continuation) {
        super(2, continuation);
        this.f10090i = stateFlow;
        this.f10091j = motionDurationScaleImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1(this.f10090i, this.f10091j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f10089h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<Float> stateFlow = this.f10090i;
            final MotionDurationScaleImpl motionDurationScaleImpl = this.f10091j;
            AnonymousClass1 r12 = new FlowCollector<Float>() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Number) obj).floatValue(), (Continuation<? super Unit>) continuation);
                }

                @Nullable
                public final Object emit(float f11, @NotNull Continuation<? super Unit> continuation) {
                    motionDurationScaleImpl.setScaleFactor(f11);
                    return Unit.INSTANCE;
                }
            };
            this.f10089h = 1;
            if (stateFlow.collect(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
