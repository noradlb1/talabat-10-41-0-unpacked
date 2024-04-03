package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class Tree<T> {

    /* renamed from: name  reason: collision with root package name */
    private ChildKey f47412name;
    private TreeNode<T> node;
    private Tree<T> parent;

    public interface TreeFilter<T> {
        boolean filterTreeNode(Tree<T> tree);
    }

    public interface TreeVisitor<T> {
        void visitTree(Tree<T> tree);
    }

    public Tree(ChildKey childKey, Tree<T> tree, TreeNode<T> treeNode) {
        this.f47412name = childKey;
        this.parent = tree;
        this.node = treeNode;
    }

    private void updateChild(ChildKey childKey, Tree<T> tree) {
        boolean isEmpty = tree.isEmpty();
        boolean containsKey = this.node.children.containsKey(childKey);
        if (isEmpty && containsKey) {
            this.node.children.remove(childKey);
            updateParents();
        } else if (!isEmpty && !containsKey) {
            this.node.children.put(childKey, tree.node);
            updateParents();
        }
    }

    private void updateParents() {
        Tree<T> tree = this.parent;
        if (tree != null) {
            tree.updateChild(this.f47412name, this);
        }
    }

    public boolean forEachAncestor(TreeFilter<T> treeFilter) {
        return forEachAncestor(treeFilter, false);
    }

    public void forEachChild(TreeVisitor<T> treeVisitor) {
        Object[] array = this.node.children.entrySet().toArray();
        for (Object obj : array) {
            Map.Entry entry = (Map.Entry) obj;
            treeVisitor.visitTree(new Tree((ChildKey) entry.getKey(), this, (TreeNode) entry.getValue()));
        }
    }

    public void forEachDescendant(TreeVisitor<T> treeVisitor) {
        forEachDescendant(treeVisitor, false, false);
    }

    public ChildKey getName() {
        return this.f47412name;
    }

    public Tree<T> getParent() {
        return this.parent;
    }

    public Path getPath() {
        boolean z11 = false;
        if (this.parent != null) {
            if (this.f47412name != null) {
                z11 = true;
            }
            Utilities.hardAssert(z11);
            return this.parent.getPath().child(this.f47412name);
        } else if (this.f47412name == null) {
            return Path.getEmptyPath();
        } else {
            return new Path(this.f47412name);
        }
    }

    public T getValue() {
        return this.node.value;
    }

    public boolean hasChildren() {
        return !this.node.children.isEmpty();
    }

    public boolean isEmpty() {
        TreeNode<T> treeNode = this.node;
        return treeNode.value == null && treeNode.children.isEmpty();
    }

    public TreeNode<T> lastNodeOnPath(Path path) {
        TreeNode<T> treeNode;
        TreeNode<T> treeNode2 = this.node;
        ChildKey front = path.getFront();
        while (front != null) {
            if (treeNode2.children.containsKey(front)) {
                treeNode = treeNode2.children.get(front);
            } else {
                treeNode = null;
            }
            if (treeNode == null) {
                return treeNode2;
            }
            path = path.popFront();
            TreeNode<T> treeNode3 = treeNode;
            front = path.getFront();
            treeNode2 = treeNode3;
        }
        return treeNode2;
    }

    public void setValue(T t11) {
        this.node.value = t11;
        updateParents();
    }

    public Tree<T> subTree(Path path) {
        TreeNode treeNode;
        ChildKey front = path.getFront();
        Tree tree = this;
        while (front != null) {
            if (tree.node.children.containsKey(front)) {
                treeNode = tree.node.children.get(front);
            } else {
                treeNode = new TreeNode();
            }
            Tree tree2 = new Tree(front, tree, treeNode);
            path = path.popFront();
            front = path.getFront();
            tree = tree2;
        }
        return tree;
    }

    public String toString() {
        return toString("");
    }

    public boolean forEachAncestor(TreeFilter<T> treeFilter, boolean z11) {
        for (Tree tree = z11 ? this : this.parent; tree != null; tree = tree.parent) {
            if (treeFilter.filterTreeNode(tree)) {
                return true;
            }
        }
        return false;
    }

    public void forEachDescendant(TreeVisitor<T> treeVisitor, boolean z11) {
        forEachDescendant(treeVisitor, z11, false);
    }

    public String toString(String str) {
        ChildKey childKey = this.f47412name;
        String asString = childKey == null ? "<anon>" : childKey.asString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(asString);
        sb2.append(StringUtils.LF);
        TreeNode<T> treeNode = this.node;
        sb2.append(treeNode.toString(str + "\t"));
        return sb2.toString();
    }

    public void forEachDescendant(final TreeVisitor<T> treeVisitor, boolean z11, final boolean z12) {
        if (z11 && !z12) {
            treeVisitor.visitTree(this);
        }
        forEachChild(new TreeVisitor<T>() {
            public void visitTree(Tree<T> tree) {
                tree.forEachDescendant(treeVisitor, true, z12);
            }
        });
        if (z11 && z12) {
            treeVisitor.visitTree(this);
        }
    }

    public Tree() {
        this((ChildKey) null, (Tree) null, new TreeNode());
    }
}
