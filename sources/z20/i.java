package z20;

import java.lang.reflect.Executable;
import org.junit.jupiter.api.extension.ParameterContext;

public final /* synthetic */ class i {
    public static Executable a(ParameterContext parameterContext) {
        return parameterContext.getParameter().getDeclaringExecutable();
    }
}
