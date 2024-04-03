package f30;

import j$.util.function.Supplier;
import java.lang.reflect.Executable;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.engine.execution.ParameterResolutionUtils;

public final /* synthetic */ class t implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ParameterResolver f62053a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f62054b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ParameterContext f62055c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Executable f62056d;

    public /* synthetic */ t(ParameterResolver parameterResolver, Object obj, ParameterContext parameterContext, Executable executable) {
        this.f62053a = parameterResolver;
        this.f62054b = obj;
        this.f62055c = parameterContext;
        this.f62056d = executable;
    }

    public final Object get() {
        return ParameterResolutionUtils.lambda$resolveParameter$1(this.f62053a, this.f62054b, this.f62055c, this.f62056d);
    }
}
