package androidx.compose.material3.internal;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f9009g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f9010h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f9011i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LayoutDirection f9012j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2(PopupLayout popupLayout, Function0<Unit> function0, String str, LayoutDirection layoutDirection) {
        super(0);
        this.f9009g = popupLayout;
        this.f9010h = function0;
        this.f9011i = str;
        this.f9012j = layoutDirection;
    }

    public final void invoke() {
        this.f9009g.updateParameters(this.f9010h, this.f9011i, this.f9012j);
    }
}
