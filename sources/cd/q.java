package cd;

import android.content.SharedPreferences;
import com.instabug.library.internal.sharedpreferences.c;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f50908b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SharedPreferences.OnSharedPreferenceChangeListener f50909c;

    public /* synthetic */ q(c cVar, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f50908b = cVar;
        this.f50909c = onSharedPreferenceChangeListener;
    }

    public final void run() {
        c.a(this.f50908b, this.f50909c);
    }
}
