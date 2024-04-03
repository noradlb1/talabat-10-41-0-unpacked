package com.newrelic.agent.android.analytics;

import com.google.android.gms.ads.AdError;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.harvest.HarvestData;
import com.newrelic.agent.android.harvest.HttpTransaction;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class AnalyticsControllerImpl extends HarvestAdapter implements AnalyticsController {
    protected static final int MAX_ATTRIBUTES = 128;
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final AnalyticsControllerImpl instance = new AnalyticsControllerImpl();
    /* access modifiers changed from: private */
    public static final AgentLog log = AgentLogManager.getAgentLog();
    private static final AnalyticsValidator validator = new AnalyticsValidator();
    private AgentImpl agentImpl;
    private AnalyticsAttributeStore attributeStore;
    private final EventManagerImpl eventManager = new EventManagerImpl();
    private final InteractionCompleteListener interactionListener = new InteractionCompleteListener();
    private final AtomicBoolean isEnabled = new AtomicBoolean(false);
    private final ConcurrentLinkedQueue<AnalyticsAttribute> systemAttributes = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<AnalyticsAttribute> userAttributes = new ConcurrentLinkedQueue<>();

    /* renamed from: com.newrelic.agent.android.analytics.AnalyticsControllerImpl$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType[] r0 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType = r0
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.analytics.AnalyticsControllerImpl.AnonymousClass1.<clinit>():void");
        }
    }

    public class InteractionCompleteListener implements TraceLifecycleAware {
        public InteractionCompleteListener() {
        }

        private AnalyticsEvent createTraceEvent(ActivityTrace activityTrace) {
            float durationAsSeconds = activityTrace.rootTrace.getDurationAsSeconds();
            HashSet hashSet = new HashSet();
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.INTERACTION_DURATION_ATTRIBUTE, (double) durationAsSeconds));
            return AnalyticsEventFactory.createEvent(activityTrace.rootTrace.displayName, AnalyticsEventCategory.Interaction, AnalyticsEvent.EVENT_TYPE_MOBILE, hashSet);
        }

        public void onEnterMethod() {
        }

        public void onExitMethod() {
        }

        public void onTraceComplete(ActivityTrace activityTrace) {
            AnalyticsControllerImpl.log.audit("AnalyticsControllerImpl.InteractionCompleteListener.onTraceComplete()");
            AnalyticsControllerImpl.getInstance().addEvent(createTraceEvent(activityTrace));
        }

        public void onTraceRename(ActivityTrace activityTrace) {
            AnalyticsControllerImpl.this.addAttributeUnchecked(new AnalyticsAttribute(AnalyticsAttribute.LAST_INTERACTION_ATTRIBUTE, activityTrace.getActivityName()), true);
        }

        public void onTraceStart(ActivityTrace activityTrace) {
            AnalyticsControllerImpl.this.addAttributeUnchecked(new AnalyticsAttribute(AnalyticsAttribute.LAST_INTERACTION_ATTRIBUTE, activityTrace.getActivityName()), true);
        }
    }

    private AnalyticsControllerImpl() {
    }

    private boolean addNewUserAttribute(AnalyticsAttribute analyticsAttribute) {
        if (this.userAttributes.size() >= 128) {
            AgentLog agentLog = log;
            agentLog.warn("Attribute limit exceeded: 128 are allowed.");
            if (agentLog.getLevel() < 6) {
                return true;
            }
            agentLog.audit("Currently defined attributes:");
            Iterator<AnalyticsAttribute> it = this.userAttributes.iterator();
            while (it.hasNext()) {
                AnalyticsAttribute next = it.next();
                AgentLog agentLog2 = log;
                String name2 = next.getName();
                String valueAsString = next.valueAsString();
                agentLog2.audit("\t" + name2 + ": " + valueAsString);
            }
            return true;
        } else if (validator.isValidAttribute(analyticsAttribute)) {
            this.userAttributes.add(analyticsAttribute);
            if (!analyticsAttribute.isPersistent() || this.attributeStore.store(analyticsAttribute)) {
                return true;
            }
            AgentLog agentLog3 = log;
            agentLog3.error("Failed to store attribute [" + analyticsAttribute + "] to attribute store.");
            return false;
        } else {
            AgentLog agentLog4 = log;
            String name3 = analyticsAttribute.getName();
            agentLog4.error("Refused to add invalid attribute: " + name3);
            return true;
        }
    }

    public static AnalyticsControllerImpl getInstance() {
        return instance;
    }

    private AnalyticsAttribute getSystemAttribute(String str) {
        Iterator<AnalyticsAttribute> it = this.systemAttributes.iterator();
        while (it.hasNext()) {
            AnalyticsAttribute next = it.next();
            if (next.getName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    private AnalyticsAttribute getUserAttribute(String str) {
        Iterator<AnalyticsAttribute> it = this.userAttributes.iterator();
        while (it.hasNext()) {
            AnalyticsAttribute next = it.next();
            if (next.getName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static void initialize(AgentConfiguration agentConfiguration, AgentImpl agentImpl2) {
        if (agentConfiguration == null || agentImpl2 == null) {
            log.error("AnalyticsControllerImpl.initialize(): Can't initialize with a null agent configuration or implementation.");
            return;
        }
        AgentLog agentLog = log;
        String obj = agentImpl2.toString();
        agentLog.audit("AnalyticsControllerImpl.initialize(" + agentConfiguration + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + obj + ")");
        if (!initialized.compareAndSet(false, true)) {
            agentLog.warn("AnalyticsControllerImpl.initialize(): Has already been initialized. Bypassing..");
            return;
        }
        AnalyticsControllerImpl analyticsControllerImpl = instance;
        analyticsControllerImpl.clear();
        analyticsControllerImpl.reinitialize(agentConfiguration, agentImpl2);
        TraceMachine.addTraceListener(analyticsControllerImpl.interactionListener);
        Harvest.addHarvestListener(analyticsControllerImpl);
        AtomicBoolean atomicBoolean = analyticsControllerImpl.isEnabled;
        agentLog.info("Analytics Controller initialized: enabled[" + atomicBoolean + "]");
    }

    private boolean isHttpError(HttpTransaction httpTransaction) {
        return ((long) httpTransaction.getStatusCode()) >= 400;
    }

    private boolean isInitializedAndEnabled() {
        if (!initialized.get()) {
            log.warn("Analytics controller is not initialized!");
            return false;
        } else if (this.isEnabled.get()) {
            return true;
        } else {
            log.warn("Analytics controller is not enabled!");
            return false;
        }
    }

    private boolean isNetworkFailure(HttpTransaction httpTransaction) {
        return httpTransaction.getErrorCode() != 0;
    }

    private boolean isSuccessfulRequest(HttpTransaction httpTransaction) {
        return httpTransaction.getStatusCode() > 0 && httpTransaction.getStatusCode() < 400;
    }

    public static void shutdown() {
        AnalyticsControllerImpl analyticsControllerImpl = instance;
        TraceMachine.removeTraceListener(analyticsControllerImpl.interactionListener);
        Harvest.removeHarvestListener(analyticsControllerImpl);
        analyticsControllerImpl.getEventManager().shutdown();
        initialized.compareAndSet(true, false);
        log.info("Analytics Controller shutdown");
    }

    public boolean addAttributeUnchecked(AnalyticsAttribute analyticsAttribute, boolean z11) {
        String str;
        AgentLog agentLog = log;
        String name2 = analyticsAttribute.getName();
        String stringValue = analyticsAttribute.getStringValue();
        if (z11) {
            str = " (persistent)";
        } else {
            str = " (transient)";
        }
        agentLog.audit("AnalyticsControllerImpl.setAttributeUnchecked(" + name2 + ")" + stringValue + str);
        if (!initialized.get()) {
            agentLog.warn("Analytics controller is not initialized!");
            return false;
        } else if (!this.isEnabled.get()) {
            agentLog.warn("Analytics controller is not enabled!");
            return false;
        } else {
            String name3 = analyticsAttribute.getName();
            AnalyticsValidator analyticsValidator = validator;
            if (!analyticsValidator.isValidKeyName(name3)) {
                return false;
            }
            if (analyticsAttribute.isStringAttribute() && !analyticsValidator.isValidAttributeValue(name3, analyticsAttribute.getStringValue())) {
                return false;
            }
            AnalyticsAttribute systemAttribute = getSystemAttribute(name3);
            if (systemAttribute == null) {
                this.systemAttributes.add(analyticsAttribute);
                if (analyticsAttribute.isPersistent() && !this.attributeStore.store(analyticsAttribute)) {
                    agentLog.error("Failed to store attribute " + analyticsAttribute + " to attribute store.");
                    return false;
                }
            } else {
                int i11 = AnonymousClass1.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType[analyticsAttribute.getAttributeDataType().ordinal()];
                if (i11 == 1) {
                    systemAttribute.setStringValue(analyticsAttribute.getStringValue());
                } else if (i11 == 2) {
                    systemAttribute.setDoubleValue(analyticsAttribute.getDoubleValue());
                } else if (i11 != 3) {
                    AnalyticsAttribute.AttributeDataType attributeDataType = analyticsAttribute.getAttributeDataType();
                    agentLog.error("Attribute data type [" + attributeDataType + "] is invalid");
                } else {
                    systemAttribute.setBooleanValue(analyticsAttribute.getBooleanValue());
                }
                systemAttribute.setPersistent(z11);
                if (!systemAttribute.isPersistent()) {
                    this.attributeStore.delete(systemAttribute);
                } else if (!this.attributeStore.store(systemAttribute)) {
                    agentLog.error("Failed to store attribute [" + systemAttribute + "] to attribute store.");
                    return false;
                }
            }
            return true;
        }
    }

    public boolean addEvent(String str, Set<AnalyticsAttribute> set) {
        return addEvent(str, AnalyticsEventCategory.Custom, AnalyticsEvent.EVENT_TYPE_MOBILE, set);
    }

    public void clear() {
        AgentLog agentLog = log;
        int size = this.systemAttributes.size();
        int size2 = this.userAttributes.size();
        int size3 = this.eventManager.size();
        agentLog.audit("AnalyticsControllerImpl.clear(): system[" + size + "] user[" + size2 + "] events[" + size3 + "]");
        this.systemAttributes.clear();
        this.userAttributes.clear();
        this.eventManager.empty();
    }

    public void createHttpErrorEvent(HttpTransaction httpTransaction) {
        if (isInitializedAndEnabled()) {
            NetworkEventController.createHttpErrorEvent(httpTransaction);
        }
    }

    public void createNetworkFailureEvent(HttpTransaction httpTransaction) {
        if (isInitializedAndEnabled()) {
            NetworkEventController.createNetworkFailureEvent(httpTransaction);
        }
    }

    public void createNetworkRequestEvent(HttpTransaction httpTransaction) {
        if (isInitializedAndEnabled()) {
            NetworkEventController.createNetworkRequestEvent(httpTransaction);
        }
    }

    public void createNetworkRequestEvents(HttpTransaction httpTransaction) {
        if (!isInitializedAndEnabled()) {
            return;
        }
        if (isHttpError(httpTransaction)) {
            NetworkEventController.createHttpErrorEvent(httpTransaction);
        } else if (isNetworkFailure(httpTransaction)) {
            NetworkEventController.createNetworkFailureEvent(httpTransaction);
        } else if (isSuccessfulRequest(httpTransaction)) {
            NetworkEventController.createNetworkRequestEvent(httpTransaction);
        }
    }

    public AnalyticsAttribute getAttribute(String str) {
        AgentLog agentLog = log;
        agentLog.audit("AnalyticsControllerImpl.getAttribute(" + str + ")");
        AnalyticsAttribute userAttribute = getUserAttribute(str);
        if (userAttribute == null) {
            return getSystemAttribute(str);
        }
        return userAttribute;
    }

    public EventManager getEventManager() {
        return this.eventManager;
    }

    public int getMaxEventBufferTime() {
        return this.eventManager.getMaxEventBufferTime();
    }

    public int getMaxEventPoolSize() {
        return this.eventManager.getMaxEventPoolSize();
    }

    public int getSessionAttributeCount() {
        return this.systemAttributes.size() + this.userAttributes.size();
    }

    public Set<AnalyticsAttribute> getSessionAttributes() {
        AgentLog agentLog = log;
        int sessionAttributeCount = getSessionAttributeCount();
        agentLog.audit("AnalyticsControllerImpl.getSessionAttributes(): " + sessionAttributeCount);
        HashSet hashSet = new HashSet(getSessionAttributeCount());
        hashSet.addAll(getSystemAttributes());
        hashSet.addAll(getUserAttributes());
        return Collections.unmodifiableSet(hashSet);
    }

    public int getSystemAttributeCount() {
        return this.systemAttributes.size();
    }

    public Set<AnalyticsAttribute> getSystemAttributes() {
        AgentLog agentLog = log;
        int size = this.systemAttributes.size();
        agentLog.audit("AnalyticsControllerImpl.getSystemAttributes(): " + size);
        HashSet hashSet = new HashSet(this.systemAttributes.size());
        Iterator<AnalyticsAttribute> it = this.systemAttributes.iterator();
        while (it.hasNext()) {
            hashSet.add(new AnalyticsAttribute(it.next()));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public int getUserAttributeCount() {
        return Math.min(this.userAttributes.size(), 128);
    }

    public Set<AnalyticsAttribute> getUserAttributes() {
        AgentLog agentLog = log;
        int size = this.userAttributes.size();
        agentLog.audit("AnalyticsControllerImpl.getUserAttributes(): " + size);
        HashSet hashSet = new HashSet(this.userAttributes.size());
        Iterator<AnalyticsAttribute> it = this.userAttributes.iterator();
        while (it.hasNext()) {
            hashSet.add(new AnalyticsAttribute(it.next()));
            if (hashSet.size() == 128) {
                break;
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public boolean incrementAttribute(String str, double d11) {
        return incrementAttribute(str, d11, true);
    }

    public boolean internalRecordEvent(String str, AnalyticsEventCategory analyticsEventCategory, String str2, Map<String, Object> map) {
        try {
            AgentLog agentLog = log;
            String obj = analyticsEventCategory.toString();
            agentLog.audit("AnalyticsControllerImpl.internalRecordEvent(" + str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + obj + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + map + ")");
            if (!isInitializedAndEnabled()) {
                return false;
            }
            AnalyticsValidator analyticsValidator = validator;
            if (!analyticsValidator.isValidEventType(str2)) {
                return false;
            }
            return addEvent(str, analyticsEventCategory, str2, analyticsValidator.toValidatedAnalyticsAttributes(map));
        } catch (Exception e11) {
            log.error(String.format("Error occurred while recording event [%s]: ", new Object[]{str}), e11);
            return false;
        }
    }

    public void loadPersistentAttributes() {
        AgentLog agentLog = log;
        int count = this.attributeStore.count();
        agentLog.audit("AnalyticsControllerImpl.loadPersistentAttributes(): " + count);
        List<AnalyticsAttribute> fetchAll = this.attributeStore.fetchAll();
        int size = fetchAll.size();
        agentLog.debug("AnalyticsControllerImpl.loadPersistentAttributes(): found " + size + " userAttributes in the attribute store");
        int size2 = this.userAttributes.size();
        for (AnalyticsAttribute next : fetchAll) {
            if (!this.userAttributes.contains(next) && size2 <= 128) {
                this.userAttributes.add(next);
                size2++;
            }
        }
    }

    public void onHarvest() {
        HarvestData harvestData = Harvest.getInstance().getHarvestData();
        if (harvestData != null) {
            harvestData.setAnalyticsEnabled(this.isEnabled.get());
            if (this.isEnabled.get() && FeatureFlag.featureEnabled(FeatureFlag.AnalyticsEvents) && this.eventManager.isTransmitRequired()) {
                HashSet hashSet = new HashSet();
                hashSet.addAll(getSystemAttributes());
                hashSet.addAll(getUserAttributes());
                harvestData.setSessionAttributes(hashSet);
                Collection<AnalyticsEvent> queuedEventsSnapshot = this.eventManager.getQueuedEventsSnapshot();
                if (queuedEventsSnapshot.size() > 0) {
                    harvestData.getAnalyticsEvents().addAll(queuedEventsSnapshot);
                    AgentLog agentLog = log;
                    int size = queuedEventsSnapshot.size();
                    agentLog.debug("EventManager: [" + size + "] events moved from buffer to HarvestData");
                }
                if (this.eventManager.getQueuedEvents().size() > 0) {
                    AgentLog agentLog2 = log;
                    int size2 = this.eventManager.getQueuedEvents().size();
                    agentLog2.error("EventManager: [" + size2 + "] events remain in buffer after hand-off");
                }
            }
        }
    }

    public boolean recordBreadcrumb(String str, Map<String, Object> map) {
        try {
            AgentLog agentLog = log;
            agentLog.audit("AnalyticsControllerImpl.recordBreadcrumb(" + str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + map + ")");
            if (!isInitializedAndEnabled()) {
                return false;
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(validator.toValidatedAnalyticsAttributes(map));
            return addEvent(str, AnalyticsEventCategory.Breadcrumb, AnalyticsEvent.EVENT_TYPE_MOBILE_BREADCRUMB, hashSet);
        } catch (Exception e11) {
            log.error(String.format("Error occurred while recording Breadcrumb event [%s]: ", new Object[]{str}), e11);
            return false;
        }
    }

    public boolean recordCustomEvent(String str, Map<String, Object> map) {
        try {
            AgentLog agentLog = log;
            agentLog.audit("AnalyticsControllerImpl.recordCustomEvent(" + str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + map + ")");
            if (!isInitializedAndEnabled()) {
                return false;
            }
            AnalyticsValidator analyticsValidator = validator;
            if (analyticsValidator.isValidEventType(str)) {
                if (!analyticsValidator.isReservedEventType(str)) {
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(analyticsValidator.toValidatedAnalyticsAttributes(map));
                    String str2 = (String) map.get("name");
                    if (str2 == null || str2.isEmpty()) {
                        str2 = str;
                    }
                    return addEvent(str2, AnalyticsEventCategory.Custom, str, hashSet);
                }
            }
            return false;
        } catch (Exception e11) {
            log.error(String.format("Error occurred while recording custom event [%s]: ", new Object[]{str}), e11);
            return false;
        }
    }

    public boolean recordEvent(String str, Map<String, Object> map) {
        try {
            AgentLog agentLog = log;
            int size = map.size();
            agentLog.audit("AnalyticsControllerImpl.recordEvent - " + str + ": " + size + " attributes");
            if (!isInitializedAndEnabled()) {
                return false;
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(validator.toValidatedAnalyticsAttributes(map));
            return addEvent(str, AnalyticsEventCategory.Custom, AnalyticsEvent.EVENT_TYPE_MOBILE, hashSet);
        } catch (Exception e11) {
            log.error(String.format("Error occurred while recording event [%s]: ", new Object[]{str}), e11);
            return false;
        }
    }

    public void reinitialize(AgentConfiguration agentConfiguration, AgentImpl agentImpl2) {
        String str;
        AgentLog agentLog = log;
        String obj = agentImpl2.toString();
        agentLog.audit("AnalyticsControllerImpl.reinitialize(" + agentConfiguration + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + obj + ")");
        this.agentImpl = agentImpl2;
        this.eventManager.initialize(agentConfiguration);
        this.isEnabled.set(agentConfiguration.getEnableAnalyticsEvents());
        this.attributeStore = agentConfiguration.getAnalyticsAttributeStore();
        loadPersistentAttributes();
        DeviceInformation deviceInformation = this.agentImpl.getDeviceInformation();
        String osVersion = deviceInformation.getOsVersion();
        if (osVersion != null) {
            osVersion = osVersion.replace(" ", "");
            if (!osVersion.isEmpty()) {
                String[] split = osVersion.split("[.:-]");
                if (split.length > 0) {
                    str = split[0];
                } else {
                    str = null;
                }
                if (str == null || str.isEmpty()) {
                    str = osVersion;
                }
                this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, osVersion));
                this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.OS_MAJOR_VERSION_ATTRIBUTE, str));
            }
        }
        if (osVersion == null || osVersion.isEmpty()) {
            this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, AdError.UNDEFINED_DOMAIN));
        }
        EnvironmentInformation environmentInformation = this.agentImpl.getEnvironmentInformation();
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.OS_NAME_ATTRIBUTE, deviceInformation.getOsName()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.OS_BUILD_ATTRIBUTE, deviceInformation.getOsBuild()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.DEVICE_MANUFACTURER_ATTRIBUTE, deviceInformation.getManufacturer()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE, deviceInformation.getModel()));
        this.systemAttributes.add(new AnalyticsAttribute("uuid", deviceInformation.getDeviceId()));
        this.systemAttributes.add(new AnalyticsAttribute("carrier", agentImpl2.getNetworkCarrier()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.NEW_RELIC_VERSION_ATTRIBUTE, deviceInformation.getAgentVersion()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.MEM_USAGE_MB_ATTRIBUTE, (double) ((float) environmentInformation.getMemoryUsage())));
        this.systemAttributes.add(new AnalyticsAttribute("sessionId", agentConfiguration.getSessionID()));
        this.systemAttributes.add(new AnalyticsAttribute("platform", agentConfiguration.getApplicationFramework().toString()));
        this.systemAttributes.add(new AnalyticsAttribute("platformVersion", agentConfiguration.getApplicationFrameworkVersion()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.RUNTIME_ATTRIBUTE, deviceInformation.getRunTime()));
        this.systemAttributes.add(new AnalyticsAttribute(AnalyticsAttribute.ARCHITECTURE_ATTRIBUTE, deviceInformation.getArchitecture()));
        if (agentConfiguration.getCustomBuildIdentifier() != null) {
            this.systemAttributes.add(new AnalyticsAttribute("appBuild", agentConfiguration.getCustomBuildIdentifier()));
            return;
        }
        String valueOf = String.valueOf(Agent.getApplicationInformation().getVersionCode());
        if (!valueOf.isEmpty()) {
            this.systemAttributes.add(new AnalyticsAttribute("appBuild", valueOf));
        }
    }

    public boolean removeAllAttributes() {
        AgentLog agentLog = log;
        int count = this.attributeStore.count();
        int size = this.userAttributes.size();
        agentLog.audit("AnalyticsControllerImpl.removeAttributes(): " + count + size);
        if (!isInitializedAndEnabled()) {
            return false;
        }
        this.attributeStore.clear();
        this.userAttributes.clear();
        return true;
    }

    public boolean removeAttribute(String str) {
        AgentLog agentLog = log;
        agentLog.audit("AnalyticsControllerImpl.removeAttribute(" + str + ")");
        if (!isInitializedAndEnabled()) {
            return false;
        }
        AnalyticsAttribute attribute = getAttribute(str);
        if (attribute == null) {
            return true;
        }
        this.userAttributes.remove(attribute);
        if (!attribute.isPersistent()) {
            return true;
        }
        this.attributeStore.delete(attribute);
        return true;
    }

    public boolean setAttribute(String str, String str2) {
        return setAttribute(str, str2, true);
    }

    public void setEnabled(boolean z11) {
        this.isEnabled.set(z11);
    }

    public void setMaxEventBufferTime(int i11) {
        this.eventManager.setMaxEventBufferTime(i11);
    }

    public void setMaxEventPoolSize(int i11) {
        this.eventManager.setMaxEventPoolSize(i11);
    }

    public boolean addEvent(String str, AnalyticsEventCategory analyticsEventCategory, String str2, Set<AnalyticsAttribute> set) {
        if (!isInitializedAndEnabled()) {
            return false;
        }
        return addEvent(AnalyticsEventFactory.createEvent(str, analyticsEventCategory, str2, set));
    }

    public boolean incrementAttribute(String str, double d11, boolean z11) {
        AgentLog agentLog = log;
        String str2 = z11 ? " (persistent)" : " (transient)";
        agentLog.audit("AnalyticsControllerImpl.incrementAttribute(" + str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + d11 + ") " + str2);
        if (!isInitializedAndEnabled() || !validator.isValidAttributeName(str)) {
            return false;
        }
        AnalyticsAttribute attribute = getAttribute(str);
        if (attribute != null && attribute.isDoubleAttribute()) {
            attribute.setDoubleValue(attribute.getDoubleValue() + d11);
            attribute.setPersistent(z11);
            if (!attribute.isPersistent() || this.attributeStore.store(attribute)) {
                return true;
            }
            agentLog.error("Failed to store attribute " + attribute + " to attribute store.");
            return false;
        } else if (attribute == null) {
            return addNewUserAttribute(new AnalyticsAttribute(str, d11, z11));
        } else {
            agentLog.warn("Cannot increment attribute " + str + ": the attribute is already defined as a non-float value.");
            return false;
        }
    }

    public boolean setAttribute(String str, String str2, boolean z11) {
        AgentLog agentLog = log;
        String str3 = z11 ? "(persistent)" : "(transient)";
        agentLog.audit("AnalyticsControllerImpl.setAttribute(" + str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str2 + ")" + str3);
        if (!isInitializedAndEnabled()) {
            return false;
        }
        AnalyticsValidator analyticsValidator = validator;
        if (!analyticsValidator.isValidAttributeName(str) || !analyticsValidator.isValidAttributeValue(str, str2)) {
            return false;
        }
        AnalyticsAttribute attribute = getAttribute(str);
        if (attribute == null) {
            return addNewUserAttribute(new AnalyticsAttribute(str, str2, z11));
        }
        attribute.setStringValue(str2);
        attribute.setPersistent(z11);
        if (!attribute.isPersistent()) {
            this.attributeStore.delete(attribute);
            return true;
        } else if (this.attributeStore.store(attribute)) {
            return true;
        } else {
            agentLog.error("Failed to store attribute [" + attribute + "] to attribute store.");
            return false;
        }
    }

    public boolean addEvent(AnalyticsEvent analyticsEvent) {
        AgentLog agentLog = log;
        String eventType = analyticsEvent.getName() == null ? analyticsEvent.getEventType() : analyticsEvent.getName();
        agentLog.audit("AnalyticsControllerImpl.addEvent(" + eventType + ")");
        if (!isInitializedAndEnabled()) {
            return false;
        }
        HashSet hashSet = new HashSet();
        long sessionDurationMillis = this.agentImpl.getSessionDurationMillis();
        if (0 == sessionDurationMillis) {
            agentLog.error("Harvest instance is not running! Session duration will be invalid");
        } else {
            hashSet.add(new AnalyticsAttribute(AnalyticsAttribute.SESSION_TIME_SINCE_LOAD_ATTRIBUTE, (double) (((float) sessionDurationMillis) / 1000.0f)));
            analyticsEvent.addAttributes(hashSet);
        }
        return this.eventManager.addEvent(analyticsEvent);
    }

    public boolean setAttribute(String str, double d11) {
        return setAttribute(str, d11, true);
    }

    public boolean setAttribute(String str, double d11, boolean z11) {
        AgentLog agentLog = log;
        String str2 = z11 ? " (persistent)" : " (transient)";
        agentLog.audit("AnalyticsControllerImpl.setAttribute(" + str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + d11 + ")" + str2);
        if (!isInitializedAndEnabled() || !validator.isValidAttributeName(str)) {
            return false;
        }
        AnalyticsAttribute attribute = getAttribute(str);
        if (attribute == null) {
            return addNewUserAttribute(new AnalyticsAttribute(str, d11, z11));
        }
        attribute.setDoubleValue(d11);
        attribute.setPersistent(z11);
        if (!attribute.isPersistent()) {
            this.attributeStore.delete(attribute);
            return true;
        } else if (this.attributeStore.store(attribute)) {
            return true;
        } else {
            agentLog.error("Failed to store attribute [" + attribute + "] to attribute store.");
            return false;
        }
    }

    public boolean setAttribute(String str, boolean z11) {
        return setAttribute(str, z11, true);
    }

    public boolean setAttribute(String str, boolean z11, boolean z12) {
        AgentLog agentLog = log;
        String str2 = z12 ? " (persistent)" : " (transient)";
        agentLog.audit("AnalyticsControllerImpl.setAttribute(" + str + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + z11 + ")" + str2);
        if (!isInitializedAndEnabled() || !validator.isValidAttributeName(str)) {
            return false;
        }
        AnalyticsAttribute attribute = getAttribute(str);
        if (attribute == null) {
            return addNewUserAttribute(new AnalyticsAttribute(str, z11, z12));
        }
        attribute.setBooleanValue(z11);
        attribute.setPersistent(z12);
        if (!attribute.isPersistent()) {
            this.attributeStore.delete(attribute);
            return true;
        } else if (this.attributeStore.store(attribute)) {
            return true;
        } else {
            agentLog.error("Failed to store attribute [" + attribute + "] to attribute store.");
            return false;
        }
    }
}
