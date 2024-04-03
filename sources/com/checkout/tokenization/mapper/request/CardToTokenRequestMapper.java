package com.checkout.tokenization.mapper.request;

import com.checkout.base.mapper.Mapper;
import com.checkout.tokenization.entity.AddressEntity;
import com.checkout.tokenization.model.Address;
import com.checkout.tokenization.model.Card;
import com.checkout.tokenization.model.Phone;
import com.checkout.tokenization.request.TokenRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/checkout/tokenization/mapper/request/CardToTokenRequestMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/tokenization/model/Card;", "Lcom/checkout/tokenization/request/TokenRequest;", "()V", "map", "from", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardToTokenRequestMapper implements Mapper<Card, TokenRequest> {
    @NotNull
    public TokenRequest map(@NotNull Card card) {
        Intrinsics.checkNotNullParameter(card, "from");
        String number = card.getNumber();
        String valueOf = String.valueOf(card.getExpiryDate().getExpiryMonth());
        String valueOf2 = String.valueOf(card.getExpiryDate().getExpiryYear());
        String name2 = card.getName();
        String cvv = card.getCvv();
        Address billingAddress = card.getBillingAddress();
        AddressEntity map = billingAddress != null ? new AddressToAddressEntityDataMapper().map(billingAddress) : null;
        Phone phone = card.getPhone();
        return new TokenRequest("card", number, valueOf, valueOf2, name2, cvv, map, phone != null ? new PhoneToPhoneEntityDataMapper().map(phone) : null);
    }
}
