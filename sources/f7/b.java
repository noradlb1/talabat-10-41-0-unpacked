package f7;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JobInfoSchedulerService f34437b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JobParameters f34438c;

    public /* synthetic */ b(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f34437b = jobInfoSchedulerService;
        this.f34438c = jobParameters;
    }

    public final void run() {
        this.f34437b.lambda$onStartJob$0(this.f34438c);
    }
}
