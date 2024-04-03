package androidx.compose.runtime.saveable;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1 implements SaverScope {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SaveableStateRegistry f9499a;

    public RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1(SaveableStateRegistry saveableStateRegistry) {
        this.f9499a = saveableStateRegistry;
    }

    public final boolean canBeSaved(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        return this.f9499a.canBeSaved(obj);
    }
}
