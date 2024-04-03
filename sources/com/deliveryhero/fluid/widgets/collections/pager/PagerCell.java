package com.deliveryhero.fluid.widgets.collections.pager;

import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.deliveryhero.fluid.widgets.collections.Cell;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0019\u0010\u0010\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\fJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J4\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/pager/PagerCell;", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "height", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size$Absolute;", "template", "Lcom/deliveryhero/fluid/template/Template;", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "(Lcom/deliveryhero/fluid/values/LogicalPixel;Lcom/deliveryhero/fluid/template/Template;Lcom/deliveryhero/fluid/template/data/TemplateUiData;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getData", "()Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "getHeight-G78lpEE", "()Lcom/deliveryhero/fluid/values/LogicalPixel;", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "getTemplate", "()Lcom/deliveryhero/fluid/template/Template;", "component1", "component1-G78lpEE", "component2", "component3", "copy", "copy-8p2hVAY", "(Lcom/deliveryhero/fluid/values/LogicalPixel;Lcom/deliveryhero/fluid/template/Template;Lcom/deliveryhero/fluid/template/data/TemplateUiData;)Lcom/deliveryhero/fluid/widgets/collections/pager/PagerCell;", "equals", "", "other", "", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public final class PagerCell implements Cell {
    @NotNull
    private final TemplateUiData data;
    @NotNull
    private final LogicalPixel height;
    @NotNull
    private final Template template;

    private PagerCell(LogicalPixel logicalPixel, Template template2, TemplateUiData templateUiData) {
        this.height = logicalPixel;
        this.template = template2;
        this.data = templateUiData;
    }

    public /* synthetic */ PagerCell(LogicalPixel logicalPixel, Template template2, TemplateUiData templateUiData, DefaultConstructorMarker defaultConstructorMarker) {
        this(logicalPixel, template2, templateUiData);
    }

    /* renamed from: copy-8p2hVAY$default  reason: not valid java name */
    public static /* synthetic */ PagerCell m8213copy8p2hVAY$default(PagerCell pagerCell, LogicalPixel logicalPixel, Template template2, TemplateUiData templateUiData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            logicalPixel = pagerCell.height;
        }
        if ((i11 & 2) != 0) {
            template2 = pagerCell.getTemplate();
        }
        if ((i11 & 4) != 0) {
            templateUiData = pagerCell.getData();
        }
        return pagerCell.m8215copy8p2hVAY(logicalPixel, template2, templateUiData);
    }

    @NotNull
    /* renamed from: component1-G78lpEE  reason: not valid java name */
    public final LogicalPixel m8214component1G78lpEE() {
        return this.height;
    }

    @NotNull
    public final Template component2() {
        return getTemplate();
    }

    @NotNull
    public final TemplateUiData component3() {
        return getData();
    }

    @NotNull
    /* renamed from: copy-8p2hVAY  reason: not valid java name */
    public final PagerCell m8215copy8p2hVAY(@NotNull LogicalPixel logicalPixel, @NotNull Template template2, @NotNull TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(logicalPixel, "height");
        Intrinsics.checkNotNullParameter(template2, "template");
        Intrinsics.checkNotNullParameter(templateUiData, "data");
        return new PagerCell(logicalPixel, template2, templateUiData, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PagerCell)) {
            return false;
        }
        PagerCell pagerCell = (PagerCell) obj;
        return Cell.Size.Absolute.m8192equalsimpl0(this.height, pagerCell.height) && Intrinsics.areEqual((Object) getTemplate(), (Object) pagerCell.getTemplate()) && Intrinsics.areEqual((Object) getData(), (Object) pagerCell.getData());
    }

    @NotNull
    public TemplateUiData getData() {
        return this.data;
    }

    @NotNull
    /* renamed from: getHeight-G78lpEE  reason: not valid java name */
    public final LogicalPixel m8216getHeightG78lpEE() {
        return this.height;
    }

    @NotNull
    public Template getTemplate() {
        return this.template;
    }

    public int hashCode() {
        return (((Cell.Size.Absolute.m8193hashCodeimpl(this.height) * 31) + getTemplate().hashCode()) * 31) + getData().hashCode();
    }

    @NotNull
    public String toString() {
        return "PagerCell(height=" + Cell.Size.Absolute.m8194toStringimpl(this.height) + ", template=" + getTemplate() + ", data=" + getData() + ')';
    }
}
