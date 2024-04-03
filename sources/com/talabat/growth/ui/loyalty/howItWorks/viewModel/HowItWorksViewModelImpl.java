package com.talabat.growth.ui.loyalty.howItWorks.viewModel;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.talabat.growth.features.loyaltyFAQ.GetHowItWorksTips;
import com.talabat.growth.ui.loyalty.howItWorks.model.HowItWorksDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/growth/ui/loyalty/howItWorks/viewModel/HowItWorksViewModelImpl;", "Lcom/talabat/growth/ui/loyalty/howItWorks/viewModel/HowItWorksViewModel;", "getHowItWorksTips", "Lcom/talabat/growth/features/loyaltyFAQ/GetHowItWorksTips;", "(Lcom/talabat/growth/features/loyaltyFAQ/GetHowItWorksTips;)V", "getGetHowItWorksTips", "", "languageCode", "", "handleHowItWorksDisplayModel", "data", "Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksDisplayModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HowItWorksViewModelImpl extends HowItWorksViewModel {
    @NotNull
    private final GetHowItWorksTips getHowItWorksTips;

    public HowItWorksViewModelImpl(@NotNull GetHowItWorksTips getHowItWorksTips2) {
        Intrinsics.checkNotNullParameter(getHowItWorksTips2, "getHowItWorksTips");
        this.getHowItWorksTips = getHowItWorksTips2;
    }

    public void getGetHowItWorksTips(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        this.getHowItWorksTips.invoke(str, new HowItWorksViewModelImpl$getGetHowItWorksTips$1(this));
    }

    public final void handleHowItWorksDisplayModel(@NotNull HowItWorksDisplayModel howItWorksDisplayModel) {
        Intrinsics.checkNotNullParameter(howItWorksDisplayModel, "data");
        getHowItWorksTipsData().setValue(howItWorksDisplayModel);
    }
}
