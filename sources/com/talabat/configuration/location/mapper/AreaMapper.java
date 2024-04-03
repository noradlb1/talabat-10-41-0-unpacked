package com.talabat.configuration.location.mapper;

import com.talabat.configuration.location.Area;
import com.talabat.configuration.location.model.AreaEntity;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/configuration/location/mapper/AreaMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/location/model/AreaEntity;", "Lcom/talabat/configuration/location/Area;", "()V", "apply", "source", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AreaMapper implements ModelMapper<AreaEntity, Area> {
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
        if (r4 == null) goto L_0x005c;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.configuration.location.Area apply(@org.jetbrains.annotations.NotNull com.talabat.configuration.location.model.AreaEntity r11) {
        /*
            r10 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.Integer r0 = r11.getId()
            r1 = -1
            if (r0 == 0) goto L_0x0013
            int r0 = r0.intValue()
            r3 = r0
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            java.lang.String r4 = r11.getAreaCenterPointCoordinates()
            r0 = 0
            if (r4 == 0) goto L_0x005c
            java.lang.String r2 = ","
            java.lang.String[] r5 = new java.lang.String[]{r2}
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            java.util.List r2 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r4, (java.lang.String[]) r5, (boolean) r6, (int) r7, (int) r8, (java.lang.Object) r9)
            int r4 = r2.size()
            r5 = 2
            r6 = 1
            if (r4 != r5) goto L_0x0033
            r4 = r6
            goto L_0x0034
        L_0x0033:
            r4 = r0
        L_0x0034:
            if (r4 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            if (r2 == 0) goto L_0x0054
            com.talabat.domain.location.GeoCoordinate r4 = new com.talabat.domain.location.GeoCoordinate
            java.lang.Object r5 = r2.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            double r7 = java.lang.Double.parseDouble(r5)
            java.lang.Object r2 = r2.get(r6)
            java.lang.String r2 = (java.lang.String) r2
            double r5 = java.lang.Double.parseDouble(r2)
            r4.<init>(r7, r5)
            goto L_0x005a
        L_0x0054:
            com.talabat.domain.location.GeoCoordinate$Companion r2 = com.talabat.domain.location.GeoCoordinate.Companion
            com.talabat.domain.location.GeoCoordinate r4 = r2.getZERO()
        L_0x005a:
            if (r4 != 0) goto L_0x0063
        L_0x005c:
            com.talabat.domain.location.GeoCoordinate$Companion r2 = com.talabat.domain.location.GeoCoordinate.Companion
            com.talabat.domain.location.GeoCoordinate r2 = r2.getZERO()
            r4 = r2
        L_0x0063:
            java.lang.String r2 = r11.getAreaName()
            if (r2 != 0) goto L_0x006b
            java.lang.String r2 = ""
        L_0x006b:
            r5 = r2
            java.lang.Integer r2 = r11.getCityId()
            if (r2 == 0) goto L_0x0076
            int r1 = r2.intValue()
        L_0x0076:
            r6 = r1
            java.lang.Boolean r11 = r11.isPolygonServiceEnabled()
            if (r11 == 0) goto L_0x0083
            boolean r11 = r11.booleanValue()
            r7 = r11
            goto L_0x0084
        L_0x0083:
            r7 = r0
        L_0x0084:
            com.talabat.configuration.location.Area r11 = new com.talabat.configuration.location.Area
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.location.mapper.AreaMapper.apply(com.talabat.configuration.location.model.AreaEntity):com.talabat.configuration.location.Area");
    }
}
