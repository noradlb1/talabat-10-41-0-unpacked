package androidx.compose.ui.window;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidPopup_androidKt$Popup$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f10369g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f10370h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PopupProperties f10371i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f10372j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LayoutDirection f10373k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidPopup_androidKt$Popup$3(PopupLayout popupLayout, Function0<Unit> function0, PopupProperties popupProperties, String str, LayoutDirection layoutDirection) {
        super(0);
        this.f10369g = popupLayout;
        this.f10370h = function0;
        this.f10371i = popupProperties;
        this.f10372j = str;
        this.f10373k = layoutDirection;
    }

    public final void invoke() {
        this.f10369g.updateParameters(this.f10370h, this.f10371i, this.f10372j, this.f10373k);
    }
}
