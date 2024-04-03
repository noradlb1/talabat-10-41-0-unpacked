package com.talabat.talabatcore.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcore.exception.Failure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "Lcom/talabat/talabatcore/viewmodel/IBaseViewModel;", "()V", "failureData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatcore/exception/Failure;", "getFailureData", "()Landroidx/lifecycle/MutableLiveData;", "setFailureData", "(Landroidx/lifecycle/MutableLiveData;)V", "handleFailure", "", "failure", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseViewModel extends IBaseViewModel {
    @NotNull
    private MutableLiveData<Failure> failureData = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<Failure> getFailureData() {
        return this.failureData;
    }

    public void handleFailure(@NotNull Failure failure) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        this.failureData.setValue(failure);
    }

    public final void setFailureData(@NotNull MutableLiveData<Failure> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.failureData = mutableLiveData;
    }
}
