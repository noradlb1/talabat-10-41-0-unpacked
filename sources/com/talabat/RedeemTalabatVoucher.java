package com.talabat;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import com.materialedittext.MaterialEditText;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.voucher.DaggerRedeemTalabatVoucherComponent;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.talabatcreditvoucher.ITalabatCreditVoucherPreseneter;
import library.talabat.mvp.talabatcreditvoucher.TalabatCreditVoucherPreseneter;
import library.talabat.mvp.talabatcreditvoucher.TalabatCreditVoucherView;
import tracking.AppTracker;
import tracking.ScreenNames;

public class RedeemTalabatVoucher extends TalabatBase implements TalabatCreditVoucherView {
    /* access modifiers changed from: private */
    public String from = "";
    @Inject

    /* renamed from: i  reason: collision with root package name */
    public AppVersionProvider f54923i;
    /* access modifiers changed from: private */
    public ITalabatCreditVoucherPreseneter iTalabatCreditVoucherPreseneter;
    private Toolbar mToolbar;
    private Button redeem;
    private MaterialEditText voucherCode;

    public void destroyPresenter() {
        this.iTalabatCreditVoucherPreseneter = null;
    }

    public IGlobalPresenter getPresenter() {
        return this.iTalabatCreditVoucherPreseneter;
    }

    public String getScreenName() {
        return ScreenNames.REDEEM_VOUCHER;
    }

    public String getVoucherCode() {
        return this.voucherCode.getText().toString().trim();
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        String str;
        DaggerRedeemTalabatVoucherComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.redeem_voucher_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            setBackButton(R.id.back);
            this.redeem = (Button) findViewById(R.id.btnRedeem);
            String str2 = "";
            if (getIntent().hasExtra("from")) {
                str = getIntent().getStringExtra("from");
            } else {
                str = str2;
            }
            this.from = str;
            this.voucherCode = (MaterialEditText) findViewById(R.id.voucher_code);
            this.iTalabatCreditVoucherPreseneter = new TalabatCreditVoucherPreseneter(this.f54923i, this);
            this.redeem.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    RedeemTalabatVoucher.this.iTalabatCreditVoucherPreseneter.validateAndContinue();
                }
            });
            if (getIntent().hasExtra("value")) {
                str2 = getIntent().getStringExtra("value");
            }
            if (!TalabatUtils.isNullOrEmpty(str2)) {
                this.voucherCode.setText(str2);
            }
        } catch (Exception unused) {
            finish();
        }
    }

    public void onError() {
    }

    public void onLocalValidationFailed(int i11) {
        if (i11 == 70) {
            this.voucherCode.setErrorColor(getResources().getColor(R.color.talabat_red));
            this.voucherCode.setError(getResources().getString(R.string.please_enter_voucher_code));
        }
    }

    public void onValidationSuccess() {
        startLodingPopup();
    }

    public void onVoucherApplied(String str, final float f11) {
        stopLodingPopup();
        if (f11 > 0.0f) {
            AppTracker.onCreditRedeemCompleted(getContext(), getScreenName(), ScreenNames.SCREEN_TYPE_USER_ACCOUNT, f11);
        } else {
            AppTracker.onCreditRedeemFailed(this, getScreenName(), ScreenNames.SCREEN_TYPE_USER_ACCOUNT, str);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setCancelable(false);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                dialogInterface.dismiss();
                if (f11 > 0.0f) {
                    if (RedeemTalabatVoucher.this.from.equals(ScreenNames.TALABAT_CREDIT_SELECTION_SCREEN_R)) {
                        RedeemTalabatVoucher.this.setResult(-1);
                    }
                    RedeemTalabatVoucher.this.finish();
                }
            }
        });
        builder.show();
    }
}
