package androidx.compose.ui.viewinterop;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidView_androidKt$AndroidView$3 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SaveableStateRegistry f10326g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f10327h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref<ViewFactoryHolder<T>> f10328i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidView_androidKt$AndroidView$3(SaveableStateRegistry saveableStateRegistry, String str, Ref<ViewFactoryHolder<T>> ref) {
        super(1);
        this.f10326g = saveableStateRegistry;
        this.f10327h = str;
        this.f10328i = ref;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new AndroidView_androidKt$AndroidView$3$invoke$$inlined$onDispose$1(this.f10326g.registerProvider(this.f10327h, new AndroidView_androidKt$AndroidView$3$valueProvider$1(this.f10328i)));
    }
}
