package c2;

import android.app.Activity;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

public final /* synthetic */ class b implements ActivityScenario.ActivityAction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f39653a;

    public /* synthetic */ b(Lifecycle.State state) {
        this.f39653a = state;
    }

    public final void perform(Activity activity) {
        FragmentScenario.m9085moveToState$lambda4(this.f39653a, (FragmentScenario.EmptyFragmentActivity) activity);
    }
}
