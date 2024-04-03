package com.talabat.vendormenu.presentation.flutter.data;

import com.visa.checkout.Profile;
import datamodels.Restaurant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"toMap", "", "", "", "Ldatamodels/Restaurant;", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FlutterVendorKt {
    @NotNull
    public static final Map<String, Object> toMap(@NotNull Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(restaurant, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("id", Integer.valueOf(restaurant.f13872id)), TuplesKt.to("na", restaurant.f13873name), TuplesKt.to("stt", Integer.valueOf(restaurant.statusType)), TuplesKt.to("css", restaurant.getCuisineString()), TuplesKt.to("dls", restaurant.deliverySchedule), TuplesKt.to("avd", restaurant.deliveryTime), TuplesKt.to("mna", Float.valueOf(restaurant.minimumAmount)), TuplesKt.to("tch", Float.valueOf(restaurant.talabatCharges)), TuplesKt.to("atbt", restaurant.altDelChargetxt), TuplesKt.to("itg", Boolean.valueOf(restaurant.isTalabatGo)), TuplesKt.to("dch", Float.valueOf(restaurant.deliveryCharges)), TuplesKt.to("dct", Integer.valueOf(restaurant.getDeliveryChargestype())), TuplesKt.to("amt", restaurant.altMunicipalityText), TuplesKt.to("mtyp", Integer.valueOf(restaurant.MuncipalityChargestype)), TuplesKt.to("mcc", Float.valueOf(restaurant.municipalityTax)), TuplesKt.to("att", restaurant.altTouristTaxText), TuplesKt.to("ttyp", Integer.valueOf(restaurant.TouristChargetype)), TuplesKt.to("trc", Float.valueOf(restaurant.touristTax)), TuplesKt.to("hsp", Boolean.valueOf(restaurant.hasPreOrderOnClosed)), TuplesKt.to("adb", Boolean.valueOf(restaurant.acceptsDebit)), TuplesKt.to("acr", Boolean.valueOf(restaurant.acceptsCredit)), TuplesKt.to("ac", Boolean.valueOf(restaurant.acceptsCash)), TuplesKt.to(Profile.LOGO_URL, restaurant.logoUrl), TuplesKt.to("rat", Float.valueOf(restaurant.rating)), TuplesKt.to("trt", restaurant.totalRating), TuplesKt.to("isVatInc", Boolean.valueOf(restaurant.inclusiveVat)), TuplesKt.to("an", restaurant.areaName), TuplesKt.to("trts", restaurant.totalRatingNonformatted), TuplesKt.to("dtim", restaurant.deliveryTimeInteger), TuplesKt.to("dsir", Boolean.valueOf(restaurant.disableItemSpecialRequest)), TuplesKt.to("bid", Integer.valueOf(restaurant.branchId)), TuplesKt.to("bna", restaurant.branchName));
    }
}
