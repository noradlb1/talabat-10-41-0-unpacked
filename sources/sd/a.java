package sd;

import android.content.Context;
import com.instabug.survey.SurveyPlugin;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurveyPlugin f57380b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f57381c;

    public /* synthetic */ a(SurveyPlugin surveyPlugin, Context context) {
        this.f57380b = surveyPlugin;
        this.f57381c = context;
    }

    public final void run() {
        this.f57380b.lambda$start$0(this.f57381c);
    }
}
