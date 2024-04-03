package com.deliveryhero.fluid.widgets.containers.stack;

import android.content.Context;
import android.widget.FrameLayout;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.containers.AndroidContainerFactory;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import g5.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/containers/stack/StackFactory;", "Lcom/deliveryhero/fluid/widgets/containers/AndroidContainerFactory;", "Lcom/deliveryhero/fluid/widgets/containers/stack/StackModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "defaultsFactory", "Lkotlin/Function1;", "Landroid/widget/FrameLayout;", "createContainer", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class StackFactory extends AndroidContainerFactory<StackModel> {
    @NotNull
    private final Function1<FrameLayout, StackModel> defaultsFactory = new StackFactory$defaultsFactory$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StackFactory(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: createContainer$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8221createContainer$lambda1$lambda0(StackFactory stackFactory, FrameLayout frameLayout, StackModel stackModel, Host host, TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(stackFactory, "this$0");
        Intrinsics.checkNotNullParameter(frameLayout, "$this_apply");
        Intrinsics.checkNotNullParameter(stackModel, "$model");
        Intrinsics.checkNotNullParameter(host, "$host");
        stackFactory.c(frameLayout, stackModel.getBaseProperties(), host, templateUiData);
    }

    @NotNull
    public FrameLayout createContainer(@NotNull StackModel stackModel, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        Intrinsics.checkNotNullParameter(stackModel, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        FrameLayout frameLayout = new FrameLayout(getContext());
        b(frameLayout, this.defaultsFactory);
        templateUiDataHolder.observe(new a(this, frameLayout, stackModel, host));
        return frameLayout;
    }
}
