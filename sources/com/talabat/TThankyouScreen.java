package com.talabat;

import JsonModels.GiftVoucherThankyouResponse;
import JsonModels.parser.UniversalGson;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.helpers.TalabatBase;
import com.talabat.home.HomeScreenActivity;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.thankyou_talabat.ThankyouPresenter;
import library.talabat.mvp.thankyou_talabat.ThankyouView;
import tracking.ScreenNames;

@Instrumented
public class TThankyouScreen extends TalabatBase implements ThankyouView {
    private Button homeButton;
    private Toolbar mToolbar;
    private TextView paymentId;
    private TextView referenceId;
    private TextView status;
    private TextView thankyouMessage;
    /* access modifiers changed from: private */
    public ThankyouPresenter thankyouPresenter;

    public void destroyPresenter() {
        this.thankyouPresenter = null;
    }

    public IGlobalPresenter getPresenter() {
        return this.thankyouPresenter;
    }

    public String getScreenName() {
        return ScreenNames.THANKYOU_OTHER;
    }

    public void goToHome() {
        Intent intent = new Intent(this, HomeScreenActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        String str;
        Object obj;
        Object obj2;
        super.onCreate(bundle);
        setContentView((int) R.layout.talabat_credit_thankyou);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            Gson gson = UniversalGson.INSTANCE.gson;
            this.thankyouMessage = (TextView) findViewById(R.id.talabat_credit_message);
            this.status = (TextView) findViewById(R.id.result_status);
            this.referenceId = (TextView) findViewById(R.id.result_reference_id);
            this.paymentId = (TextView) findViewById(R.id.result_payment_id);
            this.thankyouPresenter = new ThankyouPresenter(this);
            String stringExtra = getIntent().getStringExtra("from");
            if (getIntent().hasExtra("value")) {
                str = getIntent().getStringExtra("value");
            } else {
                str = "";
            }
            Button button = (Button) findViewById(R.id.talabat_credit_home_button);
            this.homeButton = button;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TThankyouScreen.this.thankyouPresenter.homeButtonPressed();
                }
            });
            Class cls = GiftVoucherThankyouResponse.class;
            if (stringExtra.equals(ScreenNames.GIFT_VOUCHER_DETAILS)) {
                if (!(gson instanceof Gson)) {
                    obj2 = gson.fromJson(str, cls);
                } else {
                    obj2 = GsonInstrumentation.fromJson(gson, str, cls);
                }
                this.thankyouPresenter.setUpViews(stringExtra, (GiftVoucherThankyouResponse) obj2);
            } else if (stringExtra.equals(ScreenNames.PURCHASE_TALABAT_CREDIT)) {
                if (!(gson instanceof Gson)) {
                    obj = gson.fromJson(str, cls);
                } else {
                    obj = GsonInstrumentation.fromJson(gson, str, cls);
                }
                this.thankyouPresenter.setUpViews(stringExtra, (GiftVoucherThankyouResponse) obj);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onError() {
    }

    public void setCreditTransactionDetails(String str, String str2, String str3) {
        this.status.setText(str);
        this.referenceId.setText(str2);
        this.paymentId.setText(str3);
    }

    public void setGiftVoucherThankyou(String str) {
        this.thankyouMessage.setText(getResources().getString(R.string.gift_voucher_thankyou_message).replace("#", str));
        setTitle(R.id.title, getResources().getString(R.string.title_activity_gift_voucher));
    }

    public void setTalabatCreditThankyou(String str) {
        this.thankyouMessage.setText(getResources().getString(R.string.talabat_credit_message).replace("#", str));
        setTitle(R.id.title, getResources().getString(R.string.title_activity_talabat_credit));
    }

    public void setVoucherTransactionDetails(String str, String str2, String str3) {
        this.status.setText(str);
        this.referenceId.setText(str2);
        this.paymentId.setText(str3);
    }
}
