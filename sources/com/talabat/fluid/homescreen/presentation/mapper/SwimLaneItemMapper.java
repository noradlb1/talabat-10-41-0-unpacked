package com.talabat.fluid.homescreen.presentation.mapper;

import com.facebook.internal.NativeProtocol;
import com.talabat.fluid.homescreen.presentation.displaymodel.SwimLaneEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\b"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/mapper/SwimLaneItemMapper;", "", "()V", "toSwimLaneEvent", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/SwimLaneEvent;", "params", "", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimLaneItemMapper {
    @NotNull
    public final SwimLaneEvent toSwimLaneEvent(@NotNull Map<String, String> map) {
        int i11;
        int i12;
        boolean z11;
        boolean z12;
        boolean z13;
        Integer intOrNull;
        Integer intOrNull2;
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        String str = map.get("shopId");
        if (str == null || (intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str)) == null) {
            i11 = -1;
        } else {
            i11 = intOrNull2.intValue();
        }
        String str2 = map.get("verticalId");
        if (str2 == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2)) == null) {
            i12 = -1;
        } else {
            i12 = intOrNull.intValue();
        }
        String str3 = map.get(BannerAdItemMapper.KEY_IS_GRL_ENABLED);
        if (str3 != null) {
            z11 = Boolean.parseBoolean(str3);
        } else {
            z11 = false;
        }
        String str4 = map.get("isDarkStore");
        if (str4 != null) {
            z12 = Boolean.parseBoolean(str4);
        } else {
            z12 = false;
        }
        String str5 = map.get("ismgrtd");
        if (str5 != null) {
            z13 = Boolean.parseBoolean(str5);
        } else {
            z13 = false;
        }
        return new SwimLaneEvent(i11, i12, z11, z12, z13);
    }
}
