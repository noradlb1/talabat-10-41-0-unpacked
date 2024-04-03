package com.talabat.userandlocation.compliance.status.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheetKt;
import com.talabat.userandlocation.compliance.status.domain.usecase.business.CheckUserIsAllowedToOrderUseCase;
import com.talabat.userandlocation.compliance.status.presentation.displaymodel.DismissScreenModel;
import com.talabat.userandlocation.compliance.status.presentation.displaymodel.UserVerificationDisplayModel;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.TrackContinueToCheckoutUseCase;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.TrackUserBlockedUseCase;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002&'B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0017J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/talabat/userandlocation/compliance/status/presentation/viewmodel/CheckUserAllowedToOrderViewModel;", "Landroidx/lifecycle/ViewModel;", "isAllowedToOrderUseCase", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase;", "trackContinueToCheckoutUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackContinueToCheckoutUseCase;", "trackUserBlockedUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackUserBlockedUseCase;", "(Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase;Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackContinueToCheckoutUseCase;Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackUserBlockedUseCase;)V", "dismissScreen", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/userandlocation/compliance/status/presentation/displaymodel/DismissScreenModel;", "getDismissScreen", "()Landroidx/lifecycle/MutableLiveData;", "requestUserInfoVerification", "Lcom/talabat/userandlocation/compliance/status/presentation/displaymodel/UserVerificationDisplayModel;", "getRequestUserInfoVerification", "showBlockedUserPopup", "", "getShowBlockedUserPopup", "showProgressDialog", "getShowProgressDialog", "handleUserStatus", "", "userAllowedToOrder", "Lcom/talabat/userandlocation/compliance/status/domain/usecase/business/CheckUserIsAllowedToOrderUseCase$Result;", "onBlockedUserPopupDismissed", "onBlockedUserPopupShown", "messageTitle", "", "onCreate", "Lkotlinx/coroutines/Job;", "parameters", "Lcom/talabat/userandlocation/compliance/status/presentation/viewmodel/CheckUserAllowedToOrderViewModel$Parameters;", "onUserInfoVerificationCancelled", "onUserInfoVerificationResult", "userInfoVerificationResult", "Lcom/talabat/userandlocation/compliance/status/presentation/viewmodel/CheckUserAllowedToOrderViewModel$UserInfoVerificationResult;", "Parameters", "UserInfoVerificationResult", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckUserAllowedToOrderViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<DismissScreenModel> dismissScreen = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final CheckUserIsAllowedToOrderUseCase isAllowedToOrderUseCase;
    @NotNull
    private final MutableLiveData<UserVerificationDisplayModel> requestUserInfoVerification = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Boolean> showBlockedUserPopup = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Boolean> showProgressDialog = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final TrackContinueToCheckoutUseCase trackContinueToCheckoutUseCase;
    @NotNull
    private final TrackUserBlockedUseCase trackUserBlockedUseCase;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/presentation/viewmodel/CheckUserAllowedToOrderViewModel$UserInfoVerificationResult;", "", "firstName", "", "lastName", "dateOfBirth", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDateOfBirth", "()Ljava/lang/String;", "getEmail", "getFirstName", "getLastName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UserInfoVerificationResult {
        @NotNull
        private final String dateOfBirth;
        @NotNull
        private final String email;
        @NotNull
        private final String firstName;
        @NotNull
        private final String lastName;

        public UserInfoVerificationResult(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "firstName");
            Intrinsics.checkNotNullParameter(str2, "lastName");
            Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
            Intrinsics.checkNotNullParameter(str4, "email");
            this.firstName = str;
            this.lastName = str2;
            this.dateOfBirth = str3;
            this.email = str4;
        }

        public static /* synthetic */ UserInfoVerificationResult copy$default(UserInfoVerificationResult userInfoVerificationResult, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = userInfoVerificationResult.firstName;
            }
            if ((i11 & 2) != 0) {
                str2 = userInfoVerificationResult.lastName;
            }
            if ((i11 & 4) != 0) {
                str3 = userInfoVerificationResult.dateOfBirth;
            }
            if ((i11 & 8) != 0) {
                str4 = userInfoVerificationResult.email;
            }
            return userInfoVerificationResult.copy(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return this.firstName;
        }

        @NotNull
        public final String component2() {
            return this.lastName;
        }

        @NotNull
        public final String component3() {
            return this.dateOfBirth;
        }

        @NotNull
        public final String component4() {
            return this.email;
        }

        @NotNull
        public final UserInfoVerificationResult copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "firstName");
            Intrinsics.checkNotNullParameter(str2, "lastName");
            Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
            Intrinsics.checkNotNullParameter(str4, "email");
            return new UserInfoVerificationResult(str, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserInfoVerificationResult)) {
                return false;
            }
            UserInfoVerificationResult userInfoVerificationResult = (UserInfoVerificationResult) obj;
            return Intrinsics.areEqual((Object) this.firstName, (Object) userInfoVerificationResult.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) userInfoVerificationResult.lastName) && Intrinsics.areEqual((Object) this.dateOfBirth, (Object) userInfoVerificationResult.dateOfBirth) && Intrinsics.areEqual((Object) this.email, (Object) userInfoVerificationResult.email);
        }

        @NotNull
        public final String getDateOfBirth() {
            return this.dateOfBirth;
        }

        @NotNull
        public final String getEmail() {
            return this.email;
        }

        @NotNull
        public final String getFirstName() {
            return this.firstName;
        }

        @NotNull
        public final String getLastName() {
            return this.lastName;
        }

        public int hashCode() {
            return (((((this.firstName.hashCode() * 31) + this.lastName.hashCode()) * 31) + this.dateOfBirth.hashCode()) * 31) + this.email.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.firstName;
            String str2 = this.lastName;
            String str3 = this.dateOfBirth;
            String str4 = this.email;
            return "UserInfoVerificationResult(firstName=" + str + ", lastName=" + str2 + ", dateOfBirth=" + str3 + ", email=" + str4 + ")";
        }
    }

    public CheckUserAllowedToOrderViewModel(@NotNull CheckUserIsAllowedToOrderUseCase checkUserIsAllowedToOrderUseCase, @NotNull TrackContinueToCheckoutUseCase trackContinueToCheckoutUseCase2, @NotNull TrackUserBlockedUseCase trackUserBlockedUseCase2) {
        Intrinsics.checkNotNullParameter(checkUserIsAllowedToOrderUseCase, "isAllowedToOrderUseCase");
        Intrinsics.checkNotNullParameter(trackContinueToCheckoutUseCase2, "trackContinueToCheckoutUseCase");
        Intrinsics.checkNotNullParameter(trackUserBlockedUseCase2, "trackUserBlockedUseCase");
        this.isAllowedToOrderUseCase = checkUserIsAllowedToOrderUseCase;
        this.trackContinueToCheckoutUseCase = trackContinueToCheckoutUseCase2;
        this.trackUserBlockedUseCase = trackUserBlockedUseCase2;
    }

    /* access modifiers changed from: private */
    public final void handleUserStatus(CheckUserIsAllowedToOrderUseCase.Result result) {
        if (Intrinsics.areEqual((Object) result, (Object) CheckUserIsAllowedToOrderUseCase.Result.AllowedToOrder.INSTANCE)) {
            this.dismissScreen.postValue(DismissScreenModel.WithSuccessResult.INSTANCE);
        } else if (Intrinsics.areEqual((Object) result, (Object) CheckUserIsAllowedToOrderUseCase.Result.Blocked.INSTANCE)) {
            this.showBlockedUserPopup.postValue(Boolean.TRUE);
        } else if (result instanceof CheckUserIsAllowedToOrderUseCase.Result.ShouldVerifyUserInfo) {
            CheckUserIsAllowedToOrderUseCase.Result.ShouldVerifyUserInfo shouldVerifyUserInfo = (CheckUserIsAllowedToOrderUseCase.Result.ShouldVerifyUserInfo) result;
            this.requestUserInfoVerification.postValue(new UserVerificationDisplayModel(shouldVerifyUserInfo.getFirstName(), shouldVerifyUserInfo.getLastName(), shouldVerifyUserInfo.getDateOfBirth(), shouldVerifyUserInfo.getEmail(), shouldVerifyUserInfo.getMobileNumber()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final MutableLiveData<DismissScreenModel> getDismissScreen() {
        return this.dismissScreen;
    }

    @NotNull
    public final MutableLiveData<UserVerificationDisplayModel> getRequestUserInfoVerification() {
        return this.requestUserInfoVerification;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowBlockedUserPopup() {
        return this.showBlockedUserPopup;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowProgressDialog() {
        return this.showProgressDialog;
    }

    public final void onBlockedUserPopupDismissed() {
        this.dismissScreen.postValue(DismissScreenModel.WithCancelResult.INSTANCE);
    }

    public final void onBlockedUserPopupShown(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, PaymentWidgetBottomSheetKt.MESSAGE_TITLE);
        this.trackUserBlockedUseCase.trackUserBlocked(str);
    }

    @NotNull
    public final Job onCreate(@NotNull Parameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CheckUserAllowedToOrderViewModel$onCreate$1(this, parameters, (Continuation<? super CheckUserAllowedToOrderViewModel$onCreate$1>) null), 3, (Object) null);
    }

    public final void onUserInfoVerificationCancelled() {
        this.dismissScreen.postValue(DismissScreenModel.WithCancelResult.INSTANCE);
    }

    @NotNull
    public final Job onUserInfoVerificationResult(@NotNull UserInfoVerificationResult userInfoVerificationResult) {
        Intrinsics.checkNotNullParameter(userInfoVerificationResult, "userInfoVerificationResult");
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CheckUserAllowedToOrderViewModel$onUserInfoVerificationResult$1(this, userInfoVerificationResult, (Continuation<? super CheckUserAllowedToOrderViewModel$onUserInfoVerificationResult$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/presentation/viewmodel/CheckUserAllowedToOrderViewModel$Parameters;", "", "firstName", "", "lastName", "dateOfBirth", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDateOfBirth", "()Ljava/lang/String;", "getFirstName", "getLastName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Parameters {
        @NotNull
        private final String dateOfBirth;
        @NotNull
        private final String firstName;
        @NotNull
        private final String lastName;

        public Parameters() {
            this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public Parameters(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "firstName");
            Intrinsics.checkNotNullParameter(str2, "lastName");
            Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
            this.firstName = str;
            this.lastName = str2;
            this.dateOfBirth = str3;
        }

        public static /* synthetic */ Parameters copy$default(Parameters parameters, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = parameters.firstName;
            }
            if ((i11 & 2) != 0) {
                str2 = parameters.lastName;
            }
            if ((i11 & 4) != 0) {
                str3 = parameters.dateOfBirth;
            }
            return parameters.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.firstName;
        }

        @NotNull
        public final String component2() {
            return this.lastName;
        }

        @NotNull
        public final String component3() {
            return this.dateOfBirth;
        }

        @NotNull
        public final Parameters copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "firstName");
            Intrinsics.checkNotNullParameter(str2, "lastName");
            Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
            return new Parameters(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Parameters)) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return Intrinsics.areEqual((Object) this.firstName, (Object) parameters.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) parameters.lastName) && Intrinsics.areEqual((Object) this.dateOfBirth, (Object) parameters.dateOfBirth);
        }

        @NotNull
        public final String getDateOfBirth() {
            return this.dateOfBirth;
        }

        @NotNull
        public final String getFirstName() {
            return this.firstName;
        }

        @NotNull
        public final String getLastName() {
            return this.lastName;
        }

        public int hashCode() {
            return (((this.firstName.hashCode() * 31) + this.lastName.hashCode()) * 31) + this.dateOfBirth.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.firstName;
            String str2 = this.lastName;
            String str3 = this.dateOfBirth;
            return "Parameters(firstName=" + str + ", lastName=" + str2 + ", dateOfBirth=" + str3 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Parameters(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3);
        }
    }
}
