package org.junit.jupiter.engine.extension;

import j$.util.Optional;
import j$.util.function.Supplier;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.Preconditions;

class RepeatedTestExtension implements TestTemplateInvocationContextProvider {
    private RepeatedTestDisplayNameFormatter displayNameFormatter(RepeatedTest repeatedTest, Method method, String str) {
        return new RepeatedTestDisplayNameFormatter(Preconditions.notBlank(repeatedTest.name().trim(), (Supplier<String>) new b(method)), str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TestTemplateInvocationContext lambda$provideTestTemplateInvocationContexts$0(int i11, RepeatedTestDisplayNameFormatter repeatedTestDisplayNameFormatter, int i12) {
        return new RepeatedTestInvocationContext(i12, i11, repeatedTestDisplayNameFormatter);
    }

    private int totalRepetitions(RepeatedTest repeatedTest, Method method) {
        boolean z11;
        int value = repeatedTest.value();
        if (value > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.condition(z11, (Supplier<String>) new c(method));
        return value;
    }

    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext extensionContext) {
        Method requiredTestMethod = extensionContext.getRequiredTestMethod();
        String displayName = extensionContext.getDisplayName();
        RepeatedTest repeatedTest = (RepeatedTest) AnnotationUtils.findAnnotation((AnnotatedElement) requiredTestMethod, RepeatedTest.class).get();
        int i11 = totalRepetitions(repeatedTest, requiredTestMethod);
        return IntStream.CC.rangeClosed(1, i11).mapToObj(new d(i11, displayNameFormatter(repeatedTest, requiredTestMethod, displayName)));
    }

    public boolean supportsTestTemplate(ExtensionContext extensionContext) {
        return AnnotationUtils.isAnnotated((Optional<? extends AnnotatedElement>) extensionContext.getTestMethod(), (Class<? extends Annotation>) RepeatedTest.class);
    }
}
