package com.facebook.appevents.eventdeactivation;

import androidx.annotation.RestrictTo;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0002J&\u0010\u000e\u001a\u00020\f2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager;", "", "()V", "deprecatedEvents", "", "", "deprecatedParamFilters", "", "Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager$DeprecatedParamFilter;", "enabled", "", "enable", "", "initialize", "processDeprecatedParameters", "parameters", "", "eventName", "processEvents", "events", "Lcom/facebook/appevents/AppEvent;", "DeprecatedParamFilter", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class EventDeactivationManager {
    @NotNull
    public static final EventDeactivationManager INSTANCE = new EventDeactivationManager();
    @NotNull
    private static final Set<String> deprecatedEvents = new HashSet();
    @NotNull
    private static final List<DeprecatedParamFilter> deprecatedParamFilters = new ArrayList();
    private static boolean enabled;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager$DeprecatedParamFilter;", "", "eventName", "", "deprecateParams", "", "(Ljava/lang/String;Ljava/util/List;)V", "getDeprecateParams", "()Ljava/util/List;", "setDeprecateParams", "(Ljava/util/List;)V", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DeprecatedParamFilter {
        @NotNull
        private List<String> deprecateParams;
        @NotNull
        private String eventName;

        public DeprecatedParamFilter(@NotNull String str, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            Intrinsics.checkNotNullParameter(list, "deprecateParams");
            this.eventName = str;
            this.deprecateParams = list;
        }

        @NotNull
        public final List<String> getDeprecateParams() {
            return this.deprecateParams;
        }

        @NotNull
        public final String getEventName() {
            return this.eventName;
        }

        public final void setDeprecateParams(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.deprecateParams = list;
        }

        public final void setEventName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.eventName = str;
        }
    }

    private EventDeactivationManager() {
    }

    @JvmStatic
    public static final void enable() {
        enabled = true;
        INSTANCE.initialize();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void initialize() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.facebook.internal.FetchedAppSettingsManager r0 = com.facebook.internal.FetchedAppSettingsManager.INSTANCE     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.String r0 = com.facebook.FacebookSdk.getApplicationId()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r1 = 0
            com.facebook.internal.FetchedAppSettings r0 = com.facebook.internal.FetchedAppSettingsManager.queryAppSettings(r0, r1)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r0 != 0) goto L_0x0010
            monitor-exit(r6)
            return
        L_0x0010:
            java.lang.String r0 = r0.getRestrictiveDataSetting()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r0 == 0) goto L_0x0079
            int r2 = r0.length()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r2 <= 0) goto L_0x001d
            r1 = 1
        L_0x001d:
            if (r1 == 0) goto L_0x0079
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r1.<init>((java.lang.String) r0)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.util.List<com.facebook.appevents.eventdeactivation.EventDeactivationManager$DeprecatedParamFilter> r0 = deprecatedParamFilters     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r0.clear()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.util.Iterator r0 = r1.keys()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
        L_0x002d:
            boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r2 == 0) goto L_0x0079
            java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            org.json.JSONObject r3 = r1.getJSONObject(r2)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r3 == 0) goto L_0x002d
            java.lang.String r4 = "is_deprecated_event"
            boolean r4 = r3.optBoolean(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r4 == 0) goto L_0x0052
            java.util.Set<java.lang.String> r3 = deprecatedEvents     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.String r4 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r3.add(r2)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            goto L_0x002d
        L_0x0052:
            java.lang.String r4 = "deprecated_param"
            org.json.JSONArray r3 = r3.optJSONArray(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            com.facebook.appevents.eventdeactivation.EventDeactivationManager$DeprecatedParamFilter r4 = new com.facebook.appevents.eventdeactivation.EventDeactivationManager$DeprecatedParamFilter     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.lang.String r5 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r5.<init>()     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r4.<init>(r2, r5)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            if (r3 == 0) goto L_0x0070
            java.util.List r2 = com.facebook.internal.Utility.convertJSONArrayToList(r3)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r4.setDeprecateParams(r2)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
        L_0x0070:
            java.util.List<com.facebook.appevents.eventdeactivation.EventDeactivationManager$DeprecatedParamFilter> r2 = deprecatedParamFilters     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            r2.add(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0076 }
            goto L_0x002d
        L_0x0076:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x0079:
            monitor-exit(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.eventdeactivation.EventDeactivationManager.initialize():void");
    }

    @JvmStatic
    public static final void processDeprecatedParameters(@NotNull Map<String, String> map, @NotNull String str) {
        Intrinsics.checkNotNullParameter(map, "parameters");
        Intrinsics.checkNotNullParameter(str, "eventName");
        if (enabled) {
            ArrayList<String> arrayList = new ArrayList<>(map.keySet());
            for (DeprecatedParamFilter deprecatedParamFilter : new ArrayList(deprecatedParamFilters)) {
                if (Intrinsics.areEqual((Object) deprecatedParamFilter.getEventName(), (Object) str)) {
                    for (String str2 : arrayList) {
                        if (deprecatedParamFilter.getDeprecateParams().contains(str2)) {
                            map.remove(str2);
                        }
                    }
                }
            }
        }
    }

    @JvmStatic
    public static final void processEvents(@NotNull List<AppEvent> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        if (enabled) {
            Iterator<AppEvent> it = list.iterator();
            while (it.hasNext()) {
                if (deprecatedEvents.contains(it.next().getName())) {
                    it.remove();
                }
            }
        }
    }
}
