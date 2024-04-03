package com.talabat;

import JsonModels.GiftVoucherThankyouResponse;
import JsonModels.parser.UniversalGson;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.exifinterface.media.ExifInterface;
import buisnessmodels.Customer;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.di.purchase.DaggerPurchaseTalabatCreditScreenComponent;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import com.talabat.wallet.bnplmanager.presentation.viewmodel.BNPLManagerViewModel;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.purchasetalabatcredit.IPurchaseTalabatCreditPresenter;
import library.talabat.mvp.purchasetalabatcredit.PurchaseTalabatCreditPresenter;
import library.talabat.mvp.purchasetalabatcredit.PurchaseTalabatCreditView;
import tracking.AppTracker;
import tracking.ScreenNames;

@Instrumented
public class PurchaseTalabatCredit extends TalabatBase implements PurchaseTalabatCreditView {
    private static final int PAYMENTPAGE = 350;
    private Button buyCredit;
    private View contentView;
    private TextView creditAmountText;
    private Gson gson;

    /* renamed from: i  reason: collision with root package name */
    public int f54551i;
    /* access modifiers changed from: private */
    public IPurchaseTalabatCreditPresenter iPurchaseTalabatCreditPresenter;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public AppVersionProvider f54552j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public TermsAndConditionsConfigurationRepository f54553k;
    private View loadingView;
    private Toolbar mToolbar;
    private ImageButton minus;
    private TextView paymentTerms;
    private ImageButton plus;
    private float selectedCreditAmount;
    private TextView talabatCreditDescription;

    public void destroyPresenter() {
        this.iPurchaseTalabatCreditPresenter = null;
    }

    public void dismisLoading() {
        this.loadingView.setVisibility(8);
        this.contentView.setVisibility(0);
    }

    public void displayAmount(String str, int i11, float f11) {
        this.creditAmountText.setText(str);
        this.f54551i = i11;
        this.selectedCreditAmount = f11;
    }

    public IGlobalPresenter getPresenter() {
        return this.iPurchaseTalabatCreditPresenter;
    }

    public String getScreenName() {
        return ScreenNames.PURCHASE_TALABAT_CREDIT;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 != 350) {
            return;
        }
        if (i12 == -1) {
            startLodingPopup();
            this.iPurchaseTalabatCreditPresenter.completedPayment();
            return;
        }
        stopLodingPopup();
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerPurchaseTalabatCreditScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) ((ApiContainer) getApplication()).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.purcahase_talabat_credit);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            this.loadingView = findViewById(R.id.loading_layout);
            this.contentView = findViewById(R.id.content_view);
            this.loadingView.setVisibility(0);
            this.contentView.setVisibility(8);
            this.talabatCreditDescription = (TextView) findViewById(R.id.talabat_credit_description);
            this.paymentTerms = (TextView) findViewById(R.id.talabat_credit_terms);
            setBackButton(R.id.back);
            this.minus = (ImageButton) findViewById(R.id.buy_credit_minus);
            this.plus = (ImageButton) findViewById(R.id.buy_credit_plus);
            this.creditAmountText = (TextView) findViewById(R.id.buy_credit_amount);
            this.buyCredit = (Button) findViewById(R.id.buy_credit_button);
            this.gson = UniversalGson.INSTANCE.gson;
            PurchaseTalabatCreditPresenter purchaseTalabatCreditPresenter = new PurchaseTalabatCreditPresenter(this.f54552j, this);
            this.iPurchaseTalabatCreditPresenter = purchaseTalabatCreditPresenter;
            purchaseTalabatCreditPresenter.setUpViews();
            String str = "";
            final String replace = this.f54553k.config().checkoutPaymentTermsUrl().replace(BNPLManagerViewModel.BNPL_PAYMENT_METHOD, ExifInterface.GPS_MEASUREMENT_2D).replace(BNPLManagerViewModel.BNPL_ADDITIONAL_PAYMENT_METHOD, "0");
            if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
                str = getString(R.string.by_purchasing_credit_you).replace("#KNET", getString(R.string.knet));
            } else if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
                str = getString(R.string.by_purchasing_credit_you).replace("#KNET", getString(R.string.benefit));
            }
            AnonymousClass1 r22 = new ClickableSpan() {
                public void onClick(View view) {
                    Intent intent = new Intent(PurchaseTalabatCredit.this, TWebViewScreen.class);
                    intent.putExtra("url", replace);
                    intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, PurchaseTalabatCredit.this.getResources().getString(R.string.about_us_terms_of_use));
                    PurchaseTalabatCredit.this.startActivity(intent);
                }

                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(PurchaseTalabatCredit.this.getResources().getColor(R.color.talabat_rebrand_green));
                    textPaint.setUnderlineText(false);
                }
            };
            String string = getString(R.string.terms_and_conditions);
            SpannableString spannableString = new SpannableString(str + " " + string);
            spannableString.setSpan(Integer.valueOf(getResources().getColor(R.color.talabat_rebrand_green)), str.length(), spannableString.length(), 0);
            spannableString.setSpan(r22, str.length() + 1, spannableString.length(), 33);
            this.paymentTerms.setText(spannableString);
            this.paymentTerms.setMovementMethod(LinkMovementMethod.getInstance());
            this.minus.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PurchaseTalabatCredit.this.iPurchaseTalabatCreditPresenter.decreaseAmount(PurchaseTalabatCredit.this.f54551i);
                }
            });
            this.plus.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PurchaseTalabatCredit.this.iPurchaseTalabatCreditPresenter.increaseAmount(PurchaseTalabatCredit.this.f54551i);
                }
            });
            this.buyCredit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PurchaseTalabatCredit.this.iPurchaseTalabatCreditPresenter.buyTalabatCredit();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    public void onError() {
    }

    public void onRedirectToPaymentPage(String str, String str2) {
        stopLodingPopup();
        Intent intent = new Intent(this, PaymentWebViewScreen.class);
        String string = getString(R.string.debit_card_payment);
        intent.putExtra("url", str);
        intent.putExtra("title", string);
        intent.putExtra("paymenttransactionId", str2);
        startActivityForResult(intent, 350);
    }

    public void onRedirectToThankyouPage(GiftVoucherThankyouResponse giftVoucherThankyouResponse) {
        String str;
        Customer.getInstance().getCustomerInfo().talabatCredit += this.selectedCreditAmount;
        try {
            if (Customer.getInstance().isLoggedIn(getContext())) {
                AppTracker.onTalabatCreditUpdated(getContext(), String.valueOf(Customer.getInstance().getCustomerInfo().talabatCredit));
            } else {
                AppTracker.onTalabatCreditUpdated(getContext(), "");
            }
        } catch (Exception unused) {
        }
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
        stopLodingPopup();
        finish();
    }

    public void setDescription(String str) {
        this.talabatCreditDescription.setText(str);
    }

    public void showLoading() {
        this.loadingView.setVisibility(0);
        this.contentView.setVisibility(8);
    }

    public void showLoadingPopup() {
        startLodingPopup();
    }
}
