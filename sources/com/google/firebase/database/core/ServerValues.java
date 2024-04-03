package com.google.firebase.database.core;

import com.google.firebase.database.core.ValueProvider;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerValues {
    public static final String NAME_OP_INCREMENT = "increment";
    public static final String NAME_OP_TIMESTAMP = "timestamp";
    public static final String NAME_SUBKEY_SERVERVALUE = ".sv";

    private static boolean canBeRepresentedAsLong(Number number) {
        return !(number instanceof Double) && !(number instanceof Float);
    }

    public static Map<String, Object> generateServerValues(Clock clock) {
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(clock.millis()));
        return hashMap;
    }

    public static Object resolveComplexDeferredValue(Map<String, Object> map, ValueProvider valueProvider, Map<String, Object> map2) {
        if (!map.containsKey(NAME_OP_INCREMENT)) {
            return null;
        }
        Object obj = map.get(NAME_OP_INCREMENT);
        if (!(obj instanceof Number)) {
            return null;
        }
        Number number = (Number) obj;
        Node node = valueProvider.node();
        if (!node.isLeafNode() || !(node.getValue() instanceof Number)) {
            return number;
        }
        Number number2 = (Number) node.getValue();
        if (canBeRepresentedAsLong(number) && canBeRepresentedAsLong(number2)) {
            long longValue = number.longValue();
            long longValue2 = number2.longValue();
            long j11 = longValue + longValue2;
            if (((longValue ^ j11) & (longValue2 ^ j11)) >= 0) {
                return Long.valueOf(j11);
            }
        }
        return Double.valueOf(number.doubleValue() + number2.doubleValue());
    }

    public static Object resolveDeferredLeafValue(Object obj, ValueProvider valueProvider, Map<String, Object> map) {
        Object obj2;
        if (!(obj instanceof Map)) {
            return obj;
        }
        Map map2 = (Map) obj;
        if (!map2.containsKey(NAME_SUBKEY_SERVERVALUE)) {
            return obj;
        }
        Object obj3 = map2.get(NAME_SUBKEY_SERVERVALUE);
        if (obj3 instanceof String) {
            obj2 = resolveScalarDeferredValue((String) obj3, map);
        } else if (obj3 instanceof Map) {
            obj2 = resolveComplexDeferredValue((Map) obj3, valueProvider, map);
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return obj;
        }
        return obj2;
    }

    public static CompoundWrite resolveDeferredValueMerge(CompoundWrite compoundWrite, SyncTree syncTree, Path path, Map<String, Object> map) {
        CompoundWrite emptyWrite = CompoundWrite.emptyWrite();
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            emptyWrite = emptyWrite.addWrite((Path) next.getKey(), resolveDeferredValueSnapshot((Node) next.getValue(), (ValueProvider) new ValueProvider.DeferredValueProvider(syncTree, path.child((Path) next.getKey())), map));
        }
        return emptyWrite;
    }

    public static Node resolveDeferredValueSnapshot(Node node, Node node2, Map<String, Object> map) {
        return resolveDeferredValueSnapshot(node, (ValueProvider) new ValueProvider.ExistingValueProvider(node2), map);
    }

    public static Object resolveScalarDeferredValue(String str, Map<String, Object> map) {
        if (!"timestamp".equals(str) || !map.containsKey(str)) {
            return null;
        }
        return map.get(str);
    }

    public static Node resolveDeferredValueSnapshot(Node node, SyncTree syncTree, Path path, Map<String, Object> map) {
        return resolveDeferredValueSnapshot(node, (ValueProvider) new ValueProvider.DeferredValueProvider(syncTree, path), map);
    }

    /* access modifiers changed from: private */
    public static Node resolveDeferredValueSnapshot(Node node, final ValueProvider valueProvider, final Map<String, Object> map) {
        Object value = node.getPriority().getValue();
        Object resolveDeferredLeafValue = resolveDeferredLeafValue(value, valueProvider.getImmediateChild(ChildKey.fromString(".priority")), map);
        if (node.isLeafNode()) {
            Object resolveDeferredLeafValue2 = resolveDeferredLeafValue(node.getValue(), valueProvider, map);
            if (!resolveDeferredLeafValue2.equals(node.getValue()) || !Utilities.equals(resolveDeferredLeafValue, value)) {
                return NodeUtilities.NodeFromJSON(resolveDeferredLeafValue2, PriorityUtilities.parsePriority(resolveDeferredLeafValue));
            }
            return node;
        } else if (node.isEmpty()) {
            return node;
        } else {
            ChildrenNode childrenNode = (ChildrenNode) node;
            final SnapshotHolder snapshotHolder = new SnapshotHolder(childrenNode);
            childrenNode.forEachChild(new ChildrenNode.ChildVisitor() {
                public void visitChild(ChildKey childKey, Node node) {
                    Node access$000 = ServerValues.resolveDeferredValueSnapshot(node, ValueProvider.this.getImmediateChild(childKey), (Map<String, Object>) map);
                    if (access$000 != node) {
                        snapshotHolder.update(new Path(childKey.asString()), access$000);
                    }
                }
            });
            if (!snapshotHolder.getRootNode().getPriority().equals(resolveDeferredLeafValue)) {
                return snapshotHolder.getRootNode().updatePriority(PriorityUtilities.parsePriority(resolveDeferredLeafValue));
            }
            return snapshotHolder.getRootNode();
        }
    }
}
