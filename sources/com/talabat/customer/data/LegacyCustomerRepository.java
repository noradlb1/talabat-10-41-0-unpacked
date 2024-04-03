package com.talabat.customer.data;

import android.content.Context;
import buisnessmodels.Customer;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.configuration.payment.TokenizedBankCard;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.customer.data.convert.TokenizedBankCardMapper;
import com.talabat.customer.data.convert.TokenizedCreditCardMapper;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.domain.address.Address;
import com.talabat.helpers.LoggedInHelper;
import datamodels.CustomerInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u001fH\u0017J\b\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u001fH\u0017J\b\u0010%\u001a\u00020\u001fH\u0016J\u0010\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u000eH\u0016J\u0010\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020\fH\u0016J\b\u0010+\u001a\u00020\fH\u0016J\u0016\u0010,\u001a\u00020\f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019H\u0016J\u0010\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u001aH\u0016J\u0018\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016J \u00104\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/talabat/customer/data/LegacyCustomerRepository;", "Lcom/talabat/customer/domain/CustomerRepository;", "context", "Landroid/content/Context;", "tokenizedBankCardMapper", "Lcom/talabat/customer/data/convert/TokenizedBankCardMapper;", "tokenizedCreditCardMapper", "Lcom/talabat/customer/data/convert/TokenizedCreditCardMapper;", "customer", "Lbuisnessmodels/Customer;", "(Landroid/content/Context;Lcom/talabat/customer/data/convert/TokenizedBankCardMapper;Lcom/talabat/customer/data/convert/TokenizedCreditCardMapper;Lbuisnessmodels/Customer;)V", "changeMobileNumberOfSelectedAddress", "", "mobileNumber", "", "clearTokenizationCards", "deselectCustomerAddress", "getBlock", "profileId", "getCustomerAddress", "Ljava/util/ArrayList;", "Lcom/talabat/domain/address/Address;", "Lkotlin/collections/ArrayList;", "getGlrId", "getSavedCards", "", "Lcom/talabat/configuration/payment/TokenizedBankCard;", "getSelectedCreditCardValidate", "getTalabatCreditBalance", "", "hasAddresses", "", "hasSavedCards", "isCreditCardsAvailable", "isFreeCoffeeEligible", "isLoggedIn", "isTPro", "isTalabatCreditAvailable", "removeCustomerAddress", "id", "removeDeletedCreditCard", "cardToken", "resetBrandLocalAddress", "setBrandScreenLocalAddress", "setCustomerAddresses", "addresses", "setSelectedCardValidate", "creditCard", "setSelectedCustomerAddress", "addressId", "areaId", "", "updateAddressGrl", "selectedGrl", "grlId", "com_talabat_core_customer_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacyCustomerRepository implements CustomerRepository {
    @NotNull
    private final Context context;
    @NotNull
    private final Customer customer;
    @NotNull
    private final TokenizedBankCardMapper tokenizedBankCardMapper;
    @NotNull
    private final TokenizedCreditCardMapper tokenizedCreditCardMapper;

    @Inject
    public LegacyCustomerRepository(@NotNull @ApplicationContext Context context2, @NotNull TokenizedBankCardMapper tokenizedBankCardMapper2, @NotNull TokenizedCreditCardMapper tokenizedCreditCardMapper2, @NotNull Customer customer2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(tokenizedBankCardMapper2, "tokenizedBankCardMapper");
        Intrinsics.checkNotNullParameter(tokenizedCreditCardMapper2, "tokenizedCreditCardMapper");
        Intrinsics.checkNotNullParameter(customer2, "customer");
        this.context = context2;
        this.tokenizedBankCardMapper = tokenizedBankCardMapper2;
        this.tokenizedCreditCardMapper = tokenizedCreditCardMapper2;
        this.customer = customer2;
    }

    public void changeMobileNumberOfSelectedAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "mobileNumber");
        this.customer.changeMobileNumberOfSelectedAddress(str);
    }

    public void clearTokenizationCards() {
        this.customer.isClearTokenisationCards();
    }

    public void deselectCustomerAddress() {
        this.customer.deselectCustomerAddress();
    }

    @NotNull
    public String getBlock(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "profileId");
        Iterator<Address> it = this.customer.getCustomerAddress().iterator();
        while (it.hasNext()) {
            Address next = it.next();
            if (Intrinsics.areEqual((Object) str, (Object) next.f58343id)) {
                String str2 = next.block;
                if (str2 == null) {
                    return "";
                }
                return str2;
            }
        }
        return "";
    }

    @NotNull
    public ArrayList<Address> getCustomerAddress() {
        ArrayList<Address> customerAddress = this.customer.getCustomerAddress();
        Intrinsics.checkNotNullExpressionValue(customerAddress, "customer.customerAddress");
        return customerAddress;
    }

    @NotNull
    public String getGlrId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "profileId");
        Iterator<Address> it = this.customer.getCustomerAddress().iterator();
        while (it.hasNext()) {
            Address next = it.next();
            if (Intrinsics.areEqual((Object) str, (Object) next.f58343id)) {
                String grlId = next.getGrlId();
                if (grlId == null) {
                    return "";
                }
                return grlId;
            }
        }
        return "";
    }

    @NotNull
    public List<TokenizedBankCard> getSavedCards() {
        ArrayList<TokenisationCreditCard> savedCards = this.customer.getSavedCards();
        Intrinsics.checkNotNullExpressionValue(savedCards, "customer.savedCards");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(savedCards, 10));
        for (TokenisationCreditCard tokenisationCreditCard : savedCards) {
            TokenizedBankCardMapper tokenizedBankCardMapper2 = this.tokenizedBankCardMapper;
            Intrinsics.checkNotNullExpressionValue(tokenisationCreditCard, "it");
            arrayList.add(tokenizedBankCardMapper2.apply(tokenisationCreditCard));
        }
        return arrayList;
    }

    @NotNull
    public TokenizedBankCard getSelectedCreditCardValidate() {
        TokenizedBankCardMapper tokenizedBankCardMapper2 = this.tokenizedBankCardMapper;
        TokenisationCreditCard selectedCreditCardValidate = this.customer.getSelectedCreditCardValidate();
        Intrinsics.checkNotNullExpressionValue(selectedCreditCardValidate, "customer.getSelectedCreditCardValidate()");
        return tokenizedBankCardMapper2.apply(selectedCreditCardValidate);
    }

    public float getTalabatCreditBalance() {
        return this.customer.getTalabatCreditBalance();
    }

    public boolean hasAddresses() {
        return this.customer.hasAddresses();
    }

    public boolean hasSavedCards() {
        return this.customer.hasSavedCards();
    }

    public boolean isCreditCardsAvailable() {
        return this.customer.isCreditCardsAvailable();
    }

    @Deprecated(message = "This method is deprecated")
    public boolean isFreeCoffeeEligible() {
        Boolean isFreeCoffeeEligible = this.customer.isFreeCoffeeEligible();
        Intrinsics.checkNotNullExpressionValue(isFreeCoffeeEligible, "customer.isFreeCoffeeEligible");
        return isFreeCoffeeEligible.booleanValue();
    }

    public boolean isLoggedIn() {
        return LoggedInHelper.isLoggedIn();
    }

    @Deprecated(message = "This method is deprecated")
    public boolean isTPro() {
        Boolean isTPro = this.customer.isTPro();
        Intrinsics.checkNotNullExpressionValue(isTPro, "customer.isTPro");
        return isTPro.booleanValue();
    }

    public boolean isTalabatCreditAvailable() {
        CustomerInfo customerInfo = this.customer.getCustomerInfo();
        if (customerInfo == null || customerInfo.talabatCredit <= 0.0f) {
            return false;
        }
        return true;
    }

    public void removeCustomerAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.customer.RemoveCustomerAddress(str);
    }

    public void removeDeletedCreditCard(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "cardToken");
        this.customer.removeDeletedCreditCard(str);
    }

    public void resetBrandLocalAddress() {
        this.customer.resetBrandLocalAddress();
    }

    public void setBrandScreenLocalAddress() {
        this.customer.setBrandScreenLocalAddress();
    }

    public void setCustomerAddresses(@NotNull List<Address> list) {
        Intrinsics.checkNotNullParameter(list, "addresses");
        this.customer.setCustomerAddress(this.context, new ArrayList(list));
    }

    public void setSelectedCardValidate(@NotNull TokenizedBankCard tokenizedBankCard) {
        Intrinsics.checkNotNullParameter(tokenizedBankCard, "creditCard");
        this.customer.setSelectedCreditCard(this.tokenizedCreditCardMapper.apply(tokenizedBankCard));
    }

    public void setSelectedCustomerAddress(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "addressId");
        this.customer.setSelectedCustomerAddress(this.context, str, i11);
    }

    public void updateAddressGrl(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "profileId");
        Intrinsics.checkNotNullParameter(str2, "selectedGrl");
        Intrinsics.checkNotNullParameter(str3, "grlId");
        this.customer.updateAddressGrl(str, str2, str3);
    }
}
