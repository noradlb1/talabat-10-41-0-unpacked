package com.talabat.vendormenu.presentation.flutter;

import android.content.Intent;
import android.view.View;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.talabatcommon.R;
import com.talabat.vendormenu.presentation.flutter.dto.AddToBasketCallArguments;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/VendorItemDetailsWithChoiceFlutterActivity;", "Lcom/talabat/vendormenu/presentation/flutter/VendorItemDetailsFlutterActivity;", "()V", "onAddToBasketClicked", "", "args", "Lcom/talabat/vendormenu/presentation/flutter/dto/AddToBasketCallArguments;", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorItemDetailsWithChoiceFlutterActivity extends VendorItemDetailsFlutterActivity {
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

    public void onAddToBasketClicked(@NotNull AddToBasketCallArguments addToBasketCallArguments) {
        Intrinsics.checkNotNullParameter(addToBasketCallArguments, StepData.ARGS);
        Intent intent = new Intent();
        intent.putExtra(FirebaseAnalytics.Param.QUANTITY, addToBasketCallArguments.getQuantity());
        intent.putExtra("itemId", addToBasketCallArguments.getItemId());
        String specialRequest = addToBasketCallArguments.getSpecialRequest();
        if (specialRequest == null) {
            specialRequest = "";
        }
        intent.putExtra("specialRequest", specialRequest);
        intent.putExtra("selectedChoices", addToBasketCallArguments.getSelectedChoiceSections());
        setResult(-1, intent);
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
