package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.compose.material.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class SwipeableKt$swipeablepPrIpRY$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SwipeableState f5600g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Map f5601h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Orientation f5602i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5603j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f5604k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5605l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2 f5606m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ResistanceConfig f5607n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f5608o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableKt$swipeablepPrIpRY$$inlined$debugInspectorInfo$1(SwipeableState swipeableState, Map map, Orientation orientation, boolean z11, boolean z12, MutableInteractionSource mutableInteractionSource, Function2 function2, ResistanceConfig resistanceConfig, float f11) {
        super(1);
        this.f5600g = swipeableState;
        this.f5601h = map;
        this.f5602i = orientation;
        this.f5603j = z11;
        this.f5604k = z12;
        this.f5605l = mutableInteractionSource;
        this.f5606m = function2;
        this.f5607n = resistanceConfig;
        this.f5608o = f11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("swipeable");
        inspectorInfo.getProperties().set("state", this.f5600g);
        inspectorInfo.getProperties().set("anchors", this.f5601h);
        inspectorInfo.getProperties().set("orientation", this.f5602i);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.f5603j));
        inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(this.f5604k));
        inspectorInfo.getProperties().set("interactionSource", this.f5605l);
        inspectorInfo.getProperties().set("thresholds", this.f5606m);
        inspectorInfo.getProperties().set("resistance", this.f5607n);
        inspectorInfo.getProperties().set("velocityThreshold", Dp.m5476boximpl(this.f5608o));
    }
}
