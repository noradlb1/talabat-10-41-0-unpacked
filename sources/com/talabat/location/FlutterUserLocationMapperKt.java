package com.talabat.location;

import androidx.autofill.HintConstants;
import com.adyen.checkout.core.model.Address;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.talabat.location.UserLocation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"toFlutterMap", "", "", "", "Lcom/talabat/location/UserLocation;", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FlutterUserLocationMapperKt {
    @NotNull
    public static final Map<String, Object> toFlutterMap(@NotNull UserLocation userLocation) {
        Intrinsics.checkNotNullParameter(userLocation, "<this>");
        if (userLocation instanceof UserLocation.WithAddress) {
            Pair[] pairArr = new Pair[19];
            UserLocation.WithAddress withAddress = (UserLocation.WithAddress) userLocation;
            pairArr[0] = TuplesKt.to("id", withAddress.getAddress().f58343id);
            String str = withAddress.getAddress().profileName;
            String str2 = "";
            if (str == null && (str = withAddress.getAddress().geoAddressTitle) == null) {
                str = str2;
            }
            pairArr[1] = TuplesKt.to("title", str);
            String str3 = withAddress.getAddress().block;
            if (str3 == null) {
                str3 = str2;
            }
            pairArr[2] = TuplesKt.to("buildingName", str3);
            pairArr[3] = TuplesKt.to("areaId", Integer.valueOf(withAddress.getAddress().areaId));
            String str4 = withAddress.getAddress().areaName;
            if (str4 == null) {
                str4 = str2;
            }
            pairArr[4] = TuplesKt.to("areaName", str4);
            pairArr[5] = TuplesKt.to("type", Integer.valueOf(withAddress.getAddress().type));
            String str5 = withAddress.getAddress().block;
            if (str5 == null) {
                str5 = str2;
            }
            pairArr[6] = TuplesKt.to("block", str5);
            String str6 = withAddress.getAddress().judda;
            if (str6 == null) {
                str6 = str2;
            }
            pairArr[7] = TuplesKt.to("judda", str6);
            String str7 = withAddress.getAddress().street;
            if (str7 == null) {
                str7 = str2;
            }
            pairArr[8] = TuplesKt.to(Address.KEY_STREET, str7);
            String str8 = withAddress.getAddress().buildingNo;
            if (str8 == null) {
                str8 = str2;
            }
            pairArr[9] = TuplesKt.to("buildingNumber", str8);
            String str9 = withAddress.getAddress().floor;
            if (str9 == null) {
                str9 = str2;
            }
            pairArr[10] = TuplesKt.to(LogWriteConstants.FLOOR, str9);
            String str10 = withAddress.getAddress().extraDirections;
            if (str10 == null) {
                str10 = str2;
            }
            pairArr[11] = TuplesKt.to("extraDirections", str10);
            String str11 = withAddress.getAddress().phoneNumber;
            if (str11 == null) {
                str11 = str2;
            }
            pairArr[12] = TuplesKt.to(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, str11);
            String str12 = withAddress.getAddress().mobileNumber;
            if (str12 == null) {
                str12 = str2;
            }
            pairArr[13] = TuplesKt.to("mobileNumber", str12);
            String str13 = withAddress.getAddress().mobilNumberCountryCode;
            if (str13 != null) {
                str2 = str13;
            }
            pairArr[14] = TuplesKt.to("countryCode", str2);
            pairArr[15] = TuplesKt.to("latitude", Double.valueOf(withAddress.getAddress().latitude));
            pairArr[16] = TuplesKt.to("longitude", Double.valueOf(withAddress.getAddress().longitude));
            pairArr[17] = TuplesKt.to("countyId", Integer.valueOf(withAddress.getAddress().countyId));
            pairArr[18] = TuplesKt.to("cityId", Integer.valueOf(withAddress.getAddress().cityId));
            return MapsKt__MapsKt.mapOf(pairArr);
        } else if (userLocation instanceof UserLocation.WithoutAddress) {
            UserLocation.WithoutAddress withoutAddress = (UserLocation.WithoutAddress) userLocation;
            return MapsKt__MapsKt.mapOf(TuplesKt.to("areaId", Integer.valueOf(withoutAddress.getAreaId())), TuplesKt.to("areaName", withoutAddress.getAreaName()), TuplesKt.to("latitude", Double.valueOf(withoutAddress.getLatitude())), TuplesKt.to("longitude", Double.valueOf(withoutAddress.getLongitude())), TuplesKt.to("cityId", Integer.valueOf(withoutAddress.getCityId())));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
