package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1", f = "ClickableText.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
public final class ClickableTextKt$ClickableText$pressIndicator$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f3352h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<TextLayoutResult> f3353i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f3354j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableTextKt$ClickableText$pressIndicator$1$1(MutableState<TextLayoutResult> mutableState, Function1<? super Integer, Unit> function1, Continuation<? super ClickableTextKt$ClickableText$pressIndicator$1$1> continuation) {
        super(2, continuation);
        this.f3353i = mutableState;
        this.f3354j = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ClickableTextKt$ClickableText$pressIndicator$1$1 clickableTextKt$ClickableText$pressIndicator$1$1 = new ClickableTextKt$ClickableText$pressIndicator$1$1(this.f3353i, this.f3354j, continuation);
        clickableTextKt$ClickableText$pressIndicator$1$1.L$0 = obj;
        return clickableTextKt$ClickableText$pressIndicator$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ClickableTextKt$ClickableText$pressIndicator$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3352h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final MutableState<TextLayoutResult> mutableState = this.f3353i;
            final Function1<Integer, Unit> function1 = this.f3354j;
            AnonymousClass1 r72 = new Function1<Offset, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m836invokek4lQ0M(((Offset) obj).m2686unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m836invokek4lQ0M(long j11) {
                    TextLayoutResult value = mutableState.getValue();
                    if (value != null) {
                        function1.invoke(Integer.valueOf(value.m5013getOffsetForPositionk4lQ0M(j11)));
                    }
                }
            };
            this.f3352h = 1;
            if (TapGestureDetectorKt.detectTapGestures$default((PointerInputScope) this.L$0, (Function1) null, (Function1) null, (Function3) null, r72, this, 7, (Object) null) == coroutine_suspended) {
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
