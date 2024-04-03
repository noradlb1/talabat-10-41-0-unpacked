package mm;

import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoresCartMethodCallHandlerImpl;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.functions.Action;

public final /* synthetic */ class b implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f62300b;

    public /* synthetic */ b(MethodChannel.Result result) {
        this.f62300b = result;
    }

    public final void run() {
        DarkstoresCartMethodCallHandlerImpl.m10206performAction$lambda3(this.f62300b);
    }
}
