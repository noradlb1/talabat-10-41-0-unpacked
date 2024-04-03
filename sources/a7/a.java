package a7;

import com.facebook.internal.security.OidcSecurityUtil;
import java.net.URL;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ URL f29310b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f29311c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f29312d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ReentrantLock f29313e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Condition f29314f;

    public /* synthetic */ a(URL url, Ref.ObjectRef objectRef, String str, ReentrantLock reentrantLock, Condition condition) {
        this.f29310b = url;
        this.f29311c = objectRef;
        this.f29312d = str;
        this.f29313e = reentrantLock;
        this.f29314f = condition;
    }

    public final void run() {
        OidcSecurityUtil.m8985getRawKeyFromEndPoint$lambda1(this.f29310b, this.f29311c, this.f29312d, this.f29313e, this.f29314f);
    }
}
