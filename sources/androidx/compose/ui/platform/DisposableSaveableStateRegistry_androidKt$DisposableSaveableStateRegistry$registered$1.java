package androidx.compose.ui.platform;

import android.os.Bundle;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.savedstate.SavedStateRegistry;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroid/os/Bundle;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$registered$1 implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SaveableStateRegistry f10033a;

    public DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$registered$1(SaveableStateRegistry saveableStateRegistry) {
        this.f10033a = saveableStateRegistry;
    }

    @NotNull
    public final Bundle saveState() {
        return DisposableSaveableStateRegistry_androidKt.toBundle(this.f10033a.performSave());
    }
}
