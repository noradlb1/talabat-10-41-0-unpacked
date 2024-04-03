package datamodels;

import com.google.gson.annotations.SerializedName;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.Nullable;

public class CustomerInfo {
    private static final String INNER_EMAIL_SUFFIX = "@talabat.com";
    public String birthday;
    public String email;
    public String encgid = "";
    public String firstName;
    private boolean gender = true;

    /* renamed from: id  reason: collision with root package name */
    public int f13850id;
    private boolean isANewCustomer;
    @Deprecated
    public boolean isTproUser = false;
    public String lastName;
    public LastOrdersDetails[] lastOrdersDetails;
    public float minimOrderValueToEnableTproDiscount = 0.0f;
    public String mobile;
    @SerializedName("mobileNumber")
    @Nullable
    public String mobileNumber;
    @SerializedName("registrationType")
    public RegistrationType registrationType = RegistrationType.UNDEFINED;
    public boolean subscribedToNewsletter;
    public boolean subscribedToSMS;
    public List<Subscription> subscriptionsList;
    @Nullable
    @Deprecated
    public Subscription tProSubscriptionInfo;
    public boolean talabatCcIncomplete;
    public float talabatCredit;
    public String talabatPayStatus;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CustomerInfo customerInfo = (CustomerInfo) obj;
        if (this.gender != customerInfo.gender || this.f13850id != customerInfo.f13850id || this.subscribedToNewsletter != customerInfo.subscribedToNewsletter || this.subscribedToSMS != customerInfo.subscribedToSMS || this.registrationType != customerInfo.registrationType) {
            return false;
        }
        String str = this.mobileNumber;
        if ((str != null && !str.equals(customerInfo.mobileNumber)) || Float.compare(customerInfo.talabatCredit, this.talabatCredit) != 0) {
            return false;
        }
        String str2 = this.firstName;
        if (str2 == null ? customerInfo.firstName != null : !str2.equals(customerInfo.firstName)) {
            return false;
        }
        String str3 = this.lastName;
        if (str3 == null ? customerInfo.lastName != null : !str3.equals(customerInfo.lastName)) {
            return false;
        }
        String str4 = this.mobile;
        if (str4 == null ? customerInfo.mobile != null : !str4.equals(customerInfo.mobile)) {
            return false;
        }
        String str5 = this.birthday;
        if (str5 == null ? customerInfo.birthday != null : !str5.equals(customerInfo.birthday)) {
            return false;
        }
        String str6 = this.email;
        if (str6 == null ? customerInfo.email != null : !str6.equals(customerInfo.email)) {
            return false;
        }
        String str7 = this.encgid;
        if (str7 == null ? customerInfo.encgid != null : !str7.equals(customerInfo.encgid)) {
            return false;
        }
        if (this.isANewCustomer != customerInfo.isANewCustomer) {
            return false;
        }
        return Arrays.equals(this.lastOrdersDetails, customerInfo.lastOrdersDetails);
    }

    public String getFistName() {
        return this.firstName;
    }

    public String getGender() {
        return this.gender ? "male" : "female";
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public Subscription getTProSubscriptionInfo() {
        return this.tProSubscriptionInfo;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        String str = this.firstName;
        int i18 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i19 = i11 * 31;
        String str2 = this.lastName;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i21 = (i19 + i12) * 31;
        String str3 = this.mobile;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i22 = (((((i21 + i13) * 31) + (this.gender ? 1 : 0)) * 31) + this.f13850id) * 31;
        String str4 = this.birthday;
        if (str4 != null) {
            i14 = str4.hashCode();
        } else {
            i14 = 0;
        }
        int i23 = (i22 + i14) * 31;
        String str5 = this.email;
        if (str5 != null) {
            i15 = str5.hashCode();
        } else {
            i15 = 0;
        }
        int hashCode = (((i23 + i15) * 31) + this.registrationType.hashCode()) * 31;
        String str6 = this.mobileNumber;
        if (str6 != null) {
            i16 = str6.hashCode();
        } else {
            i16 = 0;
        }
        int i24 = (((((hashCode + i16) * 31) + (this.subscribedToNewsletter ? 1 : 0)) * 31) + (this.subscribedToSMS ? 1 : 0)) * 31;
        float f11 = this.talabatCredit;
        if (f11 != 0.0f) {
            i17 = Float.floatToIntBits(f11);
        } else {
            i17 = 0;
        }
        int i25 = (i24 + i17) * 31;
        String str7 = this.encgid;
        if (str7 != null) {
            i18 = str7.hashCode();
        }
        return ((((i25 + i18) * 31) + (this.isANewCustomer ? 1 : 0)) * 31) + Arrays.hashCode(this.lastOrdersDetails);
    }

    public boolean isANewCustomer() {
        return this.isANewCustomer;
    }

    public boolean isTalabatEmail() {
        String str = this.email;
        return str != null && str.endsWith(INNER_EMAIL_SUFFIX);
    }

    @Deprecated
    public boolean isTproUser() {
        Subscription subscription = this.tProSubscriptionInfo;
        if (subscription == null) {
            return false;
        }
        return subscription.isActive();
    }

    public void setGender(boolean z11) {
        this.gender = z11;
    }

    public void setIsANewCustomer(boolean z11) {
        this.isANewCustomer = z11;
    }

    public void setTalabatCredit(float f11) {
        this.talabatCredit = f11;
    }

    public String toString() {
        return "CustomerInfo{firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", mobile='" + this.mobile + '\'' + ", gender=" + this.gender + ", id=" + this.f13850id + ", birthday='" + this.birthday + '\'' + ", email='" + this.email + '\'' + ", registrationType='" + this.registrationType.name() + '\'' + ", registrationType='" + this.mobileNumber + '\'' + ", subscribedToNewsletter=" + this.subscribedToNewsletter + ", newCustomer=" + this.isANewCustomer + ", subscribedToSMS=" + this.subscribedToSMS + ", talabatCredit=" + this.talabatCredit + ", encgid='" + this.encgid + '\'' + ", lastOrdersDetails=" + Arrays.toString(this.lastOrdersDetails) + AbstractJsonLexerKt.END_OBJ;
    }
}
