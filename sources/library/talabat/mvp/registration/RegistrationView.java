package library.talabat.mvp.registration;

import android.content.Context;
import com.talabat.helpers.Talabat;

public interface RegistrationView extends Talabat {
    public static final int REG_CONFIRM_PASSWORD = 6;
    public static final int REG_DATE_OF_BIRTH = 8;
    public static final int REG_EMAIL = 1;
    public static final int REG_ERROR_PASSWORD_NOT_MATCHING = 100;
    public static final int REG_ERROR_WRONG_EMAIL_PATTERN = 101;
    public static final int REG_ERROR_WRONG_PASSWORD_FORMAT = 102;
    public static final int REG_FIRST_NAME = 2;
    public static final int REG_LAST_NAME = 3;
    public static final int REG_MOBILE_NUMBER_EMPTY = 104;
    public static final int REG_NAME_LENGTH_25 = 103;
    public static final int REG_PASSWORD = 5;
    public static final int REG_PASSWORD_MIN_CHARACTER_REQUIREMENT_FAILED = 102;
    public static final int REG_PASSWORD_VALIDATION_FAILED = 105;
    public static final int REG_PHONE = 7;
    public static final int REG_REGION = 4;

    void changeTitleToCreateYourAccount();

    void disableGetOtpLinkFor(int i11);

    void disableSubmitButton();

    void enableSubmitButton();

    int getAreaId();

    boolean getConsentCheckAvailable();

    boolean getConsentChecked();

    Context getContext();

    String getDateOfBirth();

    String getEmail();

    String getFirstName();

    boolean getGender();

    String getLastName();

    String getMobileNumber();

    boolean getNewsLetter();

    String getOtp();

    String getPassWord();

    boolean getSms();

    void hideEmailField();

    void onConsentValidationError();

    void onLocalValidationSuccess();

    void onRegisterFailedWithAccessDeniedMessage();

    void onRegistrationCompleted();

    void onRegistrationFailed(String str, String str2, String str3);

    void onValidationError(int i11);

    void setEmail(String str);

    void showAccountAlreadyExistForMobileNumber(String str);

    void showAlertDialog(String str);

    void showComplianceCannotCreateAccountDialog();

    void showConsentSubtitle();

    void showCouldNotValidateDetailsDialog(String str);

    void showDateOfBirthField();

    void showMobileNumberField(int i11, boolean z11);

    void showNormalTermsAndCondition();

    void showOTPField();

    void showRegistrationConsentCheck();

    void showRegistrationConsentCheckWithChangedText();

    void showSuccessOtpRequestDialog();
}
