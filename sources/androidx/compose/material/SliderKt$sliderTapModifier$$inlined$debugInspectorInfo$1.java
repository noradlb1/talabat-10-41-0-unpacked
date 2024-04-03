package androidx.compose.material;

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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DraggableState f5077g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5078h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f5079i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5080j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State f5081k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ State f5082l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableState f5083m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f5084n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1(DraggableState draggableState, MutableInteractionSource mutableInteractionSource, float f11, boolean z11, State state, State state2, MutableState mutableState, boolean z12) {
        super(1);
        this.f5077g = draggableState;
        this.f5078h = mutableInteractionSource;
        this.f5079i = f11;
        this.f5080j = z11;
        this.f5081k = state;
        this.f5082l = state2;
        this.f5083m = mutableState;
        this.f5084n = z12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("sliderTapModifier");
        inspectorInfo.getProperties().set("draggableState", this.f5077g);
        inspectorInfo.getProperties().set("interactionSource", this.f5078h);
        inspectorInfo.getProperties().set("maxPx", Float.valueOf(this.f5079i));
        inspectorInfo.getProperties().set("isRtl", Boolean.valueOf(this.f5080j));
        inspectorInfo.getProperties().set("rawOffset", this.f5081k);
        inspectorInfo.getProperties().set("gestureEndAction", this.f5082l);
        inspectorInfo.getProperties().set("pressOffset", this.f5083m);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f5084n));
    }
}
