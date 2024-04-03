package jn;

import com.talabat.feature.nfvinvendorsearch.presentation.handler.QCommerceMethodHandler;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f62191b;

    public /* synthetic */ b(MethodChannel.Result result) {
        this.f62191b = result;
    }

    public final void accept(Object obj) {
        QCommerceMethodHandler.m10233getVendor$lambda10(this.f62191b, (Throwable) obj);
    }
}
