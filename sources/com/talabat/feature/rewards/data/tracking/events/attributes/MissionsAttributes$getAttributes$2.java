package com.talabat.feature.rewards.data.tracking.events.attributes;

import com.talabat.feature.rewards.domain.model.Mission;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/feature/rewards/domain/model/Mission;", "invoke", "(Lcom/talabat/feature/rewards/domain/model/Mission;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MissionsAttributes$getAttributes$2 extends Lambda implements Function1<Mission, Integer> {
    public static final MissionsAttributes$getAttributes$2 INSTANCE = new MissionsAttributes$getAttributes$2();

    public MissionsAttributes$getAttributes$2() {
        super(1);
    }

    @Nullable
    public final Integer invoke(@NotNull Mission mission) {
        Intrinsics.checkNotNullParameter(mission, "it");
        return mission.getStatusId();
    }
}
