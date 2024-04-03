package r3;

import com.braze.brazeplugin.IntegrationInitializer;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class e implements IEventSubscriber {
    public final void trigger(Object obj) {
        IntegrationInitializer.m9199subscribeToContentCardsUpdatedEvent$lambda0((ContentCardsUpdatedEvent) obj);
    }
}
