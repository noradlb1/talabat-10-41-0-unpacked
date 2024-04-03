package org.junit.platform.engine.support.descriptor;

import java.io.File;
import org.apiguardian.api.API;

@API(since = "1.0", status = API.Status.STABLE)
public interface FileSystemSource extends UriSource {
    File getFile();
}
