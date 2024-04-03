package l6;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.FlushStatistics;
import com.facebook.appevents.SessionEventsState;

public final /* synthetic */ class d implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccessTokenAppIdPair f34544a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GraphRequest f34545b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SessionEventsState f34546c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FlushStatistics f34547d;

    public /* synthetic */ d(AccessTokenAppIdPair accessTokenAppIdPair, GraphRequest graphRequest, SessionEventsState sessionEventsState, FlushStatistics flushStatistics) {
        this.f34544a = accessTokenAppIdPair;
        this.f34545b = graphRequest;
        this.f34546c = sessionEventsState;
        this.f34547d = flushStatistics;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        AppEventQueue.m8881buildRequestForSession$lambda4(this.f34544a, this.f34545b, this.f34546c, this.f34547d, graphResponse);
    }
}
