package sd;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.survey.SurveyPlugin;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurveyPlugin f57385b;

    public /* synthetic */ g(SurveyPlugin surveyPlugin) {
        this.f57385b = surveyPlugin;
    }

    public final void accept(Object obj) {
        this.f57385b.lambda$wake$1((SDKCoreEvent) obj);
    }
}
