package m30;

import j$.util.Optional;
import j$.util.function.Function;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.ConfigurationParameters;

public final /* synthetic */ class e {
    @API(since = "1.3", status = API.Status.STABLE)
    public static Optional a(ConfigurationParameters configurationParameters, String str, Function function) {
        Preconditions.notNull(function, "transformer must not be null");
        return configurationParameters.get(str).map(new d(function, str));
    }

    public static /* synthetic */ Object b(Function function, String str, String str2) {
        try {
            return function.apply(str2);
        } catch (Exception e11) {
            throw new JUnitException(String.format("Failed to transform configuration parameter with key '%s' and initial value '%s'", new Object[]{str, str2}), e11);
        }
    }
}
