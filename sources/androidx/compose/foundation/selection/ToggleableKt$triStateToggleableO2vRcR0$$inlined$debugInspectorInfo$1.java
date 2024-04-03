package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.foundation.selection.ToggleableKt$triStateToggleable-O2vRcR0$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class ToggleableKt$triStateToggleableO2vRcR0$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ToggleableState f3237g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3238h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Role f3239i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f3240j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Indication f3241k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0 f3242l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToggleableKt$triStateToggleableO2vRcR0$$inlined$debugInspectorInfo$1(ToggleableState toggleableState, boolean z11, Role role, MutableInteractionSource mutableInteractionSource, Indication indication, Function0 function0) {
        super(1);
        this.f3237g = toggleableState;
        this.f3238h = z11;
        this.f3239i = role;
        this.f3240j = mutableInteractionSource;
        this.f3241k = indication;
        this.f3242l = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("triStateToggleable");
        inspectorInfo.getProperties().set("state", this.f3237g);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f3238h));
        inspectorInfo.getProperties().set("role", this.f3239i);
        inspectorInfo.getProperties().set("interactionSource", this.f3240j);
        inspectorInfo.getProperties().set("indication", this.f3241k);
        inspectorInfo.getProperties().set("onClick", this.f3242l);
    }
}
