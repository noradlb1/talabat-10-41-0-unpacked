package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010\u0015\u001a\u00020\u0012J*\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00172\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010\u001b\u001a\u00020\u0012J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tR$\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalManager;", "", "owner", "Landroidx/compose/ui/node/Owner;", "(Landroidx/compose/ui/node/Owner;)V", "inserted", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Pair;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "Landroidx/compose/ui/modifier/ModifierLocal;", "invalidated", "", "getOwner", "()Landroidx/compose/ui/node/Owner;", "removed", "Landroidx/compose/ui/node/LayoutNode;", "updated", "insertedProvider", "", "node", "key", "invalidate", "invalidateConsumersOfNodeForKey", "Landroidx/compose/ui/Modifier$Node;", "set", "", "removedProvider", "triggerUpdates", "updatedProvider", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ModifierLocalManager {
    @NotNull
    private final MutableVector<Pair<BackwardsCompatNode, ModifierLocal<?>>> inserted = new MutableVector<>(new Pair[16], 0);
    private boolean invalidated;
    @NotNull
    private final Owner owner;
    @NotNull
    private final MutableVector<Pair<LayoutNode, ModifierLocal<?>>> removed = new MutableVector<>(new Pair[16], 0);
    @NotNull
    private final MutableVector<Pair<BackwardsCompatNode, ModifierLocal<?>>> updated = new MutableVector<>(new Pair[16], 0);

    public ModifierLocalManager(@NotNull Owner owner2) {
        Intrinsics.checkNotNullParameter(owner2, "owner");
        this.owner = owner2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x002f A[EDGE_INSN: B:35:0x002f->B:33:0x002f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0085 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void invalidateConsumersOfNodeForKey(androidx.compose.ui.Modifier.Node r9, androidx.compose.ui.modifier.ModifierLocal<?> r10, java.util.Set<androidx.compose.ui.node.BackwardsCompatNode> r11) {
        /*
            r8 = this;
            androidx.compose.ui.node.Nodes r0 = androidx.compose.ui.node.Nodes.INSTANCE
            int r0 = r0.m4763getLocalsOLwlOKw()
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto L_0x008f
            androidx.compose.runtime.collection.MutableVector r1 = new androidx.compose.runtime.collection.MutableVector
            r2 = 16
            androidx.compose.ui.Modifier$Node[] r2 = new androidx.compose.ui.Modifier.Node[r2]
            r3 = 0
            r1.<init>(r2, r3)
            androidx.compose.ui.Modifier$Node r2 = r9.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getChild$ui_release()
            if (r2 != 0) goto L_0x002c
            androidx.compose.ui.Modifier$Node r9 = r9.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.addLayoutNodeChildren(r1, r9)
            goto L_0x002f
        L_0x002c:
            r1.add(r2)
        L_0x002f:
            boolean r9 = r1.isNotEmpty()
            if (r9 == 0) goto L_0x008e
            int r9 = r1.getSize()
            r2 = 1
            int r9 = r9 - r2
            java.lang.Object r9 = r1.removeAt(r9)
            androidx.compose.ui.Modifier$Node r9 = (androidx.compose.ui.Modifier.Node) r9
            int r4 = r9.getAggregateChildKindSet$ui_release()
            r4 = r4 & r0
            if (r4 == 0) goto L_0x008a
            r4 = r9
        L_0x0049:
            if (r4 == 0) goto L_0x008a
            int r5 = r4.getKindSet$ui_release()
            r5 = r5 & r0
            if (r5 == 0) goto L_0x0085
            boolean r5 = r4 instanceof androidx.compose.ui.modifier.ModifierLocalNode
            if (r5 == 0) goto L_0x0082
            r5 = r4
            androidx.compose.ui.modifier.ModifierLocalNode r5 = (androidx.compose.ui.modifier.ModifierLocalNode) r5
            boolean r6 = r5 instanceof androidx.compose.ui.node.BackwardsCompatNode
            if (r6 == 0) goto L_0x0075
            r6 = r5
            androidx.compose.ui.node.BackwardsCompatNode r6 = (androidx.compose.ui.node.BackwardsCompatNode) r6
            androidx.compose.ui.Modifier$Element r7 = r6.getElement()
            boolean r7 = r7 instanceof androidx.compose.ui.modifier.ModifierLocalConsumer
            if (r7 == 0) goto L_0x0075
            java.util.HashSet r6 = r6.getReadValues()
            boolean r6 = r6.contains(r10)
            if (r6 == 0) goto L_0x0075
            r11.add(r5)
        L_0x0075:
            androidx.compose.ui.modifier.ModifierLocalMap r5 = r5.getProvidedValues()
            boolean r5 = r5.contains$ui_release(r10)
            if (r5 != 0) goto L_0x0080
            goto L_0x0082
        L_0x0080:
            r5 = r3
            goto L_0x0083
        L_0x0082:
            r5 = r2
        L_0x0083:
            if (r5 == 0) goto L_0x002f
        L_0x0085:
            androidx.compose.ui.Modifier$Node r4 = r4.getChild$ui_release()
            goto L_0x0049
        L_0x008a:
            androidx.compose.ui.node.DelegatableNodeKt.addLayoutNodeChildren(r1, r9)
            goto L_0x002f
        L_0x008e:
            return
        L_0x008f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Check failed."
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.modifier.ModifierLocalManager.invalidateConsumersOfNodeForKey(androidx.compose.ui.Modifier$Node, androidx.compose.ui.modifier.ModifierLocal, java.util.Set):void");
    }

    @NotNull
    public final Owner getOwner() {
        return this.owner;
    }

    public final void insertedProvider(@NotNull BackwardsCompatNode backwardsCompatNode, @NotNull ModifierLocal<?> modifierLocal) {
        Intrinsics.checkNotNullParameter(backwardsCompatNode, "node");
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        this.inserted.add(TuplesKt.to(backwardsCompatNode, modifierLocal));
        invalidate();
    }

    public final void invalidate() {
        if (!this.invalidated) {
            this.invalidated = true;
            this.owner.registerOnEndApplyChangesListener(new ModifierLocalManager$invalidate$1(this));
        }
    }

    public final void removedProvider(@NotNull BackwardsCompatNode backwardsCompatNode, @NotNull ModifierLocal<?> modifierLocal) {
        Intrinsics.checkNotNullParameter(backwardsCompatNode, "node");
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        this.removed.add(TuplesKt.to(DelegatableNodeKt.requireLayoutNode(backwardsCompatNode), modifierLocal));
        invalidate();
    }

    public final void triggerUpdates() {
        int i11 = 0;
        this.invalidated = false;
        HashSet<BackwardsCompatNode> hashSet = new HashSet<>();
        MutableVector<Pair<LayoutNode, ModifierLocal<?>>> mutableVector = this.removed;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i12 = 0;
            do {
                Pair pair = (Pair) content[i12];
                LayoutNode layoutNode = (LayoutNode) pair.component1();
                ModifierLocal modifierLocal = (ModifierLocal) pair.component2();
                if (layoutNode.isAttached()) {
                    invalidateConsumersOfNodeForKey(layoutNode.getNodes$ui_release().getHead$ui_release(), modifierLocal, hashSet);
                }
                i12++;
            } while (i12 < size);
        }
        this.removed.clear();
        MutableVector<Pair<BackwardsCompatNode, ModifierLocal<?>>> mutableVector2 = this.inserted;
        int size2 = mutableVector2.getSize();
        if (size2 > 0) {
            Object[] content2 = mutableVector2.getContent();
            Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i13 = 0;
            do {
                Pair pair2 = (Pair) content2[i13];
                BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) pair2.component1();
                ModifierLocal modifierLocal2 = (ModifierLocal) pair2.component2();
                if (backwardsCompatNode.isAttached()) {
                    invalidateConsumersOfNodeForKey(backwardsCompatNode, modifierLocal2, hashSet);
                }
                i13++;
            } while (i13 < size2);
        }
        this.inserted.clear();
        MutableVector<Pair<BackwardsCompatNode, ModifierLocal<?>>> mutableVector3 = this.updated;
        int size3 = mutableVector3.getSize();
        if (size3 > 0) {
            Object[] content3 = mutableVector3.getContent();
            Intrinsics.checkNotNull(content3, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                Pair pair3 = (Pair) content3[i11];
                BackwardsCompatNode backwardsCompatNode2 = (BackwardsCompatNode) pair3.component1();
                ModifierLocal modifierLocal3 = (ModifierLocal) pair3.component2();
                if (backwardsCompatNode2.isAttached()) {
                    invalidateConsumersOfNodeForKey(backwardsCompatNode2, modifierLocal3, hashSet);
                }
                i11++;
            } while (i11 < size3);
        }
        this.updated.clear();
        for (BackwardsCompatNode updateModifierLocalConsumer : hashSet) {
            updateModifierLocalConsumer.updateModifierLocalConsumer();
        }
    }

    public final void updatedProvider(@NotNull BackwardsCompatNode backwardsCompatNode, @NotNull ModifierLocal<?> modifierLocal) {
        Intrinsics.checkNotNullParameter(backwardsCompatNode, "node");
        Intrinsics.checkNotNullParameter(modifierLocal, "key");
        this.updated.add(TuplesKt.to(backwardsCompatNode, modifierLocal));
        invalidate();
    }
}
