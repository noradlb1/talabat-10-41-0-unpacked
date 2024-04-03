package com.talabat.gem.adapters.presentation.payment;

import android.view.View;
import com.talabat.gem.adapters.presentation.GemOfferProcessingConfigurations;
import com.talabat.gem.adapters.presentation.GemRestaurantData;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.domain.usecases.BusinessRulesKt;
import com.talabat.gem.domain.usecases.GemOfferProcessingBusinessRulesKt;
import com.talabat.talabatcommon.extentions.RxKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemOfferProcessingKt$withGemOfferProcessing$1$1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemOfferProcessingViewModel f60263b;

    public GemOfferProcessingKt$withGemOfferProcessing$1$1(GemOfferProcessingViewModel gemOfferProcessingViewModel) {
        this.f60263b = gemOfferProcessingViewModel;
    }

    public final void onClick(View view) {
        Integer num;
        GemRestaurantData with;
        GemOfferProcessingConfigurations value = this.f60263b.getConfigurations$com_talabat_Components_gem_gem().getValue();
        if (value == null || (with = value.getWith()) == null) {
            num = null;
        } else {
            num = with.getRestaurantId$com_talabat_Components_gem_gem();
        }
        if (BusinessRulesKt.isGemActive(num)) {
            GemOfferProcessingBusinessRulesKt.onProcessOffer(this.f60263b);
            return;
        }
        Function1 function1 = (Function1) RxKt.invoke(this.f60263b.getOnProcessed$com_talabat_Components_gem_gem());
        if (function1 != null) {
            function1.invoke(GemOfferAcceptance.Rejected.INSTANCE);
        }
    }
}
