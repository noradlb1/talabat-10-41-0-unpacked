package ms;

import com.talabat.helpers.TalabatApplication;
import com.talabat.integration.IntegrationsKt;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatApplication f62338b;

    public /* synthetic */ c(TalabatApplication talabatApplication) {
        this.f62338b = talabatApplication;
    }

    public final Object apply(Object obj) {
        return IntegrationsKt.m10667initializeAllInBackground$lambda1(this.f62338b, (Boolean) obj);
    }
}
