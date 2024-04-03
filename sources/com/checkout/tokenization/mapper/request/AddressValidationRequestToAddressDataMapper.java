package com.checkout.tokenization.mapper.request;

import com.checkout.base.mapper.Mapper;
import com.checkout.tokenization.model.Address;
import com.checkout.validation.model.AddressValidationRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/checkout/tokenization/mapper/request/AddressValidationRequestToAddressDataMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/validation/model/AddressValidationRequest;", "Lcom/checkout/tokenization/model/Address;", "()V", "map", "from", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressValidationRequestToAddressDataMapper implements Mapper<AddressValidationRequest, Address> {
    @NotNull
    public Address map(@NotNull AddressValidationRequest addressValidationRequest) {
        Intrinsics.checkNotNullParameter(addressValidationRequest, "from");
        return new Address(addressValidationRequest.getAddressLine1(), addressValidationRequest.getAddressLine2(), addressValidationRequest.getCity(), addressValidationRequest.getState(), addressValidationRequest.getZip(), addressValidationRequest.getCountry());
    }
}
