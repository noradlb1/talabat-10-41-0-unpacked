package com.deliveryhero.fluid.widgets.collections.grid;

import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.widgets.collections.Cell;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/GridCell;", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "template", "Lcom/deliveryhero/fluid/template/Template;", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "(Lcom/deliveryhero/fluid/template/Template;Lcom/deliveryhero/fluid/template/data/TemplateUiData;)V", "getData", "()Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "height", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "getHeight", "()Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "getTemplate", "()Lcom/deliveryhero/fluid/template/Template;", "width", "getWidth", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class GridCell implements Cell {
    @NotNull
    private final TemplateUiData data;
    @NotNull
    private final Template template;

    public GridCell(@NotNull Template template2, @NotNull TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(template2, "template");
        Intrinsics.checkNotNullParameter(templateUiData, "data");
        this.template = template2;
        this.data = templateUiData;
    }

    @NotNull
    public TemplateUiData getData() {
        return this.data;
    }

    @NotNull
    public abstract Cell.Size getHeight();

    @NotNull
    public Template getTemplate() {
        return this.template;
    }

    @NotNull
    public abstract Cell.Size getWidth();
}
