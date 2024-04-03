package com.braze.models;

import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0010\b\b\u0018\u0000 !2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\"B!\b\u0000\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000f\u0010\u0006\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/braze/models/FeatureFlag;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "forJsonPut", "deepcopy$android_sdk_base_release", "()Lcom/braze/models/FeatureFlag;", "deepcopy", "", "component1", "", "component2", "component3", "id", "enabled", "properties", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Z", "getEnabled", "()Z", "Lorg/json/JSONObject;", "getProperties", "()Lorg/json/JSONObject;", "<init>", "(Ljava/lang/String;ZLorg/json/JSONObject;)V", "Companion", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class FeatureFlag implements IPutIntoJson<JSONObject> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String ENABLED = "enabled";
    public static final String ID = "id";
    public static final String PROPERTIES = "properties";
    private final boolean enabled;

    /* renamed from: id  reason: collision with root package name */
    private final String f43762id;
    private final JSONObject properties;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/braze/models/FeatureFlag$a;", "", "", "id", "Lcom/braze/models/FeatureFlag;", "a", "(Ljava/lang/String;)Lcom/braze/models/FeatureFlag;", "ENABLED", "Ljava/lang/String;", "ID", "PROPERTIES", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeatureFlag a(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            return new FeatureFlag(str, false, new JSONObject());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f43763b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating FeatureFlag Json.";
        }
    }

    public FeatureFlag(String str, boolean z11, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(jSONObject, PROPERTIES);
        this.f43762id = str;
        this.enabled = z11;
        this.properties = jSONObject;
    }

    public static /* synthetic */ FeatureFlag copy$default(FeatureFlag featureFlag, String str, boolean z11, JSONObject jSONObject, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = featureFlag.f43762id;
        }
        if ((i11 & 2) != 0) {
            z11 = featureFlag.enabled;
        }
        if ((i11 & 4) != 0) {
            jSONObject = featureFlag.properties;
        }
        return featureFlag.copy(str, z11, jSONObject);
    }

    public final String component1() {
        return this.f43762id;
    }

    public final boolean component2() {
        return this.enabled;
    }

    public final JSONObject component3() {
        return this.properties;
    }

    public final FeatureFlag copy(String str, boolean z11, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(jSONObject, PROPERTIES);
        return new FeatureFlag(str, z11, jSONObject);
    }

    public final FeatureFlag deepcopy$android_sdk_base_release() {
        return new FeatureFlag(this.f43762id, this.enabled, JsonUtils.deepcopy(this.properties));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureFlag)) {
            return false;
        }
        FeatureFlag featureFlag = (FeatureFlag) obj;
        return Intrinsics.areEqual((Object) this.f43762id, (Object) featureFlag.f43762id) && this.enabled == featureFlag.enabled && Intrinsics.areEqual((Object) this.properties, (Object) featureFlag.properties);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getId() {
        return this.f43762id;
    }

    public final JSONObject getProperties() {
        return this.properties;
    }

    public int hashCode() {
        int hashCode = this.f43762id.hashCode() * 31;
        boolean z11 = this.enabled;
        if (z11) {
            z11 = true;
        }
        return ((hashCode + (z11 ? 1 : 0)) * 31) + this.properties.hashCode();
    }

    public String toString() {
        return "FeatureFlag(id=" + this.f43762id + ", enabled=" + this.enabled + ", properties=" + this.properties + ')';
    }

    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", (Object) this.f43762id);
            jSONObject.put("enabled", this.enabled);
            jSONObject.put(PROPERTIES, (Object) this.properties);
        } catch (JSONException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) b.f43763b, 4, (Object) null);
        }
        return jSONObject;
    }
}
