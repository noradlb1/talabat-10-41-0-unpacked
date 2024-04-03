package com.facebook.appevents;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Instrumented
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 '2\u00020\u0001:\u0002'(BE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB)\b\u0012\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\b\u0010\u001d\u001a\u00020\u0003H\u0002J\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u0017J;\u0010 \u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0003H\u0016J\u001e\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030$2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020&H\u0002R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/facebook/appevents/AppEvent;", "Ljava/io/Serializable;", "contextName", "", "eventName", "valueToSum", "", "parameters", "Landroid/os/Bundle;", "isImplicitlyLogged", "", "isInBackground", "currentSessionId", "Ljava/util/UUID;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;ZZLjava/util/UUID;)V", "jsonString", "isImplicit", "inBackground", "checksum", "(Ljava/lang/String;ZZLjava/lang/String;)V", "isChecksumValid", "()Z", "jsonObject", "Lorg/json/JSONObject;", "getJsonObject", "()Lorg/json/JSONObject;", "name", "getName", "()Ljava/lang/String;", "calculateChecksum", "getIsImplicit", "getJSONObject", "getJSONObjectForAppEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;Ljava/util/UUID;)Lorg/json/JSONObject;", "toString", "validateParameters", "", "writeReplace", "", "Companion", "SerializationProxyV2", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppEvent implements Serializable {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_IDENTIFIER_LENGTH = 40;
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    @NotNull
    public static final HashSet<String> validatedIdentifiers = new HashSet<>();
    @Nullable
    private final String checksum;
    private final boolean inBackground;
    private final boolean isImplicit;
    @NotNull
    private final JSONObject jsonObject;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f33576name;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/appevents/AppEvent$Companion;", "", "()V", "MAX_IDENTIFIER_LENGTH", "", "serialVersionUID", "", "validatedIdentifiers", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "md5Checksum", "toHash", "validateIdentifier", "", "identifier", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String md5Checksum(String str) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
                if (str != null) {
                    byte[] bytes = str.getBytes(forName);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    instance.update(bytes, 0, bytes.length);
                    byte[] digest = instance.digest();
                    Intrinsics.checkNotNullExpressionValue(digest, "digest.digest()");
                    return AppEventUtility.bytesToHex(digest);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (NoSuchAlgorithmException e11) {
                Utility.logd("Failed to generate checksum: ", (Exception) e11);
                return "0";
            } catch (UnsupportedEncodingException e12) {
                Utility.logd("Failed to generate checksum: ", (Exception) e12);
                return "1";
            }
        }

        /* access modifiers changed from: private */
        public final void validateIdentifier(String str) {
            boolean z11;
            boolean contains;
            if (str != null) {
                if (str.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11 && str.length() <= 40) {
                    synchronized (AppEvent.validatedIdentifiers) {
                        contains = AppEvent.validatedIdentifiers.contains(str);
                        Unit unit = Unit.INSTANCE;
                    }
                    if (contains) {
                        return;
                    }
                    if (new Regex("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$").matches(str)) {
                        synchronized (AppEvent.validatedIdentifiers) {
                            AppEvent.validatedIdentifiers.add(str);
                        }
                        return;
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", Arrays.copyOf(new Object[]{str}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                    throw new FacebookException(format);
                }
            }
            if (str == null) {
                str = "<None Provided>";
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", Arrays.copyOf(new Object[]{str, 40}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/AppEvent$SerializationProxyV2;", "Ljava/io/Serializable;", "jsonString", "", "isImplicit", "", "inBackground", "checksum", "(Ljava/lang/String;ZZLjava/lang/String;)V", "readResolve", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SerializationProxyV2 implements Serializable {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 20160803001L;
        @Nullable
        private final String checksum;
        private final boolean inBackground;
        private final boolean isImplicit;
        @NotNull
        private final String jsonString;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/AppEvent$SerializationProxyV2$Companion;", "", "()V", "serialVersionUID", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public SerializationProxyV2(@NotNull String str, boolean z11, boolean z12, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "jsonString");
            this.jsonString = str;
            this.isImplicit = z11;
            this.inBackground = z12;
            this.checksum = str2;
        }

        private final Object readResolve() throws JSONException, ObjectStreamException {
            return new AppEvent(this.jsonString, this.isImplicit, this.inBackground, this.checksum, (DefaultConstructorMarker) null);
        }
    }

    public AppEvent(@NotNull String str, @NotNull String str2, @Nullable Double d11, @Nullable Bundle bundle, boolean z11, boolean z12, @Nullable UUID uuid) throws JSONException, FacebookException {
        Intrinsics.checkNotNullParameter(str, "contextName");
        Intrinsics.checkNotNullParameter(str2, "eventName");
        this.isImplicit = z11;
        this.inBackground = z12;
        this.f33576name = str2;
        this.jsonObject = getJSONObjectForAppEvent(str, str2, d11, bundle, uuid);
        this.checksum = calculateChecksum();
    }

    public /* synthetic */ AppEvent(String str, boolean z11, boolean z12, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z11, z12, str2);
    }

    private final String calculateChecksum() {
        Companion companion = Companion;
        JSONObject jSONObject = this.jsonObject;
        String jSONObject2 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return companion.md5Checksum(jSONObject2);
    }

    private final JSONObject getJSONObjectForAppEvent(String str, String str2, Double d11, Bundle bundle, UUID uuid) {
        Companion companion = Companion;
        companion.validateIdentifier(str2);
        JSONObject jSONObject = new JSONObject();
        String processEvent = RestrictiveDataManager.processEvent(str2);
        jSONObject.put(Constants.EVENT_NAME_EVENT_KEY, (Object) processEvent);
        jSONObject.put(Constants.EVENT_NAME_MD5_EVENT_KEY, (Object) companion.md5Checksum(processEvent));
        jSONObject.put(Constants.LOG_TIME_APP_EVENT_KEY, System.currentTimeMillis() / ((long) 1000));
        jSONObject.put("_ui", (Object) str);
        if (uuid != null) {
            jSONObject.put("_session_id", (Object) uuid);
        }
        if (bundle != null) {
            Map<String, String> validateParameters = validateParameters(bundle);
            for (String next : validateParameters.keySet()) {
                jSONObject.put(next, (Object) validateParameters.get(next));
            }
        }
        if (d11 != null) {
            jSONObject.put(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, d11.doubleValue());
        }
        if (this.inBackground) {
            jSONObject.put("_inBackground", (Object) "1");
        }
        if (this.isImplicit) {
            jSONObject.put("_implicitlyLogged", (Object) "1");
        } else {
            Logger.Companion companion2 = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
            Intrinsics.checkNotNullExpressionValue(jSONObjectInstrumentation, "eventObject.toString()");
            companion2.log(loggingBehavior, "AppEvents", "Created app event '%s'", jSONObjectInstrumentation);
        }
        return jSONObject;
    }

    private final Map<String, String> validateParameters(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String next : bundle.keySet()) {
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue(next, "key");
            companion.validateIdentifier(next);
            Object obj = bundle.get(next);
            if ((obj instanceof String) || (obj instanceof Number)) {
                hashMap.put(next, obj.toString());
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", Arrays.copyOf(new Object[]{obj, next}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                throw new FacebookException(format);
            }
        }
        IntegrityManager.processParameters(hashMap);
        RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
        RestrictiveDataManager.processParameters(hashMap, this.f33576name);
        EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
        EventDeactivationManager.processDeprecatedParameters(hashMap, this.f33576name);
        return hashMap;
    }

    private final Object writeReplace() throws ObjectStreamException {
        JSONObject jSONObject = this.jsonObject;
        String jSONObject2 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return new SerializationProxyV2(jSONObject2, this.isImplicit, this.inBackground, this.checksum);
    }

    public final boolean getIsImplicit() {
        return this.isImplicit;
    }

    @NotNull
    public final JSONObject getJSONObject() {
        return this.jsonObject;
    }

    @NotNull
    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    @NotNull
    public final String getName() {
        return this.f33576name;
    }

    public final boolean isChecksumValid() {
        if (this.checksum == null) {
            return true;
        }
        return Intrinsics.areEqual((Object) calculateChecksum(), (Object) this.checksum);
    }

    public final boolean isImplicit() {
        return this.isImplicit;
    }

    @NotNull
    public String toString() {
        String str;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[3];
        objArr[0] = this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY);
        objArr[1] = Boolean.valueOf(this.isImplicit);
        JSONObject jSONObject = this.jsonObject;
        if (!(jSONObject instanceof JSONObject)) {
            str = jSONObject.toString();
        } else {
            str = JSONObjectInstrumentation.toString(jSONObject);
        }
        objArr[2] = str;
        String format = String.format("\"%s\", implicit: %b, json: %s", Arrays.copyOf(objArr, 3));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    private AppEvent(String str, boolean z11, boolean z12, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        this.jsonObject = jSONObject;
        this.isImplicit = z11;
        String optString = jSONObject.optString(Constants.EVENT_NAME_EVENT_KEY);
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY)");
        this.f33576name = optString;
        this.checksum = str2;
        this.inBackground = z12;
    }
}
