package bo.app;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001a"}, d2 = {"Lbo/app/x4;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lbo/app/c2;", "originalRequest", "Lbo/app/c2;", "b", "()Lbo/app/c2;", "sdkAuthErrorCode", "I", "c", "()I", "sdkAuthErrorReason", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "errorMessage", "a", "<init>", "(Lbo/app/c2;ILjava/lang/String;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class x4 implements q2 {

    /* renamed from: a  reason: collision with root package name */
    private final c2 f39552a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39553b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39554c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39555d;

    public x4(c2 c2Var, int i11, String str, String str2) {
        Intrinsics.checkNotNullParameter(c2Var, "originalRequest");
        this.f39552a = c2Var;
        this.f39553b = i11;
        this.f39554c = str;
        this.f39555d = str2;
    }

    public String a() {
        return this.f39555d;
    }

    public c2 b() {
        return this.f39552a;
    }

    public int c() {
        return this.f39553b;
    }

    public String d() {
        return this.f39554c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x4)) {
            return false;
        }
        x4 x4Var = (x4) obj;
        return Intrinsics.areEqual((Object) b(), (Object) x4Var.b()) && c() == x4Var.c() && Intrinsics.areEqual((Object) d(), (Object) x4Var.d()) && Intrinsics.areEqual((Object) a(), (Object) x4Var.a());
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((b().hashCode() * 31) + c()) * 31) + (d() == null ? 0 : d().hashCode())) * 31;
        if (a() != null) {
            i11 = a().hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "{code = " + c() + ", reason = " + d() + ", message = " + a() + AbstractJsonLexerKt.END_OBJ;
    }
}
