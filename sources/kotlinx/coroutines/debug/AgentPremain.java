package kotlinx.coroutines.debug;

import android.annotation.SuppressLint;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.AgentInstallationType;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r00.a;
import sun.misc.Signal;

@SuppressLint({"all"})
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain;", "", "()V", "enableCreationStackTraces", "", "installSignalHandler", "", "premain", "args", "", "instrumentation", "Ljava/lang/instrument/Instrumentation;", "DebugProbesTransformer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@IgnoreJRERequirement
public final class AgentPremain {
    @NotNull
    public static final AgentPremain INSTANCE = new AgentPremain();
    private static final boolean enableCreationStackTraces;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "()V", "transform", "", "loader", "Ljava/lang/ClassLoader;", "className", "", "classBeingRedefined", "Ljava/lang/Class;", "protectionDomain", "Ljava/security/ProtectionDomain;", "classfileBuffer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DebugProbesTransformer implements ClassFileTransformer {
        @NotNull
        public static final DebugProbesTransformer INSTANCE = new DebugProbesTransformer();

        private DebugProbesTransformer() {
        }

        @Nullable
        public byte[] transform(@NotNull ClassLoader classLoader, @NotNull String str, @Nullable Class<?> cls, @NotNull ProtectionDomain protectionDomain, @Nullable byte[] bArr) {
            if (!Intrinsics.areEqual((Object) str, (Object) "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
            return ByteStreamsKt.readBytes(classLoader.getResourceAsStream("DebugProbesKt.bin"));
        }
    }

    static {
        Object obj;
        boolean z11;
        Boolean bool;
        Boolean bool2 = null;
        try {
            Result.Companion companion = Result.Companion;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            if (property != null) {
                bool = Boolean.valueOf(Boolean.parseBoolean(property));
            } else {
                bool = null;
            }
            obj = Result.m6329constructorimpl(bool);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (!Result.m6335isFailureimpl(obj)) {
            bool2 = obj;
        }
        Boolean bool3 = bool2;
        if (bool3 != null) {
            z11 = bool3.booleanValue();
        } else {
            z11 = DebugProbesImpl.INSTANCE.getEnableCreationStackTraces();
        }
        enableCreationStackTraces = z11;
    }

    private AgentPremain() {
    }

    private final void installSignalHandler() {
        try {
            Signal.handle(new Signal("TRAP"), new a());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: installSignalHandler$lambda-1  reason: not valid java name */
    private static final void m7821installSignalHandler$lambda1(Signal signal) {
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.INSTANCE;
        if (debugProbesImpl.isInstalled$kotlinx_coroutines_core()) {
            debugProbesImpl.dumpCoroutines(System.out);
        } else {
            System.out.println("Cannot perform coroutines dump, debug probes are disabled");
        }
    }

    @JvmStatic
    public static final void premain(@Nullable String str, @NotNull Instrumentation instrumentation) {
        AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
        instrumentation.addTransformer(DebugProbesTransformer.INSTANCE);
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.INSTANCE;
        debugProbesImpl.setEnableCreationStackTraces(enableCreationStackTraces);
        debugProbesImpl.install();
        INSTANCE.installSignalHandler();
    }
}
