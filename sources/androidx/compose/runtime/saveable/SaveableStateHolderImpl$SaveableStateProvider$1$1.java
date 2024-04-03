package androidx.compose.runtime.saveable;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SaveableStateHolderImpl$SaveableStateProvider$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SaveableStateHolderImpl f9505g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f9506h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SaveableStateHolderImpl.RegistryHolder f9507i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaveableStateHolderImpl$SaveableStateProvider$1$1(SaveableStateHolderImpl saveableStateHolderImpl, Object obj, SaveableStateHolderImpl.RegistryHolder registryHolder) {
        super(1);
        this.f9505g = saveableStateHolderImpl;
        this.f9506h = obj;
        this.f9507i = registryHolder;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        boolean z11 = !this.f9505g.registryHolders.containsKey(this.f9506h);
        Object obj = this.f9506h;
        if (z11) {
            this.f9505g.savedStates.remove(this.f9506h);
            this.f9505g.registryHolders.put(this.f9506h, this.f9507i);
            return new SaveableStateHolderImpl$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1(this.f9507i, this.f9505g, this.f9506h);
        }
        throw new IllegalArgumentException(("Key " + obj + " was used multiple times ").toString());
    }
}
