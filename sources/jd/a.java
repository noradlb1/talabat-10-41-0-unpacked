package jd;

import com.instabug.library.sessionV3.cache.b;
import com.instabug.library.sessionV3.providers.FeatureSessionDataController;
import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FeatureSessionDataController f56914b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f56915c;

    public /* synthetic */ a(FeatureSessionDataController featureSessionDataController, List list) {
        this.f56914b = featureSessionDataController;
        this.f56915c = list;
    }

    public final Object call() {
        return b.a(this.f56914b, this.f56915c);
    }
}
