package j3;

import android.widget.ListView;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.ui.AppboyXamarinFormsFeedFragment;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppboyXamarinFormsFeedFragment f44364b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedUpdatedEvent f44365c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ListView f44366d;

    public /* synthetic */ k(AppboyXamarinFormsFeedFragment appboyXamarinFormsFeedFragment, FeedUpdatedEvent feedUpdatedEvent, ListView listView) {
        this.f44364b = appboyXamarinFormsFeedFragment;
        this.f44365c = feedUpdatedEvent;
        this.f44366d = listView;
    }

    public final void run() {
        this.f44364b.lambda$onActivityCreated$2(this.f44365c, this.f44366d);
    }
}
