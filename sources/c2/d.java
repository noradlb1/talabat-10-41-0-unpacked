package c2;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

public final /* synthetic */ class d implements ActivityScenario.ActivityAction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentFactory f39656a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f39657b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f39658c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f39659d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f39660e;

    public /* synthetic */ d(FragmentFactory fragmentFactory, Class cls, Bundle bundle, int i11, Lifecycle.State state) {
        this.f39656a = fragmentFactory;
        this.f39657b = cls;
        this.f39658c = bundle;
        this.f39659d = i11;
        this.f39660e = state;
    }

    public final void perform(Activity activity) {
        FragmentScenario.Companion.m9087internalLaunch$lambda2(this.f39656a, this.f39657b, this.f39658c, this.f39659d, this.f39660e, (FragmentScenario.EmptyFragmentActivity) activity);
    }
}
