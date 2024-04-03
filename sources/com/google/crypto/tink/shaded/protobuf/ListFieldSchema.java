package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.Collections;
import java.util.List;

abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE = new ListFieldSchemaFull();
    private static final ListFieldSchema LITE_INSTANCE = new ListFieldSchemaLite();

    public static final class ListFieldSchemaFull extends ListFieldSchema {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        public static <E> List<E> getList(Object obj, long j11) {
            return (List) UnsafeUtil.getObject(obj, j11);
        }

        public void makeImmutableListAt(Object obj, long j11) {
            Object obj2;
            List list = (List) UnsafeUtil.getObject(obj, j11);
            if (list instanceof LazyStringList) {
                obj2 = ((LazyStringList) list).getUnmodifiableView();
            } else if (!UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                if (!(list instanceof PrimitiveNonBoxingCollection) || !(list instanceof Internal.ProtobufList)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            UnsafeUtil.putObject(obj, j11, obj2);
        }

        public <E> void mergeListsAt(Object obj, Object obj2, long j11) {
            List list = getList(obj2, j11);
            List mutableListAt = mutableListAt(obj, j11, list.size());
            int size = mutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                mutableListAt.addAll(list);
            }
            if (size > 0) {
                list = mutableListAt;
            }
            UnsafeUtil.putObject(obj, j11, (Object) list);
        }

        public <L> List<L> mutableListAt(Object obj, long j11) {
            return mutableListAt(obj, j11, 10);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.crypto.tink.shaded.protobuf.LazyStringArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.crypto.tink.shaded.protobuf.LazyStringArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.crypto.tink.shaded.protobuf.LazyStringArrayList} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static <L> java.util.List<L> mutableListAt(java.lang.Object r3, long r4, int r6) {
            /*
                java.util.List r0 = getList(r3, r4)
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x002d
                boolean r1 = r0 instanceof com.google.crypto.tink.shaded.protobuf.LazyStringList
                if (r1 == 0) goto L_0x0014
                com.google.crypto.tink.shaded.protobuf.LazyStringArrayList r0 = new com.google.crypto.tink.shaded.protobuf.LazyStringArrayList
                r0.<init>((int) r6)
                goto L_0x0029
            L_0x0014:
                boolean r1 = r0 instanceof com.google.crypto.tink.shaded.protobuf.PrimitiveNonBoxingCollection
                if (r1 == 0) goto L_0x0024
                boolean r1 = r0 instanceof com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
                if (r1 == 0) goto L_0x0024
                com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList r0 = (com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList) r0
                com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList r6 = r0.mutableCopyWithCapacity(r6)
                r0 = r6
                goto L_0x0029
            L_0x0024:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r6)
            L_0x0029:
                com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
                goto L_0x007f
            L_0x002d:
                java.lang.Class<?> r1 = UNMODIFIABLE_LIST_CLASS
                java.lang.Class r2 = r0.getClass()
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 == 0) goto L_0x004b
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>(r2)
                r1.addAll(r0)
                com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
            L_0x0049:
                r0 = r1
                goto L_0x007f
            L_0x004b:
                boolean r1 = r0 instanceof com.google.crypto.tink.shaded.protobuf.UnmodifiableLazyStringList
                if (r1 == 0) goto L_0x0062
                com.google.crypto.tink.shaded.protobuf.LazyStringArrayList r1 = new com.google.crypto.tink.shaded.protobuf.LazyStringArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>((int) r2)
                com.google.crypto.tink.shaded.protobuf.UnmodifiableLazyStringList r0 = (com.google.crypto.tink.shaded.protobuf.UnmodifiableLazyStringList) r0
                r1.addAll(r0)
                com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
                goto L_0x0049
            L_0x0062:
                boolean r1 = r0 instanceof com.google.crypto.tink.shaded.protobuf.PrimitiveNonBoxingCollection
                if (r1 == 0) goto L_0x007f
                boolean r1 = r0 instanceof com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
                if (r1 == 0) goto L_0x007f
                r1 = r0
                com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList r1 = (com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList) r1
                boolean r2 = r1.isModifiable()
                if (r2 != 0) goto L_0x007f
                int r0 = r0.size()
                int r0 = r0 + r6
                com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList r0 = r1.mutableCopyWithCapacity(r0)
                com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
            L_0x007f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.ListFieldSchema.ListFieldSchemaFull.mutableListAt(java.lang.Object, long, int):java.util.List");
        }
    }

    public static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        public static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j11) {
            return (Internal.ProtobufList) UnsafeUtil.getObject(obj, j11);
        }

        public void makeImmutableListAt(Object obj, long j11) {
            getProtobufList(obj, j11).makeImmutable();
        }

        public <E> void mergeListsAt(Object obj, Object obj2, long j11) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j11);
            Internal.ProtobufList protobufList2 = getProtobufList(obj2, j11);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.isModifiable()) {
                    protobufList = protobufList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            if (size > 0) {
                protobufList2 = protobufList;
            }
            UnsafeUtil.putObject(obj, j11, (Object) protobufList2);
        }

        public <L> List<L> mutableListAt(Object obj, long j11) {
            int i11;
            Internal.ProtobufList protobufList = getProtobufList(obj, j11);
            if (protobufList.isModifiable()) {
                return protobufList;
            }
            int size = protobufList.size();
            if (size == 0) {
                i11 = 10;
            } else {
                i11 = size * 2;
            }
            Internal.ProtobufList mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(i11);
            UnsafeUtil.putObject(obj, j11, (Object) mutableCopyWithCapacity);
            return mutableCopyWithCapacity;
        }
    }

    private ListFieldSchema() {
    }

    public static ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    public static ListFieldSchema lite() {
        return LITE_INSTANCE;
    }

    public abstract void makeImmutableListAt(Object obj, long j11);

    public abstract <L> void mergeListsAt(Object obj, Object obj2, long j11);

    public abstract <L> List<L> mutableListAt(Object obj, long j11);
}
