package com.talabat.darkstores.presenter;

import com.talabat.domain.address.Address;
import datamodels.Restaurant;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J:\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/presenter/IDarkstoresBridgePresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "checkIfBackupNeeded", "", "restaurantBackup", "Ldatamodels/Restaurant;", "onCheckoutClicked", "restaurant", "isFromCartFlow", "", "isNineCookiesTrackingEnabledFromAddress", "mcdKsaAddressUpdateIgnore", "isMapFirstReDirectCheckout", "isAfterVerifyingUserInfo", "updateAddressWithGoogleApi", "address", "Lcom/talabat/domain/address/Address;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IDarkstoresBridgePresenter extends IGlobalPresenter {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onCheckoutClicked$default(IDarkstoresBridgePresenter iDarkstoresBridgePresenter, Restaurant restaurant, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 32) != 0) {
                    z15 = false;
                }
                iDarkstoresBridgePresenter.onCheckoutClicked(restaurant, z11, z12, z13, z14, z15);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCheckoutClicked");
        }
    }

    void checkIfBackupNeeded(@NotNull Restaurant restaurant);

    void onCheckoutClicked(@NotNull Restaurant restaurant, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15);

    void updateAddressWithGoogleApi(@NotNull Address address);
}
