package ms;

import com.talabat.helpers.TalabatApplication;
import com.talabat.integration.IntegrationsKt;
import java.util.concurrent.Callable;

public final /* synthetic */ class i implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatApplication f62341b;

    public /* synthetic */ i(TalabatApplication talabatApplication) {
        this.f62341b = talabatApplication;
    }

    public final Object call() {
        return IntegrationsKt.m10671initializeApptimize$lambda6(this.f62341b);
    }
}
