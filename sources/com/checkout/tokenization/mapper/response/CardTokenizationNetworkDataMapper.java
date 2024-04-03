package com.checkout.tokenization.mapper.response;

import com.checkout.base.error.CheckoutError;
import com.checkout.tokenization.entity.AddressEntity;
import com.checkout.tokenization.entity.PhoneEntity;
import com.checkout.tokenization.error.TokenizationError;
import com.checkout.tokenization.mapper.TokenizationNetworkDataMapper;
import com.checkout.tokenization.model.Address;
import com.checkout.tokenization.model.Phone;
import com.checkout.tokenization.model.TokenDetails;
import com.checkout.tokenization.response.TokenDetailsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u0002\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u0005H\u0014¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u00020\u00022\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002¨\u0006\r"}, d2 = {"Lcom/checkout/tokenization/mapper/response/CardTokenizationNetworkDataMapper;", "Lcom/checkout/tokenization/mapper/TokenizationNetworkDataMapper;", "Lcom/checkout/tokenization/model/TokenDetails;", "()V", "createMappedResult", "T", "", "resultBody", "(Ljava/lang/Object;)Lcom/checkout/tokenization/model/TokenDetails;", "fromCardTokenizationResponse", "result", "Lcom/checkout/tokenization/response/TokenDetailsResponse;", "Lcom/checkout/tokenization/response/GetTokenDetailsResponse;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardTokenizationNetworkDataMapper extends TokenizationNetworkDataMapper<TokenDetails> {
    private final TokenDetails fromCardTokenizationResponse(TokenDetailsResponse tokenDetailsResponse) {
        Address address;
        Phone phone;
        String type = tokenDetailsResponse.getType();
        String token = tokenDetailsResponse.getToken();
        String expiresOn = tokenDetailsResponse.getExpiresOn();
        int expiryMonth = tokenDetailsResponse.getExpiryMonth();
        int expiryYear = tokenDetailsResponse.getExpiryYear();
        String scheme = tokenDetailsResponse.getScheme();
        String schemeLocal = tokenDetailsResponse.getSchemeLocal();
        String last4 = tokenDetailsResponse.getLast4();
        String bin = tokenDetailsResponse.getBin();
        String cardType = tokenDetailsResponse.getCardType();
        String cardCategory = tokenDetailsResponse.getCardCategory();
        String issuer = tokenDetailsResponse.getIssuer();
        String issuerCountry = tokenDetailsResponse.getIssuerCountry();
        String productId = tokenDetailsResponse.getProductId();
        String productType = tokenDetailsResponse.getProductType();
        AddressEntity billingAddress = tokenDetailsResponse.getBillingAddress();
        String str = productType;
        if (billingAddress != null) {
            address = new AddressEntityToAddressDataMapper().map(billingAddress);
        } else {
            address = null;
        }
        PhoneEntity phone2 = tokenDetailsResponse.getPhone();
        if (phone2 != null) {
            phone = new PhoneEntityToPhoneDataMapper().map(phone2);
        } else {
            phone = null;
        }
        return new TokenDetails(type, token, expiresOn, expiryMonth, expiryYear, scheme, schemeLocal, last4, bin, cardType, cardCategory, issuer, issuerCountry, productId, str, address, phone, tokenDetailsResponse.getName());
    }

    @NotNull
    public <T> TokenDetails createMappedResult(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "resultBody");
        if (t11 instanceof TokenDetailsResponse) {
            return fromCardTokenizationResponse((TokenDetailsResponse) t11);
        }
        String name2 = t11.getClass().getName();
        throw new CheckoutError(TokenizationError.TOKENIZATION_API_MALFORMED_JSON, name2 + " cannot be mapped to a TokenDetails", (Throwable) null, 4, (DefaultConstructorMarker) null);
    }
}
