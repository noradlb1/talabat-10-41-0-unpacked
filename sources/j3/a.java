package j3;

import android.widget.ListView;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.ui.AppboyFeedFragment;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppboyFeedFragment f44353b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedUpdatedEvent f44354c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ListView f44355d;

    public /* synthetic */ a(AppboyFeedFragment appboyFeedFragment, FeedUpdatedEvent feedUpdatedEvent, ListView listView) {
        this.f44353b = appboyFeedFragment;
        this.f44354c = feedUpdatedEvent;
        this.f44355d = listView;
    }

    public final void run() {
        this.f44353b.lambda$onViewCreated$2(this.f44354c, this.f44355d);
    }
}
