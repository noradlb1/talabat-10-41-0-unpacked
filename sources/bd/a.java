package bd;

import android.content.Context;
import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;

public final /* synthetic */ class a implements ReturnableRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f50834a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f50835b;

    public /* synthetic */ a(Context context, String str) {
        this.f50834a = context;
        this.f50835b = str;
    }

    public final Object run() {
        return CoreServiceLocator.m9384getInstabugSharedPreferences$lambda0(this.f50834a, this.f50835b);
    }
}
