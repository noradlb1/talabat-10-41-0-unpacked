package bo.app;

import android.content.Context;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0017R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lbo/app/i3;", "Lbo/app/q6;", "Landroid/content/Context;", "context", "Lbo/app/j2;", "internalEventPublisher", "Lbo/app/w2;", "triggerEvent", "", "triggeredActionDisplayExpirationTimestamp", "", "a", "Lorg/json/JSONObject;", "e", "", "Lbo/app/o4;", "b", "()Ljava/util/List;", "remoteAssetPaths", "json", "Lbo/app/b2;", "brazeManager", "<init>", "(Lorg/json/JSONObject;Lbo/app/b2;)V", "c", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class i3 extends q6 {

    /* renamed from: l  reason: collision with root package name */
    public static final c f38637l = new c((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final IInAppMessage f38638i;

    /* renamed from: j  reason: collision with root package name */
    private final JSONObject f38639j;

    /* renamed from: k  reason: collision with root package name */
    private final b2 f38640k;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38641b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(JSONObject jSONObject) {
            super(0);
            this.f38641b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Attempting to parse in-app message triggered action with JSON: ", JsonUtils.getPrettyPrintedString(this.f38641b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f38642b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to parse in-app message triggered action.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lbo/app/i3$c;", "", "", "INAPP_TYPE", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38643a;

        static {
            int[] iArr = new int[MessageType.values().length];
            iArr[MessageType.HTML_FULL.ordinal()] = 1;
            iArr[MessageType.FULL.ordinal()] = 2;
            iArr[MessageType.MODAL.ordinal()] = 3;
            iArr[MessageType.SLIDEUP.ordinal()] = 4;
            iArr[MessageType.HTML.ordinal()] = 5;
            f38643a = iArr;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i3 f38644b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(i3 i3Var) {
            super(0);
            this.f38644b = i3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Attempting to publish in-app message after delay of " + this.f38644b.f().g() + " seconds.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w2 f38645b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(w2 w2Var) {
            super(0);
            this.f38645b = w2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot perform triggered action for " + this.f38645b + " due to in-app message json being null";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w2 f38646b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(w2 w2Var) {
            super(0);
            this.f38646b = w2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot perform triggered action for " + this.f38646b + " due to deserialized in-app message being null";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f38647b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception while performing triggered action.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i f38648b = new i();

        public i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "In-app message has no remote assets for prefetch. Returning empty list.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i3 f38649b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(i3 i3Var) {
            super(0);
            this.f38649b = i3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            IInAppMessage a11 = this.f38649b.f38638i;
            return Intrinsics.stringPlus("Failed to return remote paths to assets for type: ", a11 == null ? null : a11.getMessageType());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i3(JSONObject jSONObject, b2 b2Var) {
        super(jSONObject);
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new a(jSONObject), 6, (Object) null);
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        this.f38640k = b2Var;
        this.f38639j = jSONObject2;
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "inAppMessageObject");
        IInAppMessage a11 = f3.a(jSONObject2, b2Var);
        this.f38638i = a11;
        if (a11 == null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b.f38642b, 6, (Object) null);
            throw new IllegalArgumentException(Intrinsics.stringPlus("Failed to parse in-app message triggered action with JSON: ", JsonUtils.getPrettyPrintedString(jSONObject)));
        }
    }

    public List<o4> b() {
        List<String> list;
        boolean z11;
        int i11;
        ArrayList arrayList = new ArrayList();
        IInAppMessage iInAppMessage = this.f38638i;
        MessageType messageType = null;
        if (iInAppMessage == null) {
            list = null;
        } else {
            list = iInAppMessage.getRemoteAssetPathsForPrefetch();
        }
        if (list == null || list.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) i.f38648b, 7, (Object) null);
            return arrayList;
        }
        IInAppMessage iInAppMessage2 = this.f38638i;
        if (iInAppMessage2 != null) {
            messageType = iInAppMessage2.getMessageType();
        }
        if (messageType == null) {
            i11 = -1;
        } else {
            i11 = d.f38643a[messageType.ordinal()];
        }
        if (i11 == 1) {
            arrayList.add(new o4(p4.ZIP, list.get(0)));
        } else if (i11 == 2 || i11 == 3 || i11 == 4) {
            arrayList.add(new o4(p4.f39180c, list.get(0)));
        } else if (i11 != 5) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new j(this), 6, (Object) null);
        } else {
            for (String o4Var : list) {
                arrayList.add(new o4(p4.FILE, o4Var));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        JSONObject jSONObject;
        try {
            JSONObject e11 = super.e();
            if (e11 == null) {
                return null;
            }
            IInAppMessage iInAppMessage = this.f38638i;
            if (iInAppMessage == null) {
                jSONObject = null;
            } else {
                jSONObject = (JSONObject) iInAppMessage.forJsonPut();
            }
            e11.put("data", (Object) jSONObject);
            e11.put("type", (Object) "inapp");
            return e11;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void a(Context context, j2 j2Var, w2 w2Var, long j11) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(j2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(w2Var, "triggerEvent");
        try {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new e(this), 7, (Object) null);
            JSONObject jSONObject = this.f38639j;
            if (jSONObject == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new f(w2Var), 6, (Object) null);
                return;
            }
            IInAppMessage a11 = f3.a(jSONObject, this.f38640k);
            if (a11 == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new g(w2Var), 6, (Object) null);
                return;
            }
            a11.setLocalPrefetchedAssetPaths(y());
            a11.setExpirationTimestamp(j11);
            j2Var.a(new g3(w2Var, this, a11, this.f38640k.a()), g3.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) h.f38647b, 4, (Object) null);
        }
    }
}
