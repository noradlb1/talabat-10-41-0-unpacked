package vv;

import androidx.lifecycle.Observer;
import com.talabat.talabatcommon.views.vouchers.lifecycle.BasketLifecycleVoucherView;
import com.talabat.talabatcore.exception.Failure;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f24148a;

    public /* synthetic */ c(Function0 function0) {
        this.f24148a = function0;
    }

    public final void onChanged(Object obj) {
        BasketLifecycleVoucherView.m5787setupUi$lambda3$lambda2$lambda1(this.f24148a, (Failure) obj);
    }
}
