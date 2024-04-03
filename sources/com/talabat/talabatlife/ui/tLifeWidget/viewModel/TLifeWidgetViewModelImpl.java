package com.talabat.talabatlife.ui.tLifeWidget.viewModel;

import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.talabatlife.features.tLifeWidget.GetTLifeSubscriptionStatusUseCase;
import com.talabat.talabatlife.features.tLifeWidget.model.TLifeSubscriptionStatusRequestModel;
import com.talabat.talabatlife.ui.tLifeWidget.model.SubscriptionStatusDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatlife/ui/tLifeWidget/viewModel/TLifeWidgetViewModelImpl;", "Lcom/talabat/talabatlife/ui/tLifeWidget/viewModel/TLifeWidgetViewModel;", "TLifeSubscriptionStatusUseCase", "Lcom/talabat/talabatlife/features/tLifeWidget/GetTLifeSubscriptionStatusUseCase;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "(Lcom/talabat/talabatlife/features/tLifeWidget/GetTLifeSubscriptionStatusUseCase;Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;)V", "getTLifeSubscriptionStatus", "", "country", "", "handleTLifeUserSubscriptionServiceSuccess", "subscriptionStatusDisplayModel", "Lcom/talabat/talabatlife/ui/tLifeWidget/model/SubscriptionStatusDisplayModel;", "isTProUser", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeWidgetViewModelImpl extends TLifeWidgetViewModel {
    @NotNull
    private final GetTLifeSubscriptionStatusUseCase TLifeSubscriptionStatusUseCase;
    @NotNull
    private final ISubscriptionStatusRepository subscriptionStatusRepository;

    public TLifeWidgetViewModelImpl(@NotNull GetTLifeSubscriptionStatusUseCase getTLifeSubscriptionStatusUseCase, @NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        Intrinsics.checkNotNullParameter(getTLifeSubscriptionStatusUseCase, "TLifeSubscriptionStatusUseCase");
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        this.TLifeSubscriptionStatusUseCase = getTLifeSubscriptionStatusUseCase;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
    }

    /* access modifiers changed from: private */
    public final void handleTLifeUserSubscriptionServiceSuccess(SubscriptionStatusDisplayModel subscriptionStatusDisplayModel) {
        getSubscriptionData().setValue(subscriptionStatusDisplayModel);
    }

    public void getTLifeSubscriptionStatus(int i11) {
        this.TLifeSubscriptionStatusUseCase.invoke(new TLifeSubscriptionStatusRequestModel(i11), new TLifeWidgetViewModelImpl$getTLifeSubscriptionStatus$1(this));
    }

    public boolean isTProUser() {
        return this.subscriptionStatusRepository.isTProUser();
    }
}
