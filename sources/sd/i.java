package sd;

import com.instabug.library.OnUsageExceededReady;
import com.instabug.survey.Surveys;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnUsageExceededReady f57387b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f57388c;

    public /* synthetic */ i(OnUsageExceededReady onUsageExceededReady, boolean z11) {
        this.f57387b = onUsageExceededReady;
        this.f57388c = z11;
    }

    public final void run() {
        Surveys.lambda$getUsageExceeded$0(this.f57387b, this.f57388c);
    }
}
