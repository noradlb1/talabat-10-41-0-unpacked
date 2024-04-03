package com.talabat.feature.address.data.local;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/address/data/local/AddressesLocalDataSource;", "", "cacheCustomerAddresses", "", "customerAddressLocalDataModel", "Lcom/talabat/feature/address/data/local/CustomerAddressLocalDataModel;", "getCustomerAddresses", "invalidateCustomerAddresses", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AddressesLocalDataSource {
    void cacheCustomerAddresses(@NotNull CustomerAddressLocalDataModel customerAddressLocalDataModel);

    @Nullable
    CustomerAddressLocalDataModel getCustomerAddresses();

    void invalidateCustomerAddresses();
}
