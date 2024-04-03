package androidx.lifecycle.viewmodel.compose;

import android.os.Bundle;
import androidx.compose.runtime.saveable.Saver;
import androidx.core.os.BundleKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"", "T", "Landroid/os/Bundle;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class SavedStateHandleSaverKt$saveable$1 implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Saver<T, ? extends Object> f36136a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ T f36137b;

    public SavedStateHandleSaverKt$saveable$1(Saver<T, ? extends Object> saver, T t11) {
        this.f36136a = saver;
        this.f36137b = t11;
    }

    @NotNull
    public final Bundle saveState() {
        return BundleKt.bundleOf(TuplesKt.to("value", this.f36136a.save(new SavedStateHandleSaverKt$saveable$1$saveState$1$1(SavedStateHandle.Companion), this.f36137b)));
    }
}
