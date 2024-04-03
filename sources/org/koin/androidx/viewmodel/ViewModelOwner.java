package org.koin.androidx.viewmodel;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lorg/koin/androidx/viewmodel/ViewModelOwner;", "", "store", "Landroidx/lifecycle/ViewModelStore;", "stateRegistry", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/ViewModelStore;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getStateRegistry", "()Landroidx/savedstate/SavedStateRegistryOwner;", "getStore", "()Landroidx/lifecycle/ViewModelStore;", "Companion", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewModelOwner {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final SavedStateRegistryOwner stateRegistry;
    @NotNull
    private final ViewModelStore store;

    public ViewModelOwner(@NotNull ViewModelStore viewModelStore, @Nullable SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.checkNotNullParameter(viewModelStore, "store");
        this.store = viewModelStore;
        this.stateRegistry = savedStateRegistryOwner;
    }

    @Nullable
    public final SavedStateRegistryOwner getStateRegistry() {
        return this.stateRegistry;
    }

    @NotNull
    public final ViewModelStore getStore() {
        return this.store;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001¨\u0006\u000b"}, d2 = {"Lorg/koin/androidx/viewmodel/ViewModelOwner$Companion;", "", "()V", "from", "Lorg/koin/androidx/viewmodel/ViewModelOwner;", "storeOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "stateRegistry", "Landroidx/savedstate/SavedStateRegistryOwner;", "fromAny", "owner", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ViewModelOwner from$default(Companion companion, ViewModelStoreOwner viewModelStoreOwner, SavedStateRegistryOwner savedStateRegistryOwner, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                savedStateRegistryOwner = null;
            }
            return companion.from(viewModelStoreOwner, savedStateRegistryOwner);
        }

        @NotNull
        public final ViewModelOwner from(@NotNull ViewModelStoreOwner viewModelStoreOwner, @Nullable SavedStateRegistryOwner savedStateRegistryOwner) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "storeOwner");
            ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "storeOwner.viewModelStore");
            return new ViewModelOwner(viewModelStore, savedStateRegistryOwner);
        }

        @NotNull
        public final ViewModelOwner fromAny(@NotNull Object obj) {
            SavedStateRegistryOwner savedStateRegistryOwner;
            Intrinsics.checkNotNullParameter(obj, "owner");
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) obj).getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner as ViewModelStoreOwner).viewModelStore");
            if (obj instanceof SavedStateRegistryOwner) {
                savedStateRegistryOwner = (SavedStateRegistryOwner) obj;
            } else {
                savedStateRegistryOwner = null;
            }
            return new ViewModelOwner(viewModelStore, savedStateRegistryOwner);
        }

        @NotNull
        public final ViewModelOwner from(@NotNull ViewModelStoreOwner viewModelStoreOwner) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "storeOwner");
            ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "storeOwner.viewModelStore");
            return new ViewModelOwner(viewModelStore, (SavedStateRegistryOwner) null, 2, (DefaultConstructorMarker) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelOwner(ViewModelStore viewModelStore, SavedStateRegistryOwner savedStateRegistryOwner, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelStore, (i11 & 2) != 0 ? null : savedStateRegistryOwner);
    }
}
