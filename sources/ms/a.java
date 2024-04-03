package ms;

import com.talabat.helpers.TalabatApplication;
import com.talabat.integration.IntegrationsKt;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TalabatApplication f62337b;

    public /* synthetic */ a(TalabatApplication talabatApplication) {
        this.f62337b = talabatApplication;
    }

    public final Object call() {
        return IntegrationsKt.m10665initializeAll$lambda7(this.f62337b);
    }
}
