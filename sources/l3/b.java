package l3;

import android.view.View;
import com.appboy.models.cards.CaptionedImageCard;
import com.appboy.ui.widget.CaptionedImageCardView;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CaptionedImageCardView f44373b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CaptionedImageCard f44374c;

    public /* synthetic */ b(CaptionedImageCardView captionedImageCardView, CaptionedImageCard captionedImageCard) {
        this.f44373b = captionedImageCardView;
        this.f44374c = captionedImageCard;
    }

    public final void onClick(View view) {
        this.f44373b.lambda$onSetCard$0(this.f44374c, view);
    }
}
