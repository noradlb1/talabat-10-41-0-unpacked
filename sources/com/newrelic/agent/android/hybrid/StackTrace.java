package com.newrelic.agent.android.hybrid;

import com.newrelic.agent.android.hybrid.rninterface.IStack;
import com.newrelic.agent.android.hybrid.rninterface.IStackTrace;
import com.newrelic.agent.android.hybrid.rninterface.IStackTraceException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

public class StackTrace extends Throwable implements IStackTrace {
    private Map<String, Object> attributes;
    private final String buildId;
    private final boolean isFatal;
    private final IStackTraceException rnStackTraceException;
    private IStack[] rnStacks;
    private final UUID stackId;

    public StackTrace(String str, String str2, String str3, boolean z11, String str4) {
        this(str, str2, str3, z11, str4, (Map<String, Object>) null);
    }

    public String getBuildId() {
        return this.buildId;
    }

    public Map<String, Object> getCustomAttributes() {
        return this.attributes;
    }

    public String getStackId() {
        return this.stackId.toString();
    }

    public IStackTraceException getStackTraceException() {
        return this.rnStackTraceException;
    }

    public String getStackType() {
        return "ReactNative";
    }

    public IStack[] getStacks() {
        return this.rnStacks;
    }

    public boolean isFatal() {
        return this.isFatal;
    }

    public StackTrace(String str, String str2, String str3, boolean z11, String str4, Map<String, Object> map) {
        this.rnStacks = null;
        this.attributes = new HashMap();
        if (str3 == null || str3.isEmpty()) {
            throw new IllegalArgumentException("Cannot create a RNStackTrace without a stack.");
        }
        this.stackId = UUID.randomUUID();
        this.isFatal = z11;
        this.buildId = str4;
        if (map != null) {
            this.attributes = map;
        }
        String[] split = str3.split(StringUtils.LF);
        this.rnStackTraceException = new StackTraceException((str == null || str.isEmpty()) ? str3.split(StringUtils.LF)[0] : str, (str2 == null || str2.isEmpty()) ? str3.split(StringUtils.LF)[0] : str2);
        int length = split.length - 1;
        if (length > 0) {
            StackFrame[] stackFrameArr = new StackFrame[length];
            for (int i11 = 1; i11 < length + 1; i11++) {
                stackFrameArr[i11 - 1] = new StackFrame(split[i11]);
            }
            Stack[] stackArr = new Stack[1];
            this.rnStacks = stackArr;
            stackArr[0] = new Stack(stackFrameArr);
        }
    }
}
