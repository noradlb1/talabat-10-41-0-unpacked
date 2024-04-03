package x4;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.values.providers.CoreValueProviders;

public final /* synthetic */ class a implements ValueProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34803a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CoreValueProviders f34804b;

    public /* synthetic */ a(Context context, CoreValueProviders coreValueProviders) {
        this.f34803a = context;
        this.f34804b = coreValueProviders;
    }

    public final Object get(String str) {
        return Boolean.valueOf(CoreValueProviders.m8180boolean$lambda0(this.f34803a, this.f34804b, str));
    }
}
