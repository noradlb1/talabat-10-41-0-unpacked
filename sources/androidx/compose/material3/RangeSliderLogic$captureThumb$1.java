package androidx.compose.material3;

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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.material3.RangeSliderLogic$captureThumb$1", f = "Slider.kt", i = {}, l = {1288}, m = "invokeSuspend", n = {}, s = {})
public final class RangeSliderLogic$captureThumb$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f7834h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RangeSliderLogic f7835i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7836j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Interaction f7837k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RangeSliderLogic$captureThumb$1(RangeSliderLogic rangeSliderLogic, boolean z11, Interaction interaction, Continuation<? super RangeSliderLogic$captureThumb$1> continuation) {
        super(2, continuation);
        this.f7835i = rangeSliderLogic;
        this.f7836j = z11;
        this.f7837k = interaction;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RangeSliderLogic$captureThumb$1(this.f7835i, this.f7836j, this.f7837k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RangeSliderLogic$captureThumb$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f7834h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableInteractionSource activeInteraction = this.f7835i.activeInteraction(this.f7836j);
            Interaction interaction = this.f7837k;
            this.f7834h = 1;
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
