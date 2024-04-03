package com.talabat.core.tracking.data.platform.impl;

import android.content.Context;
import androidx.core.os.BundleKt;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.core.tracking.data.logger.LogManager;
import com.talabat.core.tracking.data.platform.TrackingPlatform;
import com.talabat.core.tracking.domain.CommonAttributes;
import com.talabat.core.tracking.domain.TestingUtils;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0002J\u001e\u0010\u0011\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0002J\u001e\u0010\u0012\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0002J\u001e\u0010\u0013\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0002J\u001e\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J&\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/core/tracking/data/platform/impl/HiAnalyticsTrackingPlatform;", "Lcom/talabat/core/tracking/data/platform/TrackingPlatform;", "context", "Landroid/content/Context;", "commonAttributes", "Lcom/talabat/core/tracking/domain/CommonAttributes;", "testingUtils", "Lcom/talabat/core/tracking/domain/TestingUtils;", "hiAnalytics", "Lcom/huawei/hms/analytics/HiAnalyticsInstance;", "(Landroid/content/Context;Lcom/talabat/core/tracking/domain/CommonAttributes;Lcom/talabat/core/tracking/domain/TestingUtils;Lcom/huawei/hms/analytics/HiAnalyticsInstance;)V", "addAdjustInfoAttributes", "", "attributes", "", "", "", "addDeeplinkInfoAttributes", "addPreReleaseVersion", "addSessionInfoAttributes", "getCommonAttributes", "", "eventName", "track", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HiAnalyticsTrackingPlatform implements TrackingPlatform {
    @NotNull
    private final CommonAttributes commonAttributes;
    @NotNull
    private final Context context;
    @NotNull
    private final HiAnalyticsInstance hiAnalytics;
    @NotNull
    private final TestingUtils testingUtils;

    public HiAnalyticsTrackingPlatform(@NotNull Context context2, @NotNull CommonAttributes commonAttributes2, @NotNull TestingUtils testingUtils2, @NotNull HiAnalyticsInstance hiAnalyticsInstance) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(commonAttributes2, "commonAttributes");
        Intrinsics.checkNotNullParameter(testingUtils2, "testingUtils");
        Intrinsics.checkNotNullParameter(hiAnalyticsInstance, "hiAnalytics");
        this.context = context2;
        this.commonAttributes = commonAttributes2;
        this.testingUtils = testingUtils2;
        this.hiAnalytics = hiAnalyticsInstance;
    }

    private final void addAdjustInfoAttributes(Map<String, Object> map) {
        map.put(ConstantsKt.ADJUST_NETWORK, this.commonAttributes.getNetwork());
        map.put(ConstantsKt.ADJUST_AD_GROUP, this.commonAttributes.getAdGroup());
        map.put(ConstantsKt.ADJUST_CAMPAIGN, this.commonAttributes.getCampaign());
        map.put(ConstantsKt.ADJUST_CREATIVE, this.commonAttributes.getCreative());
        map.put(ConstantsKt.ADJUST_TRACKER_TOKEN, this.commonAttributes.getTrackerToken());
        map.put(ConstantsKt.ADJUST_LABEL, this.commonAttributes.getClickLabel());
        map.put(ConstantsKt.ADJUST_AD_ID, this.commonAttributes.getAdId());
    }

    private final void addDeeplinkInfoAttributes(Map<String, Object> map) {
        map.put(ConstantsKt.DEEPLINK_UTM_SOURCE, this.commonAttributes.getDeeplinkSource());
        map.put("source", this.commonAttributes.getDeeplinkSource());
        map.put(ConstantsKt.DEEPLINK_UTM_CAMPAIGN, this.commonAttributes.getCampaign());
        map.put("campaign", this.commonAttributes.getCampaign());
        map.put(ConstantsKt.DEEPLINK_UTM_MEDIUM, this.commonAttributes.getDeeplinkMedium());
        map.put("medium", this.commonAttributes.getDeeplinkMedium());
        map.put(ConstantsKt.DEEPLINK_UTM_CONTENT, this.commonAttributes.getDeeplinkContent());
        map.put(ConstantsKt.DEEPLINK_UTM_ID, this.commonAttributes.getDeeplinkId());
        map.put(ConstantsKt.DEEPLINK_UTM_TERM, this.commonAttributes.getDeeplinkTerm());
        map.put("deeplink", this.commonAttributes.getDeeplinkQuery());
    }

    private final void addPreReleaseVersion(Map<String, Object> map) {
        if (!this.commonAttributes.isProdBuild()) {
            map.put(ConstantsKt.PRE_RELEASE_VERSION, 1);
        }
    }

    private final void addSessionInfoAttributes(Map<String, Object> map) {
        map.put("perseusHitMatchId", this.commonAttributes.getHitMatchId());
        map.put("perseusSessionId", this.commonAttributes.getSessionId());
        map.put("perseusClientId", this.commonAttributes.getClientId());
        map.put("userId", this.commonAttributes.getUserId());
        map.put("userLoggedIn", this.commonAttributes.isUserLoggedIn());
        map.put("userTimeStamp", this.commonAttributes.getUserTimeStamp());
        map.put(ConstantsKt.SELECTED_LANGUAGE, this.commonAttributes.getSelectedLanguage());
        map.put("locationCountry", this.commonAttributes.getSelectedCountry());
        map.put("locationCity", this.commonAttributes.getSelectedCity());
        map.put("locationArea", this.commonAttributes.getSelectedArea());
        map.put("locationAddress", this.commonAttributes.getSelectedAddress());
        map.put("locationLat", this.commonAttributes.getSelectedLatitude());
        map.put("locationLon", this.commonAttributes.getSelectedLongitude());
        map.put("customerCode", this.commonAttributes.getCustomerCode());
    }

    @NotNull
    public Map<String, Object> getCommonAttributes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        addSessionInfoAttributes(linkedHashMap);
        addDeeplinkInfoAttributes(linkedHashMap);
        addAdjustInfoAttributes(linkedHashMap);
        addPreReleaseVersion(linkedHashMap);
        return linkedHashMap;
    }

    public void track(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        String str2 = "Sending " + str + " with params " + map + " and userId " + this.commonAttributes.getUserId();
        LogManager.debug(str2);
        this.hiAnalytics.setUserId(this.commonAttributes.getUserId());
        if (this.testingUtils.isAutomationProcess()) {
            this.testingUtils.setLogEventForAutomation(str, map);
        }
        HiAnalyticsInstance hiAnalyticsInstance = this.hiAnalytics;
        Object[] array = MapsKt___MapsKt.toList(map).toArray(new Pair[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Pair[] pairArr = (Pair[]) array;
        hiAnalyticsInstance.onEvent(str, BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
        this.testingUtils.updateEventsTracker(str, map, str2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HiAnalyticsTrackingPlatform(android.content.Context r1, com.talabat.core.tracking.domain.CommonAttributes r2, com.talabat.core.tracking.domain.TestingUtils r3, com.huawei.hms.analytics.HiAnalyticsInstance r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r5 = r5 & 8
            if (r5 == 0) goto L_0x000d
            com.huawei.hms.analytics.HiAnalyticsInstance r4 = com.huawei.hms.analytics.HiAnalytics.getInstance((android.content.Context) r1)
            java.lang.String r5 = "getInstance(\n        context\n    )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
        L_0x000d:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.tracking.data.platform.impl.HiAnalyticsTrackingPlatform.<init>(android.content.Context, com.talabat.core.tracking.domain.CommonAttributes, com.talabat.core.tracking.domain.TestingUtils, com.huawei.hms.analytics.HiAnalyticsInstance, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
