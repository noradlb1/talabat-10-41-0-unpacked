package g30;

import java.util.Map;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtensionContext;
import x20.m0;

public final /* synthetic */ class n implements TestReporter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62087a;

    public /* synthetic */ n(ExtensionContext extensionContext) {
        this.f62087a = extensionContext;
    }

    public /* synthetic */ void publishEntry(String str) {
        m0.a(this, str);
    }

    public /* synthetic */ void publishEntry(String str, String str2) {
        m0.b(this, str, str2);
    }

    public final void publishEntry(Map map) {
        this.f62087a.publishReportEntry((Map<String, String>) map);
    }
}
