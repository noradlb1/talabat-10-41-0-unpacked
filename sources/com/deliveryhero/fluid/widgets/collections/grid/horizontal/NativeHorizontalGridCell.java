package com.deliveryhero.fluid.widgets.collections.grid.horizontal;

import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.deliveryhero.fluid.widgets.collections.Cell;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/horizontal/NativeHorizontalGridCell;", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "template", "Lcom/deliveryhero/fluid/template/Template;", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "(Lcom/deliveryhero/fluid/template/Template;Lcom/deliveryhero/fluid/template/data/TemplateUiData;)V", "getData", "()Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "getTemplate", "()Lcom/deliveryhero/fluid/template/Template;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public final class NativeHorizontalGridCell implements Cell {
    @NotNull
    private final TemplateUiData data;
    @NotNull
    private final Template template;

    public NativeHorizontalGridCell(@NotNull Template template2, @NotNull TemplateUiData templateUiData) {
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
    public Template getTemplate() {
        return this.template;
    }
}
