package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.foundation.layout.PaddingKt$absolutePadding-qDBjuR0$$inlined$debugInspectorInfo$1  reason: invalid class name */
public final class PaddingKt$absolutePaddingqDBjuR0$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f2505g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f2506h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f2507i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f2508j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaddingKt$absolutePaddingqDBjuR0$$inlined$debugInspectorInfo$1(float f11, float f12, float f13, float f14) {
        super(1);
        this.f2505g = f11;
        this.f2506h = f12;
        this.f2507i = f13;
        this.f2508j = f14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("absolutePadding");
        inspectorInfo.getProperties().set("left", Dp.m5476boximpl(this.f2505g));
        inspectorInfo.getProperties().set(ViewHierarchyConstants.DIMENSION_TOP_KEY, Dp.m5476boximpl(this.f2506h));
        inspectorInfo.getProperties().set(TtmlNode.RIGHT, Dp.m5476boximpl(this.f2507i));
        inspectorInfo.getProperties().set("bottom", Dp.m5476boximpl(this.f2508j));
    }
}
