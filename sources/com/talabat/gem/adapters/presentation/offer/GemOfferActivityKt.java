package com.talabat.gem.adapters.presentation.offer;

import android.content.Intent;
import com.talabat.gem.domain.entities.GemRestaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"KEY_GEM_OFFER_SELECTION", "", "close", "", "Lcom/talabat/gem/adapters/presentation/offer/GemOfferActivity;", "toData", "Landroid/content/Intent;", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemOfferActivityKt {
    @NotNull
    public static final String KEY_GEM_OFFER_SELECTION = "KEY_GEM_OFFER_SELECTION";

    /* access modifiers changed from: private */
    public static final void close(GemOfferActivity gemOfferActivity) {
        if (!gemOfferActivity.isFinishing()) {
            gemOfferActivity.onBackPressed();
        }
    }

    @NotNull
    public static final Intent toData(@NotNull GemRestaurant gemRestaurant) {
        Intrinsics.checkNotNullParameter(gemRestaurant, "<this>");
        Intent putExtra = new Intent().putExtra(KEY_GEM_OFFER_SELECTION, gemRestaurant);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(KEY_GEM_OFFER_SELECTION, this)");
        return putExtra;
    }
}
