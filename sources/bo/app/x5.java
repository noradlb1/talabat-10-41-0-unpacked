package bo.app;

import android.content.Context;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001eB\u0019\b\u0016\u0012\u0006\u0010!\u001a\u00020\u0011\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R$\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006&"}, d2 = {"Lbo/app/x5;", "Lbo/app/q6;", "Lbo/app/b3;", "Lorg/json/JSONArray;", "remoteAssetUrls", "Lbo/app/p4;", "pathType", "", "a", "Landroid/content/Context;", "context", "Lbo/app/j2;", "internalEventPublisher", "Lbo/app/w2;", "triggerEvent", "", "triggeredActionDisplayExpirationTimestamp", "Lorg/json/JSONObject;", "e", "", "<set-?>", "triggerId", "Ljava/lang/String;", "z", "()Ljava/lang/String;", "J", "A", "()J", "", "Lbo/app/o4;", "b", "()Ljava/util/List;", "remoteAssetPaths", "json", "Lbo/app/b2;", "brazeManager", "<init>", "(Lorg/json/JSONObject;Lbo/app/b2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class x5 extends q6 {

    /* renamed from: m  reason: collision with root package name */
    public static final b f39556m = new b((DefaultConstructorMarker) null);

    /* renamed from: i  reason: collision with root package name */
    private b2 f39557i;

    /* renamed from: j  reason: collision with root package name */
    private String f39558j;

    /* renamed from: k  reason: collision with root package name */
    private final List<o4> f39559k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private long f39560l = -1;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f39561b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(JSONObject jSONObject) {
            super(0);
            this.f39561b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Parsing templated triggered action with JSON: ", JsonUtils.getPrettyPrintedString(this.f39561b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lbo/app/x5$b;", "", "", "PREFETCH_FILE_URLS", "Ljava/lang/String;", "PREFETCH_IMAGE_URLS", "PREFETCH_ZIP_URLS", "TEMPLATED_INAPP_TYPE", "TRIGGER_ID", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39562a;

        static {
            int[] iArr = new int[p4.values().length];
            iArr[p4.f39180c.ordinal()] = 1;
            iArr[p4.ZIP.ordinal()] = 2;
            iArr[p4.FILE.ordinal()] = 3;
            f39562a = iArr;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "", "it", "", "a", "(I)Ljava/lang/Boolean;", "com/braze/support/JsonUtils$e"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function1<Integer, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f39563b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(JSONArray jSONArray) {
            super(1);
            this.f39563b = jSONArray;
        }

        public final Boolean a(int i11) {
            return Boolean.valueOf(this.f39563b.opt(i11) instanceof String);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0003\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "", "it", "a", "(I)Ljava/lang/Object;", "com/braze/support/JsonUtils$f"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function1<Integer, String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f39564b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(JSONArray jSONArray) {
            super(1);
            this.f39564b = jSONArray;
        }

        public final String a(int i11) {
            Object obj = this.f39564b.get(i11);
            if (obj != null) {
                return (String) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f39565b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not convert TemplatedTriggeredAction to JSON";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x5 f39566b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(x5 x5Var) {
            super(0);
            this.f39566b = x5Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Posting templating request after delay of " + this.f39566b.f().g() + " seconds.";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x5(JSONObject jSONObject, b2 b2Var) {
        super(jSONObject);
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new a(jSONObject), 7, (Object) null);
        this.f39557i = b2Var;
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        String string = jSONObject2.getString(InAppMessageBase.TRIGGER_ID);
        Intrinsics.checkNotNullExpressionValue(string, "dataObject.getString(TRIGGER_ID)");
        this.f39558j = string;
        JSONArray optJSONArray = jSONObject2.optJSONArray("prefetch_image_urls");
        if (optJSONArray != null) {
            a(optJSONArray, p4.f39180c);
        }
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("prefetch_zip_urls");
        if (optJSONArray2 != null) {
            a(optJSONArray2, p4.ZIP);
        }
        JSONArray optJSONArray3 = jSONObject2.optJSONArray("prefetch_file_urls");
        if (optJSONArray3 != null) {
            a(optJSONArray3, p4.FILE);
        }
    }

    public final long A() {
        return this.f39560l;
    }

    public void a(Context context, j2 j2Var, w2 w2Var, long j11) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(j2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(w2Var, "triggerEvent");
        this.f39560l = j11;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new g(this), 7, (Object) null);
        this.f39557i.a(this, w2Var);
    }

    public List<o4> b() {
        return new ArrayList(this.f39559k);
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        try {
            JSONObject e11 = super.e();
            if (e11 == null) {
                return null;
            }
            e11.put("type", (Object) "templated_iam");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(InAppMessageBase.TRIGGER_ID, (Object) this.f39558j);
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            for (o4 next : this.f39559k) {
                int i11 = c.f39562a[next.a().ordinal()];
                if (i11 == 1) {
                    jSONArray.put((Object) next.b());
                } else if (i11 == 2) {
                    jSONArray2.put((Object) next.b());
                } else if (i11 == 3) {
                    jSONArray3.put((Object) next.b());
                }
            }
            jSONObject.put("prefetch_image_urls", (Object) jSONArray);
            jSONObject.put("prefetch_zip_urls", (Object) jSONArray2);
            jSONObject.put("prefetch_file_urls", (Object) jSONArray3);
            e11.put("data", (Object) jSONObject);
            return e11;
        } catch (JSONException e12) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e12, false, (Function0) f.f39565b, 4, (Object) null);
            return null;
        }
    }

    public final String z() {
        return this.f39558j;
    }

    private final void a(JSONArray jSONArray, p4 p4Var) {
        Iterator it;
        if (jSONArray == null) {
            it = CollectionsKt__CollectionsKt.emptyList().iterator();
        } else {
            it = SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(RangesKt___RangesKt.until(0, jSONArray.length())), new d(jSONArray)), new e(jSONArray)).iterator();
        }
        while (it.hasNext()) {
            this.f39559k.add(new o4(p4Var, (String) it.next()));
        }
    }
}
