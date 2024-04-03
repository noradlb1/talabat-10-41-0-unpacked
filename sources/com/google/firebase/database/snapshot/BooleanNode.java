package com.google.firebase.database.snapshot;

import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;

public class BooleanNode extends LeafNode<BooleanNode> {
    private final boolean value;

    public BooleanNode(Boolean bool, Node node) {
        super(node);
        this.value = bool.booleanValue();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BooleanNode)) {
            return false;
        }
        BooleanNode booleanNode = (BooleanNode) obj;
        if (this.value != booleanNode.value || !this.priority.equals(booleanNode.priority)) {
            return false;
        }
        return true;
    }

    public String getHashRepresentation(Node.HashVersion hashVersion) {
        return getPriorityHash(hashVersion) + "boolean:" + this.value;
    }

    public LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.Boolean;
    }

    public Object getValue() {
        return Boolean.valueOf(this.value);
    }

    public int hashCode() {
        boolean z11 = this.value;
        return (z11 ? 1 : 0) + this.priority.hashCode();
    }

    public int compareLeafValues(BooleanNode booleanNode) {
        boolean z11 = this.value;
        if (z11 == booleanNode.value) {
            return 0;
        }
        return z11 ? 1 : -1;
    }

    public BooleanNode updatePriority(Node node) {
        return new BooleanNode(Boolean.valueOf(this.value), node);
    }
}
