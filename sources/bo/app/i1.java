package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lbo/app/i1;", "Lbo/app/d2;", "", "cardId", "Lbo/app/x1;", "c", "a", "d", "b", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class i1 implements d2 {

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38635b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(0);
            this.f38635b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Cannot create card control event for Feed card. Returning null. Card id: ", this.f38635b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38636b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(0);
            this.f38636b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Cannot create card dismissed event for Feed card. Returning null. Card id: ", this.f38636b);
        }
    }

    public x1 a(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        return j.f38653h.e(str);
    }

    public x1 b(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new a(str), 6, (Object) null);
        return null;
    }

    public x1 c(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        return j.f38653h.f(str);
    }

    public x1 d(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new b(str), 6, (Object) null);
        return null;
    }
}
