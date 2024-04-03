package com.talabat.verticals.ui.customViewLCAware.viewModel;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.verticals.features.GetVerticalsUseCase;
import com.talabat.verticals.features.dynamicLauncher.model.request.DynamicVerticalsRequestModel;
import com.talabat.verticals.ui.customViewLCAware.model.VerticalsDisplayModel;
import com.talabat.verticals.ui.customViewLCAware.model.VerticalsViewState;
import com.talabat.verticals.ui.customViewLCAware.viewModel.VerticalsLauncherViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/viewModel/VerticalsLauncherViewModelImpl;", "Lcom/talabat/verticals/ui/customViewLCAware/viewModel/VerticalsLauncherViewModel;", "getVerticalsUseCase", "Lcom/talabat/verticals/features/GetVerticalsUseCase;", "(Lcom/talabat/verticals/features/GetVerticalsUseCase;)V", "getCountryName", "", "getVerticalsForLocation", "", "getVerticalsRequestModel", "Lcom/talabat/verticals/features/dynamicLauncher/model/request/DynamicVerticalsRequestModel;", "handleSuccess", "result", "Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsDisplayModel;", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsLauncherViewModelImpl extends VerticalsLauncherViewModel {
    @NotNull
    private final GetVerticalsUseCase getVerticalsUseCase;

    public VerticalsLauncherViewModelImpl(@NotNull GetVerticalsUseCase getVerticalsUseCase2) {
        Intrinsics.checkNotNullParameter(getVerticalsUseCase2, "getVerticalsUseCase");
        this.getVerticalsUseCase = getVerticalsUseCase2;
    }

    private final DynamicVerticalsRequestModel getVerticalsRequestModel() {
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        return new DynamicVerticalsRequestModel(companion.selectedCountryCode(), String.valueOf(companion.selectedLocationLatitude()), String.valueOf(companion.selectedLocationLongitude()));
    }

    /* access modifiers changed from: private */
    public final void handleSuccess(VerticalsDisplayModel verticalsDisplayModel) {
        VerticalsViewState verticalsViewState = new VerticalsViewState();
        verticalsViewState.setVerticalsDisplayModel(verticalsDisplayModel);
        if (verticalsDisplayModel == null) {
            verticalsViewState.setLauncherType(VerticalsLauncherViewModel.LauncherType.BUTTON);
            getSuccess().setValue(verticalsViewState);
        }
        if (verticalsDisplayModel.getVerticals() == null) {
            verticalsViewState.setLauncherType(VerticalsLauncherViewModel.LauncherType.BUTTON);
            getSuccess().setValue(verticalsViewState);
        }
        if (verticalsDisplayModel.getVerticals() != null) {
            int size = verticalsDisplayModel.getVerticals().size();
            if (size == 0 || size == 1) {
                verticalsViewState.setLauncherType(VerticalsLauncherViewModel.LauncherType.BUTTON);
            } else if (size == 2) {
                verticalsViewState.setLauncherType(VerticalsLauncherViewModel.LauncherType.TWO_VERTICALS);
            } else if (size != 3) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < 3; i11++) {
                    arrayList.add(verticalsDisplayModel.getVerticals().get(i11));
                }
                VerticalsDisplayModel verticalsDisplayModel2 = new VerticalsDisplayModel();
                verticalsDisplayModel2.setVerticals(arrayList);
                verticalsViewState.setVerticalsDisplayModel(verticalsDisplayModel2);
                verticalsViewState.setLauncherType(VerticalsLauncherViewModel.LauncherType.THREE_VERTICALS);
            } else {
                verticalsViewState.setLauncherType(VerticalsLauncherViewModel.LauncherType.THREE_VERTICALS);
            }
            getSuccess().setValue(verticalsViewState);
        }
    }

    @NotNull
    public String getCountryName() {
        return IntegrationGlobalDataModel.Companion.selectedCountry();
    }

    public void getVerticalsForLocation() {
        getShimmerSLD().postValue(Boolean.TRUE);
        this.getVerticalsUseCase.invoke(getVerticalsRequestModel(), new VerticalsLauncherViewModelImpl$getVerticalsForLocation$1(this));
    }
}
