package d30;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.junit.jupiter.api.function.Executable;

public final /* synthetic */ class q implements Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TestInstancePostProcessor f61900a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f61901b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61902c;

    public /* synthetic */ q(TestInstancePostProcessor testInstancePostProcessor, Object obj, ExtensionContext extensionContext) {
        this.f61900a = testInstancePostProcessor;
        this.f61901b = obj;
        this.f61902c = extensionContext;
    }

    public final void execute() {
        this.f61900a.postProcessTestInstance(this.f61901b, this.f61902c);
    }
}
