package androidx.compose.material.internal;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f6197g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PopupPositionProvider f6198h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3(PopupLayout popupLayout, PopupPositionProvider popupPositionProvider) {
        super(1);
        this.f6197g = popupLayout;
        this.f6198h = popupPositionProvider;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.f6197g.setPositionProvider(this.f6198h);
        this.f6197g.updatePosition();
        return new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3$invoke$$inlined$onDispose$1();
    }
}
