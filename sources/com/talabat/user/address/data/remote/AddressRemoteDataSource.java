package com.talabat.user.address.data.remote;

import com.talabat.user.address.data.remote.dto.AddAddressDto;
import com.talabat.user.address.data.remote.dto.AddressPayload;
import com.talabat.user.address.data.remote.dto.UpdateAddressDto;
import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\r"}, d2 = {"Lcom/talabat/user/address/data/remote/AddressRemoteDataSource;", "", "addAddress", "Lio/reactivex/Single;", "Lcom/talabat/user/address/data/remote/dto/AddAddressDto;", "addressPayload", "Lcom/talabat/user/address/data/remote/dto/AddressPayload;", "deleteAddress", "Lio/reactivex/Completable;", "id", "", "updateAddress", "Lcom/talabat/user/address/data/remote/dto/UpdateAddressDto;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AddressRemoteDataSource {
    @NotNull
    Single<AddAddressDto> addAddress(@NotNull AddressPayload addressPayload);

    @NotNull
    Completable deleteAddress(@NotNull String str);

    @NotNull
    Single<UpdateAddressDto> updateAddress(@NotNull String str, @NotNull AddressPayload addressPayload);
}
