package com.talabat.feature.mission.control.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControl;", "", "missions", "", "Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControlData;", "(Ljava/util/List;)V", "getMissions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_mission-control_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifeStyleMissionControl {
    @NotNull
    private final List<LifeStyleMissionControlData> missions;

    public LifeStyleMissionControl(@NotNull List<LifeStyleMissionControlData> list) {
        Intrinsics.checkNotNullParameter(list, "missions");
        this.missions = list;
    }

    public static /* synthetic */ LifeStyleMissionControl copy$default(LifeStyleMissionControl lifeStyleMissionControl, List<LifeStyleMissionControlData> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = lifeStyleMissionControl.missions;
        }
        return lifeStyleMissionControl.copy(list);
    }

    @NotNull
    public final List<LifeStyleMissionControlData> component1() {
        return this.missions;
    }

    @NotNull
    public final LifeStyleMissionControl copy(@NotNull List<LifeStyleMissionControlData> list) {
        Intrinsics.checkNotNullParameter(list, "missions");
        return new LifeStyleMissionControl(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LifeStyleMissionControl) && Intrinsics.areEqual((Object) this.missions, (Object) ((LifeStyleMissionControl) obj).missions);
    }

    @NotNull
    public final List<LifeStyleMissionControlData> getMissions() {
        return this.missions;
    }

    public int hashCode() {
        return this.missions.hashCode();
    }

    @NotNull
    public String toString() {
        List<LifeStyleMissionControlData> list = this.missions;
        return "LifeStyleMissionControl(missions=" + list + ")";
    }
}
