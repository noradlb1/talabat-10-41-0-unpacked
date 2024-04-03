package com.deliveryhero.fluid.widgets.containers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.AndroidWidgetFactory;
import com.deliveryhero.fluid.widgets.WidgetModel;
import com.deliveryhero.fluid.widgets.containers.ContainerModel;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J'\u0010\u0007\u001a\u00060\bj\u0002`\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/fluid/widgets/containers/AndroidContainerFactory;", "ModelT", "Lcom/deliveryhero/fluid/widgets/containers/ContainerModel;", "Lcom/deliveryhero/fluid/widgets/AndroidWidgetFactory;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "create", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "(Lcom/deliveryhero/fluid/widgets/containers/ContainerModel;Lcom/deliveryhero/fluid/Host;Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;)Landroid/view/View;", "createContainer", "Landroid/view/ViewGroup;", "(Lcom/deliveryhero/fluid/widgets/containers/ContainerModel;Lcom/deliveryhero/fluid/Host;Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;)Landroid/view/ViewGroup;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AndroidContainerFactory<ModelT extends ContainerModel> extends AndroidWidgetFactory<ModelT> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidContainerFactory(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public abstract ViewGroup createContainer(@NotNull ModelT modelt, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder);

    @NotNull
    public final View create(@NotNull ModelT modelt, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder) {
        Intrinsics.checkNotNullParameter(modelt, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Intrinsics.checkNotNullParameter(templateUiDataHolder, "holder");
        ViewGroup createContainer = createContainer(modelt, host, templateUiDataHolder);
        for (WidgetModel next : modelt.getChildren()) {
            createContainer.addView(host.getWidgetFactories().get(next).create(next, host, templateUiDataHolder));
        }
        return createContainer;
    }
}
