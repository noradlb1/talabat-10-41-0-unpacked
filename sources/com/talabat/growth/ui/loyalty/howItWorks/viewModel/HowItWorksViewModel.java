package com.talabat.growth.ui.loyalty.howItWorks.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.growth.ui.loyalty.howItWorks.model.HowItWorksDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/talabat/growth/ui/loyalty/howItWorks/viewModel/HowItWorksViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "howItWorksTipsData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksDisplayModel;", "getHowItWorksTipsData", "()Landroidx/lifecycle/MutableLiveData;", "setHowItWorksTipsData", "(Landroidx/lifecycle/MutableLiveData;)V", "getGetHowItWorksTips", "", "languageCode", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class HowItWorksViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<HowItWorksDisplayModel> howItWorksTipsData = new MutableLiveData<>();

    public static /* synthetic */ void getGetHowItWorksTips$default(HowItWorksViewModel howItWorksViewModel, String str, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                str = IntegrationGlobalDataModel.Companion.selectedLanguage();
            }
            howItWorksViewModel.getGetHowItWorksTips(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGetHowItWorksTips");
    }

    public abstract void getGetHowItWorksTips(@NotNull String str);

    @NotNull
    public final MutableLiveData<HowItWorksDisplayModel> getHowItWorksTipsData() {
        return this.howItWorksTipsData;
    }

    public final void setHowItWorksTipsData(@NotNull MutableLiveData<HowItWorksDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.howItWorksTipsData = mutableLiveData;
    }
}
