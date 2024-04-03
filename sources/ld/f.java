package ld;

import com.instabug.library.sessionV3.providers.FeatureSessionDataController;
import com.instabug.library.sessionV3.sync.a0;
import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FeatureSessionDataController f56985b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f56986c;

    public /* synthetic */ f(FeatureSessionDataController featureSessionDataController, List list) {
        this.f56985b = featureSessionDataController;
        this.f56986c = list;
    }

    public final Object call() {
        return a0.b(this.f56985b, this.f56986c);
    }
}
