package bo.app;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lbo/app/u1;", "", "Lbo/app/k2;", "a", "()Lbo/app/k2;", "getHttpConnector$annotations", "()V", "httpConnector", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class u1 {

    /* renamed from: a  reason: collision with root package name */
    public static final u1 f39452a = new u1();

    /* renamed from: b  reason: collision with root package name */
    private static final int f39453b = ((int) TimeUnit.SECONDS.toMillis(5));

    /* renamed from: c  reason: collision with root package name */
    private static k2 f39454c;

    private u1() {
    }

    public static final k2 a() {
        k2 k2Var = f39454c;
        return k2Var == null ? new m3(new t1(f39453b)) : k2Var;
    }
}
