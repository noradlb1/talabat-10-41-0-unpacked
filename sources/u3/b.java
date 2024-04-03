package u3;

import com.braze.events.IEventSubscriber;
import com.braze.events.SdkDataWipeEvent;
import com.braze.ui.contentcards.ContentCardsFragment;

public final /* synthetic */ class b implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContentCardsFragment f44403a;

    public /* synthetic */ b(ContentCardsFragment contentCardsFragment) {
        this.f44403a = contentCardsFragment;
    }

    public final void trigger(Object obj) {
        ContentCardsFragment.m9201onResume$lambda2(this.f44403a, (SdkDataWipeEvent) obj);
    }
}
