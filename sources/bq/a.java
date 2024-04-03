package bq;

import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusModel;
import com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusWidgetFactory;
import com.talabat.homescreen.orderstatus.ui.OrderStatusView;

public final /* synthetic */ class a implements TemplateUiDataHolder.Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OrderStatusWidgetFactory f58172a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderStatusView f58173b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderStatusModel f58174c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Host f58175d;

    public /* synthetic */ a(OrderStatusWidgetFactory orderStatusWidgetFactory, OrderStatusView orderStatusView, OrderStatusModel orderStatusModel, Host host) {
        this.f58172a = orderStatusWidgetFactory;
        this.f58173b = orderStatusView;
        this.f58174c = orderStatusModel;
        this.f58175d = host;
    }

    public final void onChanged(TemplateUiData templateUiData) {
        OrderStatusWidgetFactory.m10464create$lambda2$lambda1(this.f58172a, this.f58173b, this.f58174c, this.f58175d, templateUiData);
    }
}
