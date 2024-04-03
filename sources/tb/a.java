package tb;

import com.instabug.apm.model.ExecutionTrace;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExecutionTrace f47251b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f47252c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f47253d;

    public /* synthetic */ a(ExecutionTrace executionTrace, String str, String str2) {
        this.f47251b = executionTrace;
        this.f47252c = str;
        this.f47253d = str2;
    }

    public final void run() {
        this.f47251b.lambda$setAttribute$2(this.f47252c, this.f47253d);
    }
}
