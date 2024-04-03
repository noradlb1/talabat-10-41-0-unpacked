package com.talabat.busypopup.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import datamodels.RestaurantListItemModel;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H&R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR'\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\n8FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0013\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/talabat/busypopup/viewModel/BusyPopupViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "mDisposables", "Lio/reactivex/disposables/CompositeDisposable;", "getMDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "setMDisposables", "(Lio/reactivex/disposables/CompositeDisposable;)V", "showNoResult", "Landroidx/lifecycle/MutableLiveData;", "", "getShowNoResult", "()Landroidx/lifecycle/MutableLiveData;", "showNoResult$delegate", "Lkotlin/Lazy;", "vendorList", "", "Ldatamodels/RestaurantListItemModel;", "getVendorList", "vendorList$delegate", "getRestaurantListWithCuisine", "", "cuisineIdToFilter", "", "verticalType", "resultCount", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BusyPopupViewModel extends BaseViewModel {
    @NotNull
    private CompositeDisposable mDisposables = new CompositeDisposable();
    @NotNull
    private final Lazy showNoResult$delegate;
    @NotNull
    private final Lazy vendorList$delegate;

    public BusyPopupViewModel() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.showNoResult$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, BusyPopupViewModel$showNoResult$2.INSTANCE);
        this.vendorList$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, BusyPopupViewModel$vendorList$2.INSTANCE);
    }

    @NotNull
    public final CompositeDisposable getMDisposables() {
        return this.mDisposables;
    }

    public abstract void getRestaurantListWithCuisine(int i11, int i12, int i13);

    @NotNull
    public final MutableLiveData<Boolean> getShowNoResult() {
        return (MutableLiveData) this.showNoResult$delegate.getValue();
    }

    @NotNull
    public final MutableLiveData<List<RestaurantListItemModel>> getVendorList() {
        return (MutableLiveData) this.vendorList$delegate.getValue();
    }

    public final void setMDisposables(@NotNull CompositeDisposable compositeDisposable) {
        Intrinsics.checkNotNullParameter(compositeDisposable, "<set-?>");
        this.mDisposables = compositeDisposable;
    }
}
