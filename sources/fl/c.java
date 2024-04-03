package fl;

import com.talabat.feature.activecarts.domain.channel.ActiveCartsMethodCallHandlerImpl;
import io.flutter.plugin.common.MethodCall;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodCall f62059b;

    public /* synthetic */ c(MethodCall methodCall) {
        this.f62059b = methodCall;
    }

    public final Object apply(Object obj) {
        return ActiveCartsMethodCallHandlerImpl.m10121navigateToQcommerceBasket$lambda1(this.f62059b, (List) obj);
    }
}
