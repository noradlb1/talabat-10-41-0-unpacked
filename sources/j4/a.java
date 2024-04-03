package j4;

import com.checkout.network.extension.OkHttpProviderExtensionKt;
import okhttp3.Interceptor;
import okhttp3.Response;

public final /* synthetic */ class a implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f44367a;

    public /* synthetic */ a(String str) {
        this.f44367a = str;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return OkHttpProviderExtensionKt.m9336createNetworkApiRequestInterceptor$lambda1(this.f44367a, chain);
    }
}
