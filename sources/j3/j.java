package j3;

import android.widget.ListView;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.ui.AppboyXamarinFormsFeedFragment;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class j implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppboyXamarinFormsFeedFragment f44362a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ListView f44363b;

    public /* synthetic */ j(AppboyXamarinFormsFeedFragment appboyXamarinFormsFeedFragment, ListView listView) {
        this.f44362a = appboyXamarinFormsFeedFragment;
        this.f44363b = listView;
    }

    public final void trigger(Object obj) {
        this.f44362a.lambda$onActivityCreated$3(this.f44363b, (FeedUpdatedEvent) obj);
    }
}
