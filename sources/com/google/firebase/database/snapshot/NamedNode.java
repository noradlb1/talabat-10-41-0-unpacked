package com.google.firebase.database.snapshot;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class NamedNode {
    private static final NamedNode MAX_NODE = new NamedNode(ChildKey.getMaxName(), Node.MAX_NODE);
    private static final NamedNode MIN_NODE = new NamedNode(ChildKey.getMinName(), EmptyNode.Empty());

    /* renamed from: name  reason: collision with root package name */
    private final ChildKey f47415name;
    private final Node node;

    public NamedNode(ChildKey childKey, Node node2) {
        this.f47415name = childKey;
        this.node = node2;
    }

    public static NamedNode getMaxNode() {
        return MAX_NODE;
    }

    public static NamedNode getMinNode() {
        return MIN_NODE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NamedNode.class != obj.getClass()) {
            return false;
        }
        NamedNode namedNode = (NamedNode) obj;
        if (this.f47415name.equals(namedNode.f47415name) && this.node.equals(namedNode.node)) {
            return true;
        }
        return false;
    }

    public ChildKey getName() {
        return this.f47415name;
    }

    public Node getNode() {
        return this.node;
    }

    public int hashCode() {
        return (this.f47415name.hashCode() * 31) + this.node.hashCode();
    }

    public String toString() {
        return "NamedNode{name=" + this.f47415name + ", node=" + this.node + AbstractJsonLexerKt.END_OBJ;
    }
}
