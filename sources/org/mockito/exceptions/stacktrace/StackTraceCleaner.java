package org.mockito.exceptions.stacktrace;

public interface StackTraceCleaner {
    boolean isIn(StackTraceElement stackTraceElement);
}
