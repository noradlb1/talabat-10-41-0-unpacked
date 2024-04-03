package bo.app;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0015\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lbo/app/z;", "", "", "lastCardUpdatedAt", "J", "b", "()J", "lastFullSyncAt", "c", "", "isFullSync", "Z", "d", "()Z", "Lorg/json/JSONArray;", "contentCards", "Lorg/json/JSONArray;", "a", "()Lorg/json/JSONArray;", "Lorg/json/JSONObject;", "jsonObject", "<init>", "(Lorg/json/JSONObject;)V", "", "serializedCardJson", "(Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class z {

    /* renamed from: e  reason: collision with root package name */
    public static final a f39606e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final long f39607a;

    /* renamed from: b  reason: collision with root package name */
    private final long f39608b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f39609c;

    /* renamed from: d  reason: collision with root package name */
    private final JSONArray f39610d;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lbo/app/z$a;", "", "", "CONTENT_CARDS_KEY", "Ljava/lang/String;", "IS_FULL_SYNC_KEY", "LAST_CARD_UPDATED_AT_KEY", "LAST_FULL_SYNC_AT_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public z(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        this.f39607a = jSONObject.optLong("last_card_updated_at", -1);
        this.f39608b = jSONObject.optLong("last_full_sync_at", -1);
        this.f39609c = jSONObject.optBoolean("full_sync", false);
        this.f39610d = jSONObject.optJSONArray("cards");
    }

    public final JSONArray a() {
        return this.f39610d;
    }

    public final long b() {
        return this.f39607a;
    }

    public final long c() {
        return this.f39608b;
    }

    public final boolean d() {
        return this.f39609c;
    }

    public z(String str) {
        Intrinsics.checkNotNullParameter(str, "serializedCardJson");
        this.f39609c = false;
        this.f39607a = -1;
        this.f39608b = -1;
        this.f39610d = new JSONArray().put((Object) new JSONObject(str));
    }
}
