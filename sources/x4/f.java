package x4;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.values.providers.CoreValueProviders;

public final /* synthetic */ class f implements ValueProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34812a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CoreValueProviders f34813b;

    public /* synthetic */ f(Context context, CoreValueProviders coreValueProviders) {
        this.f34812a = context;
        this.f34813b = coreValueProviders;
    }

    public final Object get(String str) {
        return CoreValueProviders.m8186scalableLogicalPixel$lambda5(this.f34812a, this.f34813b, str);
    }
}
