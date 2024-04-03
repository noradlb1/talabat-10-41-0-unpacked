package ld;

import com.instabug.library.sessionV3.providers.FeatureSessionLazyDataProvider;
import com.instabug.library.sessionV3.sync.b;
import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FeatureSessionLazyDataProvider f56987b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f56988c;

    public /* synthetic */ g(FeatureSessionLazyDataProvider featureSessionLazyDataProvider, List list) {
        this.f56987b = featureSessionLazyDataProvider;
        this.f56988c = list;
    }

    public final Object call() {
        return b.a(this.f56987b, this.f56988c);
    }
}
