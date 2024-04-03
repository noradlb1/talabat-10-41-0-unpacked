package com.newrelic.agent.android.unity;

public class UnityException extends RuntimeException {
    private String sourceExceptionType;

    public UnityException() {
        this.sourceExceptionType = null;
    }

    public void appendStackFrame(StackTraceElement stackTraceElement) {
        StackTraceElement[] stackTrace = getStackTrace();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[(stackTrace.length + 1)];
        for (int i11 = 0; i11 < stackTrace.length; i11++) {
            stackTraceElementArr[i11] = stackTrace[i11];
        }
        stackTraceElementArr[stackTrace.length] = stackTraceElement;
        setStackTrace(stackTraceElementArr);
    }

    public void setSourceExceptionType(String str) {
        this.sourceExceptionType = str;
    }

    public String toString() {
        String str = this.sourceExceptionType;
        return (str == null || str.isEmpty()) ? getClass().getName() : this.sourceExceptionType;
    }

    public UnityException(String str, String str2) {
        super(str2);
        this.sourceExceptionType = str;
    }

    public UnityException(String str) {
        super(str);
        this.sourceExceptionType = null;
    }

    public UnityException(String str, StackTraceElement[] stackTraceElementArr) {
        super(str);
        this.sourceExceptionType = null;
        setStackTrace(stackTraceElementArr);
    }

    public void appendStackFrame(String str, String str2, String str3, int i11) {
        StackTraceElement stackTraceElement = new StackTraceElement(str, str2, str3, i11);
        StackTraceElement[] stackTrace = getStackTrace();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[(stackTrace.length + 1)];
        for (int i12 = 0; i12 < stackTrace.length; i12++) {
            stackTraceElementArr[i12] = stackTrace[i12];
        }
        stackTraceElementArr[stackTrace.length] = stackTraceElement;
        setStackTrace(stackTraceElementArr);
    }
}
