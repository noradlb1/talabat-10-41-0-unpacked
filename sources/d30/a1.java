package d30;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.Node;

public final /* synthetic */ class a1 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JupiterEngineExecutionContext f61827b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Node.SkipResult f61828c;

    public /* synthetic */ a1(JupiterEngineExecutionContext jupiterEngineExecutionContext, Node.SkipResult skipResult) {
        this.f61827b = jupiterEngineExecutionContext;
        this.f61828c = skipResult;
    }

    public final void accept(Object obj) {
        ((TestWatcher) obj).testDisabled(this.f61827b.getExtensionContext(), this.f61828c.getReason());
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
