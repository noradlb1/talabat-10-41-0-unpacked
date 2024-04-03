package u5;

import com.deliveryhero.perseus.PerseusApp;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34696b;

    public /* synthetic */ b(Function1 function1) {
        this.f34696b = function1;
    }

    public final void accept(Object obj) {
        PerseusApp.logBacklogInfo$lambda$3(this.f34696b, obj);
    }
}
