package bo.app;

import com.braze.models.IPutIntoJson;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007HÖ\u0003¨\u0006\u0010"}, d2 = {"Lbo/app/j5;", "Lcom/braze/models/IPutIntoJson;", "", "toString", "e", "", "hashCode", "", "other", "", "equals", "Ljava/util/UUID;", "sessionIdUuid", "<init>", "(Ljava/util/UUID;)V", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class j5 implements IPutIntoJson<String> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f38758d = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final UUID f38759b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38760c;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lbo/app/j5$a;", "", "Lbo/app/j5;", "a", "", "sessionId", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final j5 a() {
            UUID randomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(randomUUID, "randomUUID()");
            return new j5(randomUUID);
        }

        @JvmStatic
        public final j5 a(String str) {
            Intrinsics.checkNotNullParameter(str, "sessionId");
            UUID fromString = UUID.fromString(str);
            Intrinsics.checkNotNullExpressionValue(fromString, "fromString(sessionId)");
            return new j5(fromString);
        }
    }

    public j5(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "sessionIdUuid");
        this.f38759b = uuid;
        String uuid2 = uuid.toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "sessionIdUuid.toString()");
        this.f38760c = uuid2;
    }

    /* renamed from: e */
    public String forJsonPut() {
        return this.f38760c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j5) && Intrinsics.areEqual((Object) this.f38759b, (Object) ((j5) obj).f38759b);
    }

    public int hashCode() {
        return this.f38759b.hashCode();
    }

    public String toString() {
        return this.f38760c;
    }
}
