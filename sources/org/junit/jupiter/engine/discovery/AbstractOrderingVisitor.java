package org.junit.jupiter.engine.discovery;

import e30.a;
import e30.b;
import e30.c;
import e30.d;
import e30.e;
import e30.f;
import e30.g;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.jupiter.engine.discovery.AbstractAnnotatedDescriptorWrapper;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.UnrecoverableExceptions;
import org.junit.platform.engine.TestDescriptor;

abstract class AbstractOrderingVisitor<PARENT extends TestDescriptor, CHILD extends TestDescriptor, WRAPPER extends AbstractAnnotatedDescriptorWrapper<?>> implements TestDescriptor.Visitor {
    /* access modifiers changed from: private */
    public static final Logger logger = LoggerFactory.getLogger(AbstractOrderingVisitor.class);

    public class DescriptorWrapperOrderer {
        private final MessageGenerator descriptorsAddedMessageGenerator;
        private final MessageGenerator descriptorsRemovedMessageGenerator;
        private final Consumer<List<WRAPPER>> orderingAction;

        public DescriptorWrapperOrderer(Consumer<List<WRAPPER>> consumer, MessageGenerator messageGenerator, MessageGenerator messageGenerator2) {
            this.orderingAction = consumer;
            this.descriptorsAddedMessageGenerator = messageGenerator;
            this.descriptorsRemovedMessageGenerator = messageGenerator2;
        }

        /* access modifiers changed from: private */
        public boolean canOrderWrappers() {
            return this.orderingAction != null;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String lambda$logDescriptorsAddedWarning$0(int i11) {
            return this.descriptorsAddedMessageGenerator.generateMessage(i11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String lambda$logDescriptorsRemovedWarning$1(int i11) {
            return this.descriptorsRemovedMessageGenerator.generateMessage(Math.abs(i11));
        }

        /* access modifiers changed from: private */
        public void logDescriptorsAddedWarning(int i11) {
            AbstractOrderingVisitor.logger.warn(new f(this, i11));
        }

        /* access modifiers changed from: private */
        public void logDescriptorsRemovedWarning(int i11) {
            AbstractOrderingVisitor.logger.warn(new g(this, i11));
        }

        /* access modifiers changed from: private */
        public void orderWrappers(List<WRAPPER> list) {
            this.orderingAction.accept(list);
        }
    }

    @FunctionalInterface
    public interface MessageGenerator {
        String generateMessage(int i11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$doWithMatchingDescriptor$0(Function function, TestDescriptor testDescriptor) {
        return (String) function.apply(testDescriptor);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$orderChildrenTestDescriptors$1(Class cls, TestDescriptor testDescriptor) {
        return !cls.isInstance(testDescriptor);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$orderChildrenTestDescriptors$2(DescriptorWrapperOrderer descriptorWrapperOrderer, Class cls, Function function, AbstractAnnotatedDescriptorWrapper abstractAnnotatedDescriptorWrapper) {
        g(abstractAnnotatedDescriptorWrapper.b(), cls, function, f(descriptorWrapperOrderer, abstractAnnotatedDescriptorWrapper));
    }

    public void e(Class<PARENT> cls, TestDescriptor testDescriptor, Consumer<PARENT> consumer, Function<PARENT, String> function) {
        if (cls.isInstance(testDescriptor)) {
            try {
                consumer.accept(testDescriptor);
            } catch (Throwable th2) {
                UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
                logger.error(th2, new e(function, testDescriptor));
            }
        }
    }

    public AbstractOrderingVisitor<PARENT, CHILD, WRAPPER>.DescriptorWrapperOrderer f(AbstractOrderingVisitor<PARENT, CHILD, WRAPPER>.DescriptorWrapperOrderer descriptorWrapperOrderer, AbstractAnnotatedDescriptorWrapper<?> abstractAnnotatedDescriptorWrapper) {
        return descriptorWrapperOrderer;
    }

    public void g(TestDescriptor testDescriptor, Class<CHILD> cls, Function<CHILD, WRAPPER> function, AbstractOrderingVisitor<PARENT, CHILD, WRAPPER>.DescriptorWrapperOrderer descriptorWrapperOrderer) {
        Set<? extends TestDescriptor> children = testDescriptor.getChildren();
        Stream stream = Collection.EL.stream(children);
        Objects.requireNonNull(cls);
        List list = (List) stream.filter(new a(cls)).map(new b(cls)).map(function).collect(Collectors.toCollection(new c()));
        if (!list.isEmpty()) {
            if (descriptorWrapperOrderer.canOrderWrappers()) {
                List list2 = (List) Collection.EL.stream(children).filter(new b(cls)).collect(Collectors.toList());
                LinkedHashSet linkedHashSet = new LinkedHashSet(list);
                descriptorWrapperOrderer.orderWrappers(list);
                int size = list.size() - linkedHashSet.size();
                if (size > 0) {
                    descriptorWrapperOrderer.logDescriptorsAddedWarning(size);
                } else if (size < 0) {
                    descriptorWrapperOrderer.logDescriptorsRemovedWarning(size);
                }
                Set set = (Set) Collection.EL.stream(list).filter(new c(linkedHashSet)).map(new d()).collect(Collectors.toCollection(new d30.b()));
                Stream.CC.concat(Collection.EL.stream(set), Collection.EL.stream(list2)).forEach(new d(testDescriptor));
                if (cls == ClassBasedTestDescriptor.class) {
                    Stream.CC.concat(Collection.EL.stream(list2), Collection.EL.stream(set)).forEach(new e(testDescriptor));
                } else {
                    Stream.CC.concat(Collection.EL.stream(set), Collection.EL.stream(list2)).forEach(new e(testDescriptor));
                }
            }
            Iterable.EL.forEach(list, new a(this, descriptorWrapperOrderer, cls, function));
        }
    }
}
