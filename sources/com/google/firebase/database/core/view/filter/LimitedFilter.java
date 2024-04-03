package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Iterator;

public class LimitedFilter implements NodeFilter {
    private final Index index;
    private final int limit;
    private final RangedFilter rangedFilter;
    private final boolean reverse;

    public LimitedFilter(QueryParams queryParams) {
        this.rangedFilter = new RangedFilter(queryParams);
        this.index = queryParams.getIndex();
        this.limit = queryParams.getLimit();
        this.reverse = !queryParams.isViewFromLeft();
    }

    private IndexedNode fullLimitUpdateChild(IndexedNode indexedNode, ChildKey childKey, Node node, NodeFilter.CompleteChildSource completeChildSource, ChildChangeAccumulator childChangeAccumulator) {
        boolean z11;
        NamedNode namedNode;
        int i11;
        boolean z12;
        boolean z13 = false;
        if (indexedNode.getNode().getChildCount() == this.limit) {
            z11 = true;
        } else {
            z11 = false;
        }
        Utilities.hardAssert(z11);
        NamedNode namedNode2 = new NamedNode(childKey, node);
        if (this.reverse) {
            namedNode = indexedNode.getFirstChild();
        } else {
            namedNode = indexedNode.getLastChild();
        }
        boolean matches = this.rangedFilter.matches(namedNode2);
        if (indexedNode.getNode().hasChild(childKey)) {
            Node immediateChild = indexedNode.getNode().getImmediateChild(childKey);
            NamedNode childAfterChild = completeChildSource.getChildAfterChild(this.index, namedNode, this.reverse);
            while (childAfterChild != null && (childAfterChild.getName().equals(childKey) || indexedNode.getNode().hasChild(childAfterChild.getName()))) {
                childAfterChild = completeChildSource.getChildAfterChild(this.index, childAfterChild, this.reverse);
            }
            if (childAfterChild == null) {
                i11 = 1;
            } else {
                i11 = this.index.compare(childAfterChild, namedNode2, this.reverse);
            }
            if (!matches || node.isEmpty() || i11 < 0) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                if (childChangeAccumulator != null) {
                    childChangeAccumulator.trackChildChange(Change.childChangedChange(childKey, node, immediateChild));
                }
                return indexedNode.updateChild(childKey, node);
            }
            if (childChangeAccumulator != null) {
                childChangeAccumulator.trackChildChange(Change.childRemovedChange(childKey, immediateChild));
            }
            IndexedNode updateChild = indexedNode.updateChild(childKey, EmptyNode.Empty());
            if (childAfterChild != null && this.rangedFilter.matches(childAfterChild)) {
                z13 = true;
            }
            if (!z13) {
                return updateChild;
            }
            if (childChangeAccumulator != null) {
                childChangeAccumulator.trackChildChange(Change.childAddedChange(childAfterChild.getName(), childAfterChild.getNode()));
            }
            return updateChild.updateChild(childAfterChild.getName(), childAfterChild.getNode());
        } else if (node.isEmpty() || !matches || this.index.compare(namedNode, namedNode2, this.reverse) < 0) {
            return indexedNode;
        } else {
            if (childChangeAccumulator != null) {
                childChangeAccumulator.trackChildChange(Change.childRemovedChange(namedNode.getName(), namedNode.getNode()));
                childChangeAccumulator.trackChildChange(Change.childAddedChange(childKey, node));
            }
            return indexedNode.updateChild(childKey, node).updateChild(namedNode.getName(), EmptyNode.Empty());
        }
    }

    public boolean filtersNodes() {
        return true;
    }

    public Index getIndex() {
        return this.index;
    }

    public NodeFilter getIndexedFilter() {
        return this.rangedFilter.getIndexedFilter();
    }

    public IndexedNode updateChild(IndexedNode indexedNode, ChildKey childKey, Node node, Path path, NodeFilter.CompleteChildSource completeChildSource, ChildChangeAccumulator childChangeAccumulator) {
        if (!this.rangedFilter.matches(new NamedNode(childKey, node))) {
            node = EmptyNode.Empty();
        }
        Node node2 = node;
        if (indexedNode.getNode().getImmediateChild(childKey).equals(node2)) {
            return indexedNode;
        }
        if (indexedNode.getNode().getChildCount() < this.limit) {
            return this.rangedFilter.getIndexedFilter().updateChild(indexedNode, childKey, node2, path, completeChildSource, childChangeAccumulator);
        }
        return fullLimitUpdateChild(indexedNode, childKey, node2, completeChildSource, childChangeAccumulator);
    }

    public IndexedNode updateFullNode(IndexedNode indexedNode, IndexedNode indexedNode2, ChildChangeAccumulator childChangeAccumulator) {
        IndexedNode indexedNode3;
        Iterator<NamedNode> it;
        int i11;
        NamedNode namedNode;
        NamedNode namedNode2;
        boolean z11;
        if (indexedNode2.getNode().isLeafNode() || indexedNode2.getNode().isEmpty()) {
            indexedNode3 = IndexedNode.from(EmptyNode.Empty(), this.index);
        } else {
            indexedNode3 = indexedNode2.updatePriority(PriorityUtilities.NullPriority());
            if (this.reverse) {
                it = indexedNode2.reverseIterator();
                namedNode2 = this.rangedFilter.getEndPost();
                namedNode = this.rangedFilter.getStartPost();
                i11 = -1;
            } else {
                it = indexedNode2.iterator();
                namedNode2 = this.rangedFilter.getStartPost();
                namedNode = this.rangedFilter.getEndPost();
                i11 = 1;
            }
            boolean z12 = false;
            int i12 = 0;
            while (it.hasNext()) {
                NamedNode next = it.next();
                if (!z12 && this.index.compare(namedNode2, next) * i11 <= 0) {
                    z12 = true;
                }
                if (!z12 || i12 >= this.limit || this.index.compare(next, namedNode) * i11 > 0) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    i12++;
                } else {
                    indexedNode3 = indexedNode3.updateChild(next.getName(), EmptyNode.Empty());
                }
            }
        }
        return this.rangedFilter.getIndexedFilter().updateFullNode(indexedNode, indexedNode3, childChangeAccumulator);
    }

    public IndexedNode updatePriority(IndexedNode indexedNode, Node node) {
        return indexedNode;
    }
}
