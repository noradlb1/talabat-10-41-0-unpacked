package l3;

import android.view.View;
import com.appboy.models.cards.TextAnnouncementCard;
import com.appboy.ui.widget.TextAnnouncementCardView;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextAnnouncementCardView f44377b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextAnnouncementCard f44378c;

    public /* synthetic */ d(TextAnnouncementCardView textAnnouncementCardView, TextAnnouncementCard textAnnouncementCard) {
        this.f44377b = textAnnouncementCardView;
        this.f44378c = textAnnouncementCard;
    }

    public final void onClick(View view) {
        this.f44377b.lambda$onSetCard$0(this.f44378c, view);
    }
}
