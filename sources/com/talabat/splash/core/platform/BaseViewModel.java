package com.talabat.splash.core.platform;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.splash.core.exception.Failure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004R(\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/talabat/splash/core/platform/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/talabat/splash/core/exception/Failure;", "failure", "", "a", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "getFailure", "()Landroidx/lifecycle/MutableLiveData;", "setFailure", "(Landroidx/lifecycle/MutableLiveData;)V", "<init>", "()V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0})
public abstract class BaseViewModel extends ViewModel {
    @NotNull
    private MutableLiveData<Failure> failure = new MutableLiveData<>();

    public final void a(@NotNull Failure failure2) {
        Intrinsics.checkNotNullParameter(failure2, "failure");
        this.failure.postValue(failure2);
    }

    @NotNull
    public final MutableLiveData<Failure> getFailure() {
        return this.failure;
    }

    public final void setFailure(@NotNull MutableLiveData<Failure> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.failure = mutableLiveData;
    }
}
