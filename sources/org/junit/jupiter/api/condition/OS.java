package org.junit.jupiter.api.condition;

import java.util.Locale;
import org.apiguardian.api.API;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.StringUtils;
import y20.o;

@API(since = "5.1", status = API.Status.STABLE)
public enum OS {
    AIX,
    FREEBSD,
    LINUX,
    MAC,
    OPENBSD,
    SOLARIS,
    WINDOWS,
    OTHER;
    
    private static final OS CURRENT_OS = null;
    private static final Logger logger = null;

    /* access modifiers changed from: public */
    static {
        logger = LoggerFactory.getLogger(OS.class);
        CURRENT_OS = determineCurrentOs();
    }

    public static OS b(String str) {
        if (StringUtils.isBlank(str)) {
            logger.debug(new o());
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (lowerCase.contains("aix")) {
            return AIX;
        }
        if (lowerCase.contains("freebsd")) {
            return FREEBSD;
        }
        if (lowerCase.contains("linux")) {
            return LINUX;
        }
        if (lowerCase.contains("mac")) {
            return MAC;
        }
        if (lowerCase.contains("openbsd")) {
            return OPENBSD;
        }
        if (lowerCase.contains("sunos") || lowerCase.contains("solaris")) {
            return SOLARIS;
        }
        if (lowerCase.contains("win")) {
            return WINDOWS;
        }
        return OTHER;
    }

    @API(since = "5.9", status = API.Status.EXPERIMENTAL)
    public static OS current() {
        return CURRENT_OS;
    }

    private static OS determineCurrentOs() {
        return b(System.getProperty("os.name"));
    }

    public boolean isCurrentOs() {
        return this == CURRENT_OS;
    }
}
