package com.talabat.darkstores.feature.product.views;

import androidx.appcompat.widget.AppCompatTextView;
import com.talabat.darkstores.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/appcompat/widget/AppCompatTextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressView$label$2 extends Lambda implements Function0<AppCompatTextView> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CampaignProgressView f56562g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CampaignProgressView$label$2(CampaignProgressView campaignProgressView) {
        super(0);
        this.f56562g = campaignProgressView;
    }

    public final AppCompatTextView invoke() {
        return (AppCompatTextView) this.f56562g._$_findCachedViewById(R.id.campaign_progress_label);
    }
}
