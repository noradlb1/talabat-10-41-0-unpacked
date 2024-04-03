package l3;

import android.view.View;
import com.appboy.models.cards.BannerImageCard;
import com.appboy.ui.widget.BannerImageCardView;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BannerImageCardView f44371b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BannerImageCard f44372c;

    public /* synthetic */ a(BannerImageCardView bannerImageCardView, BannerImageCard bannerImageCard) {
        this.f44371b = bannerImageCardView;
        this.f44372c = bannerImageCard;
    }

    public final void onClick(View view) {
        this.f44371b.lambda$onSetCard$0(this.f44372c, view);
    }
}
