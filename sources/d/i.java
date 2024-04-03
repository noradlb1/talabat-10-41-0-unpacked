package d;

import androidx.activity.OnBackPressedDispatcher;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f11583b;

    public /* synthetic */ i(OnBackPressedDispatcher onBackPressedDispatcher) {
        this.f11583b = onBackPressedDispatcher;
    }

    public final void run() {
        this.f11583b.onBackPressed();
    }
}
