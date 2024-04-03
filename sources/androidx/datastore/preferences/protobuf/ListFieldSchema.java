package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
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

        public static <E> List<E> f(Object obj, long j11) {
            return (List) UnsafeUtil.u(obj, j11);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.datastore.preferences.protobuf.LazyStringArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: androidx.datastore.preferences.protobuf.LazyStringArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: androidx.datastore.preferences.protobuf.LazyStringArrayList} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static <L> java.util.List<L> mutableListAt(java.lang.Object r3, long r4, int r6) {
            /*
                java.util.List r0 = f(r3, r4)
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x002d
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.LazyStringList
                if (r1 == 0) goto L_0x0014
                androidx.datastore.preferences.protobuf.LazyStringArrayList r0 = new androidx.datastore.preferences.protobuf.LazyStringArrayList
                r0.<init>((int) r6)
                goto L_0x0029
            L_0x0014:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.PrimitiveNonBoxingCollection
                if (r1 == 0) goto L_0x0024
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.Internal.ProtobufList
                if (r1 == 0) goto L_0x0024
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r0
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r6 = r0.mutableCopyWithCapacity(r6)
                r0 = r6
                goto L_0x0029
            L_0x0024:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r6)
            L_0x0029:
                androidx.datastore.preferences.protobuf.UnsafeUtil.G(r3, r4, r0)
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
                androidx.datastore.preferences.protobuf.UnsafeUtil.G(r3, r4, r1)
            L_0x0049:
                r0 = r1
                goto L_0x007f
            L_0x004b:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList
                if (r1 == 0) goto L_0x0062
                androidx.datastore.preferences.protobuf.LazyStringArrayList r1 = new androidx.datastore.preferences.protobuf.LazyStringArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>((int) r2)
                androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList r0 = (androidx.datastore.preferences.protobuf.UnmodifiableLazyStringList) r0
                r1.addAll(r0)
                androidx.datastore.preferences.protobuf.UnsafeUtil.G(r3, r4, r1)
                goto L_0x0049
            L_0x0062:
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.PrimitiveNonBoxingCollection
                if (r1 == 0) goto L_0x007f
                boolean r1 = r0 instanceof androidx.datastore.preferences.protobuf.Internal.ProtobufList
                if (r1 == 0) goto L_0x007f
                r1 = r0
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r1 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r1
                boolean r2 = r1.isModifiable()
                if (r2 != 0) goto L_0x007f
                int r0 = r0.size()
                int r0 = r0 + r6
                androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = r1.mutableCopyWithCapacity(r0)
                androidx.datastore.preferences.protobuf.UnsafeUtil.G(r3, r4, r0)
            L_0x007f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ListFieldSchema.ListFieldSchemaFull.mutableListAt(java.lang.Object, long, int):java.util.List");
        }

        public void c(Object obj, long j11) {
            Object obj2;
            List list = (List) UnsafeUtil.u(obj, j11);
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
            UnsafeUtil.G(obj, j11, obj2);
        }

        public <E> void d(Object obj, Object obj2, long j11) {
            List f11 = f(obj2, j11);
            List mutableListAt = mutableListAt(obj, j11, f11.size());
            int size = mutableListAt.size();
            int size2 = f11.size();
            if (size > 0 && size2 > 0) {
                mutableListAt.addAll(f11);
            }
            if (size > 0) {
                f11 = mutableListAt;
            }
            UnsafeUtil.G(obj, j11, f11);
        }

        public <L> List<L> e(Object obj, long j11) {
            return mutableListAt(obj, j11, 10);
        }
    }

    public static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        public static <E> Internal.ProtobufList<E> f(Object obj, long j11) {
            return (Internal.ProtobufList) UnsafeUtil.u(obj, j11);
        }

        public void c(Object obj, long j11) {
            f(obj, j11).makeImmutable();
        }

        public <E> void d(Object obj, Object obj2, long j11) {
            Internal.ProtobufList f11 = f(obj, j11);
            Internal.ProtobufList f12 = f(obj2, j11);
            int size = f11.size();
            int size2 = f12.size();
            if (size > 0 && size2 > 0) {
                if (!f11.isModifiable()) {
                    f11 = f11.mutableCopyWithCapacity(size2 + size);
                }
                f11.addAll(f12);
            }
            if (size > 0) {
                f12 = f11;
            }
            UnsafeUtil.G(obj, j11, f12);
        }

        public <L> List<L> e(Object obj, long j11) {
            int i11;
            Internal.ProtobufList f11 = f(obj, j11);
            if (f11.isModifiable()) {
                return f11;
            }
            int size = f11.size();
            if (size == 0) {
                i11 = 10;
            } else {
                i11 = size * 2;
            }
            Internal.ProtobufList mutableCopyWithCapacity = f11.mutableCopyWithCapacity(i11);
            UnsafeUtil.G(obj, j11, mutableCopyWithCapacity);
            return mutableCopyWithCapacity;
        }
    }

    private ListFieldSchema() {
    }

    public static ListFieldSchema a() {
        return FULL_INSTANCE;
    }

    public static ListFieldSchema b() {
        return LITE_INSTANCE;
    }

    public abstract void c(Object obj, long j11);

    public abstract <L> void d(Object obj, Object obj2, long j11);

    public abstract <L> List<L> e(Object obj, long j11);
}
