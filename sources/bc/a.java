package bc;

import com.instabug.chat.synchronization.SynchronizationManager;
import com.instabug.library.core.eventbus.instabugeventbus.EventBusSubscriber;

public final /* synthetic */ class a implements EventBusSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SynchronizationManager f44498a;

    public /* synthetic */ a(SynchronizationManager synchronizationManager) {
        this.f44498a = synchronizationManager;
    }

    public final void onNewEvent(Object obj) {
        this.f44498a.lambda$new$0((Long) obj);
    }
}
