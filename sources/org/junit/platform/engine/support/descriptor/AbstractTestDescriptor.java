package org.junit.platform.engine.support.descriptor;

import d30.i0;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Optional;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import m30.o;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.TestTag;
import org.junit.platform.engine.UniqueId;
import p30.a;
import p30.b;

@API(since = "1.0", status = API.Status.STABLE)
public abstract class AbstractTestDescriptor implements TestDescriptor {

    /* renamed from: a  reason: collision with root package name */
    public final Set<TestDescriptor> f28053a;
    private final String displayName;
    private TestDescriptor parent;
    private final TestSource source;
    private final UniqueId uniqueId;

    public AbstractTestDescriptor(UniqueId uniqueId2, String str) {
        this(uniqueId2, str, (TestSource) null);
    }

    public /* synthetic */ void accept(TestDescriptor.Visitor visitor) {
        o.a(this, visitor);
    }

    public void addChild(TestDescriptor testDescriptor) {
        Preconditions.notNull(testDescriptor, "child must not be null");
        testDescriptor.setParent(this);
        this.f28053a.add(testDescriptor);
    }

    public final boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            return getUniqueId().equals(((TestDescriptor) obj).getUniqueId());
        }
        return false;
    }

    public Optional<? extends TestDescriptor> findByUniqueId(UniqueId uniqueId2) {
        Preconditions.notNull(uniqueId2, "UniqueId must not be null");
        if (getUniqueId().equals(uniqueId2)) {
            return Optional.of(this);
        }
        return (Optional) Collection.EL.stream(this.f28053a).map(new b(uniqueId2)).filter(new i0()).findAny().orElse(Optional.empty());
    }

    public final Set<? extends TestDescriptor> getChildren() {
        return Collections.unmodifiableSet(this.f28053a);
    }

    public /* synthetic */ Set getDescendants() {
        return o.b(this);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public /* synthetic */ String getLegacyReportingName() {
        return o.c(this);
    }

    public final Optional<TestDescriptor> getParent() {
        return Optional.ofNullable(this.parent);
    }

    public Optional<TestSource> getSource() {
        return Optional.ofNullable(this.source);
    }

    public Set<TestTag> getTags() {
        return Collections.emptySet();
    }

    public final UniqueId getUniqueId() {
        return this.uniqueId;
    }

    public final int hashCode() {
        return this.uniqueId.hashCode();
    }

    public /* synthetic */ boolean isContainer() {
        return o.d(this);
    }

    public /* synthetic */ boolean isRoot() {
        return o.e(this);
    }

    public /* synthetic */ boolean isTest() {
        return o.f(this);
    }

    public /* synthetic */ boolean mayRegisterTests() {
        return o.g(this);
    }

    public /* synthetic */ void prune() {
        o.h(this);
    }

    public void removeChild(TestDescriptor testDescriptor) {
        Preconditions.notNull(testDescriptor, "child must not be null");
        this.f28053a.remove(testDescriptor);
        testDescriptor.setParent((TestDescriptor) null);
    }

    public void removeFromHierarchy() {
        Preconditions.condition(!isRoot(), "cannot remove the root of a hierarchy");
        this.parent.removeChild(this);
        Iterable.EL.forEach(this.f28053a, new a());
        this.f28053a.clear();
    }

    public final void setParent(TestDescriptor testDescriptor) {
        this.parent = testDescriptor;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + getUniqueId();
    }

    public AbstractTestDescriptor(UniqueId uniqueId2, String str, TestSource testSource) {
        this.f28053a = Collections.synchronizedSet(new LinkedHashSet(16));
        this.uniqueId = (UniqueId) Preconditions.notNull(uniqueId2, "UniqueId must not be null");
        this.displayName = Preconditions.notBlank(str, "displayName must not be null or blank");
        this.source = testSource;
    }
}
