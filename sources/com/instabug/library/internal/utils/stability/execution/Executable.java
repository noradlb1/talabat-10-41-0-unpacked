package com.instabug.library.internal.utils.stability.execution;

@FunctionalInterface
public interface Executable {
    void execute() throws Exception;
}
