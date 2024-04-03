package com.talabat.talabatlife.features.waitList;

import com.talabat.talabatlife.features.waitList.model.UserWaitListRootResponse;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingDisplayModelMapper;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingWaitListDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingWaitListDisplayModel;", "it", "Lcom/talabat/talabatlife/features/waitList/model/UserWaitListRootResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetUserWaitListState$run$2 extends Lambda implements Function1<UserWaitListRootResponse, TLifeOnBoardingWaitListDisplayModel> {
    public static final GetUserWaitListState$run$2 INSTANCE = new GetUserWaitListState$run$2();

    public GetUserWaitListState$run$2() {
        super(1);
    }

    @NotNull
    public final TLifeOnBoardingWaitListDisplayModel invoke(@NotNull UserWaitListRootResponse userWaitListRootResponse) {
        Intrinsics.checkNotNullParameter(userWaitListRootResponse, "it");
        return TLifeOnBoardingDisplayModelMapper.Companion.mapToTLifeOnBoardingDisplayModel(userWaitListRootResponse);
    }
}
