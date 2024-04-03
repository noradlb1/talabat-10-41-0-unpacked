package com.talabat.offering.presentation.viewmodel.mapper;

import com.talabat.offering.presentation.displaymodel.UserSubscriptionDisplayModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/offering/presentation/viewmodel/mapper/UserOfferCollectionSubscriptionDisplayModelMapper;", "", "()V", "mapUserSubscriptionView", "Lcom/talabat/offering/presentation/displaymodel/UserSubscriptionDisplayModel;", "userIsOfferCollectionSubscribedUseCase", "", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserOfferCollectionSubscriptionDisplayModelMapper {
    @NotNull
    public static final UserOfferCollectionSubscriptionDisplayModelMapper INSTANCE = new UserOfferCollectionSubscriptionDisplayModelMapper();

    private UserOfferCollectionSubscriptionDisplayModelMapper() {
    }

    @NotNull
    public final UserSubscriptionDisplayModel mapUserSubscriptionView(boolean z11) {
        if (z11) {
            return UserSubscriptionDisplayModel.UserSubscribed.INSTANCE;
        }
        if (!z11) {
            return UserSubscriptionDisplayModel.UserNotSubscribed.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
