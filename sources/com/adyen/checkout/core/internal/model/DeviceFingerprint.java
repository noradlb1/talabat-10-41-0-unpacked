package com.adyen.checkout.core.internal.model;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.Base64Coder;
import com.adyen.checkout.base.internal.Json;
import com.adyen.checkout.base.internal.JsonEncodable;
import com.adyen.checkout.core.CheckoutException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class DeviceFingerprint extends JsonEncodable {
    private static final String DEVICE_FINGERPRINT_VERSION = "1.0";
    private static final String DEVICE_MODEL = (Build.MANUFACTURER + " " + Build.DEVICE);
    private static final String OS_VERSION = String.valueOf(Build.VERSION.SDK_INT);
    private static final String PLATFORM = "Android";
    private static final String SDK_VERSION = "2.4.13";
    private final String mDeviceIdentifier;
    private final String mGenerationTime;
    private final String mIntegration;
    private final Locale mLocale;

    private DeviceFingerprint(@NonNull Context context, @NonNull String str) {
        this.mDeviceIdentifier = Settings.Secure.getString(context.getContentResolver(), "android_id");
        this.mIntegration = str;
        if (Build.VERSION.SDK_INT < 24) {
            this.mLocale = context.getResources().getConfiguration().locale;
        } else {
            this.mLocale = context.getResources().getConfiguration().getLocales().get(0);
        }
        this.mGenerationTime = Json.serializeDate(new Date());
    }

    @NonNull
    public static String generateSdkToken(@NonNull Context context, @NonNull String str) throws CheckoutException {
        try {
            return Base64Coder.encode(new DeviceFingerprint(context, str), 2);
        } catch (JSONException e11) {
            throw new CheckoutException.Builder("Error generating SDK token.", e11).setFatal(true).build();
        }
    }

    private String getLocaleWithoutScript(@NonNull Locale locale) {
        return String.format("%s_%s", new Object[]{locale.getLanguage(), locale.getCountry()});
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DeviceFingerprint.class != obj.getClass()) {
            return false;
        }
        DeviceFingerprint deviceFingerprint = (DeviceFingerprint) obj;
        String str = this.mDeviceIdentifier;
        if (str == null ? deviceFingerprint.mDeviceIdentifier != null : !str.equals(deviceFingerprint.mDeviceIdentifier)) {
            return false;
        }
        String str2 = this.mIntegration;
        if (str2 == null ? deviceFingerprint.mIntegration != null : !str2.equals(deviceFingerprint.mIntegration)) {
            return false;
        }
        Locale locale = this.mLocale;
        if (locale == null ? deviceFingerprint.mLocale != null : !locale.equals(deviceFingerprint.mLocale)) {
            return false;
        }
        String str3 = this.mGenerationTime;
        String str4 = deviceFingerprint.mGenerationTime;
        if (str3 != null) {
            return str3.equals(str4);
        }
        if (str4 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        String str = this.mDeviceIdentifier;
        int i14 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i15 = i11 * 31;
        String str2 = this.mIntegration;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i16 = (i15 + i12) * 31;
        Locale locale = this.mLocale;
        if (locale != null) {
            i13 = locale.hashCode();
        } else {
            i13 = 0;
        }
        int i17 = (i16 + i13) * 31;
        String str3 = this.mGenerationTime;
        if (str3 != null) {
            i14 = str3.hashCode();
        }
        return i17 + i14;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceFingerprintVersion", (Object) "1.0");
        jSONObject.put("platform", (Object) "Android");
        jSONObject.put(AnalyticsAttribute.OS_VERSION_ATTRIBUTE, (Object) OS_VERSION);
        jSONObject.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, (Object) "2.4.13");
        jSONObject.put(AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE, (Object) DEVICE_MODEL);
        jSONObject.put("deviceIdentifier", (Object) this.mDeviceIdentifier);
        jSONObject.put("integration", (Object) this.mIntegration);
        jSONObject.put("locale", (Object) getLocaleWithoutScript(this.mLocale));
        jSONObject.put("generationTime", (Object) this.mGenerationTime);
        return jSONObject;
    }
}
