package com.talabat.core.testing.extensions;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a#\u0010\u0007\u001a\u0004\u0018\u00010\b\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\t\u001a#\u0010\n\u001a\u0004\u0018\u00010\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000b\u001a#\u0010\f\u001a\u0004\u0018\u00010\r\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"getResourceAsBufferedSource", "Lokio/BufferedSource;", "T", "", "filename", "", "(Ljava/lang/Object;Ljava/lang/String;)Lokio/BufferedSource;", "getResourceAsPath", "Ljava/nio/file/Path;", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/nio/file/Path;", "getResourceAsString", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;", "getResourceAsUri", "Ljava/net/URI;", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/net/URI;", "com_talabat_core_testing_extensions_extensions"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TestingExtensionsKt {
    @Nullable
    public static final <T> BufferedSource getResourceAsBufferedSource(@NotNull T t11, @NotNull String str) {
        File a11;
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(str, "filename");
        Path resourceAsPath = getResourceAsPath(t11, str);
        if (resourceAsPath == null || (a11 = resourceAsPath.toFile()) == null) {
            return null;
        }
        return Okio.buffer(Okio.source(a11));
    }

    @Nullable
    public static final <T> Path getResourceAsPath(@NotNull T t11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(str, "filename");
        URI resourceAsUri = getResourceAsUri(t11, str);
        if (resourceAsUri != null) {
            return Paths.get(resourceAsUri);
        }
        return null;
    }

    @Nullable
    public static final <T> String getResourceAsString(@NotNull T t11, @NotNull String str) {
        URL resource;
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(str, "filename");
        ClassLoader classLoader = t11.getClass().getClassLoader();
        if (classLoader == null || (resource = classLoader.getResource(str)) == null) {
            return null;
        }
        return resource.toString();
    }

    @Nullable
    public static final <T> URI getResourceAsUri(@NotNull T t11, @NotNull String str) {
        URL resource;
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(str, "filename");
        ClassLoader classLoader = t11.getClass().getClassLoader();
        if (classLoader == null || (resource = classLoader.getResource(str)) == null) {
            return null;
        }
        return resource.toURI();
    }
}
