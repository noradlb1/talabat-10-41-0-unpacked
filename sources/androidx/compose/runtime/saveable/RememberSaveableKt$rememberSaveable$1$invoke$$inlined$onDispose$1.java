package androidx.compose.runtime.saveable;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RememberSaveableKt$rememberSaveable$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SaveableStateRegistry.Entry f9489a;

    public RememberSaveableKt$rememberSaveable$1$invoke$$inlined$onDispose$1(SaveableStateRegistry.Entry entry) {
        this.f9489a = entry;
    }

    public void dispose() {
        this.f9489a.unregister();
    }
}
