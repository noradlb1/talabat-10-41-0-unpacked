package u5;

import com.deliveryhero.perseus.PerseusApp;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34697b;

    public /* synthetic */ c(Function1 function1) {
        this.f34697b = function1;
    }

    public final void accept(Object obj) {
        PerseusApp.init$lambda$0(this.f34697b, obj);
    }
}
