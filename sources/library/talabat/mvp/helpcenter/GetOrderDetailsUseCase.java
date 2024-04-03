package library.talabat.mvp.helpcenter;

import JsonModels.OrderDetailsRM;
import com.talabat.helpers.AppUrls;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.jetbrains.annotations.NotNull;
import service.ApiHandler;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Llibrary/talabat/mvp/helpcenter/GetOrderDetailsUseCase;", "", "apiHandler", "Lservice/ApiHandler;", "(Lservice/ApiHandler;)V", "getOrderDetails", "Lio/reactivex/Observable;", "LJsonModels/OrderDetailsRM;", "encryptedOrderId", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetOrderDetailsUseCase {
    @NotNull
    private final ApiHandler apiHandler;

    public GetOrderDetailsUseCase() {
        this((ApiHandler) null, 1, (DefaultConstructorMarker) null);
    }

    public GetOrderDetailsUseCase(@NotNull ApiHandler apiHandler2) {
        Intrinsics.checkNotNullParameter(apiHandler2, "apiHandler");
        this.apiHandler = apiHandler2;
    }

    @NotNull
    public final Observable<OrderDetailsRM> getOrderDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        Observable<OrderDetailsRM> orderDetails = this.apiHandler.getServices().getOrderDetails(CreateApiUrl.createWithParameters(AppUrls.ORDERDETAILSTALABAT, new String[]{"{transactionId}", str}));
        Intrinsics.checkNotNullExpressionValue(orderDetails, "apiHandler.services.getO…)\n            )\n        )");
        return orderDetails;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GetOrderDetailsUseCase(service.ApiHandler r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x000d
            service.ApiHandler r1 = service.ApiHandler.getInstance()
            java.lang.String r2 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        L_0x000d:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.helpcenter.GetOrderDetailsUseCase.<init>(service.ApiHandler, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
