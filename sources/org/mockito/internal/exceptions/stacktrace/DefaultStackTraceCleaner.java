package org.mockito.internal.exceptions.stacktrace;

import org.mockito.exceptions.stacktrace.StackTraceCleaner;

public class DefaultStackTraceCleaner implements StackTraceCleaner {
    private static boolean isFromMockito(String str) {
        return str.startsWith("org.mockito.");
    }

    private static boolean isFromMockitoRule(String str) {
        return str.startsWith("org.mockito.internal.junit.JUnitRule");
    }

    private static boolean isFromMockitoRunner(String str) {
        if (str.startsWith("org.mockito.internal.runners.") || str.startsWith("org.mockito.runners.") || str.startsWith("org.mockito.junit.")) {
            return true;
        }
        return false;
    }

    private static boolean isMockDispatcher(String str) {
        if (str.contains("$$EnhancerByMockitoWithCGLIB$$") || str.contains("$MockitoMock$")) {
            return true;
        }
        return false;
    }

    public boolean isIn(StackTraceElement stackTraceElement) {
        if (isFromMockitoRunner(stackTraceElement.getClassName()) || isFromMockitoRule(stackTraceElement.getClassName())) {
            return true;
        }
        if (isMockDispatcher(stackTraceElement.getClassName()) || isFromMockito(stackTraceElement.getClassName())) {
            return false;
        }
        return true;
    }
}
