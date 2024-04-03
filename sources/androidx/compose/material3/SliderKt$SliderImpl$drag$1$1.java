package androidx.compose.material3;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SliderKt$SliderImpl$drag$1$1", f = "Slider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SliderKt$SliderImpl$drag$1$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f8083h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Function0<Unit>> f8084i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$SliderImpl$drag$1$1(State<? extends Function0<Unit>> state, Continuation<? super SliderKt$SliderImpl$drag$1$1> continuation) {
        super(3, continuation);
        this.f8084i = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CoroutineScope) obj, ((Number) obj2).floatValue(), (Continuation<? super Unit>) (Continuation) obj3);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, float f11, @Nullable Continuation<? super Unit> continuation) {
        return new SliderKt$SliderImpl$drag$1$1(this.f8084i, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f8083h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f8084i.getValue().invoke();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
