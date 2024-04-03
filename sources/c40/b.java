package c40;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.plugins.MemberAccessor;

public final /* synthetic */ class b {
    public static Object a(MemberAccessor memberAccessor, Constructor constructor, MemberAccessor.OnConstruction onConstruction, Object... objArr) throws InstantiationException, InvocationTargetException, IllegalAccessException {
        return onConstruction.invoke(new a(memberAccessor, constructor, objArr));
    }
}
