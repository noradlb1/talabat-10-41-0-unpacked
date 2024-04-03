package ue;

import com.talabat.TestApp;
import java.util.Map;
import javax.inject.Provider;

public final /* synthetic */ class ke implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map.Entry f57616a;

    public /* synthetic */ ke(Map.Entry entry) {
        this.f57616a = entry;
    }

    public final Object get() {
        return TestApp.m9493setFeaturesDirect$lambda2$lambda1(this.f57616a);
    }
}
