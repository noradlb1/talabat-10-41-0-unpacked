package k6;

import android.content.Context;
import com.facebook.FacebookSdk;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f34510b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f34511c;

    public /* synthetic */ e(Context context, String str) {
        this.f34510b = context;
        this.f34511c = str;
    }

    public final void run() {
        FacebookSdk.m8862publishInstallAsync$lambda15(this.f34510b, this.f34511c);
    }
}
