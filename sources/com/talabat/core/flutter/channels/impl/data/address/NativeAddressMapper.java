package com.talabat.core.flutter.channels.impl.data.address;

import com.facebook.appevents.UserDataStore;
import com.talabat.domain.address.Address;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/address/NativeAddressMapper;", "", "()V", "map", "Lcom/talabat/domain/address/Address;", "address", "", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NativeAddressMapper {
    @NotNull
    public final Address map(@NotNull Map<?, ?> map) {
        String str;
        int i11;
        String str2;
        String str3;
        String str4;
        int i12;
        String str5;
        int i13;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        boolean z11;
        boolean z12;
        boolean z13;
        String str12;
        double d11;
        String str13;
        String str14;
        String str15;
        String str16;
        int i14;
        Map<?, ?> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "address");
        String str17 = (String) map2.get("eid");
        String str18 = "";
        if (str17 == null) {
            str = str18;
        } else {
            str = str17;
        }
        Integer num = (Integer) map2.get("aid");
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = 0;
        }
        String str19 = (String) map2.get("an");
        if (str19 == null) {
            str2 = str18;
        } else {
            str2 = str19;
        }
        String str20 = (String) map2.get("blk");
        if (str20 == null) {
            str3 = str18;
        } else {
            str3 = str20;
        }
        String str21 = (String) map2.get("bno");
        if (str21 == null) {
            str4 = str18;
        } else {
            str4 = str21;
        }
        Integer num2 = (Integer) map2.get("cid");
        if (num2 != null) {
            i12 = num2.intValue();
        } else {
            i12 = 0;
        }
        String str22 = (String) map2.get("cnm");
        if (str22 == null) {
            str5 = str18;
        } else {
            str5 = str22;
        }
        Integer num3 = (Integer) map2.get("cnt");
        if (num3 != null) {
            i13 = num3.intValue();
        } else {
            i13 = 0;
        }
        String str23 = (String) map2.get("exd");
        if (str23 == null) {
            str6 = str18;
        } else {
            str6 = str23;
        }
        String str24 = (String) map2.get("fl");
        if (str24 == null) {
            str7 = str18;
        } else {
            str7 = str24;
        }
        String str25 = (String) map2.get("msg");
        if (str25 == null) {
            str8 = str18;
        } else {
            str8 = str25;
        }
        String str26 = (String) map2.get("title");
        if (str26 == null) {
            str9 = str18;
        } else {
            str9 = str26;
        }
        String str27 = (String) map2.get("grl");
        if (str27 == null) {
            str10 = str18;
        } else {
            str10 = str27;
        }
        String str28 = (String) map2.get("grlid");
        if (str28 == null) {
            str11 = str18;
        } else {
            str11 = str28;
        }
        Boolean bool = (Boolean) map2.get("asplt");
        if (bool != null) {
            z11 = bool.booleanValue();
        } else {
            z11 = false;
        }
        Boolean bool2 = (Boolean) map2.get("efd");
        if (bool2 != null) {
            z12 = bool2.booleanValue();
        } else {
            z12 = false;
        }
        Boolean bool3 = (Boolean) map2.get("iso");
        if (bool3 != null) {
            z13 = bool3.booleanValue();
        } else {
            z13 = false;
        }
        String str29 = (String) map2.get("jd");
        if (str29 == null) {
            str12 = str18;
        } else {
            str12 = str29;
        }
        Double d12 = (Double) map2.get("ltd");
        double d13 = 0.0d;
        if (d12 != null) {
            d11 = d12.doubleValue();
        } else {
            d11 = 0.0d;
        }
        Double d14 = (Double) map2.get("lngt");
        if (d14 != null) {
            d13 = d14.doubleValue();
        }
        double d15 = d13;
        String str30 = (String) map2.get("mob");
        if (str30 == null) {
            str30 = str18;
        }
        String str31 = (String) map2.get("ccd");
        if (str31 == null) {
            str13 = str18;
        } else {
            str13 = str31;
        }
        String str32 = (String) map2.get(UserDataStore.PHONE);
        if (str32 == null) {
            str14 = str18;
        } else {
            str14 = str32;
        }
        String str33 = (String) map2.get("pn");
        if (str33 == null) {
            str15 = str18;
        } else {
            str15 = str33;
        }
        String str34 = (String) map2.get(UserDataStore.STATE);
        if (str34 == null) {
            str16 = str18;
        } else {
            str16 = str34;
        }
        String str35 = (String) map2.get("su");
        if (str35 != null) {
            str18 = str35;
        }
        Integer num4 = (Integer) map2.get("type");
        if (num4 != null) {
            i14 = num4.intValue();
        } else {
            i14 = 0;
        }
        return new Address(str, i11, str2, str3, str4, i12, i13, str5, str6, str7, str8, str9, str10, str11, z11, z12, z13, str12, d11, d15, str30, str13, str14, str15, str16, str18, i14);
    }
}
