package androidx.compose.runtime.saveable;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class RememberSaveableKt$rememberSaveable$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SaveableStateRegistry f9492g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f9493h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Saver<T, Object>> f9494i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<T> f9495j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RememberSaveableKt$rememberSaveable$1(SaveableStateRegistry saveableStateRegistry, String str, State<? extends Saver<T, Object>> state, State<? extends T> state2) {
        super(1);
        this.f9492g = saveableStateRegistry;
        this.f9493h = str;
        this.f9494i = state;
        this.f9495j = state2;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        RememberSaveableKt$rememberSaveable$1$valueProvider$1 rememberSaveableKt$rememberSaveable$1$valueProvider$1 = new RememberSaveableKt$rememberSaveable$1$valueProvider$1(this.f9494i, this.f9495j, this.f9492g);
        RememberSaveableKt.requireCanBeSaved(this.f9492g, rememberSaveableKt$rememberSaveable$1$valueProvider$1.invoke());
        return new RememberSaveableKt$rememberSaveable$1$invoke$$inlined$onDispose$1(this.f9492g.registerProvider(this.f9493h, rememberSaveableKt$rememberSaveable$1$valueProvider$1));
    }
}
