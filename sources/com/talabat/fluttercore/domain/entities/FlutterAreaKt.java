package com.talabat.fluttercore.domain.entities;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"toMap", "", "", "", "Lcom/talabat/fluttercore/domain/entities/FlutterArea;", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FlutterAreaKt {
    @NotNull
    public static final Map<String, Object> toMap(@NotNull FlutterArea flutterArea) {
        Intrinsics.checkNotNullParameter(flutterArea, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("latitude", Double.valueOf(flutterArea.getLatitude())), TuplesKt.to("longitude", Double.valueOf(flutterArea.getLongitude())), TuplesKt.to("areaId", Integer.valueOf(flutterArea.getAreaId())), TuplesKt.to("areaName", flutterArea.getAreaName()), TuplesKt.to("cityId", Integer.valueOf(flutterArea.getCityId())), TuplesKt.to("cityName", flutterArea.getCityName()));
    }
}
