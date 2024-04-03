package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$2", f = "TransformableState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TransformableStateKt$zoomBy$2 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2371h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f2372i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransformableStateKt$zoomBy$2(float f11, Continuation<? super TransformableStateKt$zoomBy$2> continuation) {
        super(2, continuation);
        this.f2372i = f11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TransformableStateKt$zoomBy$2 transformableStateKt$zoomBy$2 = new TransformableStateKt$zoomBy$2(this.f2372i, continuation);
        transformableStateKt$zoomBy$2.L$0 = obj;
        return transformableStateKt$zoomBy$2;
    }

    @Nullable
    public final Object invoke(@NotNull TransformScope transformScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TransformableStateKt$zoomBy$2) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f2371h == 0) {
            ResultKt.throwOnFailure(obj);
            ((TransformScope) this.L$0).m361transformByd4ec7I(this.f2372i, Offset.Companion.m2692getZeroF1C5BW0(), 0.0f);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
