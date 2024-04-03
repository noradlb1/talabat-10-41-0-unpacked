package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.core.ChildEventRegistration;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.ValueEventRegistration;
import com.google.firebase.database.core.ZombieEventManager;
import com.google.firebase.database.core.utilities.PushIdGenerator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.BooleanNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.PathIndex;
import com.google.firebase.database.snapshot.PriorityIndex;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.snapshot.StringNode;
import com.google.firebase.database.snapshot.ValueIndex;

public class Query {
    private final boolean orderByCalled;
    protected final QueryParams params;
    protected final Path path;
    protected final Repo repo;

    public Query(Repo repo2, Path path2, QueryParams queryParams, boolean z11) throws DatabaseException {
        this.repo = repo2;
        this.path = path2;
        this.params = queryParams;
        this.orderByCalled = z11;
        Utilities.hardAssert(queryParams.isValid(), "Validation of queries failed.");
    }

    private void addEventRegistration(final EventRegistration eventRegistration) {
        ZombieEventManager.getInstance().recordEventRegistration(eventRegistration);
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                Query.this.repo.addEventCallback(eventRegistration);
            }
        });
    }

    private void removeEventRegistration(final EventRegistration eventRegistration) {
        ZombieEventManager.getInstance().zombifyForRemove(eventRegistration);
        this.repo.scheduleNow(new Runnable() {
            public void run() {
                Query.this.repo.removeEventCallback(eventRegistration);
            }
        });
    }

    private void validateEqualToCall() {
        if (this.params.hasStart()) {
            throw new IllegalArgumentException("Cannot combine equalTo() with startAt() or startAfter()");
        } else if (this.params.hasEnd()) {
            throw new IllegalArgumentException("Cannot combine equalTo() with endAt() or endBefore()");
        }
    }

    private void validateLimit(QueryParams queryParams) {
        if (queryParams.hasStart() && queryParams.hasEnd() && queryParams.hasLimit() && !queryParams.hasAnchoredLimit()) {
            throw new IllegalArgumentException("Can't combine startAt(), startAfter(), endAt(), endBefore(), and limit(). Use limitToFirst() or limitToLast() instead");
        }
    }

    private void validateNoOrderByCall() {
        if (this.orderByCalled) {
            throw new IllegalArgumentException("You can't combine multiple orderBy calls!");
        }
    }

    private void validateQueryEndpoints(QueryParams queryParams) {
        if (queryParams.getIndex().equals(KeyIndex.getInstance())) {
            if (queryParams.hasStart()) {
                Node indexStartValue = queryParams.getIndexStartValue();
                if (!Objects.equal(queryParams.getIndexStartName(), ChildKey.getMinName()) || !(indexStartValue instanceof StringNode)) {
                    throw new IllegalArgumentException("You must use startAt(String value), startAfter(String value), endAt(String value), endBefore(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
                }
            }
            if (queryParams.hasEnd()) {
                Node indexEndValue = queryParams.getIndexEndValue();
                if (!queryParams.getIndexEndName().equals(ChildKey.getMaxName()) || !(indexEndValue instanceof StringNode)) {
                    throw new IllegalArgumentException("You must use startAt(String value), startAfter(String value), endAt(String value), endBefore(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
                }
            }
        } else if (!queryParams.getIndex().equals(PriorityIndex.getInstance())) {
        } else {
            if ((queryParams.hasStart() && !PriorityUtilities.isValidPriority(queryParams.getIndexStartValue())) || (queryParams.hasEnd() && !PriorityUtilities.isValidPriority(queryParams.getIndexEndValue()))) {
                throw new IllegalArgumentException("When using orderByPriority(), values provided to startAt(), startAfter(), endAt(), endBefore(), or equalTo() must be valid priorities.");
            }
        }
    }

    @NonNull
    public ChildEventListener addChildEventListener(@NonNull ChildEventListener childEventListener) {
        addEventRegistration(new ChildEventRegistration(this.repo, childEventListener, getSpec()));
        return childEventListener;
    }

    public void addListenerForSingleValueEvent(@NonNull final ValueEventListener valueEventListener) {
        addEventRegistration(new ValueEventRegistration(this.repo, new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
                valueEventListener.onCancelled(databaseError);
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                Query.this.removeEventListener((ValueEventListener) this);
                valueEventListener.onDataChange(dataSnapshot);
            }
        }, getSpec()));
    }

    @NonNull
    public ValueEventListener addValueEventListener(@NonNull ValueEventListener valueEventListener) {
        addEventRegistration(new ValueEventRegistration(this.repo, valueEventListener, getSpec()));
        return valueEventListener;
    }

    @NonNull
    public Query endAt(@Nullable String str) {
        return endAt(str, (String) null);
    }

    @NonNull
    public Query endBefore(@Nullable String str) {
        if (str == null || !this.params.getIndex().equals(KeyIndex.getInstance())) {
            return endAt(str, ChildKey.getMinName().asString());
        }
        return endAt(PushIdGenerator.predecessor(str));
    }

    @NonNull
    public Query equalTo(@Nullable String str) {
        validateEqualToCall();
        return startAt(str).endAt(str);
    }

    @NonNull
    public Task<DataSnapshot> get() {
        return this.repo.getValue(this);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Path getPath() {
        return this.path;
    }

    @NonNull
    public DatabaseReference getRef() {
        return new DatabaseReference(this.repo, getPath());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Repo getRepo() {
        return this.repo;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public QuerySpec getSpec() {
        return new QuerySpec(this.path, this.params);
    }

    public void keepSynced(final boolean z11) {
        if (this.path.isEmpty() || !this.path.getFront().equals(ChildKey.getInfoKey())) {
            this.repo.scheduleNow(new Runnable() {
                public void run() {
                    Query query = Query.this;
                    query.repo.keepSynced(query.getSpec(), z11);
                }
            });
            return;
        }
        throw new DatabaseException("Can't call keepSynced() on .info paths.");
    }

    @NonNull
    public Query limitToFirst(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.params.hasLimit()) {
            return new Query(this.repo, this.path, this.params.limitToFirst(i11), this.orderByCalled);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    @NonNull
    public Query limitToLast(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.params.hasLimit()) {
            return new Query(this.repo, this.path, this.params.limitToLast(i11), this.orderByCalled);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    @NonNull
    public Query orderByChild(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("Key can't be null");
        } else if (str.equals("$key") || str.equals(".key")) {
            throw new IllegalArgumentException("Can't use '" + str + "' as path, please use orderByKey() instead!");
        } else if (str.equals("$priority") || str.equals(".priority")) {
            throw new IllegalArgumentException("Can't use '" + str + "' as path, please use orderByPriority() instead!");
        } else if (str.equals("$value") || str.equals(".value")) {
            throw new IllegalArgumentException("Can't use '" + str + "' as path, please use orderByValue() instead!");
        } else {
            Validation.validatePathString(str);
            validateNoOrderByCall();
            Path path2 = new Path(str);
            if (path2.size() != 0) {
                return new Query(this.repo, this.path, this.params.orderBy(new PathIndex(path2)), true);
            }
            throw new IllegalArgumentException("Can't use empty path, use orderByValue() instead!");
        }
    }

    @NonNull
    public Query orderByKey() {
        validateNoOrderByCall();
        QueryParams orderBy = this.params.orderBy(KeyIndex.getInstance());
        validateQueryEndpoints(orderBy);
        return new Query(this.repo, this.path, orderBy, true);
    }

    @NonNull
    public Query orderByPriority() {
        validateNoOrderByCall();
        QueryParams orderBy = this.params.orderBy(PriorityIndex.getInstance());
        validateQueryEndpoints(orderBy);
        return new Query(this.repo, this.path, orderBy, true);
    }

    @NonNull
    public Query orderByValue() {
        validateNoOrderByCall();
        return new Query(this.repo, this.path, this.params.orderBy(ValueIndex.getInstance()), true);
    }

    public void removeEventListener(@NonNull ValueEventListener valueEventListener) {
        if (valueEventListener != null) {
            removeEventRegistration(new ValueEventRegistration(this.repo, valueEventListener, getSpec()));
            return;
        }
        throw new NullPointerException("listener must not be null");
    }

    @NonNull
    public Query startAfter(@Nullable String str) {
        if (str == null || !this.params.getIndex().equals(KeyIndex.getInstance())) {
            return startAt(str, ChildKey.getMaxName().asString());
        }
        return startAt(PushIdGenerator.successor(str));
    }

    @NonNull
    public Query startAt(@Nullable String str) {
        return startAt(str, (String) null);
    }

    @NonNull
    public Query endAt(double d11) {
        return endAt(d11, (String) null);
    }

    @NonNull
    public Query startAt(double d11) {
        return startAt(d11, (String) null);
    }

    @NonNull
    public Query endAt(boolean z11) {
        return endAt(z11, (String) null);
    }

    @NonNull
    public Query equalTo(double d11) {
        validateEqualToCall();
        return startAt(d11).endAt(d11);
    }

    public void removeEventListener(@NonNull ChildEventListener childEventListener) {
        if (childEventListener != null) {
            removeEventRegistration(new ChildEventRegistration(this.repo, childEventListener, getSpec()));
            return;
        }
        throw new NullPointerException("listener must not be null");
    }

    @NonNull
    public Query startAt(boolean z11) {
        return startAt(z11, (String) null);
    }

    @NonNull
    public Query endAt(@Nullable String str, @Nullable String str2) {
        return endAt(str != null ? new StringNode(str, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), str2);
    }

    @NonNull
    public Query endBefore(double d11) {
        return endAt(d11, ChildKey.getMinName().asString());
    }

    @NonNull
    public Query startAfter(double d11) {
        return startAt(d11, ChildKey.getMaxName().asString());
    }

    @NonNull
    public Query startAt(@Nullable String str, @Nullable String str2) {
        return startAt(str != null ? new StringNode(str, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), str2);
    }

    @NonNull
    public Query endBefore(boolean z11) {
        return endAt(z11, ChildKey.getMinName().asString());
    }

    @NonNull
    public Query equalTo(boolean z11) {
        validateEqualToCall();
        return startAt(z11).endAt(z11);
    }

    @NonNull
    public Query startAfter(boolean z11) {
        return startAt(z11, ChildKey.getMaxName().asString());
    }

    @NonNull
    public Query endAt(double d11, @Nullable String str) {
        return endAt((Node) new DoubleNode(Double.valueOf(d11), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query endBefore(@Nullable String str, @Nullable String str2) {
        if (str != null && this.params.getIndex().equals(KeyIndex.getInstance())) {
            str = PushIdGenerator.predecessor(str);
        }
        return endBefore(str != null ? new StringNode(str, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), str2);
    }

    @NonNull
    public Query startAfter(@Nullable String str, @Nullable String str2) {
        if (str != null && this.params.getIndex().equals(KeyIndex.getInstance())) {
            str = PushIdGenerator.successor(str);
        }
        return startAfter(str != null ? new StringNode(str, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), str2);
    }

    @NonNull
    public Query startAt(double d11, @Nullable String str) {
        return startAt((Node) new DoubleNode(Double.valueOf(d11), PriorityUtilities.NullPriority()), str);
    }

    public Query(Repo repo2, Path path2) {
        this.repo = repo2;
        this.path = path2;
        this.params = QueryParams.DEFAULT_PARAMS;
        this.orderByCalled = false;
    }

    @NonNull
    public Query endAt(boolean z11, @Nullable String str) {
        return endAt((Node) new BooleanNode(Boolean.valueOf(z11), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query equalTo(@Nullable String str, @Nullable String str2) {
        validateEqualToCall();
        return startAt(str, str2).endAt(str, str2);
    }

    @NonNull
    public Query startAt(boolean z11, @Nullable String str) {
        return startAt((Node) new BooleanNode(Boolean.valueOf(z11), PriorityUtilities.NullPriority()), str);
    }

    private Query endAt(Node node, String str) {
        Validation.validateNullableKey(str);
        if (node.isLeafNode() || node.isEmpty()) {
            ChildKey fromString = str != null ? ChildKey.fromString(str) : null;
            if (!this.params.hasEnd()) {
                QueryParams endAt = this.params.endAt(node, fromString);
                validateLimit(endAt);
                validateQueryEndpoints(endAt);
                Utilities.hardAssert(endAt.isValid());
                return new Query(this.repo, this.path, endAt, this.orderByCalled);
            }
            throw new IllegalArgumentException("Can't call endAt() or equalTo() multiple times");
        }
        throw new IllegalArgumentException("Can only use simple values for endAt()");
    }

    private Query startAt(Node node, String str) {
        ChildKey childKey;
        Validation.validateNullableKey(str);
        if (!node.isLeafNode() && !node.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for startAt() and startAfter()");
        } else if (!this.params.hasStart()) {
            if (str == null) {
                childKey = null;
            } else if (str.equals(ChildKey.MIN_KEY_NAME)) {
                childKey = ChildKey.getMinName();
            } else {
                childKey = str.equals(ChildKey.MAX_KEY_NAME) ? ChildKey.getMaxName() : ChildKey.fromString(str);
            }
            QueryParams startAt = this.params.startAt(node, childKey);
            validateLimit(startAt);
            validateQueryEndpoints(startAt);
            Utilities.hardAssert(startAt.isValid());
            return new Query(this.repo, this.path, startAt, this.orderByCalled);
        } else {
            throw new IllegalArgumentException("Can't call startAt(), startAfte(), or equalTo() multiple times");
        }
    }

    @NonNull
    public Query equalTo(double d11, @Nullable String str) {
        validateEqualToCall();
        return startAt(d11, str).endAt(d11, str);
    }

    @NonNull
    public Query endBefore(double d11, @Nullable String str) {
        return endBefore((Node) new DoubleNode(Double.valueOf(d11), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query startAfter(double d11, @Nullable String str) {
        return startAfter((Node) new DoubleNode(Double.valueOf(d11), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query endBefore(boolean z11, @Nullable String str) {
        return endBefore((Node) new BooleanNode(Boolean.valueOf(z11), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query equalTo(boolean z11, @Nullable String str) {
        validateEqualToCall();
        return startAt(z11, str).endAt(z11, str);
    }

    @NonNull
    public Query startAfter(boolean z11, @Nullable String str) {
        return startAfter((Node) new BooleanNode(Boolean.valueOf(z11), PriorityUtilities.NullPriority()), str);
    }

    private Query endBefore(Node node, String str) {
        return endAt(node, PushIdGenerator.predecessor(str));
    }

    private Query startAfter(Node node, String str) {
        return startAt(node, PushIdGenerator.successor(str));
    }
}
