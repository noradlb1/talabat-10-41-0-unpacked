package com.checkout.tokenization.mapper.response;

import com.checkout.base.mapper.Mapper;
import com.checkout.base.model.Country;
import com.checkout.tokenization.entity.PhoneEntity;
import com.checkout.tokenization.model.Phone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/checkout/tokenization/mapper/response/PhoneEntityToPhoneDataMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/tokenization/entity/PhoneEntity;", "Lcom/checkout/tokenization/model/Phone;", "()V", "map", "from", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneEntityToPhoneDataMapper implements Mapper<PhoneEntity, Phone> {
    @NotNull
    public Phone map(@NotNull PhoneEntity phoneEntity) {
        Intrinsics.checkNotNullParameter(phoneEntity, "from");
        return new Phone(phoneEntity.getNumber(), Country.Companion.getCountryFromDialingCode$checkout_release(phoneEntity.getCountryCode()));
    }
}
