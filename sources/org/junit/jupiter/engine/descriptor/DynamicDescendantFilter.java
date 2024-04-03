package org.junit.jupiter.engine.descriptor;

import d30.l0;
import j$.util.Collection;
import j$.util.function.BiPredicate;
import java.util.HashSet;
import java.util.Set;
import org.apiguardian.api.API;
import org.junit.platform.engine.UniqueId;

@API(since = "5.1", status = API.Status.INTERNAL)
public class DynamicDescendantFilter implements BiPredicate<UniqueId, Integer> {
    private final Set<Integer> allowedIndices = new HashSet();
    private final Set<UniqueId> allowedUniqueIds = new HashSet();
    private Mode mode = Mode.EXPLICIT;

    public enum Mode {
        EXPLICIT,
        ALLOW_ALL
    }

    public class WithoutIndexFiltering extends DynamicDescendantFilter {
        private WithoutIndexFiltering() {
        }

        public DynamicDescendantFilter withoutIndexFiltering() {
            return this;
        }

        public boolean test(UniqueId uniqueId, Integer num) {
            return DynamicDescendantFilter.this.isEverythingAllowed() || DynamicDescendantFilter.this.isUniqueIdAllowed(uniqueId);
        }
    }

    /* access modifiers changed from: private */
    public boolean isEverythingAllowed() {
        return this.allowedUniqueIds.isEmpty() && this.allowedIndices.isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: isPrefixOrViceVersa */
    public boolean lambda$isUniqueIdAllowed$0(UniqueId uniqueId, UniqueId uniqueId2) {
        return uniqueId2.hasPrefix(uniqueId) || uniqueId.hasPrefix(uniqueId2);
    }

    /* access modifiers changed from: private */
    public boolean isUniqueIdAllowed(UniqueId uniqueId) {
        return Collection.EL.stream(this.allowedUniqueIds).anyMatch(new l0(this, uniqueId));
    }

    public void allowAll() {
        this.mode = Mode.ALLOW_ALL;
        this.allowedUniqueIds.clear();
        this.allowedIndices.clear();
    }

    public void allowIndex(Set<Integer> set) {
        if (this.mode == Mode.EXPLICIT) {
            this.allowedIndices.addAll(set);
        }
    }

    public void allowUniqueIdPrefix(UniqueId uniqueId) {
        if (this.mode == Mode.EXPLICIT) {
            this.allowedUniqueIds.add(uniqueId);
        }
    }

    public /* synthetic */ BiPredicate and(BiPredicate biPredicate) {
        return BiPredicate.CC.$default$and(this, biPredicate);
    }

    public /* synthetic */ BiPredicate negate() {
        return BiPredicate.CC.$default$negate(this);
    }

    public /* synthetic */ BiPredicate or(BiPredicate biPredicate) {
        return BiPredicate.CC.$default$or(this, biPredicate);
    }

    public DynamicDescendantFilter withoutIndexFiltering() {
        return new WithoutIndexFiltering();
    }

    public boolean test(UniqueId uniqueId, Integer num) {
        return isEverythingAllowed() || isUniqueIdAllowed(uniqueId) || this.allowedIndices.contains(num);
    }
}
