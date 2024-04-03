package mm;

import com.talabat.feature.darkstoresflutter.domain.channel.DarkstoresCartMethodCallHandlerImpl;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f62301b;

    public /* synthetic */ c(MethodChannel.Result result) {
        this.f62301b = result;
    }

    public final void accept(Object obj) {
        DarkstoresCartMethodCallHandlerImpl.m10207performAction$lambda4(this.f62301b, (Throwable) obj);
    }
}
