package androidx.webkit.internal;

import androidx.annotation.NonNull;
import androidx.webkit.ScriptHandler;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.ScriptHandlerBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class ScriptHandlerImpl extends ScriptHandler {
    private ScriptHandlerBoundaryInterface mBoundaryInterface;

    private ScriptHandlerImpl(@NonNull ScriptHandlerBoundaryInterface scriptHandlerBoundaryInterface) {
        this.mBoundaryInterface = scriptHandlerBoundaryInterface;
    }

    @NonNull
    public static ScriptHandlerImpl toScriptHandler(@NonNull InvocationHandler invocationHandler) {
        return new ScriptHandlerImpl((ScriptHandlerBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ScriptHandlerBoundaryInterface.class, invocationHandler));
    }

    public void remove() {
        this.mBoundaryInterface.remove();
    }
}
