package fl;

import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandlerImplKt;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f62058b;

    public /* synthetic */ b(MethodChannel.Result result) {
        this.f62058b = result;
    }

    public final void accept(Object obj) {
        ActiveCartsMethodCallHandlerImplKt.dispatchError(this.f62058b, (Throwable) obj);
    }
}
