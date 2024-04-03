package org.junit.jupiter.api.condition;

import j$.util.DesugarArrays;
import net.bytebuddy.ClassFileVersion;
import org.junit.platform.commons.util.Preconditions;
import y20.f;
import y20.l;

class EnabledOnJreCondition extends BooleanExecutionCondition<EnabledOnJre> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f57111a = ("Enabled on JRE version: " + System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION));

    /* renamed from: b  reason: collision with root package name */
    public static final String f57112b = ("Disabled on JRE version: " + System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION));

    public EnabledOnJreCondition() {
        super(EnabledOnJre.class, f57111a, f57112b, new l());
    }

    /* renamed from: d */
    public boolean c(EnabledOnJre enabledOnJre) {
        boolean z11;
        JRE[] value = enabledOnJre.value();
        if (value.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.condition(z11, "You must declare at least one JRE in @EnabledOnJre");
        return DesugarArrays.stream((T[]) value).anyMatch(new f());
    }
}
