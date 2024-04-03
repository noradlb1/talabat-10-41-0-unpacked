package n30;

import j$.util.function.Function;
import java.net.URI;
import org.junit.platform.engine.discovery.ClasspathRootSelector;

public final /* synthetic */ class h implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return new ClasspathRootSelector((URI) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
