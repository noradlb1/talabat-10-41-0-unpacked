package j3;

import android.widget.ListView;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.ui.AppboyFeedFragment;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class d implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppboyFeedFragment f44357a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListView f44358b;

    public /* synthetic */ d(AppboyFeedFragment appboyFeedFragment, ListView listView) {
        this.f44357a = appboyFeedFragment;
        this.f44358b = listView;
    }

    public final void trigger(Object obj) {
        this.f44357a.lambda$onViewCreated$3(this.f44358b, (FeedUpdatedEvent) obj);
    }
}
