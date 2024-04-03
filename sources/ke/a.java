package ke;

import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56950b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NavOptions f56951c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Navigator.Extras f56952d;

    public /* synthetic */ a(String str, NavOptions navOptions, Navigator.Extras extras) {
        this.f56950b = str;
        this.f56951c = navOptions;
        this.f56952d = extras;
    }

    public final void run() {
        NavigationController.lambda$navigate$default$0(this.f56950b, this.f56951c, this.f56952d);
    }
}
