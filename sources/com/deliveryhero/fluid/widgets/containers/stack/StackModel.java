package com.deliveryhero.fluid.widgets.containers.stack;

import com.deliveryhero.fluid.widgets.WidgetModel;
import com.deliveryhero.fluid.widgets.containers.ContainerModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/fluid/widgets/containers/stack/StackModel;", "Lcom/deliveryhero/fluid/widgets/containers/ContainerModel;", "children", "", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "baseProperties", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "(Ljava/util/List;Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;)V", "getBaseProperties", "()Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "getChildren", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StackModel implements ContainerModel {
    @NotNull
    private final WidgetModel.BaseProperties baseProperties;
    @NotNull
    private final List<WidgetModel> children;

    public StackModel(@NotNull List<? extends WidgetModel> list, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(list, "children");
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        this.children = list;
        this.baseProperties = baseProperties2;
    }

    public static /* synthetic */ StackModel copy$default(StackModel stackModel, List<WidgetModel> list, WidgetModel.BaseProperties baseProperties2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = stackModel.getChildren();
        }
        if ((i11 & 2) != 0) {
            baseProperties2 = stackModel.getBaseProperties();
        }
        return stackModel.copy(list, baseProperties2);
    }

    @NotNull
    public final List<WidgetModel> component1() {
        return getChildren();
    }

    @NotNull
    public final WidgetModel.BaseProperties component2() {
        return getBaseProperties();
    }

    @NotNull
    public final StackModel copy(@NotNull List<? extends WidgetModel> list, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(list, "children");
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        return new StackModel(list, baseProperties2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StackModel)) {
            return false;
        }
        StackModel stackModel = (StackModel) obj;
        return Intrinsics.areEqual((Object) getChildren(), (Object) stackModel.getChildren()) && Intrinsics.areEqual((Object) getBaseProperties(), (Object) stackModel.getBaseProperties());
    }

    @NotNull
    public WidgetModel.BaseProperties getBaseProperties() {
        return this.baseProperties;
    }

    @NotNull
    public List<WidgetModel> getChildren() {
        return this.children;
    }

    public int hashCode() {
        return (getChildren().hashCode() * 31) + getBaseProperties().hashCode();
    }

    @NotNull
    public String toString() {
        return "StackModel(children=" + getChildren() + ", baseProperties=" + getBaseProperties() + ')';
    }
}
