package ke;

import androidx.compose.runtime.Composer;
import androidx.navigation.NavBackStackEntry;
import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavBackStackEntry f56954b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Composer f56955c;

    public /* synthetic */ c(NavBackStackEntry navBackStackEntry, Composer composer) {
        this.f56954b = navBackStackEntry;
        this.f56955c = composer;
    }

    public final void run() {
        NavigationController.lambda$invoke$1(this.f56954b, this.f56955c);
    }
}
