package bo.app;

import com.braze.models.FeatureFlag;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0006\u0010\t¨\u0006\f"}, d2 = {"Lbo/app/h1;", "", "Lorg/json/JSONArray;", "featureFlagsJson", "", "Lcom/braze/models/FeatureFlag;", "a", "Lorg/json/JSONObject;", "featureFlagObject", "(Lorg/json/JSONObject;)Lcom/braze/models/FeatureFlag;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class h1 {

    /* renamed from: a  reason: collision with root package name */
    public static final h1 f38603a = new h1();

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "", "it", "", "a", "(I)Ljava/lang/Boolean;", "com/braze/support/JsonUtils$e"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function1<Integer, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f38604b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(JSONArray jSONArray) {
            super(1);
            this.f38604b = jSONArray;
        }

        public final Boolean a(int i11) {
            return Boolean.valueOf(this.f38604b.opt(i11) instanceof JSONObject);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0003\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "", "it", "a", "(I)Ljava/lang/Object;", "com/braze/support/JsonUtils$f"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function1<Integer, JSONObject> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f38605b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(JSONArray jSONArray) {
            super(1);
            this.f38605b = jSONArray;
        }

        public final JSONObject a(int i11) {
            Object obj = this.f38605b.get(i11);
            if (obj != null) {
                return (JSONObject) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38606b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(JSONObject jSONObject) {
            super(0);
            this.f38606b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to deserialize feature flag Json: ", this.f38606b);
        }
    }

    private h1() {
    }

    public final List<FeatureFlag> a(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "featureFlagsJson");
        ArrayList arrayList = new ArrayList();
        for (JSONObject a11 : SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(RangesKt___RangesKt.until(0, jSONArray.length())), new a(jSONArray)), new b(jSONArray))) {
            FeatureFlag a12 = f38603a.a(a11);
            if (a12 != null) {
                arrayList.add(a12);
            }
        }
        return arrayList;
    }

    public final FeatureFlag a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "featureFlagObject");
        try {
            String string = jSONObject.getString("id");
            Intrinsics.checkNotNullExpressionValue(string, "featureFlagObject.getString(FeatureFlag.ID)");
            boolean z11 = jSONObject.getBoolean("enabled");
            JSONObject optJSONObject = jSONObject.optJSONObject(FeatureFlag.PROPERTIES);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return new FeatureFlag(string, z11, optJSONObject);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new c(jSONObject), 4, (Object) null);
            return null;
        }
    }
}
