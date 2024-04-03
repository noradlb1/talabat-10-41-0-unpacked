package a1;

import android.app.Activity;
import androidx.core.app.ActivityCompat;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f487b;

    public /* synthetic */ a(Activity activity) {
        this.f487b = activity;
    }

    public final void run() {
        ActivityCompat.lambda$recreate$0(this.f487b);
    }
}
