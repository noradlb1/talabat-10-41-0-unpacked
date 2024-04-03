package com.talabat.fluid.homescreen.ui.widget.ramadanclock;

import android.content.Context;
import android.view.View;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.AndroidWidgetFactory;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import cq.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J$\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/widget/ramadanclock/RamadanClockWidgetFactory;", "Lcom/deliveryhero/fluid/widgets/AndroidWidgetFactory;", "Lcom/talabat/fluid/homescreen/ui/widget/ramadanclock/RamadanClockModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultFactory", "Lkotlin/Function1;", "Lcom/talabat/fluid/homescreen/ui/widget/ramadanclock/RamadanClockWidgetView;", "create", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RamadanClockWidgetFactory extends AndroidWidgetFactory<RamadanClockModel> {
    @NotNull
    private final Function1<RamadanClockWidgetView, RamadanClockModel> defaultFactory = new RamadanClockWidgetFactory$defaultFactory$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RamadanClockWidgetFactory(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10465create$lambda1$lambda0(RamadanClockWidgetFactory ramadanClockWidgetFactory, RamadanClockWidgetView ramadanClockWidgetView, RamadanClockModel ramadanClockModel, Host host, TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(ramadanClockWidgetFactory, "this$0");
        Intrinsics.checkNotNullParameter(ramadanClockWidgetView, "$this_apply");
        Intrinsics.checkNotNullParameter(ramadanClockModel, "$model");
        Intrinsics.checkNotNullParameter(host, "$host");
        ramadanClockWidgetFactory.b(ramadanClockWidgetView, ramadanClockWidgetFactory.defaultFactory);
        ramadanClockWidgetFactory.c(ramadanClockWidgetView, ramadanClockModel.getBaseProperties(), host, templateUiData);
    }

    @NotNull
    public View create(@NotNull RamadanClockModel ramadanClockModel, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        Intrinsics.checkNotNullParameter(ramadanClockModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        RamadanClockWidgetView ramadanClockWidgetView = new RamadanClockWidgetView(getContext());
        templateUiDataHolder.observe(new a(this, ramadanClockWidgetView, ramadanClockModel, host));
        return ramadanClockWidgetView;
    }
}
