package com.github.anrwatchdog;

import java.io.Serializable;

public class ANRError$$ implements Serializable {
    /* access modifiers changed from: private */
    public final String _name;
    /* access modifiers changed from: private */
    public final StackTraceElement[] _stackTrace;

    public class _Thread extends Throwable {
        public Throwable fillInStackTrace() {
            setStackTrace(ANRError$$.this._stackTrace);
            return this;
        }

        private _Thread(_Thread _thread) {
            super(ANRError$$.this._name, _thread);
        }
    }

    private ANRError$$(String str, StackTraceElement[] stackTraceElementArr) {
        this._name = str;
        this._stackTrace = stackTraceElementArr;
    }
}
