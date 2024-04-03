package com.talabat.talabatlife.ui.vendorList.viewModel;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatlife.domain.entity.Cuisine;
import com.talabat.talabatlife.domain.entity.Filter;
import com.talabat.talabatlife.domain.usecases.GetFiltersUseCase;
import com.talabat.talabatlife.features.vendors.GetVendorsAreas;
import com.talabat.talabatlife.features.vendors.GetVendorsList;
import com.talabat.talabatlife.features.vendors.vendorAreas.VendorAreasRequestModel;
import com.talabat.talabatlife.features.vendors.vendorList.models.request.VendorListRequestModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorAreasDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorListDisplayModel;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016JX\u0010\u0002\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u001b2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0019H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\fH\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'H\u0002J(\u0010(\u001a\u00020\u00172\u001e\u0010)\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0+0*H\u0002R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006."}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/viewModel/VendorsListViewModelImpl;", "Lcom/talabat/talabatlife/ui/vendorList/viewModel/VendorsListViewModel;", "getVendorsList", "Lcom/talabat/talabatlife/features/vendors/GetVendorsList;", "getVendorsAreas", "Lcom/talabat/talabatlife/features/vendors/GetVendorsAreas;", "getFiltersUseCase", "Lcom/talabat/talabatlife/domain/usecases/GetFiltersUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/talabatlife/features/vendors/GetVendorsList;Lcom/talabat/talabatlife/features/vendors/GetVendorsAreas;Lcom/talabat/talabatlife/domain/usecases/GetFiltersUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "defaultResult", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;", "getDefaultResult", "()Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;", "setDefaultResult", "(Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;)V", "isFirstLoading", "", "()Z", "setFirstLoading", "(Z)V", "getVendorsAreasList", "", "countryCode", "", "lat", "", "long", "pageNumber", "pageSize", "searchString", "areaID", "offerFilterId", "cuisineId", "handleVendorListDisplayModel", "model", "handleVendorsAreasDisplayModel", "displayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorAreasDisplayModel;", "logData", "pair", "Lkotlin/Pair;", "", "Lcom/talabat/talabatlife/domain/entity/Cuisine;", "Lcom/talabat/talabatlife/domain/entity/Filter;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListViewModelImpl extends VendorsListViewModel {
    @NotNull
    private VendorListDisplayModel defaultResult = new VendorListDisplayModel();
    @NotNull
    private final GetVendorsAreas getVendorsAreas;
    @NotNull
    private final GetVendorsList getVendorsList;
    private boolean isFirstLoading = true;

    public VendorsListViewModelImpl(@NotNull GetVendorsList getVendorsList2, @NotNull GetVendorsAreas getVendorsAreas2, @NotNull GetFiltersUseCase getFiltersUseCase, @NotNull ConfigurationLocalRepository configurationLocalRepository) {
        Intrinsics.checkNotNullParameter(getVendorsList2, "getVendorsList");
        Intrinsics.checkNotNullParameter(getVendorsAreas2, "getVendorsAreas");
        Intrinsics.checkNotNullParameter(getFiltersUseCase, "getFiltersUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        this.getVendorsList = getVendorsList2;
        this.getVendorsAreas = getVendorsAreas2;
        getFiltersUseCase.invoke(new GetFiltersUseCase.Params(configurationLocalRepository.selectedCountry().getCountryId()), new Function1<Either<? extends Failure, ? extends Pair<? extends List<? extends Cuisine>, ? extends List<? extends Filter>>>, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ VendorsListViewModelImpl f12096g;

            {
                this.f12096g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Either<? extends Failure, ? extends Pair<? extends List<Cuisine>, ? extends List<Filter>>>) (Either) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Either<? extends Failure, ? extends Pair<? extends List<Cuisine>, ? extends List<Filter>>> either) {
                Intrinsics.checkNotNullParameter(either, "it");
                either.either(new Function1<Failure, Unit>(this.f12096g) {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Failure) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Failure failure) {
                        Intrinsics.checkNotNullParameter(failure, "p0");
                        ((VendorsListViewModelImpl) this.receiver).handleFailure(failure);
                    }
                }, new Function1<Pair<? extends List<? extends Cuisine>, ? extends List<? extends Filter>>, Unit>(this.f12096g) {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Pair<? extends List<Cuisine>, ? extends List<Filter>>) (Pair) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Pair<? extends List<Cuisine>, ? extends List<Filter>> pair) {
                        Intrinsics.checkNotNullParameter(pair, "p0");
                        ((VendorsListViewModelImpl) this.receiver).logData(pair);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public final void handleVendorListDisplayModel(VendorListDisplayModel vendorListDisplayModel) {
        if (isFirstLoading()) {
            setDefaultResult(vendorListDisplayModel);
        }
        setFirstLoading(false);
        getVendorListData().setValue(vendorListDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleVendorsAreasDisplayModel(VendorAreasDisplayModel vendorAreasDisplayModel) {
        getVendorAreasListData().setValue(vendorAreasDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void logData(Pair<? extends List<Cuisine>, ? extends List<Filter>> pair) {
        if (!((Collection) pair.getSecond()).isEmpty()) {
            getFilterButtonLiveData().setValue(((List) pair.getSecond()).get(0));
        }
        if (!((Collection) pair.getFirst()).isEmpty()) {
            getCuisineButtonLiveData().setValue(pair.getFirst());
        }
        pair.getFirst().toString();
        pair.getSecond().toString();
    }

    @NotNull
    public VendorListDisplayModel getDefaultResult() {
        return this.defaultResult;
    }

    public void getVendorsAreasList(int i11, @Nullable String str, @Nullable String str2) {
        this.getVendorsAreas.invoke(new VendorAreasRequestModel(i11, str, str2), new VendorsListViewModelImpl$getVendorsAreasList$1(this));
    }

    public void getVendorsList(int i11, @Nullable String str, @Nullable String str2, int i12, int i13, @Nullable String str3, @Nullable String str4, int i14, int i15) {
        GetVendorsList getVendorsList2 = this.getVendorsList;
        VendorListRequestModel vendorListRequestModel = r2;
        VendorListRequestModel vendorListRequestModel2 = new VendorListRequestModel(i11, str, (String) null, str2, i12, i13, str3, str4, true, i14, i15, 4, (DefaultConstructorMarker) null);
        getVendorsList2.invoke(vendorListRequestModel, new VendorsListViewModelImpl$getVendorsList$1(this));
    }

    public boolean isFirstLoading() {
        return this.isFirstLoading;
    }

    public void setDefaultResult(@NotNull VendorListDisplayModel vendorListDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorListDisplayModel, "<set-?>");
        this.defaultResult = vendorListDisplayModel;
    }

    public void setFirstLoading(boolean z11) {
        this.isFirstLoading = z11;
    }
}
