package com.alexmiller.map_launcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00112\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u001c\u0010\u001c\u001a\u00020\u00112\b\b\u0001\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/alexmiller/map_launcher/MapLauncherPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "context", "Landroid/content/Context;", "maps", "", "Lcom/alexmiller/map_launcher/MapModel;", "getInstalledMaps", "isMapAvailable", "", "type", "", "launchMap", "", "mapType", "Lcom/alexmiller/map_launcher/MapType;", "url", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "Companion", "map_launcher_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MapLauncherPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public MethodChannel channel;
    /* access modifiers changed from: private */
    public Context context;
    @NotNull
    private final List<MapModel> maps = CollectionsKt__CollectionsKt.listOf(new MapModel(MapType.google, "Google Maps", "com.google.android.apps.maps", "geo://"), new MapModel(MapType.googleGo, "Google Maps Go", "com.google.android.apps.mapslite", "geo://"), new MapModel(MapType.amap, "Amap", "com.autonavi.minimap", "iosamap://"), new MapModel(MapType.baidu, "Baidu Maps", "com.baidu.BaiduMap", "baidumap://"), new MapModel(MapType.waze, "Waze", "com.waze", "waze://"), new MapModel(MapType.yandexNavi, "Yandex Navigator", "ru.yandex.yandexnavi", "yandexnavi://"), new MapModel(MapType.yandexMaps, "Yandex Maps", "ru.yandex.yandexmaps", "yandexmaps://"), new MapModel(MapType.citymapper, "Citymapper", "com.citymapper.app.release", "citymapper://"), new MapModel(MapType.mapswithme, "MAPS.ME", "com.mapswithme.maps.pro", "mapswithme://"), new MapModel(MapType.osmand, "OsmAnd", "net.osmand", "osmandmaps://"), new MapModel(MapType.osmandplus, "OsmAnd+", "net.osmand.plus", "osmandmaps://"), new MapModel(MapType.doubleGis, "2GIS", "ru.dublgis.dgismobile", "dgis://"), new MapModel(MapType.tencent, "Tencent (QQ Maps)", "com.tencent.map", "qqmap://"), new MapModel(MapType.here, "HERE WeGo", "com.here.app.maps", "here-location://"), new MapModel(MapType.petal, "Petal Maps", "com.huawei.maps.app", "petalmaps://"), new MapModel(MapType.tomtomgo, "TomTom Go", "com.tomtom.gplay.navapp", "tomtomgo://"), new MapModel(MapType.tomtomgofleet, "TomTom Go Fleet", "com.tomtom.gplay.navapp.gofleet", "tomtomgofleet://"), new MapModel(MapType.sygicTruck, "Sygic Truck", "com.sygic.truck", "com.sygic.aura://"), new MapModel(MapType.copilot, "CoPilot", "com.alk.copilot.mapviewer", "copilot://"), new MapModel(MapType.flitsmeister, "Flitsmeister", "nl.flitsmeister", "flitsmeister://"), new MapModel(MapType.truckmeister, "Truckmeister", "nl.flitsmeister.flux", "truckmeister://"));

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/alexmiller/map_launcher/MapLauncherPlugin$Companion;", "", "()V", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "map_launcher_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void registerWith(@NotNull @NonNull PluginRegistry.Registrar registrar) {
            Intrinsics.checkNotNullParameter(registrar, "registrar");
            MapLauncherPlugin mapLauncherPlugin = new MapLauncherPlugin();
            mapLauncherPlugin.channel = new MethodChannel(registrar.messenger(), "map_launcher");
            Context context = registrar.context();
            Intrinsics.checkNotNullExpressionValue(context, "registrar.context()");
            mapLauncherPlugin.context = context;
            MethodChannel access$getChannel$p = mapLauncherPlugin.channel;
            if (access$getChannel$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
                access$getChannel$p = null;
            }
            access$getChannel$p.setMethodCallHandler(mapLauncherPlugin);
        }
    }

    private final List<MapModel> getInstalledMaps() {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        for (Object next : this.maps) {
            MapModel mapModel = (MapModel) next;
            Context context2 = this.context;
            Intent intent = null;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            PackageManager packageManager = context2.getPackageManager();
            if (packageManager != null) {
                intent = packageManager.getLaunchIntentForPackage(mapModel.getPackageName());
            }
            if (intent != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private final boolean isMapAvailable(String str) {
        Iterable<MapModel> installedMaps = getInstalledMaps();
        if ((installedMaps instanceof Collection) && ((Collection) installedMaps).isEmpty()) {
            return false;
        }
        for (MapModel mapType : installedMaps) {
            if (Intrinsics.areEqual((Object) mapType.getMapType().name(), (Object) str)) {
                return true;
            }
        }
        return false;
    }

    private final void launchMap(MapType mapType, String str, MethodChannel.Result result) {
        Object obj;
        boolean z11;
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        Iterator it = this.maps.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((MapModel) obj).getMapType() == mapType) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        MapModel mapModel = (MapModel) obj;
        if (mapModel != null) {
            intent.setPackage(mapModel.getPackageName());
        }
        context2.startActivity(intent);
        result.success((Object) null);
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        this.channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "map_launcher");
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "flutterPluginBinding.applicationContext");
        this.context = applicationContext;
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005b, code lost:
        if (r0.equals("showDirections") == false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0064, code lost:
        if (r0.equals("showMarker") == false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0067, code lost:
        r6 = r6.arguments;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        r6 = (java.util.Map) r6;
        r0 = r6.get(com.huawei.hms.flutter.map.constants.Param.MAP_TYPE);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.String");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007b, code lost:
        if (isMapAvailable((java.lang.String) r0) != false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007d, code lost:
        r7.error("MAP_NOT_AVAILABLE", "Map is not installed on a device", (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0086, code lost:
        r0 = r6.get(com.huawei.hms.flutter.map.constants.Param.MAP_TYPE);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.String");
        r0 = com.alexmiller.map_launcher.MapType.valueOf((java.lang.String) r0);
        r6 = r6.get("url");
        kotlin.jvm.internal.Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.String");
        launchMap(r0, (java.lang.String) r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(@org.jetbrains.annotations.NotNull @androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r6, @org.jetbrains.annotations.NotNull @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r7) {
        /*
            r5 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = r6.method
            if (r0 == 0) goto L_0x00c7
            int r1 = r0.hashCode()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.Map<*, *>"
            java.lang.String r3 = "mapType"
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.String"
            switch(r1) {
                case -1346420969: goto L_0x00a2;
                case 593783191: goto L_0x005e;
                case 1818544049: goto L_0x0055;
                case 2005082491: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x00c7
        L_0x001d:
            java.lang.String r6 = "getInstalledMaps"
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto L_0x0027
            goto L_0x00c7
        L_0x0027:
            java.util.List r6 = r5.getInstalledMaps()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r6, r1)
            r0.<init>(r1)
            java.util.Iterator r6 = r6.iterator()
        L_0x003c:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0050
            java.lang.Object r1 = r6.next()
            com.alexmiller.map_launcher.MapModel r1 = (com.alexmiller.map_launcher.MapModel) r1
            java.util.Map r1 = r1.toMap()
            r0.add(r1)
            goto L_0x003c
        L_0x0050:
            r7.success(r0)
            goto L_0x00ca
        L_0x0055:
            java.lang.String r1 = "showDirections"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0067
            goto L_0x00c7
        L_0x005e:
            java.lang.String r1 = "showMarker"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0067
            goto L_0x00c7
        L_0x0067:
            java.lang.Object r6 = r6.arguments
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r2)
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r0 = r6.get(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r4)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r5.isMapAvailable(r0)
            if (r0 != 0) goto L_0x0086
            java.lang.String r6 = "Map is not installed on a device"
            r0 = 0
            java.lang.String r1 = "MAP_NOT_AVAILABLE"
            r7.error(r1, r6, r0)
            return
        L_0x0086:
            java.lang.Object r0 = r6.get(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r4)
            java.lang.String r0 = (java.lang.String) r0
            com.alexmiller.map_launcher.MapType r0 = com.alexmiller.map_launcher.MapType.valueOf(r0)
            java.lang.String r1 = "url"
            java.lang.Object r6 = r6.get(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r4)
            java.lang.String r6 = (java.lang.String) r6
            r5.launchMap(r0, r6, r7)
            goto L_0x00ca
        L_0x00a2:
            java.lang.String r1 = "isMapAvailable"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ab
            goto L_0x00c7
        L_0x00ab:
            java.lang.Object r6 = r6.arguments
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r2)
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r6 = r6.get(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r4)
            java.lang.String r6 = (java.lang.String) r6
            boolean r6 = r5.isMapAvailable(r6)
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r7.success(r6)
            goto L_0x00ca
        L_0x00c7:
            r7.notImplemented()
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alexmiller.map_launcher.MapLauncherPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
