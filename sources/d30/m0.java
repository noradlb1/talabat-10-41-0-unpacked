package d30;

import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class m0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((TestDescriptor) obj).getLegacyReportingName();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
