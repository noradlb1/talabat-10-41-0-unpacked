package net.bytebuddy.agent.builder;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.Iterator;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.utility.JavaModule;

public interface ResettableClassFileTransformer extends ClassFileTransformer {

    public static abstract class AbstractBase implements ResettableClassFileTransformer {
        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy) {
            return reset(instrumentation, redefinitionStrategy, (AgentBuilder.RedefinitionStrategy.BatchAllocator) AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE);
        }

        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator) {
            return reset(instrumentation, redefinitionStrategy, batchAllocator, (AgentBuilder.RedefinitionStrategy.Listener) AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE);
        }

        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy) {
            return reset(instrumentation, redefinitionStrategy, discoveryStrategy, (AgentBuilder.RedefinitionStrategy.Listener) AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE);
        }

        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy) {
            return reset(instrumentation, redefinitionStrategy, discoveryStrategy, batchAllocator, AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE);
        }

        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.Listener listener) {
            return reset(instrumentation, redefinitionStrategy, discoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE, listener);
        }

        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener) {
            return reset(instrumentation, redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.SinglePass.INSTANCE, batchAllocator, listener);
        }

        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener) {
            return reset(instrumentation, this, redefinitionStrategy, discoveryStrategy, batchAllocator, listener);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class WithDelegation extends AbstractBase {

        /* renamed from: a  reason: collision with root package name */
        public final ResettableClassFileTransformer f26976a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.f26976a.equals(((WithDelegation) obj).f26976a);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.f26976a.hashCode();
        }

        public Iterator<AgentBuilder.Transformer> iterator(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain) {
            return this.f26976a.iterator(typeDescription, classLoader, javaModule, cls, protectionDomain);
        }

        public boolean reset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener) {
            return this.f26976a.reset(instrumentation, resettableClassFileTransformer, redefinitionStrategy, discoveryStrategy, batchAllocator, listener);
        }
    }

    Iterator<AgentBuilder.Transformer> iterator(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, Class<?> cls, ProtectionDomain protectionDomain);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.Listener listener);

    boolean reset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener);
}
