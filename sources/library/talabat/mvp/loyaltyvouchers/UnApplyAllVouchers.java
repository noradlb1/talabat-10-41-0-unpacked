package library.talabat.mvp.loyaltyvouchers;

import JsonModels.Response.VoucherUnAppliedResponse;
import com.talabat.helpers.AppUrls;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Llibrary/talabat/mvp/loyaltyvouchers/UnApplyAllVouchers;", "", "apiHandler", "Lservice/ApiHandler;", "(Lservice/ApiHandler;)V", "unApplyAllVouchers", "Lio/reactivex/Observable;", "LJsonModels/Response/VoucherUnAppliedResponse;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnApplyAllVouchers {
    @NotNull
    private final ApiHandler apiHandler;

    public UnApplyAllVouchers() {
        this((ApiHandler) null, 1, (DefaultConstructorMarker) null);
    }

    public UnApplyAllVouchers(@NotNull ApiHandler apiHandler2) {
        Intrinsics.checkNotNullParameter(apiHandler2, "apiHandler");
        this.apiHandler = apiHandler2;
    }

    @Nullable
    public final Observable<VoucherUnAppliedResponse> unApplyAllVouchers() {
        return this.apiHandler.getServices().unApplyAllVouchers(AppUrls.VOUCHERS_UN_APPLY_ALL);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UnApplyAllVouchers(service.ApiHandler r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.loyaltyvouchers.UnApplyAllVouchers.<init>(service.ApiHandler, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
