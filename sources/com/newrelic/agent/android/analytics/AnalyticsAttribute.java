package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnalyticsAttribute {
    public static final String ACCOUNT_ID_ATTRIBUTE = "accountId";
    public static final String ACTION_TYPE_ATTRIBUTE = "actionType";
    public static final String ANR = "ANR";
    public static final String APPLICATION_PLATFORM_ATTRIBUTE = "platform";
    public static final String APPLICATION_PLATFORM_VERSION_ATTRIBUTE = "platformVersion";
    public static final String APP_BUILD_ATTRIBUTE = "appBuild";
    public static final String APP_DATA_ATTRIBUTE = "nr.X-NewRelic-App-Data";
    public static final String APP_ID_ATTRIBUTE = "appId";
    public static final String APP_INSTALL_ATTRIBUTE = "install";
    public static final String APP_NAME_ATTRIBUTE = "appName";
    public static final String APP_UPGRADE_ATTRIBUTE = "upgradeFrom";
    public static final String ARCHITECTURE_ATTRIBUTE = "architecture";
    public static final int ATTRIBUTE_NAME_MAX_LENGTH = 255;
    public static final int ATTRIBUTE_VALUE_MAX_LENGTH = 4096;
    public static final String BYTES_RECEIVED_ATTRIBUTE = "bytesReceived";
    public static final String BYTES_SENT_ATTRIBUTE = "bytesSent";
    public static final String CARRIER_ATTRIBUTE = "carrier";
    public static final String CONNECTION_TYPE_ATTRIBUTE = "connectionType";
    public static final String CONTENT_TYPE_ATTRIBUTE = "contentType";
    public static final String DEVICE_MANUFACTURER_ATTRIBUTE = "deviceManufacturer";
    public static final String DEVICE_MODEL_ATTRIBUTE = "deviceModel";
    public static final String EVENT_CATEGORY_ATTRIBUTE = "category";
    public static final String EVENT_NAME_ATTRIBUTE = "name";
    public static final String EVENT_TIMESTAMP_ATTRIBUTE = "timestamp";
    public static final String EVENT_TYPE_ATTRIBUTE = "eventType";
    public static final String INSTANT_APP_ATTRIBUTE = "instantApp";
    public static final String INTERACTION_DURATION_ATTRIBUTE = "interactionDuration";
    public static final String LAST_INTERACTION_ATTRIBUTE = "lastInteraction";
    public static final String MEM_USAGE_MB_ATTRIBUTE = "memUsageMb";
    public static final String MUTABLE = "mutable";
    public static final String NATIVE_CRASH = "nativeCrash";
    public static final String NETWORK_ERROR_CODE_ATTRIBUTE = "networkErrorCode";
    public static final String NEW_RELIC_VERSION_ATTRIBUTE = "newRelicVersion";
    public static final String OS_BUILD_ATTRIBUTE = "osBuild";
    public static final String OS_MAJOR_VERSION_ATTRIBUTE = "osMajorVersion";
    public static final String OS_NAME_ATTRIBUTE = "osName";
    public static final String OS_VERSION_ATTRIBUTE = "osVersion";
    public static final String REQUEST_DOMAIN_ATTRIBUTE = "requestDomain";
    public static final String REQUEST_METHOD_ATTRIBUTE = "requestMethod";
    public static final String REQUEST_PATH_ATTRIBUTE = "requestPath";
    public static final String REQUEST_URL_ATTRIBUTE = "requestUrl";
    public static final String RESPONSE_BODY_ATTRIBUTE = "nr.responseBody";
    public static final String RESPONSE_TIME_ATTRIBUTE = "responseTime";
    public static final String RUNTIME_ATTRIBUTE = "runTime";
    public static final String SESSION_DURATION_ATTRIBUTE = "sessionDuration";
    public static final String SESSION_ID_ATTRIBUTE = "sessionId";
    public static final String SESSION_TIME_SINCE_LOAD_ATTRIBUTE = "timeSinceLoad";
    public static final String STATUS_CODE_ATTRIBUTE = "statusCode";
    public static final String TYPE_ATTRIBUTE = "type";
    public static final String UNHANDLED_NATIVE_EXCEPTION = "unhandledNativeException";
    public static final String USER_ID_ATTRIBUTE = "userId";
    public static final String UUID_ATTRIBUTE = "uuid";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static final AnalyticsValidator validator = new AnalyticsValidator();
    private AttributeDataType attributeDataType;
    private double doubleValue;
    private boolean isPersistent;

    /* renamed from: name  reason: collision with root package name */
    private String f52777name;
    private String stringValue;

    /* renamed from: com.newrelic.agent.android.analytics.AnalyticsAttribute$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType[] r0 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType = r0
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.VOID     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.STRING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.analytics.AnalyticsAttribute.AnonymousClass1.<clinit>():void");
        }
    }

    public enum AttributeDataType {
        VOID,
        STRING,
        DOUBLE,
        BOOLEAN
    }

    public AnalyticsAttribute() {
        this.stringValue = null;
        this.doubleValue = Double.NaN;
        this.isPersistent = false;
        this.attributeDataType = AttributeDataType.VOID;
    }

    public static AnalyticsAttribute createAttribute(String str, Object obj) {
        try {
            AnalyticsValidator analyticsValidator = validator;
            if (!analyticsValidator.isValidAttributeName(str)) {
                return null;
            }
            if (obj instanceof String) {
                if (analyticsValidator.isValidAttributeValue(str, (String) obj)) {
                    return new AnalyticsAttribute(str, String.valueOf(obj));
                }
                return null;
            } else if (obj instanceof Float) {
                return new AnalyticsAttribute(str, (double) ((Float) obj).floatValue());
            } else {
                if (obj instanceof Double) {
                    return new AnalyticsAttribute(str, ((Double) obj).doubleValue());
                }
                if (obj instanceof Integer) {
                    return new AnalyticsAttribute(str, Double.valueOf((double) ((Integer) obj).intValue()).doubleValue());
                }
                if (obj instanceof Short) {
                    return new AnalyticsAttribute(str, Double.valueOf((double) ((Short) obj).shortValue()).doubleValue());
                }
                if (obj instanceof Long) {
                    return new AnalyticsAttribute(str, Double.valueOf((double) ((Long) obj).longValue()).doubleValue());
                }
                if (obj instanceof BigDecimal) {
                    return new AnalyticsAttribute(str, ((BigDecimal) obj).doubleValue());
                }
                if (obj instanceof BigInteger) {
                    return new AnalyticsAttribute(str, ((BigInteger) obj).doubleValue());
                }
                if (obj instanceof Boolean) {
                    return new AnalyticsAttribute(str, ((Boolean) obj).booleanValue());
                }
                AgentLog agentLog = log;
                String name2 = obj.getClass().getName();
                agentLog.error("Unsupported event attribute type for key [" + str + "]: " + name2);
                return null;
            }
        } catch (ClassCastException e11) {
            log.error(String.format("Error casting attribute [%s] to String or Float: ", new Object[]{str}), e11);
            return null;
        }
    }

    public static Set<AnalyticsAttribute> newFromJson(JsonObject jsonObject) {
        HashSet hashSet = new HashSet();
        for (Map.Entry next : jsonObject.entrySet()) {
            String str = (String) next.getKey();
            if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = ((JsonElement) next.getValue()).getAsJsonPrimitive();
                if (asJsonPrimitive.isString()) {
                    hashSet.add(new AnalyticsAttribute(str, asJsonPrimitive.getAsString(), false));
                } else if (asJsonPrimitive.isBoolean()) {
                    hashSet.add(new AnalyticsAttribute(str, asJsonPrimitive.getAsBoolean(), false));
                } else if (asJsonPrimitive.isNumber()) {
                    hashSet.add(new AnalyticsAttribute(str, asJsonPrimitive.getAsDouble(), false));
                }
            } else {
                hashSet.add(new AnalyticsAttribute(str, ((JsonElement) next.getValue()).getAsString(), false));
            }
        }
        return hashSet;
    }

    public JsonElement asJsonElement() {
        int i11 = AnonymousClass1.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType[this.attributeDataType.ordinal()];
        if (i11 == 2) {
            return SafeJsonPrimitive.factory(getStringValue());
        }
        if (i11 == 3) {
            return SafeJsonPrimitive.factory(Double.valueOf(getDoubleValue()));
        }
        if (i11 != 4) {
            return null;
        }
        return SafeJsonPrimitive.factory(Boolean.valueOf(getBooleanValue()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !this.f52777name.equals(((AnalyticsAttribute) obj).f52777name)) {
            return false;
        }
        return true;
    }

    public AttributeDataType getAttributeDataType() {
        return this.attributeDataType;
    }

    public boolean getBooleanValue() {
        if (this.attributeDataType == AttributeDataType.BOOLEAN) {
            return Boolean.valueOf(this.stringValue).booleanValue();
        }
        return false;
    }

    public double getDoubleValue() {
        if (this.attributeDataType == AttributeDataType.DOUBLE) {
            return this.doubleValue;
        }
        return Double.NaN;
    }

    public String getName() {
        return this.f52777name;
    }

    public String getStringValue() {
        if (this.attributeDataType == AttributeDataType.STRING) {
            return this.stringValue;
        }
        return null;
    }

    public int hashCode() {
        return this.f52777name.hashCode();
    }

    public boolean isBooleanAttribute() {
        return this.attributeDataType == AttributeDataType.BOOLEAN;
    }

    public boolean isDoubleAttribute() {
        return this.attributeDataType == AttributeDataType.DOUBLE;
    }

    public boolean isPersistent() {
        return this.isPersistent && !validator.isExcludedAttributeName(this.f52777name);
    }

    public boolean isStringAttribute() {
        return this.attributeDataType == AttributeDataType.STRING;
    }

    public boolean isValid() {
        return validator.isValidAttribute(this);
    }

    public void setBooleanValue(boolean z11) {
        this.stringValue = Boolean.toString(z11);
        this.doubleValue = Double.NaN;
        this.attributeDataType = AttributeDataType.BOOLEAN;
    }

    public void setDoubleValue(double d11) {
        this.doubleValue = d11;
        this.stringValue = null;
        this.attributeDataType = AttributeDataType.DOUBLE;
    }

    public void setPersistent(boolean z11) {
        this.isPersistent = z11;
    }

    public void setStringValue(String str) {
        this.doubleValue = Double.NaN;
        this.stringValue = str;
        this.attributeDataType = AttributeDataType.STRING;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AnalyticsAttribute{");
        String str = this.f52777name;
        sb2.append("name='" + str + "'");
        int i11 = AnonymousClass1.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType[this.attributeDataType.ordinal()];
        if (i11 == 2) {
            String str2 = this.stringValue;
            sb2.append(",stringValue='" + str2 + "'");
        } else if (i11 == 3) {
            double d11 = this.doubleValue;
            sb2.append(",doubleValue='" + d11 + "'");
        } else if (i11 == 4) {
            String bool = Boolean.valueOf(this.stringValue).toString();
            sb2.append(",booleanValue=" + bool);
        }
        boolean z11 = this.isPersistent;
        sb2.append(",isPersistent=" + z11);
        sb2.append("}");
        return sb2.toString();
    }

    public String valueAsString() {
        int i11 = AnonymousClass1.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType[this.attributeDataType.ordinal()];
        if (i11 == 2) {
            return this.stringValue;
        }
        if (i11 == 3) {
            return Double.toString(this.doubleValue);
        }
        if (i11 != 4) {
            return null;
        }
        return Boolean.valueOf(getBooleanValue()).toString();
    }

    public AnalyticsAttribute(String str, String str2) {
        this(str, str2, true);
    }

    public AnalyticsAttribute(String str, String str2, boolean z11) {
        this.f52777name = str;
        setStringValue(str2);
        this.isPersistent = z11;
    }

    public AnalyticsAttribute(String str, double d11) {
        this(str, d11, true);
    }

    public AnalyticsAttribute(String str, double d11, boolean z11) {
        this.f52777name = str;
        setDoubleValue(d11);
        this.isPersistent = z11;
    }

    public AnalyticsAttribute(String str, boolean z11) {
        this(str, z11, true);
    }

    public AnalyticsAttribute(String str, boolean z11, boolean z12) {
        this.f52777name = str;
        setBooleanValue(z11);
        this.isPersistent = z12;
    }

    public AnalyticsAttribute(AnalyticsAttribute analyticsAttribute) {
        this.f52777name = analyticsAttribute.f52777name;
        this.doubleValue = analyticsAttribute.doubleValue;
        this.stringValue = analyticsAttribute.stringValue;
        this.isPersistent = analyticsAttribute.isPersistent;
        this.attributeDataType = analyticsAttribute.attributeDataType;
    }
}
