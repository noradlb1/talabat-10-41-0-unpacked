package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AnalyticsEvent extends HarvestableObject {
    public static final String EVENT_NAME_IS_TYPE = null;
    public static final int EVENT_NAME_MAX_LENGTH = 255;
    public static final int EVENT_TYPE_LIMIT = 250;
    public static final String EVENT_TYPE_MOBILE = "Mobile";
    public static final String EVENT_TYPE_MOBILE_BREADCRUMB = "MobileBreadcrumb";
    public static final String EVENT_TYPE_MOBILE_CRASH = "MobileCrash";
    public static final String EVENT_TYPE_MOBILE_REQUEST = "MobileRequest";
    public static final String EVENT_TYPE_MOBILE_REQUEST_ERROR = "MobileRequestError";
    public static final String EVENT_TYPE_MOBILE_USER_ACTION = "MobileUserAction";
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    protected static final AnalyticsValidator validator = new AnalyticsValidator();
    protected Set<AnalyticsAttribute> attributeSet;
    protected AnalyticsEventCategory category;
    protected String eventType;

    /* renamed from: name  reason: collision with root package name */
    protected String f52778name;
    protected long timestamp;

    public AnalyticsEvent(String str) {
        this(str, AnalyticsEventCategory.Custom, (String) null, (Set<AnalyticsAttribute>) null);
    }

    public static AnalyticsEvent newFromJson(JsonObject jsonObject) {
        HashSet hashSet = new HashSet();
        String str = null;
        long j11 = 0;
        String str2 = null;
        AnalyticsEventCategory analyticsEventCategory = null;
        for (Map.Entry next : jsonObject.entrySet()) {
            String str3 = (String) next.getKey();
            if (str3.equalsIgnoreCase("name")) {
                str2 = ((JsonElement) next.getValue()).getAsString();
            } else if (str3.equalsIgnoreCase("category")) {
                analyticsEventCategory = AnalyticsEventCategory.fromString(((JsonElement) next.getValue()).getAsString());
            } else if (str3.equalsIgnoreCase(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE)) {
                str = ((JsonElement) next.getValue()).getAsString();
            } else if (str3.equalsIgnoreCase("timestamp")) {
                j11 = ((JsonElement) next.getValue()).getAsLong();
            } else {
                JsonPrimitive asJsonPrimitive = ((JsonElement) next.getValue()).getAsJsonPrimitive();
                if (asJsonPrimitive.isString()) {
                    hashSet.add(new AnalyticsAttribute(str3, asJsonPrimitive.getAsString(), false));
                } else if (asJsonPrimitive.isBoolean()) {
                    hashSet.add(new AnalyticsAttribute(str3, asJsonPrimitive.getAsBoolean(), false));
                } else if (asJsonPrimitive.isNumber()) {
                    hashSet.add(new AnalyticsAttribute(str3, (double) asJsonPrimitive.getAsFloat(), false));
                }
            }
        }
        return new AnalyticsEvent(str2, analyticsEventCategory, str, j11, hashSet);
    }

    public void addAttributes(Set<AnalyticsAttribute> set) {
        if (set != null) {
            for (AnalyticsAttribute next : set) {
                if (!validator.isValidAttribute(next) || !this.attributeSet.add(next)) {
                    AgentLog agentLog = log;
                    String name2 = next.getName();
                    String name3 = getName();
                    agentLog.error("Failed to add attribute " + name2 + " to event " + name3 + ": the attribute is invalid or the event already contains that attribute.");
                }
            }
        }
    }

    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        synchronized (this) {
            for (AnalyticsAttribute next : this.attributeSet) {
                jsonObject.add(next.getName(), next.asJsonElement());
            }
        }
        return jsonObject;
    }

    public Collection<AnalyticsAttribute> getAttributeSet() {
        return Collections.unmodifiableCollection(this.attributeSet);
    }

    public AnalyticsEventCategory getCategory() {
        return this.category;
    }

    public String getEventType() {
        return this.eventType;
    }

    public Collection<AnalyticsAttribute> getMutableAttributeSet() {
        Set<E> checkedSet = Collections.checkedSet(this.attributeSet, AnalyticsAttribute.class);
        checkedSet.add(new AnalyticsAttribute(AnalyticsAttribute.MUTABLE, true));
        return checkedSet;
    }

    public String getName() {
        return this.f52778name;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isValid() {
        return isValid(this.f52778name, this.eventType);
    }

    public AnalyticsEvent(String str, AnalyticsEventCategory analyticsEventCategory) {
        this(str, analyticsEventCategory, (String) null, (Set<AnalyticsAttribute>) null);
    }

    public static boolean isValid(String str, String str2) {
        AnalyticsValidator analyticsValidator = validator;
        return analyticsValidator.isValidEventName(str) && analyticsValidator.isValidEventType(str2) && !analyticsValidator.isReservedEventType(str2);
    }

    public AnalyticsEvent(String str, AnalyticsEventCategory analyticsEventCategory, String str2, Set<AnalyticsAttribute> set) {
        this(str, analyticsEventCategory, str2, System.currentTimeMillis(), set);
    }

    public AnalyticsEvent(AnalyticsEvent analyticsEvent) {
        this(analyticsEvent.f52778name, analyticsEvent.category, analyticsEvent.eventType, analyticsEvent.timestamp, analyticsEvent.attributeSet);
    }

    public AnalyticsEvent(String str, AnalyticsEventCategory analyticsEventCategory, String str2, long j11, Set<AnalyticsAttribute> set) {
        this.attributeSet = Collections.synchronizedSet(new HashSet());
        this.f52778name = str;
        this.timestamp = j11;
        AnalyticsValidator analyticsValidator = validator;
        this.category = analyticsValidator.toValidCategory(analyticsEventCategory);
        this.eventType = analyticsValidator.toValidEventType(str2);
        if (set != null) {
            for (AnalyticsAttribute next : set) {
                if (validator.isValidKeyName(next.getName())) {
                    this.attributeSet.add(new AnalyticsAttribute(next));
                }
            }
        }
        if (validator.isValidEventName(str)) {
            this.attributeSet.add(new AnalyticsAttribute("name", this.f52778name));
        }
        this.attributeSet.add(new AnalyticsAttribute("timestamp", String.valueOf(this.timestamp)));
        this.attributeSet.add(new AnalyticsAttribute("category", this.category.name()));
        this.attributeSet.add(new AnalyticsAttribute(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, this.eventType));
    }

    public static Collection<AnalyticsEvent> newFromJson(JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            arrayList.add(newFromJson(it.next().getAsJsonObject()));
        }
        return arrayList;
    }
}
