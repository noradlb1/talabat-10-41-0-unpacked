package a2;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class a implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f35588a;

    public /* synthetic */ a(FragmentActivity fragmentActivity) {
        this.f35588a = fragmentActivity;
    }

    public final Bundle saveState() {
        return this.f35588a.lambda$init$0();
    }
}
