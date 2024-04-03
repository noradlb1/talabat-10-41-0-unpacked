package l3;

import android.view.View;
import com.appboy.models.cards.ShortNewsCard;
import com.appboy.ui.widget.ShortNewsCardView;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShortNewsCardView f44375b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ShortNewsCard f44376c;

    public /* synthetic */ c(ShortNewsCardView shortNewsCardView, ShortNewsCard shortNewsCard) {
        this.f44375b = shortNewsCardView;
        this.f44376c = shortNewsCard;
    }

    public final void onClick(View view) {
        this.f44375b.lambda$onSetCard$0(this.f44376c, view);
    }
}
