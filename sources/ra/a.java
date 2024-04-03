package ra;

import com.google.android.datatransport.Transformer;
import com.google.firebase.sessions.EventGDTLogger;
import com.google.firebase.sessions.SessionEvent;

public final /* synthetic */ class a implements Transformer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventGDTLogger f50773a;

    public /* synthetic */ a(EventGDTLogger eventGDTLogger) {
        this.f50773a = eventGDTLogger;
    }

    public final Object apply(Object obj) {
        return this.f50773a.encode((SessionEvent) obj);
    }
}
