package org.junit.jupiter.engine.extension;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.engine.extension.TempDirectory;

public final /* synthetic */ class o implements TempDirectory.FileOperations {
    public final void delete(Path path) {
        Files.delete(path);
    }
}
