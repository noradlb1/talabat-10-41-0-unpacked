package androidx.compose.material;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.material.RangeSliderLogic$captureThumb$1", f = "Slider.kt", i = {}, l = {1041}, m = "invokeSuspend", n = {}, s = {})
public final class RangeSliderLogic$captureThumb$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f4984h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RangeSliderLogic f4985i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4986j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Interaction f4987k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RangeSliderLogic$captureThumb$1(RangeSliderLogic rangeSliderLogic, boolean z11, Interaction interaction, Continuation<? super RangeSliderLogic$captureThumb$1> continuation) {
        super(2, continuation);
        this.f4985i = rangeSliderLogic;
        this.f4986j = z11;
        this.f4987k = interaction;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RangeSliderLogic$captureThumb$1(this.f4985i, this.f4986j, this.f4987k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RangeSliderLogic$captureThumb$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f4984h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableInteractionSource activeInteraction = this.f4985i.activeInteraction(this.f4986j);
            Interaction interaction = this.f4987k;
            this.f4984h = 1;
            if (activeInteraction.emit(interaction, this) == coroutine_suspended) {
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
