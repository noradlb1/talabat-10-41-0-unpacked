package com.talabat.growth.features.loyaltyFAQ;

import com.talabat.growth.features.loyaltyFAQ.models.howItWorks.HowItWorksResponse;
import com.talabat.growth.features.loyaltyFAQ.models.howItWorks.HowItWorksRootResponse;
import com.talabat.growth.ui.loyalty.howItWorks.model.HowItWorksDisplayModel;
import com.talabat.growth.ui.loyalty.howItWorks.model.HowItWorksMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksDisplayModel;", "it", "Lcom/talabat/growth/features/loyaltyFAQ/models/howItWorks/HowItWorksRootResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetHowItWorksTips$run$2 extends Lambda implements Function1<HowItWorksRootResponse, HowItWorksDisplayModel> {
    public static final GetHowItWorksTips$run$2 INSTANCE = new GetHowItWorksTips$run$2();

    public GetHowItWorksTips$run$2() {
        super(1);
    }

    @NotNull
    public final HowItWorksDisplayModel invoke(@NotNull HowItWorksRootResponse howItWorksRootResponse) {
        Intrinsics.checkNotNullParameter(howItWorksRootResponse, "it");
        return HowItWorksMapper.Companion.map((HowItWorksResponse) howItWorksRootResponse.getResult());
    }
}
