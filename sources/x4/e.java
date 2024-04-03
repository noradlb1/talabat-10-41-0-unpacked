package x4;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.values.providers.CoreValueProviders;

public final /* synthetic */ class e implements ValueProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34810a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CoreValueProviders f34811b;

    public /* synthetic */ e(Context context, CoreValueProviders coreValueProviders) {
        this.f34810a = context;
        this.f34811b = coreValueProviders;
    }

    public final Object get(String str) {
        return CoreValueProviders.m8185logicalPixel$lambda4(this.f34810a, this.f34811b, str);
    }
}
