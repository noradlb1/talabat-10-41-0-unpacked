package androidx.compose.material3;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SwipeableKt$rememberSwipeableStateFor$2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ T f8402g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f8403h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Unit> f8404i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f8405j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableKt$rememberSwipeableStateFor$2(T t11, SwipeableState<T> swipeableState, Function1<? super T, Unit> function1, MutableState<Boolean> mutableState) {
        super(1);
        this.f8402g = t11;
        this.f8403h = swipeableState;
        this.f8404i = function1;
        this.f8405j = mutableState;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        if (!Intrinsics.areEqual((Object) this.f8402g, (Object) this.f8403h.getCurrentValue())) {
            this.f8404i.invoke(this.f8403h.getCurrentValue());
            MutableState<Boolean> mutableState = this.f8405j;
            mutableState.setValue(Boolean.valueOf(!mutableState.getValue().booleanValue()));
        }
        return new SwipeableKt$rememberSwipeableStateFor$2$invoke$$inlined$onDispose$1();
    }
}
