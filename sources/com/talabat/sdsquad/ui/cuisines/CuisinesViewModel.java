package com.talabat.sdsquad.ui.cuisines;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.sdsquad.core.BaseSchedulerProvider;
import com.talabat.sdsquad.core.UseCaseHandler;
import com.talabat.sdsquad.domain.cuisines.GetCuisinesUseCase;
import com.talabat.sdsquad.ui.cuisines.displaymodels.CuisineDisplayModel;
import com.talabat.talabatcore.logger.LogManager;
import fu.d;
import fu.e;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\fR'\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/sdsquad/ui/cuisines/CuisinesViewModel;", "Landroidx/lifecycle/ViewModel;", "mSchedulerProvider", "Lcom/talabat/sdsquad/core/BaseSchedulerProvider;", "mUseCaseHandler", "Lcom/talabat/sdsquad/core/UseCaseHandler;", "mGetCuisinesUseCase", "Lcom/talabat/sdsquad/domain/cuisines/GetCuisinesUseCase;", "(Lcom/talabat/sdsquad/core/BaseSchedulerProvider;Lcom/talabat/sdsquad/core/UseCaseHandler;Lcom/talabat/sdsquad/domain/cuisines/GetCuisinesUseCase;)V", "cuisinesResponse", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/talabat/sdsquad/ui/cuisines/displaymodels/CuisineDisplayModel;", "getCuisinesResponse", "()Landroidx/lifecycle/MutableLiveData;", "cuisinesResponse$delegate", "Lkotlin/Lazy;", "getCuisineList", "", "selectedCuisineId", "", "getSelectedCuisineId", "setSelectedCuisine", "cuisineModel", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesViewModel extends ViewModel {
    @NotNull
    private final Lazy cuisinesResponse$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, CuisinesViewModel$cuisinesResponse$2.INSTANCE);
    @NotNull
    private final GetCuisinesUseCase mGetCuisinesUseCase;
    @NotNull
    private final BaseSchedulerProvider mSchedulerProvider;
    @NotNull
    private final UseCaseHandler mUseCaseHandler;

    public CuisinesViewModel(@NotNull BaseSchedulerProvider baseSchedulerProvider, @NotNull UseCaseHandler useCaseHandler, @NotNull GetCuisinesUseCase getCuisinesUseCase) {
        Intrinsics.checkNotNullParameter(baseSchedulerProvider, "mSchedulerProvider");
        Intrinsics.checkNotNullParameter(useCaseHandler, "mUseCaseHandler");
        Intrinsics.checkNotNullParameter(getCuisinesUseCase, "mGetCuisinesUseCase");
        this.mSchedulerProvider = baseSchedulerProvider;
        this.mUseCaseHandler = useCaseHandler;
        this.mGetCuisinesUseCase = getCuisinesUseCase;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCuisineList$lambda-0  reason: not valid java name */
    public static final void m10815getCuisineList$lambda0(CuisinesViewModel cuisinesViewModel, List list) {
        Intrinsics.checkNotNullParameter(cuisinesViewModel, "this$0");
        cuisinesViewModel.getCuisinesResponse().setValue(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: getCuisineList$lambda-1  reason: not valid java name */
    public static final void m10816getCuisineList$lambda1(Throwable th2) {
        String message = th2.getMessage();
        LogManager.logException(new Exception("grocery: " + message));
    }

    public final void getCuisineList(int i11) {
        ((Flowable) this.mUseCaseHandler.execute(this.mGetCuisinesUseCase, new GetCuisinesUseCase.RequestValues(i11))).subscribeOn(this.mSchedulerProvider.io()).observeOn(this.mSchedulerProvider.ui()).subscribe(new d(this), new e());
    }

    @NotNull
    public final MutableLiveData<List<CuisineDisplayModel>> getCuisinesResponse() {
        return (MutableLiveData) this.cuisinesResponse$delegate.getValue();
    }

    public final int getSelectedCuisineId() {
        List value = getCuisinesResponse().getValue();
        if (value == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : value) {
            if (((CuisineDisplayModel) next).isOn()) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            return ((CuisineDisplayModel) arrayList.get(0)).getId();
        }
        return 0;
    }

    public final void setSelectedCuisine(@NotNull CuisineDisplayModel cuisineDisplayModel) {
        Intrinsics.checkNotNullParameter(cuisineDisplayModel, "cuisineModel");
        List value = getCuisinesResponse().getValue();
        if (value != null) {
            Iterable iterable = value;
            ArrayList<CuisineDisplayModel> arrayList = new ArrayList<>();
            for (Object next : iterable) {
                if (((CuisineDisplayModel) next).isOn()) {
                    arrayList.add(next);
                }
            }
            for (CuisineDisplayModel on2 : arrayList) {
                on2.setOn(false);
            }
            ArrayList<CuisineDisplayModel> arrayList2 = new ArrayList<>();
            for (Object next2 : iterable) {
                if (Intrinsics.areEqual((Object) (CuisineDisplayModel) next2, (Object) cuisineDisplayModel)) {
                    arrayList2.add(next2);
                }
            }
            for (CuisineDisplayModel on3 : arrayList2) {
                on3.setOn(true);
            }
            getCuisinesResponse().setValue(value);
        }
    }
}
