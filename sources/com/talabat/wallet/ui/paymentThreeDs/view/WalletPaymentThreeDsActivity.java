package com.talabat.wallet.ui.paymentThreeDs.view;

import android.view.View;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentThreeDsFragment;
import com.talabat.talabatcore.BaseActivity;
import com.talabat.talabatcore.BaseFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\f\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/ui/paymentThreeDs/view/WalletPaymentThreeDsActivity;", "Lcom/talabat/talabatcore/BaseActivity;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsFragment$WalletPaymentThreeDsFragmentInterface;", "()V", "bottomSheetTopUpFailure", "", "bottomSheetTopUpSuccessful", "fragment", "Lcom/talabat/talabatcore/BaseFragment;", "topUpFailure", "topUpSuccessful", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentThreeDsActivity extends BaseActivity implements WalletPaymentThreeDsFragment.WalletPaymentThreeDsFragmentInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

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

    public void bottomSheetTopUpFailure() {
    }

    public void bottomSheetTopUpSuccessful() {
    }

    @NotNull
    public BaseFragment fragment() {
        return new WalletPaymentThreeDsFragment(this);
    }

    public void topUpFailure() {
    }

    public void topUpSuccessful() {
    }
}
