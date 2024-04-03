package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f35909b;

    public /* synthetic */ a(String str) {
        this.f35909b = str;
    }

    public final Thread newThread(Runnable runnable) {
        return ConcurrencyHelpers.lambda$createBackgroundPriorityExecutor$0(this.f35909b, runnable);
    }
}
