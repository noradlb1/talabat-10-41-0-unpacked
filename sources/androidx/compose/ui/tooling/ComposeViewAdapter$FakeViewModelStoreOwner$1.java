package androidx.compose.ui.tooling;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/lifecycle/ViewModelStore;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ComposeViewAdapter$FakeViewModelStoreOwner$1 implements ViewModelStoreOwner {
    public static final ComposeViewAdapter$FakeViewModelStoreOwner$1 INSTANCE = new ComposeViewAdapter$FakeViewModelStoreOwner$1();

    @NotNull
    public final ViewModelStore getViewModelStore() {
        throw new IllegalStateException("ViewModels creation is not supported in Preview");
    }
}
