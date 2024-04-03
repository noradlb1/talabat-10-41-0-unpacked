package x4;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.values.providers.CoreValueProviders;

public final /* synthetic */ class g implements ValueProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34814a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CoreValueProviders f34815b;

    public /* synthetic */ g(Context context, CoreValueProviders coreValueProviders) {
        this.f34814a = context;
        this.f34815b = coreValueProviders;
    }

    public final Object get(String str) {
        return CoreValueProviders.m8187string$lambda6(this.f34814a, this.f34815b, str);
    }
}
