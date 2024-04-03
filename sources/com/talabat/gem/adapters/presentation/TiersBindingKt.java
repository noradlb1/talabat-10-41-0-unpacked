package com.talabat.gem.adapters.presentation;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import com.talabat.gem.adapters.R;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.domain.usecases.BusinessRulesKt;
import com.talabat.gem.ports.presentation.GemTiersViewPort;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a)\u0010\t\u001a\u0004\u0018\u00010\n\"\f\b\u0000\u0010\u000b*\u00020\n*\u00020\f*\u0002H\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0010\u000f\u001a)\u0010\t\u001a\u0004\u0018\u00010\n\"\f\b\u0000\u0010\u000b*\u00020\b*\u00020\f*\u0002H\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0012H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"PLACE_HOLDER_CURRENCY", "", "PLACE_HOLDER_TOTAL_AMOUNT", "totalAmountText", "tier", "Lcom/talabat/gem/domain/entities/GemTier;", "bindTier", "", "Landroid/view/View;", "bindTiersViews", "Landroid/app/Activity;", "T", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "port", "Lcom/talabat/gem/ports/presentation/GemTiersViewPort;", "(Landroid/app/Activity;Lcom/talabat/gem/ports/presentation/GemTiersViewPort;)Landroid/app/Activity;", "(Landroid/view/View;Lcom/talabat/gem/ports/presentation/GemTiersViewPort;)Landroid/app/Activity;", "context", "Landroid/content/Context;", "tiersLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TiersBindingKt {
    @NotNull
    private static final String PLACE_HOLDER_CURRENCY = "#2";
    @NotNull
    private static final String PLACE_HOLDER_TOTAL_AMOUNT = "#1";

    /* access modifiers changed from: private */
    public static final void bindTier(View view, GemTier gemTier) {
        TextView textView = (TextView) view.findViewById(R.id.payOnlyLabelTextView);
        Intrinsics.checkNotNullExpressionValue(textView, "payOnlyLabelTextView");
        String str = null;
        ViewKt.plusAssign(textView, DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.gem_pay_only, (String) null, 1, (Object) null));
        int parseColor = Color.parseColor(gemTier.getColor());
        int i11 = R.id.tier1_disc;
        TextView textView2 = (TextView) view.findViewById(i11);
        Intrinsics.checkNotNullExpressionValue(textView2, "tier1_disc");
        Double payOnlyAmount = gemTier.getPayOnlyAmount();
        if (payOnlyAmount != null) {
            str = BusinessRulesKt.getDecimalFormat().format(payOnlyAmount.doubleValue());
        }
        ViewKt.plusAssign(textView2, str);
        ((TextView) view.findViewById(i11)).setTextColor(parseColor);
        int i12 = R.id.tier1_currency;
        TextView textView3 = (TextView) view.findViewById(i12);
        Intrinsics.checkNotNullExpressionValue(textView3, "tier1_currency");
        ViewKt.plusAssign(textView3, gemTier.getCurrency());
        ((TextView) view.findViewById(i12)).setTextColor(parseColor);
        TextView textView4 = (TextView) view.findViewById(R.id.tier1_offer);
        Intrinsics.checkNotNullExpressionValue(textView4, "tier1_offer");
        ViewKt.plusAssign(textView4, totalAmountText(gemTier));
    }

    @Nullable
    public static final <T extends View & AutoDisposable> Activity bindTiersViews(@NotNull T t11, @NotNull GemTiersViewPort gemTiersViewPort) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(gemTiersViewPort, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT);
        Context context = t11.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return bindTiersViews((AutoDisposable) t11, context, gemTiersViewPort);
    }

    /* access modifiers changed from: private */
    public static final LinearLayoutManager tiersLayoutManager(Context context) {
        return new LinearLayoutManager(context, 0, false);
    }

    private static final String totalAmountText(GemTier gemTier) {
        String str;
        String str2;
        String str3 = null;
        String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.tier_offer_place_holder, (String) null, 1, (Object) null);
        Double onTotalAmount = gemTier.getOnTotalAmount();
        if (onTotalAmount != null) {
            str3 = BusinessRulesKt.getDecimalFormat().format(onTotalAmount.doubleValue());
        }
        if (str3 == null) {
            str = "";
        } else {
            str = str3;
        }
        String replace$default = StringsKt__StringsJVMKt.replace$default(localizedString$default, PLACE_HOLDER_TOTAL_AMOUNT, str, false, 4, (Object) null);
        String currency = gemTier.getCurrency();
        if (currency == null) {
            str2 = "";
        } else {
            str2 = currency;
        }
        return StringsKt__StringsJVMKt.replace$default(replace$default, PLACE_HOLDER_CURRENCY, str2, false, 4, (Object) null);
    }

    @Nullable
    public static final <T extends Activity & AutoDisposable> Activity bindTiersViews(@NotNull T t11, @NotNull GemTiersViewPort gemTiersViewPort) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(gemTiersViewPort, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT);
        return bindTiersViews((AutoDisposable) t11, t11, gemTiersViewPort);
    }

    private static final Activity bindTiersViews(AutoDisposable autoDisposable, Context context, GemTiersViewPort gemTiersViewPort) {
        if (!(context instanceof Activity)) {
            context = null;
        }
        if (context == null) {
            return null;
        }
        Activity activity = (Activity) context;
        autoDisposable.autoDispose(new TiersBindingKt$bindTiersViews$3$1(gemTiersViewPort, activity));
        autoDisposable.autoDispose(new TiersBindingKt$bindTiersViews$3$2(gemTiersViewPort, activity));
        autoDisposable.autoDispose(new TiersBindingKt$bindTiersViews$3$3(activity, gemTiersViewPort));
        return activity;
    }
}
