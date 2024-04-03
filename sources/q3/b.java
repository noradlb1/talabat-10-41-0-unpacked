package q3;

import android.net.Uri;
import com.braze.Braze;
import com.braze.IBrazeEndpointProvider;

public final /* synthetic */ class b implements IBrazeEndpointProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f44383a;

    public /* synthetic */ b(String str) {
        this.f44383a = str;
    }

    public final Uri getApiEndpoint(Uri uri) {
        return Braze.Companion.m9193setConfiguredCustomEndpoint$lambda12$lambda11(this.f44383a, uri);
    }
}
