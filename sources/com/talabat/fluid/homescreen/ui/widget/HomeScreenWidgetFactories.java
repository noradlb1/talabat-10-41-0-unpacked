package com.talabat.fluid.homescreen.ui.widget;

import android.content.Context;
import com.deliveryhero.fluid.widgets.CoreWidgetFactories;
import com.deliveryhero.fluid.widgets.WidgetFactory;
import com.deliveryhero.fluid.widgets.WidgetModel;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.gson.Gson;
import com.talabat.fluid.homescreen.ui.widget.gem.GemModel;
import com.talabat.fluid.homescreen.ui.widget.gem.GemWidgetFactory;
import com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusDataMapper;
import com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusModel;
import com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusWidgetFactory;
import com.talabat.fluid.homescreen.ui.widget.ramadanclock.RamadanClockModel;
import com.talabat.fluid.homescreen.ui.widget.ramadanclock.RamadanClockWidgetFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\b\b\u0000\u0010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u0002H\u000fH\u0002¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/widget/HomeScreenWidgetFactories;", "Lcom/deliveryhero/fluid/widgets/CoreWidgetFactories;", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/Context;Lcom/google/gson/Gson;)V", "gemWidgetFactory", "Lcom/talabat/fluid/homescreen/ui/widget/gem/GemWidgetFactory;", "orderStatusWidgetFactory", "Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusWidgetFactory;", "ramadanClockWidgetFactory", "Lcom/talabat/fluid/homescreen/ui/widget/ramadanclock/RamadanClockWidgetFactory;", "get", "Lcom/deliveryhero/fluid/widgets/WidgetFactory;", "ModelT", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "model", "(Lcom/deliveryhero/fluid/widgets/WidgetModel;)Lcom/deliveryhero/fluid/widgets/WidgetFactory;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenWidgetFactories extends CoreWidgetFactories {
    @NotNull
    private final GemWidgetFactory gemWidgetFactory;
    @NotNull
    private final OrderStatusWidgetFactory orderStatusWidgetFactory;
    @NotNull
    private final RamadanClockWidgetFactory ramadanClockWidgetFactory;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenWidgetFactories(@NotNull Context context, @NotNull Gson gson) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.ramadanClockWidgetFactory = new RamadanClockWidgetFactory(context);
        this.orderStatusWidgetFactory = new OrderStatusWidgetFactory(context, new OrderStatusDataMapper(gson));
        this.gemWidgetFactory = new GemWidgetFactory(context);
    }

    @NotNull
    public <ModelT extends WidgetModel> WidgetFactory<ModelT> get(@NotNull ModelT modelt) {
        Intrinsics.checkNotNullParameter(modelt, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        if (modelt instanceof RamadanClockModel) {
            return this.ramadanClockWidgetFactory;
        }
        if (modelt instanceof OrderStatusModel) {
            return this.orderStatusWidgetFactory;
        }
        if (modelt instanceof GemModel) {
            return this.gemWidgetFactory;
        }
        return super.get(modelt);
    }
}
