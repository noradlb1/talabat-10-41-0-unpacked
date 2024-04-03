package x4;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.values.providers.CoreValueProviders;

public final /* synthetic */ class d implements ValueProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34808a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CoreValueProviders f34809b;

    public /* synthetic */ d(Context context, CoreValueProviders coreValueProviders) {
        this.f34808a = context;
        this.f34809b = coreValueProviders;
    }

    public final Object get(String str) {
        return Integer.valueOf(CoreValueProviders.m8183integer$lambda3(this.f34808a, this.f34809b, str));
    }
}
