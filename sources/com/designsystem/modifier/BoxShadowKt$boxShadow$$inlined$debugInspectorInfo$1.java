package com.designsystem.modifier;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.ui.platform.InspectorInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\n¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/platform/InspectorInfo;", "", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BoxShadowKt$boxShadow$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List f33550g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RoundedCornerShape f33551h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoxShadowKt$boxShadow$$inlined$debugInspectorInfo$1(List list, RoundedCornerShape roundedCornerShape) {
        super(1);
        this.f33550g = list;
        this.f33551h = roundedCornerShape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("boxShadow");
        inspectorInfo.setValue(this.f33550g);
        inspectorInfo.getProperties().set("shadows", this.f33550g);
        inspectorInfo.getProperties().set("shape", this.f33551h);
    }
}
