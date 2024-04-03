package androidx.compose.ui.window;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidPopup_androidKt$Popup$4 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f10374g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PopupPositionProvider f10375h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidPopup_androidKt$Popup$4(PopupLayout popupLayout, PopupPositionProvider popupPositionProvider) {
        super(1);
        this.f10374g = popupLayout;
        this.f10375h = popupPositionProvider;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.f10374g.setPositionProvider(this.f10375h);
        this.f10374g.updatePosition();
        return new AndroidPopup_androidKt$Popup$4$invoke$$inlined$onDispose$1();
    }
}
