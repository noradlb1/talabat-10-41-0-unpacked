package org.junit.platform.commons.util;

import j$.util.function.Consumer;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

class ClassFileVisitor extends SimpleFileVisitor<Path> {
    private static final String MODULE_INFO_FILE_NAME = "module-info.class";
    private static final String PACKAGE_INFO_FILE_NAME = "package-info.class";
    private static final Logger logger = LoggerFactory.getLogger(ClassFileVisitor.class);
    private final Consumer<Path> classFileConsumer;

    public ClassFileVisitor(Consumer<Path> consumer) {
        this.classFileConsumer = consumer;
    }

    private static boolean isClassFile(Path path) {
        return path.getFileName().toString().endsWith(".class");
    }

    private static boolean isNotModuleInfo(Path path) {
        return !path.endsWith(MODULE_INFO_FILE_NAME);
    }

    private static boolean isNotPackageInfo(Path path) {
        return !path.endsWith(PACKAGE_INFO_FILE_NAME);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$postVisitDirectory$1(Path path) {
        return "I/O error visiting directory: " + path;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$visitFileFailed$0(Path path) {
        return "I/O error visiting file: " + path;
    }

    public FileVisitResult postVisitDirectory(Path path, IOException iOException) {
        if (iOException != null) {
            logger.warn(iOException, new b(path));
        }
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
        if (isNotPackageInfo(path) && isNotModuleInfo(path) && isClassFile(path)) {
            this.classFileConsumer.accept(path);
        }
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(Path path, IOException iOException) {
        logger.warn(iOException, new a(path));
        return FileVisitResult.CONTINUE;
    }
}
