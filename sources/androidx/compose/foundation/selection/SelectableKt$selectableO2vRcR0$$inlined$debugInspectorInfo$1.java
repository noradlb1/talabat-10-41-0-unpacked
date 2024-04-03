package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.foundation.selection.SelectableKt$selectable-O2vRcR0$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class SelectableKt$selectableO2vRcR0$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f3212g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f3213h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Indication f3214i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f3215j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Role f3216k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0 f3217l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectableKt$selectableO2vRcR0$$inlined$debugInspectorInfo$1(boolean z11, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z12, Role role, Function0 function0) {
        super(1);
        this.f3212g = z11;
        this.f3213h = mutableInteractionSource;
        this.f3214i = indication;
        this.f3215j = z12;
        this.f3216k = role;
        this.f3217l = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("selectable");
        inspectorInfo.getProperties().set("selected", Boolean.valueOf(this.f3212g));
        inspectorInfo.getProperties().set("interactionSource", this.f3213h);
        inspectorInfo.getProperties().set("indication", this.f3214i);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f3215j));
        inspectorInfo.getProperties().set("role", this.f3216k);
        inspectorInfo.getProperties().set("onClick", this.f3217l);
    }
}
