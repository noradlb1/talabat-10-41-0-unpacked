package com.talabat.userandlocation.compliance.verification.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.TrackComplianceVerificationScreenOpenedUseCase;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.UpdateUserProfileUseCase;
import com.talabat.userandlocation.compliance.verification.domain.usecase.business.VerifyUserDetailsForComplianceUseCase;
import com.talabat.userandlocation.compliance.verification.presentation.StringProvider;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.ButtonDisplayModel;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.CheckBoxDisplayModel;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.DismissScreenModel;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.EditFieldDisplayModel;
import com.talabat.userandlocation.compliance.verification.presentation.displaymodel.TitleDisplayModel;
import com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationExtras;
import com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationResult;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001TB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\u0006\u00106\u001a\u000203J\u000e\u00107\u001a\u0002082\u0006\u00104\u001a\u000205J\u000e\u00109\u001a\u0002032\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020<H\u0002J\u001a\u0010=\u001a\u0002032\b\u0010>\u001a\u0004\u0018\u0001002\u0006\u0010?\u001a\u00020+H\u0002J\u0012\u0010@\u001a\u0002032\b\u0010\u001e\u001a\u0004\u0018\u000100H\u0002J\u0016\u0010A\u001a\u0002032\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002J\u0016\u0010E\u001a\u0002032\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002J\u0016\u0010F\u001a\u0002032\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002J\u0016\u0010G\u001a\u0002032\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002J$\u0010H\u001a\u0002032\f\u0010I\u001a\b\u0012\u0004\u0012\u00020K0J2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002J\"\u0010L\u001a\u0002032\u0018\u0010M\u001a\u0014\u0012\u0004\u0012\u00020K\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C0NH\u0002J\u0010\u0010O\u001a\u0002082\u0006\u0010;\u001a\u00020<H\u0002J\u0019\u0010P\u001a\u0002082\u0006\u00104\u001a\u000205H@ø\u0001\u0000¢\u0006\u0002\u0010QJ\f\u0010R\u001a\u00020S*\u000205H\u0002R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000fR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000fR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000fR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000fR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000fR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000fR\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020&0\f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u0002000\f¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006U"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/viewmodel/UserVerificationViewModel;", "Landroidx/lifecycle/ViewModel;", "verifyUserDetailsForComplianceUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase;", "trackComplianceVerificationScreenOpenedUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackComplianceVerificationScreenOpenedUseCase;", "updateUserProfileUseCase", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase;", "stringProvider", "Lcom/talabat/userandlocation/compliance/verification/presentation/StringProvider;", "(Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase;Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/TrackComplianceVerificationScreenOpenedUseCase;Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/UpdateUserProfileUseCase;Lcom/talabat/userandlocation/compliance/verification/presentation/StringProvider;)V", "confirmationButton", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/ButtonDisplayModel;", "getConfirmationButton", "()Landroidx/lifecycle/MutableLiveData;", "dateOfBirth", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/EditFieldDisplayModel;", "getDateOfBirth", "dismissScreen", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/DismissScreenModel;", "getDismissScreen", "email", "getEmail", "extras", "Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationExtras;", "firstName", "getFirstName", "middleLastName", "getMiddleLastName", "mobileNumber", "getMobileNumber", "privacyTermsConsent", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/CheckBoxDisplayModel;", "getPrivacyTermsConsent", "promotionConsent", "getPromotionConsent", "screenTitle", "Lcom/talabat/userandlocation/compliance/verification/presentation/displaymodel/TitleDisplayModel;", "getScreenTitle", "secondaryTitle", "getSecondaryTitle", "showLoadingDialog", "", "getShowLoadingDialog", "title", "getTitle", "validationErrorDialogMessage", "", "getValidationErrorDialogMessage", "dismissScreenWithSuccess", "", "data", "Lcom/talabat/userandlocation/compliance/verification/presentation/viewmodel/UserVerificationViewModel$Data;", "onBackClicked", "onCreateAccountClicked", "Lkotlinx/coroutines/Job;", "onCreated", "renderScreenBasedOnMode", "mode", "Lcom/talabat/userandlocation/compliance/verification/ui/fragment/ComplianceUserVerificationExtras$Mode;", "setEmailField", "value", "isRegisteredWithMobileNumber", "setMobileField", "showDateOfBirthValidationError", "errors", "", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$ValidationError;", "showEmailValidationError", "showFirstNameValidationError", "showLastNameValidationError", "showPrivacyTermsConsentValidationError", "allErrorFields", "", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$Field;", "showValidationError", "invalidFields", "", "trackScreenOpenedEvent", "updateUserProfile", "(Lcom/talabat/userandlocation/compliance/verification/presentation/viewmodel/UserVerificationViewModel$Data;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toVerificationUseCaseArguments", "Lcom/talabat/userandlocation/compliance/verification/domain/usecase/business/VerifyUserDetailsForComplianceUseCase$Arguments;", "Data", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserVerificationViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<ButtonDisplayModel> confirmationButton = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<EditFieldDisplayModel> dateOfBirth = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<DismissScreenModel> dismissScreen = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<EditFieldDisplayModel> email = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public ComplianceUserVerificationExtras extras;
    @NotNull
    private final MutableLiveData<EditFieldDisplayModel> firstName = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<EditFieldDisplayModel> middleLastName = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<EditFieldDisplayModel> mobileNumber = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<CheckBoxDisplayModel> privacyTermsConsent = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<CheckBoxDisplayModel> promotionConsent = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<TitleDisplayModel> screenTitle = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<TitleDisplayModel> secondaryTitle = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Boolean> showLoadingDialog = new MutableLiveData<>();
    @NotNull
    private final StringProvider stringProvider;
    @NotNull
    private final MutableLiveData<TitleDisplayModel> title = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final TrackComplianceVerificationScreenOpenedUseCase trackComplianceVerificationScreenOpenedUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final UpdateUserProfileUseCase updateUserProfileUseCase;
    @NotNull
    private final MutableLiveData<String> validationErrorDialogMessage = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final VerifyUserDetailsForComplianceUseCase verifyUserDetailsForComplianceUseCase;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/presentation/viewmodel/UserVerificationViewModel$Data;", "", "firstName", "", "lastName", "dateOfBirth", "email", "isPrivacyTermsConsentChecked", "", "isPromotionNewsletterConsentChecked", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getDateOfBirth", "()Ljava/lang/String;", "getEmail", "getFirstName", "()Z", "getLastName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Data {
        @NotNull
        private final String dateOfBirth;
        @NotNull
        private final String email;
        @NotNull
        private final String firstName;
        private final boolean isPrivacyTermsConsentChecked;
        private final boolean isPromotionNewsletterConsentChecked;
        @NotNull
        private final String lastName;

        public Data(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z11, boolean z12) {
            Intrinsics.checkNotNullParameter(str, "firstName");
            Intrinsics.checkNotNullParameter(str2, "lastName");
            Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
            Intrinsics.checkNotNullParameter(str4, "email");
            this.firstName = str;
            this.lastName = str2;
            this.dateOfBirth = str3;
            this.email = str4;
            this.isPrivacyTermsConsentChecked = z11;
            this.isPromotionNewsletterConsentChecked = z12;
        }

        public static /* synthetic */ Data copy$default(Data data, String str, String str2, String str3, String str4, boolean z11, boolean z12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = data.firstName;
            }
            if ((i11 & 2) != 0) {
                str2 = data.lastName;
            }
            String str5 = str2;
            if ((i11 & 4) != 0) {
                str3 = data.dateOfBirth;
            }
            String str6 = str3;
            if ((i11 & 8) != 0) {
                str4 = data.email;
            }
            String str7 = str4;
            if ((i11 & 16) != 0) {
                z11 = data.isPrivacyTermsConsentChecked;
            }
            boolean z13 = z11;
            if ((i11 & 32) != 0) {
                z12 = data.isPromotionNewsletterConsentChecked;
            }
            return data.copy(str, str5, str6, str7, z13, z12);
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

        public final boolean component5() {
            return this.isPrivacyTermsConsentChecked;
        }

        public final boolean component6() {
            return this.isPromotionNewsletterConsentChecked;
        }

        @NotNull
        public final Data copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z11, boolean z12) {
            Intrinsics.checkNotNullParameter(str, "firstName");
            Intrinsics.checkNotNullParameter(str2, "lastName");
            Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
            Intrinsics.checkNotNullParameter(str4, "email");
            return new Data(str, str2, str3, str4, z11, z12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual((Object) this.firstName, (Object) data.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) data.lastName) && Intrinsics.areEqual((Object) this.dateOfBirth, (Object) data.dateOfBirth) && Intrinsics.areEqual((Object) this.email, (Object) data.email) && this.isPrivacyTermsConsentChecked == data.isPrivacyTermsConsentChecked && this.isPromotionNewsletterConsentChecked == data.isPromotionNewsletterConsentChecked;
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
            int hashCode = ((((((this.firstName.hashCode() * 31) + this.lastName.hashCode()) * 31) + this.dateOfBirth.hashCode()) * 31) + this.email.hashCode()) * 31;
            boolean z11 = this.isPrivacyTermsConsentChecked;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
            boolean z13 = this.isPromotionNewsletterConsentChecked;
            if (!z13) {
                z12 = z13;
            }
            return i11 + (z12 ? 1 : 0);
        }

        public final boolean isPrivacyTermsConsentChecked() {
            return this.isPrivacyTermsConsentChecked;
        }

        public final boolean isPromotionNewsletterConsentChecked() {
            return this.isPromotionNewsletterConsentChecked;
        }

        @NotNull
        public String toString() {
            String str = this.firstName;
            String str2 = this.lastName;
            String str3 = this.dateOfBirth;
            String str4 = this.email;
            boolean z11 = this.isPrivacyTermsConsentChecked;
            boolean z12 = this.isPromotionNewsletterConsentChecked;
            return "Data(firstName=" + str + ", lastName=" + str2 + ", dateOfBirth=" + str3 + ", email=" + str4 + ", isPrivacyTermsConsentChecked=" + z11 + ", isPromotionNewsletterConsentChecked=" + z12 + ")";
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ComplianceUserVerificationExtras.Mode.values().length];
            iArr[ComplianceUserVerificationExtras.Mode.EXISTING_USER.ordinal()] = 1;
            iArr[ComplianceUserVerificationExtras.Mode.NEW_USER.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[VerifyUserDetailsForComplianceUseCase.Field.values().length];
            iArr2[VerifyUserDetailsForComplianceUseCase.Field.FIRST_NAME.ordinal()] = 1;
            iArr2[VerifyUserDetailsForComplianceUseCase.Field.LAST_NAME.ordinal()] = 2;
            iArr2[VerifyUserDetailsForComplianceUseCase.Field.DATE_OF_BIRTH.ordinal()] = 3;
            iArr2[VerifyUserDetailsForComplianceUseCase.Field.EMAIL.ordinal()] = 4;
            iArr2[VerifyUserDetailsForComplianceUseCase.Field.PRIVACY_TERMS_CONSENT.ordinal()] = 5;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public UserVerificationViewModel(@NotNull VerifyUserDetailsForComplianceUseCase verifyUserDetailsForComplianceUseCase2, @NotNull TrackComplianceVerificationScreenOpenedUseCase trackComplianceVerificationScreenOpenedUseCase2, @NotNull UpdateUserProfileUseCase updateUserProfileUseCase2, @NotNull StringProvider stringProvider2) {
        Intrinsics.checkNotNullParameter(verifyUserDetailsForComplianceUseCase2, "verifyUserDetailsForComplianceUseCase");
        Intrinsics.checkNotNullParameter(trackComplianceVerificationScreenOpenedUseCase2, "trackComplianceVerificationScreenOpenedUseCase");
        Intrinsics.checkNotNullParameter(updateUserProfileUseCase2, "updateUserProfileUseCase");
        Intrinsics.checkNotNullParameter(stringProvider2, "stringProvider");
        this.verifyUserDetailsForComplianceUseCase = verifyUserDetailsForComplianceUseCase2;
        this.trackComplianceVerificationScreenOpenedUseCase = trackComplianceVerificationScreenOpenedUseCase2;
        this.updateUserProfileUseCase = updateUserProfileUseCase2;
        this.stringProvider = stringProvider2;
    }

    /* access modifiers changed from: private */
    public final void dismissScreenWithSuccess(Data data) {
        this.dismissScreen.postValue(new DismissScreenModel.WithSuccessResult(new ComplianceUserVerificationResult(data.getFirstName(), data.getLastName(), data.getDateOfBirth(), data.getEmail(), data.isPromotionNewsletterConsentChecked())));
    }

    private final void renderScreenBasedOnMode(ComplianceUserVerificationExtras.Mode mode) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i11 == 1) {
            this.screenTitle.postValue(TitleDisplayModel.DontShow.INSTANCE);
            this.title.postValue(new TitleDisplayModel.Show(this.stringProvider.getExistingUserTitle()));
            this.secondaryTitle.postValue(new TitleDisplayModel.Show(this.stringProvider.getExistingUserSecondaryTitle()));
            this.confirmationButton.postValue(new ButtonDisplayModel.Show(this.stringProvider.getContinueToCheckoutButtonText()));
            this.promotionConsent.postValue(CheckBoxDisplayModel.DontShow.INSTANCE);
        } else if (i11 == 2) {
            this.screenTitle.postValue(new TitleDisplayModel.Show(this.stringProvider.getScreenTitle()));
            this.title.postValue(new TitleDisplayModel.Show(this.stringProvider.getNewUserTitle()));
            this.secondaryTitle.postValue(TitleDisplayModel.DontShow.INSTANCE);
            this.confirmationButton.postValue(new ButtonDisplayModel.Show(this.stringProvider.getCreateAccountButtonText()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void setEmailField(String str, boolean z11) {
        boolean z12;
        if (!z11) {
            if (str == null || str.length() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                this.email.postValue(new EditFieldDisplayModel.Show(str, false));
                return;
            }
        }
        this.email.postValue(EditFieldDisplayModel.DontShow.INSTANCE);
    }

    private final void setMobileField(String str) {
        boolean z11;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.mobileNumber.postValue(EditFieldDisplayModel.DontShow.INSTANCE);
        } else {
            this.mobileNumber.postValue(new EditFieldDisplayModel.Show(str, false));
        }
    }

    private final void showDateOfBirthValidationError(List<? extends VerifyUserDetailsForComplianceUseCase.ValidationError> list) {
        if (list.contains(VerifyUserDetailsForComplianceUseCase.ValidationError.EMPTY)) {
            this.dateOfBirth.postValue(new EditFieldDisplayModel.MarkAsError(this.stringProvider.getRequiredErrorMessage()));
        }
    }

    private final void showEmailValidationError(List<? extends VerifyUserDetailsForComplianceUseCase.ValidationError> list) {
        if (list.contains(VerifyUserDetailsForComplianceUseCase.ValidationError.EMPTY)) {
            this.email.postValue(new EditFieldDisplayModel.MarkAsError(this.stringProvider.getRequiredErrorMessage()));
        } else if (CollectionsKt___CollectionsKt.firstOrNull(list) == VerifyUserDetailsForComplianceUseCase.ValidationError.EMAIL_PATTERN_ERROR) {
            this.email.postValue(new EditFieldDisplayModel.MarkAsError(this.stringProvider.getEmailErrorMessage()));
        }
    }

    private final void showFirstNameValidationError(List<? extends VerifyUserDetailsForComplianceUseCase.ValidationError> list) {
        if (list.contains(VerifyUserDetailsForComplianceUseCase.ValidationError.EMPTY)) {
            this.firstName.postValue(new EditFieldDisplayModel.MarkAsError(this.stringProvider.getRequiredErrorMessage()));
        } else if (CollectionsKt___CollectionsKt.firstOrNull(list) == VerifyUserDetailsForComplianceUseCase.ValidationError.NAME_LENGTH_EXCEEDED) {
            this.firstName.postValue(new EditFieldDisplayModel.MarkAsError(this.stringProvider.getNameErrorMessage()));
        }
    }

    private final void showLastNameValidationError(List<? extends VerifyUserDetailsForComplianceUseCase.ValidationError> list) {
        if (list.contains(VerifyUserDetailsForComplianceUseCase.ValidationError.EMPTY)) {
            this.middleLastName.postValue(new EditFieldDisplayModel.MarkAsError(this.stringProvider.getRequiredErrorMessage()));
        } else if (CollectionsKt___CollectionsKt.firstOrNull(list) == VerifyUserDetailsForComplianceUseCase.ValidationError.NAME_LENGTH_EXCEEDED) {
            this.middleLastName.postValue(new EditFieldDisplayModel.MarkAsError(this.stringProvider.getNameErrorMessage()));
        }
    }

    private final void showPrivacyTermsConsentValidationError(Set<? extends VerifyUserDetailsForComplianceUseCase.Field> set, List<? extends VerifyUserDetailsForComplianceUseCase.ValidationError> list) {
        boolean z11 = true;
        if (set.size() != 1) {
            z11 = false;
        }
        if (z11 && list.contains(VerifyUserDetailsForComplianceUseCase.ValidationError.PRIVACY_TERMS_NOT_AGREED)) {
            this.privacyTermsConsent.postValue(CheckBoxDisplayModel.MarkAsError.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void showValidationError(Map<VerifyUserDetailsForComplianceUseCase.Field, ? extends List<? extends VerifyUserDetailsForComplianceUseCase.ValidationError>> map) {
        for (Map.Entry next : map.entrySet()) {
            int i11 = WhenMappings.$EnumSwitchMapping$1[((VerifyUserDetailsForComplianceUseCase.Field) next.getKey()).ordinal()];
            if (i11 == 1) {
                showFirstNameValidationError((List) next.getValue());
            } else if (i11 == 2) {
                showLastNameValidationError((List) next.getValue());
            } else if (i11 == 3) {
                showDateOfBirthValidationError((List) next.getValue());
            } else if (i11 == 4) {
                showEmailValidationError((List) next.getValue());
            } else if (i11 == 5) {
                showPrivacyTermsConsentValidationError(map.keySet(), (List) next.getValue());
            }
        }
    }

    /* access modifiers changed from: private */
    public final VerifyUserDetailsForComplianceUseCase.Arguments toVerificationUseCaseArguments(Data data) {
        return new VerifyUserDetailsForComplianceUseCase.Arguments(data.getFirstName(), data.getLastName(), data.getDateOfBirth(), data.getEmail(), data.isPrivacyTermsConsentChecked());
    }

    private final Job trackScreenOpenedEvent(ComplianceUserVerificationExtras.Mode mode) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserVerificationViewModel$trackScreenOpenedEvent$1(this, mode, (Continuation<? super UserVerificationViewModel$trackScreenOpenedEvent$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object updateUserProfile(Data data, Continuation<? super Job> continuation) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserVerificationViewModel$updateUserProfile$2(this, data, (Continuation<? super UserVerificationViewModel$updateUserProfile$2>) null), 3, (Object) null);
    }

    @NotNull
    public final MutableLiveData<ButtonDisplayModel> getConfirmationButton() {
        return this.confirmationButton;
    }

    @NotNull
    public final MutableLiveData<EditFieldDisplayModel> getDateOfBirth() {
        return this.dateOfBirth;
    }

    @NotNull
    public final MutableLiveData<DismissScreenModel> getDismissScreen() {
        return this.dismissScreen;
    }

    @NotNull
    public final MutableLiveData<EditFieldDisplayModel> getEmail() {
        return this.email;
    }

    @NotNull
    public final MutableLiveData<EditFieldDisplayModel> getFirstName() {
        return this.firstName;
    }

    @NotNull
    public final MutableLiveData<EditFieldDisplayModel> getMiddleLastName() {
        return this.middleLastName;
    }

    @NotNull
    public final MutableLiveData<EditFieldDisplayModel> getMobileNumber() {
        return this.mobileNumber;
    }

    @NotNull
    public final MutableLiveData<CheckBoxDisplayModel> getPrivacyTermsConsent() {
        return this.privacyTermsConsent;
    }

    @NotNull
    public final MutableLiveData<CheckBoxDisplayModel> getPromotionConsent() {
        return this.promotionConsent;
    }

    @NotNull
    public final MutableLiveData<TitleDisplayModel> getScreenTitle() {
        return this.screenTitle;
    }

    @NotNull
    public final MutableLiveData<TitleDisplayModel> getSecondaryTitle() {
        return this.secondaryTitle;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoadingDialog() {
        return this.showLoadingDialog;
    }

    @NotNull
    public final MutableLiveData<TitleDisplayModel> getTitle() {
        return this.title;
    }

    @NotNull
    public final MutableLiveData<String> getValidationErrorDialogMessage() {
        return this.validationErrorDialogMessage;
    }

    public final void onBackClicked() {
        MutableLiveData<DismissScreenModel> mutableLiveData = this.dismissScreen;
        ComplianceUserVerificationExtras complianceUserVerificationExtras = this.extras;
        if (complianceUserVerificationExtras == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extras");
            complianceUserVerificationExtras = null;
        }
        mutableLiveData.postValue(new DismissScreenModel.WithCancelResult(complianceUserVerificationExtras));
    }

    @NotNull
    public final Job onCreateAccountClicked(@NotNull Data data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserVerificationViewModel$onCreateAccountClicked$1(this, data, (Continuation<? super UserVerificationViewModel$onCreateAccountClicked$1>) null), 3, (Object) null);
    }

    public final void onCreated(@NotNull ComplianceUserVerificationExtras complianceUserVerificationExtras) {
        boolean z11;
        Intrinsics.checkNotNullParameter(complianceUserVerificationExtras, "extras");
        this.extras = complianceUserVerificationExtras;
        String component1 = complianceUserVerificationExtras.component1();
        String component2 = complianceUserVerificationExtras.component2();
        String component3 = complianceUserVerificationExtras.component3();
        String component4 = complianceUserVerificationExtras.component4();
        String component5 = complianceUserVerificationExtras.component5();
        ComplianceUserVerificationExtras.Mode component6 = complianceUserVerificationExtras.component6();
        MutableLiveData<EditFieldDisplayModel> mutableLiveData = this.firstName;
        if (component1 == null) {
            component1 = "";
        }
        mutableLiveData.postValue(new EditFieldDisplayModel.Show(component1, true));
        MutableLiveData<EditFieldDisplayModel> mutableLiveData2 = this.middleLastName;
        if (component2 == null) {
            component2 = "";
        }
        mutableLiveData2.postValue(new EditFieldDisplayModel.Show(component2, true));
        MutableLiveData<EditFieldDisplayModel> mutableLiveData3 = this.dateOfBirth;
        if (component3 == null) {
            component3 = "";
        }
        mutableLiveData3.postValue(new EditFieldDisplayModel.Show(component3, true));
        if (component5 == null || component5.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        setEmailField(component4, !z11);
        setMobileField(component5);
        renderScreenBasedOnMode(component6);
        trackScreenOpenedEvent(component6);
    }
}
