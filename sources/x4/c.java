package x4;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.values.providers.CoreValueProviders;

public final /* synthetic */ class c implements ValueProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34806a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CoreValueProviders f34807b;

    public /* synthetic */ c(Context context, CoreValueProviders coreValueProviders) {
        this.f34806a = context;
        this.f34807b = coreValueProviders;
    }

    public final Object get(String str) {
        return Float.valueOf(CoreValueProviders.m8182float$lambda2(this.f34806a, this.f34807b, str));
    }
}
