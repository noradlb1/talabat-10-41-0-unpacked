package u3;

import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.ui.contentcards.ContentCardsFragment;

public final /* synthetic */ class a implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContentCardsFragment f44402a;

    public /* synthetic */ a(ContentCardsFragment contentCardsFragment) {
        this.f44402a = contentCardsFragment;
    }

    public final void trigger(Object obj) {
        ContentCardsFragment.m9200onResume$lambda0(this.f44402a, (ContentCardsUpdatedEvent) obj);
    }
}
