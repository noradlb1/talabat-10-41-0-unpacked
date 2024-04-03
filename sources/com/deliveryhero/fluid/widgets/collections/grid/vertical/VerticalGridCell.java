package com.deliveryhero.fluid.widgets.collections.grid.vertical;

import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.deliveryhero.fluid.widgets.collections.Cell;
import com.deliveryhero.fluid.widgets.collections.grid.GridCell;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nR\u001f\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/vertical/VerticalGridCell;", "Lcom/deliveryhero/fluid/widgets/collections/grid/GridCell;", "width", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size$Relative;", "height", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size$Absolute;", "template", "Lcom/deliveryhero/fluid/template/Template;", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "(FLcom/deliveryhero/fluid/values/LogicalPixel;Lcom/deliveryhero/fluid/template/Template;Lcom/deliveryhero/fluid/template/data/TemplateUiData;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHeight-G78lpEE", "()Lcom/deliveryhero/fluid/values/LogicalPixel;", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "getWidth-JfM3bYk", "()F", "F", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public final class VerticalGridCell extends GridCell {
    @NotNull
    private final LogicalPixel height;
    private final float width;

    private VerticalGridCell(float f11, LogicalPixel logicalPixel, Template template, TemplateUiData templateUiData) {
        super(template, templateUiData);
        this.width = f11;
        this.height = logicalPixel;
    }

    public /* synthetic */ VerticalGridCell(float f11, LogicalPixel logicalPixel, Template template, TemplateUiData templateUiData, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, logicalPixel, template, templateUiData);
    }

    public /* bridge */ /* synthetic */ Cell.Size getHeight() {
        return Cell.Size.Absolute.m8189boximpl(m8206getHeightG78lpEE());
    }

    @NotNull
    /* renamed from: getHeight-G78lpEE  reason: not valid java name */
    public LogicalPixel m8206getHeightG78lpEE() {
        return this.height;
    }

    public /* bridge */ /* synthetic */ Cell.Size getWidth() {
        return Cell.Size.Relative.m8196boximpl(m8207getWidthJfM3bYk());
    }

    /* renamed from: getWidth-JfM3bYk  reason: not valid java name */
    public float m8207getWidthJfM3bYk() {
        return this.width;
    }
}
