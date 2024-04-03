package com.talabat.talabatcore.viewmodel;

import androidx.lifecycle.ViewModel;
import com.talabat.talabatcore.exception.Failure;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcore/viewmodel/IBaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "handleFailure", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class IBaseViewModel extends ViewModel {
    public abstract void handleFailure(@NotNull Failure failure);
}
