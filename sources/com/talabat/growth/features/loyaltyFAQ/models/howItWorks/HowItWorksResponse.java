package com.talabat.growth.features.loyaltyFAQ.models.howItWorks;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/talabat/growth/features/loyaltyFAQ/models/howItWorks/HowItWorksResponse;", "", "()V", "instructions", "", "Lcom/talabat/growth/features/loyaltyFAQ/models/howItWorks/HowItWorksItemResponse;", "getInstructions", "()[Lcom/talabat/growth/features/loyaltyFAQ/models/howItWorks/HowItWorksItemResponse;", "setInstructions", "([Lcom/talabat/growth/features/loyaltyFAQ/models/howItWorks/HowItWorksItemResponse;)V", "[Lcom/talabat/growth/features/loyaltyFAQ/models/howItWorks/HowItWorksItemResponse;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HowItWorksResponse {
    @SerializedName("instructions")
    @Nullable
    private HowItWorksItemResponse[] instructions;

    @Nullable
    public final HowItWorksItemResponse[] getInstructions() {
        return this.instructions;
    }

    public final void setInstructions(@Nullable HowItWorksItemResponse[] howItWorksItemResponseArr) {
        this.instructions = howItWorksItemResponseArr;
    }
}
