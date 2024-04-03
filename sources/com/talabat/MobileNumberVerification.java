package com.talabat;

import JsonModels.parser.UniversalGson;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.google.gson.Gson;
import com.materialedittext.MaterialEditText;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.designhelpers.CountryCode;
import com.talabat.di.account.DaggerMobileNumberVerificationScreenComponent;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import datamodels.QuickOrderInfo;
import datamodels.SmsVerificationInstance;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.numberverification.INumberVerificationPresenter;
import library.talabat.mvp.numberverification.NumberVerificationPresenter;
import library.talabat.mvp.numberverification.NumberVerificationView;
import mobilenumberverificationhelpers.PinEntryEditText;
import org.json.JSONArray;
import org.json.JSONObject;
import tracking.AppTracker;
import tracking.ScreenNames;

@Instrumented
public class MobileNumberVerification extends TalabatBase implements NumberVerificationView {
    public static int LIVE_CHAT = 555;
    private static final int PERMISSION_REQUEST_CODE = 44;
    /* access modifiers changed from: private */
    public View LiveChatView;
    /* access modifiers changed from: private */
    public ArrayList<CountryCode> allCountriesList;
    /* access modifiers changed from: private */
    public TextView arabicErrorTxt;
    /* access modifiers changed from: private */
    public TextView callMeCounter;
    /* access modifiers changed from: private */
    public ImageView callMeImg;
    /* access modifiers changed from: private */
    public TextView callMeLabel;
    /* access modifiers changed from: private */
    public View callMeView;
    /* access modifiers changed from: private */
    public boolean continueTimer = true;
    /* access modifiers changed from: private */
    public String countryCode = "";
    /* access modifiers changed from: private */
    public String encryptedMobile;

    /* renamed from: i  reason: collision with root package name */
    public PinEntryEditText f54405i;
    private View initialVerificationView;
    private boolean isFirst;
    private boolean isFromAptimize;
    /* access modifiers changed from: private */
    public boolean isFromCallOption;
    /* access modifiers changed from: private */
    public boolean isNeedToUpdateMobChekckout = false;
    private boolean isQuickOrder;
    private boolean isSmsReceiverRegistered;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<String> f54406j;

    /* renamed from: k  reason: collision with root package name */
    public String f54407k;

    /* renamed from: l  reason: collision with root package name */
    public QuickOrderInfo f54408l;
    /* access modifiers changed from: private */
    public TextView liveChatCounterLabel;
    private ImageView liveChatImage;
    /* access modifiers changed from: private */
    public ImageView liveChatImg;
    /* access modifiers changed from: private */
    public TextView livechatCounter;

    /* renamed from: m  reason: collision with root package name */
    public Handler f54409m;
    private TextView mobileverifiedThankyouContinueBtn;

    /* renamed from: n  reason: collision with root package name */
    public Runnable f54410n;
    /* access modifiers changed from: private */
    public INumberVerificationPresenter numberVerificationPresenter;

    /* renamed from: o  reason: collision with root package name */
    public int f54411o = 30;
    private String otpString = "";

    /* renamed from: p  reason: collision with root package name */
    public int f54412p = 30;
    private ArrayList<CountryCode> phoneCountriesList;

    /* renamed from: q  reason: collision with root package name */
    public SmsVerificationInstance f54413q;
    private String quickOrderString = "";
    @Inject

    /* renamed from: r  reason: collision with root package name */
    public AppVersionProvider f54414r;
    /* access modifiers changed from: private */
    public View resendCodeView;
    /* access modifiers changed from: private */
    public TextView resendCounter;
    /* access modifiers changed from: private */
    public ImageView resendImg;
    /* access modifiers changed from: private */
    public TextView resendLabel;
    private View rootLayout;
    @Inject

    /* renamed from: s  reason: collision with root package name */
    public ConfigurationLocalRepository f54415s;
    /* access modifiers changed from: private */
    public String smsToken;
    @Inject

    /* renamed from: t  reason: collision with root package name */
    public DiscoveryConfigurationRepository f54416t;
    /* access modifiers changed from: private */
    public boolean timedOut = false;
    @Inject

    /* renamed from: u  reason: collision with root package name */
    public LocationConfigurationRepository f54417u;
    private TextView updateCancel;
    /* access modifiers changed from: private */
    public TextView updateCountryCode;
    private TextView updateMessage;
    private TextView updateNext;
    /* access modifiers changed from: private */
    public MaterialEditText updateNumber;
    /* access modifiers changed from: private */
    public Spinner updateSpinner;
    private View updateView;
    private TextView updatedCountryCode;
    private TextView updatedNumber;
    private String userSelectedInternationalCountryCode;
    private TextView verificationCancel;
    private View verificationView;
    private TextView verificationViewChange;
    private TextView verifiedCancel;
    private TextView verifiedCountryCode;
    private TextView verifiedNumber;
    private TextView verifiedNumberMessage;
    private TextView verifiedThankyouCountryCode;
    private TextView verifiedThankyouNumber;
    private View verifiedView;
    private TextView verifiedmobileThankyouScreenTitle;
    /* access modifiers changed from: private */
    public Button verify;
    /* access modifiers changed from: private */
    public TextView verifyBtnMsg;
    private TextView verifyCallMeMsg;
    private TextView verifyCancel;
    private TextView verifyChange;
    /* access modifiers changed from: private */
    public TextView verifyCountryCode;
    private TextView verifyGetCode;
    private TextView verifyNumber;
    private Spinner verifySpinner;

    private String defaultCountryCode() {
        if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
            return "+965";
        }
        if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
            return "+966";
        }
        if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
            return "+973";
        }
        if (GlobalDataModel.SelectedCountryId == Country.OMAN.getCountryId()) {
            return "+968";
        }
        if (GlobalDataModel.SelectedCountryId == Country.QATAR.getCountryId()) {
            return "+974";
        }
        if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId()) {
            return "+971";
        }
        if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
            return "+962";
        }
        if (GlobalDataModel.SelectedCountryId == Country.EGYPT.getCountryId()) {
            return "+20";
        }
        if (GlobalDataModel.SelectedCountryId == Country.IRAQ.getCountryId()) {
            return "+964";
        }
        return "";
    }

    private void flipToMobileNumberVerificationPopUp() {
        showVerificationPopup();
    }

    /* access modifiers changed from: private */
    public boolean getCountryCodeType(String str) {
        if (!str.contains("+")) {
            str = "+" + str;
        }
        this.allCountriesList = new ArrayList<>();
        this.f54406j = new ArrayList<>();
        try {
            this.allCountriesList = new ArrayList<>();
            String loadJSONFromAsset = TalabatUtils.loadJSONFromAsset(getContext());
            if (loadJSONFromAsset == null || loadJSONFromAsset.length() <= 0) {
                return false;
            }
            JSONArray jSONArray = new JSONArray(loadJSONFromAsset);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                String optString = jSONObject.optString("dialCode");
                boolean optBoolean = jSONObject.optBoolean("isGcc");
                CountryCode countryCode2 = new CountryCode();
                countryCode2.isGccCountry = optBoolean;
                countryCode2.dialCode = optString;
                this.allCountriesList.add(countryCode2);
            }
            ArrayList<CountryCode> arrayList = this.allCountriesList;
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            Iterator<CountryCode> it = this.allCountriesList.iterator();
            while (it.hasNext()) {
                CountryCode next = it.next();
                if (str.equals(next.dialCode)) {
                    return next.isGccCountry;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private String getShopIdForTracking() {
        Cart instance = Cart.getInstance();
        if (instance == null || instance.getRestaurant() == null) {
            return "N/A";
        }
        return "" + instance.getRestaurant().f13872id;
    }

    private boolean getTimeDifference(long j11, long j12) {
        int i11 = ((int) ((j11 - j12) / 1000)) % 60;
        int i12 = SmsVerificationInstance.previousSecond;
        if (i12 <= 0 || i12 <= i11) {
            return false;
        }
        this.f54411o = i12 - i11;
        return true;
    }

    private void mobileNumberVerifiedThankYouPage(boolean z11, final String str, boolean z12, boolean z13) {
        String str2;
        String str3;
        stopLodingPopup();
        this.f54413q = null;
        View view = this.updateView;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.initialVerificationView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.verificationView;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        this.verifiedView.setVisibility(0);
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.verifiedThankyouNumber.setText(str);
        }
        if (!TalabatUtils.isNullOrEmpty(this.countryCode)) {
            if (this.countryCode.contains("+")) {
                this.verifiedThankyouCountryCode.setText(this.countryCode);
            } else {
                this.verifiedThankyouCountryCode.setText("+" + this.countryCode);
            }
        }
        if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.f54415s, this.f54417u)) {
            this.updateCountryCode.setTextColor(getResources().getColor(R.color.talabat_black));
        } else {
            this.updateCountryCode.setTextColor(getResources().getColor(R.color.talabat_grey));
        }
        if (z12) {
            if (this.isQuickOrder) {
                str2 = this.f54408l.address.areaName;
            } else {
                str2 = Customer.getInstance().getSelectedCustomerAddress().profileName + "(" + GlobalDataModel.SelectedAreaName + ")";
            }
            this.verifiedmobileThankyouScreenTitle.setText(getResources().getString(R.string.verify_mobile_no_verified));
            if (!TalabatUtils.isNullOrEmpty(str2)) {
                str3 = getString(R.string.number_update_already_verified).replace("#", str2);
            } else {
                str3 = getString(R.string.number_update_already_verified);
            }
            this.verifiedNumberMessage.setText(str3);
            AppTracker.onMobileNumberVerificationValidated(getContext(), getShopIdForTracking());
        } else {
            this.verifiedmobileThankyouScreenTitle.setText(getResources().getString(R.string.verify_mobile_no_success_title));
            this.verifiedNumberMessage.setText(getResources().getString(R.string.mobile_no_thank_you_verify_title));
            AppTracker.onMobileNumberVerificationValidated(getContext(), getShopIdForTracking());
        }
        if (z13) {
            this.verifiedmobileThankyouScreenTitle.setText(getResources().getString(R.string.verify_mobile_no_verified));
        }
        this.mobileverifiedThankyouContinueBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                if (MobileNumberVerification.this.isNeedToUpdateMobChekckout) {
                    intent.putExtra("isUpdateCheckOut", MobileNumberVerification.this.isNeedToUpdateMobChekckout);
                    intent.putExtra("updatedMobileNo", str);
                }
                MobileNumberVerification.this.setResult(-1, intent);
                MobileNumberVerification.this.finish();
            }
        });
    }

    private void showInitialVerificationPopUp() {
        this.f54413q = null;
        this.continueTimer = true;
        this.initialVerificationView.setVisibility(0);
        if (!TalabatUtils.isNullOrEmpty(this.countryCode)) {
            if (this.countryCode.contains("+")) {
                this.verifyCountryCode.setText(this.countryCode);
            } else {
                TextView textView = this.verifyCountryCode;
                textView.setText("+" + this.countryCode);
            }
        }
        this.verifyNumber.setText(this.f54407k);
        this.verifyGetCode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MobileNumberVerification.this.startLodingPopup();
                AppTracker.onGetCodeClicked(MobileNumberVerification.this);
                INumberVerificationPresenter G = MobileNumberVerification.this.numberVerificationPresenter;
                MobileNumberVerification mobileNumberVerification = MobileNumberVerification.this;
                G.onGetCodeForMobileNumberClicked(mobileNumberVerification.f54407k, 1, mobileNumberVerification.countryCode, MobileNumberVerification.this.smsToken, MobileNumberVerification.this.encryptedMobile);
            }
        });
        this.verifyCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MobileNumberVerification.this.finish();
            }
        });
        this.verifyChange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppTracker.onVerificationChangeSelected(MobileNumberVerification.this);
                MobileNumberVerification.this.updateMobileNumberPopup(true, false, "");
            }
        });
    }

    private void showVerificationPopup() {
        this.continueTimer = true;
        if (this.verificationView.getVisibility() == 8) {
            View view = this.initialVerificationView;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.updateView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (!TalabatUtils.isNullOrEmpty(this.countryCode)) {
                if (this.countryCode.contains("+")) {
                    this.verifiedCountryCode.setText(this.countryCode);
                } else {
                    TextView textView = this.verifiedCountryCode;
                    textView.setText("+" + this.countryCode);
                }
            }
            this.verificationView.setVisibility(0);
            this.verify.setEnabled(false);
            this.verify.setAlpha(0.5f);
            if (this.isFirst || SmsVerificationInstance.previousSecond > 0) {
                startTimer();
            } else {
                this.resendLabel.setTextColor(getResources().getColor(R.color.talabat_black));
                this.callMeLabel.setTextColor(getResources().getColor(R.color.talabat_black));
                this.livechatCounter.setTextColor(getResources().getColor(R.color.talabat_black));
                this.liveChatCounterLabel.setTextColor(getResources().getColor(R.color.talabat_black));
                this.resendImg.setImageResource(R.drawable.icon_resendcode_enabled);
                this.callMeImg.setImageResource(R.drawable.icon_callme_enabled);
                this.liveChatImg.setImageResource(R.drawable.icon_livechat);
                this.resendCodeView.setEnabled(true);
                this.callMeView.setEnabled(true);
                this.callMeView.setClickable(true);
                this.LiveChatView.setEnabled(true);
                this.LiveChatView.setClickable(true);
                this.resendCodeView.setClickable(true);
            }
            this.verifiedNumber.setText(this.f54407k);
            this.verify.setClickable(false);
            this.verify.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MobileNumberVerification.this.startLodingPopup();
                    MobileNumberVerification.this.numberVerificationPresenter.verifyMobileNumberWithCodeClicked(MobileNumberVerification.this.countryCode, MobileNumberVerification.this.f54405i.getText().toString(), MobileNumberVerification.this.f54407k);
                }
            });
            this.verificationViewChange.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AppTracker.onVerificationChangeSelected(MobileNumberVerification.this);
                    MobileNumberVerification.this.updateMobileNumberPopup(false, false, "");
                }
            });
            this.resendCodeView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MobileNumberVerification.this.startLodingPopup();
                    AppTracker.onOtherVerificationOptionSelected(MobileNumberVerification.this, "Resend Code");
                    MobileNumberVerification.this.isFromCallOption = false;
                    MobileNumberVerification.this.restartTimer();
                    INumberVerificationPresenter G = MobileNumberVerification.this.numberVerificationPresenter;
                    MobileNumberVerification mobileNumberVerification = MobileNumberVerification.this;
                    G.onGetCodeForMobileNumberClicked(mobileNumberVerification.f54407k, 3, mobileNumberVerification.countryCode, MobileNumberVerification.this.smsToken, MobileNumberVerification.this.encryptedMobile);
                }
            });
            this.callMeView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MobileNumberVerification.this.startLodingPopup();
                    AppTracker.onOtherVerificationOptionSelected(MobileNumberVerification.this, "Call Me");
                    MobileNumberVerification.this.isFromCallOption = true;
                    MobileNumberVerification.this.restartTimer();
                    INumberVerificationPresenter G = MobileNumberVerification.this.numberVerificationPresenter;
                    MobileNumberVerification mobileNumberVerification = MobileNumberVerification.this;
                    G.onGetCodeForMobileNumberClicked(mobileNumberVerification.f54407k, 2, mobileNumberVerification.countryCode, MobileNumberVerification.this.smsToken, MobileNumberVerification.this.encryptedMobile);
                }
            });
            this.LiveChatView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String str;
                    AppTracker.onOtherVerificationOptionSelected(MobileNumberVerification.this, "Live Chat");
                    MobileNumberVerification.this.isFromCallOption = false;
                    MobileNumberVerification.this.restartTimer();
                    if (!TalabatUtils.isNullOrEmpty(MobileNumberVerification.this.f54407k)) {
                        str = MobileNumberVerification.this.getString(R.string.live_chat_default_message).replace("#", MobileNumberVerification.this.f54407k);
                    } else {
                        str = MobileNumberVerification.this.getString(R.string.live_chat_default_message);
                    }
                    MobileNumberVerification.this.numberVerificationPresenter.onRedirectToLiveChatForMobileVerification(str, MobileNumberVerification.this.countryCode, MobileNumberVerification.this.f54407k);
                }
            });
            this.f54405i.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    if (editable.toString().length() == 4) {
                        MobileNumberVerification.this.verify.setEnabled(true);
                        MobileNumberVerification.this.verify.setAlpha(1.0f);
                        MobileNumberVerification.this.verify.setClickable(true);
                        MobileNumberVerification.this.startLodingPopup();
                        MobileNumberVerification.this.numberVerificationPresenter.verifyMobileNumberWithCodeClicked(MobileNumberVerification.this.countryCode, MobileNumberVerification.this.f54405i.getText().toString(), MobileNumberVerification.this.f54407k);
                        return;
                    }
                    MobileNumberVerification.this.verify.setEnabled(false);
                    MobileNumberVerification.this.verify.setAlpha(0.5f);
                    MobileNumberVerification.this.verify.setClickable(false);
                    MobileNumberVerification.this.verifyBtnMsg.setText(MobileNumberVerification.this.getString(R.string.verify_code_message));
                    MobileNumberVerification.this.verifyBtnMsg.setTextColor(MobileNumberVerification.this.getResources().getColor(R.color.talabat_grey));
                }

                public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }

                public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }
            });
            this.verifiedCancel.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MobileNumberVerification mobileNumberVerification = MobileNumberVerification.this;
                    int i11 = mobileNumberVerification.f54411o;
                    if (i11 > 0 && i11 < mobileNumberVerification.f54412p) {
                        SmsVerificationInstance smsVerificationInstance = mobileNumberVerification.f54413q;
                        SmsVerificationInstance.userMobileNumber = mobileNumberVerification.f54407k;
                        SmsVerificationInstance.timeStamp = System.currentTimeMillis();
                        MobileNumberVerification mobileNumberVerification2 = MobileNumberVerification.this;
                        SmsVerificationInstance smsVerificationInstance2 = mobileNumberVerification2.f54413q;
                        SmsVerificationInstance.previousSecond = mobileNumberVerification2.f54411o;
                        SmsVerificationInstance.isFirst = false;
                    }
                    Intent intent = new Intent();
                    if (MobileNumberVerification.this.isNeedToUpdateMobChekckout) {
                        intent.putExtra("isUpdateCheckOut", MobileNumberVerification.this.isNeedToUpdateMobChekckout);
                        intent.putExtra("updatedMobileNo", MobileNumberVerification.this.f54407k);
                    }
                    MobileNumberVerification.this.setResult(-1, intent);
                    MobileNumberVerification.this.finish();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void updateMobileNumber() {
        startLodingPopup();
        if (this.isQuickOrder) {
            INumberVerificationPresenter iNumberVerificationPresenter = this.numberVerificationPresenter;
            String obj = this.updateNumber.getText().toString();
            iNumberVerificationPresenter.onMobileCheck(obj, "" + GlobalDataModel.SelectedCountryId, this.quickOrderString, this.isQuickOrder, -3, this.countryCode, this.smsToken, this.encryptedMobile);
            return;
        }
        this.numberVerificationPresenter.updateMobileNumberClicked(Customer.getInstance().getSelectedCustomerAddress().f58343id, this.updateNumber.getText().toString(), this.countryCode, this.smsToken, this.encryptedMobile);
    }

    /* access modifiers changed from: private */
    public void updateMobileNumberPopup(final boolean z11, boolean z12, String str) {
        String str2;
        String str3;
        View view = this.initialVerificationView;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.verificationView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        this.updateView.setVisibility(0);
        this.updateNumber.setText(this.f54407k);
        if (z12 && !TalabatUtils.isNullOrEmpty(str)) {
            if (TalabatUtils.isRTL()) {
                TextView textView = this.arabicErrorTxt;
                if (textView != null) {
                    textView.setVisibility(0);
                    this.arabicErrorTxt.setText(str);
                }
            } else {
                MaterialEditText materialEditText = this.updateNumber;
                if (materialEditText != null) {
                    materialEditText.setError(str);
                }
            }
        }
        if (!TalabatUtils.isNullOrEmpty(this.countryCode)) {
            this.updateCountryCode.setTextColor(getResources().getColor(R.color.talabat_grey));
            if (this.countryCode.contains("+")) {
                this.updateCountryCode.setText(this.countryCode);
            } else {
                this.updateCountryCode.setText("+" + this.countryCode);
            }
        }
        if (this.isQuickOrder) {
            str2 = this.f54408l.address.areaName;
        } else {
            str2 = Customer.getInstance().getSelectedCustomerAddress().profileName + "(" + GlobalDataModel.SelectedAreaName + ")";
        }
        if (!TalabatUtils.isNullOrEmpty(str2)) {
            str3 = getString(R.string.verify_mobile_change_messgae).replace("#", str2);
        } else {
            str3 = "";
        }
        this.updateMessage.setText(str3);
        this.updateNumber.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                if (MobileNumberVerification.this.arabicErrorTxt != null) {
                    MobileNumberVerification.this.arabicErrorTxt.setVisibility(8);
                }
            }
        });
        this.updateNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!TalabatUtils.isNullOrEmpty(MobileNumberVerification.this.updateNumber.getText().toString())) {
                    MobileNumberVerification mobileNumberVerification = MobileNumberVerification.this;
                    if (!mobileNumberVerification.f54407k.equals(mobileNumberVerification.updateNumber.getText().toString())) {
                        MobileNumberVerification mobileNumberVerification2 = MobileNumberVerification.this;
                        if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(mobileNumberVerification2.f54415s, mobileNumberVerification2.f54417u)) {
                            MobileNumberVerification mobileNumberVerification3 = MobileNumberVerification.this;
                            if (mobileNumberVerification3.getCountryCodeType(mobileNumberVerification3.countryCode)) {
                                MobileNumberVerification.this.updateMobileNumber();
                            } else if (MobileNumberVerification.this.updateNumber.getText().toString().length() <= 0 || MobileNumberVerification.this.updateNumber.getText().toString().length() > 5) {
                                MobileNumberVerification.this.updateMobileNumber();
                            } else if (TalabatUtils.isRTL()) {
                                if (MobileNumberVerification.this.arabicErrorTxt != null) {
                                    MobileNumberVerification.this.arabicErrorTxt.setVisibility(0);
                                    MobileNumberVerification.this.arabicErrorTxt.setText(MobileNumberVerification.this.getResources().getString(R.string.uae_international_validation));
                                }
                            } else if (MobileNumberVerification.this.updateNumber != null) {
                                MobileNumberVerification.this.updateNumber.setErrorColor(MobileNumberVerification.this.getResources().getColor(R.color.talabat_red));
                                MobileNumberVerification.this.updateNumber.setError(MobileNumberVerification.this.getResources().getString(R.string.uae_international_validation));
                                MobileNumberVerification.this.updateNumber.setHintTextColor(-65536);
                            }
                        } else {
                            MobileNumberVerification.this.updateMobileNumber();
                        }
                    } else if (TalabatUtils.isRTL()) {
                        if (MobileNumberVerification.this.arabicErrorTxt != null) {
                            MobileNumberVerification.this.arabicErrorTxt.setVisibility(0);
                            MobileNumberVerification.this.arabicErrorTxt.setText(MobileNumberVerification.this.getResources().getString(R.string.update_error_msg));
                        }
                    } else if (MobileNumberVerification.this.updateNumber != null) {
                        MobileNumberVerification.this.updateNumber.setErrorColor(MobileNumberVerification.this.getResources().getColor(R.color.talabat_red));
                        MobileNumberVerification.this.updateNumber.setError(MobileNumberVerification.this.getResources().getString(R.string.update_error_msg));
                        MobileNumberVerification.this.updateNumber.setHintTextColor(-65536);
                    }
                } else if (TalabatUtils.isRTL()) {
                    if (MobileNumberVerification.this.arabicErrorTxt != null) {
                        MobileNumberVerification.this.arabicErrorTxt.setVisibility(0);
                        MobileNumberVerification.this.arabicErrorTxt.setText(MobileNumberVerification.this.getResources().getString(R.string.required));
                    }
                } else if (MobileNumberVerification.this.updateNumber != null) {
                    MobileNumberVerification.this.updateNumber.setErrorColor(MobileNumberVerification.this.getResources().getColor(R.color.talabat_red));
                    MobileNumberVerification.this.updateNumber.requestFocus();
                    MobileNumberVerification.this.updateNumber.setError(MobileNumberVerification.this.getResources().getString(R.string.required));
                    MobileNumberVerification.this.updateNumber.setHintTextColor(-65536);
                }
            }
        });
        this.updateCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MobileNumberVerification.this.updatePoupCancelClicked(z11);
            }
        });
    }

    /* access modifiers changed from: private */
    public void updatePoupCancelClicked(boolean z11) {
        int i11 = this.f54411o;
        if (i11 > 0 && i11 < this.f54412p) {
            SmsVerificationInstance.userMobileNumber = this.f54407k;
            SmsVerificationInstance.timeStamp = System.currentTimeMillis();
            SmsVerificationInstance.previousSecond = this.f54411o;
            SmsVerificationInstance.isFirst = false;
        }
        View view = this.updateView;
        if (view != null) {
            view.setVisibility(8);
        }
        if (z11) {
            showInitialVerificationPopUp();
        } else {
            showVerificationPopup();
        }
    }

    private boolean usedNumber() {
        try {
            if (this.f54413q == null || TalabatUtils.isNullOrEmpty(SmsVerificationInstance.userMobileNumber) || !SmsVerificationInstance.userMobileNumber.equals(this.f54407k)) {
                return false;
            }
            getTimeDifference(System.currentTimeMillis(), SmsVerificationInstance.timeStamp);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void destroyPresenter() {
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.SCREEN_TYPE_MOBILE_NUMBER_VERIFICATION;
    }

    public void hideMobileNumberVerificationCodePopup(String str, int i11, boolean z11, boolean z12, boolean z13) {
        this.isNeedToUpdateMobChekckout = z11;
        mobileNumberVerifiedThankYouPage(z12, str, z12, z13);
    }

    public void initialiseTimer() {
        Handler handler;
        Runnable runnable = this.f54410n;
        if (!(runnable == null || (handler = this.f54409m) == null)) {
            handler.removeCallbacks(runnable);
        }
        this.f54409m = null;
        this.f54410n = null;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        PinEntryEditText pinEntryEditText;
        super.onActivityResult(i11, i12, intent);
        if (i11 == LIVE_CHAT && intent != null) {
            String stringExtra = intent.getStringExtra("verificationCode");
            if (!TalabatUtils.isNullOrEmpty(stringExtra) && (pinEntryEditText = this.f54405i) != null) {
                pinEntryEditText.setText(stringExtra);
            }
        }
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        int i11 = this.f54411o;
        if (i11 > 0 && i11 < this.f54412p) {
            SmsVerificationInstance.userMobileNumber = this.f54407k;
            SmsVerificationInstance.timeStamp = System.currentTimeMillis();
            SmsVerificationInstance.previousSecond = this.f54411o;
            SmsVerificationInstance.isFirst = false;
        }
        Intent intent = new Intent();
        boolean z11 = this.isNeedToUpdateMobChekckout;
        if (z11) {
            intent.putExtra("isUpdateCheckOut", z11);
            intent.putExtra("updatedMobileNo", this.f54407k);
        }
        setResult(-1, intent);
        super.onBackPressed();
    }

    public void onCreate(@Nullable Bundle bundle) {
        String str;
        Object obj;
        DaggerMobileNumberVerificationScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        try {
            setContentView((int) R.layout.mobile_no_verification_screen);
            this.f54407k = getIntent().getStringExtra("userselectedmobno");
            if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.f54415s, this.f54417u)) {
                this.userSelectedInternationalCountryCode = getIntent().getStringExtra("userSelectedInternationalCountryCode");
            }
            this.isQuickOrder = getIntent().getBooleanExtra("isQuick", false);
            this.isFromAptimize = getIntent().getBooleanExtra("isFromAptimize", false);
            this.smsToken = getIntent().getStringExtra("smsToken");
            this.encryptedMobile = getIntent().getStringExtra("encryptedNumber");
            this.f54413q = SmsVerificationInstance.getSmsInstance();
            if (this.isQuickOrder) {
                Gson gson = UniversalGson.INSTANCE.gson;
                if (getIntent().hasExtra("value")) {
                    str = getIntent().getStringExtra("value");
                } else {
                    str = null;
                }
                this.quickOrderString = str;
                Class cls = QuickOrderInfo.class;
                if (!(gson instanceof Gson)) {
                    obj = gson.fromJson(str, cls);
                } else {
                    obj = GsonInstrumentation.fromJson(gson, str, cls);
                }
                this.f54408l = (QuickOrderInfo) obj;
            }
            this.verifyCountryCode = (TextView) findViewById(R.id.verify_country_code);
            this.verifyNumber = (TextView) findViewById(R.id.verify_number);
            this.verifyChange = (TextView) findViewById(R.id.verify_change_button);
            this.verifyGetCode = (TextView) findViewById(R.id.get_code);
            this.verifyCancel = (TextView) findViewById(R.id.verify_cancel);
            this.livechatCounter = (TextView) findViewById(R.id.live_chat_counter);
            this.updateCountryCode = (TextView) findViewById(R.id.update_country_code);
            this.updateNumber = (MaterialEditText) findViewById(R.id.update_number);
            this.updateCancel = (TextView) findViewById(R.id.update_cancel);
            this.updateNext = (TextView) findViewById(R.id.next);
            this.updateMessage = (TextView) findViewById(R.id.updated_message);
            this.verifiedCountryCode = (TextView) findViewById(R.id.otp_country_code);
            this.verifiedNumber = (TextView) findViewById(R.id.otp_number);
            this.verifiedCancel = (TextView) findViewById(R.id.otp_cancel);
            this.verify = (Button) findViewById(R.id.otp_verify);
            this.resendCodeView = findViewById(R.id.resend_code_view);
            this.callMeView = findViewById(R.id.call_me_view);
            this.LiveChatView = findViewById(R.id.live_chat_view);
            this.resendCounter = (TextView) findViewById(R.id.resend_counter);
            this.callMeCounter = (TextView) findViewById(R.id.callme_counter);
            this.mobileverifiedThankyouContinueBtn = (TextView) findViewById(R.id.continue_button);
            this.verifiedThankyouNumber = (TextView) findViewById(R.id.updated_thankyou_number);
            this.verifiedThankyouCountryCode = (TextView) findViewById(R.id.updated_thankyou_country_code);
            this.initialVerificationView = findViewById(R.id.verify_number_initial_view);
            this.rootLayout = findViewById(R.id.root_layout);
            this.updateView = findViewById(R.id.update_mob_no_main_view);
            this.verifiedView = findViewById(R.id.updated_number_view);
            this.verificationView = findViewById(R.id.otp_view);
            this.verifiedmobileThankyouScreenTitle = (TextView) findViewById(R.id.mobile_thankyou_screen_title);
            this.verifiedNumberMessage = (TextView) findViewById(R.id.verified_number_message);
            this.f54405i = (PinEntryEditText) findViewById(R.id.txt_pin_entry);
            this.resendLabel = (TextView) findViewById(R.id.resend_me_label);
            this.callMeLabel = (TextView) findViewById(R.id.call_me_label);
            this.resendImg = (ImageView) findViewById(R.id.resend_img);
            this.callMeImg = (ImageView) findViewById(R.id.call_me_img);
            this.verificationViewChange = (TextView) findViewById(R.id.otp_change);
            this.verifyBtnMsg = (TextView) findViewById(R.id.verify_enter_4_digits_msg);
            this.verifySpinner = (Spinner) findViewById(R.id.country_code_spinner);
            this.updateSpinner = (Spinner) findViewById(R.id.country_code_update_spinner);
            this.liveChatCounterLabel = (TextView) findViewById(R.id.live_chat_label);
            this.liveChatImg = (ImageView) findViewById(R.id.live_chat_image);
            this.arabicErrorTxt = (TextView) findViewById(R.id.arabic_error_txt);
            setCountryCode();
            NumberVerificationPresenter numberVerificationPresenter2 = new NumberVerificationPresenter(this.f54414r, this);
            this.numberVerificationPresenter = numberVerificationPresenter2;
            numberVerificationPresenter2.setFromAptimize(this.isFromAptimize);
            this.verifySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
                    MobileNumberVerification.this.verifyCountryCode.setText(((CountryCode) MobileNumberVerification.this.allCountriesList.get(i11)).dialCode);
                    MobileNumberVerification mobileNumberVerification = MobileNumberVerification.this;
                    mobileNumberVerification.countryCode = ((CountryCode) mobileNumberVerification.allCountriesList.get(i11)).dialCode;
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.updateCountryCode.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId()) {
                        MobileNumberVerification.this.updateSpinner.performClick();
                    }
                }
            });
            this.updateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
                    MobileNumberVerification.this.updateCountryCode.setText(((CountryCode) MobileNumberVerification.this.allCountriesList.get(i11)).dialCode);
                    MobileNumberVerification mobileNumberVerification = MobileNumberVerification.this;
                    mobileNumberVerification.countryCode = ((CountryCode) mobileNumberVerification.allCountriesList.get(i11)).dialCode;
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.updateNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
            if (usedNumber()) {
                showVerificationPopup();
            } else {
                this.isFirst = true;
                showInitialVerificationPopUp();
            }
            AppTracker.onVerificationPopupShown(this, getShopIdForTracking());
            this.callMeView.setVisibility(0);
        } catch (Exception unused) {
        }
    }

    public void onError() {
    }

    public void onMobileNumberValidationFailedOnGetCode(String str, int i11, String str2) {
        stopLodingPopup();
        updateMobileNumberPopup(true, true, str);
    }

    public void onMobileVerificationCheckFailed(String str, int i11) {
        TextView textView;
        stopLodingPopup();
        this.f54405i.setText("");
        if (i11 == -2 && (textView = this.verifyBtnMsg) != null) {
            textView.setText(getString(R.string.mobile_no_verify_error_title));
            this.verifyBtnMsg.setTextColor(getResources().getColor(R.color.talabat_red));
            AppTracker.mobileVerificationFailed(getContext(), getShopIdForTracking());
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onRedirectToLiveChatForMobileVerification(String str, String str2, String str3) {
    }

    public void onResume() {
        pauseBannerForNextScreen();
        super.onResume();
        if (this.isFromCallOption) {
            startLodingPopup();
            INumberVerificationPresenter iNumberVerificationPresenter = this.numberVerificationPresenter;
            String str = this.f54407k;
            iNumberVerificationPresenter.onMobileCheck(str, "" + GlobalDataModel.SelectedCountryId, this.quickOrderString, this.isQuickOrder, 2, this.countryCode, this.smsToken, this.encryptedMobile);
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onValidationError(String str, int i11) {
        stopLodingPopup();
        if (TalabatUtils.isNullOrEmpty(str)) {
            return;
        }
        if (i11 == -4) {
            if (TalabatUtils.isRTL()) {
                TextView textView = this.arabicErrorTxt;
                if (textView != null) {
                    textView.setVisibility(0);
                    this.arabicErrorTxt.setText(str);
                    return;
                }
                return;
            }
            MaterialEditText materialEditText = this.updateNumber;
            if (materialEditText != null) {
                materialEditText.setError(str);
            }
        } else if (i11 == -8) {
            updateMobileNumberPopup(true, false, "");
            if (TalabatUtils.isRTL()) {
                TextView textView2 = this.arabicErrorTxt;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                    this.arabicErrorTxt.setText(str);
                    return;
                }
                return;
            }
            MaterialEditText materialEditText2 = this.updateNumber;
            if (materialEditText2 != null) {
                materialEditText2.setError(str);
            }
        } else {
            Toast.makeText(this, str, 0).show();
        }
    }

    public void restartTimer() {
        this.f54411o = this.f54412p;
        stopTimer();
        startTimer();
    }

    public void setCountryCode() {
        ArrayList<CountryCode> arrayList = this.allCountriesList;
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                for (int i11 = 0; i11 < this.allCountriesList.size(); i11++) {
                    if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+965")) {
                            this.verifySpinner.setSelection(i11);
                            this.updateSpinner.setSelection(i11);
                        }
                    } else if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+966")) {
                            this.verifySpinner.setSelection(i11);
                            this.updateSpinner.setSelection(i11);
                        }
                    } else if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+973")) {
                            this.verifySpinner.setSelection(i11);
                            this.updateSpinner.setSelection(i11);
                        }
                    } else if (GlobalDataModel.SelectedCountryId == Country.OMAN.getCountryId()) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+968")) {
                            this.verifySpinner.setSelection(i11);
                            this.updateSpinner.setSelection(i11);
                        }
                    } else if (GlobalDataModel.SelectedCountryId == Country.QATAR.getCountryId()) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+974")) {
                            this.verifySpinner.setSelection(i11);
                            this.updateSpinner.setSelection(i11);
                        }
                    } else if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId()) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+971")) {
                            this.verifySpinner.setSelection(i11);
                            this.updateSpinner.setSelection(i11);
                        }
                    } else if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+962")) {
                            this.verifySpinner.setSelection(i11);
                            this.updateSpinner.setSelection(i11);
                        }
                    } else if (GlobalDataModel.SelectedCountryId == Country.EGYPT.getCountryId()) {
                        if (this.allCountriesList.get(i11).dialCode.equals("+20")) {
                            this.verifySpinner.setSelection(i11);
                            this.updateSpinner.setSelection(i11);
                        }
                    } else if (GlobalDataModel.SelectedCountryId == Country.IRAQ.getCountryId() && this.allCountriesList.get(i11).dialCode.equals("+964")) {
                        this.verifySpinner.setSelection(i11);
                        this.updateSpinner.setSelection(i11);
                    }
                }
            }
        } else if (!TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.f54415s, this.f54417u)) {
            this.countryCode = defaultCountryCode();
        } else if (TalabatUtils.isNullOrEmpty(this.userSelectedInternationalCountryCode)) {
            this.countryCode = defaultCountryCode();
        } else {
            this.countryCode = this.userSelectedInternationalCountryCode;
        }
    }

    public void showMobileNumberVerificationCodePopup(String str, int i11, int i12) {
        this.f54411o = 30;
        this.f54412p = 30;
        stopLodingPopup();
        if (i11 == 1) {
            this.isFromCallOption = false;
        } else if (i11 == 2) {
            this.isFromCallOption = true;
        } else if (i11 == 3) {
            this.isFromCallOption = false;
        }
        flipToMobileNumberVerificationPopUp();
    }

    public void startTimer() {
        if (this.f54411o > 0) {
            initialiseTimer();
            this.f54409m = new Handler();
            AnonymousClass18 r02 = new Runnable() {
                public void run() {
                    MobileNumberVerification mobileNumberVerification = MobileNumberVerification.this;
                    int i11 = mobileNumberVerification.f54411o - 1;
                    mobileNumberVerification.f54411o = i11;
                    if (i11 < 0 || !mobileNumberVerification.continueTimer) {
                        MobileNumberVerification.this.f54409m.removeCallbacks(this);
                        MobileNumberVerification mobileNumberVerification2 = MobileNumberVerification.this;
                        SmsVerificationInstance smsVerificationInstance = mobileNumberVerification2.f54413q;
                        SmsVerificationInstance.isFirst = false;
                        SmsVerificationInstance.previousSecond = 0;
                        mobileNumberVerification2.resendCounter.setVisibility(8);
                        MobileNumberVerification.this.callMeCounter.setVisibility(8);
                        MobileNumberVerification.this.livechatCounter.setVisibility(8);
                        MobileNumberVerification.this.resendLabel.setTextColor(MobileNumberVerification.this.getResources().getColor(R.color.talabat_black));
                        MobileNumberVerification.this.callMeLabel.setTextColor(MobileNumberVerification.this.getResources().getColor(R.color.talabat_black));
                        MobileNumberVerification.this.livechatCounter.setTextColor(MobileNumberVerification.this.getResources().getColor(R.color.talabat_black));
                        MobileNumberVerification.this.liveChatCounterLabel.setTextColor(MobileNumberVerification.this.getResources().getColor(R.color.talabat_black));
                        MobileNumberVerification.this.resendImg.setImageResource(R.drawable.icon_resendcode_enabled);
                        MobileNumberVerification.this.callMeImg.setImageResource(R.drawable.icon_callme_enabled);
                        MobileNumberVerification.this.liveChatImg.setImageResource(R.drawable.icon_livechat);
                        MobileNumberVerification.this.resendCodeView.setEnabled(true);
                        MobileNumberVerification.this.callMeView.setEnabled(true);
                        MobileNumberVerification.this.callMeView.setClickable(true);
                        MobileNumberVerification.this.LiveChatView.setEnabled(true);
                        MobileNumberVerification.this.LiveChatView.setClickable(true);
                        MobileNumberVerification.this.resendCodeView.setClickable(true);
                        return;
                    }
                    MobileNumberVerification.this.timedOut = false;
                    String valueOf = String.valueOf(MobileNumberVerification.this.f54411o);
                    MobileNumberVerification.this.resendCounter.setText(valueOf);
                    MobileNumberVerification.this.callMeCounter.setText(valueOf);
                    MobileNumberVerification.this.livechatCounter.setText(valueOf);
                    MobileNumberVerification.this.resendCodeView.setEnabled(false);
                    MobileNumberVerification.this.resendCodeView.setClickable(false);
                    MobileNumberVerification.this.callMeView.setClickable(false);
                    MobileNumberVerification.this.callMeView.setEnabled(false);
                    MobileNumberVerification.this.LiveChatView.setEnabled(false);
                    MobileNumberVerification.this.LiveChatView.setClickable(false);
                    MobileNumberVerification.this.resendLabel.setTextColor(MobileNumberVerification.this.getResources().getColor(R.color.talabat_grey));
                    MobileNumberVerification.this.callMeLabel.setTextColor(MobileNumberVerification.this.getResources().getColor(R.color.talabat_grey));
                    MobileNumberVerification.this.resendImg.setImageResource(R.drawable.icon_resendcode_disabled);
                    MobileNumberVerification.this.callMeImg.setImageResource(R.drawable.icon_callme_disabled);
                    MobileNumberVerification.this.liveChatImg.setImageResource(R.drawable.icon_livechat_disabled);
                    MobileNumberVerification.this.resendCounter.setVisibility(0);
                    MobileNumberVerification.this.callMeCounter.setVisibility(0);
                    MobileNumberVerification.this.livechatCounter.setVisibility(0);
                    MobileNumberVerification.this.liveChatCounterLabel.setVisibility(0);
                    MobileNumberVerification.this.livechatCounter.setTextColor(MobileNumberVerification.this.getResources().getColor(R.color.talabat_grey));
                    MobileNumberVerification.this.liveChatCounterLabel.setTextColor(MobileNumberVerification.this.getResources().getColor(R.color.talabat_grey));
                    MobileNumberVerification.this.f54409m.postDelayed(this, 1000);
                }
            };
            this.f54410n = r02;
            r02.run();
        }
    }

    public void stopTimer() {
        Handler handler;
        Runnable runnable = this.f54410n;
        if (!(runnable == null || (handler = this.f54409m) == null)) {
            handler.removeCallbacks(runnable);
        }
        this.continueTimer = true;
    }

    public void updateMobielNumbeVerifcationFailed(String str, int i11, String str2, boolean z11, String str3, String str4) {
        this.isNeedToUpdateMobChekckout = z11;
        this.f54407k = str;
        stopLodingPopup();
        showVerificationPopup();
        this.smsToken = str3;
        this.encryptedMobile = str4;
        restartTimer();
        this.numberVerificationPresenter.onGetCodeForMobileNumberClicked(this.f54407k, 1, this.countryCode, this.smsToken, this.encryptedMobile);
    }

    public void updateMobielNumbeVerifcationSuccess(String str, int i11, boolean z11, boolean z12) {
        stopLodingPopup();
        this.isNeedToUpdateMobChekckout = true;
        mobileNumberVerifiedThankYouPage(z12, str, z12, false);
    }
}
