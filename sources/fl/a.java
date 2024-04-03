package fl;

import io.flutter.plugin.common.MethodChannel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f62057b;

    public /* synthetic */ a(MethodChannel.Result result) {
        this.f62057b = result;
    }

    public final void accept(Object obj) {
        this.f62057b.success((List) obj);
    }
}
