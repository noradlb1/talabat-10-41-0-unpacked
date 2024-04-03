package com.deliveryhero.fluid.widgets.collections.grid.vertical;

import a5.a;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.AndroidWidgetFactory;
import com.deliveryhero.fluid.widgets.collections.grid.GridWidget;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridFactory;", "Lcom/deliveryhero/fluid/widgets/AndroidWidgetFactory;", "Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultsFactory", "Lkotlin/Function1;", "Lcom/deliveryhero/fluid/widgets/collections/grid/GridWidget;", "create", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class VerticalGridFactory extends AndroidWidgetFactory<VerticalGridModel> {
    @NotNull
    private final Function1<GridWidget, VerticalGridModel> defaultsFactory = new VerticalGridFactory$defaultsFactory$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalGridFactory(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8208create$lambda1$lambda0(VerticalGridFactory verticalGridFactory, GridWidget gridWidget, VerticalGridModel verticalGridModel, Host host, VerticalGridModel verticalGridModel2, TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(verticalGridFactory, "this$0");
        Intrinsics.checkNotNullParameter(gridWidget, "$this_apply");
        Intrinsics.checkNotNullParameter(verticalGridModel, "$model");
        Intrinsics.checkNotNullParameter(host, "$host");
        Intrinsics.checkNotNullParameter(verticalGridModel2, "$defaults");
        verticalGridFactory.c(gridWidget, verticalGridModel.getBaseProperties(), host, templateUiData);
        Context context = gridWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        gridWidget.setCellSpacing((int) TypedValue.applyDimension(1, verticalGridModel.getCellSpacing().get(templateUiData, verticalGridModel2.getCellSpacing()).getValue(), context.getResources().getDisplayMetrics()));
        gridWidget.setCells(verticalGridModel.getCells().get(templateUiData, verticalGridModel2.getCells()));
    }

    @NotNull
    public GridWidget create(@NotNull VerticalGridModel verticalGridModel, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        Intrinsics.checkNotNullParameter(verticalGridModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        GridWidget gridWidget = new GridWidget(getContext(), host, false, (AttributeSet) null, 0, 24, (DefaultConstructorMarker) null);
        templateUiDataHolder.observe(new a(this, gridWidget, verticalGridModel, host, (VerticalGridModel) b(gridWidget, this.defaultsFactory)));
        return gridWidget;
    }
}
