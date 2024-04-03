package com.deliveryhero.fluid.widgets.collections;

import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.data.TemplateUiData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/RawCell;", "", "template", "Lcom/deliveryhero/fluid/template/Template;", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "width", "", "height", "(Lcom/deliveryhero/fluid/template/Template;Lcom/deliveryhero/fluid/template/data/TemplateUiData;Ljava/lang/Float;Ljava/lang/Float;)V", "getData", "()Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "getHeight", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTemplate", "()Lcom/deliveryhero/fluid/template/Template;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Lcom/deliveryhero/fluid/template/Template;Lcom/deliveryhero/fluid/template/data/TemplateUiData;Ljava/lang/Float;Ljava/lang/Float;)Lcom/deliveryhero/fluid/widgets/collections/RawCell;", "equals", "", "other", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RawCell {
    @NotNull
    private final TemplateUiData data;
    @Nullable
    private final Float height;
    @NotNull
    private final Template template;
    @Nullable
    private final Float width;

    public RawCell(@NotNull Template template2, @NotNull TemplateUiData templateUiData, @Nullable Float f11, @Nullable Float f12) {
        Intrinsics.checkNotNullParameter(template2, "template");
        Intrinsics.checkNotNullParameter(templateUiData, "data");
        this.template = template2;
        this.data = templateUiData;
        this.width = f11;
        this.height = f12;
    }

    public static /* synthetic */ RawCell copy$default(RawCell rawCell, Template template2, TemplateUiData templateUiData, Float f11, Float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            template2 = rawCell.template;
        }
        if ((i11 & 2) != 0) {
            templateUiData = rawCell.data;
        }
        if ((i11 & 4) != 0) {
            f11 = rawCell.width;
        }
        if ((i11 & 8) != 0) {
            f12 = rawCell.height;
        }
        return rawCell.copy(template2, templateUiData, f11, f12);
    }

    @NotNull
    public final Template component1() {
        return this.template;
    }

    @NotNull
    public final TemplateUiData component2() {
        return this.data;
    }

    @Nullable
    public final Float component3() {
        return this.width;
    }

    @Nullable
    public final Float component4() {
        return this.height;
    }

    @NotNull
    public final RawCell copy(@NotNull Template template2, @NotNull TemplateUiData templateUiData, @Nullable Float f11, @Nullable Float f12) {
        Intrinsics.checkNotNullParameter(template2, "template");
        Intrinsics.checkNotNullParameter(templateUiData, "data");
        return new RawCell(template2, templateUiData, f11, f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RawCell)) {
            return false;
        }
        RawCell rawCell = (RawCell) obj;
        return Intrinsics.areEqual((Object) this.template, (Object) rawCell.template) && Intrinsics.areEqual((Object) this.data, (Object) rawCell.data) && Intrinsics.areEqual((Object) this.width, (Object) rawCell.width) && Intrinsics.areEqual((Object) this.height, (Object) rawCell.height);
    }

    @NotNull
    public final TemplateUiData getData() {
        return this.data;
    }

    @Nullable
    public final Float getHeight() {
        return this.height;
    }

    @NotNull
    public final Template getTemplate() {
        return this.template;
    }

    @Nullable
    public final Float getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode = ((this.template.hashCode() * 31) + this.data.hashCode()) * 31;
        Float f11 = this.width;
        int i11 = 0;
        int hashCode2 = (hashCode + (f11 == null ? 0 : f11.hashCode())) * 31;
        Float f12 = this.height;
        if (f12 != null) {
            i11 = f12.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        return "RawCell(template=" + this.template + ", data=" + this.data + ", width=" + this.width + ", height=" + this.height + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RawCell(Template template2, TemplateUiData templateUiData, Float f11, Float f12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(template2, templateUiData, (i11 & 4) != 0 ? null : f11, (i11 & 8) != 0 ? null : f12);
    }
}
