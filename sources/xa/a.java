package xa;

import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.flutter.analytics.presenter.HMSAnalyticsContract;
import com.huawei.hms.flutter.analytics.viewmodel.HMSAnalyticsViewModel;

public final /* synthetic */ class a implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HMSAnalyticsContract.ResultListener f50795a;

    public /* synthetic */ a(HMSAnalyticsContract.ResultListener resultListener) {
        this.f50795a = resultListener;
    }

    public final void onComplete(Task task) {
        HMSAnalyticsViewModel.lambda$getAAID$0(this.f50795a, task);
    }
}
