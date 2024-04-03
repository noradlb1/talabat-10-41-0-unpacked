package u5;

import com.deliveryhero.perseus.PerseusApp;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34695b;

    public /* synthetic */ a(Function1 function1) {
        this.f34695b = function1;
    }

    public final void accept(Object obj) {
        PerseusApp.execute$lambda$2(this.f34695b, obj);
    }
}
