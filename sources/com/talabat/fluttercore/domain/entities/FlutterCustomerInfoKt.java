package com.talabat.fluttercore.domain.entities;

import buisnessmodels.Customer;
import datamodels.CustomerInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u001a\u0018\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003*\u00020\u0001¨\u0006\u0006"}, d2 = {"flutterCustomerInfoFromGlobalDataModel", "Lcom/talabat/fluttercore/domain/entities/FlutterCustomerInfo;", "toMap", "", "", "", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FlutterCustomerInfoKt {
    @Nullable
    public static final FlutterCustomerInfo flutterCustomerInfoFromGlobalDataModel() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        if (customerInfo == null) {
            return null;
        }
        int i11 = Customer.getInstance().getCustomerInfo().f13850id;
        String str7 = Customer.getInstance().getCustomerInfo().firstName;
        if (str7 == null) {
            str = "";
        } else {
            str = str7;
        }
        String str8 = Customer.getInstance().getCustomerInfo().lastName;
        if (str8 == null) {
            str2 = "";
        } else {
            str2 = str8;
        }
        String str9 = Customer.getInstance().getCustomerInfo().email;
        if (str9 == null) {
            str3 = "";
        } else {
            str3 = str9;
        }
        Boolean bool = Boolean.FALSE;
        Integer valueOf = Integer.valueOf(Customer.getInstance().getCustomerInfo().f13850id);
        String str10 = Customer.getInstance().getCustomerInfo().birthday;
        if (str10 == null) {
            str4 = "";
        } else {
            str4 = str10;
        }
        Double valueOf2 = Double.valueOf((double) Customer.getInstance().getCustomerInfo().talabatCredit);
        String valueOf3 = String.valueOf(Customer.getInstance().getCustomerInfo().f13850id);
        String str11 = Customer.getInstance().getCustomerInfo().encgid;
        if (str11 == null) {
            str5 = "";
        } else {
            str5 = str11;
        }
        boolean isPro = Customer.getInstance().isPro();
        float f11 = customerInfo.minimOrderValueToEnableTproDiscount;
        Integer valueOf4 = Integer.valueOf(customerInfo.registrationType.getValue());
        String gender = customerInfo.getGender();
        if (gender == null) {
            str6 = "";
        } else {
            str6 = gender;
        }
        return new FlutterCustomerInfo(i11, str, str2, str3, bool, "", "", valueOf, str4, (Integer) null, valueOf2, "", valueOf3, str5, isPro, f11, valueOf4, str6, customerInfo.subscribedToNewsletter, customerInfo.subscribedToSMS, customerInfo.mobileNumber);
    }

    @NotNull
    public static final Map<String, Object> toMap(@NotNull FlutterCustomerInfo flutterCustomerInfo) {
        Intrinsics.checkNotNullParameter(flutterCustomerInfo, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("id", Integer.valueOf(flutterCustomerInfo.getId())), TuplesKt.to("firstName", flutterCustomerInfo.getFirstName()), TuplesKt.to("lastName", flutterCustomerInfo.getLastName()), TuplesKt.to("email", flutterCustomerInfo.getEmail()), TuplesKt.to("blocked", flutterCustomerInfo.getBlocked()), TuplesKt.to("housePhone", flutterCustomerInfo.getHousePhone()), TuplesKt.to("workPhone", flutterCustomerInfo.getWorkPhone()), TuplesKt.to("tokenProvider", flutterCustomerInfo.getTokenProvider()), TuplesKt.to("birthDate", flutterCustomerInfo.getBirthDate()), TuplesKt.to("countryId", flutterCustomerInfo.getCountryId()), TuplesKt.to("talabatCredit", flutterCustomerInfo.getTalabatCredit()), TuplesKt.to("userName", flutterCustomerInfo.getUserName()), TuplesKt.to("userId", flutterCustomerInfo.getUserId()), TuplesKt.to("encgid", flutterCustomerInfo.getEncgid()), TuplesKt.to("isTpro", Boolean.valueOf(flutterCustomerInfo.isTproUser())), TuplesKt.to("tproMinimumOrderValue", Float.valueOf(flutterCustomerInfo.getMinimOrderValueToEnableTproDiscount())), TuplesKt.to("registrationType", flutterCustomerInfo.getRegistrationType()), TuplesKt.to("gender", flutterCustomerInfo.getGender()), TuplesKt.to("subscribedToNewsletter", Boolean.valueOf(flutterCustomerInfo.getSubscribedToNewsletter())), TuplesKt.to("subscribedToSMS", Boolean.valueOf(flutterCustomerInfo.getSubscribedToSMS())), TuplesKt.to("mobileNumber", flutterCustomerInfo.getMobileNumber()));
    }
}
