package com.talabat;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Customer;
import buisnessmodels.TalabatFormatter;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationExtensionsKt;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.pay.DaggerTalabatCreditStatementScreenComponent;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.SimpleDividerItemDecoration;
import com.talabat.helpers.TalabatBase;
import datamodels.TalabatCreditStatement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.talabatcreditstatement.ITalabatCreditStatementPresenter;
import library.talabat.mvp.talabatcreditstatement.TalabatCreditStatementPresenter;
import library.talabat.mvp.talabatcreditstatement.TalabatCreditStatementView;
import tracking.ScreenNames;

public class TalabatCreditStatementScreen extends TalabatBase implements TalabatCreditStatementView {
    private TextView creditBalance;
    private RecyclerView creditHistory;
    private CreditHistoryAdapter creditHistoryAdapter;
    private View header;

    /* renamed from: i  reason: collision with root package name */
    public TalabatCreditStatement[] f55075i;
    private ITalabatCreditStatementPresenter iTalabatCreditStatementPresenter;

    /* renamed from: j  reason: collision with root package name */
    public final TalabatFormatter f55076j = TalabatFormatter.getInstance();
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public AppVersionProvider f55077k;
    private LinearLayoutManager llm;
    private Toolbar mToolbar;
    private View noTransactionView;
    private View progressBar;
    private View separator;

    public class CreditHistoryAdapter extends RecyclerView.Adapter<CreditHistoryViewHolder> {
        private CreditHistoryAdapter() {
        }

        public String getFormattedCurrency(float f11) {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(new Locale("en"));
            String str = LocationExtensionsKt.DECIMAL_PATTERN_DEFAULT;
            for (int i11 = 0; i11 < 3; i11++) {
                str = str + "0";
            }
            decimalFormat.applyPattern(str);
            return decimalFormat.format((double) f11);
        }

        public int getItemCount() {
            return TalabatCreditStatementScreen.this.f55075i.length;
        }

        public void onBindViewHolder(CreditHistoryViewHolder creditHistoryViewHolder, int i11) {
            creditHistoryViewHolder.f55081j.setText(TalabatCreditStatementScreen.this.f55075i[i11].details);
            TextView textView = creditHistoryViewHolder.f55080i;
            TalabatCreditStatementScreen talabatCreditStatementScreen = TalabatCreditStatementScreen.this;
            textView.setText(talabatCreditStatementScreen.f55076j.getFormattedCurrency(talabatCreditStatementScreen.f55075i[i11].total));
            creditHistoryViewHolder.f55082k.setText(getFormattedCurrency(TalabatCreditStatementScreen.this.f55075i[i11].amount));
            TextView textView2 = creditHistoryViewHolder.f55079h;
            textView2.setText(TalabatCreditStatementScreen.this.f55075i[i11].dateStr + "  " + TalabatCreditStatementScreen.this.f55075i[i11].timeStr);
        }

        public CreditHistoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new CreditHistoryViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.credit_list_item, viewGroup, false));
        }
    }

    public class CreditHistoryViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public TextView f55079h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f55080i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f55081j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f55082k;

        public CreditHistoryViewHolder(View view) {
            super(view);
            this.f55079h = (TextView) view.findViewById(R.id.credit_time);
            this.f55080i = (TextView) view.findViewById(R.id.credit_amount);
            this.f55081j = (TextView) view.findViewById(R.id.credit_used_at);
            this.f55082k = (TextView) view.findViewById(R.id.credit_transaction);
        }
    }

    public void destroyPresenter() {
        this.iTalabatCreditStatementPresenter = null;
    }

    public IGlobalPresenter getPresenter() {
        return this.iTalabatCreditStatementPresenter;
    }

    public String getScreenName() {
        return ScreenNames.CREDIT_STATEMENT_SCREEN;
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        DaggerTalabatCreditStatementScreenComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.credit_statement_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            setBackButton(R.id.back);
            this.creditBalance = (TextView) findViewById(R.id.remaining_credit_amount);
            this.creditHistory = (RecyclerView) findViewById(R.id.credit_list);
            this.noTransactionView = findViewById(R.id.no_transactions_view);
            this.header = findViewById(R.id.header_credit);
            this.separator = findViewById(R.id.separator);
            this.progressBar = findViewById(R.id.loading_layout);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            this.llm = linearLayoutManager;
            linearLayoutManager.setOrientation(1);
            this.creditHistory.setLayoutManager(this.llm);
            this.creditHistory.addItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.line_divider));
            TalabatCreditStatementPresenter talabatCreditStatementPresenter = new TalabatCreditStatementPresenter(this.f55077k, this);
            this.iTalabatCreditStatementPresenter = talabatCreditStatementPresenter;
            talabatCreditStatementPresenter.setUpViews();
            GlobalConstants.isSideMenuInitialSelection = false;
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onError() {
    }

    public void setTalabatCreditStatements(TalabatCreditStatement[] talabatCreditStatementArr) {
        this.creditBalance.setVisibility(0);
        this.f55075i = talabatCreditStatementArr;
        if (talabatCreditStatementArr.length > 0) {
            this.noTransactionView.setVisibility(8);
            this.header.setVisibility(0);
            this.separator.setVisibility(0);
            this.creditHistory.setVisibility(0);
            CreditHistoryAdapter creditHistoryAdapter2 = new CreditHistoryAdapter();
            this.creditHistoryAdapter = creditHistoryAdapter2;
            this.creditHistory.setAdapter(creditHistoryAdapter2);
            this.creditBalance.setText(this.f55076j.getFormattedCurrency(Customer.getInstance().getCustomerInfo().talabatCredit));
        } else {
            this.noTransactionView.setVisibility(0);
            onShakeImage(R.id.no_transactions_image);
            this.header.setVisibility(8);
            this.separator.setVisibility(8);
            this.creditHistory.setVisibility(8);
        }
        if (Customer.getInstance().getCustomerInfo().talabatCredit <= 0.0f && talabatCreditStatementArr != null && talabatCreditStatementArr.length > 0) {
            float f11 = Customer.getInstance().getCustomerInfo().talabatCredit;
            float f12 = talabatCreditStatementArr[0].total;
            if (f11 < f12) {
                this.creditBalance.setText(this.f55076j.getFormattedCurrency(f12));
                Customer.getInstance().getCustomerInfo().talabatCredit = talabatCreditStatementArr[0].total;
            }
        }
    }

    public void showProgress(boolean z11) {
        if (z11) {
            this.progressBar.setVisibility(0);
        } else {
            this.progressBar.setVisibility(8);
        }
    }
}
