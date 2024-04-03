package com.talabat.growth.ui.vouchers.list;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.talabat.talabatcore.BaseActivity;
import com.talabat.talabatcore.BaseFragment;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\f"}, d2 = {"Lcom/talabat/growth/ui/vouchers/list/VouchersListActivity;", "Lcom/talabat/talabatcore/BaseActivity;", "()V", "fragment", "Lcom/talabat/talabatcore/BaseFragment;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersListActivity extends BaseActivity {
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
        VouchersListFragment vouchersListFragment = new VouchersListFragment();
        vouchersListFragment.setArguments(getIntent().getExtras());
        return vouchersListFragment;
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        for (Fragment onActivityResult : fragments) {
            onActivityResult.onActivityResult(i11, i12, intent);
        }
    }
}
