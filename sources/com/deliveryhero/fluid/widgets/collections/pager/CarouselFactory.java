package com.deliveryhero.fluid.widgets.collections.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import c5.a;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.AndroidWidgetFactory;
import com.deliveryhero.fluid.widgets.collections.pager.indicators.PagerDotsIndicatorWidget;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/pager/CarouselFactory;", "Lcom/deliveryhero/fluid/widgets/AndroidWidgetFactory;", "Lcom/deliveryhero/fluid/widgets/collections/pager/CarouselModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultsFactory", "Lkotlin/Function1;", "Lcom/deliveryhero/fluid/widgets/collections/pager/CarouselWidget;", "create", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CarouselFactory extends AndroidWidgetFactory<CarouselModel> {
    @NotNull
    private final Function1<CarouselWidget, CarouselModel> defaultsFactory = new CarouselFactory$defaultsFactory$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselFactory(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-2$lambda-1  reason: not valid java name */
    public static final void m8210create$lambda2$lambda1(CarouselFactory carouselFactory, CarouselWidget carouselWidget, CarouselModel carouselModel, Host host, CarouselModel carouselModel2, TemplateUiData templateUiData) {
        boolean z11;
        Intrinsics.checkNotNullParameter(carouselFactory, "this$0");
        Intrinsics.checkNotNullParameter(carouselWidget, "$this_apply");
        Intrinsics.checkNotNullParameter(carouselModel, "$model");
        Intrinsics.checkNotNullParameter(host, "$host");
        Intrinsics.checkNotNullParameter(carouselModel2, "$defaults");
        carouselFactory.c(carouselWidget, carouselModel.getBaseProperties(), host, templateUiData);
        Context context = carouselWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        carouselWidget.setCellSpacing((int) TypedValue.applyDimension(1, carouselModel.getCellSpacing().get(templateUiData, carouselModel2.getCellSpacing()).getValue(), context.getResources().getDisplayMetrics()));
        List list = carouselModel.getCells().get(templateUiData, carouselModel2.getCells());
        carouselWidget.setCells(list);
        PagerDotsIndicatorWidget indicator = carouselWidget.getIndicator();
        int i11 = 0;
        if (list.size() > 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            i11 = 8;
        }
        indicator.setVisibility(i11);
        PagerDotsIndicatorWidget indicator2 = carouselWidget.getIndicator();
        ViewGroup.LayoutParams layoutParams = indicator2.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = (int) TypedValue.applyDimension(1, carouselModel.getIndicator().getPagerSpacing().get(templateUiData, carouselModel2.getIndicator().getPagerSpacing()).getValue(), host.getContext().getResources().getDisplayMetrics());
            indicator2.setLayoutParams(marginLayoutParams);
            carouselWidget.getIndicator().setSpacing(carouselModel.getIndicator().getSpacing().get(templateUiData, carouselModel2.getIndicator().getSpacing()));
            carouselWidget.getIndicator().setSize(carouselModel.getIndicator().getSize().get(templateUiData, carouselModel2.getIndicator().getSize()));
            carouselWidget.getIndicator().setActiveColor(carouselModel.getIndicator().getActiveColor().get(templateUiData, carouselModel2.getIndicator().getActiveColor()));
            carouselWidget.getIndicator().setInActiveColor(carouselModel.getIndicator().getInActiveColor().get(templateUiData, carouselModel2.getIndicator().getInActiveColor()));
            carouselWidget.getIndicator().refresh();
            carouselWidget.setScrollHandler(new CarouselFactory$create$1$1$2(templateUiData, host, carouselWidget));
            carouselWidget.setCarouselPadding(carouselModel.getCellWidthRatio().get(templateUiData, carouselModel2.getCellWidthRatio()));
            carouselWidget.setAutoScroll(carouselModel.getAutoScrollEnabled().get(templateUiData, carouselModel2.getAutoScrollEnabled()).booleanValue(), carouselModel.getAutoScrollDelayInMillis().get(templateUiData, carouselModel2.getAutoScrollDelayInMillis()).intValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @NotNull
    public CarouselWidget create(@NotNull CarouselModel carouselModel, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        Intrinsics.checkNotNullParameter(carouselModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        CarouselWidget carouselWidget = new CarouselWidget(getContext(), host, (AttributeSet) null, 0, 12, (DefaultConstructorMarker) null);
        templateUiDataHolder.observe(new a(this, carouselWidget, carouselModel, host, (CarouselModel) b(carouselWidget, this.defaultsFactory)));
        return carouselWidget;
    }
}
