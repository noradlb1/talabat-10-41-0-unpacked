package com.talabat.wallet.ui.walletDashboard.view;

import android.view.View;
import com.talabat.talabatcore.BaseActivity;
import com.talabat.talabatcore.BaseFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/view/WalletDashboardActivity;", "Lcom/talabat/talabatcore/BaseActivity;", "()V", "fragment", "Lcom/talabat/talabatcore/BaseFragment;", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_DISABLE_OPENING_HOME_FOR_BACK_PRESSED = "extraDisableOpeningHome";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/view/WalletDashboardActivity$Companion;", "", "()V", "EXTRA_DISABLE_OPENING_HOME_FOR_BACK_PRESSED", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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

    @NotNull
    public BaseFragment fragment() {
        return new WalletDashboardFragment();
    }
}
