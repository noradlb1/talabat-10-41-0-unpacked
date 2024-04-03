package bo.app;

import kotlin.Metadata;
import l.a;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\b\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u0010"}, d2 = {"Lbo/app/x;", "", "", "a", "", "b", "", "toString", "hashCode", "other", "", "equals", "timeInMs", "retryCount", "<init>", "(JI)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class x {

    /* renamed from: a  reason: collision with root package name */
    private final long f39543a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39544b;

    public x(long j11, int i11) {
        this.f39543a = j11;
        this.f39544b = i11;
    }

    public final long a() {
        return this.f39543a;
    }

    public final int b() {
        return this.f39544b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f39543a == xVar.f39543a && this.f39544b == xVar.f39544b;
    }

    public int hashCode() {
        return (a.a(this.f39543a) * 31) + this.f39544b;
    }

    public String toString() {
        return "ContentCardRetryEvent(timeInMs=" + this.f39543a + ", retryCount=" + this.f39544b + ')';
    }
}
