package com.deliveryhero.fluid.widgets.image;

import android.content.Context;
import android.util.TypedValue;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.AndroidWidgetFactory;
import com.deliveryhero.fluid.widgets.image.utils.ImageUtilsKt;
import com.deliveryhero.fluid.widgets.image.utils.ShapeUtilsKt;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import h5.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/image/ImageFactory;", "Lcom/deliveryhero/fluid/widgets/AndroidWidgetFactory;", "Lcom/deliveryhero/fluid/widgets/image/ImageModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultsFactory", "Lkotlin/Function1;", "Lcom/deliveryhero/fluid/widgets/image/ImageWidget;", "create", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ImageFactory extends AndroidWidgetFactory<ImageModel> {
    @NotNull
    private final Function1<ImageWidget, ImageModel> defaultsFactory = new ImageFactory$defaultsFactory$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageFactory(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8222create$lambda1$lambda0(ImageFactory imageFactory, ImageWidget imageWidget, ImageModel imageModel, Host host, ImageModel imageModel2, TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(imageFactory, "this$0");
        Intrinsics.checkNotNullParameter(imageWidget, "$this_apply");
        Intrinsics.checkNotNullParameter(imageModel, "$model");
        Intrinsics.checkNotNullParameter(host, "$host");
        Intrinsics.checkNotNullParameter(imageModel2, "$defaults");
        imageFactory.c(imageWidget, imageModel.getBaseProperties(), host, templateUiData);
        Context context = imageWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        float applyDimension = TypedValue.applyDimension(1, imageModel.getCornerRadiusTopLeft().get(templateUiData, imageModel2.getCornerRadiusTopLeft()).getValue(), context.getResources().getDisplayMetrics());
        Context context2 = imageWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        float applyDimension2 = TypedValue.applyDimension(1, imageModel.getCornerRadiusTopRight().get(templateUiData, imageModel2.getCornerRadiusTopRight()).getValue(), context2.getResources().getDisplayMetrics());
        Context context3 = imageWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        float applyDimension3 = TypedValue.applyDimension(1, imageModel.getCornerRadiusBottomRight().get(templateUiData, imageModel2.getCornerRadiusBottomRight()).getValue(), context3.getResources().getDisplayMetrics());
        Context context4 = imageWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        ShapeUtilsKt.updateCornerRadii(imageWidget, applyDimension, applyDimension2, applyDimension3, TypedValue.applyDimension(1, imageModel.getCornerRadiusBottomLeft().get(templateUiData, imageModel2.getCornerRadiusBottomLeft()).getValue(), context4.getResources().getDisplayMetrics()));
        imageWidget.setContentMode(imageModel.getContentMode().get(templateUiData, imageModel2.getContentMode()));
        ImageUtilsKt.updateImage(imageWidget, host, imageModel.getImage().get(templateUiData, imageModel2.getImage()), imageModel.getLoadingPlaceholder().get(templateUiData, imageModel2.getLoadingPlaceholder()), imageModel.getErrorPlaceholder().get(templateUiData, imageModel2.getErrorPlaceholder()));
    }

    @NotNull
    public ImageWidget create(@NotNull ImageModel imageModel, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        Intrinsics.checkNotNullParameter(imageModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        ImageWidget imageWidget = new ImageWidget(getContext());
        templateUiDataHolder.observe(new a(this, imageWidget, imageModel, host, (ImageModel) b(imageWidget, this.defaultsFactory)));
        return imageWidget;
    }
}
