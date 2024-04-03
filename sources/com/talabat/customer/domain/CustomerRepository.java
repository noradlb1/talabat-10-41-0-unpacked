package com.talabat.customer.domain;

import com.talabat.configuration.payment.TokenizedBankCard;
import com.talabat.domain.address.Address;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\u0016H&J\b\u0010\u0019\u001a\u00020\u0016H&J\b\u0010\u001a\u001a\u00020\u0016H&J\b\u0010\u001b\u001a\u00020\u0016H&J\b\u0010\u001c\u001a\u00020\u0016H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0005H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0005H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\u0016\u0010#\u001a\u00020\u00032\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0011H&J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H&J \u0010+\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H&¨\u0006."}, d2 = {"Lcom/talabat/customer/domain/CustomerRepository;", "", "changeMobileNumberOfSelectedAddress", "", "mobileNumber", "", "clearTokenizationCards", "deselectCustomerAddress", "getBlock", "profileId", "getCustomerAddress", "Ljava/util/ArrayList;", "Lcom/talabat/domain/address/Address;", "Lkotlin/collections/ArrayList;", "getGlrId", "getSavedCards", "", "Lcom/talabat/configuration/payment/TokenizedBankCard;", "getSelectedCreditCardValidate", "getTalabatCreditBalance", "", "hasAddresses", "", "hasSavedCards", "isCreditCardsAvailable", "isFreeCoffeeEligible", "isLoggedIn", "isTPro", "isTalabatCreditAvailable", "removeCustomerAddress", "id", "removeDeletedCreditCard", "cardToken", "resetBrandLocalAddress", "setBrandScreenLocalAddress", "setCustomerAddresses", "addresses", "setSelectedCardValidate", "creditCard", "setSelectedCustomerAddress", "addressId", "areaId", "", "updateAddressGrl", "selectedGrl", "grlId", "com_talabat_core_customer_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CustomerRepository {
    void changeMobileNumberOfSelectedAddress(@NotNull String str);

    void clearTokenizationCards();

    void deselectCustomerAddress();

    @NotNull
    String getBlock(@NotNull String str);

    @NotNull
    ArrayList<Address> getCustomerAddress();

    @NotNull
    String getGlrId(@NotNull String str);

    @NotNull
    List<TokenizedBankCard> getSavedCards();

    @NotNull
    TokenizedBankCard getSelectedCreditCardValidate();

    float getTalabatCreditBalance();

    boolean hasAddresses();

    boolean hasSavedCards();

    boolean isCreditCardsAvailable();

    boolean isFreeCoffeeEligible();

    boolean isLoggedIn();

    boolean isTPro();

    boolean isTalabatCreditAvailable();

    void removeCustomerAddress(@NotNull String str);

    void removeDeletedCreditCard(@NotNull String str);

    void resetBrandLocalAddress();

    void setBrandScreenLocalAddress();

    void setCustomerAddresses(@NotNull List<Address> list);

    void setSelectedCardValidate(@NotNull TokenizedBankCard tokenizedBankCard);

    void setSelectedCustomerAddress(@NotNull String str, int i11);

    void updateAddressGrl(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
