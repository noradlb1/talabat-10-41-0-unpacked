package org.junit.platform.engine.support.descriptor;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.Preconditions;
import p30.j;

public final /* synthetic */ class a {
    public static UriSource a(URI uri) {
        Preconditions.notNull(uri, "URI must not be null");
        try {
            Path a11 = Paths.get(ResourceUtils.a(uri));
            if (Files.isRegularFile(a11, new LinkOption[0])) {
                return FileSource.from(a11.toFile(), FilePosition.fromQuery(uri.getQuery()).orElse(null));
            }
            if (Files.isDirectory(a11, new LinkOption[0])) {
                return DirectorySource.from(a11.toFile());
            }
            return new DefaultUriSource(uri);
        } catch (RuntimeException e11) {
            LoggerFactory.getLogger(UriSource.class).debug(e11, new j(uri));
        }
    }
}
