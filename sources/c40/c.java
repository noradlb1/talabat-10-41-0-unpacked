package c40;

import j$.util.Optional;
import j$.util.function.Function;
import org.mockito.MockedConstruction;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.StringUtil;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;
import org.mockito.plugins.MockMaker;

public final /* synthetic */ class c {
    public static void a(MockMaker mockMaker) {
    }

    public static MockMaker.ConstructionMockControl b(MockMaker mockMaker, Class cls, Function function, Function function2, MockedConstruction.MockInitializer mockInitializer) {
        throw new MockitoException(StringUtil.join("The used MockMaker " + mockMaker.getClass().getSimpleName() + " does not support the creation of construction mocks", "", "Mockito's inline mock maker supports construction mocks based on the Instrumentation API.", "You can simply enable this mock mode, by placing the 'mockito-inline' artifact where you are currently using 'mockito-core'.", "Note that Mockito's inline mock maker is not supported on Android."));
    }

    public static Optional c(MockMaker mockMaker, MockCreationSettings mockCreationSettings, MockHandler mockHandler, Object obj) {
        return Optional.empty();
    }

    public static MockMaker.StaticMockControl d(MockMaker mockMaker, Class cls, MockCreationSettings mockCreationSettings, MockHandler mockHandler) {
        throw new MockitoException(StringUtil.join("The used MockMaker " + mockMaker.getClass().getSimpleName() + " does not support the creation of static mocks", "", "Mockito's inline mock maker supports static mocks based on the Instrumentation API.", "You can simply enable this mock mode, by placing the 'mockito-inline' artifact where you are currently using 'mockito-core'.", "Note that Mockito's inline mock maker is not supported on Android."));
    }
}
