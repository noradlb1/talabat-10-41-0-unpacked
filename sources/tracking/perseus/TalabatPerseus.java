package tracking.perseus;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import com.adjust.sdk.AdjustAttribution;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.messaging.Constants;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.common.AndroidMobilePlatform;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatVolley;
import com.talabat.perseus.Perseus;
import com.talabat.perseus.PerseusNotConfiguredException;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatcore.logger.impl.TimberLogger;
import com.visa.checkout.Profile;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import j40.a;
import j40.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tracking.TalabatAdjust;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Ltracking/perseus/TalabatPerseus;", "", "()V", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatPerseus {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String PREFS_KEY_FLAG = "sf93i3";
    @NotNull
    private static final String PREFS_KEY_ID = "KIW387";
    @NotNull
    private static final String PREFS_NAME = "OD83k0";
    /* access modifiers changed from: private */
    @NotNull
    public static final String TAG = "TALABAT_PERSEUS";
    /* access modifiers changed from: private */
    @NotNull
    public static String perseusClientId = "";

    @Instrumented
    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jn\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 Jx\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002Jp\u0010$\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002J,\u0010%\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00042\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010(J\b\u0010)\u001a\u00020\u0004H\u0007J\u0006\u0010*\u001a\u00020\u0004J\u0014\u0010+\u001a\u00020\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u0006\u0010,\u001a\u00020\u0004J\u0006\u0010-\u001a\u00020\u0004J\u0006\u0010.\u001a\u00020\u0004J\b\u0010/\u001a\u00020\u0004H\u0002J.\u00100\u001a\u0002012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00042\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010(H\u0002J\"\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u00042\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000406J\u000e\u00107\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0004J\u0010\u00108\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u000e\u00109\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010:\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010<J\u0010\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u0004H\u0007J\u000e\u0010?\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0004J\u0018\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020CH\u0002J\u0016\u0010F\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020KR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\r¨\u0006L"}, d2 = {"Ltracking/perseus/TalabatPerseus$Companion;", "", "()V", "PREFS_KEY_FLAG", "", "PREFS_KEY_ID", "PREFS_NAME", "TAG", "getTAG", "()Ljava/lang/String;", "perseusClientId", "getPerseusClientId$com_talabat_talabatlib_talabatlib", "setPerseusClientId$com_talabat_talabatlib_talabatlib", "(Ljava/lang/String;)V", "configurePerseus", "", "appName", "appId", "entity", "appVersionName", "debuggable", "", "baseUrl", "uaId", "advertisingId", "adjustId", "country", "Lcom/talabat/configuration/country/Country;", "userId", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "context", "Landroid/content/Context;", "configurePerseusAsync", "prefs", "Landroid/content/SharedPreferences;", "configurePerseusSync", "dispatchPerseusEvent", "appVersion", "eventVarsJsonObj", "", "generateSessionId", "getHitMatchId", "getMyClientId", "getMySessionId", "getNetworkHeaderClientId", "getNetworkHeaderSessionId", "getPerseusCurrentTime", "getPerseusJsonFormat", "Lorg/json/JSONObject;", "eventVarsMap", "sendEvent", "perseusEventName", "perseusParams", "", "setAdjustId", "setAdvertisingId", "setCountry", "setObservability", "observability", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setPerseusClientId", "fakeValue", "setUserId", "trackNotInitialized", "method", "exception", "", "trackPerseusError", "e", "updateFlags", "feature", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "with", "myAppContext", "Ltracking/perseus/MyAppContext;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void configurePerseusAsync(String str, String str2, String str3, String str4, boolean z11, String str5, String str6, String str7, String str8, Country country, String str9, CoroutineDispatchersFactory coroutineDispatchersFactory, Context context, SharedPreferences sharedPreferences) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(coroutineDispatchersFactory.m9577default()).plus(new TalabatPerseus$Companion$configurePerseusAsync$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key))), (CoroutineContext) null, (CoroutineStart) null, new TalabatPerseus$Companion$configurePerseusAsync$1(country, str8, str7, str2, str, str4, str5, context, z11, str3, str6, str9, sharedPreferences, (Continuation<? super TalabatPerseus$Companion$configurePerseusAsync$1>) null), 3, (Object) null);
        }

        private final void configurePerseusSync(String str, String str2, String str3, String str4, boolean z11, String str5, String str6, String str7, String str8, Country country, String str9, Context context, SharedPreferences sharedPreferences) {
            try {
                Perseus.INSTANCE.configurePerseus(str8, str7, str2, str, str4, str5, context, PerseusCountryMapperKt.perseusCountryCode(country), z11, PerseusCountryMapperKt.perseusGlobalEntityId(country), str3, str6, str9);
                sharedPreferences.edit().putString(TalabatPerseus.PREFS_KEY_ID, getMyClientId$default(this, (Context) null, 1, (Object) null)).apply();
            } catch (Throwable th2) {
                trackPerseusError(th2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: dispatchPerseusEvent$lambda-1  reason: not valid java name */
        public static final void m10952dispatchPerseusEvent$lambda1(JSONObject jSONObject) {
            TalabatPerseus.Companion.getTAG();
            if (!(jSONObject instanceof JSONObject)) {
                jSONObject.toString();
            } else {
                JSONObjectInstrumentation.toString(jSONObject);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: dispatchPerseusEvent$lambda-2  reason: not valid java name */
        public static final void m10953dispatchPerseusEvent$lambda2(VolleyError volleyError) {
            TalabatPerseus.Companion.getTAG();
            volleyError.toString();
        }

        public static /* synthetic */ String getMyClientId$default(Companion companion, Context context, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                context = null;
            }
            return companion.getMyClientId(context);
        }

        private final String getPerseusCurrentTime() {
            if (Build.VERSION.SDK_INT >= 26) {
                String format = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH));
                Intrinsics.checkNotNullExpressionValue(format, "now().format(formatter)");
                return format;
            }
            String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH).format(new Date());
            Intrinsics.checkNotNullExpressionValue(format2, "formatter.format(Date())");
            return format2;
        }

        private final JSONObject getPerseusJsonFormat(Context context, String str, Map<String, Object> map) {
            boolean z11;
            String str2;
            String str3;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            String str4 = "";
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    String str5 = (String) next.getKey();
                    Object value = next.getValue();
                    if (value == null) {
                        str3 = str4;
                    } else {
                        str3 = value.toString();
                    }
                    jSONObject2.put(str5, (Object) str3);
                }
            }
            jSONObject.put("payloadTimestamp", (Object) getPerseusCurrentTime());
            jSONObject.put("platform", (Object) "Android");
            jSONObject.put("country", (Object) TalabatAdjust.getSelectedCountryIso());
            jSONObject.put("uaId", (Object) GlobalDataModel.getUaIDForPerseus());
            String str6 = GlobalDataModel.googleAdId;
            boolean z12 = false;
            if (str6 == null || str6.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                str4 = GlobalDataModel.googleAdId;
            }
            jSONObject.put(ConstantsKt.GOOGLE_AD_ID, (Object) str4);
            jSONObject.put("appId", (Object) GlobalDataModel.getAppPAckageID());
            jSONObject.put(AnalyticsAttribute.APP_NAME_ATTRIBUTE, (Object) GlobalDataModel.getAppName());
            jSONObject.put("appVersionCode", (Object) str);
            jSONObject.put("sessionId", (Object) getMySessionId());
            AdjustAttribution adjustAttribution = GlobalDataModel.adjustAttribution;
            if (adjustAttribution != null) {
                String str7 = adjustAttribution.adid;
                if (str7 == null || str7.length() == 0) {
                    z12 = true;
                }
                if (!z12) {
                    str2 = GlobalDataModel.adjustAttribution.adid;
                    jSONObject.put(ConstantsKt.ADJUST_AD_ID, (Object) str2);
                    jSONObject.put(Profile.CLIENT_ID, (Object) getMyClientId(context));
                    jSONObject.put("userAgent", (Object) "Android:" + Build.VERSION.RELEASE + CertificateUtil.DELIMITER + Build.BRAND + CertificateUtil.DELIMITER + Build.MANUFACTURER + CertificateUtil.DELIMITER + Build.MODEL);
                    TalabatGTM.Companion companion = TalabatGTM.Companion;
                    jSONObject.put("userId", (Object) companion.getUserId());
                    jSONObject.put("eventVariables", (Object) jSONObject2);
                    String userId = companion.getUserId();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Encryped user id TalabatPerseus: ");
                    sb2.append(userId);
                    LogManager.info(sb2.toString());
                    return jSONObject;
                }
            }
            str2 = "N/A";
            jSONObject.put(ConstantsKt.ADJUST_AD_ID, (Object) str2);
            jSONObject.put(Profile.CLIENT_ID, (Object) getMyClientId(context));
            jSONObject.put("userAgent", (Object) "Android:" + Build.VERSION.RELEASE + CertificateUtil.DELIMITER + Build.BRAND + CertificateUtil.DELIMITER + Build.MANUFACTURER + CertificateUtil.DELIMITER + Build.MODEL);
            TalabatGTM.Companion companion2 = TalabatGTM.Companion;
            jSONObject.put("userId", (Object) companion2.getUserId());
            jSONObject.put("eventVariables", (Object) jSONObject2);
            String userId2 = companion2.getUserId();
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Encryped user id TalabatPerseus: ");
            sb22.append(userId2);
            LogManager.info(sb22.toString());
            return jSONObject;
        }

        private final void trackNotInitialized(String str, Throwable th2) {
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            IObservabilityManager access$getObservabilityManager$p = TalabatPerseusKt.observabilityManager;
            if (access$getObservabilityManager$p != null) {
                String value = AndroidMobilePlatform.PerseusException.getValue();
                Pair[] pairArr = new Pair[3];
                pairArr[0] = TuplesKt.to("perseusMethod", str);
                String message = th2.getMessage();
                if (message == null) {
                    message = "";
                }
                pairArr[1] = TuplesKt.to("errorMessage", message);
                pairArr[2] = TuplesKt.to("stackTrace", stringWriter.toString());
                access$getObservabilityManager$p.trackEvent("PerseusNotConfigured", value, (Map<String, String>) MapsKt__MapsKt.mutableMapOf(pairArr));
            }
        }

        /* access modifiers changed from: private */
        public final void trackPerseusError(Throwable th2) {
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            IObservabilityManager access$getObservabilityManager$p = TalabatPerseusKt.observabilityManager;
            if (access$getObservabilityManager$p != null) {
                String value = AndroidMobilePlatform.PerseusException.getValue();
                Pair[] pairArr = new Pair[2];
                String message = th2.getMessage();
                if (message == null) {
                    message = "";
                }
                pairArr[0] = TuplesKt.to("errorMessage", message);
                pairArr[1] = TuplesKt.to("stackTrace", stringWriter.toString());
                access$getObservabilityManager$p.trackUnExpectedScenario(value, MapsKt__MapsKt.mutableMapOf(pairArr));
            }
        }

        public final void configurePerseus(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z11, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull Country country, @NotNull String str9, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory, @NotNull Context context) {
            Context context2 = context;
            Intrinsics.checkNotNullParameter(str, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
            Intrinsics.checkNotNullParameter(str2, "appId");
            Intrinsics.checkNotNullParameter(str3, "entity");
            Intrinsics.checkNotNullParameter(str4, "appVersionName");
            Intrinsics.checkNotNullParameter(str5, "baseUrl");
            Intrinsics.checkNotNullParameter(str6, "uaId");
            Intrinsics.checkNotNullParameter(str7, ConstantsKt.GOOGLE_AD_ID);
            Intrinsics.checkNotNullParameter(str8, "adjustId");
            Intrinsics.checkNotNullParameter(country, "country");
            Intrinsics.checkNotNullParameter(str9, "userId");
            Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "coroutineDispatchersFactory");
            Intrinsics.checkNotNullParameter(context2, "context");
            SharedPreferences sharedPreferences = context2.getSharedPreferences(TalabatPerseus.PREFS_NAME, 0);
            if (sharedPreferences.getBoolean(TalabatPerseus.PREFS_KEY_FLAG, false)) {
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "prefs");
                configurePerseusAsync(str, str2, str3, str4, z11, str5, str6, str7, str8, country, str9, coroutineDispatchersFactory, context, sharedPreferences);
                return;
            }
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "prefs");
            configurePerseusSync(str, str2, str3, str4, z11, str5, str6, str7, str8, country, str9, context, sharedPreferences);
        }

        public final void dispatchPerseusEvent(@NotNull Context context, @NotNull String str, @Nullable Map<String, Object> map) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "appVersion");
            TalabatVolley.addToRequestQueue(context, new JsonObjectRequest(1, AppUrls.PERSEUS_URL, getPerseusJsonFormat(context, str, map), new a(), new b()));
        }

        @NotNull
        @Deprecated(message = "Generation of Id is on Perseus SDK side now", replaceWith = @ReplaceWith(expression = "getMySessionId()", imports = {"tracking.perseus.TalabatPerseus.Companion.getMySessionId"}))
        public final String generateSessionId() {
            long time = new Date().getTime();
            String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsJVMKt.shuffled(new IntRange(0, 9)), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            String joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsJVMKt.shuffled(new CharRange('a', 'z')).subList(0, 10), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            return time + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + joinToString$default + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + joinToString$default2;
        }

        @NotNull
        public final String getHitMatchId() {
            try {
                return Perseus.getPerseusHitMatchId();
            } catch (Throwable th2) {
                if (th2 instanceof PerseusNotConfiguredException) {
                    trackNotInitialized("hitmatch_id", th2);
                } else {
                    trackPerseusError(th2);
                }
                return "";
            }
        }

        @NotNull
        @JvmOverloads
        public final String getMyClientId() {
            return getMyClientId$default(this, (Context) null, 1, (Object) null);
        }

        @NotNull
        @JvmOverloads
        public final String getMyClientId(@Nullable Context context) {
            SharedPreferences sharedPreferences;
            String string;
            Context context2;
            try {
                return Perseus.getPerseusClientId();
            } catch (Throwable th2) {
                if (th2 instanceof PerseusNotConfiguredException) {
                    trackNotInitialized("client_id", th2);
                    MyAppContext mMyAppContext = TalabatPerseusKt.getMMyAppContext();
                    if (mMyAppContext == null || (context2 = mMyAppContext.getContext()) == null) {
                        sharedPreferences = null;
                    } else {
                        sharedPreferences = context2.getSharedPreferences(TalabatPerseus.PREFS_NAME, 0);
                    }
                    if (!(sharedPreferences == null || (string = sharedPreferences.getString(TalabatPerseus.PREFS_KEY_ID, "")) == null)) {
                        return string;
                    }
                } else {
                    trackPerseusError(th2);
                }
                return "";
            }
        }

        @NotNull
        public final String getMySessionId() {
            try {
                return Perseus.getPerseusSessionId();
            } catch (Throwable th2) {
                if (th2 instanceof PerseusNotConfiguredException) {
                    trackNotInitialized("session_id", th2);
                } else {
                    trackPerseusError(th2);
                }
                return "";
            }
        }

        @NotNull
        public final String getNetworkHeaderClientId() {
            return getMyClientId$default(this, (Context) null, 1, (Object) null);
        }

        @NotNull
        public final String getNetworkHeaderSessionId() {
            return getMySessionId();
        }

        @NotNull
        public final String getPerseusClientId$com_talabat_talabatlib_talabatlib() {
            return TalabatPerseus.perseusClientId;
        }

        @NotNull
        public final String getTAG() {
            return TalabatPerseus.TAG;
        }

        public final void sendEvent(@NotNull String str, @NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str, "perseusEventName");
            Intrinsics.checkNotNullParameter(map, "perseusParams");
            try {
                Perseus.sendEvent(str, map);
            } catch (Throwable th2) {
                if (th2 instanceof PerseusNotConfiguredException) {
                    trackNotInitialized(Constants.MessageTypes.SEND_EVENT, th2);
                } else {
                    trackPerseusError(th2);
                }
            }
        }

        public final void setAdjustId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "adjustId");
            try {
                Perseus.setAdjustId(str);
            } catch (Throwable th2) {
                if (th2 instanceof PerseusNotConfiguredException) {
                    trackNotInitialized("set_adjust_id", th2);
                } else {
                    trackPerseusError(th2);
                }
            }
        }

        @JvmStatic
        public final void setAdvertisingId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, ConstantsKt.GOOGLE_AD_ID);
            try {
                Perseus.setAdvertisingId(str);
            } catch (Throwable th2) {
                if (th2 instanceof PerseusNotConfiguredException) {
                    trackNotInitialized("set_advertising_id", th2);
                } else {
                    trackPerseusError(th2);
                }
            }
        }

        public final void setCountry(@NotNull Country country) {
            Intrinsics.checkNotNullParameter(country, "country");
            try {
                Perseus.setCountry(PerseusCountryMapperKt.perseusCountryCode(country));
                Perseus.setGlobalEntityId(PerseusCountryMapperKt.perseusGlobalEntityId(country));
            } catch (Throwable th2) {
                if (th2 instanceof PerseusNotConfiguredException) {
                    trackNotInitialized("set_country_id", th2);
                } else {
                    trackPerseusError(th2);
                }
            }
        }

        public final void setObservability(@Nullable IObservabilityManager iObservabilityManager) {
            TalabatPerseusKt.observabilityManager = iObservabilityManager;
        }

        @VisibleForTesting
        public final void setPerseusClientId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "fakeValue");
            setPerseusClientId$com_talabat_talabatlib_talabatlib(str);
        }

        public final void setPerseusClientId$com_talabat_talabatlib_talabatlib(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            TalabatPerseus.perseusClientId = str;
        }

        public final void setUserId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "userId");
            try {
                Perseus.setUserId(str);
            } catch (Throwable th2) {
                if (th2 instanceof PerseusNotConfiguredException) {
                    trackNotInitialized("set_user_id", th2);
                } else {
                    trackPerseusError(th2);
                }
            }
        }

        public final void updateFlags(@NotNull Context context, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "feature");
            SharedPreferences sharedPreferences = context.getSharedPreferences(TalabatPerseus.PREFS_NAME, 0);
            boolean featureFlag = iTalabatFeatureFlag.getFeatureFlag(PlatformFeatureFlagsKeys.PERSEUS_ASYNC_INIT, false);
            TimberLogger timberLogger = TimberLogger.INSTANCE;
            timberLogger.debug("Perseus initialization: update flag: " + featureFlag);
            sharedPreferences.edit().putBoolean(TalabatPerseus.PREFS_KEY_FLAG, featureFlag).apply();
        }

        public final void with(@NotNull MyAppContext myAppContext) {
            Intrinsics.checkNotNullParameter(myAppContext, "myAppContext");
            TalabatPerseusKt.mMyAppContext = myAppContext;
        }
    }

    @JvmStatic
    public static final void setAdvertisingId(@NotNull String str) {
        Companion.setAdvertisingId(str);
    }
}
