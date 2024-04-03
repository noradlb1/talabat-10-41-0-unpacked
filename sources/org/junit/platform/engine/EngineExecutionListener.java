package org.junit.platform.engine;

import m30.h;
import org.apiguardian.api.API;
import org.junit.platform.engine.reporting.ReportEntry;

@API(since = "1.0", status = API.Status.STABLE)
public interface EngineExecutionListener {
    public static final EngineExecutionListener NOOP = new EngineExecutionListener() {
        public /* synthetic */ void dynamicTestRegistered(TestDescriptor testDescriptor) {
            h.a(this, testDescriptor);
        }

        public /* synthetic */ void executionFinished(TestDescriptor testDescriptor, TestExecutionResult testExecutionResult) {
            h.b(this, testDescriptor, testExecutionResult);
        }

        public /* synthetic */ void executionSkipped(TestDescriptor testDescriptor, String str) {
            h.c(this, testDescriptor, str);
        }

        public /* synthetic */ void executionStarted(TestDescriptor testDescriptor) {
            h.d(this, testDescriptor);
        }

        public /* synthetic */ void reportingEntryPublished(TestDescriptor testDescriptor, ReportEntry reportEntry) {
            h.e(this, testDescriptor, reportEntry);
        }
    };

    void dynamicTestRegistered(TestDescriptor testDescriptor);

    void executionFinished(TestDescriptor testDescriptor, TestExecutionResult testExecutionResult);

    void executionSkipped(TestDescriptor testDescriptor, String str);

    void executionStarted(TestDescriptor testDescriptor);

    void reportingEntryPublished(TestDescriptor testDescriptor, ReportEntry reportEntry);
}
