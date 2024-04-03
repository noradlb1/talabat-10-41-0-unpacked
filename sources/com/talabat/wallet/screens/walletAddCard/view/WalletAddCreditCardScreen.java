package com.talabat.wallet.screens.walletAddCard.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.exoplayer2.ExoPlayer;
import com.talabat.R;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.wallet.DaggerWalletAddCreditCardScreenComponent;
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardType;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.helpers.CreditCardHelperInterface;
import com.talabat.wallet.helpers.ResponseStatus;
import com.talabat.wallet.helpers.ResponseStatusInterface;
import com.talabat.wallet.screens.walletAddCard.presenter.WalletAddCreditCardPresenter;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen;
import com.talabat.wallet.screens.walletTopupCardList.view.WalletTopupCardListScreen;
import datamodels.WalletCreditCard;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wx.a;
import wx.b;
import wx.c;
import wx.d;
import wx.e;
import wx.f;
import wx.g;
import wx.h;
import wx.i;
import wx.j;
import wx.k;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J \u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\tH\u0002J\u0010\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HJ\u001e\u0010I\u001a\u00020F2\u0006\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010G\u001a\u00020HJ\b\u0010L\u001a\u00020FH\u0016J\b\u0010M\u001a\u00020FH\u0002J\u000e\u0010N\u001a\u00020F2\u0006\u0010O\u001a\u00020PJ\b\u0010Q\u001a\u00020FH\u0002J\b\u0010R\u001a\u00020FH\u0002J \u0010S\u001a\u00020F2\u0006\u0010T\u001a\u00020P2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0007H\u0002J\u0012\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010X\u001a\u00020\u0007H\u0002J\u0018\u0010Y\u001a\u00020B2\u0006\u0010Z\u001a\u00020H2\u0006\u0010[\u001a\u00020\u000bH\u0002J\u0018\u0010\\\u001a\u00020\u00072\u0006\u0010O\u001a\u00020P2\u0006\u0010]\u001a\u00020\u001cH\u0002J&\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010P2\b\u0010a\u001a\u0004\u0018\u00010P2\b\u0010b\u001a\u0004\u0018\u00010PH\u0002J\n\u0010c\u001a\u0004\u0018\u00010?H\u0016J\b\u0010d\u001a\u00020\u0007H\u0016J\b\u0010e\u001a\u00020FH\u0002J(\u0010f\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020H2\u0006\u0010g\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\tH\u0002J\u0012\u0010i\u001a\u00020F2\b\u0010j\u001a\u0004\u0018\u00010\u0007H\u0002J\"\u0010k\u001a\u00020F2\u0006\u0010l\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u000b2\b\u0010n\u001a\u0004\u0018\u00010oH\u0014J\b\u0010p\u001a\u00020FH\u0016J\u0012\u0010q\u001a\u00020F2\b\u0010r\u001a\u0004\u0018\u00010sH\u0014J\b\u0010t\u001a\u00020FH\u0016J\b\u0010u\u001a\u00020FH\u0016J\u0012\u0010u\u001a\u00020F2\b\u0010v\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010w\u001a\u00020FH\u0016J\b\u0010x\u001a\u00020FH\u0016J\b\u0010y\u001a\u00020FH\u0016J\u0012\u0010z\u001a\u00020F2\b\u0010{\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010|\u001a\u00020F2\b\u0010a\u001a\u0004\u0018\u00010PH\u0002J\u0010\u0010}\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HJ\u001a\u0010~\u001a\u00020F2\b\u00109\u001a\u0004\u0018\u00010\u00072\u0006\u0010O\u001a\u00020PH\u0002J\u001a\u0010\u001a\u00020F2\b\u0010X\u001a\u0004\u0018\u00010\u00072\u0006\u0010O\u001a\u00020PH\u0002J\t\u0010\u0001\u001a\u00020FH\u0016J\u001d\u0010\u0001\u001a\u00020F2\b\u00109\u001a\u0004\u0018\u00010\u00072\b\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020FH\u0002J\u0013\u0010\u0001\u001a\u00020\u001c2\b\u00109\u001a\u0004\u0018\u00010\u0007H\u0002J\t\u0010\u0001\u001a\u00020\u001cH\u0002J\u0011\u0010\u0001\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020PH\u0002J\u0013\u0010\u0001\u001a\u00020\u001c2\b\u00109\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0002048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/talabat/wallet/screens/walletAddCard/view/WalletAddCreditCardScreen;", "Lcom/talabat/helpers/TalabatBase;", "Lcom/talabat/wallet/helpers/CreditCardHelperInterface;", "Lcom/talabat/wallet/screens/walletAddCard/view/WalletAddCreditCardView;", "Lcom/talabat/wallet/helpers/ResponseStatusInterface;", "()V", "DATE_SEPERATOR", "", "DIVIDER", "", "DIVIDER_MODULO", "", "DIVIDER_POSITION", "EMPTY_STRING", "ERROR", "EXPIRY_DATE_LENGTH", "MINIMUM_LENGTH_FOR_CARD_VALIDATION", "NUMBER_OF_EMPTY_SPACE", "RESULT_CODE", "SOURCE", "STATUS", "SUCCESS", "TLIFE", "TOP_UP_SCREEN", "TOTAL_DIGITS", "TOTAL_SYMBOLS", "URL", "cardErrorAvailable", "", "cardSecurityErrorAvailable", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "expiryDateErrorAvailable", "generateCardTokenUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "getGenerateCardTokenUseCase", "()Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "setGenerateCardTokenUseCase", "(Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;)V", "isSaveButtonDisabled", "lastInput", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "getPaymentConfigurationRepository", "()Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "setPaymentConfigurationRepository", "(Lcom/talabat/configuration/payment/PaymentConfigurationRepository;)V", "paymentOptionName", "getPaymentOptionName", "()Ljava/lang/String;", "setPaymentOptionName", "(Ljava/lang/String;)V", "walletAddCreditCardPresenter", "Lcom/talabat/wallet/screens/walletAddCard/presenter/WalletAddCreditCardPresenter;", "buildCorrectString", "digits", "", "dividerPosition", "divider", "cardExpiryAfterTextValidation", "", "editable", "Landroid/text/Editable;", "creditCardAfterTextValidation", "count", "input", "destroyPresenter", "disAbleSearchButtonOnAllClicks", "disAbleSearchButtonOnKeyboard", "editText", "Landroid/widget/EditText;", "disableSaveButton", "enableSaveButton", "formatExpiryDate", "expiryDateET", "currentInput", "getCardTypeIcon", "Landroid/graphics/drawable/Drawable;", "paymentOption", "getDigitArray", "s", "size", "getEditTextValue", "doTrim", "getFilledCard", "Ldatamodels/WalletCreditCard;", "cardNumberEditText", "cardExpiryDate", "securityCode", "getPresenter", "getScreenName", "hideKeyBoard", "isInputCorrect", "totalSymbols", "dividerModulo", "navigateToSubscriptionDetailScreen", "subscriptionMemberId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAuthError", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "onErrorReceived", "message", "onNonThreeDSCardSaved", "onResume", "onServerError", "openWebView", "url", "requestFocus", "securityCodeAfterTextValidation", "setCreditCardLength", "setMaximumLengthForSecurityCode", "setUpViewBeforeResponse", "updateCardTypeIndicator", "imageView", "Landroid/widget/ImageView;", "validateAllFields", "validateCreditCardLength", "validateExpiryDate", "validateExpiryDateEditView", "validateSecurityCode", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCreditCardScreen extends TalabatBase implements CreditCardHelperInterface, WalletAddCreditCardView, ResponseStatusInterface {
    @NotNull
    private final String DATE_SEPERATOR = "/";
    /* access modifiers changed from: private */
    public final char DIVIDER = ' ';
    /* access modifiers changed from: private */
    public final int DIVIDER_MODULO = 5;
    /* access modifiers changed from: private */
    public final int DIVIDER_POSITION = (5 - 1);
    @NotNull
    private final String EMPTY_STRING = "";
    @NotNull
    private final String ERROR = "error";
    private final int EXPIRY_DATE_LENGTH = 5;
    private final int MINIMUM_LENGTH_FOR_CARD_VALIDATION = 4;
    private final int NUMBER_OF_EMPTY_SPACE = 3;
    private final int RESULT_CODE = 2;
    @NotNull
    private final String SOURCE = "source";
    @NotNull
    private final String STATUS = "status";
    @NotNull
    private final String SUCCESS = "success";
    @NotNull
    private final String TLIFE = "tlife";
    @NotNull
    private final String TOP_UP_SCREEN = "top up screen";
    /* access modifiers changed from: private */
    public final int TOTAL_DIGITS = 16;
    /* access modifiers changed from: private */
    public final int TOTAL_SYMBOLS = 19;
    @NotNull
    private final String URL = "url";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean cardErrorAvailable = true;
    private boolean cardSecurityErrorAvailable = true;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    private boolean expiryDateErrorAvailable = true;
    @Inject
    public GenerateCardTokenUseCase generateCardTokenUseCase;
    private boolean isSaveButtonDisabled;
    @NotNull
    private String lastInput = "";
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Inject
    public PaymentConfigurationRepository paymentConfigurationRepository;
    @Nullable
    private String paymentOptionName;
    @Nullable
    private WalletAddCreditCardPresenter walletAddCreditCardPresenter;

    /* access modifiers changed from: private */
    public final String buildCorrectString(char[] cArr, int i11, char c11) {
        StringBuilder sb2 = new StringBuilder();
        int length = cArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            char c12 = cArr[i12];
            if (c12 != 0) {
                sb2.append(c12);
                if (i12 > 0 && i12 < cArr.length - 1 && (i12 + 1) % i11 == 0) {
                    sb2.append(c11);
                }
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "formatted.toString()");
        return sb3;
    }

    private final void disAbleSearchButtonOnAllClicks() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.card_number_edit_text);
        Intrinsics.checkNotNullExpressionValue(editText, "card_number_edit_text");
        disAbleSearchButtonOnKeyboard(editText);
        EditText editText2 = (EditText) _$_findCachedViewById(R.id.card_expiry_date);
        Intrinsics.checkNotNullExpressionValue(editText2, "card_expiry_date");
        disAbleSearchButtonOnKeyboard(editText2);
        EditText editText3 = (EditText) _$_findCachedViewById(R.id.security_code);
        Intrinsics.checkNotNullExpressionValue(editText3, "security_code");
        disAbleSearchButtonOnKeyboard(editText3);
    }

    /* access modifiers changed from: private */
    /* renamed from: disAbleSearchButtonOnKeyboard$lambda-10  reason: not valid java name */
    public static final boolean m5958disAbleSearchButtonOnKeyboard$lambda10(TextView textView, int i11, KeyEvent keyEvent) {
        return i11 == 3;
    }

    private final void disableSaveButton() {
        int i11 = R.id.save_button;
        ((TalabatFillButton) _$_findCachedViewById(i11)).setEnabled(false);
        ((TalabatFillButton) _$_findCachedViewById(i11)).setAlpha(0.5f);
    }

    private final void enableSaveButton() {
        int i11 = R.id.save_button;
        ((TalabatFillButton) _$_findCachedViewById(i11)).setEnabled(true);
        ((TalabatFillButton) _$_findCachedViewById(i11)).setAlpha(1.0f);
    }

    private final void formatExpiryDate(EditText editText, String str, String str2) {
        EditText editText2 = editText;
        String str3 = str;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy", Locale.US);
        try {
            Calendar.getInstance().setTime(simpleDateFormat.parse(str2));
        } catch (ParseException unused) {
            if (str2.length() == 2 && !StringsKt__StringsJVMKt.endsWith$default(str3, this.DATE_SEPERATOR, false, 2, (Object) null)) {
                if (Integer.parseInt(StringsKt__StringsJVMKt.replace$default(str2, this.DATE_SEPERATOR, "", false, 4, (Object) null)) <= 12) {
                    Editable text = editText.getText();
                    String str4 = this.DATE_SEPERATOR;
                    editText.setText(text + str4);
                    editText.setSelection(editText.getText().toString().length());
                    return;
                }
                char charAt = editText.getText().toString().charAt(0);
                String str5 = this.DATE_SEPERATOR;
                char charAt2 = editText.getText().toString().charAt(1);
                editText.setText("0" + charAt + str5 + charAt2);
                editText.setSelection(editText.getText().toString().length());
            } else if (str2.length() == 2 && StringsKt__StringsJVMKt.endsWith$default(str3, this.DATE_SEPERATOR, false, 2, (Object) null)) {
                if (Integer.parseInt(StringsKt__StringsJVMKt.replace$default(str2, this.DATE_SEPERATOR, "", false, 4, (Object) null)) <= 12) {
                    String substring = editText.getText().toString().substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    editText.setText(substring);
                    editText.setSelection(editText.getText().toString().length());
                    return;
                }
                editText.setText("");
                editText.setSelection(editText.getText().toString().length());
            } else if (str2.length() == 1) {
                if (Integer.parseInt(StringsKt__StringsJVMKt.replace$default(str2, this.DATE_SEPERATOR, "", false, 4, (Object) null)) > 1) {
                    Editable text2 = editText.getText();
                    String str6 = this.DATE_SEPERATOR;
                    editText.setText("0" + text2 + str6);
                    editText.setSelection(editText.getText().toString().length());
                }
            }
        }
    }

    private final Drawable getCardTypeIcon(String str) {
        switch (str.hashCode()) {
            case -1553624974:
                if (str.equals("MASTERCARD")) {
                    return getResources().getDrawable(R.drawable.master_card_icon);
                }
                break;
            case -420007048:
                if (str.equals("DINERS_CLUB")) {
                    return getResources().getDrawable(R.drawable.bt_ic_dinersclub);
                }
                break;
            case 73257:
                if (str.equals(GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_JCB)) {
                    return getResources().getDrawable(R.drawable.bt_ic_jcb);
                }
                break;
            case 2012639:
                if (str.equals("AMEX")) {
                    return getResources().getDrawable(R.drawable.amex_card_icon);
                }
                break;
            case 2634817:
                if (str.equals("VISA")) {
                    return getResources().getDrawable(R.drawable.visa_icon);
                }
                break;
            case 486122361:
                if (str.equals("UNIONPAY")) {
                    return getResources().getDrawable(R.drawable.bt_ic_unionpay);
                }
                break;
            case 1055811561:
                if (str.equals("DISCOVER")) {
                    return getResources().getDrawable(R.drawable.bt_ic_discover);
                }
                break;
            case 1545480463:
                if (str.equals(GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_MAESTRO)) {
                    return getResources().getDrawable(R.drawable.bt_ic_maestro);
                }
                break;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final char[] getDigitArray(Editable editable, int i11) {
        char[] cArr = new char[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < editable.length() && i12 < i11; i13++) {
            char charAt = editable.charAt(i13);
            if (Character.isDigit(charAt)) {
                cArr[i12] = charAt;
                i12++;
            }
        }
        return cArr;
    }

    private final String getEditTextValue(EditText editText, boolean z11) {
        int i11;
        boolean z12;
        if (z11) {
            String obj = editText.getText().toString();
            int length = obj.length() - 1;
            int i12 = 0;
            boolean z13 = false;
            while (i12 <= length) {
                if (!z13) {
                    i11 = i12;
                } else {
                    i11 = length;
                }
                if (Intrinsics.compare((int) obj.charAt(i11), 32) <= 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z13) {
                    if (!z12) {
                        z13 = true;
                    } else {
                        i12++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            return obj.subSequence(i12, length + 1).toString();
        }
        Editable text = editText.getText();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(text);
        return sb2.toString();
    }

    private final WalletCreditCard getFilledCard(EditText editText, EditText editText2, EditText editText3) {
        Editable editable;
        Editable editable2;
        Editable editable3;
        Editable editable4;
        int i11;
        boolean z11;
        int i12;
        boolean z12;
        int i13;
        boolean z13;
        int i14;
        boolean z14;
        int i15;
        boolean z15;
        Editable editable5 = null;
        if (editText2 != null) {
            editable = editText2.getText();
        } else {
            editable = null;
        }
        String valueOf = String.valueOf(editable);
        int length = valueOf.length() - 1;
        int i16 = 0;
        boolean z16 = false;
        while (i16 <= length) {
            if (!z16) {
                i15 = i16;
            } else {
                i15 = length;
            }
            if (Intrinsics.compare((int) valueOf.charAt(i15), 32) <= 0) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (!z16) {
                if (!z15) {
                    z16 = true;
                } else {
                    i16++;
                }
            } else if (!z15) {
                break;
            } else {
                length--;
            }
        }
        String substring = valueOf.subSequence(i16, length + 1).toString().substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        if (editText2 != null) {
            editable2 = editText2.getText();
        } else {
            editable2 = null;
        }
        String valueOf2 = String.valueOf(editable2);
        int length2 = valueOf2.length() - 1;
        int i17 = 0;
        boolean z17 = false;
        while (i17 <= length2) {
            if (!z17) {
                i14 = i17;
            } else {
                i14 = length2;
            }
            if (Intrinsics.compare((int) valueOf2.charAt(i14), 32) <= 0) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (!z17) {
                if (!z14) {
                    z17 = true;
                } else {
                    i17++;
                }
            } else if (!z14) {
                break;
            } else {
                length2--;
            }
        }
        String substring2 = valueOf2.subSequence(i17, length2 + 1).toString().substring(3, 5);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        if (editText != null) {
            editable3 = editText.getText();
        } else {
            editable3 = null;
        }
        String valueOf3 = String.valueOf(editable3);
        int length3 = valueOf3.length() - 1;
        int i18 = 0;
        boolean z18 = false;
        while (i18 <= length3) {
            if (!z18) {
                i13 = i18;
            } else {
                i13 = length3;
            }
            if (Intrinsics.compare((int) valueOf3.charAt(i13), 32) <= 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (!z18) {
                if (!z13) {
                    z18 = true;
                } else {
                    i18++;
                }
            } else if (!z13) {
                break;
            } else {
                length3--;
            }
        }
        String replace = new Regex("\\s").replace((CharSequence) valueOf3.subSequence(i18, length3 + 1).toString(), "");
        if (editText3 != null) {
            editable4 = editText3.getText();
        } else {
            editable4 = null;
        }
        String valueOf4 = String.valueOf(editable4);
        int length4 = valueOf4.length() - 1;
        int i19 = 0;
        boolean z19 = false;
        while (i19 <= length4) {
            if (!z19) {
                i12 = i19;
            } else {
                i12 = length4;
            }
            if (Intrinsics.compare((int) valueOf4.charAt(i12), 32) <= 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z19) {
                if (!z12) {
                    z19 = true;
                } else {
                    i19++;
                }
            } else if (!z12) {
                break;
            } else {
                length4--;
            }
        }
        String obj = valueOf4.subSequence(i19, length4 + 1).toString();
        if (editText != null) {
            editable5 = editText.getText();
        }
        String valueOf5 = String.valueOf(editable5);
        int length5 = valueOf5.length() - 1;
        int i21 = 0;
        boolean z21 = false;
        while (i21 <= length5) {
            if (!z21) {
                i11 = i21;
            } else {
                i11 = length5;
            }
            if (Intrinsics.compare((int) valueOf5.charAt(i11), 32) <= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z21) {
                if (!z11) {
                    z21 = true;
                } else {
                    i21++;
                }
            } else if (!z11) {
                break;
            } else {
                length5--;
            }
        }
        String substring3 = new Regex("\\s").replace((CharSequence) valueOf5.subSequence(i21, length5 + 1).toString(), "").substring(0, 6);
        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
        return new WalletCreditCard(replace, substring3, substring, substring2, obj, StringUtils.empty(StringCompanionObject.INSTANCE));
    }

    private final void hideKeyBoard() {
        InputMethodManager inputMethodManager;
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = getSystemService("input_method");
            if (systemService instanceof InputMethodManager) {
                inputMethodManager = (InputMethodManager) systemService;
            } else {
                inputMethodManager = null;
            }
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean isInputCorrect(Editable editable, int i11, int i12, char c11) {
        boolean z11;
        boolean z12;
        if (editable.length() <= i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        int length = editable.length();
        for (int i13 = 0; i13 < length; i13++) {
            if (i13 <= 0 || (i13 + 1) % i12 != 0) {
                z12 = Character.isDigit(editable.charAt(i13));
            } else if (c11 == editable.charAt(i13)) {
                z12 = true;
            } else {
                z12 = false;
            }
            z11 &= z12;
        }
        return z11;
    }

    private final void navigateToSubscriptionDetailScreen(String str) {
        if (str != null) {
            Navigator.Companion.navigate((Context) this, WalletNavigatorActions.Companion.createSubscriptionDetailNavigation(str, "talabat.action.Wallet.addcard", "talabat.action.Wallet.SubscriptionDetailActivity", true));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityResult$lambda-16  reason: not valid java name */
    public static final void m5959onActivityResult$lambda16(WalletAddCreditCardScreen walletAddCreditCardScreen) {
        Intrinsics.checkNotNullParameter(walletAddCreditCardScreen, "this$0");
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) walletAddCreditCardScreen._$_findCachedViewById(R.id.root_view);
        Intrinsics.checkNotNullExpressionValue(coordinatorLayout, "root_view");
        String string = walletAddCreditCardScreen.getResources().getString(R.string.invalid_card_info);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…string.invalid_card_info)");
        walletAddCreditCardScreen.makeSnackBar(coordinatorLayout, walletAddCreditCardScreen, string, ResponseStatus.ERROR);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m5960onCreate$lambda0(WalletAddCreditCardScreen walletAddCreditCardScreen, View view, boolean z11) {
        Intrinsics.checkNotNullParameter(walletAddCreditCardScreen, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!z11) {
            walletAddCreditCardScreen.validateCreditCardLength(walletAddCreditCardScreen.paymentOptionName);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m5961onCreate$lambda1(WalletAddCreditCardScreen walletAddCreditCardScreen, View view, boolean z11) {
        Intrinsics.checkNotNullParameter(walletAddCreditCardScreen, "this$0");
        if (!z11) {
            walletAddCreditCardScreen.validateExpiryDate();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m5962onCreate$lambda2(WalletAddCreditCardScreen walletAddCreditCardScreen, View view, boolean z11) {
        Intrinsics.checkNotNullParameter(walletAddCreditCardScreen, "this$0");
        if (!z11) {
            walletAddCreditCardScreen.validateSecurityCode(walletAddCreditCardScreen.paymentOptionName);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m5963onCreate$lambda3(WalletAddCreditCardScreen walletAddCreditCardScreen, View view) {
        Intrinsics.checkNotNullParameter(walletAddCreditCardScreen, "this$0");
        if (walletAddCreditCardScreen.validateCreditCardLength(walletAddCreditCardScreen.paymentOptionName) && walletAddCreditCardScreen.validateExpiryDate() && walletAddCreditCardScreen.validateSecurityCode(walletAddCreditCardScreen.paymentOptionName)) {
            walletAddCreditCardScreen.disableSaveButton();
            Object systemService = walletAddCreditCardScreen.getSystemService("input_method");
            if (systemService != null) {
                int i11 = R.id.security_code;
                ((InputMethodManager) systemService).hideSoftInputFromWindow(((EditText) walletAddCreditCardScreen._$_findCachedViewById(i11)).getWindowToken(), 0);
                WalletCreditCard filledCard = walletAddCreditCardScreen.getFilledCard((EditText) walletAddCreditCardScreen._$_findCachedViewById(R.id.card_number_edit_text), (EditText) walletAddCreditCardScreen._$_findCachedViewById(R.id.card_expiry_date), (EditText) walletAddCreditCardScreen._$_findCachedViewById(i11));
                WalletAddCreditCardPresenter walletAddCreditCardPresenter2 = walletAddCreditCardScreen.walletAddCreditCardPresenter;
                if (walletAddCreditCardPresenter2 != null) {
                    walletAddCreditCardPresenter2.saveCreditCard(filledCard);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4  reason: not valid java name */
    public static final void m5964onCreate$lambda4(WalletAddCreditCardScreen walletAddCreditCardScreen, View view) {
        Intrinsics.checkNotNullParameter(walletAddCreditCardScreen, "this$0");
        Object systemService = walletAddCreditCardScreen.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(((EditText) walletAddCreditCardScreen._$_findCachedViewById(R.id.security_code)).getWindowToken(), 0);
            walletAddCreditCardScreen.finish();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-6  reason: not valid java name */
    public static final void m5965onCreate$lambda6(WalletAddCreditCardScreen walletAddCreditCardScreen, View view) {
        Intrinsics.checkNotNullParameter(walletAddCreditCardScreen, "this$0");
        walletAddCreditCardScreen.hideKeyBoard();
        new Handler().postDelayed(new e(new SecureMoreInfoBottomSheetDialog(), walletAddCreditCardScreen), 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-6$lambda-5  reason: not valid java name */
    public static final void m5966onCreate$lambda6$lambda5(SecureMoreInfoBottomSheetDialog secureMoreInfoBottomSheetDialog, WalletAddCreditCardScreen walletAddCreditCardScreen) {
        Intrinsics.checkNotNullParameter(secureMoreInfoBottomSheetDialog, "$bottomSheet");
        Intrinsics.checkNotNullParameter(walletAddCreditCardScreen, "this$0");
        secureMoreInfoBottomSheetDialog.show(walletAddCreditCardScreen.getSupportFragmentManager(), "bottomsheet");
    }

    /* access modifiers changed from: private */
    /* renamed from: onErrorReceived$lambda-12  reason: not valid java name */
    public static final void m5967onErrorReceived$lambda12(WalletAddCreditCardScreen walletAddCreditCardScreen, String str) {
        Intrinsics.checkNotNullParameter(walletAddCreditCardScreen, "this$0");
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) walletAddCreditCardScreen._$_findCachedViewById(R.id.root_view);
        Intrinsics.checkNotNullExpressionValue(coordinatorLayout, "root_view");
        Intrinsics.checkNotNull(str);
        walletAddCreditCardScreen.makeSnackBar(coordinatorLayout, walletAddCreditCardScreen, str, ResponseStatus.ERROR);
    }

    /* access modifiers changed from: private */
    /* renamed from: onErrorReceived$lambda-13  reason: not valid java name */
    public static final void m5968onErrorReceived$lambda13(WalletAddCreditCardScreen walletAddCreditCardScreen) {
        Intrinsics.checkNotNullParameter(walletAddCreditCardScreen, "this$0");
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) walletAddCreditCardScreen._$_findCachedViewById(R.id.root_view);
        Intrinsics.checkNotNullExpressionValue(coordinatorLayout, "root_view");
        String string = walletAddCreditCardScreen.getResources().getString(R.string.invalid_card_info);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…string.invalid_card_info)");
        walletAddCreditCardScreen.makeSnackBar(coordinatorLayout, walletAddCreditCardScreen, string, ResponseStatus.ERROR);
    }

    private final void requestFocus(EditText editText) {
        if (editText == null) {
            return;
        }
        if (validateExpiryDateEditView(editText)) {
            ((EditText) _$_findCachedViewById(R.id.security_code)).requestFocus();
        } else {
            editText.requestFocus();
        }
    }

    private final void setCreditCardLength(String str, EditText editText) {
        Integer num;
        WalletAddCreditCardPresenter walletAddCreditCardPresenter2 = this.walletAddCreditCardPresenter;
        if (walletAddCreditCardPresenter2 != null) {
            num = Integer.valueOf(walletAddCreditCardPresenter2.getCreditCardNumberLength(str) + this.NUMBER_OF_EMPTY_SPACE);
        } else {
            num = null;
        }
        if (num != null) {
            num.intValue();
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(num.intValue())});
        }
    }

    private final void setMaximumLengthForSecurityCode(String str, EditText editText) {
        Integer num;
        WalletAddCreditCardPresenter walletAddCreditCardPresenter2 = this.walletAddCreditCardPresenter;
        if (walletAddCreditCardPresenter2 != null) {
            num = Integer.valueOf(walletAddCreditCardPresenter2.getMaximumLengthForSecurityCode(str));
        } else {
            num = null;
        }
        if (num != null) {
            num.intValue();
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(num.intValue())});
        }
    }

    private final void updateCardTypeIndicator(String str, ImageView imageView) {
        if (str != null) {
            imageView.setImageResource(WalletCardType.Companion.getCardTypeFromCardName(str).getIconResource());
        }
    }

    private final void validateAllFields() {
        if (!this.cardErrorAvailable && !this.expiryDateErrorAvailable && !this.cardSecurityErrorAvailable) {
            enableSaveButton();
        }
    }

    private final boolean validateCreditCardLength(String str) {
        Integer num;
        if (str == null) {
            return false;
        }
        int i11 = R.id.card_number_edit_text;
        EditText editText = (EditText) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(editText, "card_number_edit_text");
        setCreditCardLength(str, editText);
        WalletAddCreditCardPresenter walletAddCreditCardPresenter2 = this.walletAddCreditCardPresenter;
        if (walletAddCreditCardPresenter2 != null) {
            num = Integer.valueOf(walletAddCreditCardPresenter2.getCreditCardNumberLength(str) + this.NUMBER_OF_EMPTY_SPACE);
        } else {
            num = null;
        }
        EditText editText2 = (EditText) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(editText2, "card_number_edit_text");
        int length = getEditTextValue(editText2, true).length();
        if (num == null || num.intValue() == length) {
            return true;
        }
        Integer valueOf = Integer.valueOf(num.intValue() - this.NUMBER_OF_EMPTY_SPACE);
        int i12 = R.id.card_number_error;
        ((TextView) _$_findCachedViewById(i12)).setText(getResources().getString(R.string.card_number_length_error, new Object[]{valueOf.toString()}));
        ((TextView) _$_findCachedViewById(i12)).setVisibility(0);
        this.cardErrorAvailable = true;
        disableSaveButton();
        return false;
    }

    private final boolean validateExpiryDate() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.card_expiry_date);
        Intrinsics.checkNotNullExpressionValue(editText, "card_expiry_date");
        if (validateExpiryDateEditView(editText)) {
            return true;
        }
        int i11 = R.id.expiry_date_error;
        ((TextView) _$_findCachedViewById(i11)).setText(getString(R.string.invalid_expiry_date));
        ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        this.expiryDateErrorAvailable = true;
        disableSaveButton();
        return false;
    }

    private final boolean validateExpiryDateEditView(EditText editText) {
        Boolean bool;
        String editTextValue = getEditTextValue(editText, true);
        WalletAddCreditCardPresenter walletAddCreditCardPresenter2 = this.walletAddCreditCardPresenter;
        if (walletAddCreditCardPresenter2 != null) {
            bool = Boolean.valueOf(walletAddCreditCardPresenter2.validateExpiryDate(editTextValue));
        } else {
            bool = null;
        }
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    private final boolean validateSecurityCode(String str) {
        Integer num;
        if (str == null) {
            return false;
        }
        int i11 = R.id.security_code;
        EditText editText = (EditText) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(editText, "security_code");
        setMaximumLengthForSecurityCode(str, editText);
        WalletAddCreditCardPresenter walletAddCreditCardPresenter2 = this.walletAddCreditCardPresenter;
        if (walletAddCreditCardPresenter2 != null) {
            num = Integer.valueOf(walletAddCreditCardPresenter2.getMaximumLengthForSecurityCode(str));
        } else {
            num = null;
        }
        EditText editText2 = (EditText) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(editText2, "security_code");
        int length = getEditTextValue(editText2, true).length();
        if (num != null && num.intValue() == length) {
            return true;
        }
        int i12 = R.id.security_code_error;
        ((TextView) _$_findCachedViewById(i12)).setText(getString(R.string.security_code_length_error, new Object[]{String.valueOf(num)}));
        ((TextView) _$_findCachedViewById(i12)).setVisibility(0);
        this.cardSecurityErrorAvailable = true;
        disableSaveButton();
        return false;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void cardExpiryAfterTextValidation(@Nullable Editable editable) {
        Integer num;
        if (!TalabatUtils.isNullOrEmpty(String.valueOf(editable))) {
            int i11 = R.id.card_expiry_date;
            EditText editText = (EditText) _$_findCachedViewById(i11);
            Intrinsics.checkNotNullExpressionValue(editText, "card_expiry_date");
            formatExpiryDate(editText, this.lastInput, String.valueOf(editable));
            this.lastInput = ((EditText) _$_findCachedViewById(i11)).getText().toString();
        }
        if (editable != null) {
            num = Integer.valueOf(editable.length());
        } else {
            num = null;
        }
        if (num == null) {
            return;
        }
        if (num.intValue() == this.EXPIRY_DATE_LENGTH) {
            EditText editText2 = (EditText) _$_findCachedViewById(R.id.card_expiry_date);
            Intrinsics.checkNotNullExpressionValue(editText2, "card_expiry_date");
            if (!validateExpiryDateEditView(editText2)) {
                ((TextView) _$_findCachedViewById(R.id.expiry_date_error)).setVisibility(0);
                this.expiryDateErrorAvailable = true;
                disableSaveButton();
                return;
            }
            ((TextView) _$_findCachedViewById(R.id.expiry_date_error)).setVisibility(8);
            this.expiryDateErrorAvailable = false;
            ((EditText) _$_findCachedViewById(R.id.security_code)).requestFocus();
            validateAllFields();
            return;
        }
        ((TextView) _$_findCachedViewById(R.id.expiry_date_error)).setVisibility(8);
        this.expiryDateErrorAvailable = true;
        disableSaveButton();
    }

    public final void creditCardAfterTextValidation(int i11, @NotNull String str, @NotNull Editable editable) {
        String str2;
        Integer num;
        Intrinsics.checkNotNullParameter(str, "input");
        Intrinsics.checkNotNullParameter(editable, "editable");
        if (i11 >= this.MINIMUM_LENGTH_FOR_CARD_VALIDATION) {
            String substring = StringsKt__StringsKt.substring(str, new IntRange(0, this.MINIMUM_LENGTH_FOR_CARD_VALIDATION - 1));
            WalletAddCreditCardPresenter walletAddCreditCardPresenter2 = this.walletAddCreditCardPresenter;
            Boolean bool = null;
            if (walletAddCreditCardPresenter2 != null) {
                str2 = walletAddCreditCardPresenter2.getPaymentMethodOptionName(substring);
            } else {
                str2 = null;
            }
            this.paymentOptionName = str2;
            int i12 = R.id.credit_card_logo;
            ImageView imageView = (ImageView) _$_findCachedViewById(i12);
            Intrinsics.checkNotNullExpressionValue(imageView, "credit_card_logo");
            updateCardTypeIndicator(str2, imageView);
            ((ImageView) _$_findCachedViewById(i12)).setVisibility(0);
            String str3 = this.paymentOptionName;
            EditText editText = (EditText) _$_findCachedViewById(R.id.card_number_edit_text);
            Intrinsics.checkNotNullExpressionValue(editText, "card_number_edit_text");
            setCreditCardLength(str3, editText);
            String str4 = this.paymentOptionName;
            EditText editText2 = (EditText) _$_findCachedViewById(R.id.security_code);
            Intrinsics.checkNotNullExpressionValue(editText2, "security_code");
            setMaximumLengthForSecurityCode(str4, editText2);
            WalletAddCreditCardPresenter walletAddCreditCardPresenter3 = this.walletAddCreditCardPresenter;
            if (walletAddCreditCardPresenter3 != null) {
                num = Integer.valueOf(walletAddCreditCardPresenter3.getCreditCardNumberLength(this.paymentOptionName) + this.NUMBER_OF_EMPTY_SPACE);
            } else {
                num = null;
            }
            if (TalabatUtils.isNullOrEmpty(str) || this.paymentOptionName == null || num == null || num.intValue() <= 0) {
                if (this.paymentOptionName == null) {
                    int i13 = R.id.card_number_error;
                    ((TextView) _$_findCachedViewById(i13)).setText(getString(R.string.card_not_surported));
                    ((TextView) _$_findCachedViewById(i13)).setVisibility(0);
                    ((ImageView) _$_findCachedViewById(i12)).setVisibility(4);
                }
            } else if (str.length() != num.intValue()) {
                this.cardErrorAvailable = true;
                ((TextView) _$_findCachedViewById(R.id.card_number_error)).setVisibility(8);
                disableSaveButton();
            } else {
                WalletAddCreditCardPresenter walletAddCreditCardPresenter4 = this.walletAddCreditCardPresenter;
                if (walletAddCreditCardPresenter4 != null) {
                    bool = Boolean.valueOf(walletAddCreditCardPresenter4.isLuhnValid(new Regex("\\s").replace((CharSequence) editable.toString(), this.EMPTY_STRING)));
                }
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    this.cardErrorAvailable = false;
                    requestFocus((EditText) _$_findCachedViewById(R.id.card_expiry_date));
                    ((TextView) _$_findCachedViewById(R.id.card_number_error)).setVisibility(8);
                    validateAllFields();
                    return;
                }
                int i14 = R.id.card_number_error;
                ((TextView) _$_findCachedViewById(i14)).setVisibility(0);
                ((TextView) _$_findCachedViewById(i14)).setText(getString(R.string.invalid_card_message));
                ((ImageView) _$_findCachedViewById(i12)).setVisibility(4);
                this.cardErrorAvailable = true;
                disableSaveButton();
            }
        } else {
            String str5 = this.EMPTY_STRING;
            int i15 = R.id.credit_card_logo;
            ImageView imageView2 = (ImageView) _$_findCachedViewById(i15);
            Intrinsics.checkNotNullExpressionValue(imageView2, "credit_card_logo");
            updateCardTypeIndicator(str5, imageView2);
            ((ImageView) _$_findCachedViewById(i15)).setVisibility(4);
            ((TextView) _$_findCachedViewById(R.id.card_number_error)).setVisibility(8);
            this.cardErrorAvailable = true;
            disableSaveButton();
        }
    }

    public void destroyPresenter() {
        this.walletAddCreditCardPresenter = null;
    }

    public final void disAbleSearchButtonOnKeyboard(@NotNull EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        editText.setOnEditorActionListener(new d());
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    @NotNull
    public final GenerateCardTokenUseCase getGenerateCardTokenUseCase() {
        GenerateCardTokenUseCase generateCardTokenUseCase2 = this.generateCardTokenUseCase;
        if (generateCardTokenUseCase2 != null) {
            return generateCardTokenUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("generateCardTokenUseCase");
        return null;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
        return null;
    }

    @NotNull
    public final PaymentConfigurationRepository getPaymentConfigurationRepository() {
        PaymentConfigurationRepository paymentConfigurationRepository2 = this.paymentConfigurationRepository;
        if (paymentConfigurationRepository2 != null) {
            return paymentConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentConfigurationRepository");
        return null;
    }

    @Nullable
    public final String getPaymentOptionName() {
        return this.paymentOptionName;
    }

    @NotNull
    public String getScreenName() {
        return "";
    }

    public boolean hasCardExpired(@NotNull String str, @NotNull String str2) {
        return CreditCardHelperInterface.DefaultImpls.hasCardExpired(this, str, str2);
    }

    public void makeSnackBar(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull ResponseStatus responseStatus) {
        ResponseStatusInterface.DefaultImpls.makeSnackBar(this, view, context, str, responseStatus);
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        String str;
        super.onActivityResult(i11, i12, intent);
        if (i12 == this.RESULT_CODE) {
            if (intent != null) {
                str = intent.getStringExtra(this.STATUS);
            } else {
                str = null;
            }
            if (Intrinsics.areEqual((Object) str, (Object) this.ERROR)) {
                new Handler().postDelayed(new c(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                this.isSaveButtonDisabled = true;
            }
        }
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerWalletAddCreditCardScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class), (ContextCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ContextCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class), (TokenizationFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(TokenizationFeatureApi.class)).inject(this);
        super.onCreate(bundle);
        if (TalabatUtils.isArabic()) {
            setContentView((int) R.layout.activity_wallet_add_credit_card_screen_ar);
        } else {
            setContentView((int) R.layout.activity_wallet_add_credit_card_screen);
        }
        this.walletAddCreditCardPresenter = new WalletAddCreditCardPresenter(getConfigurationLocalRepository(), getLocationConfigurationRepository(), getPaymentConfigurationRepository(), getGenerateCardTokenUseCase(), this);
        this.lastInput = "";
        int i11 = R.id.card_number_edit_text;
        ((EditText) _$_findCachedViewById(i11)).requestFocus();
        ((EditText) _$_findCachedViewById(i11)).addTextChangedListener(new WalletAddCreditCardScreen$onCreate$1(this));
        int i12 = R.id.card_expiry_date;
        ((EditText) _$_findCachedViewById(i12)).addTextChangedListener(new WalletAddCreditCardScreen$onCreate$2(this));
        int i13 = R.id.security_code;
        ((EditText) _$_findCachedViewById(i13)).addTextChangedListener(new WalletAddCreditCardScreen$onCreate$3(this));
        ((EditText) _$_findCachedViewById(i11)).setOnFocusChangeListener(new f(this));
        ((EditText) _$_findCachedViewById(i12)).setOnFocusChangeListener(new g(this));
        ((EditText) _$_findCachedViewById(i13)).setOnFocusChangeListener(new h(this));
        disAbleSearchButtonOnAllClicks();
        int i14 = R.id.save_button;
        ((TalabatFillButton) _$_findCachedViewById(i14)).setOnClickListener(new i(this));
        ((ImageButton) _$_findCachedViewById(R.id.back)).setOnClickListener(new j(this));
        ((TextView) _$_findCachedViewById(R.id.learn_more)).setOnClickListener(new k(this));
        ((TalabatFillButton) _$_findCachedViewById(i14)).setAlpha(0.5f);
        ((TalabatFillButton) _$_findCachedViewById(i14)).setEnabled(false);
    }

    public void onError() {
    }

    public void onErrorReceived(@Nullable String str) {
        stopLodingPopup();
        new Handler().postDelayed(new a(this, str), 1000);
    }

    public void onNonThreeDSCardSaved() {
        String str;
        Intent intent;
        boolean z11;
        String str2 = this.EMPTY_STRING;
        if (getIntent().hasExtra(this.SOURCE) && (str2 = getIntent().getStringExtra(this.SOURCE)) == null) {
            str2 = "";
        }
        String str3 = str2;
        Intent intent2 = getIntent();
        if (intent2 != null) {
            str = intent2.getStringExtra("subscriptionMemberId");
        } else {
            str = null;
        }
        boolean z12 = false;
        if (StringsKt__StringsJVMKt.equals(str3, this.TOP_UP_SCREEN, false)) {
            intent = new Intent(this, WalletTopupCardListScreen.class);
        } else if (StringsKt__StringsJVMKt.equals(str3, "walletPaymentBottomSheet", false)) {
            finish();
            return;
        } else {
            if (str == null || str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                navigateToSubscriptionDetailScreen(str);
                return;
            }
            if (str3.length() > 0) {
                z12 = true;
            }
            if (z12) {
                Navigator.Companion.navigate((Context) this, new NavigatorModel(str3, (Bundle) null, WalletAddCreditCardScreen$onNonThreeDSCardSaved$1.INSTANCE, 2, (DefaultConstructorMarker) null));
                return;
            }
            intent = new Intent(this, WalletManageCreditCardsScreen.class);
        }
        intent.addFlags(335544320);
        intent.putExtra(this.STATUS, this.SUCCESS);
        startActivity(intent);
        finish();
    }

    public void onResume() {
        super.onResume();
        int i11 = R.id.save_button;
        ((TalabatFillButton) _$_findCachedViewById(i11)).setVisibility(0);
        if (validateCreditCardLength(this.paymentOptionName) && validateExpiryDate() && validateSecurityCode(this.paymentOptionName)) {
            ((TalabatFillButton) _$_findCachedViewById(i11)).setEnabled(true);
        }
        Object systemService = getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).toggleSoftInput(2, 0);
            if (this.isSaveButtonDisabled) {
                ((TalabatFillButton) _$_findCachedViewById(i11)).setEnabled(false);
                this.isSaveButtonDisabled = false;
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public void onServerError() {
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
        stopLodingPopup();
        enableSaveButton();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) _$_findCachedViewById(R.id.root_view);
        Intrinsics.checkNotNullExpressionValue(coordinatorLayout, "root_view");
        String string = getString(R.string.server_error_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….string.server_error_msg)");
        makeSnackBar(coordinatorLayout, this, string, ResponseStatus.ERROR);
    }

    public void openWebView(@Nullable String str) {
        stopLodingPopup();
        if (str != null) {
            String stringExtra = getIntent().getStringExtra(this.SOURCE);
            if (stringExtra == null) {
                stringExtra = "";
            }
            String stringExtra2 = getIntent().getStringExtra("subscriptionMemberId");
            Intent intent = new Intent(this, CheckoutWebView.class);
            intent.putExtra(this.URL, str);
            intent.putExtra(this.SOURCE, stringExtra);
            if (stringExtra2 != null) {
                intent.putExtra("subscriptionMemberId", stringExtra2);
                LogManager.debug("member id " + stringExtra2);
            }
            startActivityForResult(intent, this.RESULT_CODE);
            if (StringsKt__StringsJVMKt.equals(stringExtra, "walletPaymentBottomSheet", false)) {
                finish();
            }
        }
    }

    public final void securityCodeAfterTextValidation(@Nullable Editable editable) {
        Integer num;
        String valueOf = String.valueOf(editable);
        Integer num2 = null;
        if (editable != null) {
            num = Integer.valueOf(editable.length());
        } else {
            num = null;
        }
        if (num != null) {
            num.intValue();
            WalletAddCreditCardPresenter walletAddCreditCardPresenter2 = this.walletAddCreditCardPresenter;
            if (walletAddCreditCardPresenter2 != null) {
                num2 = Integer.valueOf(walletAddCreditCardPresenter2.getMaximumLengthForSecurityCode(this.paymentOptionName));
            }
            if (!TalabatUtils.isNullOrEmpty(valueOf)) {
                Intrinsics.checkNotNull(num2);
                if (num2.intValue() > 0) {
                    if (valueOf.length() != num2.intValue()) {
                        this.cardSecurityErrorAvailable = true;
                        disableSaveButton();
                        return;
                    }
                    this.cardSecurityErrorAvailable = false;
                    ((TextView) _$_findCachedViewById(R.id.security_code_error)).setVisibility(8);
                    validateAllFields();
                    return;
                }
            }
            this.cardSecurityErrorAvailable = true;
        }
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setGenerateCardTokenUseCase(@NotNull GenerateCardTokenUseCase generateCardTokenUseCase2) {
        Intrinsics.checkNotNullParameter(generateCardTokenUseCase2, "<set-?>");
        this.generateCardTokenUseCase = generateCardTokenUseCase2;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setPaymentConfigurationRepository(@NotNull PaymentConfigurationRepository paymentConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "<set-?>");
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
    }

    public final void setPaymentOptionName(@Nullable String str) {
        this.paymentOptionName = str;
    }

    public void setUpViewBeforeResponse() {
        startLodingPopup();
    }

    @Nullable
    public WalletAddCreditCardPresenter getPresenter() {
        return this.walletAddCreditCardPresenter;
    }

    public void onErrorReceived() {
        stopLodingPopup();
        new Handler().postDelayed(new b(this), 1000);
    }
}
