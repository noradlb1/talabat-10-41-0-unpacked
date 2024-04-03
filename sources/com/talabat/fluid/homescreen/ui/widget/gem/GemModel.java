package com.talabat.fluid.homescreen.ui.widget.gem;

import com.deliveryhero.fluid.widgets.WidgetModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/widget/gem/GemModel;", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "baseProperties", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "(Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;)V", "getBaseProperties", "()Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemModel implements WidgetModel {
    @NotNull
    private final WidgetModel.BaseProperties baseProperties;

    public GemModel(@NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        this.baseProperties = baseProperties2;
    }

    @NotNull
    public WidgetModel.BaseProperties getBaseProperties() {
        return this.baseProperties;
    }
}
