package net.bytebuddy.utility.privilege;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Method;
import java.security.PrivilegedAction;
import java.util.Arrays;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

@HashCodeAndEqualsPlugin.Enhance
public class GetMethodAction implements PrivilegedAction<Method> {
    private static final Object[] NO_ARGUMENT = new Object[0];

    /* renamed from: name  reason: collision with root package name */
    private final String f27513name;
    private final Class<?>[] parameter;
    private final String type;

    public GetMethodAction(String str, String str2, Class<?>... clsArr) {
        this.type = str;
        this.f27513name = str2;
        this.parameter = clsArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GetMethodAction getMethodAction = (GetMethodAction) obj;
        return this.type.equals(getMethodAction.type) && this.f27513name.equals(getMethodAction.f27513name) && Arrays.equals(this.parameter, getMethodAction.parameter);
    }

    public int hashCode() {
        return (((((getClass().hashCode() * 31) + this.type.hashCode()) * 31) + this.f27513name.hashCode()) * 31) + Arrays.hashCode(this.parameter);
    }

    @SuppressFBWarnings(justification = "Exception should not be rethrown but be nulled out", value = {"REC_CATCH_EXCEPTION"})
    public Method run() {
        try {
            return Class.forName(this.type).getMethod(this.f27513name, this.parameter);
        } catch (Exception unused) {
            return null;
        }
    }
}
