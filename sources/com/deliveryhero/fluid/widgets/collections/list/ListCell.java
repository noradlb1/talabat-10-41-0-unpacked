package com.deliveryhero.fluid.widgets.collections.list;

import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.versioning.CoreContract;
import com.deliveryhero.fluid.widgets.collections.Cell;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/list/ListCell;", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "template", "Lcom/deliveryhero/fluid/template/Template;", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "(Lcom/deliveryhero/fluid/template/Template;Lcom/deliveryhero/fluid/template/data/TemplateUiData;)V", "getData", "()Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "getTemplate", "()Lcom/deliveryhero/fluid/template/Template;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@CoreContract.CreatedOn(version = CoreContract.Version.V1)
public final class ListCell implements Cell {
    @NotNull
    private final TemplateUiData data;
    @NotNull
    private final Template template;

    public ListCell(@NotNull Template template2, @NotNull TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(template2, "template");
        Intrinsics.checkNotNullParameter(templateUiData, "data");
        this.template = template2;
        this.data = templateUiData;
    }

    public static /* synthetic */ ListCell copy$default(ListCell listCell, Template template2, TemplateUiData templateUiData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            template2 = listCell.getTemplate();
        }
        if ((i11 & 2) != 0) {
            templateUiData = listCell.getData();
        }
        return listCell.copy(template2, templateUiData);
    }

    @NotNull
    public final Template component1() {
        return getTemplate();
    }

    @NotNull
    public final TemplateUiData component2() {
        return getData();
    }

    @NotNull
    public final ListCell copy(@NotNull Template template2, @NotNull TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(template2, "template");
        Intrinsics.checkNotNullParameter(templateUiData, "data");
        return new ListCell(template2, templateUiData);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListCell)) {
            return false;
        }
        ListCell listCell = (ListCell) obj;
        return Intrinsics.areEqual((Object) getTemplate(), (Object) listCell.getTemplate()) && Intrinsics.areEqual((Object) getData(), (Object) listCell.getData());
    }

    @NotNull
    public TemplateUiData getData() {
        return this.data;
    }

    @NotNull
    public Template getTemplate() {
        return this.template;
    }

    public int hashCode() {
        return (getTemplate().hashCode() * 31) + getData().hashCode();
    }

    @NotNull
    public String toString() {
        return "ListCell(template=" + getTemplate() + ", data=" + getData() + ')';
    }
}
