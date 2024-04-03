package t20;

import java.security.PrivilegedAction;
import java.util.Locale;
import org.apache.commons.compress.harmony.archive.internal.nls.Messages;

public final /* synthetic */ class a implements PrivilegedAction {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f28205b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Locale f28206c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClassLoader f28207d;

    public /* synthetic */ a(String str, Locale locale, ClassLoader classLoader) {
        this.f28205b = str;
        this.f28206c = locale;
        this.f28207d = classLoader;
    }

    public final Object run() {
        return Messages.lambda$setLocale$0(this.f28205b, this.f28206c, this.f28207d);
    }
}
