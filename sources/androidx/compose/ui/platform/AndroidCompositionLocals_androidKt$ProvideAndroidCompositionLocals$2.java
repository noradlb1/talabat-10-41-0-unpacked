package androidx.compose.ui.platform;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DisposableSaveableStateRegistry f10002g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2(DisposableSaveableStateRegistry disposableSaveableStateRegistry) {
        super(1);
        this.f10002g = disposableSaveableStateRegistry;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2$invoke$$inlined$onDispose$1(this.f10002g);
    }
}
