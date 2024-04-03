package com.talabat.verticals.helper.customMvvmView;

import androidx.lifecycle.LifecycleOwner;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&R\u0018\u0010\u0004\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomView;", "T", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "", "viewModel", "getViewModel", "()Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "setViewModel", "(Lcom/talabat/talabatcore/viewmodel/BaseViewModel;)V", "onLifecycleOwnerAttached", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MvvmCustomView<T extends BaseViewModel> {
    @NotNull
    T getViewModel();

    void onLifecycleOwnerAttached(@NotNull LifecycleOwner lifecycleOwner);

    void setViewModel(@NotNull T t11);
}
