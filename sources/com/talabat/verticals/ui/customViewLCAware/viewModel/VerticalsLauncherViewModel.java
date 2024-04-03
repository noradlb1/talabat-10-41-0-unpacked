package com.talabat.verticals.ui.customViewLCAware.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import com.talabat.verticals.ui.customViewLCAware.model.VerticalsViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/viewModel/VerticalsLauncherViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "shimmerSLD", "Landroidx/lifecycle/MutableLiveData;", "", "getShimmerSLD", "()Landroidx/lifecycle/MutableLiveData;", "setShimmerSLD", "(Landroidx/lifecycle/MutableLiveData;)V", "success", "Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsViewState;", "getSuccess", "setSuccess", "getCountryName", "", "getVerticalsForLocation", "", "LauncherType", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class VerticalsLauncherViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<Boolean> shimmerSLD = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<VerticalsViewState> success = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/viewModel/VerticalsLauncherViewModel$LauncherType;", "", "(Ljava/lang/String;I)V", "BUTTON", "TWO_VERTICALS", "THREE_VERTICALS", "MORE", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum LauncherType {
        BUTTON,
        TWO_VERTICALS,
        THREE_VERTICALS,
        MORE
    }

    @NotNull
    public abstract String getCountryName();

    @NotNull
    public final MutableLiveData<Boolean> getShimmerSLD() {
        return this.shimmerSLD;
    }

    @NotNull
    public final MutableLiveData<VerticalsViewState> getSuccess() {
        return this.success;
    }

    public abstract void getVerticalsForLocation();

    public final void setShimmerSLD(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.shimmerSLD = mutableLiveData;
    }

    public final void setSuccess(@NotNull MutableLiveData<VerticalsViewState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.success = mutableLiveData;
    }
}
