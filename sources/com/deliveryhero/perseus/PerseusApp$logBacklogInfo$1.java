package com.deliveryhero.perseus;

import com.deliveryhero.perseus.di.LoggerModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PerseusApp$logBacklogInfo$1 extends Lambda implements Function1<Throwable, Unit> {
    public static final PerseusApp$logBacklogInfo$1 INSTANCE = new PerseusApp$logBacklogInfo$1();

    public PerseusApp$logBacklogInfo$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th2) {
        LoggerModule.INSTANCE.getPerseusLogger().e("Sending backlog queue status failed: ", th2);
    }
}
