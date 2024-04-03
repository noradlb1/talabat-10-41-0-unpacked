package x4;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.values.providers.CoreValueProviders;

public final /* synthetic */ class h implements ValueProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34816a;

    public /* synthetic */ h(Context context) {
        this.f34816a = context;
    }

    public final Object get(String str) {
        return CoreValueProviders.m8188textStyle$lambda7(this.f34816a, str);
    }
}
