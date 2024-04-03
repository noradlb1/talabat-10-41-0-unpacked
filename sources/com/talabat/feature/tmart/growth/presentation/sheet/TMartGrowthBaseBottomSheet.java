package com.talabat.feature.tmart.growth.presentation.sheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH$¢\u0006\u0002\u0010\rJ&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/TMartGrowthBaseBottomSheet;", "Binding", "Landroidx/viewbinding/ViewBinding;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "bindingFactory", "inflater", "Landroid/view/LayoutInflater;", "(Landroid/view/LayoutInflater;)Landroidx/viewbinding/ViewBinding;", "onCreateView", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TMartGrowthBaseBottomSheet<Binding extends ViewBinding> extends BottomSheetDialogFragment {
    @Nullable
    private Binding _binding;

    @NotNull
    public abstract Binding bindingFactory(@NotNull LayoutInflater layoutInflater);

    @NotNull
    public final Binding getBinding() {
        Binding binding = this._binding;
        if (binding != null) {
            return binding;
        }
        throw new IllegalStateException("Cannot access binding outside of Fragment's View lifecycle");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Binding bindingFactory = bindingFactory(layoutInflater);
        this._binding = bindingFactory;
        if (bindingFactory != null) {
            return bindingFactory.getRoot();
        }
        return null;
    }

    public void onDestroyView() {
        this._binding = null;
        super.onDestroyView();
    }
}
