package androidx.compose.ui.tooling;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1", "Landroidx/savedstate/SavedStateRegistryOwner;", "controller", "Landroidx/savedstate/SavedStateRegistryController;", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getSavedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "ui-tooling_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComposeViewAdapter$FakeSavedStateRegistryOwner$1 implements SavedStateRegistryOwner {
    @NotNull
    private final SavedStateRegistryController controller;
    @NotNull
    private final LifecycleRegistry lifecycle;

    public ComposeViewAdapter$FakeSavedStateRegistryOwner$1() {
        LifecycleRegistry createUnsafe = LifecycleRegistry.createUnsafe(this);
        Intrinsics.checkNotNullExpressionValue(createUnsafe, "createUnsafe(this)");
        this.lifecycle = createUnsafe;
        SavedStateRegistryController create = SavedStateRegistryController.create(this);
        create.performRestore(new Bundle());
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(create, "create(this).apply {\n   …store(Bundle())\n        }");
        this.controller = create;
        createUnsafe.setCurrentState(Lifecycle.State.RESUMED);
    }

    @NotNull
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @NotNull
    public SavedStateRegistry getSavedStateRegistry() {
        SavedStateRegistry savedStateRegistry = this.controller.getSavedStateRegistry();
        Intrinsics.checkNotNullExpressionValue(savedStateRegistry, "controller.savedStateRegistry");
        return savedStateRegistry;
    }
}
