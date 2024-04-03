package com.deliveryhero.fluid.widgets;

import android.view.View;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.template.data.TemplateUiDataHolder;
import com.deliveryhero.fluid.widgets.WidgetModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J)\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/deliveryhero/fluid/widgets/WidgetFactory;", "ModelT", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "", "create", "Landroid/view/View;", "Lcom/deliveryhero/fluid/widgets/Widget;", "model", "host", "Lcom/deliveryhero/fluid/Host;", "holder", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "(Lcom/deliveryhero/fluid/widgets/WidgetModel;Lcom/deliveryhero/fluid/Host;Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;)Landroid/view/View;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WidgetFactory<ModelT extends WidgetModel> {
    @NotNull
    View create(@NotNull ModelT modelt, @NotNull Host host, @NotNull TemplateUiDataHolder templateUiDataHolder);
}
