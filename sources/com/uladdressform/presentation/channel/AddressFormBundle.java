package com.uladdressform.presentation.channel;

import android.os.Parcel;
import android.os.Parcelable;
import com.adyen.checkout.core.model.Address;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.homescreen.network.UrlConstantsKt;
import java.util.Map;
import junit.runner.BaseTestRunner;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\bD\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 g2\u00020\u0001:\u0001gBµ\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0005¢\u0006\u0002\u0010!J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0013HÆ\u0003J\t\u0010E\u001a\u00020\u0013HÆ\u0003J\t\u0010F\u001a\u00020\u0013HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0018HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0018HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¹\u0002\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010 \u001a\u00020\u0005HÆ\u0001J\t\u0010Z\u001a\u00020\u0005HÖ\u0001J\u0013\u0010[\u001a\u00020\u00132\b\u0010\\\u001a\u0004\u0018\u00010]HÖ\u0003J\t\u0010^\u001a\u00020\u0005HÖ\u0001J\u0006\u0010_\u001a\u00020`J\t\u0010a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u00102R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u00102R\u0011\u0010\u0015\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u00102R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#¨\u0006h"}, d2 = {"Lcom/uladdressform/presentation/channel/AddressFormBundle;", "Landroid/os/Parcelable;", "id", "", "areaId", "", "areaName", "block", "buildingNo", "cityId", "countyId", "countryName", "extraDirections", "floor", "geoAddressMsg", "geoAddressTitle", "grl", "grlid", "isAreaSplit", "", "isDeliverable", "isOldAddreses", "judda", "latitude", "", "longitude", "mobileNumber", "mobilNumberCountryCode", "phoneNumber", "profileName", "street", "suite", "type", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAreaId", "()I", "getAreaName", "()Ljava/lang/String;", "getBlock", "getBuildingNo", "getCityId", "getCountryName", "getCountyId", "getExtraDirections", "getFloor", "getGeoAddressMsg", "getGeoAddressTitle", "getGrl", "getGrlid", "getId", "()Z", "getJudda", "getLatitude", "()D", "getLongitude", "getMobilNumberCountryCode", "getMobileNumber", "getPhoneNumber", "getProfileName", "getStreet", "getSuite", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toAddress", "Lcom/talabat/domain/address/Address;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "com_talabat_feature_ul-address-form_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class AddressFormBundle implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<AddressFormBundle> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int areaId;
    @Nullable
    private final String areaName;
    @Nullable
    private final String block;
    @Nullable
    private final String buildingNo;
    private final int cityId;
    @Nullable
    private final String countryName;
    private final int countyId;
    @Nullable
    private final String extraDirections;
    @Nullable
    private final String floor;
    @Nullable
    private final String geoAddressMsg;
    @Nullable
    private final String geoAddressTitle;
    @Nullable
    private final String grl;
    @Nullable
    private final String grlid;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f12928id;
    private final boolean isAreaSplit;
    private final boolean isDeliverable;
    private final boolean isOldAddreses;
    @Nullable
    private final String judda;
    private final double latitude;
    private final double longitude;
    @Nullable
    private final String mobilNumberCountryCode;
    @Nullable
    private final String mobileNumber;
    @Nullable
    private final String phoneNumber;
    @Nullable
    private final String profileName;
    @Nullable
    private final String street;
    @Nullable
    private final String suite;
    private final int type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/uladdressform/presentation/channel/AddressFormBundle$Companion;", "", "()V", "fromFlutterMap", "Lcom/uladdressform/presentation/channel/AddressFormBundle;", "map", "", "", "com_talabat_feature_ul-address-form_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final AddressFormBundle fromFlutterMap(@NotNull Map<String, ? extends Object> map) {
            Map<String, ? extends Object> map2 = map;
            Intrinsics.checkNotNullParameter(map2, Param.MAP);
            String access$asString = ParcelableKt.asString(map2.get("area_name"));
            int access$asInt = ParcelableKt.asInt(map2.get("country"));
            String access$asString2 = ParcelableKt.asString(map2.get("grl_id"));
            double access$asDouble = ParcelableKt.asDouble(map2.get("latitude"));
            int access$asInt2 = ParcelableKt.asInt(map2.get("type"));
            int access$asInt3 = ParcelableKt.asInt(map2.get("area_id"));
            String access$asString3 = ParcelableKt.asString(map2.get("profile_name"));
            boolean access$asBoolean = ParcelableKt.asBoolean(map2.get("is_area_disabled"));
            String access$asString4 = ParcelableKt.asString(map2.get(Address.KEY_STREET));
            String access$asString5 = ParcelableKt.asString(map2.get("block"));
            String access$asString6 = ParcelableKt.asString(map2.get("id"));
            if (access$asString6 == null) {
                access$asString6 = "";
            }
            String str = access$asString6;
            String access$asString7 = ParcelableKt.asString(map2.get(LogWriteConstants.FLOOR));
            double access$asDouble2 = ParcelableKt.asDouble(map2.get("longitude"));
            String access$asString8 = ParcelableKt.asString(map2.get("grl"));
            boolean access$asBoolean2 = ParcelableKt.asBoolean(map2.get("is_old_addreses"));
            String access$asString9 = ParcelableKt.asString(map2.get("geo_address_title"));
            String access$asString10 = ParcelableKt.asString(map2.get("geo_address_msg"));
            String access$asString11 = ParcelableKt.asString(map2.get("building_no"));
            String access$asString12 = ParcelableKt.asString(map2.get(UrlConstantsKt.PATH_COUNTRY_CODE));
            String access$asString13 = ParcelableKt.asString(map2.get("extra_directions"));
            boolean access$asBoolean3 = ParcelableKt.asBoolean(map2.get("is_eligible_for_delivery"));
            String access$asString14 = ParcelableKt.asString(map2.get(UrlConstantsKt.PATH_COUNTRY_CODE));
            String access$asString15 = ParcelableKt.asString(map2.get(BaseTestRunner.SUITE_METHODNAME));
            String access$asString16 = ParcelableKt.asString(map2.get("judda"));
            String access$asString17 = ParcelableKt.asString(map2.get("phone_number"));
            return new AddressFormBundle(str, access$asInt3, access$asString, access$asString5, access$asString11, ParcelableKt.asInt(map2.get(ConstantsKt.ADJUST_CITY_ID)), access$asInt, access$asString14, access$asString13, access$asString7, access$asString10, access$asString9, access$asString8, access$asString2, access$asBoolean, access$asBoolean3, access$asBoolean2, access$asString16, access$asDouble, access$asDouble2, ParcelableKt.asString(map2.get(AppTracker.LOGIN_TYPE_MOBILE_STRING)), access$asString12, access$asString17, access$asString3, access$asString4, access$asString15, access$asInt2);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AddressFormBundle> {
        @NotNull
        public final AddressFormBundle createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AddressFormBundle(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @NotNull
        public final AddressFormBundle[] newArray(int i11) {
            return new AddressFormBundle[i11];
        }
    }

    public AddressFormBundle() {
        this((String) null, 0, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, false, false, (String) null, 0.0d, 0.0d, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 134217727, (DefaultConstructorMarker) null);
    }

    public AddressFormBundle(@NotNull String str, int i11, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i12, int i13, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, boolean z11, boolean z12, boolean z13, @Nullable String str12, double d11, double d12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable String str18, int i14) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.f12928id = str;
        this.areaId = i11;
        this.areaName = str2;
        this.block = str3;
        this.buildingNo = str4;
        this.cityId = i12;
        this.countyId = i13;
        this.countryName = str5;
        this.extraDirections = str6;
        this.floor = str7;
        this.geoAddressMsg = str8;
        this.geoAddressTitle = str9;
        this.grl = str10;
        this.grlid = str11;
        this.isAreaSplit = z11;
        this.isDeliverable = z12;
        this.isOldAddreses = z13;
        this.judda = str12;
        this.latitude = d11;
        this.longitude = d12;
        this.mobileNumber = str13;
        this.mobilNumberCountryCode = str14;
        this.phoneNumber = str15;
        this.profileName = str16;
        this.street = str17;
        this.suite = str18;
        this.type = i14;
    }

    public static /* synthetic */ AddressFormBundle copy$default(AddressFormBundle addressFormBundle, String str, int i11, String str2, String str3, String str4, int i12, int i13, String str5, String str6, String str7, String str8, String str9, String str10, String str11, boolean z11, boolean z12, boolean z13, String str12, double d11, double d12, String str13, String str14, String str15, String str16, String str17, String str18, int i14, int i15, Object obj) {
        AddressFormBundle addressFormBundle2 = addressFormBundle;
        int i16 = i15;
        return addressFormBundle.copy((i16 & 1) != 0 ? addressFormBundle2.f12928id : str, (i16 & 2) != 0 ? addressFormBundle2.areaId : i11, (i16 & 4) != 0 ? addressFormBundle2.areaName : str2, (i16 & 8) != 0 ? addressFormBundle2.block : str3, (i16 & 16) != 0 ? addressFormBundle2.buildingNo : str4, (i16 & 32) != 0 ? addressFormBundle2.cityId : i12, (i16 & 64) != 0 ? addressFormBundle2.countyId : i13, (i16 & 128) != 0 ? addressFormBundle2.countryName : str5, (i16 & 256) != 0 ? addressFormBundle2.extraDirections : str6, (i16 & 512) != 0 ? addressFormBundle2.floor : str7, (i16 & 1024) != 0 ? addressFormBundle2.geoAddressMsg : str8, (i16 & 2048) != 0 ? addressFormBundle2.geoAddressTitle : str9, (i16 & 4096) != 0 ? addressFormBundle2.grl : str10, (i16 & 8192) != 0 ? addressFormBundle2.grlid : str11, (i16 & 16384) != 0 ? addressFormBundle2.isAreaSplit : z11, (i16 & 32768) != 0 ? addressFormBundle2.isDeliverable : z12, (i16 & 65536) != 0 ? addressFormBundle2.isOldAddreses : z13, (i16 & 131072) != 0 ? addressFormBundle2.judda : str12, (i16 & 262144) != 0 ? addressFormBundle2.latitude : d11, (i16 & 524288) != 0 ? addressFormBundle2.longitude : d12, (i16 & 1048576) != 0 ? addressFormBundle2.mobileNumber : str13, (2097152 & i16) != 0 ? addressFormBundle2.mobilNumberCountryCode : str14, (i16 & 4194304) != 0 ? addressFormBundle2.phoneNumber : str15, (i16 & 8388608) != 0 ? addressFormBundle2.profileName : str16, (i16 & 16777216) != 0 ? addressFormBundle2.street : str17, (i16 & 33554432) != 0 ? addressFormBundle2.suite : str18, (i16 & 67108864) != 0 ? addressFormBundle2.type : i14);
    }

    @JvmStatic
    @NotNull
    public static final AddressFormBundle fromFlutterMap(@NotNull Map<String, ? extends Object> map) {
        return Companion.fromFlutterMap(map);
    }

    @NotNull
    public final String component1() {
        return this.f12928id;
    }

    @Nullable
    public final String component10() {
        return this.floor;
    }

    @Nullable
    public final String component11() {
        return this.geoAddressMsg;
    }

    @Nullable
    public final String component12() {
        return this.geoAddressTitle;
    }

    @Nullable
    public final String component13() {
        return this.grl;
    }

    @Nullable
    public final String component14() {
        return this.grlid;
    }

    public final boolean component15() {
        return this.isAreaSplit;
    }

    public final boolean component16() {
        return this.isDeliverable;
    }

    public final boolean component17() {
        return this.isOldAddreses;
    }

    @Nullable
    public final String component18() {
        return this.judda;
    }

    public final double component19() {
        return this.latitude;
    }

    public final int component2() {
        return this.areaId;
    }

    public final double component20() {
        return this.longitude;
    }

    @Nullable
    public final String component21() {
        return this.mobileNumber;
    }

    @Nullable
    public final String component22() {
        return this.mobilNumberCountryCode;
    }

    @Nullable
    public final String component23() {
        return this.phoneNumber;
    }

    @Nullable
    public final String component24() {
        return this.profileName;
    }

    @Nullable
    public final String component25() {
        return this.street;
    }

    @Nullable
    public final String component26() {
        return this.suite;
    }

    public final int component27() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.areaName;
    }

    @Nullable
    public final String component4() {
        return this.block;
    }

    @Nullable
    public final String component5() {
        return this.buildingNo;
    }

    public final int component6() {
        return this.cityId;
    }

    public final int component7() {
        return this.countyId;
    }

    @Nullable
    public final String component8() {
        return this.countryName;
    }

    @Nullable
    public final String component9() {
        return this.extraDirections;
    }

    @NotNull
    public final AddressFormBundle copy(@NotNull String str, int i11, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i12, int i13, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, boolean z11, boolean z12, boolean z13, @Nullable String str12, double d11, double d12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable String str18, int i14) {
        String str19 = str;
        String str20 = str19;
        Intrinsics.checkNotNullParameter(str19, "id");
        return new AddressFormBundle(str19, i11, str2, str3, str4, i12, i13, str5, str6, str7, str8, str9, str10, str11, z11, z12, z13, str12, d11, d12, str13, str14, str15, str16, str17, str18, i14);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressFormBundle)) {
            return false;
        }
        AddressFormBundle addressFormBundle = (AddressFormBundle) obj;
        return Intrinsics.areEqual((Object) this.f12928id, (Object) addressFormBundle.f12928id) && this.areaId == addressFormBundle.areaId && Intrinsics.areEqual((Object) this.areaName, (Object) addressFormBundle.areaName) && Intrinsics.areEqual((Object) this.block, (Object) addressFormBundle.block) && Intrinsics.areEqual((Object) this.buildingNo, (Object) addressFormBundle.buildingNo) && this.cityId == addressFormBundle.cityId && this.countyId == addressFormBundle.countyId && Intrinsics.areEqual((Object) this.countryName, (Object) addressFormBundle.countryName) && Intrinsics.areEqual((Object) this.extraDirections, (Object) addressFormBundle.extraDirections) && Intrinsics.areEqual((Object) this.floor, (Object) addressFormBundle.floor) && Intrinsics.areEqual((Object) this.geoAddressMsg, (Object) addressFormBundle.geoAddressMsg) && Intrinsics.areEqual((Object) this.geoAddressTitle, (Object) addressFormBundle.geoAddressTitle) && Intrinsics.areEqual((Object) this.grl, (Object) addressFormBundle.grl) && Intrinsics.areEqual((Object) this.grlid, (Object) addressFormBundle.grlid) && this.isAreaSplit == addressFormBundle.isAreaSplit && this.isDeliverable == addressFormBundle.isDeliverable && this.isOldAddreses == addressFormBundle.isOldAddreses && Intrinsics.areEqual((Object) this.judda, (Object) addressFormBundle.judda) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(addressFormBundle.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(addressFormBundle.longitude)) && Intrinsics.areEqual((Object) this.mobileNumber, (Object) addressFormBundle.mobileNumber) && Intrinsics.areEqual((Object) this.mobilNumberCountryCode, (Object) addressFormBundle.mobilNumberCountryCode) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) addressFormBundle.phoneNumber) && Intrinsics.areEqual((Object) this.profileName, (Object) addressFormBundle.profileName) && Intrinsics.areEqual((Object) this.street, (Object) addressFormBundle.street) && Intrinsics.areEqual((Object) this.suite, (Object) addressFormBundle.suite) && this.type == addressFormBundle.type;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    @Nullable
    public final String getAreaName() {
        return this.areaName;
    }

    @Nullable
    public final String getBlock() {
        return this.block;
    }

    @Nullable
    public final String getBuildingNo() {
        return this.buildingNo;
    }

    public final int getCityId() {
        return this.cityId;
    }

    @Nullable
    public final String getCountryName() {
        return this.countryName;
    }

    public final int getCountyId() {
        return this.countyId;
    }

    @Nullable
    public final String getExtraDirections() {
        return this.extraDirections;
    }

    @Nullable
    public final String getFloor() {
        return this.floor;
    }

    @Nullable
    public final String getGeoAddressMsg() {
        return this.geoAddressMsg;
    }

    @Nullable
    public final String getGeoAddressTitle() {
        return this.geoAddressTitle;
    }

    @Nullable
    public final String getGrl() {
        return this.grl;
    }

    @Nullable
    public final String getGrlid() {
        return this.grlid;
    }

    @NotNull
    public final String getId() {
        return this.f12928id;
    }

    @Nullable
    public final String getJudda() {
        return this.judda;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @Nullable
    public final String getMobilNumberCountryCode() {
        return this.mobilNumberCountryCode;
    }

    @Nullable
    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Nullable
    public final String getProfileName() {
        return this.profileName;
    }

    @Nullable
    public final String getStreet() {
        return this.street;
    }

    @Nullable
    public final String getSuite() {
        return this.suite;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((this.f12928id.hashCode() * 31) + this.areaId) * 31;
        String str = this.areaName;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.block;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.buildingNo;
        int hashCode4 = (((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.cityId) * 31) + this.countyId) * 31;
        String str4 = this.countryName;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.extraDirections;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.floor;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.geoAddressMsg;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.geoAddressTitle;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.grl;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.grlid;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        boolean z11 = this.isAreaSplit;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode11 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isDeliverable;
        if (z13) {
            z13 = true;
        }
        int i13 = (i12 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isOldAddreses;
        if (!z14) {
            z12 = z14;
        }
        int i14 = (i13 + (z12 ? 1 : 0)) * 31;
        String str11 = this.judda;
        int hashCode12 = (((((i14 + (str11 == null ? 0 : str11.hashCode())) * 31) + Double.doubleToLongBits(this.latitude)) * 31) + Double.doubleToLongBits(this.longitude)) * 31;
        String str12 = this.mobileNumber;
        int hashCode13 = (hashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.mobilNumberCountryCode;
        int hashCode14 = (hashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.phoneNumber;
        int hashCode15 = (hashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.profileName;
        int hashCode16 = (hashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.street;
        int hashCode17 = (hashCode16 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.suite;
        if (str17 != null) {
            i11 = str17.hashCode();
        }
        return ((hashCode17 + i11) * 31) + this.type;
    }

    public final boolean isAreaSplit() {
        return this.isAreaSplit;
    }

    public final boolean isDeliverable() {
        return this.isDeliverable;
    }

    public final boolean isOldAddreses() {
        return this.isOldAddreses;
    }

    @NotNull
    public final com.talabat.domain.address.Address toAddress() {
        return new com.talabat.domain.address.Address(this.f12928id, this.areaId, this.areaName, this.block, this.buildingNo, this.cityId, this.countyId, this.countryName, this.extraDirections, this.floor, this.geoAddressMsg, this.geoAddressTitle, this.grl, this.grlid, this.isAreaSplit, this.isDeliverable, this.isOldAddreses, this.judda, this.latitude, this.longitude, this.mobileNumber, this.mobilNumberCountryCode, this.phoneNumber, this.profileName, this.street, this.suite, this.type);
    }

    @NotNull
    public String toString() {
        String str = this.f12928id;
        int i11 = this.areaId;
        String str2 = this.areaName;
        String str3 = this.block;
        String str4 = this.buildingNo;
        int i12 = this.cityId;
        int i13 = this.countyId;
        String str5 = this.countryName;
        String str6 = this.extraDirections;
        String str7 = this.floor;
        String str8 = this.geoAddressMsg;
        String str9 = this.geoAddressTitle;
        String str10 = this.grl;
        String str11 = this.grlid;
        boolean z11 = this.isAreaSplit;
        boolean z12 = this.isDeliverable;
        boolean z13 = this.isOldAddreses;
        String str12 = str11;
        String str13 = this.judda;
        double d11 = this.latitude;
        double d12 = this.longitude;
        String str14 = this.mobileNumber;
        String str15 = this.mobilNumberCountryCode;
        String str16 = this.phoneNumber;
        String str17 = this.profileName;
        String str18 = this.street;
        String str19 = this.suite;
        int i14 = this.type;
        return "AddressFormBundle(id=" + str + ", areaId=" + i11 + ", areaName=" + str2 + ", block=" + str3 + ", buildingNo=" + str4 + ", cityId=" + i12 + ", countyId=" + i13 + ", countryName=" + str5 + ", extraDirections=" + str6 + ", floor=" + str7 + ", geoAddressMsg=" + str8 + ", geoAddressTitle=" + str9 + ", grl=" + str10 + ", grlid=" + str12 + ", isAreaSplit=" + z11 + ", isDeliverable=" + z12 + ", isOldAddreses=" + z13 + ", judda=" + str13 + ", latitude=" + d11 + ", longitude=" + d12 + ", mobileNumber=" + str14 + ", mobilNumberCountryCode=" + str15 + ", phoneNumber=" + str16 + ", profileName=" + str17 + ", street=" + str18 + ", suite=" + str19 + ", type=" + i14 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f12928id);
        parcel.writeInt(this.areaId);
        parcel.writeString(this.areaName);
        parcel.writeString(this.block);
        parcel.writeString(this.buildingNo);
        parcel.writeInt(this.cityId);
        parcel.writeInt(this.countyId);
        parcel.writeString(this.countryName);
        parcel.writeString(this.extraDirections);
        parcel.writeString(this.floor);
        parcel.writeString(this.geoAddressMsg);
        parcel.writeString(this.geoAddressTitle);
        parcel.writeString(this.grl);
        parcel.writeString(this.grlid);
        parcel.writeInt(this.isAreaSplit ? 1 : 0);
        parcel.writeInt(this.isDeliverable ? 1 : 0);
        parcel.writeInt(this.isOldAddreses ? 1 : 0);
        parcel.writeString(this.judda);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.mobileNumber);
        parcel.writeString(this.mobilNumberCountryCode);
        parcel.writeString(this.phoneNumber);
        parcel.writeString(this.profileName);
        parcel.writeString(this.street);
        parcel.writeString(this.suite);
        parcel.writeInt(this.type);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AddressFormBundle(java.lang.String r31, int r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, int r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, boolean r45, boolean r46, boolean r47, java.lang.String r48, double r49, double r51, java.lang.String r53, java.lang.String r54, java.lang.String r55, java.lang.String r56, java.lang.String r57, java.lang.String r58, int r59, int r60, kotlin.jvm.internal.DefaultConstructorMarker r61) {
        /*
            r30 = this;
            r0 = r60
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = ""
            goto L_0x000b
        L_0x0009:
            r1 = r31
        L_0x000b:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0011
            r2 = 0
            goto L_0x0013
        L_0x0011:
            r2 = r32
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = 0
            goto L_0x001b
        L_0x0019:
            r4 = r33
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = 0
            goto L_0x0023
        L_0x0021:
            r6 = r34
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            r7 = 0
            goto L_0x002b
        L_0x0029:
            r7 = r35
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = 0
            goto L_0x0033
        L_0x0031:
            r8 = r36
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = 0
            goto L_0x003b
        L_0x0039:
            r9 = r37
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = 0
            goto L_0x0043
        L_0x0041:
            r10 = r38
        L_0x0043:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0049
            r11 = 0
            goto L_0x004b
        L_0x0049:
            r11 = r39
        L_0x004b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0051
            r12 = 0
            goto L_0x0053
        L_0x0051:
            r12 = r40
        L_0x0053:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0059
            r13 = 0
            goto L_0x005b
        L_0x0059:
            r13 = r41
        L_0x005b:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0061
            r14 = 0
            goto L_0x0063
        L_0x0061:
            r14 = r42
        L_0x0063:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0069
            r15 = 0
            goto L_0x006b
        L_0x0069:
            r15 = r43
        L_0x006b:
            r3 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x0071
            r3 = 0
            goto L_0x0073
        L_0x0071:
            r3 = r44
        L_0x0073:
            r5 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x0079
            r5 = 0
            goto L_0x007b
        L_0x0079:
            r5 = r45
        L_0x007b:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0085
            r16 = 0
            goto L_0x0087
        L_0x0085:
            r16 = r46
        L_0x0087:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0090
            r17 = 0
            goto L_0x0092
        L_0x0090:
            r17 = r47
        L_0x0092:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009b
            r18 = 0
            goto L_0x009d
        L_0x009b:
            r18 = r48
        L_0x009d:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            r20 = 0
            if (r19 == 0) goto L_0x00a8
            r22 = r20
            goto L_0x00aa
        L_0x00a8:
            r22 = r49
        L_0x00aa:
            r19 = 524288(0x80000, float:7.34684E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00b1
            goto L_0x00b3
        L_0x00b1:
            r20 = r51
        L_0x00b3:
            r19 = 1048576(0x100000, float:1.469368E-39)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00bc
            r19 = 0
            goto L_0x00be
        L_0x00bc:
            r19 = r53
        L_0x00be:
            r24 = 2097152(0x200000, float:2.938736E-39)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c7
            r24 = 0
            goto L_0x00c9
        L_0x00c7:
            r24 = r54
        L_0x00c9:
            r25 = 4194304(0x400000, float:5.877472E-39)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00d2
            r25 = 0
            goto L_0x00d4
        L_0x00d2:
            r25 = r55
        L_0x00d4:
            r26 = 8388608(0x800000, float:1.17549435E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00dd
            r26 = 0
            goto L_0x00df
        L_0x00dd:
            r26 = r56
        L_0x00df:
            r27 = 16777216(0x1000000, float:2.3509887E-38)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00e8
            r27 = 0
            goto L_0x00ea
        L_0x00e8:
            r27 = r57
        L_0x00ea:
            r28 = 33554432(0x2000000, float:9.403955E-38)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x00f3
            r28 = 0
            goto L_0x00f5
        L_0x00f3:
            r28 = r58
        L_0x00f5:
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            r0 = r0 & r29
            if (r0 == 0) goto L_0x00fd
            r0 = 0
            goto L_0x00ff
        L_0x00fd:
            r0 = r59
        L_0x00ff:
            r31 = r30
            r32 = r1
            r33 = r2
            r34 = r4
            r35 = r6
            r36 = r7
            r37 = r8
            r38 = r9
            r39 = r10
            r40 = r11
            r41 = r12
            r42 = r13
            r43 = r14
            r44 = r15
            r45 = r3
            r46 = r5
            r47 = r16
            r48 = r17
            r49 = r18
            r50 = r22
            r52 = r20
            r54 = r19
            r55 = r24
            r56 = r25
            r57 = r26
            r58 = r27
            r59 = r28
            r60 = r0
            r31.<init>(r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r52, r54, r55, r56, r57, r58, r59, r60)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uladdressform.presentation.channel.AddressFormBundle.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, java.lang.String, double, double, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
