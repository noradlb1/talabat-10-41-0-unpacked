package com.newrelic.agent.android;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.analytics.EventManager;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.api.v1.ConnectionEvent;
import com.newrelic.agent.android.api.v1.ConnectionListener;
import com.newrelic.agent.android.api.v1.DeviceForm;
import com.newrelic.agent.android.api.v2.TraceMachineInterface;
import com.newrelic.agent.android.background.ApplicationStateEvent;
import com.newrelic.agent.android.background.ApplicationStateListener;
import com.newrelic.agent.android.distributedtracing.UserActionFacade;
import com.newrelic.agent.android.distributedtracing.UserActionType;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestData;
import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.metric.MetricUnit;
import com.newrelic.agent.android.ndk.NativeReporting;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.sample.MachineMeasurementConsumer;
import com.newrelic.agent.android.sample.Sampler;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.AndroidEncoder;
import com.newrelic.agent.android.util.Connectivity;
import com.newrelic.agent.android.util.Encoder;
import com.newrelic.agent.android.util.PersistentUUID;
import com.newrelic.agent.android.util.Reachability;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AndroidAgentImpl implements AgentImpl, ConnectionListener, ApplicationStateListener, TraceMachineInterface {
    private static final Comparator<TransactionData> cmp = new Comparator<TransactionData>() {
        public int compare(TransactionData transactionData, TransactionData transactionData2) {
            if (transactionData.getTimestamp() > transactionData2.getTimestamp()) {
                return -1;
            }
            return transactionData.getTimestamp() < transactionData2.getTimestamp() ? 1 : 0;
        }
    };
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final AgentConfiguration agentConfiguration;
    private ApplicationInformation applicationInformation;
    private final Context context;
    DeviceInformation deviceInformation;
    private final Encoder encoder = new AndroidEncoder();
    private final Lock lock = new ReentrantLock();
    private MachineMeasurementConsumer machineMeasurementConsumer;
    private SavedState savedState;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x007b, code lost:
        if (r5.getApplicationFramework() == com.newrelic.agent.android.ApplicationFramework.MAUI) goto L_0x007d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AndroidAgentImpl(android.content.Context r4, com.newrelic.agent.android.AgentConfiguration r5) throws com.newrelic.agent.android.AgentInitializationException {
        /*
            r3 = this;
            r3.<init>()
            java.util.concurrent.locks.ReentrantLock r0 = new java.util.concurrent.locks.ReentrantLock
            r0.<init>()
            r3.lock = r0
            com.newrelic.agent.android.util.AndroidEncoder r0 = new com.newrelic.agent.android.util.AndroidEncoder
            r0.<init>()
            r3.encoder = r0
            android.content.Context r0 = appContext(r4)
            r3.context = r0
            r3.agentConfiguration = r5
            com.newrelic.agent.android.SavedState r1 = new com.newrelic.agent.android.SavedState
            r1.<init>(r0)
            r3.savedState = r1
            boolean r0 = r3.isDisabled()
            if (r0 != 0) goto L_0x0091
            r3.initApplicationInformation()
            com.newrelic.agent.android.tracing.TraceMachine.setTraceMachineInterface(r3)
            com.newrelic.agent.android.stores.SharedPrefsCrashStore r0 = new com.newrelic.agent.android.stores.SharedPrefsCrashStore
            r0.<init>(r4)
            r5.setCrashStore(r0)
            com.newrelic.agent.android.stores.SharedPrefsPayloadStore r0 = new com.newrelic.agent.android.stores.SharedPrefsPayloadStore
            r0.<init>(r4)
            r5.setPayloadStore(r0)
            com.newrelic.agent.android.stores.SharedPrefsAnalyticsAttributeStore r0 = new com.newrelic.agent.android.stores.SharedPrefsAnalyticsAttributeStore
            r0.<init>(r4)
            r5.setAnalyticsAttributeStore(r0)
            com.newrelic.agent.android.background.ApplicationStateMonitor r0 = com.newrelic.agent.android.background.ApplicationStateMonitor.getInstance()
            r0.addApplicationStateListener(r3)
            java.lang.String r0 = com.newrelic.agent.android.Agent.getMonoInstrumentationFlag()
            java.lang.String r1 = "YES"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0085
            com.newrelic.agent.android.util.ActivityLifecycleBackgroundListener r0 = new com.newrelic.agent.android.util.ActivityLifecycleBackgroundListener
            r0.<init>()
            android.content.Context r1 = r4.getApplicationContext()     // Catch:{ Exception -> 0x008a }
            boolean r1 = r1 instanceof android.app.Application     // Catch:{ Exception -> 0x008a }
            if (r1 == 0) goto L_0x008a
            android.content.Context r1 = r4.getApplicationContext()     // Catch:{ Exception -> 0x008a }
            android.app.Application r1 = (android.app.Application) r1     // Catch:{ Exception -> 0x008a }
            r1.registerActivityLifecycleCallbacks(r0)     // Catch:{ Exception -> 0x008a }
            com.newrelic.agent.android.ApplicationFramework r1 = r5.getApplicationFramework()     // Catch:{ Exception -> 0x008a }
            com.newrelic.agent.android.ApplicationFramework r2 = com.newrelic.agent.android.ApplicationFramework.Xamarin     // Catch:{ Exception -> 0x008a }
            if (r1 == r2) goto L_0x007d
            com.newrelic.agent.android.ApplicationFramework r5 = r5.getApplicationFramework()     // Catch:{ Exception -> 0x008a }
            com.newrelic.agent.android.ApplicationFramework r1 = com.newrelic.agent.android.ApplicationFramework.MAUI     // Catch:{ Exception -> 0x008a }
            if (r5 != r1) goto L_0x008a
        L_0x007d:
            com.newrelic.agent.android.background.ApplicationStateMonitor r5 = com.newrelic.agent.android.background.ApplicationStateMonitor.getInstance()     // Catch:{ Exception -> 0x008a }
            r5.activityStarted()     // Catch:{ Exception -> 0x008a }
            goto L_0x008a
        L_0x0085:
            com.newrelic.agent.android.util.UiBackgroundListener r0 = new com.newrelic.agent.android.util.UiBackgroundListener
            r0.<init>()
        L_0x008a:
            r4.registerComponentCallbacks(r0)
            r3.setupSession()
            return
        L_0x0091:
            com.newrelic.agent.android.AgentInitializationException r4 = new com.newrelic.agent.android.AgentInitializationException
            java.lang.String r5 = "This version of the agent has been disabled"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.AndroidAgentImpl.<init>(android.content.Context, com.newrelic.agent.android.AgentConfiguration):void");
    }

    private static Context appContext(Context context2) {
        if (!(context2 instanceof Application)) {
            return context2.getApplicationContext();
        }
        return context2;
    }

    private void clearExistingData() {
        try {
            if (!(Harvest.getInstance() == null || Harvest.getInstance().getHarvestData() == null)) {
                Harvest.getInstance().getHarvestData().reset();
            }
            TraceMachine.clearActivityHistory();
            AnalyticsControllerImpl instance = AnalyticsControllerImpl.getInstance();
            if (instance != null) {
                instance.clear();
            }
            new MeasurementEngine().clear();
        } catch (Exception e11) {
            AgentLog agentLog = log;
            agentLog.error("There is an error while clean data during shutdown process: " + e11.getLocalizedMessage());
        }
    }

    private static DeviceForm deviceForm(Context context2) {
        int i11 = context2.getResources().getConfiguration().screenLayout & 15;
        if (i11 == 1) {
            return DeviceForm.SMALL;
        }
        if (i11 == 2) {
            return DeviceForm.NORMAL;
        }
        if (i11 == 3) {
            return DeviceForm.LARGE;
        }
        if (i11 > 3) {
            return DeviceForm.XLARGE;
        }
        return DeviceForm.UNKNOWN;
    }

    private String getUnhandledExceptionHandlerName() {
        try {
            return Thread.getDefaultUncaughtExceptionHandler().getClass().getName();
        } catch (Exception unused) {
            return "unknown";
        }
    }

    public static void init(Context context2, AgentConfiguration agentConfiguration2) {
        try {
            Agent.setImpl(new AndroidAgentImpl(context2, agentConfiguration2));
            Agent.start();
        } catch (AgentInitializationException e11) {
            AgentLog agentLog = log;
            agentLog.error("Failed to initialize the agent: " + e11.toString());
        }
    }

    @Deprecated
    public void addTransactionData(TransactionData transactionData) {
    }

    public void applicationBackgrounded(ApplicationStateEvent applicationStateEvent) {
        log.info("AndroidAgentImpl: application backgrounded");
        stop();
    }

    public void applicationForegrounded(ApplicationStateEvent applicationStateEvent) {
        log.info("AndroidAgentImpl: application foregrounded");
        if (!NewRelic.isShutdown) {
            start();
        }
    }

    @Deprecated
    public void connected(ConnectionEvent connectionEvent) {
        log.error("AndroidAgentImpl: connected ");
    }

    public void disable() {
        AgentLog agentLog = log;
        agentLog.warn("PERMANENTLY DISABLING AGENT v" + Agent.getVersion());
        try {
            this.savedState.saveDisabledVersion(Agent.getVersion());
            try {
                stop(false);
            } finally {
                Agent.setImpl(NullAgentImpl.instance);
            }
        } catch (Throwable th2) {
            stop(false);
            throw th2;
        } finally {
            Agent.setImpl(NullAgentImpl.instance);
        }
    }

    @Deprecated
    public void disconnected(ConnectionEvent connectionEvent) {
        this.savedState.clear();
    }

    public void finalizeSession() {
    }

    @Deprecated
    public List<TransactionData> getAndClearTransactionData() {
        return null;
    }

    public ApplicationInformation getApplicationInformation() {
        return this.applicationInformation;
    }

    public String getCrossProcessId() {
        this.lock.lock();
        try {
            return this.savedState.getCrossProcessId();
        } finally {
            this.lock.unlock();
        }
    }

    public long getCurrentThreadId() {
        return Thread.currentThread().getId();
    }

    public String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    public DeviceInformation getDeviceInformation() {
        if (this.deviceInformation == null) {
            DeviceInformation deviceInformation2 = new DeviceInformation();
            deviceInformation2.setOsName("Android");
            deviceInformation2.setOsVersion(Build.VERSION.RELEASE);
            deviceInformation2.setOsBuild(Build.VERSION.INCREMENTAL);
            deviceInformation2.setModel(Build.MODEL);
            deviceInformation2.setAgentName("AndroidAgent");
            deviceInformation2.setAgentVersion(Agent.getVersion());
            deviceInformation2.setManufacturer(Build.MANUFACTURER);
            deviceInformation2.setDeviceId(getUUID());
            deviceInformation2.setArchitecture(System.getProperty("os.arch"));
            deviceInformation2.setRunTime(System.getProperty("java.vm.version"));
            deviceInformation2.setSize(deviceForm(this.context).name().toLowerCase(Locale.getDefault()));
            deviceInformation2.setApplicationFramework(this.agentConfiguration.getApplicationFramework());
            deviceInformation2.setApplicationFrameworkVersion(this.agentConfiguration.getApplicationFrameworkVersion());
            this.deviceInformation = deviceInformation2;
        }
        return this.deviceInformation;
    }

    public Encoder getEncoder() {
        return this.encoder;
    }

    public EnvironmentInformation getEnvironmentInformation() {
        EnvironmentInformation environmentInformation = new EnvironmentInformation();
        ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
        long[] jArr = new long[2];
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            jArr[0] = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
            long availableBlocksLong = statFs2.getAvailableBlocksLong() * statFs.getBlockSizeLong();
            jArr[1] = availableBlocksLong;
            if (jArr[0] < 0) {
                jArr[0] = 0;
            }
            if (availableBlocksLong < 0) {
                jArr[1] = 0;
            }
        } catch (Exception e11) {
            AgentHealth.noticeException(e11);
            if (jArr[0] < 0) {
                jArr[0] = 0;
            }
            if (jArr[1] < 0) {
                jArr[1] = 0;
            }
        } catch (Throwable th2) {
            if (jArr[0] < 0) {
                jArr[0] = 0;
            }
            if (jArr[1] < 0) {
                jArr[1] = 0;
            }
            environmentInformation.setDiskAvailable(jArr);
            throw th2;
        }
        environmentInformation.setDiskAvailable(jArr);
        environmentInformation.setMemoryUsage(Sampler.sampleMemory(activityManager).getSampleValue().asLong().longValue());
        environmentInformation.setOrientation(this.context.getResources().getConfiguration().orientation);
        environmentInformation.setNetworkStatus(getNetworkCarrier());
        environmentInformation.setNetworkWanType(getNetworkWanType());
        return environmentInformation;
    }

    public String getNetworkCarrier() {
        return Connectivity.carrierNameFromContext(this.context);
    }

    public String getNetworkWanType() {
        return Connectivity.wanType(this.context);
    }

    public int getResponseBodyLimit() {
        this.lock.lock();
        try {
            return this.savedState.getHarvestConfiguration().getResponse_body_limit();
        } finally {
            this.lock.unlock();
        }
    }

    public SavedState getSavedState() {
        return this.savedState;
    }

    public long getSessionDurationMillis() {
        return Harvest.getMillisSinceStart();
    }

    public int getStackTraceLimit() {
        this.lock.lock();
        try {
            return this.savedState.getStackTraceLimit();
        } finally {
            this.lock.unlock();
        }
    }

    public String getUUID() {
        String deviceId = this.savedState.getConnectInformation().getDeviceInformation().getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            deviceId = new PersistentUUID(this.context).getPersistentUUID();
            this.savedState.saveDeviceId(deviceId);
            StatsEngine.get().inc(MetricNames.METRIC_UUID_CREATED);
        }
        String deviceID = this.agentConfiguration.getDeviceID();
        if (deviceID == null) {
            return deviceId;
        }
        StatsEngine.get().inc(MetricNames.METRIC_UUID_OVERRIDDEN);
        return deviceID;
    }

    public boolean hasReachableNetworkConnection(String str) {
        return Reachability.hasReachableNetworkConnection(this.context, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initApplicationInformation() throws com.newrelic.agent.android.AgentInitializationException {
        /*
            r8 = this;
            com.newrelic.agent.android.harvest.ApplicationInformation r0 = r8.applicationInformation
            if (r0 == 0) goto L_0x000c
            com.newrelic.agent.android.logging.AgentLog r0 = log
            java.lang.String r1 = "attempted to reinitialize ApplicationInformation."
            r0.debug(r1)
            return
        L_0x000c:
            android.content.Context r0 = r8.context
            java.lang.String r0 = r0.getPackageName()
            android.content.Context r1 = r8.context
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r2 = 0
            android.content.pm.PackageInfo r3 = r1.getPackageInfo(r0, r2)     // Catch:{ NameNotFoundException -> 0x00ce }
            com.newrelic.agent.android.AgentConfiguration r4 = r8.agentConfiguration
            java.lang.String r4 = r4.getCustomApplicationVersion()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x0040
            if (r3 == 0) goto L_0x0038
            java.lang.String r4 = r3.versionName
            if (r4 == 0) goto L_0x0038
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0038
            java.lang.String r4 = r3.versionName
            goto L_0x0040
        L_0x0038:
            com.newrelic.agent.android.AgentInitializationException r0 = new com.newrelic.agent.android.AgentInitializationException
            java.lang.String r1 = "Your app doesn't appear to have a version defined. Ensure you have defined 'versionName' in your manifest."
            r0.<init>(r1)
            throw r0
        L_0x0040:
            com.newrelic.agent.android.logging.AgentLog r5 = log
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Using application version "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            r5.debug(r6)
            android.content.pm.ApplicationInfo r2 = r1.getApplicationInfo(r0, r2)     // Catch:{ NameNotFoundException -> 0x0070, SecurityException -> 0x0065 }
            if (r2 == 0) goto L_0x007a
            java.lang.CharSequence r1 = r1.getApplicationLabel(r2)     // Catch:{ NameNotFoundException -> 0x0070, SecurityException -> 0x0065 }
            java.lang.String r1 = r1.toString()     // Catch:{ NameNotFoundException -> 0x0070, SecurityException -> 0x0065 }
            goto L_0x007b
        L_0x0065:
            r1 = move-exception
            com.newrelic.agent.android.logging.AgentLog r2 = log
            java.lang.String r1 = r1.toString()
            r2.warn(r1)
            goto L_0x007a
        L_0x0070:
            r1 = move-exception
            com.newrelic.agent.android.logging.AgentLog r2 = log
            java.lang.String r1 = r1.toString()
            r2.warn(r1)
        L_0x007a:
            r1 = r0
        L_0x007b:
            com.newrelic.agent.android.logging.AgentLog r2 = log
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Using application name "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            r2.debug(r5)
            com.newrelic.agent.android.AgentConfiguration r5 = r8.agentConfiguration
            java.lang.String r5 = r5.getCustomBuildIdentifier()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L_0x00ad
            if (r3 == 0) goto L_0x00a6
            int r5 = r3.versionCode
            java.lang.String r5 = java.lang.String.valueOf(r5)
            goto L_0x00ad
        L_0x00a6:
            java.lang.String r5 = "Your app doesn't appear to have a version code defined. Ensure you have defined 'versionCode' in your manifest."
            r2.warn(r5)
            java.lang.String r5 = ""
        L_0x00ad:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Using build "
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r2.debug(r6)
            com.newrelic.agent.android.harvest.ApplicationInformation r2 = new com.newrelic.agent.android.harvest.ApplicationInformation
            r2.<init>(r1, r4, r0, r5)
            r8.applicationInformation = r2
            int r0 = r3.versionCode
            r2.setVersionCode(r0)
            return
        L_0x00ce:
            r0 = move-exception
            com.newrelic.agent.android.AgentInitializationException r1 = new com.newrelic.agent.android.AgentInitializationException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Could not determine package version: "
            r2.append(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.AndroidAgentImpl.initApplicationInformation():void");
    }

    public void initialize() {
        setupSession();
        AnalyticsControllerImpl.initialize(this.agentConfiguration, this);
        Harvest.addHarvestListener(this.savedState);
        Harvest.initialize(this.agentConfiguration);
        Harvest.setHarvestConfiguration(this.savedState.getHarvestConfiguration());
        Harvest.setHarvestConnectInformation(this.savedState.getConnectInformation());
        Measurements.initialize();
        AgentLog agentLog = log;
        agentLog.info(MessageFormat.format("New Relic Agent v{0}", new Object[]{Agent.getVersion()}));
        agentLog.verbose(MessageFormat.format("Application token: {0}", new Object[]{this.agentConfiguration.getApplicationToken()}));
        MachineMeasurementConsumer machineMeasurementConsumer2 = new MachineMeasurementConsumer();
        this.machineMeasurementConsumer = machineMeasurementConsumer2;
        Measurements.addMeasurementConsumer(machineMeasurementConsumer2);
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_UNCAUGHT_HANDLER.replace(MetricNames.TAG_NAME, getUnhandledExceptionHandlerName()));
        PayloadController.initialize(this.agentConfiguration);
        Sampler.init(this.context);
        if (isInstantApp()) {
            agentLog.info("This appears to be an Instant App");
            AnalyticsControllerImpl.getInstance().addAttributeUnchecked(new AnalyticsAttribute(AnalyticsAttribute.INSTANT_APP_ATTRIBUTE, true), false);
        }
        if (FeatureFlag.featureEnabled(FeatureFlag.NativeReporting)) {
            try {
                NativeReporting.initialize(this.context, this.agentConfiguration);
            } catch (NoClassDefFoundError unused) {
                AgentLog agentLog2 = log;
                agentLog2.error("NativeReporting feature is enabled, but agent-ndk was not found (probably missing as a dependency).");
                agentLog2.error("Native reporting will not be enabled");
            }
        }
    }

    public boolean isDisabled() {
        return Agent.getVersion().equals(this.savedState.getDisabledVersion());
    }

    public boolean isInstantApp() {
        return InstantApps.isInstantApp(this.context);
    }

    public boolean isUIThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @Deprecated
    public void mergeTransactionData(List<TransactionData> list) {
    }

    public void setLocation(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Country code and administrative region are required.");
        }
    }

    public void setSavedState(SavedState savedState2) {
        this.savedState = savedState2;
    }

    public void setupSession() {
        TraceMachine.clearActivityHistory();
        this.agentConfiguration.provideSessionId();
    }

    public void start() {
        if (!isDisabled()) {
            initialize();
            Harvest.start();
            if (FeatureFlag.featureEnabled(FeatureFlag.NativeReporting)) {
                try {
                    if (NativeReporting.isInitialized()) {
                        NativeReporting.getInstance().start();
                    }
                } catch (NoClassDefFoundError unused) {
                    log.error("Native reporting is not enabled");
                }
            }
            if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
                UserActionFacade.getInstance().recordUserAction(UserActionType.AppLaunch);
                return;
            }
            return;
        }
        stop(false);
    }

    public void stop() {
        stop(true);
    }

    public boolean updateSavedConnectInformation() {
        ConnectInformation connectInformation = this.savedState.getConnectInformation();
        ConnectInformation connectInformation2 = new ConnectInformation(getApplicationInformation(), getDeviceInformation());
        if (connectInformation2.equals(connectInformation) && this.savedState.hasConnectionToken(this.agentConfiguration.getApplicationToken())) {
            return false;
        }
        if (connectInformation2.getApplicationInformation().isAppUpgrade(connectInformation.getApplicationInformation())) {
            StatsEngine.get().inc(MetricNames.MOBILE_APP_UPGRADE);
            AnalyticsControllerImpl.getInstance().addAttributeUnchecked(new AnalyticsAttribute(AnalyticsAttribute.APP_UPGRADE_ATTRIBUTE, connectInformation.getApplicationInformation().getAppVersion()), false);
        }
        this.savedState.clear();
        this.savedState.saveConnectInformation(connectInformation2);
        this.savedState.saveConnectionToken(this.agentConfiguration.getApplicationToken());
        return true;
    }

    public void setLocation(Location location) {
        List<Address> list;
        Address address;
        if (location != null) {
            try {
                list = new Geocoder(this.context).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            } catch (IOException e11) {
                AgentLog agentLog = log;
                agentLog.error("Unable to geocode location: " + e11.toString());
                list = null;
            }
            if (list != null && list.size() != 0 && (address = list.get(0)) != null) {
                String countryCode = address.getCountryCode();
                String adminArea = address.getAdminArea();
                if (countryCode != null && adminArea != null) {
                    setLocation(countryCode, adminArea);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Location must not be null.");
    }

    public void stop(boolean z11) {
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            UserActionFacade.getInstance().recordUserAction(UserActionType.AppBackground);
        }
        finalizeSession();
        Sampler.shutdown();
        TraceMachine.haltTracing();
        EventManager eventManager = AnalyticsControllerImpl.getInstance().getEventManager();
        if (!NewRelic.isShutdown) {
            int eventsRecorded = eventManager.getEventsRecorded();
            int eventsEjected = eventManager.getEventsEjected();
            String name2 = MetricCategory.NONE.name();
            double d11 = (double) eventsEjected;
            MetricUnit metricUnit = MetricUnit.OPERATIONS;
            Measurements.addCustomMetric("Supportability/Events/Recorded", name2, eventsRecorded, d11, d11, metricUnit, metricUnit);
        }
        if (z11) {
            if (isUIThread()) {
                StatsEngine.get().inc(MetricNames.SUPPORTABILITY_HARVEST_ON_MAIN_THREAD);
            }
            try {
                if (NewRelic.isStarted() && NewRelic.isShutdown) {
                    clearExistingData();
                    for (Map.Entry<String, Metric> value : StatsEngine.notice().getStatsMap().entrySet()) {
                        Metric metric = (Metric) value.getValue();
                        if (!(Harvest.getInstance().getHarvestData() == null || Harvest.getInstance().getHarvestData().getMetrics() == null)) {
                            Harvest.getInstance().getHarvestData().getMetrics().addMetric(metric);
                        }
                    }
                }
            } catch (Exception e11) {
                AgentLog agentLog = log;
                agentLog.error("There is an error during shutdown process: " + e11.getLocalizedMessage());
            }
            Harvest.harvestNow(true);
            HarvestData harvestData = Harvest.getInstance().getHarvestData();
            AgentLog agentLog2 = log;
            agentLog2.debug("EventManager: recorded[" + eventManager.getEventsRecorded() + "] ejected[" + eventManager.getEventsEjected() + "]");
            if (harvestData != null && harvestData.isValid()) {
                Collection<AnalyticsEvent> analyticsEvents = harvestData.getAnalyticsEvents();
                if (!analyticsEvents.isEmpty()) {
                    agentLog2.warn("Agent stopped with " + analyticsEvents.size() + " events dropped from failed harvest.");
                }
                if (eventManager.size() > 0) {
                    agentLog2.warn("Agent stopped with " + eventManager.size() + " events left in event pool.");
                }
            }
        }
        if (FeatureFlag.featureEnabled(FeatureFlag.NativeReporting)) {
            try {
                NativeReporting.shutdown();
            } catch (NoClassDefFoundError unused) {
            }
        }
        AnalyticsControllerImpl.shutdown();
        TraceMachine.clearActivityHistory();
        Harvest.shutdown();
        Measurements.shutdown();
        PayloadController.shutdown();
    }
}
