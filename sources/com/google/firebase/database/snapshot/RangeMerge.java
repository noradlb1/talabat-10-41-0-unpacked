package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class RangeMerge {
    private final Path optExclusiveStart;
    private final Path optInclusiveEnd;
    private final Node snap;

    public RangeMerge(Path path, Path path2, Node node) {
        this.optExclusiveStart = path;
        this.optInclusiveEnd = path2;
        this.snap = node;
    }

    private Node updateRangeInNode(Path path, Node node, Node node2) {
        int i11;
        int i12;
        boolean z11;
        boolean z12;
        Path path2 = this.optExclusiveStart;
        boolean z13 = true;
        if (path2 == null) {
            i11 = 1;
        } else {
            i11 = path.compareTo(path2);
        }
        Path path3 = this.optInclusiveEnd;
        if (path3 == null) {
            i12 = -1;
        } else {
            i12 = path.compareTo(path3);
        }
        Path path4 = this.optExclusiveStart;
        if (path4 == null || !path.contains(path4)) {
            z11 = false;
        } else {
            z11 = true;
        }
        Path path5 = this.optInclusiveEnd;
        if (path5 == null || !path.contains(path5)) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (i11 > 0 && i12 < 0 && !z12) {
            return node2;
        }
        if (i11 > 0 && z12 && node2.isLeafNode()) {
            return node2;
        }
        if (i11 > 0 && i12 == 0) {
            Utilities.hardAssert(z12);
            Utilities.hardAssert(!node2.isLeafNode());
            if (node.isLeafNode()) {
                return EmptyNode.Empty();
            }
            return node;
        } else if (z11 || z12) {
            HashSet hashSet = new HashSet();
            Iterator it = node.iterator();
            while (it.hasNext()) {
                hashSet.add(((NamedNode) it.next()).getName());
            }
            Iterator it2 = node2.iterator();
            while (it2.hasNext()) {
                hashSet.add(((NamedNode) it2.next()).getName());
            }
            ArrayList<ChildKey> arrayList = new ArrayList<>(hashSet.size() + 1);
            arrayList.addAll(hashSet);
            if (!node2.getPriority().isEmpty() || !node.getPriority().isEmpty()) {
                arrayList.add(ChildKey.getPriorityKey());
            }
            Node node3 = node;
            for (ChildKey childKey : arrayList) {
                Node immediateChild = node.getImmediateChild(childKey);
                Node updateRangeInNode = updateRangeInNode(path.child(childKey), node.getImmediateChild(childKey), node2.getImmediateChild(childKey));
                if (updateRangeInNode != immediateChild) {
                    node3 = node3.updateImmediateChild(childKey, updateRangeInNode);
                }
            }
            return node3;
        } else {
            if (i12 <= 0 && i11 > 0) {
                z13 = false;
            }
            Utilities.hardAssert(z13);
            return node;
        }
    }

    public Node applyTo(Node node) {
        return updateRangeInNode(Path.getEmptyPath(), node, this.snap);
    }

    public Path getEnd() {
        return this.optInclusiveEnd;
    }

    public Path getStart() {
        return this.optExclusiveStart;
    }

    public String toString() {
        return "RangeMerge{optExclusiveStart=" + this.optExclusiveStart + ", optInclusiveEnd=" + this.optInclusiveEnd + ", snap=" + this.snap + AbstractJsonLexerKt.END_OBJ;
    }

    public RangeMerge(com.google.firebase.database.connection.RangeMerge rangeMerge) {
        List<String> optExclusiveStart2 = rangeMerge.getOptExclusiveStart();
        Path path = null;
        this.optExclusiveStart = optExclusiveStart2 != null ? new Path(optExclusiveStart2) : null;
        List<String> optInclusiveEnd2 = rangeMerge.getOptInclusiveEnd();
        this.optInclusiveEnd = optInclusiveEnd2 != null ? new Path(optInclusiveEnd2) : path;
        this.snap = NodeUtilities.NodeFromJSON(rangeMerge.getSnap());
    }
}
