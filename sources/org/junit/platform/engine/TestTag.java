package org.junit.platform.engine;

import com.huawei.hms.framework.common.ContainerUtils;
import j$.util.Collection;
import j$.util.function.Supplier;
import j$.util.stream.Stream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import m30.s;
import m30.t;
import org.apiguardian.api.API;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.StringUtils;

@API(since = "1.0", status = API.Status.STABLE)
public final class TestTag implements Serializable {
    public static final Set<String> RESERVED_CHARACTERS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{",", "(", ")", ContainerUtils.FIELD_DELIMITER, "|", "!"})));
    private static final long serialVersionUID = 1;

    /* renamed from: name  reason: collision with root package name */
    private final String f28022name;

    private TestTag(String str) {
        Preconditions.condition(isValid(str), (Supplier<String>) new t(str));
        this.f28022name = str.trim();
    }

    public static TestTag create(String str) throws PreconditionViolationException {
        return new TestTag(str);
    }

    private static boolean doesNotContainReservedCharacter(String str) {
        Stream stream = Collection.EL.stream(RESERVED_CHARACTERS);
        Objects.requireNonNull(str);
        return stream.noneMatch(new s(str));
    }

    public static boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.isEmpty() || !StringUtils.doesNotContainWhitespace(trim) || !StringUtils.doesNotContainIsoControlCharacter(trim) || !doesNotContainReservedCharacter(trim)) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TestTag) {
            return Objects.equals(this.f28022name, ((TestTag) obj).f28022name);
        }
        return false;
    }

    public String getName() {
        return this.f28022name;
    }

    public int hashCode() {
        return this.f28022name.hashCode();
    }

    public String toString() {
        return this.f28022name;
    }
}
