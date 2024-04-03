package cd;

import android.content.SharedPreferences;
import com.instabug.library.internal.sharedpreferences.c;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f50906b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SharedPreferences.OnSharedPreferenceChangeListener f50907c;

    public /* synthetic */ p(c cVar, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f50906b = cVar;
        this.f50907c = onSharedPreferenceChangeListener;
    }

    public final void run() {
        c.b(this.f50906b, this.f50907c);
    }
}
