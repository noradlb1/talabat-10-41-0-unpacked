package androidx.compose.material3.internal;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f9005g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f9006h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f9007i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LayoutDirection f9008j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1(PopupLayout popupLayout, Function0<Unit> function0, String str, LayoutDirection layoutDirection) {
        super(1);
        this.f9005g = popupLayout;
        this.f9006h = function0;
        this.f9007i = str;
        this.f9008j = layoutDirection;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.f9005g.show();
        this.f9005g.updateParameters(this.f9006h, this.f9007i, this.f9008j);
        return new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1$invoke$$inlined$onDispose$1(this.f9005g);
    }
}
