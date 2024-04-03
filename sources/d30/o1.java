package d30;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;
import org.junit.platform.engine.TestExecutionResult;

public final /* synthetic */ class o1 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestExecutionResult.Status f61894b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61895c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TestExecutionResult f61896d;

    public /* synthetic */ o1(TestExecutionResult.Status status, ExtensionContext extensionContext, TestExecutionResult testExecutionResult) {
        this.f61894b = status;
        this.f61895c = extensionContext;
        this.f61896d = testExecutionResult;
    }

    public final void accept(Object obj) {
        TestMethodTestDescriptor.lambda$nodeFinished$15(this.f61894b, this.f61895c, this.f61896d, (TestWatcher) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
