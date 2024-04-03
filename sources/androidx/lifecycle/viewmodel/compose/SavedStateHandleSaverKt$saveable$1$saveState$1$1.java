package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.lifecycle.SavedStateHandle;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SavedStateHandleSaverKt$saveable$1$saveState$1$1 implements SaverScope, FunctionAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateHandle.Companion f36138a;

    public SavedStateHandleSaverKt$saveable$1$saveState$1$1(SavedStateHandle.Companion companion) {
        this.f36138a = companion;
    }

    public final boolean canBeSaved(@Nullable Object obj) {
        return this.f36138a.validateValue(obj);
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SaverScope) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return Intrinsics.areEqual((Object) getFunctionDelegate(), (Object) ((FunctionAdapter) obj).getFunctionDelegate());
    }

    @NotNull
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.f36138a, SavedStateHandle.Companion.class, "validateValue", "validateValue(Ljava/lang/Object;)Z", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
