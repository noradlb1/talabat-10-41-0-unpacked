package com.talabat;

import JsonModels.GiftVoucherThankyouResponse;
import JsonModels.parser.UniversalGson;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.gson.Gson;
import com.materialedittext.MaterialEditText;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.di.voucher.DaggerGiftVoucherDetailsScreenComponent;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import com.talabat.wallet.bnplmanager.presentation.viewmodel.BNPLManagerViewModel;
import datamodels.GiftVoucherItem;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.giftvoucher.GiftVoucherPresenter;
import library.talabat.mvp.giftvoucher.GiftVoucherView;
import library.talabat.mvp.giftvoucher.IGiftVoucherPresenter;
import tracking.ScreenNames;

@Instrumented
public class GiftVoucherDetailsScreen extends TalabatBase implements GiftVoucherView {
    private static final int PAYMENTPAGE = 300;
    private Button buyVoucher;
    private GiftVoucherItem giftVoucherItem;
    private Gson gson;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f54083i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public TermsAndConditionsConfigurationRepository f54084j;
    private Toolbar mToolbar;
    private MaterialEditText message;
    private TextView paymentTerms;
    /* access modifiers changed from: private */
    public IGiftVoucherPresenter presenter;
    private MaterialEditText recipientEmail;
    private MaterialEditText recipientName;
    private ImageButton selectedVoucher;

    public void destroyPresenter() {
        this.presenter = null;
    }

    public int getGiftVoucherId() {
        return this.giftVoucherItem.f13855id;
    }

    public String getMessage() {
        return this.message.getText().toString().trim();
    }

    public IGlobalPresenter getPresenter() {
        return this.presenter;
    }

    public String getReciepientEmail() {
        return this.recipientEmail.getText().toString().trim();
    }

    public String getReciepientName() {
        return this.recipientName.getText().toString().trim();
    }

    public String getScreenName() {
        return ScreenNames.GIFT_VOUCHER_DETAILS;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 300 && i12 == -1) {
            startLodingPopup();
            this.presenter.onPaymentCompleted();
        }
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        int i11;
        DaggerGiftVoucherDetailsScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) ((ApiContainer) getApplication()).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.voucher_selected_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setBackButton(R.id.back);
            this.selectedVoucher = (ImageButton) findViewById(R.id.selected_voucher);
            this.recipientName = (MaterialEditText) findViewById(R.id.voucher_recipient_name);
            this.recipientEmail = (MaterialEditText) findViewById(R.id.voucher_recipient_email);
            this.message = (MaterialEditText) findViewById(R.id.voucher_personalized_message);
            this.buyVoucher = (Button) findViewById(R.id.buy_voucher_button);
            this.paymentTerms = (TextView) findViewById(R.id.buy_voucher_terms);
            String str = "";
            String checkoutPaymentTermsUrl = this.f54084j.config().checkoutPaymentTermsUrl();
            if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
                str = getString(R.string.by_purchasing_gift_voucher_you).replace("#KNET", getString(R.string.knet));
            } else if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
                str = getString(R.string.by_purchasing_gift_voucher_you).replace("#KNET", getString(R.string.benefit));
            }
            final String replace = checkoutPaymentTermsUrl.replace(BNPLManagerViewModel.BNPL_PAYMENT_METHOD, "1").replace(BNPLManagerViewModel.BNPL_ADDITIONAL_PAYMENT_METHOD, "0");
            SpannableString spannableString = new SpannableString(str + " " + getString(R.string.terms_and_conditions));
            spannableString.setSpan(Integer.valueOf(getResources().getColor(R.color.talabat_rebrand_green)), str.length(), spannableString.length(), 0);
            spannableString.setSpan(new ClickableSpan() {
                public void onClick(View view) {
                    Intent intent = new Intent(GiftVoucherDetailsScreen.this, TWebViewScreen.class);
                    intent.putExtra("url", replace);
                    intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, GiftVoucherDetailsScreen.this.getResources().getString(R.string.about_us_terms_of_use));
                    GiftVoucherDetailsScreen.this.startActivity(intent);
                }

                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(GiftVoucherDetailsScreen.this.getResources().getColor(R.color.talabat_rebrand_green));
                    textPaint.setUnderlineText(false);
                }
            }, str.length() + 1, spannableString.length(), 33);
            this.paymentTerms.setText(spannableString);
            this.paymentTerms.setMovementMethod(LinkMovementMethod.getInstance());
            Gson gson2 = UniversalGson.INSTANCE.gson;
            this.gson = gson2;
            String stringExtra = getIntent().getStringExtra("value");
            Class cls = GiftVoucherItem.class;
            if (!(gson2 instanceof Gson)) {
                obj = gson2.fromJson(stringExtra, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson2, stringExtra, cls);
            }
            this.giftVoucherItem = (GiftVoucherItem) obj;
            this.buyVoucher.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GiftVoucherDetailsScreen.this.presenter.validateFields();
                }
            });
            this.presenter = new GiftVoucherPresenter(this.f54083i, this);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                i11 = extras.getInt("imageId");
            } else {
                i11 = 0;
            }
            this.selectedVoucher.setImageDrawable(getResources().getDrawable(i11));
            this.recipientName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
            this.message.setImeOptions(6);
            this.message.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                    if (i11 != 6) {
                        return false;
                    }
                    GiftVoucherDetailsScreen.this.presenter.validateFields();
                    return false;
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onError() {
    }

    public void onRedirectionToPaymentPage(String str, String str2) {
        stopLodingPopup();
        String string = getString(R.string.debit_card_payment);
        Intent intent = new Intent(this, PaymentWebViewScreen.class);
        intent.putExtra("url", str);
        intent.putExtra("title", string);
        intent.putExtra("paymenttransactionId", str2);
        startActivityForResult(intent, 300);
    }

    public void onRedirectionToThanyouPage(GiftVoucherThankyouResponse giftVoucherThankyouResponse) {
        String str;
        stopLodingPopup();
        Intent intent = new Intent(this, TThankyouScreen.class);
        intent.putExtra("from", getScreenName());
        Gson gson2 = this.gson;
        if (!(gson2 instanceof Gson)) {
            str = gson2.toJson((Object) giftVoucherThankyouResponse);
        } else {
            str = GsonInstrumentation.toJson(gson2, (Object) giftVoucherThankyouResponse);
        }
        intent.putExtra("value", str);
        startActivity(intent);
        finish();
    }

    public void onValidationError(int i11) {
        if (i11 == 60) {
            this.recipientEmail.setErrorColor(getResources().getColor(R.color.talabat_red));
            this.recipientEmail.setError(getResources().getString(R.string.required));
        } else if (i11 == 61) {
            this.recipientName.setErrorColor(getResources().getColor(R.color.talabat_red));
            this.recipientName.setError(getResources().getString(R.string.required));
        } else if (i11 == 62) {
            this.recipientEmail.setErrorColor(getResources().getColor(R.color.talabat_red));
            this.recipientEmail.setError(getString(R.string.enter_valid_email));
        }
    }

    public void onValidationSuccess() {
        startLodingPopup();
    }
}
