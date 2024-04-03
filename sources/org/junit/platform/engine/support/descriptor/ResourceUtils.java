package org.junit.platform.engine.support.descriptor;

import java.net.URI;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.StringUtils;

final class ResourceUtils {
    private ResourceUtils() {
    }

    public static URI a(URI uri) {
        Preconditions.notNull(uri, "URI must not be null");
        if (StringUtils.isBlank(uri.getQuery())) {
            return uri;
        }
        String uri2 = uri.toString();
        return URI.create(uri2.substring(0, uri2.indexOf(63)));
    }
}
