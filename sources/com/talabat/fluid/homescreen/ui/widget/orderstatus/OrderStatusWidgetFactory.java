package com.talabat.fluid.homescreen.ui.widget.orderstatus;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import bq.a;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.AndroidWidgetFactory;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import com.talabat.homescreen.orderstatus.ui.OrderStatusView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012$\u0010\u0005\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006¢\u0006\u0002\u0010\u000bJ$\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u00020\u0017*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002R,\u0010\u0005\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusWidgetFactory;", "Lcom/deliveryhero/fluid/widgets/AndroidWidgetFactory;", "Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusModel;", "context", "Landroid/content/Context;", "dataMapper", "Lkotlin/Function1;", "", "", "", "Lcom/talabat/homescreen/orderstatus/ui/OrderStatusView$OrderStatusData;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "defaultFactory", "Lcom/talabat/homescreen/orderstatus/ui/OrderStatusView;", "create", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "updateItemPadding", "", "templateUiData", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "defaults", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusWidgetFactory extends AndroidWidgetFactory<OrderStatusModel> {
    @NotNull
    private final Function1<Map<String, String>, List<OrderStatusView.OrderStatusData>> dataMapper;
    @NotNull
    private final Function1<OrderStatusView, OrderStatusModel> defaultFactory = new OrderStatusWidgetFactory$defaultFactory$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderStatusWidgetFactory(@NotNull Context context, @NotNull Function1<? super Map<String, String>, ? extends List<OrderStatusView.OrderStatusData>> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "dataMapper");
        this.dataMapper = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-2$lambda-1  reason: not valid java name */
    public static final void m10464create$lambda2$lambda1(OrderStatusWidgetFactory orderStatusWidgetFactory, OrderStatusView orderStatusView, OrderStatusModel orderStatusModel, Host host, TemplateUiData templateUiData) {
        Map map;
        Map<String, Object> metadata;
        Intrinsics.checkNotNullParameter(orderStatusWidgetFactory, "this$0");
        Intrinsics.checkNotNullParameter(orderStatusView, "$this_apply");
        Intrinsics.checkNotNullParameter(orderStatusModel, "$model");
        Intrinsics.checkNotNullParameter(host, "$host");
        OrderStatusModel orderStatusModel2 = (OrderStatusModel) orderStatusWidgetFactory.b(orderStatusView, orderStatusWidgetFactory.defaultFactory);
        orderStatusWidgetFactory.c(orderStatusView, orderStatusModel.getBaseProperties(), host, templateUiData);
        orderStatusWidgetFactory.updateItemPadding(orderStatusView, orderStatusModel, templateUiData, orderStatusModel2);
        Context context = orderStatusView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        orderStatusView.setItemSpacing((int) TypedValue.applyDimension(1, orderStatusModel.getItemSpacing().get(templateUiData, orderStatusModel2.getItemSpacing()).getValue(), context.getResources().getDisplayMetrics()));
        Function1<Map<String, String>, List<OrderStatusView.OrderStatusData>> function1 = orderStatusWidgetFactory.dataMapper;
        if (templateUiData == null || (metadata = templateUiData.getMetadata()) == null) {
            map = null;
        } else {
            map = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(metadata.size()));
            for (Map.Entry entry : metadata.entrySet()) {
                map.put(entry.getKey(), entry.getValue().toString());
            }
        }
        if (map == null) {
            map = MapsKt__MapsKt.emptyMap();
        }
        orderStatusView.bind(function1.invoke(map));
    }

    private final void updateItemPadding(OrderStatusView orderStatusView, OrderStatusModel orderStatusModel, TemplateUiData templateUiData, OrderStatusModel orderStatusModel2) {
        Context context = orderStatusView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Context context2 = orderStatusView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Context context3 = orderStatusView.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        Context context4 = orderStatusView.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        orderStatusView.setItemPadding((int) TypedValue.applyDimension(1, orderStatusModel.getItemPaddingLeading().get(templateUiData, orderStatusModel2.getItemPaddingLeading()).getValue(), context.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, orderStatusModel.getItemPaddingTop().get(templateUiData, orderStatusModel2.getItemPaddingTop()).getValue(), context2.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, orderStatusModel.getItemPaddingTrailing().get(templateUiData, orderStatusModel2.getItemPaddingTrailing()).getValue(), context3.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, orderStatusModel.getItemPaddingBottom().get(templateUiData, orderStatusModel2.getItemPaddingBottom()).getValue(), context4.getResources().getDisplayMetrics()));
    }

    @NotNull
    public View create(@NotNull OrderStatusModel orderStatusModel, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        Intrinsics.checkNotNullParameter(orderStatusModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        OrderStatusView orderStatusView = new OrderStatusView(getContext());
        templateUiDataHolder.observe(new a(this, orderStatusView, orderStatusModel, host));
        return orderStatusView;
    }
}
