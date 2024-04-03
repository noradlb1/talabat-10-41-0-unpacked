package c30;

import j$.util.function.Function;
import org.junit.platform.engine.ConfigurationParameters;

public final /* synthetic */ class n implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigurationParameters f58209a;

    public /* synthetic */ n(ConfigurationParameters configurationParameters) {
        this.f58209a = configurationParameters;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f58209a.get((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
