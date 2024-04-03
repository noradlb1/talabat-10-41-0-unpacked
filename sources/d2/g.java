package d2;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class g implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateHandle f44275a;

    public /* synthetic */ g(SavedStateHandle savedStateHandle) {
        this.f44275a = savedStateHandle;
    }

    public final Bundle saveState() {
        return SavedStateHandle.m9091savedStateProvider$lambda0(this.f44275a);
    }
}
