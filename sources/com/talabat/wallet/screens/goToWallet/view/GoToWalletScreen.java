package com.talabat.wallet.screens.goToWallet.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.talabat.R;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.wallet.screens.goToWallet.presenter.GoToWalletPresenter;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ux.a;
import ux.b;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/wallet/screens/goToWallet/view/GoToWalletScreen;", "Lcom/talabat/helpers/TalabatBase;", "Lcom/talabat/wallet/screens/goToWallet/view/GoToWalletView;", "()V", "goToWalletPresenter", "Lcom/talabat/wallet/screens/goToWallet/presenter/GoToWalletPresenter;", "destroyPresenter", "", "getPresenter", "getScreenName", "", "onAuthError", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GoToWalletScreen extends TalabatBase implements GoToWalletView {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private GoToWalletPresenter goToWalletPresenter;

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m5955onCreate$lambda0(GoToWalletScreen goToWalletScreen, View view) {
        Intrinsics.checkNotNullParameter(goToWalletScreen, "this$0");
        goToWalletScreen.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m5956onCreate$lambda1(GoToWalletScreen goToWalletScreen, View view) {
        Intrinsics.checkNotNullParameter(goToWalletScreen, "this$0");
        goToWalletScreen.startActivity(new Intent(goToWalletScreen, WalletManageCreditCardsScreen.class));
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
        this.goToWalletPresenter = null;
    }

    @NotNull
    public String getScreenName() {
        return "";
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_go_to_wallet);
        setSupportActionBar((TalabatToolBar) _$_findCachedViewById(R.id.toolbar));
        this.goToWalletPresenter = new GoToWalletPresenter(this);
        ((TalabatToolBarImageButton) _$_findCachedViewById(R.id.back_icon)).setOnClickListener(new a(this));
        ((TalabatFillButton) _$_findCachedViewById(R.id.got_to_wallet_button)).setOnClickListener(new b(this));
    }

    public void onError() {
    }

    @Nullable
    public GoToWalletPresenter getPresenter() {
        return this.goToWalletPresenter;
    }
}
