package c2;

import android.app.Activity;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.core.app.ActivityScenario;

public final /* synthetic */ class c implements ActivityScenario.ActivityAction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentScenario f39654a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentScenario.FragmentAction f39655b;

    public /* synthetic */ c(FragmentScenario fragmentScenario, FragmentScenario.FragmentAction fragmentAction) {
        this.f39654a = fragmentScenario;
        this.f39655b = fragmentAction;
    }

    public final void perform(Activity activity) {
        FragmentScenario.m9086onFragment$lambda6(this.f39654a, this.f39655b, (FragmentScenario.EmptyFragmentActivity) activity);
    }
}
