package com.talabat.verticals.ui.customViewLCAware.model;

import com.talabat.verticals.ui.customViewLCAware.viewModel.VerticalsLauncherViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsViewState;", "", "()V", "launcherType", "Lcom/talabat/verticals/ui/customViewLCAware/viewModel/VerticalsLauncherViewModel$LauncherType;", "getLauncherType", "()Lcom/talabat/verticals/ui/customViewLCAware/viewModel/VerticalsLauncherViewModel$LauncherType;", "setLauncherType", "(Lcom/talabat/verticals/ui/customViewLCAware/viewModel/VerticalsLauncherViewModel$LauncherType;)V", "verticalsDisplayModel", "Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsDisplayModel;", "getVerticalsDisplayModel", "()Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsDisplayModel;", "setVerticalsDisplayModel", "(Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsDisplayModel;)V", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsViewState {
    @NotNull
    private VerticalsLauncherViewModel.LauncherType launcherType = VerticalsLauncherViewModel.LauncherType.BUTTON;
    @Nullable
    private VerticalsDisplayModel verticalsDisplayModel;

    @NotNull
    public final VerticalsLauncherViewModel.LauncherType getLauncherType() {
        return this.launcherType;
    }

    @Nullable
    public final VerticalsDisplayModel getVerticalsDisplayModel() {
        return this.verticalsDisplayModel;
    }

    public final void setLauncherType(@NotNull VerticalsLauncherViewModel.LauncherType launcherType2) {
        Intrinsics.checkNotNullParameter(launcherType2, "<set-?>");
        this.launcherType = launcherType2;
    }

    public final void setVerticalsDisplayModel(@Nullable VerticalsDisplayModel verticalsDisplayModel2) {
        this.verticalsDisplayModel = verticalsDisplayModel2;
    }
}
