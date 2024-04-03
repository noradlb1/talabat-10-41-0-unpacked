package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.appboy.enums.Gender;
import com.appboy.enums.NotificationSubscriptionType;
import com.appboy.models.outgoing.AttributionData;
import com.appboy.models.outgoing.FacebookUser;
import com.appboy.models.outgoing.TwitterUser;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.braze.support.StringUtils;
import com.braze.support.ValidationUtils;
import com.facebook.AccessToken;
import com.instabug.library.model.State;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B9\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0014\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0007J\u0010\u0010\u0014\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0018\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001a\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0014\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u0006\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0014\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010 J\u0010\u0010\u0014\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010\u0014\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010$J\u0016\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\rJ\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0003H\u0007J\b\u0010(\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0005H\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0007J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007R\u0014\u0010,\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010+R.\u0010-\u001a\u0004\u0018\u00010\u00072\b\u0010-\u001a\u0004\u0018\u00010\u00078\u0006@FX\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b\u001a\u0010/\"\u0004\b(\u00100R\u0011\u00101\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0010\u0010+¨\u0006;"}, d2 = {"Lbo/app/t6;", "Lbo/app/a;", "Lbo/app/b4;", "Lorg/json/JSONObject;", "userObjectJson", "", "b", "", "key", "", "value", "c", "firstName", "", "d", "lastName", "g", "email", "Lcom/appboy/enums/Gender;", "gender", "a", "dateString", "country", "homeCity", "e", "language", "f", "Lcom/appboy/enums/NotificationSubscriptionType;", "subscription", "pushNotificationSubscription", "phoneNumber", "h", "Lcom/appboy/models/outgoing/TwitterUser;", "twitterUser", "Lcom/appboy/models/outgoing/FacebookUser;", "facebookUser", "Lcom/appboy/models/outgoing/AttributionData;", "attributionData", "j", "outboundJson", "i", "outboundObject", "isSuccessful", "()Lorg/json/JSONObject;", "customAttributesObjectFromCache", "userId", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "userObjectFromCache", "Landroid/content/Context;", "context", "Lbo/app/m2;", "pushRegistrationDataProvider", "Lbo/app/z4;", "sdkEnablementProvider", "apiKey", "<init>", "(Landroid/content/Context;Lbo/app/m2;Lbo/app/z4;Ljava/lang/String;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class t6 extends a<b4> {

    /* renamed from: g  reason: collision with root package name */
    public static final a f39419g = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final m2 f39420b;

    /* renamed from: c  reason: collision with root package name */
    private final z4 f39421c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences f39422d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedPreferences f39423e;

    /* renamed from: f  reason: collision with root package name */
    private String f39424f;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lbo/app/t6$a;", "", "", "ATTRIBUTION_DATA_KEY", "Ljava/lang/String;", "BIRTHDAY_KEY", "COUNTRY_KEY", "CUSTOM_ATTRIBUTES_OBJECT_KEY", "EMAIL_KEY", "EMAIL_SUBSCRIPTION_KEY", "FACEBOOK_KEY", "FIRST_NAME_KEY", "GENDER_KEY", "HOME_CITY_KEY", "LANGUAGE_KEY", "LAST_NAME_KEY", "PHONE_NUMBER_KEY", "PUSH_NOTIFICATION_SUBSCRIPTION_KEY", "PUSH_TOKEN_CACHE_FILE_PREFIX", "PUSH_TOKEN_KEY", "SERIALIZED_USER_OBJECT_JSON_KEY", "TWITTER_KEY", "USER_CACHE_FILE_PREFIX_V3", "USER_ID_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f39425b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "No push token available to add to attributes object.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f39426b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Couldn't add push token to outbound json";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f39427b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not create custom attributes json object from preferences";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f39428b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to add merged custom attributes back to user object.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f39429b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Push token cache cleared.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function1<String, Unit> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ t6 f39430b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(t6 t6Var) {
            super(1);
            this.f39430b = t6Var;
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            boolean unused = this.f39430b.c("user_id", str);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39431b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(0);
            this.f39431b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to load user object json from prefs with json string: ", this.f39431b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39432b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ JSONObject f39433c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(String str, JSONObject jSONObject) {
            super(0);
            this.f39432b = str;
            this.f39433c = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to write to user object json from prefs with key: [" + this.f39432b + "] value: [" + this.f39433c + "] ";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final j f39434b = new j();

        public j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not writing to user cache.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39435b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f39436c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(String str, Object obj) {
            super(0);
            this.f39435b = str;
            this.f39436c = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not write to custom attributes json object with key: [" + this.f39435b + "] value: [" + this.f39436c + AbstractJsonLexerKt.END_LIST;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39437b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f39438c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(String str, Object obj) {
            super(0);
            this.f39437b = str;
            this.f39438c = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to write to user object json from prefs with key: [" + this.f39437b + "] value: [" + this.f39438c + AbstractJsonLexerKt.END_LIST;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t6(Context context, m2 m2Var, z4 z4Var, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, m2Var, z4Var, (i11 & 8) != 0 ? null : str, (i11 & 16) != 0 ? null : str2);
    }

    private final JSONObject e() {
        JSONObject g11 = g();
        if (g11.has("custom")) {
            try {
                JSONObject jSONObject = g11.getJSONObject("custom");
                Intrinsics.checkNotNullExpressionValue(jSONObject, "userObjectFromCache.getJ…OM_ATTRIBUTES_OBJECT_KEY)");
                return jSONObject;
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) d.f39427b, 4, (Object) null);
            }
        }
        return new JSONObject();
    }

    public final synchronized boolean c(String str) {
        return c("email", str);
    }

    public final String f() {
        return this.f39424f;
    }

    public final JSONObject g() {
        String string = this.f39422d.getString("user_cache_attributes_object", (String) null);
        if (string == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new h(string), 4, (Object) null);
            return new JSONObject();
        }
    }

    public final synchronized boolean h(String str) {
        return c("phone", str);
    }

    public final synchronized void i(String str) {
        this.f39424f = str;
        c("user_id", str);
    }

    public final synchronized boolean j(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return b(ValidationUtils.ensureBrazeFieldLength(str), JSONObject.NULL);
    }

    public t6(Context context, m2 m2Var, z4 z4Var, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(m2Var, "pushRegistrationDataProvider");
        Intrinsics.checkNotNullParameter(z4Var, "sdkEnablementProvider");
        this.f39420b = m2Var;
        this.f39421c = z4Var;
        this.f39424f = str;
        String cacheFileSuffix = StringUtils.getCacheFileSuffix(context, str, str2);
        SharedPreferences sharedPreferences = context.getSharedPreferences(Intrinsics.stringPlus("com.appboy.storage.user_cache.v3", cacheFileSuffix), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.f39422d = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(Intrinsics.stringPlus("com.braze.storage.user_cache.push_token_store", cacheFileSuffix), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.f39423e = sharedPreferences2;
    }

    /* access modifiers changed from: private */
    public final boolean c(String str, Object obj) {
        Object obj2;
        JSONObject g11 = g();
        if (obj == null) {
            try {
                obj2 = JSONObject.NULL;
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new l(str, obj), 4, (Object) null);
                return false;
            }
        } else {
            obj2 = obj;
        }
        g11.put(str, obj2);
        return b(g11);
    }

    public final synchronized void a(Gender gender) {
        c("gender", gender == null ? null : gender.forJsonPut());
    }

    public final synchronized boolean b(String str) {
        Intrinsics.checkNotNullParameter(str, "dateString");
        return c("dob", str);
    }

    public final synchronized void d(String str) {
        c("first_name", str);
    }

    public final synchronized void f(String str) {
        c(ConstantsKt.ADJUST_LANGUAGE, str);
    }

    public final synchronized void h() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) f.f39429b, 6, (Object) null);
        this.f39423e.edit().clear().apply();
    }

    public final synchronized void a(String str) {
        c("country", str);
    }

    public final synchronized void b(NotificationSubscriptionType notificationSubscriptionType) {
        c("push_subscribe", notificationSubscriptionType == null ? null : notificationSubscriptionType.forJsonPut());
    }

    /* renamed from: i */
    public b4 d() {
        StringUtils.ifNonEmpty(this.f39424f, new g(this));
        JSONObject g11 = g();
        a(g11);
        this.f39422d.edit().clear().apply();
        return new b4(g11);
    }

    public final synchronized void a(NotificationSubscriptionType notificationSubscriptionType) {
        c("email_subscribe", notificationSubscriptionType == null ? null : notificationSubscriptionType.forJsonPut());
    }

    private final boolean b(JSONObject jSONObject) {
        if (this.f39421c.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) j.f39434b, 6, (Object) null);
            return false;
        }
        this.f39422d.edit().putString("user_cache_attributes_object", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
        return true;
    }

    public final synchronized void a(TwitterUser twitterUser) {
        a("twitter", twitterUser == null ? null : twitterUser.forJsonPut());
    }

    public final synchronized void g(String str) {
        c("last_name", str);
    }

    public final synchronized void a(FacebookUser facebookUser) {
        a(AccessToken.DEFAULT_GRAPH_DOMAIN, facebookUser == null ? null : facebookUser.forJsonPut());
    }

    public final synchronized void e(String str) {
        c("home_city", str);
    }

    public final synchronized void a(AttributionData attributionData) {
        a("ab_install_attribution", attributionData == null ? null : attributionData.forJsonPut());
    }

    public final synchronized boolean a(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, "value");
        return b(str, obj);
    }

    public final void a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "outboundJson");
        try {
            String a11 = this.f39420b.a();
            if (a11 == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) b.f39425b, 7, (Object) null);
            } else if (!Intrinsics.areEqual((Object) a11, (Object) this.f39423e.getString(State.KEY_PUSH_TOKEN, (String) null))) {
                jSONObject.put(State.KEY_PUSH_TOKEN, (Object) a11);
            }
        } catch (JSONException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) c.f39426b, 4, (Object) null);
        }
    }

    public final boolean b(String str, Object obj) {
        Object obj2;
        Intrinsics.checkNotNullParameter(str, "key");
        JSONObject e11 = e();
        if (obj == null) {
            try {
                obj2 = JSONObject.NULL;
            } catch (JSONException e12) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e12, false, (Function0) new k(str, obj), 4, (Object) null);
                return false;
            }
        } else {
            obj2 = obj;
        }
        e11.put(str, obj2);
        return c("custom", e11);
    }

    /* renamed from: a */
    public void b(b4 b4Var, boolean z11) {
        Intrinsics.checkNotNullParameter(b4Var, "outboundObject");
        JSONObject w11 = b4Var.w();
        if (!z11) {
            JSONObject g11 = g();
            JSONObject plus = JsonUtils.plus(w11, g11);
            plus.remove(State.KEY_PUSH_TOKEN);
            JSONObject optJSONObject = g11.optJSONObject("custom");
            JSONObject optJSONObject2 = w11.optJSONObject("custom");
            if (optJSONObject != null && optJSONObject2 != null) {
                try {
                    plus.put("custom", (Object) JsonUtils.plus(optJSONObject2, optJSONObject));
                } catch (JSONException e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) e.f39428b, 4, (Object) null);
                }
            } else if (optJSONObject != null) {
                plus.put("custom", (Object) optJSONObject);
            } else if (optJSONObject2 != null) {
                plus.put("custom", (Object) optJSONObject2);
            }
            this.f39422d.edit().putString("user_cache_attributes_object", JSONObjectInstrumentation.toString(plus)).apply();
        } else if (w11.has(State.KEY_PUSH_TOKEN)) {
            this.f39423e.edit().putString(State.KEY_PUSH_TOKEN, w11.optString(State.KEY_PUSH_TOKEN)).apply();
        }
    }

    public final boolean a(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "key");
        JSONObject g11 = g();
        if (jSONObject == null) {
            try {
                g11.put(str, JSONObject.NULL);
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new i(str, jSONObject), 4, (Object) null);
                return false;
            }
        } else {
            JSONObject optJSONObject = g11.optJSONObject(str);
            if (optJSONObject != null) {
                g11.put(str, (Object) JsonUtils.plus(optJSONObject, jSONObject));
            } else {
                g11.put(str, (Object) jSONObject);
            }
        }
        return b(g11);
    }
}
