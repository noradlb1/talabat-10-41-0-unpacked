package com.facebook.appevents.cloudbridge;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n6.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR@\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e8A@@X\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsCAPIManager;", "", "()V", "SETTINGS_PATH", "", "TAG", "kotlin.jvm.PlatformType", "isEnabled", "", "isEnabled$facebook_core_release", "()Z", "setEnabled$facebook_core_release", "(Z)V", "valuesToSave", "", "savedCloudBridgeCredentials", "getSavedCloudBridgeCredentials$facebook_core_release", "()Ljava/util/Map;", "setSavedCloudBridgeCredentials$facebook_core_release", "(Ljava/util/Map;)V", "enable", "", "getCAPIGSettingsFromGraphResponse", "response", "Lcom/facebook/GraphResponse;", "getCAPIGSettingsFromGraphResponse$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppEventsCAPIManager {
    @NotNull
    public static final AppEventsCAPIManager INSTANCE = new AppEventsCAPIManager();
    @NotNull
    private static final String SETTINGS_PATH = "/cloudbridge_settings";
    private static final String TAG = AppEventsCAPIManager.class.getCanonicalName();
    private static boolean isEnabled;

    private AppEventsCAPIManager() {
    }

    @JvmStatic
    public static final void enable() {
        try {
            GraphRequest graphRequest = new GraphRequest((AccessToken) null, Intrinsics.stringPlus(FacebookSdk.getApplicationId(), SETTINGS_PATH), (Bundle) null, HttpMethod.GET, new a(), (String) null, 32, (DefaultConstructorMarker) null);
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            if (str != null) {
                companion.log(loggingBehavior, str, " \n\nCreating Graph Request: \n=============\n%s\n\n ", graphRequest);
                graphRequest.executeAsync();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (JSONException e11) {
            Logger.Companion companion2 = Logger.Companion;
            LoggingBehavior loggingBehavior2 = LoggingBehavior.APP_EVENTS;
            String str2 = TAG;
            if (str2 != null) {
                companion2.log(loggingBehavior2, str2, " \n\nGraph Request Exception: \n=============\n%s\n\n ", ExceptionsKt__ExceptionsKt.stackTraceToString(e11));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enable$lambda-0  reason: not valid java name */
    public static final void m8901enable$lambda0(GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        INSTANCE.getCAPIGSettingsFromGraphResponse$facebook_core_release(graphResponse);
    }

    @Nullable
    @JvmStatic
    @AutoHandleExceptions
    public static final Map<String, Object> getSavedCloudBridgeCredentials$facebook_core_release() {
        boolean z11;
        boolean z12;
        boolean z13;
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.CLOUDBRIDGE_SAVED_CREDENTIALS, 0);
        if (sharedPreferences == null) {
            return null;
        }
        SettingsAPIFields settingsAPIFields = SettingsAPIFields.DATASETID;
        String string = sharedPreferences.getString(settingsAPIFields.getRawValue(), (String) null);
        SettingsAPIFields settingsAPIFields2 = SettingsAPIFields.URL;
        String string2 = sharedPreferences.getString(settingsAPIFields2.getRawValue(), (String) null);
        SettingsAPIFields settingsAPIFields3 = SettingsAPIFields.ACCESSKEY;
        String string3 = sharedPreferences.getString(settingsAPIFields3.getRawValue(), (String) null);
        if (string == null || StringsKt__StringsJVMKt.isBlank(string)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        if (string2 == null || StringsKt__StringsJVMKt.isBlank(string2)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            return null;
        }
        if (string3 == null || StringsKt__StringsJVMKt.isBlank(string3)) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(settingsAPIFields2.getRawValue(), string2);
        linkedHashMap.put(settingsAPIFields.getRawValue(), string);
        linkedHashMap.put(settingsAPIFields3.getRawValue(), string3);
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG.toString(), " \n\nLoading Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", string, string2, string3);
        return linkedHashMap;
    }

    public final void getCAPIGSettingsFromGraphResponse$facebook_core_release(@NotNull GraphResponse graphResponse) {
        Object obj;
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        boolean z11 = false;
        if (graphResponse.getError() != null) {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            if (str != null) {
                companion.log(loggingBehavior, str, " \n\nGraph Response Error: \n================\nResponse Error: %s\nResponse Error Exception: %s\n\n ", graphResponse.getError().toString(), String.valueOf(graphResponse.getError().getException()));
                Map<String, Object> savedCloudBridgeCredentials$facebook_core_release = getSavedCloudBridgeCredentials$facebook_core_release();
                if (savedCloudBridgeCredentials$facebook_core_release != null) {
                    URL url = new URL(String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.URL.getRawValue())));
                    AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                    String valueOf = String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.DATASETID.getRawValue()));
                    AppEventsConversionsAPITransformerWebRequests.configure(valueOf, url.getProtocol() + "://" + url.getHost(), String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.ACCESSKEY.getRawValue())));
                    isEnabled = true;
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Logger.Companion companion2 = Logger.Companion;
        LoggingBehavior loggingBehavior2 = LoggingBehavior.APP_EVENTS;
        String str2 = TAG;
        if (str2 != null) {
            companion2.log(loggingBehavior2, str2, " \n\nGraph Response Received: \n================\n%s\n\n ", graphResponse);
            JSONObject jSONObject = graphResponse.getJSONObject();
            try {
                Utility utility = Utility.INSTANCE;
                if (jSONObject == null) {
                    obj = null;
                } else {
                    obj = jSONObject.get("data");
                }
                if (obj != null) {
                    Map<String, Object> convertJSONObjectToHashMap = Utility.convertJSONObjectToHashMap(new JSONObject((String) CollectionsKt___CollectionsKt.firstOrNull(Utility.convertJSONArrayToList((JSONArray) obj))));
                    String str3 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.URL.getRawValue());
                    String str4 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.DATASETID.getRawValue());
                    String str5 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.ACCESSKEY.getRawValue());
                    if (str3 == null || str4 == null || str5 == null) {
                        Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                        companion2.log(loggingBehavior2, str2, "CloudBridge Settings API response doesn't have valid data");
                        return;
                    }
                    try {
                        AppEventsConversionsAPITransformerWebRequests.configure(str4, str3, str5);
                        setSavedCloudBridgeCredentials$facebook_core_release(convertJSONObjectToHashMap);
                        SettingsAPIFields settingsAPIFields = SettingsAPIFields.ENABLED;
                        if (convertJSONObjectToHashMap.get(settingsAPIFields.getRawValue()) != null) {
                            Object obj2 = convertJSONObjectToHashMap.get(settingsAPIFields.getRawValue());
                            if (obj2 != null) {
                                z11 = ((Boolean) obj2).booleanValue();
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                        }
                        isEnabled = z11;
                    } catch (MalformedURLException e11) {
                        Logger.Companion companion3 = Logger.Companion;
                        LoggingBehavior loggingBehavior3 = LoggingBehavior.APP_EVENTS;
                        String str6 = TAG;
                        Intrinsics.checkNotNullExpressionValue(str6, "TAG");
                        companion3.log(loggingBehavior3, str6, "CloudBridge Settings API response doesn't have valid url\n %s ", ExceptionsKt__ExceptionsKt.stackTraceToString(e11));
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                }
            } catch (JSONException e12) {
                Logger.Companion companion4 = Logger.Companion;
                LoggingBehavior loggingBehavior4 = LoggingBehavior.APP_EVENTS;
                String str7 = TAG;
                Intrinsics.checkNotNullExpressionValue(str7, "TAG");
                companion4.log(loggingBehavior4, str7, "CloudBridge Settings API response is not a valid json: \n%s ", ExceptionsKt__ExceptionsKt.stackTraceToString(e12));
            } catch (NullPointerException e13) {
                Logger.Companion companion5 = Logger.Companion;
                LoggingBehavior loggingBehavior5 = LoggingBehavior.APP_EVENTS;
                String str8 = TAG;
                Intrinsics.checkNotNullExpressionValue(str8, "TAG");
                companion5.log(loggingBehavior5, str8, "CloudBridge Settings API response is not a valid json: \n%s ", ExceptionsKt__ExceptionsKt.stackTraceToString(e13));
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public final boolean isEnabled$facebook_core_release() {
        return isEnabled;
    }

    public final void setEnabled$facebook_core_release(boolean z11) {
        isEnabled = z11;
    }

    public final void setSavedCloudBridgeCredentials$facebook_core_release(@Nullable Map<String, ? extends Object> map) {
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.CLOUDBRIDGE_SAVED_CREDENTIALS, 0);
        if (sharedPreferences != null) {
            if (map == null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.apply();
                return;
            }
            SettingsAPIFields settingsAPIFields = SettingsAPIFields.DATASETID;
            Object obj = map.get(settingsAPIFields.getRawValue());
            SettingsAPIFields settingsAPIFields2 = SettingsAPIFields.URL;
            Object obj2 = map.get(settingsAPIFields2.getRawValue());
            SettingsAPIFields settingsAPIFields3 = SettingsAPIFields.ACCESSKEY;
            Object obj3 = map.get(settingsAPIFields3.getRawValue());
            if (obj != null && obj2 != null && obj3 != null) {
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putString(settingsAPIFields.getRawValue(), obj.toString());
                edit2.putString(settingsAPIFields2.getRawValue(), obj2.toString());
                edit2.putString(settingsAPIFields3.getRawValue(), obj3.toString());
                edit2.apply();
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG.toString(), " \n\nSaving Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", obj, obj2, obj3);
            }
        }
    }
}
