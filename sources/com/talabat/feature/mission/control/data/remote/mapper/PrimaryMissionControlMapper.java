package com.talabat.feature.mission.control.data.remote.mapper;

import com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse;
import com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponseData;
import com.talabat.feature.mission.control.data.remote.model.Result;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControl;
import com.talabat.feature.mission.control.domain.model.PrimaryMissionControlData;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/mission/control/data/remote/mapper/PrimaryMissionControlMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/mission/control/data/remote/model/PrimaryMissionControlResponse;", "Lcom/talabat/feature/mission/control/domain/model/PrimaryMissionControl;", "()V", "apply", "source", "com_talabat_feature_mission-control_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrimaryMissionControlMapper implements ModelMapper<PrimaryMissionControlResponse, PrimaryMissionControl> {
    @NotNull
    public PrimaryMissionControl apply(@NotNull PrimaryMissionControlResponse primaryMissionControlResponse) {
        List list;
        List<PrimaryMissionControlResponseData> missions;
        Intrinsics.checkNotNullParameter(primaryMissionControlResponse, "source");
        Result result = primaryMissionControlResponse.getResult();
        if (result == null || (missions = result.getMissions()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            Iterable<PrimaryMissionControlResponseData> iterable = missions;
            list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (PrimaryMissionControlResponseData primaryMissionControlResponseData : iterable) {
                String code = primaryMissionControlResponseData.getCode();
                String str = "";
                if (code == null) {
                    code = str;
                }
                String name2 = primaryMissionControlResponseData.getName();
                if (name2 == null) {
                    name2 = str;
                }
                String iconType = primaryMissionControlResponseData.getIconType();
                if (iconType != null) {
                    str = iconType;
                }
                list.add(new PrimaryMissionControlData(code, name2, str));
            }
        }
        return new PrimaryMissionControl(list);
    }
}
