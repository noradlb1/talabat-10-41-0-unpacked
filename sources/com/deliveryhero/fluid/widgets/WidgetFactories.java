package com.deliveryhero.fluid.widgets;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0004H¦\u0002¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/deliveryhero/fluid/widgets/WidgetFactories;", "", "get", "Lcom/deliveryhero/fluid/widgets/WidgetFactory;", "ModelT", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "model", "(Lcom/deliveryhero/fluid/widgets/WidgetModel;)Lcom/deliveryhero/fluid/widgets/WidgetFactory;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WidgetFactories {
    @NotNull
    <ModelT extends WidgetModel> WidgetFactory<ModelT> get(@NotNull ModelT modelt);
}
