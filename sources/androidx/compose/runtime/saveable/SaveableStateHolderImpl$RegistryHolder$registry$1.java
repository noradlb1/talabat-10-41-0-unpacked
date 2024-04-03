package androidx.compose.runtime.saveable;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SaveableStateHolderImpl$RegistryHolder$registry$1 extends Lambda implements Function1<Object, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SaveableStateHolderImpl f9504g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaveableStateHolderImpl$RegistryHolder$registry$1(SaveableStateHolderImpl saveableStateHolderImpl) {
        super(1);
        this.f9504g = saveableStateHolderImpl;
    }

    @NotNull
    public final Boolean invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        SaveableStateRegistry parentSaveableStateRegistry = this.f9504g.getParentSaveableStateRegistry();
        return Boolean.valueOf(parentSaveableStateRegistry != null ? parentSaveableStateRegistry.canBeSaved(obj) : true);
    }
}
