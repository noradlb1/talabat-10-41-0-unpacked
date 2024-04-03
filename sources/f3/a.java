package f3;

import coil.util.Extensions;
import kotlin.Lazy;
import okhttp3.Call;
import okhttp3.Request;

public final /* synthetic */ class a implements Call.Factory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Lazy f44292b;

    public /* synthetic */ a(Lazy lazy) {
        this.f44292b = lazy;
    }

    public final Call newCall(Request request) {
        return Extensions.m9134lazyCallFactory$lambda3(this.f44292b, request);
    }
}
