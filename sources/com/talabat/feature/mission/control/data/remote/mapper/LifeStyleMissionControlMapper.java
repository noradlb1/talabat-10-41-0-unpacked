package com.talabat.feature.mission.control.data.remote.mapper;

import com.talabat.feature.mission.control.data.remote.model.LifeStyleMissionControlResponse;
import com.talabat.feature.mission.control.data.remote.model.LifeStyleMissionControlResponseData;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControl;
import com.talabat.feature.mission.control.domain.model.LifeStyleMissionControlData;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/mission/control/data/remote/mapper/LifeStyleMissionControlMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/mission/control/data/remote/model/LifeStyleMissionControlResponse;", "Lcom/talabat/feature/mission/control/domain/model/LifeStyleMissionControl;", "()V", "apply", "source", "com_talabat_feature_mission-control_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifeStyleMissionControlMapper implements ModelMapper<LifeStyleMissionControlResponse, LifeStyleMissionControl> {
    @NotNull
    public LifeStyleMissionControl apply(@NotNull LifeStyleMissionControlResponse lifeStyleMissionControlResponse) {
        List list;
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(lifeStyleMissionControlResponse, "source");
        List<LifeStyleMissionControlResponseData> missions = lifeStyleMissionControlResponse.getMissions();
        if (missions != null) {
            Iterable<LifeStyleMissionControlResponseData> iterable = missions;
            list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (LifeStyleMissionControlResponseData lifeStyleMissionControlResponseData : iterable) {
                String bgColor = lifeStyleMissionControlResponseData.getBgColor();
                String str4 = bgColor == null ? "" : bgColor;
                String code = lifeStyleMissionControlResponseData.getCode();
                if (code == null) {
                    str = "";
                } else {
                    str = code;
                }
                String imageUrl = lifeStyleMissionControlResponseData.getImageUrl();
                if (imageUrl == null) {
                    str2 = "";
                } else {
                    str2 = imageUrl;
                }
                String name2 = lifeStyleMissionControlResponseData.getName();
                if (name2 == null) {
                    str3 = "";
                } else {
                    str3 = name2;
                }
                String text = lifeStyleMissionControlResponseData.getText();
                if (text == null) {
                    text = "";
                }
                list.add(new LifeStyleMissionControlData(str4, str, str2, str3, text));
            }
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return new LifeStyleMissionControl(list);
    }
}
