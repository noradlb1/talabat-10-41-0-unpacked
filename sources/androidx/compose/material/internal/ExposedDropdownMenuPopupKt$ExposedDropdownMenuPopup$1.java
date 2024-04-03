package androidx.compose.material.internal;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f6189g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6190h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f6191i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LayoutDirection f6192j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1(PopupLayout popupLayout, Function0<Unit> function0, String str, LayoutDirection layoutDirection) {
        super(1);
        this.f6189g = popupLayout;
        this.f6190h = function0;
        this.f6191i = str;
        this.f6192j = layoutDirection;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.f6189g.show();
        this.f6189g.updateParameters(this.f6190h, this.f6191i, this.f6192j);
        return new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1$invoke$$inlined$onDispose$1(this.f6189g);
    }
}
