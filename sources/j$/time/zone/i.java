package j$.time.zone;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;

final class i extends j {

    /* renamed from: c  reason: collision with root package name */
    private final Set f28537c;

    i() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String add : TimeZone.getAvailableIDs()) {
            linkedHashSet.add(add);
        }
        this.f28537c = Collections.unmodifiableSet(linkedHashSet);
    }

    /* access modifiers changed from: protected */
    public final f b(String str) {
        if (this.f28537c.contains(str)) {
            return new f(TimeZone.getTimeZone(str));
        }
        throw new g("Not a built-in time zone: " + str);
    }

    /* access modifiers changed from: protected */
    public final Set c() {
        return this.f28537c;
    }
}
