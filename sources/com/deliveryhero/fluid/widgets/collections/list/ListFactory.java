package com.deliveryhero.fluid.widgets.collections.list;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import b5.a;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.AndroidWidgetFactory;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/list/ListFactory;", "Lcom/deliveryhero/fluid/widgets/AndroidWidgetFactory;", "Lcom/deliveryhero/fluid/widgets/collections/list/ListModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultsFactory", "Lkotlin/Function1;", "Lcom/deliveryhero/fluid/widgets/collections/list/ListWidget;", "create", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ListFactory extends AndroidWidgetFactory<ListModel> {
    @NotNull
    private final Function1<ListWidget, ListModel> defaultsFactory = new ListFactory$defaultsFactory$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListFactory(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8209create$lambda1$lambda0(ListFactory listFactory, ListWidget listWidget, ListModel listModel, Host host, ListModel listModel2, TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(listFactory, "this$0");
        Intrinsics.checkNotNullParameter(listWidget, "$this_apply");
        Intrinsics.checkNotNullParameter(listModel, "$model");
        Intrinsics.checkNotNullParameter(host, "$host");
        Intrinsics.checkNotNullParameter(listModel2, "$defaults");
        listFactory.c(listWidget, listModel.getBaseProperties(), host, templateUiData);
        Context context = listWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        listWidget.setCellSpacing((int) TypedValue.applyDimension(1, listModel.getCellSpacing().get(templateUiData, listModel2.getCellSpacing()).getValue(), context.getResources().getDisplayMetrics()));
        listWidget.setCells(listModel.getCells().get(templateUiData, listModel2.getCells()));
    }

    @NotNull
    public ListWidget create(@NotNull ListModel listModel, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        Intrinsics.checkNotNullParameter(listModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        ListWidget listWidget = new ListWidget(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        listWidget.init(host);
        templateUiDataHolder.observe(new a(this, listWidget, listModel, host, (ListModel) b(listWidget, this.defaultsFactory)));
        return listWidget;
    }
}
