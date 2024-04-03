package d30;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstanceFactoryContext;
import org.junit.jupiter.api.extension.TestInstancePreConstructCallback;
import org.junit.jupiter.api.function.Executable;

public final /* synthetic */ class o implements Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TestInstancePreConstructCallback f61891a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestInstanceFactoryContext f61892b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f61893c;

    public /* synthetic */ o(TestInstancePreConstructCallback testInstancePreConstructCallback, TestInstanceFactoryContext testInstanceFactoryContext, ExtensionContext extensionContext) {
        this.f61891a = testInstancePreConstructCallback;
        this.f61892b = testInstanceFactoryContext;
        this.f61893c = extensionContext;
    }

    public final void execute() {
        this.f61891a.preConstructTestInstance(this.f61892b, this.f61893c);
    }
}
