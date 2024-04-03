package sh;

import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.talabat.core.wearable.huawei.data.impl.DefaultHuaweiWearEngineKit;

public final /* synthetic */ class a implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultHuaweiWearEngineKit f57400a;

    public /* synthetic */ a(DefaultHuaweiWearEngineKit defaultHuaweiWearEngineKit) {
        this.f57400a = defaultHuaweiWearEngineKit;
    }

    public final void onComplete(Task task) {
        DefaultHuaweiWearEngineKit.m9614send$lambda3(this.f57400a, task);
    }
}
