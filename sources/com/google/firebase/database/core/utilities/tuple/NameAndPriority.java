package com.google.firebase.database.core.utilities.tuple;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;

public class NameAndPriority implements Comparable<NameAndPriority> {

    /* renamed from: name  reason: collision with root package name */
    private ChildKey f47413name;
    private Node priority;

    public NameAndPriority(ChildKey childKey, Node node) {
        this.f47413name = childKey;
        this.priority = node;
    }

    public ChildKey getName() {
        return this.f47413name;
    }

    public Node getPriority() {
        return this.priority;
    }

    public int compareTo(NameAndPriority nameAndPriority) {
        return NodeUtilities.nameAndPriorityCompare(this.f47413name, this.priority, nameAndPriority.f47413name, nameAndPriority.priority);
    }
}
