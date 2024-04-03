package androidx.compose.material3;

import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DraggableState f7941g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7942h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7943i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f7944j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State f7945k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ State f7946l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableState f7947m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f7948n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1(DraggableState draggableState, MutableInteractionSource mutableInteractionSource, int i11, boolean z11, State state, State state2, MutableState mutableState, boolean z12) {
        super(1);
        this.f7941g = draggableState;
        this.f7942h = mutableInteractionSource;
        this.f7943i = i11;
        this.f7944j = z11;
        this.f7945k = state;
        this.f7946l = state2;
        this.f7947m = mutableState;
        this.f7948n = z12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("sliderTapModifier");
        inspectorInfo.getProperties().set("draggableState", this.f7941g);
        inspectorInfo.getProperties().set("interactionSource", this.f7942h);
        inspectorInfo.getProperties().set("maxPx", Integer.valueOf(this.f7943i));
        inspectorInfo.getProperties().set("isRtl", Boolean.valueOf(this.f7944j));
        inspectorInfo.getProperties().set("rawOffset", this.f7945k);
        inspectorInfo.getProperties().set("gestureEndAction", this.f7946l);
        inspectorInfo.getProperties().set("pressOffset", this.f7947m);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f7948n));
    }
}
