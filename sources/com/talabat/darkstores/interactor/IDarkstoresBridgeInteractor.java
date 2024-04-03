package com.talabat.darkstores.interactor;

import com.talabat.domain.address.Address;
import datamodels.Restaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/interactor/IDarkstoresBridgeInteractor;", "", "getDarkstore", "Ldatamodels/Restaurant;", "loadCustomerDetails", "", "updateAddresswithGoogleAddress", "address", "Lcom/talabat/domain/address/Address;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IDarkstoresBridgeInteractor {
    @Nullable
    Restaurant getDarkstore();

    void loadCustomerDetails();

    void updateAddresswithGoogleAddress(@NotNull Address address);
}
