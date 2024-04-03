package com.talabat.core.tracking.data.platform.impl;

import android.content.Context;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.core.tracking.data.logger.LogManager;
import com.talabat.core.tracking.data.platform.TrackingPlatform;
import com.talabat.core.tracking.domain.CommonAttributes;
import com.talabat.core.tracking.domain.TestingUtils;
import com.talabat.core.tracking.domain.migration.FlutterMigrationTools;
import com.talabat.firebase.Firebase;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.utility.JavaConstant;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0002J\u001e\u0010\u0015\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0002J\u001e\u0010\u0016\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0002J\u001e\u0010\u0017\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0002J\u001e\u0010\u0018\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H\u0002J\u001e\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J&\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00132\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001aH\u0002J&\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00132\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/core/tracking/data/platform/impl/GoogleAnalyticsTrackingPlatform;", "Lcom/talabat/core/tracking/data/platform/TrackingPlatform;", "context", "Landroid/content/Context;", "commonAttributes", "Lcom/talabat/core/tracking/domain/CommonAttributes;", "testingUtils", "Lcom/talabat/core/tracking/domain/TestingUtils;", "firebase", "Lcom/talabat/firebase/Firebase;", "migrationTools", "Lcom/talabat/core/tracking/domain/migration/FlutterMigrationTools;", "perseusRepository", "Lcom/talabat/core/perseus/domain/TalabatPerseusRepository;", "(Landroid/content/Context;Lcom/talabat/core/tracking/domain/CommonAttributes;Lcom/talabat/core/tracking/domain/TestingUtils;Lcom/talabat/firebase/Firebase;Lcom/talabat/core/tracking/domain/migration/FlutterMigrationTools;Lcom/talabat/core/perseus/domain/TalabatPerseusRepository;)V", "addAdjustInfoAttributes", "", "attributes", "", "", "", "addDeeplinkInfoAttributes", "addPerseusAnalyticsAttributes", "addPreReleaseVersion", "addSessionInfoAttributes", "getCommonAttributes", "", "eventName", "sendToFirebaseDatabase", "track", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GoogleAnalyticsTrackingPlatform implements TrackingPlatform {
    @NotNull
    private final CommonAttributes commonAttributes;
    @NotNull
    private final Context context;
    @NotNull

    /* renamed from: firebase  reason: collision with root package name */
    private final Firebase f56005firebase;
    @NotNull
    private final FlutterMigrationTools migrationTools;
    @NotNull
    private final TalabatPerseusRepository perseusRepository;
    @NotNull
    private final TestingUtils testingUtils;

    public GoogleAnalyticsTrackingPlatform(@NotNull Context context2, @NotNull CommonAttributes commonAttributes2, @NotNull TestingUtils testingUtils2, @NotNull Firebase firebase2, @NotNull FlutterMigrationTools flutterMigrationTools, @NotNull TalabatPerseusRepository talabatPerseusRepository) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(commonAttributes2, "commonAttributes");
        Intrinsics.checkNotNullParameter(testingUtils2, "testingUtils");
        Intrinsics.checkNotNullParameter(firebase2, "firebase");
        Intrinsics.checkNotNullParameter(flutterMigrationTools, "migrationTools");
        Intrinsics.checkNotNullParameter(talabatPerseusRepository, "perseusRepository");
        this.context = context2;
        this.commonAttributes = commonAttributes2;
        this.testingUtils = testingUtils2;
        this.f56005firebase = firebase2;
        this.migrationTools = flutterMigrationTools;
        this.perseusRepository = talabatPerseusRepository;
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
        map.put(ConstantsKt.DEEPLINK_UTM_CAMPAIGN, this.commonAttributes.getDeeplinkCampaign());
        map.put("campaign", this.commonAttributes.getDeeplinkCampaign());
        map.put(ConstantsKt.DEEPLINK_UTM_MEDIUM, this.commonAttributes.getDeeplinkMedium());
        map.put("medium", this.commonAttributes.getDeeplinkMedium());
        map.put(ConstantsKt.DEEPLINK_UTM_CONTENT, this.commonAttributes.getDeeplinkContent());
        map.put(ConstantsKt.DEEPLINK_UTM_ID, this.commonAttributes.getDeeplinkId());
        map.put(ConstantsKt.DEEPLINK_UTM_TERM, this.commonAttributes.getDeeplinkTerm());
        map.put("deeplink", this.commonAttributes.getDeeplinkQuery());
    }

    private final void addPerseusAnalyticsAttributes(Map<String, Object> map) {
        map.put(this.perseusRepository.getPerseusClientIdKey(), this.perseusRepository.getMyClientId());
        map.put(this.perseusRepository.getPerseusSessionIdKey(), this.perseusRepository.getMySessionId());
        map.put(this.perseusRepository.getPerseusHitMatchIdKey(), this.perseusRepository.getPerseusHitMatchId());
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
        map.put(ConstantsKt.GOOGLE_AD_ID, this.commonAttributes.getGoogleAdId());
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

    private final void sendToFirebaseDatabase(String str, Map<String, ? extends Object> map) {
        String str2;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap hashMap = new HashMap();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                str2 = value.toString();
            } else {
                str2 = null;
            }
            hashMap.put(key, str2);
            arrayList.add(hashMap);
        }
        this.f56005firebase.pushToDatabase(this.testingUtils.loggingKey(), StringsKt__StringsJVMKt.replace$default(str, RealDiscoveryConfigurationRepository.VERSION_DELIMETER, JavaConstant.Dynamic.DEFAULT_NAME, false, 4, (Object) null), arrayList);
    }

    @NotNull
    public Map<String, Object> getCommonAttributes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        addSessionInfoAttributes(linkedHashMap);
        addDeeplinkInfoAttributes(linkedHashMap);
        addAdjustInfoAttributes(linkedHashMap);
        addPreReleaseVersion(linkedHashMap);
        addPerseusAnalyticsAttributes(linkedHashMap);
        return linkedHashMap;
    }

    public void track(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        String str2 = "Sending " + str + " with params " + map + " and userId " + this.commonAttributes.getUserId();
        LogManager.debug(str2);
        this.f56005firebase.setUserId(this.commonAttributes.getUserId());
        this.migrationTools.logGaEvent(str, map);
        Map<String, Object> removeMigrationParameters = this.migrationTools.removeMigrationParameters(str, map);
        if (this.testingUtils.isAutomationProcess()) {
            this.testingUtils.setLogEventForAutomation(str, removeMigrationParameters);
        }
        this.f56005firebase.logEvent(str, removeMigrationParameters);
        this.testingUtils.updateEventsTracker(str, removeMigrationParameters, str2);
        if (this.testingUtils.isLoggingEnabled()) {
            sendToFirebaseDatabase(str, removeMigrationParameters);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoogleAnalyticsTrackingPlatform(Context context2, CommonAttributes commonAttributes2, TestingUtils testingUtils2, Firebase firebase2, FlutterMigrationTools flutterMigrationTools, TalabatPerseusRepository talabatPerseusRepository, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, commonAttributes2, testingUtils2, (i11 & 8) != 0 ? new Firebase(context2) : firebase2, flutterMigrationTools, talabatPerseusRepository);
    }
}
