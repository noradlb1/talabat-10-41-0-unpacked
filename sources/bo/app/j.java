package bo.app;

import bo.app.c1;
import com.braze.enums.inappmessage.InAppMessageFailureType;
import com.braze.models.inappmessage.MessageButton;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;
import x2.w;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001:\u0001\"B-\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b.\u0010/BG\b\u0016\u0012\u0006\u00100\u001a\u00020\f\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b.\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR/\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010#R/\u0010*\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010%8F@FX\u0002¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010(\"\u0004\b\"\u0010)R\u0014\u0010-\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00064"}, d2 = {"Lbo/app/j;", "Lbo/app/x1;", "Lorg/json/JSONObject;", "e", "", "toString", "", "other", "", "equals", "", "hashCode", "Lbo/app/c1;", "type", "Lbo/app/c1;", "j", "()Lbo/app/c1;", "data", "Lorg/json/JSONObject;", "k", "()Lorg/json/JSONObject;", "", "timestampSeconds", "D", "v", "()D", "uniqueIdentifier", "Ljava/lang/String;", "r", "()Ljava/lang/String;", "<set-?>", "userId$delegate", "Lbo/app/j3;", "w", "a", "(Ljava/lang/String;)V", "userId", "Lbo/app/j5;", "sessionId$delegate", "n", "()Lbo/app/j5;", "(Lbo/app/j5;)V", "sessionId", "d", "()Z", "isNonPersistable", "<init>", "(Lbo/app/c1;Lorg/json/JSONObject;DLjava/lang/String;)V", "eventType", "eventData", "eventTimeInSeconds", "(Lbo/app/c1;Lorg/json/JSONObject;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public class j implements x1 {

    /* renamed from: h  reason: collision with root package name */
    public static final a f38653h = new a((DefaultConstructorMarker) null);

    /* renamed from: i  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f38654i;

    /* renamed from: b  reason: collision with root package name */
    private final c1 f38655b;

    /* renamed from: c  reason: collision with root package name */
    private final JSONObject f38656c;

    /* renamed from: d  reason: collision with root package name */
    private final double f38657d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38658e;

    /* renamed from: f  reason: collision with root package name */
    private final j3 f38659f;

    /* renamed from: g  reason: collision with root package name */
    private final j3 f38660g;

    @Metadata(bv = {}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bG\u0010HJ\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J6\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J&\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0007J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0007J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J\u0012\u0010 \u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J\u001a\u0010 \u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0007J\u0012\u0010$\u001a\u0004\u0018\u00010\u00032\u0006\u0010#\u001a\u00020\u0006H\u0007J\u0012\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010#\u001a\u00020\u0006H\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010#\u001a\u00020\u0006H\u0007J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010#\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0007J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010#\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0007J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010#\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0007J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010,\u001a\u0004\u0018\u00010\u00032\u0006\u0010+\u001a\u00020\u0006H\u0007J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u000eH\u0007J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\u0007J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\u0007J+\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010/\u001a\u00020\u00062\u0010\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u000101H\u0007¢\u0006\u0004\b\u0005\u00102J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u00104\u001a\u000203H\u0007J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010/\u001a\u00020\u00062\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u000205H\u0007J\u0014\u00108\u001a\u0004\u0018\u00010\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u00109\u001a\u00020\u00062\u0006\u0010;\u001a\u00020:H\u0007J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0006H\u0007J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0006H\u0007J\u0017\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0005\u0010@J3\u0010\u0005\u001a\u00020A2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)H\u0001¢\u0006\u0004\b\u0005\u0010BR\u0014\u0010C\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lbo/app/j$a;", "", "Lkotlin/Function0;", "Lbo/app/x1;", "block", "a", "", "eventName", "Lcom/braze/models/outgoing/BrazeProperties;", "properties", "productId", "currencyCode", "Ljava/math/BigDecimal;", "price", "", "quantity", "Lbo/app/a2;", "location", "", "throwable", "Lbo/app/j5;", "sessionId", "", "shouldPersist", "alias", "label", "g", "cardId", "f", "e", "d", "b", "c", "id", "eventType", "triggerId", "h", "i", "Lcom/braze/models/inappmessage/MessageButton;", "messageButton", "buttonId", "Lcom/braze/enums/inappmessage/InAppMessageFailureType;", "inAppMessageFailureType", "name", "j", "customUserAttributeKey", "incrementValue", "key", "value", "", "(Ljava/lang/String;[Ljava/lang/String;)Lbo/app/x1;", "", "sessionDurationSeconds", "", "latitude", "longitude", "k", "subscriptionGroupId", "Lbo/app/t5;", "subscriptionGroupStatus", "campaignId", "pageId", "serializedEvent", "uniqueIdentifier", "(Ljava/lang/Throwable;)Ljava/lang/String;", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lcom/braze/enums/inappmessage/InAppMessageFailureType;)Lorg/json/JSONObject;", "MAX_STACK_TRACE_STRING_LENGTH", "I", "SHOULD_NOT_BE_PERSISTED_KEY", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: bo.app.j$a$a  reason: collision with other inner class name */
        public static final class C0023a extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38661b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f38662c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0023a(String str, String str2) {
                super(0);
                this.f38661b = str;
                this.f38662c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("key", (Object) this.f38661b).put("value", (Object) this.f38662c);
                c1 c1Var = c1.ADD_TO_CUSTOM_ATTRIBUTE_ARRAY;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class a0 extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ j5 f38663b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a0(j5 j5Var) {
                super(0);
                this.f38663b = j5Var;
            }

            /* renamed from: a */
            public final x1 invoke() {
                j jVar = new j(c1.SESSION_START, (JSONObject) null, 0.0d, (String) null, 14, (DefaultConstructorMarker) null);
                jVar.a(this.f38663b);
                return jVar;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38664b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f38665c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str, String str2) {
                super(0);
                this.f38664b = str;
                this.f38665c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject(this.f38664b);
                String string = jSONObject.getString("name");
                c1.a aVar = c1.f38329c;
                Intrinsics.checkNotNullExpressionValue(string, "eventTypeString");
                c1 a11 = aVar.a(string);
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                double d11 = jSONObject.getDouble("time");
                String optionalString = JsonUtils.getOptionalString(jSONObject, "user_id");
                String optionalString2 = JsonUtils.getOptionalString(jSONObject, "session_id");
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "data");
                return new j(a11, jSONObject2, d11, this.f38665c, optionalString, optionalString2);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class b0 extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38666b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String[] f38667c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b0(String str, String[] strArr) {
                super(0);
                this.f38666b = str;
                this.f38667c = strArr;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", (Object) this.f38666b);
                String[] strArr = this.f38667c;
                if (strArr == null) {
                    jSONObject.put("value", JSONObject.NULL);
                } else {
                    jSONObject.put("value", (Object) JsonUtils.constructJsonArray((T[]) strArr));
                }
                return new j(c1.SET_CUSTOM_ATTRIBUTE_ARRAY, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class c extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38668b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(String str) {
                super(0);
                this.f38668b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) this.f38668b);
                jSONObject.put("ids", (Object) jSONArray);
                return new j(c1.CONTENT_CARDS_CLICK, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class c0 extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38669b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ t5 f38670c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c0(String str, t5 t5Var) {
                super(0);
                this.f38669b = str;
                this.f38670c = t5Var;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put(FirebaseAnalytics.Param.GROUP_ID, (Object) this.f38669b).put("status", (Object) this.f38670c.forJsonPut());
                c1 c1Var = c1.SUBSCRIPTION_GROUP_UPDATE;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class d extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38671b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(String str) {
                super(0);
                this.f38671b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) this.f38671b);
                jSONObject.put("ids", (Object) jSONArray);
                return new j(c1.CONTENT_CARDS_CONTROL_IMPRESSION, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class d0 extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38672b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f38673c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d0(String str, String str2) {
                super(0);
                this.f38672b = str;
                this.f38673c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("a", (Object) this.f38672b).put("l", (Object) this.f38673c);
                c1 c1Var = c1.USER_ALIAS;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class e extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38674b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(String str) {
                super(0);
                this.f38674b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) this.f38674b);
                jSONObject.put("ids", (Object) jSONArray);
                return new j(c1.CONTENT_CARDS_DISMISS, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class e0 extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final e0 f38675b = new e0();

            public e0() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to create event";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class f extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38676b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(String str) {
                super(0);
                this.f38676b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) this.f38676b);
                jSONObject.put("ids", (Object) jSONArray);
                return new j(c1.CONTENT_CARDS_IMPRESSION, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class g extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38677b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ BrazeProperties f38678c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public g(String str, BrazeProperties brazeProperties) {
                super(0);
                this.f38677b = str;
                this.f38678c = brazeProperties;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("n", (Object) this.f38677b);
                BrazeProperties brazeProperties = this.f38678c;
                if (brazeProperties != null && brazeProperties.getSize() > 0) {
                    put.put("p", (Object) this.f38678c.forJsonPut());
                }
                c1 c1Var = c1.CUSTOM_EVENT;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class h extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Throwable f38679b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ j5 f38680c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ boolean f38681d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public h(Throwable th2, j5 j5Var, boolean z11) {
                super(0);
                this.f38679b = th2;
                this.f38680c = j5Var;
                this.f38681d = z11;
            }

            /* renamed from: a */
            public final x1 invoke() {
                String str;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\n                original_sdk_version: 23.3.0\n                exception_class: ");
                sb2.append(this.f38679b.getClass().getName());
                sb2.append("\n                available_cpus: ");
                sb2.append(Runtime.getRuntime().availableProcessors());
                sb2.append("\n                ");
                j5 j5Var = this.f38680c;
                if (j5Var == null) {
                    str = null;
                } else {
                    str = Intrinsics.stringPlus("session_id: ", j5Var);
                }
                sb2.append(str);
                sb2.append("\n                ");
                sb2.append(j.f38653h.a(this.f38679b));
                sb2.append("\n            ");
                JSONObject put = new JSONObject().put("e", (Object) StringsKt__IndentKt.trimIndent(sb2.toString()));
                if (!this.f38681d) {
                    put.put("nop", true);
                }
                c1 c1Var = c1.INTERNAL_ERROR;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class i extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38682b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public i(String str) {
                super(0);
                this.f38682b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) this.f38682b);
                jSONObject.put("ids", (Object) jSONArray);
                return new j(c1.NEWS_FEED_CARD_CLICK, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: bo.app.j$a$j  reason: collision with other inner class name */
        public static final class C0024j extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38683b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0024j(String str) {
                super(0);
                this.f38683b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) this.f38683b);
                jSONObject.put("ids", (Object) jSONArray);
                return new j(c1.NEWS_FEED_CARD_IMPRESSION, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class k extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38684b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f38685c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public k(String str, String str2) {
                super(0);
                this.f38684b = str;
                this.f38685c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("geo_id", (Object) this.f38684b).put("event_type", (Object) this.f38685c);
                c1 c1Var = c1.GEOFENCE;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class l extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38686b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f38687c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public l(String str, String str2) {
                super(0);
                this.f38686b = str;
                this.f38687c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(c1.INAPP_MESSAGE_BUTTON_CLICK, a.a(j.f38653h, this.f38686b, this.f38687c, (InAppMessageFailureType) null, 4, (Object) null), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class m extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38688b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ MessageButton f38689c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public m(String str, MessageButton messageButton) {
                super(0);
                this.f38688b = str;
                this.f38689c = messageButton;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(c1.INAPP_MESSAGE_BUTTON_CLICK, a.a(j.f38653h, this.f38688b, this.f38689c.getStringId(), (InAppMessageFailureType) null, 4, (Object) null), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class n extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38690b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public n(String str) {
                super(0);
                this.f38690b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(c1.INAPP_MESSAGE_CLICK, a.a(j.f38653h, this.f38690b, (String) null, (InAppMessageFailureType) null, 6, (Object) null), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class o extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38691b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public o(String str) {
                super(0);
                this.f38691b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(c1.INAPP_MESSAGE_CONTROL_IMPRESSION, a.a(j.f38653h, this.f38691b, (String) null, (InAppMessageFailureType) null, 6, (Object) null), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class p extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38692b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ InAppMessageFailureType f38693c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public p(String str, InAppMessageFailureType inAppMessageFailureType) {
                super(0);
                this.f38692b = str;
                this.f38693c = inAppMessageFailureType;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(c1.INAPP_MESSAGE_DISPLAY_FAILURE, a.a(j.f38653h, this.f38692b, (String) null, this.f38693c, 2, (Object) null), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class q extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38694b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public q(String str) {
                super(0);
                this.f38694b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(c1.INAPP_MESSAGE_IMPRESSION, a.a(j.f38653h, this.f38694b, (String) null, (InAppMessageFailureType) null, 6, (Object) null), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class r extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38695b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f38696c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public r(String str, int i11) {
                super(0);
                this.f38695b = str;
                this.f38696c = i11;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("key", (Object) this.f38695b).put("value", this.f38696c);
                c1 c1Var = c1.INCREMENT;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class s extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38697b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public s(String str) {
                super(0);
                this.f38697b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("n", (Object) this.f38697b);
                c1 c1Var = c1.INTERNAL;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class t extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38698b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ double f38699c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ double f38700d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public t(String str, double d11, double d12) {
                super(0);
                this.f38698b = str;
                this.f38699c = d11;
                this.f38700d = d12;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("key", (Object) this.f38698b).put("latitude", this.f38699c).put("longitude", this.f38700d);
                c1 c1Var = c1.LOCATION_CUSTOM_ATTRIBUTE_ADD;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class u extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38701b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public u(String str) {
                super(0);
                this.f38701b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("key", (Object) this.f38701b);
                c1 c1Var = c1.LOCATION_CUSTOM_ATTRIBUTE_REMOVE;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class v extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a2 f38702b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public v(a2 a2Var) {
                super(0);
                this.f38702b = a2Var;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(c1.LOCATION_RECORDED, (JSONObject) this.f38702b.forJsonPut(), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class w extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ BrazeProperties f38703b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f38704c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f38705d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ BigDecimal f38706e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ int f38707f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public w(BrazeProperties brazeProperties, String str, String str2, BigDecimal bigDecimal, int i11) {
                super(0);
                this.f38703b = brazeProperties;
                this.f38704c = str;
                this.f38705d = str2;
                this.f38706e = bigDecimal;
                this.f38707f = i11;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                String str = this.f38704c;
                String str2 = this.f38705d;
                BigDecimal bigDecimal = this.f38706e;
                int i11 = this.f38707f;
                jSONObject.put("pid", (Object) str);
                jSONObject.put(com.apptimize.c.f41585a, (Object) str2);
                jSONObject.put("p", u3.a(bigDecimal).doubleValue());
                jSONObject.put("q", i11);
                BrazeProperties brazeProperties = this.f38703b;
                if (brazeProperties != null && brazeProperties.getSize() > 0) {
                    jSONObject.put("pr", (Object) this.f38703b.forJsonPut());
                }
                return new j(c1.f38333g, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class x extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38708b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f38709c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public x(String str, String str2) {
                super(0);
                this.f38708b = str;
                this.f38709c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("cid", (Object) this.f38708b).put("a", (Object) this.f38709c);
                c1 c1Var = c1.PUSH_STORY_PAGE_CLICK;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class y extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38710b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f38711c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public y(String str, String str2) {
                super(0);
                this.f38710b = str;
                this.f38711c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("key", (Object) this.f38710b).put("value", (Object) this.f38711c);
                c1 c1Var = c1.REMOVE_FROM_CUSTOM_ATTRIBUTE_ARRAY;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lbo/app/x1;", "a", "()Lbo/app/x1;"}, k = 3, mv = {1, 6, 0})
        public static final class z extends Lambda implements Function0<x1> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ long f38712b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public z(long j11) {
                super(0);
                this.f38712b = j11;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("d", this.f38712b);
                c1 c1Var = c1.SESSION_END;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(c1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final x1 a(String str, BrazeProperties brazeProperties) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            return a((Function0<? extends x1>) new g(str, brazeProperties));
        }

        @JvmStatic
        public final x1 b(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return a((Function0<? extends x1>) new d(str));
        }

        @JvmStatic
        public final x1 c(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return a((Function0<? extends x1>) new e(str));
        }

        @JvmStatic
        public final x1 d(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return a((Function0<? extends x1>) new f(str));
        }

        @JvmStatic
        public final x1 e(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return a((Function0<? extends x1>) new i(str));
        }

        @JvmStatic
        public final x1 f(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return a((Function0<? extends x1>) new C0024j(str));
        }

        @JvmStatic
        public final x1 g(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "alias");
            Intrinsics.checkNotNullParameter(str2, "label");
            return a((Function0<? extends x1>) new d0(str, str2));
        }

        @JvmStatic
        public final x1 h(String str) {
            Intrinsics.checkNotNullParameter(str, "triggerId");
            return a((Function0<? extends x1>) new o(str));
        }

        @JvmStatic
        public final x1 i(String str) {
            Intrinsics.checkNotNullParameter(str, "triggerId");
            return a((Function0<? extends x1>) new q(str));
        }

        @JvmStatic
        public final x1 j(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return a((Function0<? extends x1>) new s(str));
        }

        @JvmStatic
        public final x1 k(String str) {
            return a((Function0<? extends x1>) new u(str));
        }

        @JvmStatic
        public final x1 a(String str, String str2, BigDecimal bigDecimal, int i11, BrazeProperties brazeProperties) {
            Intrinsics.checkNotNullParameter(str, "productId");
            Intrinsics.checkNotNullParameter(str2, "currencyCode");
            Intrinsics.checkNotNullParameter(bigDecimal, FirebaseAnalytics.Param.PRICE);
            return a((Function0<? extends x1>) new w(brazeProperties, str, str2, bigDecimal, i11));
        }

        @JvmStatic
        public final x1 b(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "serializedEvent");
            Intrinsics.checkNotNullParameter(str2, "uniqueIdentifier");
            return a((Function0<? extends x1>) new b(str, str2));
        }

        @JvmStatic
        public final x1 c(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            return a((Function0<? extends x1>) new k(str, str2));
        }

        @JvmStatic
        public final x1 d(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "triggerId");
            Intrinsics.checkNotNullParameter(str2, "buttonId");
            return a((Function0<? extends x1>) new l(str, str2));
        }

        @JvmStatic
        public final x1 e(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "campaignId");
            Intrinsics.checkNotNullParameter(str2, "pageId");
            return a((Function0<? extends x1>) new x(str, str2));
        }

        @JvmStatic
        public final x1 f(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            return a((Function0<? extends x1>) new y(str, str2));
        }

        @JvmStatic
        public final x1 g(String str) {
            Intrinsics.checkNotNullParameter(str, "triggerId");
            return a((Function0<? extends x1>) new n(str));
        }

        @JvmStatic
        public final x1 a(a2 a2Var) {
            Intrinsics.checkNotNullParameter(a2Var, "location");
            return a((Function0<? extends x1>) new v(a2Var));
        }

        @JvmStatic
        public final x1 a(Throwable th2, j5 j5Var, boolean z11) {
            Intrinsics.checkNotNullParameter(th2, "throwable");
            return a((Function0<? extends x1>) new h(th2, j5Var, z11));
        }

        @JvmStatic
        public final x1 a(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return a((Function0<? extends x1>) new c(str));
        }

        @JvmStatic
        public final x1 a(String str, MessageButton messageButton) {
            Intrinsics.checkNotNullParameter(str, "triggerId");
            Intrinsics.checkNotNullParameter(messageButton, "messageButton");
            return a((Function0<? extends x1>) new m(str, messageButton));
        }

        @JvmStatic
        public final x1 a(String str, InAppMessageFailureType inAppMessageFailureType) {
            Intrinsics.checkNotNullParameter(str, "triggerId");
            Intrinsics.checkNotNullParameter(inAppMessageFailureType, "inAppMessageFailureType");
            return a((Function0<? extends x1>) new p(str, inAppMessageFailureType));
        }

        @JvmStatic
        public final x1 a() {
            return j("feed_displayed");
        }

        @JvmStatic
        public final x1 a(String str, int i11) {
            Intrinsics.checkNotNullParameter(str, "customUserAttributeKey");
            return a((Function0<? extends x1>) new r(str, i11));
        }

        @JvmStatic
        public final x1 a(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            return a((Function0<? extends x1>) new C0023a(str, str2));
        }

        @JvmStatic
        public final x1 a(String str, String[] strArr) {
            Intrinsics.checkNotNullParameter(str, "key");
            return a((Function0<? extends x1>) new b0(str, strArr));
        }

        @JvmStatic
        public final x1 a(j5 j5Var) {
            Intrinsics.checkNotNullParameter(j5Var, "sessionId");
            return a((Function0<? extends x1>) new a0(j5Var));
        }

        @JvmStatic
        public final x1 a(long j11) {
            return a((Function0<? extends x1>) new z(j11));
        }

        @JvmStatic
        public final x1 a(String str, double d11, double d12) {
            Intrinsics.checkNotNullParameter(str, "key");
            return a((Function0<? extends x1>) new t(str, d11, d12));
        }

        @JvmStatic
        public final x1 a(String str, t5 t5Var) {
            Intrinsics.checkNotNullParameter(str, "subscriptionGroupId");
            Intrinsics.checkNotNullParameter(t5Var, "subscriptionGroupStatus");
            return a((Function0<? extends x1>) new c0(str, t5Var));
        }

        @JvmStatic
        public final String a(Throwable th2) {
            Intrinsics.checkNotNullParameter(th2, "throwable");
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, "result.toString()");
            return StringsKt___StringsKt.take(stringWriter2, 5000);
        }

        public static /* synthetic */ JSONObject a(a aVar, String str, String str2, InAppMessageFailureType inAppMessageFailureType, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                str2 = null;
            }
            if ((i11 & 4) != 0) {
                inAppMessageFailureType = null;
            }
            return aVar.a(str, str2, inAppMessageFailureType);
        }

        @JvmStatic
        public final JSONObject a(String str, String str2, InAppMessageFailureType inAppMessageFailureType) {
            JSONObject jSONObject = new JSONObject();
            boolean z11 = false;
            if (!(str == null || str.length() == 0)) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) str);
                jSONObject.put("trigger_ids", (Object) jSONArray);
            }
            if (str2 == null || str2.length() == 0) {
                z11 = true;
            }
            if (!z11) {
                jSONObject.put("bid", (Object) str2);
            }
            if (inAppMessageFailureType != null) {
                jSONObject.put("error_code", (Object) inAppMessageFailureType.forJsonPut());
            }
            return jSONObject;
        }

        private final x1 a(Function0<? extends x1> function0) {
            try {
                return (x1) function0.invoke();
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) e0.f38675b, 4, (Object) null);
                return null;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f38713b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating Braze event json";
        }
    }

    static {
        Class<j> cls = j.class;
        f38654i = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "userId", "getUserId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "sessionId", "getSessionId()Lcom/braze/models/SessionId;", 0))};
    }

    public j(c1 c1Var, JSONObject jSONObject, double d11, String str) {
        Intrinsics.checkNotNullParameter(c1Var, "type");
        Intrinsics.checkNotNullParameter(jSONObject, "data");
        Intrinsics.checkNotNullParameter(str, "uniqueIdentifier");
        this.f38655b = c1Var;
        this.f38656c = jSONObject;
        this.f38657d = d11;
        this.f38658e = str;
        this.f38659f = new j3();
        this.f38660g = new j3();
        if (c1Var == c1.UNKNOWN) {
            throw new IllegalArgumentException("Event type cannot be unknown.");
        }
    }

    public final void a(String str) {
        this.f38659f.setValue(this, f38654i[0], str);
    }

    public boolean d() {
        if (this.f38655b != c1.INTERNAL_ERROR || !k().optBoolean("nop", false)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034 A[Catch:{ JSONException -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043 A[Catch:{ JSONException -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044 A[Catch:{ JSONException -> 0x004e }] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject forJsonPut() {
        /*
            r10 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "name"
            bo.app.c1 r2 = r10.f38655b     // Catch:{ JSONException -> 0x004e }
            java.lang.String r2 = r2.forJsonPut()     // Catch:{ JSONException -> 0x004e }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x004e }
            java.lang.String r1 = "data"
            org.json.JSONObject r2 = r10.k()     // Catch:{ JSONException -> 0x004e }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x004e }
            java.lang.String r1 = "time"
            double r2 = r10.v()     // Catch:{ JSONException -> 0x004e }
            r0.put((java.lang.String) r1, (double) r2)     // Catch:{ JSONException -> 0x004e }
            java.lang.String r1 = r10.w()     // Catch:{ JSONException -> 0x004e }
            if (r1 == 0) goto L_0x0031
            int r1 = r1.length()     // Catch:{ JSONException -> 0x004e }
            if (r1 != 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r1 = 0
            goto L_0x0032
        L_0x0031:
            r1 = 1
        L_0x0032:
            if (r1 != 0) goto L_0x003d
            java.lang.String r1 = "user_id"
            java.lang.String r2 = r10.w()     // Catch:{ JSONException -> 0x004e }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x004e }
        L_0x003d:
            bo.app.j5 r1 = r10.n()     // Catch:{ JSONException -> 0x004e }
            if (r1 != 0) goto L_0x0044
            goto L_0x005d
        L_0x0044:
            java.lang.String r2 = "session_id"
            java.lang.String r1 = r1.forJsonPut()     // Catch:{ JSONException -> 0x004e }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x004e }
            goto L_0x005d
        L_0x004e:
            r1 = move-exception
            r5 = r1
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            bo.app.j$b r7 = bo.app.j.b.f38713b
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
        L_0x005d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.j.forJsonPut():org.json.JSONObject");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            return false;
        }
        return Intrinsics.areEqual((Object) r(), (Object) ((j) obj).r());
    }

    public int hashCode() {
        return r().hashCode();
    }

    public final c1 j() {
        return this.f38655b;
    }

    public JSONObject k() {
        return this.f38656c;
    }

    public final j5 n() {
        return (j5) this.f38660g.getValue(this, f38654i[1]);
    }

    public /* synthetic */ String p() {
        return w.a(this);
    }

    public String r() {
        return this.f38658e;
    }

    public String toString() {
        return p();
    }

    public double v() {
        return this.f38657d;
    }

    public final String w() {
        return (String) this.f38659f.getValue(this, f38654i[0]);
    }

    public final void a(j5 j5Var) {
        this.f38660g.setValue(this, f38654i[1], j5Var);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ j(bo.app.c1 r7, org.json.JSONObject r8, double r9, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 2
            if (r13 == 0) goto L_0x0009
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
        L_0x0009:
            r2 = r8
            r8 = r12 & 4
            if (r8 == 0) goto L_0x0012
            double r9 = com.braze.support.DateTimeUtils.nowInSecondsPrecise()
        L_0x0012:
            r3 = r9
            r8 = r12 & 8
            if (r8 == 0) goto L_0x0024
            java.util.UUID r8 = java.util.UUID.randomUUID()
            java.lang.String r11 = r8.toString()
            java.lang.String r8 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r8)
        L_0x0024:
            r5 = r11
            r0 = r6
            r1 = r7
            r0.<init>(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.j.<init>(bo.app.c1, org.json.JSONObject, double, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public j(c1 c1Var, JSONObject jSONObject, double d11, String str, String str2, String str3) {
        this(c1Var, jSONObject, d11, str);
        j5 j5Var;
        Intrinsics.checkNotNullParameter(c1Var, AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(jSONObject, "eventData");
        Intrinsics.checkNotNullParameter(str, "uniqueIdentifier");
        a(str2);
        if (str3 == null) {
            j5Var = null;
        } else {
            j5Var = j5.f38758d.a(str3);
        }
        a(j5Var);
    }
}
