package com.alexmiller.map_launcher;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/alexmiller/map_launcher/MapModel;", "", "mapType", "Lcom/alexmiller/map_launcher/MapType;", "mapName", "", "packageName", "urlPrefix", "(Lcom/alexmiller/map_launcher/MapType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMapName", "()Ljava/lang/String;", "getMapType", "()Lcom/alexmiller/map_launcher/MapType;", "getPackageName", "getUrlPrefix", "toMap", "", "map_launcher_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class MapModel {
    @NotNull
    private final String mapName;
    @NotNull
    private final MapType mapType;
    @NotNull
    private final String packageName;
    @NotNull
    private final String urlPrefix;

    public MapModel(@NotNull MapType mapType2, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(mapType2, Param.MAP_TYPE);
        Intrinsics.checkNotNullParameter(str, "mapName");
        Intrinsics.checkNotNullParameter(str2, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str3, "urlPrefix");
        this.mapType = mapType2;
        this.mapName = str;
        this.packageName = str2;
        this.urlPrefix = str3;
    }

    @NotNull
    public final String getMapName() {
        return this.mapName;
    }

    @NotNull
    public final MapType getMapType() {
        return this.mapType;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getUrlPrefix() {
        return this.urlPrefix;
    }

    @NotNull
    public final Map<String, String> toMap() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to(Param.MAP_TYPE, this.mapType.name()), TuplesKt.to("mapName", this.mapName), TuplesKt.to(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, this.packageName), TuplesKt.to("urlPrefix", this.urlPrefix));
    }
}
