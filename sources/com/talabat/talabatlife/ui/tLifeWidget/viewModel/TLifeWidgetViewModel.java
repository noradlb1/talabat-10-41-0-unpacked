package com.talabat.talabatlife.ui.tLifeWidget.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.network.endpoint.TLifeEndPointProvider;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.talabatlife.features.UrlConstantsKt;
import com.talabat.talabatlife.ui.tLifeWidget.model.SubscriptionStatusDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatlife/ui/tLifeWidget/viewModel/TLifeWidgetViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "logoUrl", "", "getLogoUrl", "()Ljava/lang/String;", "subscriptionData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatlife/ui/tLifeWidget/model/SubscriptionStatusDisplayModel;", "getSubscriptionData", "()Landroidx/lifecycle/MutableLiveData;", "setSubscriptionData", "(Landroidx/lifecycle/MutableLiveData;)V", "getTLifeSubscriptionStatus", "", "country", "", "isTProUser", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TLifeWidgetViewModel extends BaseViewModel {
    @NotNull
    private final String logoUrl;
    @NotNull
    private MutableLiveData<SubscriptionStatusDisplayModel> subscriptionData = new MutableLiveData<>();

    public TLifeWidgetViewModel() {
        String baseUrl = TLifeEndPointProvider.INSTANCE.getBaseUrl();
        this.logoUrl = baseUrl + UrlConstantsKt.T_LIFE_LOGO_URL;
    }

    public static /* synthetic */ void getTLifeSubscriptionStatus$default(TLifeWidgetViewModel tLifeWidgetViewModel, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            tLifeWidgetViewModel.getTLifeSubscriptionStatus(i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTLifeSubscriptionStatus");
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @NotNull
    public final MutableLiveData<SubscriptionStatusDisplayModel> getSubscriptionData() {
        return this.subscriptionData;
    }

    public abstract void getTLifeSubscriptionStatus(int i11);

    public abstract boolean isTProUser();

    public final void setSubscriptionData(@NotNull MutableLiveData<SubscriptionStatusDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.subscriptionData = mutableLiveData;
    }
}
