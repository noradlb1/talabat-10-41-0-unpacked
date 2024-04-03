package com.deliveryhero.fluid.widgets.collections.grid.horizontal;

import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.deliveryhero.fluid.widgets.collections.Cell;
import com.deliveryhero.fluid.widgets.collections.grid.GridCell;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/horizontal/HorizontalGridCell;", "Lcom/deliveryhero/fluid/widgets/collections/grid/GridCell;", "width", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "height", "template", "Lcom/deliveryhero/fluid/template/Template;", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "(Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;Lcom/deliveryhero/fluid/template/Template;Lcom/deliveryhero/fluid/template/data/TemplateUiData;)V", "getHeight", "()Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "getWidth", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public final class HorizontalGridCell extends GridCell {
    @NotNull
    private final Cell.Size height;
    @NotNull
    private final Cell.Size width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalGridCell(@NotNull Cell.Size size, @NotNull Cell.Size size2, @NotNull Template template, @NotNull TemplateUiData templateUiData) {
        super(template, templateUiData);
        Intrinsics.checkNotNullParameter(size, "width");
        Intrinsics.checkNotNullParameter(size2, "height");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(templateUiData, "data");
        this.width = size;
        this.height = size2;
    }

    @NotNull
    public Cell.Size getHeight() {
        return this.height;
    }

    @NotNull
    public Cell.Size getWidth() {
        return this.width;
    }
}
