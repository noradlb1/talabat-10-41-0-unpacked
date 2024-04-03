package org.junit.platform.engine.support.descriptor;

import com.newrelic.agent.android.agentdata.HexAttribute;
import j$.util.Optional;
import j$.util.function.Supplier;
import java.net.URI;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.TestSource;
import p30.c;
import p30.d;

@API(since = "1.0", status = API.Status.STABLE)
public class ClassSource implements TestSource {
    @API(since = "1.8", status = API.Status.STABLE)
    public static final String CLASS_SCHEME = "class";
    private static final long serialVersionUID = 1;
    private final String className;
    private final FilePosition filePosition;
    private Class<?> javaClass;

    private ClassSource(String str) {
        this(str, (FilePosition) null);
    }

    public static ClassSource from(String str) {
        return new ClassSource(str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$from$0(URI uri) {
        return "URI [" + uri + "] must have [" + "class" + "] scheme";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ PreconditionViolationException lambda$getJavaClass$1(Exception exc) {
        return new PreconditionViolationException("Could not load class with name: " + this.className, exc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClassSource classSource = (ClassSource) obj;
        if (!Objects.equals(this.className, classSource.className) || !Objects.equals(this.filePosition, classSource.filePosition)) {
            return false;
        }
        return true;
    }

    public final String getClassName() {
        return this.className;
    }

    public final Class<?> getJavaClass() {
        if (this.javaClass == null) {
            this.javaClass = ReflectionUtils.tryToLoadClass(this.className).getOrThrow(new d(this));
        }
        return this.javaClass;
    }

    public final Optional<FilePosition> getPosition() {
        return Optional.ofNullable(this.filePosition);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.className, this.filePosition});
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append(HexAttribute.HEX_ATTR_CLASS_NAME, this.className).append("filePosition", this.filePosition).toString();
    }

    private ClassSource(String str, FilePosition filePosition2) {
        this.className = Preconditions.notBlank(str, "Class name must not be null or blank");
        this.filePosition = filePosition2;
    }

    public static ClassSource from(String str, FilePosition filePosition2) {
        return new ClassSource(str, filePosition2);
    }

    public static ClassSource from(Class<?> cls) {
        return new ClassSource(cls);
    }

    public static ClassSource from(Class<?> cls, FilePosition filePosition2) {
        return new ClassSource(cls, filePosition2);
    }

    private ClassSource(Class<?> cls) {
        this(cls, (FilePosition) null);
    }

    @API(since = "1.8", status = API.Status.STABLE)
    public static ClassSource from(URI uri) {
        Preconditions.notNull(uri, "URI must not be null");
        Preconditions.condition("class".equals(uri.getScheme()), (Supplier<String>) new c(uri));
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        int indexOf = schemeSpecificPart.indexOf(63);
        FilePosition filePosition2 = null;
        if (indexOf >= 0) {
            filePosition2 = FilePosition.fromQuery(schemeSpecificPart.substring(indexOf + 1)).orElse(null);
            schemeSpecificPart = schemeSpecificPart.substring(0, indexOf);
        }
        return from(schemeSpecificPart, filePosition2);
    }

    private ClassSource(Class<?> cls, FilePosition filePosition2) {
        Class<?> cls2 = (Class) Preconditions.notNull(cls, "Class must not be null");
        this.javaClass = cls2;
        this.className = cls2.getName();
        this.filePosition = filePosition2;
    }
}
