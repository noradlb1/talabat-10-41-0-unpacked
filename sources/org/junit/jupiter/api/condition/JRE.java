package org.junit.jupiter.api.condition;

import java.util.EnumSet;
import net.bytebuddy.ClassFileVersion;
import org.apiguardian.api.API;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.StringUtils;
import y20.m;
import y20.n;

@API(since = "5.1", status = API.Status.STABLE)
public enum JRE {
    JAVA_8,
    JAVA_9,
    JAVA_10,
    JAVA_11,
    JAVA_12,
    JAVA_13,
    JAVA_14,
    JAVA_15,
    JAVA_16,
    JAVA_17,
    JAVA_18,
    JAVA_19,
    JAVA_20,
    OTHER;
    
    private static final JRE CURRENT_VERSION = null;
    private static final Logger logger = null;

    /* access modifiers changed from: public */
    static {
        logger = LoggerFactory.getLogger(JRE.class);
        CURRENT_VERSION = determineCurrentVersion();
    }

    public static boolean c(JRE jre, JRE jre2) {
        return EnumSet.range(jre, jre2).contains(CURRENT_VERSION);
    }

    @API(since = "5.7", status = API.Status.STABLE)
    public static JRE currentVersion() {
        return CURRENT_VERSION;
    }

    private static JRE determineCurrentVersion() {
        String property = System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION);
        boolean isBlank = StringUtils.isBlank(property);
        if (isBlank) {
            logger.debug(new m());
        }
        if (!isBlank && property.startsWith("1.8")) {
            return JAVA_8;
        }
        try {
            Object invokeMethod = ReflectionUtils.invokeMethod(Runtime.class.getMethod("version", new Class[0]), (Object) null, new Object[0]);
            switch (((Integer) ReflectionUtils.invokeMethod(invokeMethod.getClass().getMethod("major", new Class[0]), invokeMethod, new Object[0])).intValue()) {
                case 9:
                    return JAVA_9;
                case 10:
                    return JAVA_10;
                case 11:
                    return JAVA_11;
                case 12:
                    return JAVA_12;
                case 13:
                    return JAVA_13;
                case 14:
                    return JAVA_14;
                case 15:
                    return JAVA_15;
                case 16:
                    return JAVA_16;
                case 17:
                    return JAVA_17;
                case 18:
                    return JAVA_18;
                case 19:
                    return JAVA_19;
                case 20:
                    return JAVA_20;
                default:
                    return OTHER;
            }
        } catch (Exception e11) {
            logger.debug(e11, new n());
            return null;
        }
    }

    public boolean isCurrentVersion() {
        return this == CURRENT_VERSION;
    }
}
