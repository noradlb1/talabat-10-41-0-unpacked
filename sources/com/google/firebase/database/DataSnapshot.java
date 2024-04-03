package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

public class DataSnapshot {
    private final IndexedNode node;
    /* access modifiers changed from: private */
    public final DatabaseReference query;

    public DataSnapshot(DatabaseReference databaseReference, IndexedNode indexedNode) {
        this.node = indexedNode;
        this.query = databaseReference;
    }

    @NonNull
    public DataSnapshot child(@NonNull String str) {
        return new DataSnapshot(this.query.child(str), IndexedNode.from(this.node.getNode().getChild(new Path(str))));
    }

    public boolean exists() {
        return !this.node.getNode().isEmpty();
    }

    @NonNull
    public Iterable<DataSnapshot> getChildren() {
        final Iterator<NamedNode> it = this.node.iterator();
        return new Iterable<DataSnapshot>() {
            public Iterator<DataSnapshot> iterator() {
                return new Object() {
                    public /* synthetic */ void forEachRemaining(Consumer consumer) {
                        Iterator.CC.$default$forEachRemaining(this, consumer);
                    }

                    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                    }

                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException("remove called on immutable collection");
                    }

                    @NonNull
                    public DataSnapshot next() {
                        NamedNode namedNode = (NamedNode) it.next();
                        return new DataSnapshot(DataSnapshot.this.query.child(namedNode.getName().asString()), IndexedNode.from(namedNode.getNode()));
                    }
                };
            }
        };
    }

    public long getChildrenCount() {
        return (long) this.node.getNode().getChildCount();
    }

    @Nullable
    public String getKey() {
        return this.query.getKey();
    }

    @Nullable
    public Object getPriority() {
        Object value = this.node.getNode().getPriority().getValue();
        if (value instanceof Long) {
            return Double.valueOf((double) ((Long) value).longValue());
        }
        return value;
    }

    @NonNull
    public DatabaseReference getRef() {
        return this.query;
    }

    @Nullable
    public Object getValue() {
        return this.node.getNode().getValue();
    }

    public boolean hasChild(@NonNull String str) {
        if (this.query.getParent() == null) {
            Validation.validateRootPathString(str);
        } else {
            Validation.validatePathString(str);
        }
        return !this.node.getNode().getChild(new Path(str)).isEmpty();
    }

    public boolean hasChildren() {
        return this.node.getNode().getChildCount() > 0;
    }

    public String toString() {
        return "DataSnapshot { key = " + this.query.getKey() + ", value = " + this.node.getNode().getValue(true) + " }";
    }

    @Nullable
    public Object getValue(boolean z11) {
        return this.node.getNode().getValue(z11);
    }

    @Nullable
    public <T> T getValue(@NonNull Class<T> cls) {
        return CustomClassMapper.convertToCustomClass(this.node.getNode().getValue(), cls);
    }

    @Nullable
    public <T> T getValue(@NonNull GenericTypeIndicator<T> genericTypeIndicator) {
        return CustomClassMapper.convertToCustomClass(this.node.getNode().getValue(), genericTypeIndicator);
    }
}
