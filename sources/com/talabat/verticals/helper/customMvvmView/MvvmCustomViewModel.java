package com.talabat.verticals.helper.customMvvmView;

import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.verticals.helper.customMvvmView.MvvmCustomViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomViewModel;", "T", "Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomViewState;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "state", "getState", "()Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomViewState;", "setState", "(Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomViewState;)V", "Lcom/talabat/verticals/helper/customMvvmView/MvvmCustomViewState;", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class MvvmCustomViewModel<T extends MvvmCustomViewState> extends BaseViewModel {
    public T state;

    @NotNull
    public final T getState() {
        T t11 = this.state;
        if (t11 != null) {
            return t11;
        }
        Intrinsics.throwUninitializedPropertyAccessException("state");
        return null;
    }

    public final void setState(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "<set-?>");
        this.state = t11;
    }
}
