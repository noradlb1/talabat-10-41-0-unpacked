package com.talabat.userandlocation.choosecountry.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.userandlocation.choosecountry.domain.UseCases;
import com.talabat.userandlocation.choosecountry.domain.entity.CountryVO;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase;
import com.talabat.userandlocation.choosecountry.presentation.Extras;
import com.talabat.userandlocation.choosecountry.presentation.StringProvider;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.ClearCartConfirmationDialogDisplayModel;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.CountryDisplayModel;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.DismissScreenDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u000e\u0010*\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0018\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020)H\u0002J\u000e\u0010.\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010/\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\b\u00100\u001a\u00020'H\u0002R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/presentation/viewmodel/ChooseCountryViewModel;", "Landroidx/lifecycle/ViewModel;", "useCases", "Lcom/talabat/userandlocation/choosecountry/domain/UseCases;", "stringProvider", "Lcom/talabat/userandlocation/choosecountry/presentation/StringProvider;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "displayModelMapper", "Lkotlin/Function1;", "Lcom/talabat/userandlocation/choosecountry/domain/entity/CountryVO;", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/CountryDisplayModel;", "(Lcom/talabat/userandlocation/choosecountry/domain/UseCases;Lcom/talabat/userandlocation/choosecountry/presentation/StringProvider;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;)V", "clearCartConfirmationDialogDisplayModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/ClearCartConfirmationDialogDisplayModel;", "getClearCartConfirmationDialogDisplayModel", "()Landroidx/lifecycle/MutableLiveData;", "countries", "", "getCountries", "dismissScreenDisplayModel", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/DismissScreenDisplayModel;", "getDismissScreenDisplayModel", "extras", "Lcom/talabat/userandlocation/choosecountry/presentation/Extras;", "screenTitle", "", "getScreenTitle", "showProgressDialog", "", "getShowProgressDialog", "toastMessage", "getToastMessage", "getCountriesList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBackClicked", "", "onClearCartWarningAcknowledged", "Lkotlinx/coroutines/Job;", "countryId", "", "onCountrySelected", "onSetSelectedCountryResult", "result", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result;", "onViewCreated", "showConfirmationDialog", "showCountries", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChooseCountryViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<ClearCartConfirmationDialogDisplayModel> clearCartConfirmationDialogDisplayModel;
    @NotNull
    private final MutableLiveData<List<CountryDisplayModel>> countries;
    @NotNull
    private final MutableLiveData<DismissScreenDisplayModel> dismissScreenDisplayModel;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<CountryVO, CountryDisplayModel> displayModelMapper;
    @NotNull
    private Extras extras;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineDispatcher ioDispatcher;
    @NotNull
    private final MutableLiveData<String> screenTitle;
    @NotNull
    private final MutableLiveData<Boolean> showProgressDialog;
    /* access modifiers changed from: private */
    @NotNull
    public final StringProvider stringProvider;
    @NotNull
    private final MutableLiveData<String> toastMessage;
    /* access modifiers changed from: private */
    @NotNull
    public final UseCases useCases;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SetUserSelectedCountryUseCase.Result.Error.Code.values().length];
            iArr[SetUserSelectedCountryUseCase.Result.Error.Code.NO_COUNTRY_FOUND.ordinal()] = 1;
            iArr[SetUserSelectedCountryUseCase.Result.Error.Code.API_ERROR.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChooseCountryViewModel(UseCases useCases2, StringProvider stringProvider2, CoroutineDispatcher coroutineDispatcher, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(useCases2, stringProvider2, (i11 & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher, (i11 & 8) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    /* access modifiers changed from: private */
    public final Object getCountriesList(Continuation<? super List<CountryDisplayModel>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new ChooseCountryViewModel$getCountriesList$2(this, (Continuation<? super ChooseCountryViewModel$getCountriesList$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final Job onClearCartWarningAcknowledged(int i11) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChooseCountryViewModel$onClearCartWarningAcknowledged$1(this, i11, (Continuation<? super ChooseCountryViewModel$onClearCartWarningAcknowledged$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void onSetSelectedCountryResult(SetUserSelectedCountryUseCase.Result result, int i11) {
        this.showProgressDialog.postValue(Boolean.FALSE);
        if (result instanceof SetUserSelectedCountryUseCase.Result.WarnBasketClear) {
            showConfirmationDialog(((SetUserSelectedCountryUseCase.Result.WarnBasketClear) result).getCountryId());
        } else if (Intrinsics.areEqual((Object) result, (Object) SetUserSelectedCountryUseCase.Result.Success.INSTANCE)) {
            if (this.extras.isInitialSelection()) {
                this.dismissScreenDisplayModel.postValue(new DismissScreenDisplayModel.ToHomeScreen(this.extras));
            } else {
                this.dismissScreenDisplayModel.postValue(new DismissScreenDisplayModel.WithResult(i11));
            }
        } else if (result instanceof SetUserSelectedCountryUseCase.Result.Error) {
            SetUserSelectedCountryUseCase.Result.Error error = (SetUserSelectedCountryUseCase.Result.Error) result;
            int i12 = WhenMappings.$EnumSwitchMapping$0[error.getCode().ordinal()];
            if (i12 == 1 || i12 == 2) {
                this.toastMessage.postValue(this.stringProvider.getGenericErrorMessage());
                LogManager.error$default((Throwable) null, error.getCode().name(), 1, (Object) null);
                return;
            }
            LogManager.info(error.getCode().name());
        }
    }

    private final Job showConfirmationDialog(int i11) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChooseCountryViewModel$showConfirmationDialog$1(this, i11, (Continuation<? super ChooseCountryViewModel$showConfirmationDialog$1>) null), 3, (Object) null);
    }

    private final Job showCountries() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChooseCountryViewModel$showCountries$1(this, (Continuation<? super ChooseCountryViewModel$showCountries$1>) null), 3, (Object) null);
    }

    @NotNull
    public final MutableLiveData<ClearCartConfirmationDialogDisplayModel> getClearCartConfirmationDialogDisplayModel() {
        return this.clearCartConfirmationDialogDisplayModel;
    }

    @NotNull
    public final MutableLiveData<List<CountryDisplayModel>> getCountries() {
        return this.countries;
    }

    @NotNull
    public final MutableLiveData<DismissScreenDisplayModel> getDismissScreenDisplayModel() {
        return this.dismissScreenDisplayModel;
    }

    @NotNull
    public final MutableLiveData<String> getScreenTitle() {
        return this.screenTitle;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowProgressDialog() {
        return this.showProgressDialog;
    }

    @NotNull
    public final MutableLiveData<String> getToastMessage() {
        return this.toastMessage;
    }

    public final void onBackClicked() {
        this.dismissScreenDisplayModel.postValue(DismissScreenDisplayModel.NoResult.INSTANCE);
    }

    @NotNull
    public final Job onCountrySelected(int i11) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChooseCountryViewModel$onCountrySelected$1(this, i11, (Continuation<? super ChooseCountryViewModel$onCountrySelected$1>) null), 3, (Object) null);
    }

    public final void onViewCreated(@NotNull Extras extras2) {
        Intrinsics.checkNotNullParameter(extras2, "extras");
        this.extras = extras2;
        showCountries();
    }

    public ChooseCountryViewModel(@NotNull UseCases useCases2, @NotNull StringProvider stringProvider2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function1<? super CountryVO, CountryDisplayModel> function1) {
        Intrinsics.checkNotNullParameter(useCases2, "useCases");
        Intrinsics.checkNotNullParameter(stringProvider2, "stringProvider");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(function1, "displayModelMapper");
        this.useCases = useCases2;
        this.stringProvider = stringProvider2;
        this.ioDispatcher = coroutineDispatcher;
        this.displayModelMapper = function1;
        this.countries = new MutableLiveData<>();
        this.screenTitle = new MutableLiveData<>(stringProvider2.getScreenTitle());
        this.dismissScreenDisplayModel = new MutableLiveData<>();
        this.clearCartConfirmationDialogDisplayModel = new MutableLiveData<>(ClearCartConfirmationDialogDisplayModel.DontShow.INSTANCE);
        this.showProgressDialog = new MutableLiveData<>(Boolean.FALSE);
        this.toastMessage = new MutableLiveData<>();
        this.extras = new Extras(false, false, false, false, false, 31, (DefaultConstructorMarker) null);
    }
}
