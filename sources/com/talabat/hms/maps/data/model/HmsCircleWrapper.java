package com.talabat.hms.maps.data.model;

import com.talabat.maps.domain.model.Circle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/hms/maps/data/model/HmsCircleWrapper;", "Lcom/talabat/maps/domain/model/Circle;", "circle", "Lcom/huawei/hms/maps/model/Circle;", "(Lcom/huawei/hms/maps/model/Circle;)V", "value", "", "isVisible", "()Z", "setVisible", "(Z)V", "radius", "", "getRadius", "()D", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsCircleWrapper implements Circle {
    @NotNull
    private final com.huawei.hms.maps.model.Circle circle;

    public HmsCircleWrapper(@NotNull com.huawei.hms.maps.model.Circle circle2) {
        Intrinsics.checkNotNullParameter(circle2, TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
        this.circle = circle2;
    }

    public double getRadius() {
        return this.circle.getRadius();
    }

    public boolean isVisible() {
        return this.circle.isVisible();
    }

    public void setVisible(boolean z11) {
        this.circle.setVisible(z11);
    }
}
