package com.google.firebase.remoteconfig.internal;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ConfigContainer {
    static final String ABT_EXPERIMENTS_KEY = "abt_experiments_key";
    static final String CONFIGS_KEY = "configs_key";
    /* access modifiers changed from: private */
    public static final Date DEFAULTS_FETCH_TIME = new Date(0);
    static final String FETCH_TIME_KEY = "fetch_time_key";
    static final String PERSONALIZATION_METADATA_KEY = "personalization_metadata_key";
    static final String TEMPLATE_VERSION_NUMBER_KEY = "template_version_number_key";
    private JSONArray abtExperiments;
    private JSONObject configsJson;
    private JSONObject containerJson;
    private Date fetchTime;
    private JSONObject personalizationMetadata;
    private long templateVersionNumber;

    @Instrumented
    public static class Builder {
        private JSONArray builderAbtExperiments;
        private JSONObject builderConfigsJson;
        private Date builderFetchTime;
        private JSONObject builderPersonalizationMetadata;
        private long builderTemplateVersionNumber;

        public ConfigContainer build() throws JSONException {
            return new ConfigContainer(this.builderConfigsJson, this.builderFetchTime, this.builderAbtExperiments, this.builderPersonalizationMetadata, this.builderTemplateVersionNumber);
        }

        public Builder replaceConfigsWith(Map<String, String> map) {
            this.builderConfigsJson = new JSONObject((Map<?, ?>) map);
            return this;
        }

        public Builder withAbtExperiments(JSONArray jSONArray) {
            try {
                this.builderAbtExperiments = new JSONArray(!(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray));
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withFetchTime(Date date) {
            this.builderFetchTime = date;
            return this;
        }

        public Builder withPersonalizationMetadata(JSONObject jSONObject) {
            try {
                this.builderPersonalizationMetadata = new JSONObject(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder withTemplateVersionNumber(long j11) {
            this.builderTemplateVersionNumber = j11;
            return this;
        }

        private Builder() {
            this.builderConfigsJson = new JSONObject();
            this.builderFetchTime = ConfigContainer.DEFAULTS_FETCH_TIME;
            this.builderAbtExperiments = new JSONArray();
            this.builderPersonalizationMetadata = new JSONObject();
            this.builderTemplateVersionNumber = 0;
        }

        public Builder replaceConfigsWith(JSONObject jSONObject) {
            try {
                this.builderConfigsJson = new JSONObject(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder(ConfigContainer configContainer) {
            this.builderConfigsJson = configContainer.getConfigs();
            this.builderFetchTime = configContainer.getFetchTime();
            this.builderAbtExperiments = configContainer.getAbtExperiments();
            this.builderPersonalizationMetadata = configContainer.getPersonalizationMetadata();
            this.builderTemplateVersionNumber = configContainer.getTemplateVersionNumber();
        }
    }

    public static ConfigContainer copyOf(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(PERSONALIZATION_METADATA_KEY);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        return new ConfigContainer(jSONObject.getJSONObject(CONFIGS_KEY), new Date(jSONObject.getLong(FETCH_TIME_KEY)), jSONObject.getJSONArray(ABT_EXPERIMENTS_KEY), optJSONObject, jSONObject.optLong(TEMPLATE_VERSION_NUMBER_KEY));
    }

    private static ConfigContainer deepCopyOf(JSONObject jSONObject) throws JSONException {
        String str;
        if (!(jSONObject instanceof JSONObject)) {
            str = jSONObject.toString();
        } else {
            str = JSONObjectInstrumentation.toString(jSONObject);
        }
        return copyOf(new JSONObject(str));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigContainer)) {
            return false;
        }
        ConfigContainer configContainer = (ConfigContainer) obj;
        JSONObject jSONObject = this.containerJson;
        if (!(jSONObject instanceof JSONObject)) {
            str = jSONObject.toString();
        } else {
            str = JSONObjectInstrumentation.toString(jSONObject);
        }
        return str.equals(configContainer.toString());
    }

    public JSONArray getAbtExperiments() {
        return this.abtExperiments;
    }

    public Set<String> getChangedParams(ConfigContainer configContainer) throws JSONException {
        String str;
        String str2;
        JSONObject configs = deepCopyOf(configContainer.containerJson).getConfigs();
        HashSet hashSet = new HashSet();
        Iterator<String> keys = getConfigs().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!configContainer.getConfigs().has(next)) {
                hashSet.add(next);
            } else if (!getConfigs().get(next).equals(configContainer.getConfigs().get(next))) {
                hashSet.add(next);
            } else if ((!getPersonalizationMetadata().has(next) || configContainer.getPersonalizationMetadata().has(next)) && (getPersonalizationMetadata().has(next) || !configContainer.getPersonalizationMetadata().has(next))) {
                if (getPersonalizationMetadata().has(next) && configContainer.getPersonalizationMetadata().has(next)) {
                    JSONObject jSONObject = getPersonalizationMetadata().getJSONObject(next);
                    if (!(jSONObject instanceof JSONObject)) {
                        str = jSONObject.toString();
                    } else {
                        str = JSONObjectInstrumentation.toString(jSONObject);
                    }
                    JSONObject jSONObject2 = configContainer.getPersonalizationMetadata().getJSONObject(next);
                    if (!(jSONObject2 instanceof JSONObject)) {
                        str2 = jSONObject2.toString();
                    } else {
                        str2 = JSONObjectInstrumentation.toString(jSONObject2);
                    }
                    if (!str.equals(str2)) {
                        hashSet.add(next);
                    }
                }
                configs.remove(next);
            } else {
                hashSet.add(next);
            }
        }
        Iterator<String> keys2 = configs.keys();
        while (keys2.hasNext()) {
            hashSet.add(keys2.next());
        }
        return hashSet;
    }

    public JSONObject getConfigs() {
        return this.configsJson;
    }

    public Date getFetchTime() {
        return this.fetchTime;
    }

    public JSONObject getPersonalizationMetadata() {
        return this.personalizationMetadata;
    }

    public long getTemplateVersionNumber() {
        return this.templateVersionNumber;
    }

    public int hashCode() {
        return this.containerJson.hashCode();
    }

    public String toString() {
        JSONObject jSONObject = this.containerJson;
        return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
    }

    private ConfigContainer(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2, long j11) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(CONFIGS_KEY, (Object) jSONObject);
        jSONObject3.put(FETCH_TIME_KEY, date.getTime());
        jSONObject3.put(ABT_EXPERIMENTS_KEY, (Object) jSONArray);
        jSONObject3.put(PERSONALIZATION_METADATA_KEY, (Object) jSONObject2);
        jSONObject3.put(TEMPLATE_VERSION_NUMBER_KEY, j11);
        this.configsJson = jSONObject;
        this.fetchTime = date;
        this.abtExperiments = jSONArray;
        this.personalizationMetadata = jSONObject2;
        this.templateVersionNumber = j11;
        this.containerJson = jSONObject3;
    }

    public static Builder newBuilder(ConfigContainer configContainer) {
        return new Builder(configContainer);
    }
}
