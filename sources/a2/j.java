package a2;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class j implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f35597a;

    public /* synthetic */ j(FragmentManager fragmentManager) {
        this.f35597a = fragmentManager;
    }

    public final Bundle saveState() {
        return this.f35597a.lambda$attachController$4();
    }
}
