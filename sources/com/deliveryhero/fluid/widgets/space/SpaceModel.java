package com.deliveryhero.fluid.widgets.space;

import com.deliveryhero.fluid.widgets.WidgetModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/fluid/widgets/space/SpaceModel;", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "baseProperties", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "(Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;)V", "getBaseProperties", "()Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpaceModel implements WidgetModel {
    @NotNull
    private final WidgetModel.BaseProperties baseProperties;

    public SpaceModel(@NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        this.baseProperties = baseProperties2;
    }

    public static /* synthetic */ SpaceModel copy$default(SpaceModel spaceModel, WidgetModel.BaseProperties baseProperties2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            baseProperties2 = spaceModel.getBaseProperties();
        }
        return spaceModel.copy(baseProperties2);
    }

    @NotNull
    public final WidgetModel.BaseProperties component1() {
        return getBaseProperties();
    }

    @NotNull
    public final SpaceModel copy(@NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        return new SpaceModel(baseProperties2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SpaceModel) && Intrinsics.areEqual((Object) getBaseProperties(), (Object) ((SpaceModel) obj).getBaseProperties());
    }

    @NotNull
    public WidgetModel.BaseProperties getBaseProperties() {
        return this.baseProperties;
    }

    public int hashCode() {
        return getBaseProperties().hashCode();
    }

    @NotNull
    public String toString() {
        return "SpaceModel(baseProperties=" + getBaseProperties() + ')';
    }
}
