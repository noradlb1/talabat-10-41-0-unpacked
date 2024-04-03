package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.compose.material.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5868g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f5869h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f5870i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TextFieldColors f5871j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f5872k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f5873l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1(boolean z11, boolean z12, InteractionSource interactionSource, TextFieldColors textFieldColors, float f11, float f12) {
        super(1);
        this.f5868g = z11;
        this.f5869h = z12;
        this.f5870i = interactionSource;
        this.f5871j = textFieldColors;
        this.f5872k = f11;
        this.f5873l = f12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("indicatorLine");
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f5868g));
        inspectorInfo.getProperties().set("isError", Boolean.valueOf(this.f5869h));
        inspectorInfo.getProperties().set("interactionSource", this.f5870i);
        inspectorInfo.getProperties().set("colors", this.f5871j);
        inspectorInfo.getProperties().set("focusedIndicatorLineThickness", Dp.m5476boximpl(this.f5872k));
        inspectorInfo.getProperties().set("unfocusedIndicatorLineThickness", Dp.m5476boximpl(this.f5873l));
    }
}
