package com.adjust.sdk;

import android.text.TextUtils;
import com.deliveryhero.customerchat.eventTracking.constants.UserPropertyKeys;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeTracer;
import com.facebook.internal.NativeProtocol;
import com.huawei.wearengine.common.Constants;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.model.State;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import com.visa.checkout.Profile;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@Instrumented
public class PackageBuilder {
    private static ILogger logger = AdjustFactory.getLogger();
    private a activityStateCopy;
    private AdjustConfig adjustConfig;
    public AdjustAttribution attribution;
    public long clickTimeInMilliseconds = -1;
    public long clickTimeInSeconds = -1;
    public long clickTimeServerInSeconds = -1;
    private long createdAt;
    public String deeplink;
    private a deviceInfo;
    public Map<String, String> extraParameters;
    public Boolean googlePlayInstant;
    public long installBeginTimeInSeconds = -1;
    public long installBeginTimeServerInSeconds = -1;
    public String installVersion;
    public String preinstallLocation;
    public String preinstallPayload;
    public String rawReferrer;
    public String referrer;
    public String referrerApi;
    public String reftag;
    private SessionParameters sessionParameters;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f39933a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f39934b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f39935c = -1;

        /* renamed from: d  reason: collision with root package name */
        public long f39936d = -1;

        /* renamed from: e  reason: collision with root package name */
        public long f39937e = -1;

        /* renamed from: f  reason: collision with root package name */
        public long f39938f = -1;

        /* renamed from: g  reason: collision with root package name */
        public String f39939g = null;

        /* renamed from: h  reason: collision with root package name */
        public String f39940h = null;

        public a(ActivityState activityState) {
            if (activityState != null) {
                this.f39933a = activityState.eventCount;
                this.f39934b = activityState.sessionCount;
                this.f39935c = activityState.subsessionCount;
                this.f39936d = activityState.timeSpent;
                this.f39937e = activityState.lastInterval;
                this.f39938f = activityState.sessionLength;
                this.f39939g = activityState.uuid;
                this.f39940h = activityState.pushToken;
            }
        }
    }

    public PackageBuilder(AdjustConfig adjustConfig2, a aVar, ActivityState activityState, SessionParameters sessionParameters2, long j11) {
        this.createdAt = j11;
        this.deviceInfo = aVar;
        this.adjustConfig = adjustConfig2;
        this.activityStateCopy = new a(activityState);
        this.sessionParameters = sessionParameters2;
    }

    public static void addBoolean(Map<String, String> map, String str, Boolean bool) {
        if (bool != null) {
            addLong(map, str, bool.booleanValue() ? 1 : 0);
        }
    }

    private static void addDate(Map<String, String> map, String str, Date date) {
        if (date != null) {
            addString(map, str, Util.dateFormatter.format(date));
        }
    }

    private static void addDateInMilliseconds(Map<String, String> map, String str, long j11) {
        if (j11 > 0) {
            addDate(map, str, new Date(j11));
        }
    }

    private static void addDateInSeconds(Map<String, String> map, String str, long j11) {
        if (j11 > 0) {
            addDate(map, str, new Date(j11 * 1000));
        }
    }

    private static void addDouble(Map<String, String> map, String str, Double d11) {
        if (d11 != null) {
            addString(map, str, Util.formatString("%.5f", d11));
        }
    }

    private static void addDoubleWithoutRounding(Map<String, String> map, String str, Double d11) {
        if (d11 != null) {
            addString(map, str, Double.toString(d11.doubleValue()));
        }
    }

    private static void addDuration(Map<String, String> map, String str, long j11) {
        if (j11 >= 0) {
            addLong(map, str, (j11 + 500) / 1000);
        }
    }

    private static void addInteger(Map<String, String> map, String str, Integer num) {
        if (num != null) {
            addString(map, str, Integer.toString(num.intValue()));
        }
    }

    public static void addJsonObject(Map<String, String> map, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            addString(map, str, JSONObjectInstrumentation.toString(jSONObject));
        }
    }

    public static void addLong(Map<String, String> map, String str, long j11) {
        if (j11 >= 0) {
            addString(map, str, Long.toString(j11));
        }
    }

    public static void addMapJson(Map<String, String> map, String str, Map map2) {
        if (map2 != null && map2.size() != 0) {
            addString(map, str, JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) map2)));
        }
    }

    public static void addString(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private void checkDeviceIds(Map<String, String> map) {
        if (map != null && !map.containsKey("android_id") && !map.containsKey("gps_adid") && !map.containsKey("fire_adid") && !map.containsKey("oaid") && !map.containsKey("imei") && !map.containsKey("meid") && !map.containsKey("device_id") && !map.containsKey("imeis") && !map.containsKey("meids") && !map.containsKey("device_ids")) {
            if (this.adjustConfig.coppaCompliantEnabled) {
                logger.info("Missing Device IDs. COPPA enabled.", new Object[0]);
            } else {
                logger.error("Missing Device IDs. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
            }
        }
    }

    private boolean containsFireIds(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return map.containsKey("fire_adid");
    }

    private boolean containsPlayIds(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return map.containsKey("gps_adid");
    }

    private Map<String, String> getAdRevenueParameters(AdjustAdRevenue adjustAdRevenue, boolean z11) {
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Util.getImeiParameters(this.adjustConfig, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Util.getOaidParameters(this.adjustConfig, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        if (!z11) {
            addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.sessionParameters.callbackParameters, adjustAdRevenue.callbackParameters, "Callback"));
            addMapJson(hashMap, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.sessionParameters.partnerParameters, adjustAdRevenue.partnerParameters, "Partner"));
        }
        this.deviceInfo.b(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f39939g);
        addString(hashMap, "gps_adid", this.deviceInfo.f39966a);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.f39968c);
        addString(hashMap, "gps_adid_src", this.deviceInfo.f39967b);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.f39969d);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(this.adjustConfig));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(this.adjustConfig));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.a(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.f39971f);
        }
        addString(hashMap, "api_level", this.deviceInfo.f39981p);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.f39975j);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addLong(hashMap, "connectivity_type", (long) Util.getConnectivityType(this.adjustConfig.context));
        addString(hashMap, "country", this.deviceInfo.f39983r);
        addString(hashMap, "cpu_type", this.deviceInfo.f39990y);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addString(hashMap, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, UserPropertyKeys.DEVICE_MANUFACTURER, this.deviceInfo.f39978m);
        addString(hashMap, UserPropertyKeys.DEVICE_NAME, this.deviceInfo.f39977l);
        addString(hashMap, UserPropertyKeys.DEVICE_TYPE, this.deviceInfo.f39976k);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.C);
        addString(hashMap, "display_height", this.deviceInfo.f39988w);
        addString(hashMap, "display_width", this.deviceInfo.f39987v);
        addString(hashMap, Profile.ENVIRONMENT, this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.f39972g);
        addString(hashMap, "hardware_name", this.deviceInfo.f39989x);
        addString(hashMap, "installed_at", this.deviceInfo.A);
        addString(hashMap, ConstantsKt.ADJUST_LANGUAGE, this.deviceInfo.f39982q);
        addDuration(hashMap, "last_interval", this.activityStateCopy.f39937e);
        addString(hashMap, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(hashMap, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.f39991z);
        addString(hashMap, "os_name", this.deviceInfo.f39979n);
        addString(hashMap, UserPropertyKeys.OS_VERSION, this.deviceInfo.f39980o);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.f39974i);
        addString(hashMap, State.KEY_PUSH_TOKEN, this.activityStateCopy.f39940h);
        addString(hashMap, RichContentLoadTimeTracer.SCREEN_DENSITY_ATTR, this.deviceInfo.f39986u);
        addString(hashMap, "screen_format", this.deviceInfo.f39985t);
        addString(hashMap, State.KEY_SCREEN_SIZE, this.deviceInfo.f39984s);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addString(hashMap, "source", adjustAdRevenue.source);
        addDoubleWithoutRounding(hashMap, "revenue", adjustAdRevenue.revenue);
        addString(hashMap, "currency", adjustAdRevenue.currency);
        addInteger(hashMap, "ad_impressions_count", adjustAdRevenue.adImpressionsCount);
        addString(hashMap, "ad_revenue_network", adjustAdRevenue.adRevenueNetwork);
        addString(hashMap, "ad_revenue_unit", adjustAdRevenue.adRevenueUnit);
        addString(hashMap, "ad_revenue_placement", adjustAdRevenue.adRevenuePlacement);
        addLong(hashMap, InstabugDbContract.UserEntity.COLUMN_SESSION_COUNT, (long) this.activityStateCopy.f39934b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f39938f);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f39935c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f39936d);
        addString(hashMap, "updated_at", this.deviceInfo.B);
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getAdRevenueParameters(String str, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Util.getImeiParameters(this.adjustConfig, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Util.getOaidParameters(this.adjustConfig, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.b(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f39939g);
        addString(hashMap, "gps_adid", this.deviceInfo.f39966a);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.f39968c);
        addString(hashMap, "gps_adid_src", this.deviceInfo.f39967b);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.f39969d);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(this.adjustConfig));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(this.adjustConfig));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.a(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.f39971f);
        }
        addString(hashMap, "api_level", this.deviceInfo.f39981p);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.f39975j);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addLong(hashMap, "connectivity_type", (long) Util.getConnectivityType(this.adjustConfig.context));
        addString(hashMap, "country", this.deviceInfo.f39983r);
        addString(hashMap, "cpu_type", this.deviceInfo.f39990y);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addString(hashMap, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, UserPropertyKeys.DEVICE_MANUFACTURER, this.deviceInfo.f39978m);
        addString(hashMap, UserPropertyKeys.DEVICE_NAME, this.deviceInfo.f39977l);
        addString(hashMap, UserPropertyKeys.DEVICE_TYPE, this.deviceInfo.f39976k);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.C);
        addString(hashMap, "display_height", this.deviceInfo.f39988w);
        addString(hashMap, "display_width", this.deviceInfo.f39987v);
        addString(hashMap, Profile.ENVIRONMENT, this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.f39972g);
        addString(hashMap, "hardware_name", this.deviceInfo.f39989x);
        addString(hashMap, "installed_at", this.deviceInfo.A);
        addString(hashMap, ConstantsKt.ADJUST_LANGUAGE, this.deviceInfo.f39982q);
        addDuration(hashMap, "last_interval", this.activityStateCopy.f39937e);
        addString(hashMap, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(hashMap, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.f39991z);
        addString(hashMap, "os_name", this.deviceInfo.f39979n);
        addString(hashMap, UserPropertyKeys.OS_VERSION, this.deviceInfo.f39980o);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.f39974i);
        addString(hashMap, State.KEY_PUSH_TOKEN, this.activityStateCopy.f39940h);
        addString(hashMap, RichContentLoadTimeTracer.SCREEN_DENSITY_ATTR, this.deviceInfo.f39986u);
        addString(hashMap, "screen_format", this.deviceInfo.f39985t);
        addString(hashMap, State.KEY_SCREEN_SIZE, this.deviceInfo.f39984s);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addString(hashMap, "source", str);
        addJsonObject(hashMap, "payload", jSONObject);
        addLong(hashMap, InstabugDbContract.UserEntity.COLUMN_SESSION_COUNT, (long) this.activityStateCopy.f39934b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f39938f);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f39935c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f39936d);
        addString(hashMap, "updated_at", this.deviceInfo.B);
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getAttributionParameters(String str) {
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Util.getImeiParameters(this.adjustConfig, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Util.getOaidParameters(this.adjustConfig, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.b(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f39939g);
        addString(hashMap, "gps_adid", this.deviceInfo.f39966a);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.f39968c);
        addString(hashMap, "gps_adid_src", this.deviceInfo.f39967b);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.f39969d);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(this.adjustConfig));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(this.adjustConfig));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.a(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.f39971f);
        }
        addString(hashMap, "api_level", this.deviceInfo.f39981p);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.f39975j);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, UserPropertyKeys.DEVICE_NAME, this.deviceInfo.f39977l);
        addString(hashMap, UserPropertyKeys.DEVICE_TYPE, this.deviceInfo.f39976k);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.C);
        addString(hashMap, Profile.ENVIRONMENT, this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "initiated_by", str);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_name", this.deviceInfo.f39979n);
        addString(hashMap, UserPropertyKeys.OS_VERSION, this.deviceInfo.f39980o);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.f39974i);
        addString(hashMap, State.KEY_PUSH_TOKEN, this.activityStateCopy.f39940h);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getClickParameters(String str) {
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Util.getImeiParameters(this.adjustConfig, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Util.getOaidParameters(this.adjustConfig, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.b(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f39939g);
        addString(hashMap, "gps_adid", this.deviceInfo.f39966a);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.f39968c);
        addString(hashMap, "gps_adid_src", this.deviceInfo.f39967b);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.f39969d);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(this.adjustConfig));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(this.adjustConfig));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.a(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.f39971f);
        }
        AdjustAttribution adjustAttribution = this.attribution;
        if (adjustAttribution != null) {
            addString(hashMap, "tracker", adjustAttribution.trackerName);
            addString(hashMap, "campaign", this.attribution.campaign);
            addString(hashMap, "adgroup", this.attribution.adgroup);
            addString(hashMap, "creative", this.attribution.creative);
        }
        addString(hashMap, "api_level", this.deviceInfo.f39981p);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.f39975j);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, this.sessionParameters.callbackParameters);
        addDateInMilliseconds(hashMap, "click_time", this.clickTimeInMilliseconds);
        addDateInSeconds(hashMap, "click_time", this.clickTimeInSeconds);
        addDateInSeconds(hashMap, "click_time_server", this.clickTimeServerInSeconds);
        addLong(hashMap, "connectivity_type", (long) Util.getConnectivityType(this.adjustConfig.context));
        addString(hashMap, "country", this.deviceInfo.f39983r);
        addString(hashMap, "cpu_type", this.deviceInfo.f39990y);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addString(hashMap, "deeplink", this.deeplink);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, UserPropertyKeys.DEVICE_MANUFACTURER, this.deviceInfo.f39978m);
        addString(hashMap, UserPropertyKeys.DEVICE_NAME, this.deviceInfo.f39977l);
        addString(hashMap, UserPropertyKeys.DEVICE_TYPE, this.deviceInfo.f39976k);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.C);
        addString(hashMap, "display_height", this.deviceInfo.f39988w);
        addString(hashMap, "display_width", this.deviceInfo.f39987v);
        addString(hashMap, Profile.ENVIRONMENT, this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.f39972g);
        addBoolean(hashMap, "google_play_instant", this.googlePlayInstant);
        addString(hashMap, "hardware_name", this.deviceInfo.f39989x);
        addDateInSeconds(hashMap, "install_begin_time", this.installBeginTimeInSeconds);
        addDateInSeconds(hashMap, "install_begin_time_server", this.installBeginTimeServerInSeconds);
        addString(hashMap, "install_version", this.installVersion);
        addString(hashMap, "installed_at", this.deviceInfo.A);
        addString(hashMap, ConstantsKt.ADJUST_LANGUAGE, this.deviceInfo.f39982q);
        addDuration(hashMap, "last_interval", this.activityStateCopy.f39937e);
        addString(hashMap, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(hashMap, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.f39991z);
        addString(hashMap, "os_name", this.deviceInfo.f39979n);
        addString(hashMap, UserPropertyKeys.OS_VERSION, this.deviceInfo.f39980o);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.f39974i);
        addMapJson(hashMap, NativeProtocol.WEB_DIALOG_PARAMS, this.extraParameters);
        addMapJson(hashMap, Constants.PARTNER_PARAMETERS, this.sessionParameters.partnerParameters);
        addString(hashMap, State.KEY_PUSH_TOKEN, this.activityStateCopy.f39940h);
        addString(hashMap, "raw_referrer", this.rawReferrer);
        addString(hashMap, Constants.REFERRER, this.referrer);
        addString(hashMap, "referrer_api", this.referrerApi);
        addString(hashMap, Constants.REFTAG, this.reftag);
        addString(hashMap, RichContentLoadTimeTracer.SCREEN_DENSITY_ATTR, this.deviceInfo.f39986u);
        addString(hashMap, "screen_format", this.deviceInfo.f39985t);
        addString(hashMap, State.KEY_SCREEN_SIZE, this.deviceInfo.f39984s);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addLong(hashMap, InstabugDbContract.UserEntity.COLUMN_SESSION_COUNT, (long) this.activityStateCopy.f39934b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f39938f);
        addString(hashMap, "source", str);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f39935c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f39936d);
        addString(hashMap, "updated_at", this.deviceInfo.B);
        addString(hashMap, "payload", this.preinstallPayload);
        addString(hashMap, "found_location", this.preinstallLocation);
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private ActivityPackage getDefaultActivityPackage(ActivityKind activityKind) {
        ActivityPackage activityPackage = new ActivityPackage(activityKind);
        activityPackage.setClientSdk(this.deviceInfo.f39973h);
        return activityPackage;
    }

    private Map<String, String> getDisableThirdPartySharingParameters() {
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Util.getImeiParameters(this.adjustConfig, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Util.getOaidParameters(this.adjustConfig, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.b(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f39939g);
        addString(hashMap, "gps_adid", this.deviceInfo.f39966a);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.f39968c);
        addString(hashMap, "gps_adid_src", this.deviceInfo.f39967b);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.f39969d);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(this.adjustConfig));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(this.adjustConfig));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.a(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.f39971f);
        }
        addString(hashMap, "api_level", this.deviceInfo.f39981p);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.f39975j);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, UserPropertyKeys.DEVICE_NAME, this.deviceInfo.f39977l);
        addString(hashMap, UserPropertyKeys.DEVICE_TYPE, this.deviceInfo.f39976k);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.C);
        addString(hashMap, Profile.ENVIRONMENT, this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_name", this.deviceInfo.f39979n);
        addString(hashMap, UserPropertyKeys.OS_VERSION, this.deviceInfo.f39980o);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.f39974i);
        addString(hashMap, State.KEY_PUSH_TOKEN, this.activityStateCopy.f39940h);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private String getEventSuffix(AdjustEvent adjustEvent) {
        Double d11 = adjustEvent.revenue;
        if (d11 == null) {
            return Util.formatString("'%s'", adjustEvent.eventToken);
        }
        return Util.formatString("(%.5f %s, '%s')", d11, adjustEvent.currency, adjustEvent.eventToken);
    }

    private Map<String, String> getGdprParameters() {
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Util.getImeiParameters(this.adjustConfig, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Util.getOaidParameters(this.adjustConfig, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.b(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f39939g);
        addString(hashMap, "gps_adid", this.deviceInfo.f39966a);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.f39968c);
        addString(hashMap, "gps_adid_src", this.deviceInfo.f39967b);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.f39969d);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(this.adjustConfig));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(this.adjustConfig));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.a(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.f39971f);
        }
        addString(hashMap, "api_level", this.deviceInfo.f39981p);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.f39975j);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, UserPropertyKeys.DEVICE_NAME, this.deviceInfo.f39977l);
        addString(hashMap, UserPropertyKeys.DEVICE_TYPE, this.deviceInfo.f39976k);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.C);
        addString(hashMap, Profile.ENVIRONMENT, this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_name", this.deviceInfo.f39979n);
        addString(hashMap, UserPropertyKeys.OS_VERSION, this.deviceInfo.f39980o);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.f39974i);
        addString(hashMap, State.KEY_PUSH_TOKEN, this.activityStateCopy.f39940h);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getInfoParameters(String str) {
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Util.getImeiParameters(this.adjustConfig, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Util.getOaidParameters(this.adjustConfig, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.b(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f39939g);
        addString(hashMap, "gps_adid", this.deviceInfo.f39966a);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.f39968c);
        addString(hashMap, "gps_adid_src", this.deviceInfo.f39967b);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.f39969d);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(this.adjustConfig));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(this.adjustConfig));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.a(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.f39971f);
        }
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, this.adjustConfig.appToken);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, Profile.ENVIRONMENT, this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, State.KEY_PUSH_TOKEN, this.activityStateCopy.f39940h);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addString(hashMap, "source", str);
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getMeasurementConsentParameters(boolean z11) {
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Util.getImeiParameters(this.adjustConfig, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Util.getOaidParameters(this.adjustConfig, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        addString(hashMap, "measurement", z11 ? "enable" : "disable");
        this.deviceInfo.b(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f39939g);
        addString(hashMap, "gps_adid", this.deviceInfo.f39966a);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.f39968c);
        addString(hashMap, "gps_adid_src", this.deviceInfo.f39967b);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.f39969d);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(this.adjustConfig));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(this.adjustConfig));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.a(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.f39971f);
        }
        addString(hashMap, "api_level", this.deviceInfo.f39981p);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.f39975j);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addString(hashMap, UserPropertyKeys.DEVICE_NAME, this.deviceInfo.f39977l);
        addString(hashMap, UserPropertyKeys.DEVICE_TYPE, this.deviceInfo.f39976k);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.C);
        addString(hashMap, Profile.ENVIRONMENT, this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_name", this.deviceInfo.f39979n);
        addString(hashMap, UserPropertyKeys.OS_VERSION, this.deviceInfo.f39980o);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.f39974i);
        addString(hashMap, State.KEY_PUSH_TOKEN, this.activityStateCopy.f39940h);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getSessionParameters(boolean z11) {
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Util.getImeiParameters(this.adjustConfig, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Util.getOaidParameters(this.adjustConfig, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        if (!z11) {
            addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, this.sessionParameters.callbackParameters);
            addMapJson(hashMap, Constants.PARTNER_PARAMETERS, this.sessionParameters.partnerParameters);
        }
        this.deviceInfo.b(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f39939g);
        addString(hashMap, "gps_adid", this.deviceInfo.f39966a);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.f39968c);
        addString(hashMap, "gps_adid_src", this.deviceInfo.f39967b);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.f39969d);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(this.adjustConfig));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(this.adjustConfig));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.a(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.f39971f);
        }
        addString(hashMap, "api_level", this.deviceInfo.f39981p);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.f39975j);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addLong(hashMap, "connectivity_type", (long) Util.getConnectivityType(this.adjustConfig.context));
        addString(hashMap, "country", this.deviceInfo.f39983r);
        addString(hashMap, "cpu_type", this.deviceInfo.f39990y);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addString(hashMap, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, UserPropertyKeys.DEVICE_MANUFACTURER, this.deviceInfo.f39978m);
        addString(hashMap, UserPropertyKeys.DEVICE_NAME, this.deviceInfo.f39977l);
        addString(hashMap, UserPropertyKeys.DEVICE_TYPE, this.deviceInfo.f39976k);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.C);
        addString(hashMap, "display_height", this.deviceInfo.f39988w);
        addString(hashMap, "display_width", this.deviceInfo.f39987v);
        addString(hashMap, Profile.ENVIRONMENT, this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.f39972g);
        addString(hashMap, "hardware_name", this.deviceInfo.f39989x);
        addString(hashMap, "installed_at", this.deviceInfo.A);
        addString(hashMap, ConstantsKt.ADJUST_LANGUAGE, this.deviceInfo.f39982q);
        addDuration(hashMap, "last_interval", this.activityStateCopy.f39937e);
        addString(hashMap, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(hashMap, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.f39991z);
        addString(hashMap, "os_name", this.deviceInfo.f39979n);
        addString(hashMap, UserPropertyKeys.OS_VERSION, this.deviceInfo.f39980o);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.f39974i);
        addString(hashMap, State.KEY_PUSH_TOKEN, this.activityStateCopy.f39940h);
        addString(hashMap, RichContentLoadTimeTracer.SCREEN_DENSITY_ATTR, this.deviceInfo.f39986u);
        addString(hashMap, "screen_format", this.deviceInfo.f39985t);
        addString(hashMap, State.KEY_SCREEN_SIZE, this.deviceInfo.f39984s);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addLong(hashMap, InstabugDbContract.UserEntity.COLUMN_SESSION_COUNT, (long) this.activityStateCopy.f39934b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f39938f);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f39935c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f39936d);
        addString(hashMap, "updated_at", this.deviceInfo.B);
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getSubscriptionParameters(AdjustPlayStoreSubscription adjustPlayStoreSubscription, boolean z11) {
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Util.getImeiParameters(this.adjustConfig, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Util.getOaidParameters(this.adjustConfig, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        this.deviceInfo.b(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f39939g);
        addString(hashMap, "gps_adid", this.deviceInfo.f39966a);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.f39968c);
        addString(hashMap, "gps_adid_src", this.deviceInfo.f39967b);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.f39969d);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(this.adjustConfig));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(this.adjustConfig));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.a(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.f39971f);
        }
        if (!z11) {
            addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.sessionParameters.callbackParameters, adjustPlayStoreSubscription.getCallbackParameters(), "Callback"));
            addMapJson(hashMap, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.sessionParameters.partnerParameters, adjustPlayStoreSubscription.getPartnerParameters(), "Partner"));
        }
        addString(hashMap, "api_level", this.deviceInfo.f39981p);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.f39975j);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addLong(hashMap, "connectivity_type", (long) Util.getConnectivityType(this.adjustConfig.context));
        addString(hashMap, "country", this.deviceInfo.f39983r);
        addString(hashMap, "cpu_type", this.deviceInfo.f39990y);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addString(hashMap, "default_tracker", this.adjustConfig.defaultTracker);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, UserPropertyKeys.DEVICE_MANUFACTURER, this.deviceInfo.f39978m);
        addString(hashMap, UserPropertyKeys.DEVICE_NAME, this.deviceInfo.f39977l);
        addString(hashMap, UserPropertyKeys.DEVICE_TYPE, this.deviceInfo.f39976k);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.C);
        addString(hashMap, "display_height", this.deviceInfo.f39988w);
        addString(hashMap, "display_width", this.deviceInfo.f39987v);
        addString(hashMap, Profile.ENVIRONMENT, this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.f39972g);
        addString(hashMap, "hardware_name", this.deviceInfo.f39989x);
        addString(hashMap, "installed_at", this.deviceInfo.A);
        addString(hashMap, ConstantsKt.ADJUST_LANGUAGE, this.deviceInfo.f39982q);
        addDuration(hashMap, "last_interval", this.activityStateCopy.f39937e);
        addString(hashMap, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(hashMap, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.f39991z);
        addString(hashMap, "os_name", this.deviceInfo.f39979n);
        addString(hashMap, UserPropertyKeys.OS_VERSION, this.deviceInfo.f39980o);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.f39974i);
        addString(hashMap, State.KEY_PUSH_TOKEN, this.activityStateCopy.f39940h);
        addString(hashMap, RichContentLoadTimeTracer.SCREEN_DENSITY_ATTR, this.deviceInfo.f39986u);
        addString(hashMap, "screen_format", this.deviceInfo.f39985t);
        addString(hashMap, State.KEY_SCREEN_SIZE, this.deviceInfo.f39984s);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addLong(hashMap, InstabugDbContract.UserEntity.COLUMN_SESSION_COUNT, (long) this.activityStateCopy.f39934b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f39938f);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f39935c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f39936d);
        addString(hashMap, "updated_at", this.deviceInfo.B);
        addString(hashMap, "billing_store", adjustPlayStoreSubscription.getBillingStore());
        addString(hashMap, "currency", adjustPlayStoreSubscription.getCurrency());
        addString(hashMap, TalabatCommonUrlConstantsKt.PRODUCT_ID, adjustPlayStoreSubscription.getSku());
        addString(hashMap, "purchase_token", adjustPlayStoreSubscription.getPurchaseToken());
        addString(hashMap, "receipt", adjustPlayStoreSubscription.getSignature());
        addLong(hashMap, "revenue", adjustPlayStoreSubscription.getPrice());
        addDateInMilliseconds(hashMap, "transaction_date", adjustPlayStoreSubscription.getPurchaseTime());
        addString(hashMap, "transaction_id", adjustPlayStoreSubscription.getOrderId());
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private Map<String, String> getThirdPartySharingParameters(AdjustThirdPartySharing adjustThirdPartySharing) {
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Util.getImeiParameters(this.adjustConfig, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Util.getOaidParameters(this.adjustConfig, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        Boolean bool = adjustThirdPartySharing.isEnabled;
        if (bool != null) {
            addString(hashMap, "sharing", bool.booleanValue() ? "enable" : "disable");
        }
        addMapJson(hashMap, "granular_third_party_sharing_options", adjustThirdPartySharing.granularOptions);
        addMapJson(hashMap, "partner_sharing_settings", adjustThirdPartySharing.partnerSharingSettings);
        this.deviceInfo.b(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f39939g);
        addString(hashMap, "gps_adid", this.deviceInfo.f39966a);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.f39968c);
        addString(hashMap, "gps_adid_src", this.deviceInfo.f39967b);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.f39969d);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(this.adjustConfig));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(this.adjustConfig));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.a(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.f39971f);
        }
        addString(hashMap, "api_level", this.deviceInfo.f39981p);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.f39975j);
        Boolean bool2 = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool2);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addString(hashMap, UserPropertyKeys.DEVICE_NAME, this.deviceInfo.f39977l);
        addString(hashMap, UserPropertyKeys.DEVICE_TYPE, this.deviceInfo.f39976k);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.C);
        addString(hashMap, Profile.ENVIRONMENT, this.adjustConfig.environment);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addBoolean(hashMap, "needs_response_details", bool2);
        addString(hashMap, "os_name", this.deviceInfo.f39979n);
        addString(hashMap, UserPropertyKeys.OS_VERSION, this.deviceInfo.f39980o);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.f39974i);
        addString(hashMap, State.KEY_PUSH_TOKEN, this.activityStateCopy.f39940h);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }

    private void injectFeatureFlagsWithParameters(Map<String, String> map) {
        if (this.adjustConfig.coppaCompliantEnabled) {
            addLong(map, "ff_coppa", 1);
        }
        if (this.adjustConfig.playStoreKidsAppEnabled) {
            addLong(map, "ff_play_store_kids_app", 1);
        }
    }

    public ActivityPackage buildAdRevenuePackage(AdjustAdRevenue adjustAdRevenue, boolean z11) {
        Map<String, String> adRevenueParameters = getAdRevenueParameters(adjustAdRevenue, z11);
        ActivityKind activityKind = ActivityKind.AD_REVENUE;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/ad_revenue");
        defaultActivityPackage.setSuffix("");
        String activityKind2 = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        AdjustSigner.sign(adRevenueParameters, activityKind2, clientSdk, adjustConfig2.context, adjustConfig2.logger);
        defaultActivityPackage.setParameters(adRevenueParameters);
        if (z11) {
            defaultActivityPackage.setCallbackParameters(adjustAdRevenue.callbackParameters);
            defaultActivityPackage.setPartnerParameters(adjustAdRevenue.partnerParameters);
        }
        return defaultActivityPackage;
    }

    public ActivityPackage buildAdRevenuePackage(String str, JSONObject jSONObject) {
        Map<String, String> adRevenueParameters = getAdRevenueParameters(str, jSONObject);
        ActivityKind activityKind = ActivityKind.AD_REVENUE;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/ad_revenue");
        defaultActivityPackage.setSuffix("");
        String activityKind2 = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        AdjustSigner.sign(adRevenueParameters, activityKind2, clientSdk, adjustConfig2.context, adjustConfig2.logger);
        defaultActivityPackage.setParameters(adRevenueParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildAttributionPackage(String str) {
        Map<String, String> attributionParameters = getAttributionParameters(str);
        ActivityKind activityKind = ActivityKind.ATTRIBUTION;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("attribution");
        defaultActivityPackage.setSuffix("");
        String activityKind2 = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        AdjustSigner.sign(attributionParameters, activityKind2, clientSdk, adjustConfig2.context, adjustConfig2.logger);
        defaultActivityPackage.setParameters(attributionParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildClickPackage(String str) {
        Map<String, String> clickParameters = getClickParameters(str);
        ActivityKind activityKind = ActivityKind.CLICK;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/sdk_click");
        defaultActivityPackage.setSuffix("");
        defaultActivityPackage.setClickTimeInMilliseconds(this.clickTimeInMilliseconds);
        defaultActivityPackage.setClickTimeInSeconds(this.clickTimeInSeconds);
        defaultActivityPackage.setInstallBeginTimeInSeconds(this.installBeginTimeInSeconds);
        defaultActivityPackage.setClickTimeServerInSeconds(this.clickTimeServerInSeconds);
        defaultActivityPackage.setInstallBeginTimeServerInSeconds(this.installBeginTimeServerInSeconds);
        defaultActivityPackage.setInstallVersion(this.installVersion);
        defaultActivityPackage.setGooglePlayInstant(this.googlePlayInstant);
        String activityKind2 = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        AdjustSigner.sign(clickParameters, activityKind2, clientSdk, adjustConfig2.context, adjustConfig2.logger);
        defaultActivityPackage.setParameters(clickParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildDisableThirdPartySharingPackage() {
        Map<String, String> disableThirdPartySharingParameters = getDisableThirdPartySharingParameters();
        ActivityKind activityKind = ActivityKind.DISABLE_THIRD_PARTY_SHARING;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/disable_third_party_sharing");
        defaultActivityPackage.setSuffix("");
        String activityKind2 = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        AdjustSigner.sign(disableThirdPartySharingParameters, activityKind2, clientSdk, adjustConfig2.context, adjustConfig2.logger);
        defaultActivityPackage.setParameters(disableThirdPartySharingParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildEventPackage(AdjustEvent adjustEvent, boolean z11) {
        Map<String, String> eventParameters = getEventParameters(adjustEvent, z11);
        ActivityKind activityKind = ActivityKind.EVENT;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/event");
        defaultActivityPackage.setSuffix(getEventSuffix(adjustEvent));
        String activityKind2 = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        AdjustSigner.sign(eventParameters, activityKind2, clientSdk, adjustConfig2.context, adjustConfig2.logger);
        defaultActivityPackage.setParameters(eventParameters);
        if (z11) {
            defaultActivityPackage.setCallbackParameters(adjustEvent.callbackParameters);
            defaultActivityPackage.setPartnerParameters(adjustEvent.partnerParameters);
        }
        return defaultActivityPackage;
    }

    public ActivityPackage buildGdprPackage() {
        Map<String, String> gdprParameters = getGdprParameters();
        ActivityKind activityKind = ActivityKind.GDPR;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/gdpr_forget_device");
        defaultActivityPackage.setSuffix("");
        String activityKind2 = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        AdjustSigner.sign(gdprParameters, activityKind2, clientSdk, adjustConfig2.context, adjustConfig2.logger);
        defaultActivityPackage.setParameters(gdprParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildInfoPackage(String str) {
        Map<String, String> infoParameters = getInfoParameters(str);
        ActivityKind activityKind = ActivityKind.INFO;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/sdk_info");
        defaultActivityPackage.setSuffix("");
        String activityKind2 = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        AdjustSigner.sign(infoParameters, activityKind2, clientSdk, adjustConfig2.context, adjustConfig2.logger);
        defaultActivityPackage.setParameters(infoParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildMeasurementConsentPackage(boolean z11) {
        Map<String, String> measurementConsentParameters = getMeasurementConsentParameters(z11);
        ActivityKind activityKind = ActivityKind.MEASUREMENT_CONSENT;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/measurement_consent");
        defaultActivityPackage.setSuffix("");
        String activityKind2 = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        AdjustSigner.sign(measurementConsentParameters, activityKind2, clientSdk, adjustConfig2.context, adjustConfig2.logger);
        defaultActivityPackage.setParameters(measurementConsentParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildSessionPackage(boolean z11) {
        Map<String, String> sessionParameters2 = getSessionParameters(z11);
        ActivityKind activityKind = ActivityKind.SESSION;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/session");
        defaultActivityPackage.setSuffix("");
        String activityKind2 = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        AdjustSigner.sign(sessionParameters2, activityKind2, clientSdk, adjustConfig2.context, adjustConfig2.logger);
        defaultActivityPackage.setParameters(sessionParameters2);
        return defaultActivityPackage;
    }

    public ActivityPackage buildSubscriptionPackage(AdjustPlayStoreSubscription adjustPlayStoreSubscription, boolean z11) {
        Map<String, String> subscriptionParameters = getSubscriptionParameters(adjustPlayStoreSubscription, z11);
        ActivityKind activityKind = ActivityKind.SUBSCRIPTION;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/v2/purchase");
        defaultActivityPackage.setSuffix("");
        String activityKind2 = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        AdjustSigner.sign(subscriptionParameters, activityKind2, clientSdk, adjustConfig2.context, adjustConfig2.logger);
        defaultActivityPackage.setParameters(subscriptionParameters);
        return defaultActivityPackage;
    }

    public ActivityPackage buildThirdPartySharingPackage(AdjustThirdPartySharing adjustThirdPartySharing) {
        Map<String, String> thirdPartySharingParameters = getThirdPartySharingParameters(adjustThirdPartySharing);
        ActivityKind activityKind = ActivityKind.THIRD_PARTY_SHARING;
        ActivityPackage defaultActivityPackage = getDefaultActivityPackage(activityKind);
        defaultActivityPackage.setPath("/third_party_sharing");
        defaultActivityPackage.setSuffix("");
        String activityKind2 = activityKind.toString();
        String clientSdk = defaultActivityPackage.getClientSdk();
        AdjustConfig adjustConfig2 = this.adjustConfig;
        AdjustSigner.sign(thirdPartySharingParameters, activityKind2, clientSdk, adjustConfig2.context, adjustConfig2.logger);
        defaultActivityPackage.setParameters(thirdPartySharingParameters);
        return defaultActivityPackage;
    }

    public Map<String, String> getEventParameters(AdjustEvent adjustEvent, boolean z11) {
        HashMap hashMap = new HashMap();
        Map<String, String> imeiParameters = Util.getImeiParameters(this.adjustConfig, logger);
        if (imeiParameters != null) {
            hashMap.putAll(imeiParameters);
        }
        Map<String, String> oaidParameters = Util.getOaidParameters(this.adjustConfig, logger);
        if (oaidParameters != null) {
            hashMap.putAll(oaidParameters);
        }
        if (!z11) {
            addMapJson(hashMap, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(this.sessionParameters.callbackParameters, adjustEvent.callbackParameters, "Callback"));
            addMapJson(hashMap, Constants.PARTNER_PARAMETERS, Util.mergeParameters(this.sessionParameters.partnerParameters, adjustEvent.partnerParameters, "Partner"));
        }
        this.deviceInfo.b(this.adjustConfig);
        addString(hashMap, "android_uuid", this.activityStateCopy.f39939g);
        addString(hashMap, "gps_adid", this.deviceInfo.f39966a);
        addLong(hashMap, "gps_adid_attempt", (long) this.deviceInfo.f39968c);
        addString(hashMap, "gps_adid_src", this.deviceInfo.f39967b);
        addBoolean(hashMap, "tracking_enabled", this.deviceInfo.f39969d);
        addString(hashMap, "fire_adid", Util.getFireAdvertisingId(this.adjustConfig));
        addBoolean(hashMap, "fire_tracking_enabled", Util.getFireTrackingEnabled(this.adjustConfig));
        if (!containsPlayIds(hashMap) && !containsFireIds(hashMap)) {
            logger.warn("Google Advertising ID or Fire Advertising ID not detected, fallback to non Google Play and Fire identifiers will take place", new Object[0]);
            this.deviceInfo.a(this.adjustConfig);
            addString(hashMap, "android_id", this.deviceInfo.f39971f);
        }
        addString(hashMap, "api_level", this.deviceInfo.f39981p);
        addString(hashMap, "app_secret", this.adjustConfig.appSecret);
        addString(hashMap, InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, this.adjustConfig.appToken);
        addString(hashMap, "app_version", this.deviceInfo.f39975j);
        Boolean bool = Boolean.TRUE;
        addBoolean(hashMap, "attribution_deeplink", bool);
        addLong(hashMap, "connectivity_type", (long) Util.getConnectivityType(this.adjustConfig.context));
        addString(hashMap, "country", this.deviceInfo.f39983r);
        addString(hashMap, "cpu_type", this.deviceInfo.f39990y);
        addDateInMilliseconds(hashMap, "created_at", this.createdAt);
        addString(hashMap, "currency", adjustEvent.currency);
        addBoolean(hashMap, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(hashMap, "needs_cost", this.adjustConfig.needsCost);
        addString(hashMap, UserPropertyKeys.DEVICE_MANUFACTURER, this.deviceInfo.f39978m);
        addString(hashMap, UserPropertyKeys.DEVICE_NAME, this.deviceInfo.f39977l);
        addString(hashMap, UserPropertyKeys.DEVICE_TYPE, this.deviceInfo.f39976k);
        addLong(hashMap, "ui_mode", (long) this.deviceInfo.C);
        addString(hashMap, "display_height", this.deviceInfo.f39988w);
        addString(hashMap, "display_width", this.deviceInfo.f39987v);
        addString(hashMap, Profile.ENVIRONMENT, this.adjustConfig.environment);
        addString(hashMap, "event_callback_id", adjustEvent.callbackId);
        addLong(hashMap, "event_count", (long) this.activityStateCopy.f39933a);
        addBoolean(hashMap, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(hashMap, "event_token", adjustEvent.eventToken);
        addString(hashMap, "external_device_id", this.adjustConfig.externalDeviceId);
        addString(hashMap, "fb_id", this.deviceInfo.f39972g);
        addString(hashMap, "hardware_name", this.deviceInfo.f39989x);
        addString(hashMap, ConstantsKt.ADJUST_LANGUAGE, this.deviceInfo.f39982q);
        addString(hashMap, "mcc", Util.getMcc(this.adjustConfig.context));
        addString(hashMap, "mnc", Util.getMnc(this.adjustConfig.context));
        addBoolean(hashMap, "needs_response_details", bool);
        addString(hashMap, "os_build", this.deviceInfo.f39991z);
        addString(hashMap, "os_name", this.deviceInfo.f39979n);
        addString(hashMap, UserPropertyKeys.OS_VERSION, this.deviceInfo.f39980o);
        addString(hashMap, Constants.PACKAGE_NAME, this.deviceInfo.f39974i);
        addString(hashMap, State.KEY_PUSH_TOKEN, this.activityStateCopy.f39940h);
        addDouble(hashMap, "revenue", adjustEvent.revenue);
        addString(hashMap, "deduplication_id", adjustEvent.orderId);
        addString(hashMap, RichContentLoadTimeTracer.SCREEN_DENSITY_ATTR, this.deviceInfo.f39986u);
        addString(hashMap, "screen_format", this.deviceInfo.f39985t);
        addString(hashMap, State.KEY_SCREEN_SIZE, this.deviceInfo.f39984s);
        addString(hashMap, "secret_id", this.adjustConfig.secretId);
        addLong(hashMap, InstabugDbContract.UserEntity.COLUMN_SESSION_COUNT, (long) this.activityStateCopy.f39934b);
        addDuration(hashMap, "session_length", this.activityStateCopy.f39938f);
        addLong(hashMap, "subsession_count", (long) this.activityStateCopy.f39935c);
        addDuration(hashMap, "time_spent", this.activityStateCopy.f39936d);
        injectFeatureFlagsWithParameters(hashMap);
        checkDeviceIds(hashMap);
        return hashMap;
    }
}
