package jn;

import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.feature.nfvinvendorsearch.presentation.handler.QCommerceMethodHandler;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f62189b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QCommerceMethodHandler f62190c;

    public /* synthetic */ a(MethodChannel.Result result, QCommerceMethodHandler qCommerceMethodHandler) {
        this.f62189b = result;
        this.f62190c = qCommerceMethodHandler;
    }

    public final void accept(Object obj) {
        QCommerceMethodHandler.m10234getVendor$lambda9(this.f62189b, this.f62190c, (Vendor) obj);
    }
}
