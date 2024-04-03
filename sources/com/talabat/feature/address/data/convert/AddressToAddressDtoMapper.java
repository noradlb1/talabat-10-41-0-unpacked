package com.talabat.feature.address.data.convert;

import com.talabat.domain.address.Address;
import com.talabat.feature.address.data.AddressDto;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/address/data/convert/AddressToAddressDtoMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/domain/address/Address;", "Lcom/talabat/feature/address/data/AddressDto;", "()V", "apply", "from", "parseGrlId", "", "grl", "JsonModelAddAddressResult", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressToAddressDtoMapper implements ModelMapper<Address, AddressDto> {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/address/data/convert/AddressToAddressDtoMapper$JsonModelAddAddressResult;", "", "itemId", "", "item", "", "(ILjava/lang/String;)V", "getItem", "()Ljava/lang/String;", "getItemId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class JsonModelAddAddressResult {
        @NotNull
        private final String item;
        private final int itemId;

        public JsonModelAddAddressResult(int i11, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "item");
            this.itemId = i11;
            this.item = str;
        }

        public static /* synthetic */ JsonModelAddAddressResult copy$default(JsonModelAddAddressResult jsonModelAddAddressResult, int i11, String str, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = jsonModelAddAddressResult.itemId;
            }
            if ((i12 & 2) != 0) {
                str = jsonModelAddAddressResult.item;
            }
            return jsonModelAddAddressResult.copy(i11, str);
        }

        public final int component1() {
            return this.itemId;
        }

        @NotNull
        public final String component2() {
            return this.item;
        }

        @NotNull
        public final JsonModelAddAddressResult copy(int i11, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "item");
            return new JsonModelAddAddressResult(i11, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof JsonModelAddAddressResult)) {
                return false;
            }
            JsonModelAddAddressResult jsonModelAddAddressResult = (JsonModelAddAddressResult) obj;
            return this.itemId == jsonModelAddAddressResult.itemId && Intrinsics.areEqual((Object) this.item, (Object) jsonModelAddAddressResult.item);
        }

        @NotNull
        public final String getItem() {
            return this.item;
        }

        public final int getItemId() {
            return this.itemId;
        }

        public int hashCode() {
            return (this.itemId * 31) + this.item.hashCode();
        }

        @NotNull
        public String toString() {
            int i11 = this.itemId;
            String str = this.item;
            return "JsonModelAddAddressResult(itemId=" + i11 + ", item=" + str + ")";
        }
    }

    private final String parseGrlId(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("AddressElements");
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                int i12 = jSONObject.getInt("AddressElementTypeCode");
                String string = jSONObject.getString("Value");
                Intrinsics.checkNotNullExpressionValue(string, "addressElement.getString(\"Value\")");
                arrayList.add(i11, new JsonModelAddAddressResult(i12, string));
            }
            return ((JsonModelAddAddressResult) arrayList.get(4)).getItem();
        } catch (Exception unused) {
            return str;
        }
    }

    @NotNull
    public AddressDto apply(@NotNull Address address) {
        AddressToAddressDtoMapper addressToAddressDtoMapper;
        String str;
        Address address2 = address;
        Intrinsics.checkNotNullParameter(address2, "from");
        String str2 = address2.f58343id;
        int i11 = address2.areaId;
        String str3 = address2.areaName;
        String str4 = address2.block;
        String str5 = address2.buildingNo;
        int i12 = address2.cityId;
        int i13 = address2.countyId;
        String str6 = address2.extraDirections;
        String str7 = address2.floor;
        String str8 = address2.geoAddressMsg;
        String str9 = address2.geoAddressTitle;
        String str10 = address2.grl;
        String str11 = address2.grlid;
        if (str11 == null) {
            if (str10 == null) {
                str = "";
                addressToAddressDtoMapper = this;
            } else {
                addressToAddressDtoMapper = this;
                str = str10;
            }
            str11 = addressToAddressDtoMapper.parseGrlId(str);
        }
        return new AddressDto(str2, i11, str3, str4, str5, i12, (String) null, i13, str6, str7, str8, str9, str10, str11, address2.isAreaSplit, address2.isDeliverable, address2.isOldAddreses, address2.judda, address2.latitude, address2.longitude, address2.mobileNumber, address2.mobilNumberCountryCode, address2.phoneNumber, address2.profileName, address2.street, address2.suite, address2.type, 64, (DefaultConstructorMarker) null);
    }
}
