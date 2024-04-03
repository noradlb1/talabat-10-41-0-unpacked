package k6;

import com.facebook.AccessTokenManager;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class b implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f34504a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f34505b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Set f34506c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Set f34507d;

    public /* synthetic */ b(AtomicBoolean atomicBoolean, Set set, Set set2, Set set3) {
        this.f34504a = atomicBoolean;
        this.f34505b = set;
        this.f34506c = set2;
        this.f34507d = set3;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        AccessTokenManager.m8856refreshCurrentAccessTokenImpl$lambda1(this.f34504a, this.f34505b, this.f34506c, this.f34507d, graphResponse);
    }
}
