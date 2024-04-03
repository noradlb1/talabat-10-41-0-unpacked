package org.junit.platform.engine.support.descriptor;

import j$.util.Optional;
import j$.util.function.Supplier;
import java.net.URI;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.TestSource;
import p30.e;

@API(since = "1.0", status = API.Status.STABLE)
public class ClasspathResourceSource implements TestSource {
    public static final String CLASSPATH_SCHEME = "classpath";
    private static final long serialVersionUID = 1;
    private final String classpathResourceName;
    private final FilePosition filePosition;

    private ClasspathResourceSource(String str) {
        this(str, (FilePosition) null);
    }

    public static ClasspathResourceSource from(String str) {
        return new ClasspathResourceSource(str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$from$0(URI uri) {
        return "URI [" + uri + "] must have [" + CLASSPATH_SCHEME + "] scheme";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClasspathResourceSource classpathResourceSource = (ClasspathResourceSource) obj;
        if (!Objects.equals(this.classpathResourceName, classpathResourceSource.classpathResourceName) || !Objects.equals(this.filePosition, classpathResourceSource.filePosition)) {
            return false;
        }
        return true;
    }

    public String getClasspathResourceName() {
        return this.classpathResourceName;
    }

    public final Optional<FilePosition> getPosition() {
        return Optional.ofNullable(this.filePosition);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.classpathResourceName, this.filePosition});
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("classpathResourceName", this.classpathResourceName).append("filePosition", this.filePosition).toString();
    }

    private ClasspathResourceSource(String str, FilePosition filePosition2) {
        Preconditions.notBlank(str, "Classpath resource name must not be null or blank");
        this.classpathResourceName = str.startsWith("/") ? str.substring(1) : str;
        this.filePosition = filePosition2;
    }

    public static ClasspathResourceSource from(String str, FilePosition filePosition2) {
        return new ClasspathResourceSource(str, filePosition2);
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public static ClasspathResourceSource from(URI uri) {
        Preconditions.notNull(uri, "URI must not be null");
        Preconditions.condition(CLASSPATH_SCHEME.equals(uri.getScheme()), (Supplier<String>) new e(uri));
        return from(ResourceUtils.a(uri).getPath(), FilePosition.fromQuery(uri.getQuery()).orElse(null));
    }
}
