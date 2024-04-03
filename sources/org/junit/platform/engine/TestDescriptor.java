package org.junit.platform.engine;

import j$.util.Optional;
import java.util.Set;
import org.apiguardian.api.API;

@API(since = "1.0", status = API.Status.STABLE)
public interface TestDescriptor {

    public enum Type {
        CONTAINER,
        TEST,
        CONTAINER_AND_TEST;

        public boolean isContainer() {
            return this == CONTAINER || this == CONTAINER_AND_TEST;
        }

        public boolean isTest() {
            return this == TEST || this == CONTAINER_AND_TEST;
        }
    }

    @FunctionalInterface
    public interface Visitor {
        void visit(TestDescriptor testDescriptor);
    }

    void accept(Visitor visitor);

    void addChild(TestDescriptor testDescriptor);

    Optional<? extends TestDescriptor> findByUniqueId(UniqueId uniqueId);

    Set<? extends TestDescriptor> getChildren();

    Set<? extends TestDescriptor> getDescendants();

    String getDisplayName();

    String getLegacyReportingName();

    Optional<TestDescriptor> getParent();

    Optional<TestSource> getSource();

    Set<TestTag> getTags();

    Type getType();

    UniqueId getUniqueId();

    boolean isContainer();

    boolean isRoot();

    boolean isTest();

    boolean mayRegisterTests();

    void prune();

    void removeChild(TestDescriptor testDescriptor);

    void removeFromHierarchy();

    void setParent(TestDescriptor testDescriptor);
}
