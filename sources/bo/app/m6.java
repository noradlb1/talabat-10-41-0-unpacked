package bo.app;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\rJ!\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\u0011\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0007\u0010\u0013¨\u0006\u0016"}, d2 = {"Lbo/app/m6;", "", "Lorg/json/JSONObject;", "templatedMessageJson", "Lbo/app/b2;", "brazeManager", "Lcom/braze/models/inappmessage/IInAppMessage;", "a", "(Lorg/json/JSONObject;Lbo/app/b2;)Lcom/braze/models/inappmessage/IInAppMessage;", "Lorg/json/JSONArray;", "triggeredActionJsonArray", "", "Lbo/app/b3;", "(Lorg/json/JSONArray;Lbo/app/b2;)Ljava/util/List;", "actionJson", "b", "(Lorg/json/JSONObject;Lbo/app/b2;)Lbo/app/b3;", "triggerConditionsJson", "Lbo/app/v2;", "(Lorg/json/JSONArray;)Ljava/util/List;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class m6 {

    /* renamed from: a  reason: collision with root package name */
    public static final m6 f38991a = new m6();

    /* renamed from: b  reason: collision with root package name */
    private static final String f38992b = BrazeLogger.getBrazeLogTag((Class<?>) m6.class);

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f38993b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Templated message Json was null. Not de-serializing templated message.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38994b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(0);
            this.f38994b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received templated message Json with unknown type: " + this.f38994b + ". Not parsing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38995b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(JSONObject jSONObject) {
            super(0);
            this.f38995b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Encountered exception processing templated message: ", this.f38995b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f38996b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received null or blank trigger condition Json. Not parsing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38997b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(0);
            this.f38997b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received triggered condition Json with unknown type: " + this.f38997b + ". Not parsing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38998b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(0);
            this.f38998b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Received unknown trigger type: ", this.f38998b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38999b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(JSONObject jSONObject) {
            super(0);
            this.f38999b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to deserialize triggered action Json: ", this.f38999b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f39000b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered actions Json array was null. Not de-serializing triggered actions.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f39001b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(JSONArray jSONArray) {
            super(0);
            this.f39001b = jSONArray;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to deserialize triggered actions Json array: ", this.f39001b);
        }
    }

    private m6() {
    }

    public final IInAppMessage a(JSONObject jSONObject, b2 b2Var) {
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        if (jSONObject == null) {
            try {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38992b, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a.f38993b, 14, (Object) null);
                return null;
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38992b, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new c(jSONObject), 8, (Object) null);
                return null;
            }
        } else {
            String string = jSONObject.getString("type");
            if (Intrinsics.areEqual((Object) string, (Object) "inapp")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2 == null) {
                    return null;
                }
                return f3.a(jSONObject2, b2Var);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38992b, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new b(string), 12, (Object) null);
            return null;
        }
    }

    public final b3 b(JSONObject jSONObject, b2 b2Var) {
        Intrinsics.checkNotNullParameter(jSONObject, "actionJson");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        try {
            String string = jSONObject.getString("type");
            if (Intrinsics.areEqual((Object) string, (Object) "inapp")) {
                return new i3(jSONObject, b2Var);
            }
            if (Intrinsics.areEqual((Object) string, (Object) "templated_iam")) {
                return new x5(jSONObject, b2Var);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new f(string), 6, (Object) null);
            return null;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38992b, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new g(jSONObject), 8, (Object) null);
        }
    }

    public final List<b3> a(JSONArray jSONArray, b2 b2Var) {
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        if (jSONArray == null) {
            try {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38992b, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) h.f39000b, 14, (Object) null);
                return null;
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38992b, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new i(jSONArray), 8, (Object) null);
                return null;
            }
        } else {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "actionJson");
                b3 b11 = b(jSONObject, b2Var);
                if (b11 != null) {
                    arrayList.add(b11);
                }
                i11 = i12;
            }
            return arrayList;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<bo.app.v2> a(org.json.JSONArray r14) {
        /*
            r13 = this;
            java.lang.String r0 = "triggerConditionsJson"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r14.length()
            r2 = 0
        L_0x000f:
            if (r2 >= r1) goto L_0x00e8
            int r3 = r2 + 1
            org.json.JSONObject r2 = r14.optJSONObject(r2)
            if (r2 != 0) goto L_0x002b
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r5 = f38992b
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.W
            bo.app.m6$d r9 = bo.app.m6.d.f38996b
            r7 = 0
            r8 = 0
            r10 = 12
            r11 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.String) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
            goto L_0x00e5
        L_0x002b:
            java.lang.String r4 = "type"
            java.lang.String r4 = r2.getString(r4)
            if (r4 == 0) goto L_0x00d2
            int r5 = r4.hashCode()
            switch(r5) {
                case -1679221933: goto L_0x00c0;
                case 3417674: goto L_0x00ae;
                case 3556498: goto L_0x009c;
                case 447503464: goto L_0x008a;
                case 717572172: goto L_0x0078;
                case 1512893214: goto L_0x0064;
                case 1743324417: goto L_0x0050;
                case 1926863907: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x00d2
        L_0x003c:
            java.lang.String r5 = "push_click"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x0046
            goto L_0x00d2
        L_0x0046:
            bo.app.i4 r4 = new bo.app.i4
            r4.<init>(r2)
            r0.add(r4)
            goto L_0x00e5
        L_0x0050:
            java.lang.String r5 = "purchase"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x005a
            goto L_0x00d2
        L_0x005a:
            bo.app.e4 r4 = new bo.app.e4
            r4.<init>(r2)
            r0.add(r4)
            goto L_0x00e5
        L_0x0064:
            java.lang.String r5 = "iam_click"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x006e
            goto L_0x00d2
        L_0x006e:
            bo.app.d3 r4 = new bo.app.d3
            r4.<init>(r2)
            r0.add(r4)
            goto L_0x00e5
        L_0x0078:
            java.lang.String r5 = "custom_event"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x0081
            goto L_0x00d2
        L_0x0081:
            bo.app.d0 r4 = new bo.app.d0
            r4.<init>(r2)
            r0.add(r4)
            goto L_0x00e5
        L_0x008a:
            java.lang.String r5 = "custom_event_property"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x0093
            goto L_0x00d2
        L_0x0093:
            bo.app.f0 r4 = new bo.app.f0
            r4.<init>(r2)
            r0.add(r4)
            goto L_0x00e5
        L_0x009c:
            java.lang.String r2 = "test"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x00a5
            goto L_0x00d2
        L_0x00a5:
            bo.app.y5 r2 = new bo.app.y5
            r2.<init>()
            r0.add(r2)
            goto L_0x00e5
        L_0x00ae:
            java.lang.String r2 = "open"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x00b7
            goto L_0x00d2
        L_0x00b7:
            bo.app.w3 r2 = new bo.app.w3
            r2.<init>()
            r0.add(r2)
            goto L_0x00e5
        L_0x00c0:
            java.lang.String r5 = "purchase_property"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x00c9
            goto L_0x00d2
        L_0x00c9:
            bo.app.g4 r4 = new bo.app.g4
            r4.<init>(r2)
            r0.add(r4)
            goto L_0x00e5
        L_0x00d2:
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r6 = f38992b
            com.braze.support.BrazeLogger$Priority r7 = com.braze.support.BrazeLogger.Priority.W
            bo.app.m6$e r10 = new bo.app.m6$e
            r10.<init>(r4)
            r8 = 0
            r9 = 0
            r11 = 12
            r12 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.String) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (boolean) r9, (kotlin.jvm.functions.Function0) r10, (int) r11, (java.lang.Object) r12)
        L_0x00e5:
            r2 = r3
            goto L_0x000f
        L_0x00e8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.m6.a(org.json.JSONArray):java.util.List");
    }
}
