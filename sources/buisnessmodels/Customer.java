package buisnessmodels;

import JsonModels.parser.UniversalGson;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.configuration.country.Country;
import com.talabat.domain.address.Address;
import com.talabat.domain.address.AddressesKt;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.LoggedInHelper;
import com.talabat.helpers.TalabatUtils;
import com.talabat.userandlocation.customerinfo.data.local.CustomerInfoLocalDataSource;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import datamodels.CustomerInfo;
import datamodels.LastOrdersDetails;
import datamodels.Token;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
public class Customer implements ICustomer {
    private static final Customer ourInstance = new Customer();
    public Address brandLocalAddress;
    private ArrayList<Address> customerAddress;
    private CustomerInfo customerInfo;
    @Nullable
    private CustomerInfoLocalDataSource customerInfoLocalDataSource;
    private Subject<CustomerInfo> customerInfoSubject = BehaviorSubject.createDefault(new CustomerInfo());
    ArrayList<Address> deliverableAddress;
    private boolean isPro = false;
    public float minimOrderValueToEnableTproDiscount = 0.0f;
    public Address saveForLaterAddress;
    public String saveForLaterSelectedAddressId;
    public TokenisationCreditCard selectedCreditCard;
    public TokenisationCreditCard selectedCreditCardValidate;
    private String selectedCustomerAddressId = "";
    public boolean shouldCheckForAreaSplit = true;
    private boolean showPro = false;
    @Nullable
    @Deprecated
    public Subscription tProSubscriptionInfo;
    ArrayList<TokenisationCreditCard> tokenisationCreditCards;

    private Customer() {
    }

    public static void clearToken(Context context) {
        GlobalDataModel.token = null;
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putString(LegacyTokenLocalDataSourceImpl.KEY, "");
        edit.apply();
        Customer instance = getInstance();
        instance.setCustomerInfo((CustomerInfo) null);
        instance.customerAddress = null;
        instance.tokenisationCreditCards = new ArrayList<>();
        GlobalDataModel.BIN.savedTokens = new ArrayList<>();
    }

    private void deleteSavedProfile(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.remove("profileId");
        edit.apply();
    }

    private CustomerInfoLocalDataSource getCustomerInfoLocalDataSourceInstance() {
        if (this.customerInfoLocalDataSource == null) {
            this.customerInfoLocalDataSource = new CustomerInfoLocalDataSourceImpl();
        }
        return this.customerInfoLocalDataSource;
    }

    public static Customer getInstance() {
        return ourInstance;
    }

    private String getSelectedProfileIdFromPrefs(Context context) {
        return context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).getString("profileId", "");
    }

    private void retriveProfileIdIfApplicable(Context context) {
        ArrayList<Address> arrayList;
        if (TalabatUtils.isNullOrEmpty(this.selectedCustomerAddressId)) {
            String selectedProfileIdFromPrefs = getSelectedProfileIdFromPrefs(context);
            if (!TalabatUtils.isNullOrEmpty(selectedProfileIdFromPrefs) && (arrayList = this.customerAddress) != null) {
                Iterator<Address> it = arrayList.iterator();
                while (it.hasNext()) {
                    Address next = it.next();
                    if (next.f58343id.equals(selectedProfileIdFromPrefs) && GlobalDataModel.SelectedAreaId == next.areaId) {
                        this.selectedCustomerAddressId = selectedProfileIdFromPrefs;
                    }
                }
            }
        }
    }

    public static boolean retriveToken(Context context) {
        Object obj;
        Gson gson = UniversalGson.INSTANCE.gson;
        String string = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).getString(LegacyTokenLocalDataSourceImpl.KEY, "");
        if (string.equals("")) {
            return false;
        }
        Class cls = Token.class;
        if (!(gson instanceof Gson)) {
            obj = gson.fromJson(string, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson, string, cls);
        }
        GlobalDataModel.token = (Token) obj;
        return true;
    }

    private void saveSelectedProfile(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putString("profileId", str);
        edit.apply();
    }

    private void saveToLocalDataSource(CustomerInfo customerInfo2) {
        getCustomerInfoLocalDataSourceInstance().setCustomerInfo(customerInfo2);
    }

    public static void saveToken(Context context) {
        String str;
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        Gson gson = UniversalGson.INSTANCE.gson;
        Token token = GlobalDataModel.token;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) token);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) token);
        }
        edit.putString(LegacyTokenLocalDataSourceImpl.KEY, str);
        edit.apply();
    }

    public static void setSavedLanguage(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        if (str.startsWith(ArchiveStreamFactory.AR)) {
            edit.putString(GlobalConstants.PrefsConstants.LOCALE, GlobalConstants.ARABIC);
        } else if (str.equals(GlobalConstants.KURDISH_SORANI)) {
            edit.putString(GlobalConstants.PrefsConstants.LOCALE, GlobalConstants.KURDISH_SORANI);
        } else if (str.equals(GlobalConstants.KURDISH_BADINI)) {
            edit.putString(GlobalConstants.PrefsConstants.LOCALE, GlobalConstants.KURDISH_BADINI);
        } else {
            edit.putString(GlobalConstants.PrefsConstants.LOCALE, "en-US");
        }
        edit.apply();
    }

    public void AddCustomerAddress(Address address) {
        if (this.customerAddress == null) {
            this.customerAddress = new ArrayList<>();
        }
        this.customerAddress.add(address);
    }

    public void EditCustomerAddress(Context context, Address address) {
        for (int i11 = 0; i11 < this.customerAddress.size(); i11++) {
            Address address2 = this.customerAddress.get(i11);
            if (address2.f58343id.equals(address.f58343id)) {
                if (address2.areaId != address.areaId && this.selectedCustomerAddressId.equals(address.f58343id)) {
                    deselectCustomerAddress();
                    deleteSavedProfile(context);
                }
                this.customerAddress.remove(i11);
                this.customerAddress.add(i11, address);
            }
        }
    }

    public void RemoveCustomerAddress(String str) {
        for (int i11 = 0; i11 < this.customerAddress.size(); i11++) {
            if (this.customerAddress.get(i11).f58343id.equals(str)) {
                this.customerAddress.remove(i11);
                return;
            }
        }
    }

    public void changeMobileNumberOfSelectedAddress(String str) {
        String selectedCustomerAddressId2 = getSelectedCustomerAddressId();
        Iterator<Address> it = this.customerAddress.iterator();
        while (it.hasNext()) {
            Address next = it.next();
            if (next.f58343id.equals(selectedCustomerAddressId2)) {
                next.mobileNumber = str;
            }
        }
    }

    public void clearSelectedCard() {
        this.selectedCreditCard = null;
    }

    public void clearSelectedCardValidate() {
        this.selectedCreditCardValidate = null;
    }

    public void deselectCustomerAddress() {
        this.selectedCustomerAddressId = "";
    }

    public Address getBrandLocalAddress() {
        return this.brandLocalAddress;
    }

    @Deprecated
    public ArrayList<Address> getCustomerAddress() {
        ArrayList<Address> arrayList = new ArrayList<>();
        ArrayList<Address> arrayList2 = this.customerAddress;
        if (arrayList2 != null) {
            Iterator<Address> it = arrayList2.iterator();
            while (it.hasNext()) {
                Address next = it.next();
                if (next.countyId == GlobalDataModel.SelectedCountryId) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public CustomerInfo getCustomerInfo() {
        if (this.customerInfo == null) {
            this.customerInfo = getCustomerInfoLocalDataSourceInstance().getCustomerInfo();
        }
        return this.customerInfo;
    }

    public Subject<CustomerInfo> getCustomerInfoSubject() {
        return this.customerInfoSubject;
    }

    public String getId(String str) {
        Iterator<Address> it = this.customerAddress.iterator();
        while (it.hasNext()) {
            Address next = it.next();
            if (str.equals(next.f58343id)) {
                return next.block;
            }
        }
        return "";
    }

    public ArrayList<Address> getResDeliverableAddress() {
        return this.deliverableAddress;
    }

    public ArrayList<TokenisationCreditCard> getSavedCards() {
        ArrayList<TokenisationCreditCard> arrayList = this.tokenisationCreditCards;
        if (arrayList != null) {
            return arrayList;
        }
        return null;
    }

    public TokenisationCreditCard getSelectedCreditCard() {
        TokenisationCreditCard tokenisationCreditCard = new TokenisationCreditCard();
        TokenisationCreditCard tokenisationCreditCard2 = this.selectedCreditCard;
        if (tokenisationCreditCard2 != null) {
            return tokenisationCreditCard2;
        }
        return tokenisationCreditCard;
    }

    public TokenisationCreditCard getSelectedCreditCardValidate() {
        TokenisationCreditCard tokenisationCreditCard = new TokenisationCreditCard();
        TokenisationCreditCard tokenisationCreditCard2 = this.selectedCreditCardValidate;
        if (tokenisationCreditCard2 != null) {
            return tokenisationCreditCard2;
        }
        return tokenisationCreditCard;
    }

    public Address getSelectedCustomerAddress() {
        if (this.customerAddress == null || TalabatUtils.isNullOrEmpty(this.selectedCustomerAddressId)) {
            return null;
        }
        Iterator<Address> it = this.customerAddress.iterator();
        while (it.hasNext()) {
            Address next = it.next();
            if (next.f58343id.equals(this.selectedCustomerAddressId)) {
                return next;
            }
        }
        return null;
    }

    public String getSelectedCustomerAddressId() {
        return this.selectedCustomerAddressId;
    }

    public float getTalabatCreditBalance() {
        CustomerInfo customerInfo2;
        if (!isLoggedIn() || (customerInfo2 = this.customerInfo) == null) {
            return 0.0f;
        }
        return customerInfo2.talabatCredit;
    }

    public boolean hasAddresses() {
        return getCustomerAddress() != null && getCustomerAddress().size() > 0;
    }

    public boolean hasSavedCards() {
        ArrayList<TokenisationCreditCard> arrayList = this.tokenisationCreditCards;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    public void initSelectedCustomerAddressId(Context context) {
        if (TalabatUtils.isNullOrEmpty(this.selectedCustomerAddressId)) {
            retriveProfileIdIfApplicable(context);
        }
    }

    public void isClearTokenisationCards() {
        if (!this.tokenisationCreditCards.isEmpty()) {
            this.tokenisationCreditCards = null;
        }
    }

    public boolean isCreditCardsAvailable() {
        ArrayList<TokenisationCreditCard> arrayList = this.tokenisationCreditCards;
        if (arrayList == null || arrayList.isEmpty() || TalabatUtils.isNullOrEmpty(this.tokenisationCreditCards.get(0).cardnumber)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public Boolean isFreeCoffeeEligible() {
        boolean z11;
        Subscription subscription;
        if (!isTPro().booleanValue() || (subscription = this.tProSubscriptionInfo) == null || !subscription.isFreeCoffeeEnabled()) {
            z11 = false;
        } else {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }

    public boolean isLoggedIn(Context context) {
        if (!LoggedInHelper.isLoggedIn()) {
            retriveToken(context);
        }
        return LoggedInHelper.isLoggedIn();
    }

    public boolean isPro() {
        return this.isPro;
    }

    public boolean isShowPro() {
        return this.showPro;
    }

    @Deprecated
    public Boolean isTPro() {
        return Boolean.valueOf(isPro());
    }

    public void removeDeletedCreditCard(String str) {
        for (int i11 = 0; i11 < this.tokenisationCreditCards.size(); i11++) {
            if (this.tokenisationCreditCards.get(i11).token.equals(str)) {
                this.tokenisationCreditCards.remove(i11);
                return;
            }
        }
    }

    public void resetBrandLocalAddress() {
        this.brandLocalAddress = null;
    }

    public void setBrandScreenLocalAddress() {
        this.brandLocalAddress = null;
        this.brandLocalAddress = getSelectedCustomerAddress();
    }

    public void setCustomerAddress(@Nullable ArrayList<Address> arrayList) {
        this.customerAddress = arrayList;
    }

    public void setCustomerDeliverableAddressBasedRes(Address[] addressArr) {
        ArrayList<Address> arrayList = new ArrayList<>();
        this.deliverableAddress = arrayList;
        arrayList.addAll(Arrays.asList(addressArr));
    }

    public void setCustomerInfo(CustomerInfo customerInfo2) {
        this.customerInfo = customerInfo2;
        saveToLocalDataSource(customerInfo2);
        if (customerInfo2 != null) {
            GlobalDataModel.encryptedUserId = customerInfo2.encgid;
            getCustomerInfoSubject().onNext(customerInfo2);
        }
    }

    @VisibleForTesting
    public void setCustomerInfoLocalDataSource(@NotNull CustomerInfoLocalDataSource customerInfoLocalDataSource2) {
        this.customerInfoLocalDataSource = customerInfoLocalDataSource2;
    }

    public void setLastOrdersDetails(LastOrdersDetails[] lastOrdersDetailsArr) {
        CustomerInfo customerInfo2 = this.customerInfo;
        if (customerInfo2 != null) {
            customerInfo2.lastOrdersDetails = lastOrdersDetailsArr;
        }
    }

    public void setMapSaveLaterAddress(@Nullable String str, @Nullable Address address) {
        if (address != null) {
            this.saveForLaterAddress = address;
            this.saveForLaterSelectedAddressId = str;
        }
    }

    public void setPro(boolean z11) {
        this.isPro = z11;
    }

    public void setSavedCreditCards(TokenisationCreditCard[] tokenisationCreditCardArr) {
        this.tokenisationCreditCards = null;
        ArrayList<TokenisationCreditCard> arrayList = new ArrayList<>();
        this.tokenisationCreditCards = arrayList;
        if (tokenisationCreditCardArr != null && tokenisationCreditCardArr.length > 0) {
            arrayList.addAll(Arrays.asList(tokenisationCreditCardArr));
        }
    }

    public void setSelectedCardValidate(TokenisationCreditCard tokenisationCreditCard) {
        this.selectedCreditCardValidate = tokenisationCreditCard;
    }

    public void setSelectedCreditCard(TokenisationCreditCard tokenisationCreditCard) {
        if (tokenisationCreditCard != null) {
            this.selectedCreditCard = tokenisationCreditCard;
            setSelectedCardValidate(tokenisationCreditCard);
        }
    }

    public void setSelectedCustomerAddress(String str, int i11) {
        this.shouldCheckForAreaSplit = true;
        this.selectedCustomerAddressId = str;
        GlobalDataModel.SelectedAreaId = i11;
        ArrayList<Address> arrayList = this.customerAddress;
        if (arrayList != null) {
            Iterator<Address> it = arrayList.iterator();
            while (it.hasNext()) {
                Address next = it.next();
                if (next.areaId == i11) {
                    GlobalDataModel.SelectedAreaName = next.areaName;
                    return;
                }
            }
        }
    }

    public void setShowPro(boolean z11) {
        this.showPro = z11;
    }

    public void updateAddressGrl(String str, String str2, String str3) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            Iterator<Address> it = this.customerAddress.iterator();
            while (it.hasNext()) {
                Address next = it.next();
                if (str.equals(next.f58343id)) {
                    next.grl = str2;
                    next.grlid = str3;
                }
            }
        }
    }

    public void updateDeliveryAddress(Address address) {
        ArrayList<Address> arrayList;
        if (address != null && (arrayList = this.deliverableAddress) != null && arrayList.size() > 0) {
            for (int i11 = 0; i11 < this.deliverableAddress.size(); i11++) {
                if (this.deliverableAddress.get(i11).f58343id.equals(address.f58343id)) {
                    ArrayList<Address> arrayList2 = this.deliverableAddress;
                    arrayList2.set(i11, AddressesKt.merge(arrayList2.get(i11), address));
                    return;
                }
            }
        }
    }

    public Address updateGeoCordinates(String str, LatLng latLng, Address address) {
        ArrayList<Address> arrayList = this.customerAddress;
        if (arrayList != null) {
            Iterator<Address> it = arrayList.iterator();
            while (it.hasNext()) {
                Address next = it.next();
                if (next.f58343id.equals(str)) {
                    next.latitude = latLng.latitude;
                    next.longitude = latLng.longitude;
                    next.block = address.block;
                    next.street = address.street;
                    next.extraDirections = address.extraDirections;
                    return next;
                }
            }
        }
        return null;
    }

    public void deselectCustomerAddress(Context context) {
        deselectCustomerAddress();
        deleteSavedProfile(context);
    }

    public boolean hasAddresses(@NonNull Country country) {
        return !getCustomerAddress(country).isEmpty();
    }

    public void setCustomerAddress(Context context, ArrayList<Address> arrayList) {
        setCustomerAddress(arrayList);
        if (TalabatUtils.isNullOrEmpty(this.selectedCustomerAddressId)) {
            retriveProfileIdIfApplicable(context);
        }
    }

    public boolean hasAddresses(int i11) {
        if (getCustomerAddress() == null || getCustomerAddress().size() <= 0) {
            return false;
        }
        Iterator<Address> it = this.customerAddress.iterator();
        while (it.hasNext()) {
            if (it.next().cityId == i11) {
                return true;
            }
        }
        return false;
    }

    public boolean isLoggedIn() {
        return LoggedInHelper.isLoggedIn();
    }

    public void setCustomerAddress(Address[] addressArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(addressArr));
        setCustomerAddress((ArrayList<Address>) arrayList);
    }

    @NonNull
    public ArrayList<Address> getCustomerAddress(@NonNull Country country) {
        ArrayList<Address> arrayList = new ArrayList<>();
        ArrayList<Address> arrayList2 = this.customerAddress;
        if (arrayList2 != null) {
            Iterator<Address> it = arrayList2.iterator();
            while (it.hasNext()) {
                Address next = it.next();
                if (next.countyId == country.getCountryId()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void setSelectedCustomerAddress(Context context, String str, int i11) {
        setSelectedCustomerAddress(str, i11);
        saveSelectedProfile(context, str);
    }

    public ArrayList<Address> getCustomerAddress(int i11) {
        ArrayList<Address> arrayList = new ArrayList<>();
        Iterator<Address> it = this.customerAddress.iterator();
        while (it.hasNext()) {
            Address next = it.next();
            if (next.areaId == i11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public ArrayList<Address> getCustomerAddress(boolean z11) {
        ArrayList<Address> arrayList = new ArrayList<>();
        Iterator<Address> it = this.customerAddress.iterator();
        while (it.hasNext()) {
            Address next = it.next();
            if (next.cityId == GlobalDataModel.SelectedCityId) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
