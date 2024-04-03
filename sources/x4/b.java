package x4;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.values.providers.CoreValueProviders;

public final /* synthetic */ class b implements ValueProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34805a;

    public /* synthetic */ b(Context context) {
        this.f34805a = context;
    }

    public final Object get(String str) {
        return CoreValueProviders.m8181color$lambda1(this.f34805a, str);
    }
}
