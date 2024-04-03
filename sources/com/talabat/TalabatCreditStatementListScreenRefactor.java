package com.talabat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.adapters.talabatcredit.TalabatCreditStatementListAdapter;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatToolBar;
import datamodels.TalabatCreditStatementR;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import library.talabatcreditstatementrefactor.ITalabatCreditStatementPresenterR;
import library.talabatcreditstatementrefactor.TalabatCreditStatementPresenterR;
import library.talabatcreditstatementrefactor.TalabatCreditStatementViewR;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0002J \u0010\r\u001a\u00020\u00072\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/TalabatCreditStatementListScreenRefactor;", "Lcom/talabat/helpers/TalabatBase;", "Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementViewR;", "()V", "mTalabatCreditStatementPresenter", "Llibrary/talabatcreditstatementrefactor/TalabatCreditStatementPresenterR;", "destroyPresenter", "", "getPresenter", "Llibrary/talabatcreditstatementrefactor/ITalabatCreditStatementPresenterR;", "getScreenName", "", "initInitialView", "loadCreditStatmentList", "lstStatement", "Ljava/util/ArrayList;", "Ldatamodels/TalabatCreditStatementR;", "Lkotlin/collections/ArrayList;", "noCreditStatementFound", "onAuthError", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "showLoading", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatCreditStatementListScreenRefactor extends TalabatBase implements TalabatCreditStatementViewR {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private TalabatCreditStatementPresenterR mTalabatCreditStatementPresenter;

    private final void initInitialView() {
        TalabatCreditStatementPresenterR talabatCreditStatementPresenterR = this.mTalabatCreditStatementPresenter;
        if (talabatCreditStatementPresenterR != null) {
            talabatCreditStatementPresenterR.setUpViews();
        }
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

    public void destroyPresenter() {
        this.mTalabatCreditStatementPresenter = null;
    }

    @NotNull
    public String getScreenName() {
        return ScreenNames.CREDIT_STATEMENT_SCREEN;
    }

    public void loadCreditStatmentList(@NotNull ArrayList<TalabatCreditStatementR> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "lstStatement");
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
        ((LinearLayout) _$_findCachedViewById(R.id.no_transactions_view)).setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.header_container);
        ((LinearLayout) _$_findCachedViewById(R.id.credit_statement_list_container)).setVisibility(0);
        int i11 = R.id.credit_statement_list;
        ((RecyclerView) _$_findCachedViewById(i11)).setVisibility(0);
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(new TalabatCreditStatementListAdapter(arrayList, this));
        ((RecyclerView) _$_findCachedViewById(i11)).addOnScrollListener(new TalabatCreditStatementListScreenRefactor$loadCreditStatmentList$1(this));
    }

    public void noCreditStatementFound() {
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
        ((LinearLayout) _$_findCachedViewById(R.id.no_transactions_view)).setVisibility(0);
        ((LinearLayout) _$_findCachedViewById(R.id.credit_statement_list_container)).setVisibility(8);
        onShakeImage(R.id.no_transactions_image);
    }

    public void onAuthError() {
        throw new NotImplementedError("An operation is not implemented: " + "not implemented");
    }

    public void onCreate(@Nullable Bundle bundle) {
        AppVersionProvider appVersionProvider = ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).getAppVersionProvider();
        super.onCreate(bundle);
        setContentView((int) R.layout.credit_statement_screen_r);
        int i11 = R.id.toolbar;
        setSupportActionBar((TalabatToolBar) _$_findCachedViewById(i11));
        setToolbarPadding((TalabatToolBar) _$_findCachedViewById(i11));
        this.mTalabatCreditStatementPresenter = new TalabatCreditStatementPresenterR(appVersionProvider, this);
        setBackButton(R.id.back);
        initInitialView();
    }

    public void onError() {
    }

    public void showLoading() {
        ((LinearLayout) _$_findCachedViewById(R.id.credit_statement_list_container)).setVisibility(8);
        ((LinearLayout) _$_findCachedViewById(R.id.no_transactions_view)).setVisibility(8);
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(0);
    }

    @Nullable
    public ITalabatCreditStatementPresenterR getPresenter() {
        return this.mTalabatCreditStatementPresenter;
    }
}
