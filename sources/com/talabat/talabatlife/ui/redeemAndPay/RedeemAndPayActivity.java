package com.talabat.talabatlife.ui.redeemAndPay;

import android.view.View;
import com.talabat.talabatcore.BaseActivity;
import com.talabat.talabatcore.BaseFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatlife/ui/redeemAndPay/RedeemAndPayActivity;", "Lcom/talabat/talabatcore/BaseActivity;", "()V", "fragment", "Lcom/talabat/talabatcore/BaseFragment;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemAndPayActivity extends BaseActivity {
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

    @NotNull
    public BaseFragment fragment() {
        return new RedeemAndPayFragment();
    }
}
