package t00;

import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.rx2.RxSchedulerKt;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f28198b;

    public /* synthetic */ e(Ref.ObjectRef objectRef) {
        this.f28198b = objectRef;
    }

    public final void run() {
        RxSchedulerKt.m7860scheduleTask$lambda0(this.f28198b);
    }
}
