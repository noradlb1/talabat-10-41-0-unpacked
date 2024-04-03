package ld;

import com.instabug.library.sessionV3.providers.FeatureSessionDataController;
import com.instabug.library.sessionV3.sync.a0;
import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FeatureSessionDataController f56983b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f56984c;

    public /* synthetic */ e(FeatureSessionDataController featureSessionDataController, List list) {
        this.f56983b = featureSessionDataController;
        this.f56984c = list;
    }

    public final Object call() {
        return a0.a(this.f56983b, this.f56984c);
    }
}
