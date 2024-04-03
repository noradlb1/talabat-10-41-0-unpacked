package com.talabat.core.flutter.channels.impl.data.address;

import com.facebook.appevents.UserDataStore;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0003\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004J\u0016\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004¨\u0006\t"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/address/FlutterAddressMapper;", "", "()V", "map", "", "", "address", "Lcom/talabat/domain/address/Address;", "mapUnsavedAddress", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterAddressMapper {
    @NotNull
    public final Map<String, Object> map(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Map createMapBuilder = MapsKt__MapsJVMKt.createMapBuilder();
        createMapBuilder.put("eid", address.f58343id);
        createMapBuilder.put("aid", Integer.valueOf(address.areaId));
        createMapBuilder.put("an", address.areaName);
        createMapBuilder.put("cid", Integer.valueOf(address.cityId));
        createMapBuilder.put("cnm", GlobalDataModel.SelectedCityName);
        createMapBuilder.put("ltd", String.valueOf(address.latitude));
        createMapBuilder.put("lngt", String.valueOf(address.longitude));
        createMapBuilder.put(UserDataStore.STATE, address.street);
        createMapBuilder.put("jd", address.judda);
        createMapBuilder.put("bno", address.buildingNo);
        createMapBuilder.put("fl", address.floor);
        createMapBuilder.put("blk", address.block);
        createMapBuilder.put("exd", address.extraDirections);
        String str = address.profileName;
        if (str == null) {
            str = address.geoAddressTitle;
        }
        createMapBuilder.put("title", str);
        String str2 = address.profileName;
        if (str2 == null) {
            str2 = address.geoAddressTitle;
        }
        createMapBuilder.put("pn", str2);
        createMapBuilder.put("ccd", address.mobilNumberCountryCode);
        createMapBuilder.put("mob", address.mobileNumber);
        createMapBuilder.put(UserDataStore.PHONE, address.phoneNumber);
        createMapBuilder.put("type", Integer.valueOf(address.type));
        createMapBuilder.put("su", address.suite);
        return MapsKt__MapsJVMKt.build(createMapBuilder);
    }

    @NotNull
    public final Address mapUnsavedAddress(@NotNull Map<?, ?> map) {
        String str;
        String str2;
        Integer num;
        int i11;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Integer num2;
        int i12;
        String str9;
        String str10;
        Integer num3;
        int i13;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        Boolean bool;
        boolean z11;
        Boolean bool2;
        boolean z12;
        Boolean bool3;
        boolean z13;
        String str21;
        String str22;
        Double d11;
        double d12;
        Double d13;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        Integer num4;
        int i14;
        Map<?, ?> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "address");
        Object obj = map2.get("eid");
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        Object obj2 = map2.get("aid");
        if (obj2 instanceof Integer) {
            num = (Integer) obj2;
        } else {
            num = null;
        }
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = 0;
        }
        Object obj3 = map2.get("an");
        if (obj3 instanceof String) {
            str3 = (String) obj3;
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        Object obj4 = map2.get("blk");
        if (obj4 instanceof String) {
            str5 = (String) obj4;
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str6 = "";
        } else {
            str6 = str5;
        }
        Object obj5 = map2.get("bno");
        if (obj5 instanceof String) {
            str7 = (String) obj5;
        } else {
            str7 = null;
        }
        if (str7 == null) {
            str8 = "";
        } else {
            str8 = str7;
        }
        Object obj6 = map2.get("cid");
        if (obj6 instanceof Integer) {
            num2 = (Integer) obj6;
        } else {
            num2 = null;
        }
        if (num2 != null) {
            i12 = num2.intValue();
        } else {
            i12 = 0;
        }
        Object obj7 = map2.get("cnm");
        if (obj7 instanceof String) {
            str9 = (String) obj7;
        } else {
            str9 = null;
        }
        if (str9 == null) {
            str10 = "";
        } else {
            str10 = str9;
        }
        Object obj8 = map2.get("cnt");
        if (obj8 instanceof Integer) {
            num3 = (Integer) obj8;
        } else {
            num3 = null;
        }
        if (num3 != null) {
            i13 = num3.intValue();
        } else {
            i13 = 0;
        }
        Object obj9 = map2.get("exd");
        if (obj9 instanceof String) {
            str11 = (String) obj9;
        } else {
            str11 = null;
        }
        if (str11 == null) {
            str12 = "";
        } else {
            str12 = str11;
        }
        Object obj10 = map2.get("fl");
        if (obj10 instanceof String) {
            str13 = (String) obj10;
        } else {
            str13 = null;
        }
        if (str13 == null) {
            str14 = "";
        } else {
            str14 = str13;
        }
        Object obj11 = map2.get("msg");
        if (obj11 instanceof String) {
            str15 = (String) obj11;
        } else {
            str15 = null;
        }
        if (str15 == null) {
            str16 = "";
        } else {
            str16 = str15;
        }
        Object obj12 = map2.get("title");
        if (obj12 instanceof String) {
            str17 = (String) obj12;
        } else {
            str17 = null;
        }
        if (str17 == null) {
            str17 = "";
        }
        Object obj13 = map2.get("grl");
        if (obj13 instanceof String) {
            str18 = (String) obj13;
        } else {
            str18 = null;
        }
        if (str18 == null) {
            str18 = "";
        }
        Object obj14 = map2.get("grlid");
        String str34 = "";
        if (obj14 instanceof String) {
            str19 = (String) obj14;
        } else {
            str19 = null;
        }
        if (str19 == null) {
            str20 = str34;
        } else {
            str20 = str19;
        }
        Object obj15 = map2.get("asplt");
        String str35 = str20;
        if (obj15 instanceof Boolean) {
            bool = (Boolean) obj15;
        } else {
            bool = null;
        }
        if (bool != null) {
            z11 = bool.booleanValue();
        } else {
            z11 = false;
        }
        Object obj16 = map2.get("efd");
        boolean z14 = z11;
        if (obj16 instanceof Boolean) {
            bool2 = (Boolean) obj16;
        } else {
            bool2 = null;
        }
        if (bool2 != null) {
            z12 = bool2.booleanValue();
        } else {
            z12 = false;
        }
        Object obj17 = map2.get("iso");
        boolean z15 = z12;
        if (obj17 instanceof Boolean) {
            bool3 = (Boolean) obj17;
        } else {
            bool3 = null;
        }
        if (bool3 != null) {
            z13 = bool3.booleanValue();
        } else {
            z13 = false;
        }
        Object obj18 = map2.get("jd");
        boolean z16 = z13;
        if (obj18 instanceof String) {
            str21 = (String) obj18;
        } else {
            str21 = null;
        }
        if (str21 == null) {
            str22 = str34;
        } else {
            str22 = str21;
        }
        Object obj19 = map2.get("ltd");
        String str36 = str22;
        if (obj19 instanceof Double) {
            d11 = (Double) obj19;
        } else {
            d11 = null;
        }
        double d14 = 0.0d;
        if (d11 != null) {
            d12 = d11.doubleValue();
        } else {
            d12 = 0.0d;
        }
        Object obj20 = map2.get("lngt");
        if (obj20 instanceof Double) {
            d13 = (Double) obj20;
        } else {
            d13 = null;
        }
        if (d13 != null) {
            d14 = d13.doubleValue();
        }
        double d15 = d14;
        Object obj21 = map2.get("mob");
        if (obj21 instanceof String) {
            str23 = (String) obj21;
        } else {
            str23 = null;
        }
        if (str23 == null) {
            str23 = str34;
        }
        Object obj22 = map2.get("ccd");
        String str37 = str23;
        if (obj22 instanceof String) {
            str24 = (String) obj22;
        } else {
            str24 = null;
        }
        if (str24 == null) {
            str25 = str34;
        } else {
            str25 = str24;
        }
        Object obj23 = map2.get(UserDataStore.PHONE);
        String str38 = str25;
        if (obj23 instanceof String) {
            str26 = (String) obj23;
        } else {
            str26 = null;
        }
        if (str26 == null) {
            str27 = str34;
        } else {
            str27 = str26;
        }
        Object obj24 = map2.get("pn");
        String str39 = str27;
        if (obj24 instanceof String) {
            str28 = (String) obj24;
        } else {
            str28 = null;
        }
        if (str28 == null) {
            str29 = str34;
        } else {
            str29 = str28;
        }
        Object obj25 = map2.get(UserDataStore.STATE);
        String str40 = str29;
        if (obj25 instanceof String) {
            str30 = (String) obj25;
        } else {
            str30 = null;
        }
        if (str30 == null) {
            str31 = str34;
        } else {
            str31 = str30;
        }
        Object obj26 = map2.get("su");
        String str41 = str31;
        if (obj26 instanceof String) {
            str32 = (String) obj26;
        } else {
            str32 = null;
        }
        if (str32 == null) {
            str33 = str34;
        } else {
            str33 = str32;
        }
        Object obj27 = map2.get("type");
        if (obj27 instanceof Integer) {
            num4 = (Integer) obj27;
        } else {
            num4 = null;
        }
        if (num4 != null) {
            i14 = num4.intValue();
        } else {
            i14 = 0;
        }
        return new Address(str2, i11, str4, str6, str8, i12, i13, str10, str12, str14, str16, str17, str18, str35, z14, z15, z16, str36, d12, d15, str37, str38, str39, str40, str41, str33, i14);
    }

    @NotNull
    public final Address map(@NotNull Map<?, ?> map) {
        Map<?, ?> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "address");
        String str = (String) map2.get("eid");
        String str2 = "";
        String str3 = str == null ? str2 : str;
        String str4 = (String) map2.get("aid");
        int parseInt = str4 != null ? Integer.parseInt(str4) : 0;
        String str5 = (String) map2.get("an");
        String str6 = str5 == null ? str2 : str5;
        String str7 = (String) map2.get("blk");
        String str8 = str7 == null ? str2 : str7;
        String str9 = (String) map2.get("bno");
        String str10 = str9 == null ? str2 : str9;
        String str11 = (String) map2.get("cid");
        int parseInt2 = str11 != null ? Integer.parseInt(str11) : 0;
        String str12 = (String) map2.get("cnm");
        String str13 = str12 == null ? str2 : str12;
        Integer num = (Integer) map2.get("cnt");
        int intValue = num != null ? num.intValue() : 0;
        String str14 = (String) map2.get("exd");
        String str15 = str14 == null ? str2 : str14;
        String str16 = (String) map2.get("fl");
        String str17 = str16 == null ? str2 : str16;
        String str18 = (String) map2.get("msg");
        String str19 = str18 == null ? str2 : str18;
        String str20 = (String) map2.get("title");
        String str21 = str20 == null ? str2 : str20;
        String str22 = (String) map2.get("grl");
        String str23 = str22 == null ? str2 : str22;
        String str24 = (String) map2.get("grlid");
        String str25 = str24 == null ? str2 : str24;
        Boolean bool = (Boolean) map2.get("asplt");
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        Boolean bool2 = (Boolean) map2.get("efd");
        boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : false;
        Boolean bool3 = (Boolean) map2.get("iso");
        boolean booleanValue3 = bool3 != null ? bool3.booleanValue() : false;
        String str26 = (String) map2.get("jd");
        String str27 = str26 == null ? str2 : str26;
        String str28 = (String) map2.get("ltd");
        double d11 = 0.0d;
        double parseDouble = str28 != null ? Double.parseDouble(str28) : 0.0d;
        String str29 = (String) map2.get("lngt");
        if (str29 != null) {
            d11 = Double.parseDouble(str29);
        }
        double d12 = d11;
        String str30 = (String) map2.get("mob");
        if (str30 == null) {
            str30 = str2;
        }
        String str31 = (String) map2.get("ccd");
        String str32 = str31 == null ? str2 : str31;
        String str33 = (String) map2.get(UserDataStore.PHONE);
        String str34 = str33 == null ? str2 : str33;
        String str35 = (String) map2.get("pn");
        String str36 = str35 == null ? str2 : str35;
        String str37 = (String) map2.get(UserDataStore.STATE);
        String str38 = str37 == null ? str2 : str37;
        String str39 = (String) map2.get("su");
        if (str39 != null) {
            str2 = str39;
        }
        String str40 = (String) map2.get("type");
        return new Address(str3, parseInt, str6, str8, str10, parseInt2, intValue, str13, str15, str17, str19, str21, str23, str25, booleanValue, booleanValue2, booleanValue3, str27, parseDouble, d12, str30, str32, str34, str36, str38, str2, str40 != null ? Integer.parseInt(str40) : 0);
    }
}
