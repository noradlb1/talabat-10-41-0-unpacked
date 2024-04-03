package androidx.compose.runtime.saveable;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SaveableStateHolderImpl$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SaveableStateHolderImpl.RegistryHolder f9500a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SaveableStateHolderImpl f9501b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9502c;

    public SaveableStateHolderImpl$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1(SaveableStateHolderImpl.RegistryHolder registryHolder, SaveableStateHolderImpl saveableStateHolderImpl, Object obj) {
        this.f9500a = registryHolder;
        this.f9501b = saveableStateHolderImpl;
        this.f9502c = obj;
    }

    public void dispose() {
        this.f9500a.saveTo(this.f9501b.savedStates);
        this.f9501b.registryHolders.remove(this.f9502c);
    }
}
