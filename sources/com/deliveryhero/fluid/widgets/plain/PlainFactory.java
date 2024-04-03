package com.deliveryhero.fluid.widgets.plain;

import android.content.Context;
import android.view.View;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.AndroidWidgetFactory;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import j5.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/plain/PlainFactory;", "Lcom/deliveryhero/fluid/widgets/AndroidWidgetFactory;", "Lcom/deliveryhero/fluid/widgets/plain/PlainModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultsFactory", "Lkotlin/Function1;", "Landroid/view/View;", "create", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PlainFactory extends AndroidWidgetFactory<PlainModel> {
    @NotNull
    private final Function1<View, PlainModel> defaultsFactory = new PlainFactory$defaultsFactory$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlainFactory(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8225create$lambda1$lambda0(PlainFactory plainFactory, View view, PlainModel plainModel, Host host, TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(plainFactory, "this$0");
        Intrinsics.checkNotNullParameter(view, "$this_apply");
        Intrinsics.checkNotNullParameter(plainModel, "$model");
        Intrinsics.checkNotNullParameter(host, "$host");
        plainFactory.c(view, plainModel.getBaseProperties(), host, templateUiData);
    }

    @NotNull
    public View create(@NotNull PlainModel plainModel, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        Intrinsics.checkNotNullParameter(plainModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        View view = new View(getContext());
        b(view, this.defaultsFactory);
        templateUiDataHolder.observe(new a(this, view, plainModel, host));
        return view;
    }
}
