package sd;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.survey.SurveyPlugin;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurveyPlugin f57384b;

    public /* synthetic */ e(SurveyPlugin surveyPlugin) {
        this.f57384b = surveyPlugin;
    }

    public final void accept(Object obj) {
        this.f57384b.lambda$subscribeOnSDKEvents$2((SDKCoreEvent) obj);
    }
}
