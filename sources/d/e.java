package d;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class e implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f11579a;

    public /* synthetic */ e(ComponentActivity componentActivity) {
        this.f11579a = componentActivity;
    }

    public final Bundle saveState() {
        return this.f11579a.lambda$new$0();
    }
}
