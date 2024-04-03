package bo.app;

import android.util.Base64;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import net.bytebuddy.utility.JavaConstant;

public abstract class h6 implements w2 {

    /* renamed from: d  reason: collision with root package name */
    private static final String f38625d = BrazeLogger.getBrazeLogTag((Class<?>) h6.class);

    /* renamed from: a  reason: collision with root package name */
    private final long f38626a;

    /* renamed from: b  reason: collision with root package name */
    private final long f38627b;

    /* renamed from: c  reason: collision with root package name */
    private x1 f38628c;

    public h6() {
        long nowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        this.f38627b = nowInMilliseconds;
        this.f38626a = nowInMilliseconds / 1000;
    }

    public x1 a() {
        return this.f38628c;
    }

    public long b() {
        return this.f38626a;
    }

    public long e() {
        return this.f38627b;
    }

    public String a(String str) {
        if (StringUtils.isNullOrBlank(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str, 0)).split(JavaConstant.Dynamic.DEFAULT_NAME)[0];
        } catch (Exception e11) {
            String str2 = f38625d;
            BrazeLogger.e(str2, "Unexpected error decoding Base64 encoded campaign Id " + str, e11);
            return null;
        }
    }

    public h6(x1 x1Var) {
        this();
        this.f38628c = x1Var;
    }
}
