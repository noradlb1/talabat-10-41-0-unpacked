package org.junit.jupiter.engine.execution;

import f30.r;
import f30.s;
import f30.t;
import j$.util.Collection;
import j$.util.Optional;
import j$.util.stream.Collectors;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import org.apiguardian.api.API;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.StringUtils;
import org.junit.platform.commons.util.UnrecoverableExceptions;

@API(since = "5.9", status = API.Status.INTERNAL)
public class ParameterResolutionUtils {
    private static final Logger logger = LoggerFactory.getLogger(ParameterResolutionUtils.class);

    private static String asLabel(Executable executable) {
        return executable instanceof Constructor ? "constructor" : "method";
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$resolveParameter$1(ParameterResolver parameterResolver, Object obj, ParameterContext parameterContext, Executable executable) {
        String str;
        Object[] objArr = new Object[5];
        objArr[0] = parameterResolver.getClass().getName();
        if (obj != null) {
            str = obj.getClass().getName();
        } else {
            str = null;
        }
        objArr[1] = str;
        objArr[2] = parameterContext.getParameter();
        objArr[3] = asLabel(executable);
        objArr[4] = executable.toGenericString();
        return String.format("ParameterResolver [%s] resolved a value of type [%s] for parameter [%s] in %s [%s].", objArr);
    }

    private static Object resolveParameter(ParameterContext parameterContext, Executable executable, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) {
        try {
            List list = (List) extensionRegistry.stream(ParameterResolver.class).filter(new r(parameterContext, extensionContext)).collect(Collectors.toList());
            if (list.isEmpty()) {
                throw new ParameterResolutionException(String.format("No ParameterResolver registered for parameter [%s] in %s [%s].", new Object[]{parameterContext.getParameter(), asLabel(executable), executable.toGenericString()}));
            } else if (list.size() <= 1) {
                ParameterResolver parameterResolver = (ParameterResolver) list.get(0);
                Object resolveParameter = parameterResolver.resolveParameter(parameterContext, extensionContext);
                validateResolvedType(parameterContext.getParameter(), resolveParameter, executable, parameterResolver);
                logger.trace(new t(parameterResolver, resolveParameter, parameterContext, executable));
                return resolveParameter;
            } else {
                throw new ParameterResolutionException(String.format("Discovered multiple competing ParameterResolvers for parameter [%s] in %s [%s]: %s", new Object[]{parameterContext.getParameter(), asLabel(executable), executable.toGenericString(), (String) Collection.EL.stream(list).map(new s()).collect(Collectors.joining(IndicativeSentencesGeneration.DEFAULT_SEPARATOR))}));
            }
        } catch (ParameterResolutionException e11) {
            throw e11;
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            String format = String.format("Failed to resolve parameter [%s] in %s [%s]", new Object[]{parameterContext.getParameter(), asLabel(executable), executable.toGenericString()});
            if (StringUtils.isNotBlank(th2.getMessage())) {
                format = format + ": " + th2.getMessage();
            }
            throw new ParameterResolutionException(format, th2);
        }
    }

    public static Object[] resolveParameters(Method method, Optional<Object> optional, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) {
        return resolveParameters(method, optional, Optional.empty(), extensionContext, extensionRegistry);
    }

    private static void validateResolvedType(Parameter parameter, Object obj, Executable executable, ParameterResolver parameterResolver) {
        String str;
        String str2;
        Class a11 = parameter.getType();
        if (!ReflectionUtils.isAssignableTo(obj, (Class<?>) a11)) {
            if (obj != null || !a11.isPrimitive()) {
                Object[] objArr = new Object[6];
                objArr[0] = parameterResolver.getClass().getName();
                if (obj != null) {
                    str2 = obj.getClass().getName();
                } else {
                    str2 = null;
                }
                objArr[1] = str2;
                objArr[2] = parameter;
                objArr[3] = asLabel(executable);
                objArr[4] = executable.toGenericString();
                objArr[5] = a11.getName();
                str = String.format("ParameterResolver [%s] resolved a value of type [%s] for parameter [%s] in %s [%s], but a value assignment compatible with [%s] is required.", objArr);
            } else {
                str = String.format("ParameterResolver [%s] resolved a null value for parameter [%s] in %s [%s], but a primitive of type [%s] is required.", new Object[]{parameterResolver.getClass().getName(), parameter, asLabel(executable), executable.toGenericString(), a11.getName()});
            }
            throw new ParameterResolutionException(str);
        }
    }

    public static Object[] resolveParameters(Executable executable, Optional<Object> optional, Optional<Object> optional2, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) {
        Preconditions.notNull(optional, "target must not be null");
        Parameter[] a11 = executable.getParameters();
        Object[] objArr = new Object[a11.length];
        int i11 = 0;
        if (optional2.isPresent()) {
            objArr[0] = optional2.get();
            i11 = 1;
        }
        while (i11 < a11.length) {
            objArr[i11] = resolveParameter(new DefaultParameterContext(a11[i11], i11, optional), executable, extensionContext, extensionRegistry);
            i11++;
        }
        return objArr;
    }
}
