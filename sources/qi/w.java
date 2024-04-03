package qi;

import com.talabat.darkstores.domain.common.BuildVoucherDetailsNavigationUseCaseImpl;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class w implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f57249b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterConfigurationParams f57250c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57251d;

    public /* synthetic */ w(Function2 function2, FlutterConfigurationParams flutterConfigurationParams, String str) {
        this.f57249b = function2;
        this.f57250c = flutterConfigurationParams;
        this.f57251d = str;
    }

    public final Object call() {
        return BuildVoucherDetailsNavigationUseCaseImpl.m9766invoke$lambda0(this.f57249b, this.f57250c, this.f57251d);
    }
}
