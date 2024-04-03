package com.deliveryhero.fluid.widgets.containers.column;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.containers.AndroidContainerFactory;
import com.deliveryhero.fluid.widgets.containers.EnhancedLinearLayout;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import e5.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/fluid/widgets/containers/column/ColumnFactory;", "Lcom/deliveryhero/fluid/widgets/containers/AndroidContainerFactory;", "Lcom/deliveryhero/fluid/widgets/containers/column/ColumnModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultsFactory", "Lkotlin/Function1;", "Landroid/widget/LinearLayout;", "createContainer", "Lcom/deliveryhero/fluid/widgets/containers/EnhancedLinearLayout;", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ColumnFactory extends AndroidContainerFactory<ColumnModel> {
    @NotNull
    private final Function1<LinearLayout, ColumnModel> defaultsFactory = new ColumnFactory$defaultsFactory$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ColumnFactory(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: createContainer$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8219createContainer$lambda1$lambda0(ColumnFactory columnFactory, EnhancedLinearLayout enhancedLinearLayout, ColumnModel columnModel, Host host, TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(columnFactory, "this$0");
        Intrinsics.checkNotNullParameter(enhancedLinearLayout, "$this_apply");
        Intrinsics.checkNotNullParameter(columnModel, "$model");
        Intrinsics.checkNotNullParameter(host, "$host");
        columnFactory.c(enhancedLinearLayout, columnModel.getBaseProperties(), host, templateUiData);
    }

    @NotNull
    public EnhancedLinearLayout createContainer(@NotNull ColumnModel columnModel, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        Intrinsics.checkNotNullParameter(columnModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        EnhancedLinearLayout enhancedLinearLayout = new EnhancedLinearLayout(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        enhancedLinearLayout.setOrientation(1);
        b(enhancedLinearLayout, this.defaultsFactory);
        templateUiDataHolder.observe(new a(this, enhancedLinearLayout, columnModel, host));
        return enhancedLinearLayout;
    }
}
