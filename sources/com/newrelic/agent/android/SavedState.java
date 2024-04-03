package com.newrelic.agent.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.DataToken;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

public class SavedState extends HarvestAdapter {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final long DATA_TOKEN_TTL_MS = TimeUnit.MILLISECONDS.convert(14, TimeUnit.DAYS);
    private final String NEW_RELIC_AGENT_DISABLED_VERSION_KEY = "NewRelicAgentDisabledVersion";
    private final String PREFERENCE_FILE_PREFIX = "com.newrelic.android.agent.v1_";
    private final String PREF_ACCOUNT_ID = "account_id";
    private final String PREF_ACTIVITY_TRACE_MIN_UTILIZATION = "activityTraceMinUtilization";
    private final String PREF_AGENT_NAME = "agentName";
    private final String PREF_AGENT_VERSION = "agentVersion";
    private final String PREF_APPLICATION_ID = "application_id";
    private final String PREF_APP_BUILD = "appBuild";
    private final String PREF_APP_NAME = AnalyticsAttribute.APP_NAME_ATTRIBUTE;
    private final String PREF_APP_VERSION = "appVersion";
    private final String PREF_COLLECT_NETWORK_ERRORS = "collectNetworkErrors";
    private final String PREF_CONNECT_HASH = "connectHash";
    private final String PREF_CROSS_PROCESS_ID = "crossProcessId";
    private final String PREF_DATA_TOKEN = "dataToken";
    private final String PREF_DATA_TOKEN_EXPIRATION = "dataTokenExpiration";
    private final String PREF_DEVICE_ARCHITECTURE = "deviceArchitecture";
    private final String PREF_DEVICE_ID = "deviceId";
    private final String PREF_DEVICE_MANUFACTURER = AnalyticsAttribute.DEVICE_MANUFACTURER_ATTRIBUTE;
    private final String PREF_DEVICE_MODEL = AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE;
    private final String PREF_DEVICE_RUN_TIME = "deviceRunTime";
    private final String PREF_DEVICE_SIZE = "deviceSize";
    private final String PREF_ERROR_LIMIT = "errorLimit";
    private final String PREF_HARVEST_INTERVAL = "harvestIntervalInSeconds";
    private final String PREF_MAX_TRANSACTION_AGE = "maxTransactionAgeInSeconds";
    private final String PREF_MAX_TRANSACTION_COUNT = "maxTransactionCount";
    private final String PREF_OS_BUILD = AnalyticsAttribute.OS_BUILD_ATTRIBUTE;
    private final String PREF_OS_NAME = AnalyticsAttribute.OS_NAME_ATTRIBUTE;
    private final String PREF_OS_VERSION = AnalyticsAttribute.OS_VERSION_ATTRIBUTE;
    private final String PREF_PACKAGE_ID = "packageId";
    private final String PREF_PLATFORM = "platform";
    private final String PREF_PLATFORM_VERSION = "platformVersion";
    private final String PREF_PRIORITY_ENCODING_KEY = "encoding_key";
    private final String PREF_RESPONSE_BODY_LIMIT = "responseBodyLimit";
    private final String PREF_SERVER_TIMESTAMP = "serverTimestamp";
    private final String PREF_STACK_TRACE_LIMIT = "stackTraceLimit";
    private final String PREF_TRUSTED_ACCOUNT_KEY = "trusted_account_key";
    private final String PREF_VERSION_CODE = "versionCode";
    private Float activityTraceMinUtilization;
    private final HarvestConfiguration configuration = new HarvestConfiguration();
    private final ConnectInformation connectInformation = new ConnectInformation(new ApplicationInformation(), new DeviceInformation());
    private final SharedPreferences.Editor editor;
    private final Lock lock = new ReentrantLock();
    private final SharedPreferences prefs;

    @SuppressLint({"CommitPrefEdits"})
    public SavedState(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(getPreferenceFileName(context.getPackageName()), 0);
        this.prefs = sharedPreferences;
        this.editor = sharedPreferences.edit();
        loadHarvestConfiguration();
        loadConnectInformation();
    }

    private String getPreferenceFileName(String str) {
        return "com.newrelic.android.agent.v1_" + str;
    }

    private void saveApplicationInformation(ApplicationInformation applicationInformation) {
        save(AnalyticsAttribute.APP_NAME_ATTRIBUTE, applicationInformation.getAppName());
        save("appVersion", applicationInformation.getAppVersion());
        save("appBuild", applicationInformation.getAppBuild());
        save("packageId", applicationInformation.getPackageId());
        save("versionCode", applicationInformation.getVersionCode());
    }

    private void saveDeviceInformation(DeviceInformation deviceInformation) {
        save("agentName", deviceInformation.getAgentName());
        save("agentVersion", deviceInformation.getAgentVersion());
        save("deviceArchitecture", deviceInformation.getArchitecture());
        save("deviceId", deviceInformation.getDeviceId());
        save(AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE, deviceInformation.getModel());
        save(AnalyticsAttribute.DEVICE_MANUFACTURER_ATTRIBUTE, deviceInformation.getManufacturer());
        save("deviceRunTime", deviceInformation.getRunTime());
        save("deviceSize", deviceInformation.getSize());
        save(AnalyticsAttribute.OS_NAME_ATTRIBUTE, deviceInformation.getOsName());
        save(AnalyticsAttribute.OS_BUILD_ATTRIBUTE, deviceInformation.getOsBuild());
        save(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, deviceInformation.getOsVersion());
        save("platform", deviceInformation.getApplicationFramework().toString());
        save("platformVersion", deviceInformation.getApplicationFrameworkVersion());
    }

    public void clear() {
        this.lock.lock();
        try {
            this.editor.clear();
            this.editor.apply();
            this.configuration.setDefaultValues();
        } finally {
            this.lock.unlock();
        }
    }

    public String getAccountId() {
        return getString("account_id");
    }

    public float getActivityTraceMinUtilization() {
        if (this.activityTraceMinUtilization == null) {
            this.activityTraceMinUtilization = getFloat("activityTraceMinUtilization");
        }
        return this.activityTraceMinUtilization.floatValue();
    }

    public String getAgentName() {
        return getString("agentName");
    }

    public String getAgentVersion() {
        return getString("agentVersion");
    }

    public String getAppBuild() {
        return getString("appBuild");
    }

    public String getAppName() {
        return getString(AnalyticsAttribute.APP_NAME_ATTRIBUTE);
    }

    public String getAppVersion() {
        return getString("appVersion");
    }

    public String getApplicationFramework() {
        return getString("platform");
    }

    public String getApplicationFrameworkVersion() {
        return getString("platformVersion");
    }

    public String getApplicationId() {
        return getString("application_id");
    }

    public boolean getBoolean(String str) {
        return this.prefs.getBoolean(str, false);
    }

    public ConnectInformation getConnectInformation() {
        return this.connectInformation;
    }

    public String getConnectionToken() {
        return String.valueOf(getInt("connectHash"));
    }

    public String getCrossProcessId() {
        return getString("crossProcessId");
    }

    public int[] getDataToken() {
        int[] iArr = new int[2];
        String string = getString("dataToken");
        if (string != null && !string.isEmpty()) {
            try {
                JSONArray jSONArray = (JSONArray) new JSONTokener(string).nextValue();
                if (jSONArray == null) {
                    return null;
                }
                iArr[0] = jSONArray.getInt(0);
                iArr[1] = jSONArray.getInt(1);
                return iArr;
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public long getDataTokenTTL() {
        return this.DATA_TOKEN_TTL_MS;
    }

    public String getDeviceArchitecture() {
        return getString("deviceArchitecture");
    }

    public String getDeviceId() {
        return getString("deviceId");
    }

    public String getDeviceManufacturer() {
        return getString(AnalyticsAttribute.DEVICE_MANUFACTURER_ATTRIBUTE);
    }

    public String getDeviceModel() {
        return getString(AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE);
    }

    public String getDeviceRunTime() {
        return getString("deviceRunTime");
    }

    public String getDeviceSize() {
        return getString("deviceSize");
    }

    public String getDisabledVersion() {
        return getString("NewRelicAgentDisabledVersion");
    }

    public int getErrorLimit() {
        return getInt("errorLimit");
    }

    public Float getFloat(String str) {
        if (!this.prefs.contains(str)) {
            return null;
        }
        return Float.valueOf(((float) ((int) (this.prefs.getFloat(str, 0.0f) * 100.0f))) / 100.0f);
    }

    public ApplicationFramework getFramework() {
        try {
            return ApplicationFramework.valueOf(getString("platform"));
        } catch (IllegalArgumentException unused) {
            return ApplicationFramework.Native;
        }
    }

    public HarvestConfiguration getHarvestConfiguration() {
        return this.configuration;
    }

    public long getHarvestInterval() {
        return getLong("harvestIntervalInSeconds");
    }

    public long getHarvestIntervalInSeconds() {
        return getHarvestInterval();
    }

    public int getInt(String str) {
        return this.prefs.getInt(str, 0);
    }

    public long getLong(String str) {
        return this.prefs.getLong(str, 0);
    }

    public long getMaxTransactionAge() {
        return getLong("maxTransactionAgeInSeconds");
    }

    public long getMaxTransactionAgeInSeconds() {
        return getMaxTransactionAge();
    }

    public long getMaxTransactionCount() {
        return getLong("maxTransactionCount");
    }

    public String getOsBuild() {
        return getString(AnalyticsAttribute.OS_BUILD_ATTRIBUTE);
    }

    public String getOsName() {
        return getString(AnalyticsAttribute.OS_NAME_ATTRIBUTE);
    }

    public String getOsVersion() {
        return getString(AnalyticsAttribute.OS_VERSION_ATTRIBUTE);
    }

    public String getPackageId() {
        return getString("packageId");
    }

    public String getPlatformVersion() {
        return getString("platformVersion");
    }

    public String getPriorityEncodingKey() {
        return getString("encoding_key");
    }

    public int getResponseBodyLimit() {
        return getInt("responseBodyLimit");
    }

    public long getServerTimestamp() {
        return getLong("serverTimestamp");
    }

    public int getStackTraceLimit() {
        return getInt("stackTraceLimit");
    }

    public String getString(String str) {
        if (!this.prefs.contains(str)) {
            return null;
        }
        return this.prefs.getString(str, (String) null);
    }

    public String getTrustedAccountKey() {
        return getString("trusted_account_key");
    }

    public int getVersionCode() {
        return getInt("versionCode");
    }

    public boolean has(String str) {
        return this.prefs.contains(str);
    }

    public boolean hasConnectionToken(String str) {
        if (getInt("connectHash") == str.hashCode()) {
            return true;
        }
        return false;
    }

    public boolean isCollectingNetworkErrors() {
        return getBoolean("collectNetworkErrors");
    }

    public void loadConnectInformation() {
        ApplicationInformation applicationInformation = new ApplicationInformation();
        if (has(AnalyticsAttribute.APP_NAME_ATTRIBUTE)) {
            applicationInformation.setAppName(getAppName());
        }
        if (has("appVersion")) {
            applicationInformation.setAppVersion(getAppVersion());
        }
        if (has("appBuild")) {
            applicationInformation.setAppBuild(getAppBuild());
        }
        if (has("packageId")) {
            applicationInformation.setPackageId(getPackageId());
        }
        if (has("versionCode")) {
            applicationInformation.setVersionCode(getVersionCode());
        }
        DeviceInformation deviceInformation = new DeviceInformation();
        if (has("agentName")) {
            deviceInformation.setAgentName(getAgentName());
        }
        if (has("agentVersion")) {
            deviceInformation.setAgentVersion(getAgentVersion());
        }
        if (has("deviceArchitecture")) {
            deviceInformation.setArchitecture(getDeviceArchitecture());
        }
        if (has("deviceId")) {
            deviceInformation.setDeviceId(getDeviceId());
        }
        if (has(AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE)) {
            deviceInformation.setModel(getDeviceModel());
        }
        if (has(AnalyticsAttribute.DEVICE_MANUFACTURER_ATTRIBUTE)) {
            deviceInformation.setManufacturer(getDeviceManufacturer());
        }
        if (has("deviceRunTime")) {
            deviceInformation.setRunTime(getDeviceRunTime());
        }
        if (has("deviceSize")) {
            deviceInformation.setSize(getDeviceSize());
        }
        if (has(AnalyticsAttribute.OS_NAME_ATTRIBUTE)) {
            deviceInformation.setOsName(getOsName());
        }
        if (has(AnalyticsAttribute.OS_BUILD_ATTRIBUTE)) {
            deviceInformation.setOsBuild(getOsBuild());
        }
        if (has(AnalyticsAttribute.OS_VERSION_ATTRIBUTE)) {
            deviceInformation.setOsVersion(getOsVersion());
        }
        if (has("platform")) {
            deviceInformation.setApplicationFramework(getFramework());
        }
        if (has("platformVersion")) {
            deviceInformation.setApplicationFrameworkVersion(getPlatformVersion());
        }
        this.connectInformation.setApplicationInformation(applicationInformation);
        this.connectInformation.setDeviceInformation(deviceInformation);
    }

    public void loadHarvestConfiguration() {
        if (has("dataToken")) {
            this.configuration.setData_token(getDataToken());
            if (!this.configuration.getDataToken().isValid()) {
                this.configuration.setData_token(new int[]{0, 0});
            }
        }
        if (has("crossProcessId")) {
            this.configuration.setCross_process_id(getCrossProcessId());
        }
        if (has("encoding_key")) {
            this.configuration.setPriority_encoding_key(getPriorityEncodingKey());
        }
        if (has("account_id")) {
            this.configuration.setAccount_id(getAccountId());
        }
        if (has("application_id")) {
            this.configuration.setApplication_id(getApplicationId());
        }
        if (has("serverTimestamp")) {
            this.configuration.setServer_timestamp(getServerTimestamp());
        }
        if (has("harvestIntervalInSeconds")) {
            this.configuration.setData_report_period((int) getHarvestIntervalInSeconds());
        }
        if (has("maxTransactionAgeInSeconds")) {
            this.configuration.setReport_max_transaction_age((int) getMaxTransactionAgeInSeconds());
        }
        if (has("maxTransactionCount")) {
            this.configuration.setReport_max_transaction_count((int) getMaxTransactionCount());
        }
        if (has("stackTraceLimit")) {
            this.configuration.setStack_trace_limit(getStackTraceLimit());
        }
        if (has("responseBodyLimit")) {
            this.configuration.setResponse_body_limit(getResponseBodyLimit());
        }
        if (has("collectNetworkErrors")) {
            this.configuration.setCollect_network_errors(isCollectingNetworkErrors());
        }
        if (has("errorLimit")) {
            this.configuration.setError_limit(getErrorLimit());
        }
        if (has("activityTraceMinUtilization")) {
            this.configuration.setActivity_trace_min_utilization((double) getActivityTraceMinUtilization());
        }
        if (has("encoding_key")) {
            this.configuration.setPriority_encoding_key(getPriorityEncodingKey());
        }
        if (has("trusted_account_key")) {
            this.configuration.setTrusted_account_key(getTrustedAccountKey());
        }
        AgentLog agentLog = log;
        agentLog.info("Loaded configuration: " + this.configuration);
    }

    public void onHarvestComplete() {
        if (has("dataTokenExpiration")) {
            long j11 = getLong("dataTokenExpiration");
            if (j11 > 0 && System.currentTimeMillis() >= j11) {
                remove("dataToken");
                remove("dataTokenExpiration");
            }
        }
    }

    public void onHarvestConnected() {
        saveHarvestConfiguration(Harvest.getHarvestConfiguration());
    }

    public void onHarvestDisabled() {
        String agentVersion = Agent.getDeviceInformation().getAgentVersion();
        AgentLog agentLog = log;
        agentLog.info("Disabling agent version " + agentVersion);
        saveDisabledVersion(agentVersion);
    }

    public void onHarvestDisconnected() {
        log.info("Clearing harvest configuration.");
        clear();
    }

    public void remove(String str) {
        this.lock.lock();
        try {
            this.editor.remove(str).apply();
        } catch (Exception unused) {
        } catch (Throwable th2) {
            this.lock.unlock();
            throw th2;
        }
        this.lock.unlock();
    }

    public void save(String str, String str2) {
        this.lock.lock();
        try {
            this.editor.putString(str, str2);
            this.editor.apply();
        } finally {
            this.lock.unlock();
        }
    }

    public void saveActivityTraceMinUtilization(float f11) {
        this.activityTraceMinUtilization = Float.valueOf(f11);
        save("activityTraceMinUtilization", f11);
    }

    public void saveConnectInformation(ConnectInformation connectInformation2) {
        if (!this.connectInformation.equals(connectInformation2)) {
            saveApplicationInformation(connectInformation2.getApplicationInformation());
            saveDeviceInformation(connectInformation2.getDeviceInformation());
            loadConnectInformation();
        }
    }

    public void saveConnectionToken(String str) {
        save("connectHash", str.hashCode());
    }

    public void saveDeviceId(String str) {
        save("deviceId", str);
        this.connectInformation.getDeviceInformation().setDeviceId(str);
    }

    public void saveDisabledVersion(String str) {
        save("NewRelicAgentDisabledVersion", str);
    }

    public void saveHarvestConfiguration(HarvestConfiguration harvestConfiguration) {
        if (!this.configuration.equals(harvestConfiguration)) {
            if (!harvestConfiguration.getDataToken().isValid()) {
                AgentLog agentLog = log;
                agentLog.debug("Invalid data token: " + harvestConfiguration.getDataToken());
                DataToken dataToken = this.configuration.getDataToken();
                if (dataToken.isValid()) {
                    harvestConfiguration.setData_token(dataToken.asIntArray());
                }
            }
            AgentLog agentLog2 = log;
            agentLog2.info("Saving configuration: " + harvestConfiguration);
            DataToken dataToken2 = harvestConfiguration.getDataToken();
            if (dataToken2.isValid()) {
                String jsonString = dataToken2.toJsonString();
                agentLog2.info("Saving data token: " + jsonString);
                save("dataToken", jsonString);
                save("dataTokenExpiration", System.currentTimeMillis() + getDataTokenTTL());
            } else {
                agentLog2.error("Refusing to save invalid data token: " + dataToken2);
                StatsEngine.SUPPORTABILITY.inc(MetricNames.SUPPORTABILITY_INVALID_DATA_TOKEN);
            }
            save("crossProcessId", harvestConfiguration.getCross_process_id());
            save("serverTimestamp", harvestConfiguration.getServer_timestamp());
            save("harvestIntervalInSeconds", (long) harvestConfiguration.getData_report_period());
            save("maxTransactionAgeInSeconds", (long) harvestConfiguration.getReport_max_transaction_age());
            save("maxTransactionCount", (long) harvestConfiguration.getReport_max_transaction_count());
            save("stackTraceLimit", harvestConfiguration.getStack_trace_limit());
            save("responseBodyLimit", harvestConfiguration.getResponse_body_limit());
            save("collectNetworkErrors", harvestConfiguration.isCollect_network_errors());
            save("errorLimit", harvestConfiguration.getError_limit());
            save("encoding_key", harvestConfiguration.getPriority_encoding_key());
            save("account_id", harvestConfiguration.getAccount_id());
            save("application_id", harvestConfiguration.getApplication_id());
            save("trusted_account_key", harvestConfiguration.getTrusted_account_key());
            saveActivityTraceMinUtilization((float) harvestConfiguration.getActivity_trace_min_utilization());
            loadHarvestConfiguration();
        }
    }

    public void save(String str, boolean z11) {
        this.lock.lock();
        try {
            this.editor.putBoolean(str, z11);
            this.editor.apply();
        } finally {
            this.lock.unlock();
        }
    }

    public void save(String str, int i11) {
        this.lock.lock();
        try {
            this.editor.putInt(str, i11);
            this.editor.apply();
        } finally {
            this.lock.unlock();
        }
    }

    public void save(String str, long j11) {
        this.lock.lock();
        try {
            this.editor.putLong(str, j11);
            this.editor.apply();
        } finally {
            this.lock.unlock();
        }
    }

    public void save(String str, float f11) {
        this.lock.lock();
        try {
            this.editor.putFloat(str, f11);
            this.editor.apply();
        } finally {
            this.lock.unlock();
        }
    }
}
