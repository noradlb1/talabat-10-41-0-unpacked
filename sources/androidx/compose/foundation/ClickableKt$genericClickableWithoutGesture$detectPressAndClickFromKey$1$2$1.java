package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
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
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1", f = "Clickable.kt", i = {}, l = {549}, m = "invokeSuspend", n = {}, s = {})
public final class ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f1612h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1613i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PressInteraction.Press f1614j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1(MutableInteractionSource mutableInteractionSource, PressInteraction.Press press, Continuation<? super ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1> continuation) {
        super(2, continuation);
        this.f1613i = mutableInteractionSource;
        this.f1614j = press;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1(this.f1613i, this.f1614j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1612h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableInteractionSource mutableInteractionSource = this.f1613i;
            PressInteraction.Release release = new PressInteraction.Release(this.f1614j);
            this.f1612h = 1;
            if (mutableInteractionSource.emit(release, this) == coroutine_suspended) {
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
