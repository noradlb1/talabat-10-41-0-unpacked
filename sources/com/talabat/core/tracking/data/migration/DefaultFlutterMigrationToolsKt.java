package com.talabat.core.tracking.data.migration;

import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\r*\u00020\u000eH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"ANDROID_TRACKING_WAY", "", "CORELIB", "EVENT_NAME_KEY", "FLUTTER_CHANNEL_METHOD", "FLUTTER_MIGRATION_EVENT_DIFFERENTIATOR_KEY", "FLUTTER_MIGRATION_VERIFY_KEY", "FLUTTER_MIGRATION_VERIFY_VALUE", "GA_EVENT_NAME", "LEGACY", "NR_EVENT_TYPE", "NR_TABLE_NAME", "convertBundleToMap", "", "Landroid/os/Bundle;", "com_talabat_core_tracking_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DefaultFlutterMigrationToolsKt {
    @NotNull
    private static final String ANDROID_TRACKING_WAY = "android_tracking_way";
    @NotNull
    private static final String CORELIB = "corelib";
    @NotNull
    private static final String EVENT_NAME_KEY = "name";
    @NotNull
    private static final String FLUTTER_CHANNEL_METHOD = "flutter_channel_method";
    @NotNull
    private static final String FLUTTER_MIGRATION_EVENT_DIFFERENTIATOR_KEY = "eventTimestampDifferentiator";
    @NotNull
    private static final String FLUTTER_MIGRATION_VERIFY_KEY = "trackingLibrarySource";
    @NotNull
    private static final String FLUTTER_MIGRATION_VERIFY_VALUE = "androidSDKSource";
    @NotNull
    private static final String GA_EVENT_NAME = "gaEventName";
    @NotNull
    private static final String LEGACY = "legacy";
    @NotNull
    private static final String NR_EVENT_TYPE = "new_flutter_tracking_validation_event_pushed";
    @NotNull
    private static final String NR_TABLE_NAME = "android_tracking_validation_discrepancy_table";

    /* access modifiers changed from: private */
    public static final Map<String, String> convertBundleToMap(Bundle bundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<String> keySet = bundle.keySet();
        if (keySet != null) {
            for (String str : keySet) {
                Intrinsics.checkNotNullExpressionValue(str, "key");
                linkedHashMap.put(str, String.valueOf(bundle.get(str)));
            }
        }
        return linkedHashMap;
    }
}
