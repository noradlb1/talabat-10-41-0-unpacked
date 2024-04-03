package com.talabat.talabatcore.adapters;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B3\u0012\"\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ%\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0006HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003JA\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002$\b\u0002\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcore/adapters/Binding;", "I", "", "itemsAdapter", "Lcom/talabat/talabatcore/adapters/UpdatableAdapter;", "Lcom/talabat/talabatcore/adapters/UpdatableViewHolder;", "Lcom/talabat/talabatcore/adapters/ItemsAdapter;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/talabat/talabatcore/adapters/UpdatableAdapter;Landroidx/lifecycle/LifecycleOwner;)V", "getItemsAdapter", "()Lcom/talabat/talabatcore/adapters/UpdatableAdapter;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class Binding<I> {
    @NotNull
    private final UpdatableAdapter<I, UpdatableViewHolder<I>> itemsAdapter;
    @Nullable
    private final LifecycleOwner lifecycleOwner;

    public Binding(@NotNull UpdatableAdapter<I, UpdatableViewHolder<I>> updatableAdapter, @Nullable LifecycleOwner lifecycleOwner2) {
        Intrinsics.checkNotNullParameter(updatableAdapter, "itemsAdapter");
        this.itemsAdapter = updatableAdapter;
        this.lifecycleOwner = lifecycleOwner2;
    }

    public static /* synthetic */ Binding copy$default(Binding binding, UpdatableAdapter<I, UpdatableViewHolder<I>> updatableAdapter, LifecycleOwner lifecycleOwner2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            updatableAdapter = binding.itemsAdapter;
        }
        if ((i11 & 2) != 0) {
            lifecycleOwner2 = binding.lifecycleOwner;
        }
        return binding.copy(updatableAdapter, lifecycleOwner2);
    }

    @NotNull
    public final UpdatableAdapter<I, UpdatableViewHolder<I>> component1() {
        return this.itemsAdapter;
    }

    @Nullable
    public final LifecycleOwner component2() {
        return this.lifecycleOwner;
    }

    @NotNull
    public final Binding<I> copy(@NotNull UpdatableAdapter<I, UpdatableViewHolder<I>> updatableAdapter, @Nullable LifecycleOwner lifecycleOwner2) {
        Intrinsics.checkNotNullParameter(updatableAdapter, "itemsAdapter");
        return new Binding<>(updatableAdapter, lifecycleOwner2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Binding)) {
            return false;
        }
        Binding binding = (Binding) obj;
        return Intrinsics.areEqual((Object) this.itemsAdapter, (Object) binding.itemsAdapter) && Intrinsics.areEqual((Object) this.lifecycleOwner, (Object) binding.lifecycleOwner);
    }

    @NotNull
    public final UpdatableAdapter<I, UpdatableViewHolder<I>> getItemsAdapter() {
        return this.itemsAdapter;
    }

    @Nullable
    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public int hashCode() {
        int hashCode = this.itemsAdapter.hashCode() * 31;
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
        return hashCode + (lifecycleOwner2 == null ? 0 : lifecycleOwner2.hashCode());
    }

    @NotNull
    public String toString() {
        UpdatableAdapter<I, UpdatableViewHolder<I>> updatableAdapter = this.itemsAdapter;
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
        return "Binding(itemsAdapter=" + updatableAdapter + ", lifecycleOwner=" + lifecycleOwner2 + ")";
    }
}
