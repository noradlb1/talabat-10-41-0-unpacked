package u5;

import com.deliveryhero.perseus.PerseusApp;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34698b;

    public /* synthetic */ d(Function1 function1) {
        this.f34698b = function1;
    }

    public final void accept(Object obj) {
        PerseusApp.init$lambda$1(this.f34698b, obj);
    }
}
