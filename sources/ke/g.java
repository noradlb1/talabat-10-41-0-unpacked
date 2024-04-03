package ke;

import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f56967b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NavOptions f56968c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Navigator.Extras f56969d;

    public /* synthetic */ g(int i11, NavOptions navOptions, Navigator.Extras extras) {
        this.f56967b = i11;
        this.f56968c = navOptions;
        this.f56969d = extras;
    }

    public final void run() {
        NavigationController.lambda$navigate$2(this.f56967b, this.f56968c, this.f56969d);
    }
}
