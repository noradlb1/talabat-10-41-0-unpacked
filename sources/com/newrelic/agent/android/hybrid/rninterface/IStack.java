package com.newrelic.agent.android.hybrid.rninterface;

public interface IStack {
    String getId();

    IStackFrame[] getStackFrames();

    boolean isThrowingThread();
}
