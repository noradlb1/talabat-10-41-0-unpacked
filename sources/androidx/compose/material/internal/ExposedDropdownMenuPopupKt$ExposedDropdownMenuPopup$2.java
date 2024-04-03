package androidx.compose.material.internal;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f6193g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6194h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f6195i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LayoutDirection f6196j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2(PopupLayout popupLayout, Function0<Unit> function0, String str, LayoutDirection layoutDirection) {
        super(0);
        this.f6193g = popupLayout;
        this.f6194h = function0;
        this.f6195i = str;
        this.f6196j = layoutDirection;
    }

    public final void invoke() {
        this.f6193g.updateParameters(this.f6194h, this.f6195i, this.f6196j);
    }
}
