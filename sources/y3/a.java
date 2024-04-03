package y3;

import android.view.View;
import com.appboy.models.cards.Card;
import com.braze.ui.actions.UriAction;
import com.braze.ui.contentcards.view.BaseContentCardView;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseContentCardView f44447b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Card f44448c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ UriAction f44449d;

    public /* synthetic */ a(BaseContentCardView baseContentCardView, Card card, UriAction uriAction) {
        this.f44447b = baseContentCardView;
        this.f44448c = card;
        this.f44449d = uriAction;
    }

    public final void onClick(View view) {
        BaseContentCardView.m9205bindViewHolder$lambda0(this.f44447b, this.f44448c, this.f44449d, view);
    }
}
