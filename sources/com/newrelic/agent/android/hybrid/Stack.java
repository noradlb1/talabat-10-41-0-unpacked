package com.newrelic.agent.android.hybrid;

import com.newrelic.agent.android.hybrid.rninterface.IStack;
import com.newrelic.agent.android.hybrid.rninterface.IStackFrame;
import java.util.UUID;

public class Stack implements IStack {

    /* renamed from: id  reason: collision with root package name */
    private final String f52781id = UUID.randomUUID().toString();
    private StackFrame[] stackFrames;

    public Stack(StackFrame[] stackFrameArr) {
        this.stackFrames = stackFrameArr;
    }

    public String getId() {
        return this.f52781id;
    }

    public IStackFrame[] getStackFrames() {
        return this.stackFrames;
    }

    public boolean isThrowingThread() {
        return true;
    }
}
