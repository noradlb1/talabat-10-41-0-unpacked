package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class Moshi {

    /* renamed from: a  reason: collision with root package name */
    public static final List<JsonAdapter.Factory> f53309a;
    /* access modifiers changed from: private */
    public final Map<Object, JsonAdapter<?>> adapterCache = new LinkedHashMap();
    private final List<JsonAdapter.Factory> factories;
    private final int lastOffset;
    /* access modifiers changed from: private */
    public final ThreadLocal<LookupChain> lookupChainThreadLocal = new ThreadLocal<>();

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final List<JsonAdapter.Factory> f53315a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public int f53316b = 0;

        public <T> Builder add(Type type, JsonAdapter<T> jsonAdapter) {
            return add(Moshi.c(type, jsonAdapter));
        }

        public <T> Builder addLast(Type type, JsonAdapter<T> jsonAdapter) {
            return addLast(Moshi.c(type, jsonAdapter));
        }

        @CheckReturnValue
        public Moshi build() {
            return new Moshi(this);
        }

        public <T> Builder add(Type type, Class<? extends Annotation> cls, JsonAdapter<T> jsonAdapter) {
            return add(Moshi.d(type, cls, jsonAdapter));
        }

        public <T> Builder addLast(Type type, Class<? extends Annotation> cls, JsonAdapter<T> jsonAdapter) {
            return addLast(Moshi.d(type, cls, jsonAdapter));
        }

        public Builder add(JsonAdapter.Factory factory) {
            if (factory != null) {
                List<JsonAdapter.Factory> list = this.f53315a;
                int i11 = this.f53316b;
                this.f53316b = i11 + 1;
                list.add(i11, factory);
                return this;
            }
            throw new IllegalArgumentException("factory == null");
        }

        public Builder addLast(JsonAdapter.Factory factory) {
            if (factory != null) {
                this.f53315a.add(factory);
                return this;
            }
            throw new IllegalArgumentException("factory == null");
        }

        public Builder add(Object obj) {
            if (obj != null) {
                return add((JsonAdapter.Factory) AdapterMethodsFactory.get(obj));
            }
            throw new IllegalArgumentException("adapter == null");
        }

        public Builder addLast(Object obj) {
            if (obj != null) {
                return addLast((JsonAdapter.Factory) AdapterMethodsFactory.get(obj));
            }
            throw new IllegalArgumentException("adapter == null");
        }
    }

    public static final class Lookup<T> extends JsonAdapter<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Type f53317a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final String f53318b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f53319c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public JsonAdapter<T> f53320d;

        public Lookup(Type type, @Nullable String str, Object obj) {
            this.f53317a = type;
            this.f53318b = str;
            this.f53319c = obj;
        }

        public T fromJson(JsonReader jsonReader) throws IOException {
            JsonAdapter<T> jsonAdapter = this.f53320d;
            if (jsonAdapter != null) {
                return jsonAdapter.fromJson(jsonReader);
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        public void toJson(JsonWriter jsonWriter, T t11) throws IOException {
            JsonAdapter<T> jsonAdapter = this.f53320d;
            if (jsonAdapter != null) {
                jsonAdapter.toJson(jsonWriter, t11);
                return;
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        public String toString() {
            JsonAdapter<T> jsonAdapter = this.f53320d;
            return jsonAdapter != null ? jsonAdapter.toString() : super.toString();
        }
    }

    public final class LookupChain {

        /* renamed from: a  reason: collision with root package name */
        public final List<Lookup<?>> f53321a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final Deque<Lookup<?>> f53322b = new ArrayDeque();

        /* renamed from: c  reason: collision with root package name */
        public boolean f53323c;

        public LookupChain() {
        }

        public <T> void a(JsonAdapter<T> jsonAdapter) {
            this.f53322b.getLast().f53320d = jsonAdapter;
        }

        public IllegalArgumentException b(IllegalArgumentException illegalArgumentException) {
            if (this.f53323c) {
                return illegalArgumentException;
            }
            this.f53323c = true;
            if (this.f53322b.size() == 1 && this.f53322b.getFirst().f53318b == null) {
                return illegalArgumentException;
            }
            StringBuilder sb2 = new StringBuilder(illegalArgumentException.getMessage());
            Iterator<Lookup<?>> descendingIterator = this.f53322b.descendingIterator();
            while (descendingIterator.hasNext()) {
                Lookup next = descendingIterator.next();
                sb2.append("\nfor ");
                sb2.append(next.f53317a);
                if (next.f53318b != null) {
                    sb2.append(' ');
                    sb2.append(next.f53318b);
                }
            }
            return new IllegalArgumentException(sb2.toString(), illegalArgumentException);
        }

        public void c(boolean z11) {
            this.f53322b.removeLast();
            if (this.f53322b.isEmpty()) {
                Moshi.this.lookupChainThreadLocal.remove();
                if (z11) {
                    synchronized (Moshi.this.adapterCache) {
                        int size = this.f53321a.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            Lookup lookup = this.f53321a.get(i11);
                            JsonAdapter<T> jsonAdapter = (JsonAdapter) Moshi.this.adapterCache.put(lookup.f53319c, lookup.f53320d);
                            if (jsonAdapter != null) {
                                lookup.f53320d = jsonAdapter;
                                Moshi.this.adapterCache.put(lookup.f53319c, jsonAdapter);
                            }
                        }
                    }
                }
            }
        }

        public <T> JsonAdapter<T> d(Type type, @Nullable String str, Object obj) {
            int size = this.f53321a.size();
            for (int i11 = 0; i11 < size; i11++) {
                Lookup lookup = this.f53321a.get(i11);
                if (lookup.f53319c.equals(obj)) {
                    this.f53322b.add(lookup);
                    JsonAdapter<T> jsonAdapter = lookup.f53320d;
                    if (jsonAdapter != null) {
                        return jsonAdapter;
                    }
                    return lookup;
                }
            }
            Lookup lookup2 = new Lookup(type, str, obj);
            this.f53321a.add(lookup2);
            this.f53322b.add(lookup2);
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(5);
        f53309a = arrayList;
        arrayList.add(StandardJsonAdapters.FACTORY);
        arrayList.add(CollectionJsonAdapter.FACTORY);
        arrayList.add(MapJsonAdapter.FACTORY);
        arrayList.add(ArrayJsonAdapter.FACTORY);
        arrayList.add(RecordJsonAdapter.f53325a);
        arrayList.add(ClassJsonAdapter.FACTORY);
    }

    public Moshi(Builder builder) {
        int size = builder.f53315a.size();
        List<JsonAdapter.Factory> list = f53309a;
        ArrayList arrayList = new ArrayList(size + list.size());
        arrayList.addAll(builder.f53315a);
        arrayList.addAll(list);
        this.factories = Collections.unmodifiableList(arrayList);
        this.lastOffset = builder.f53316b;
    }

    public static <T> JsonAdapter.Factory c(final Type type, final JsonAdapter<T> jsonAdapter) {
        if (type == null) {
            throw new IllegalArgumentException("type == null");
        } else if (jsonAdapter != null) {
            return new JsonAdapter.Factory() {
                @Nullable
                public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
                    if (!set.isEmpty() || !Util.typesMatch(type, type)) {
                        return null;
                    }
                    return jsonAdapter;
                }
            };
        } else {
            throw new IllegalArgumentException("jsonAdapter == null");
        }
    }

    private Object cacheKey(Type type, Set<? extends Annotation> set) {
        if (set.isEmpty()) {
            return type;
        }
        return Arrays.asList(new Object[]{type, set});
    }

    public static <T> JsonAdapter.Factory d(final Type type, final Class<? extends Annotation> cls, final JsonAdapter<T> jsonAdapter) {
        if (type == null) {
            throw new IllegalArgumentException("type == null");
        } else if (cls == null) {
            throw new IllegalArgumentException("annotation == null");
        } else if (jsonAdapter == null) {
            throw new IllegalArgumentException("jsonAdapter == null");
        } else if (!cls.isAnnotationPresent(JsonQualifier.class)) {
            throw new IllegalArgumentException(cls + " does not have @JsonQualifier");
        } else if (cls.getDeclaredMethods().length <= 0) {
            return new JsonAdapter.Factory() {
                @Nullable
                public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
                    if (!Util.typesMatch(type, type) || set.size() != 1 || !Util.isAnnotationPresent(set, cls)) {
                        return null;
                    }
                    return jsonAdapter;
                }
            };
        } else {
            throw new IllegalArgumentException("Use JsonAdapter.Factory for annotations with elements");
        }
    }

    @CheckReturnValue
    public <T> JsonAdapter<T> adapter(Type type) {
        return adapter(type, (Set<? extends Annotation>) Util.NO_ANNOTATIONS);
    }

    @CheckReturnValue
    public Builder newBuilder() {
        Builder builder = new Builder();
        int i11 = this.lastOffset;
        for (int i12 = 0; i12 < i11; i12++) {
            builder.add(this.factories.get(i12));
        }
        int size = this.factories.size() - f53309a.size();
        for (int i13 = this.lastOffset; i13 < size; i13++) {
            builder.addLast(this.factories.get(i13));
        }
        return builder;
    }

    @CheckReturnValue
    public <T> JsonAdapter<T> nextAdapter(JsonAdapter.Factory factory, Type type, Set<? extends Annotation> set) {
        if (set != null) {
            Type removeSubtypeWildcard = Util.removeSubtypeWildcard(Util.canonicalize(type));
            int indexOf = this.factories.indexOf(factory);
            if (indexOf != -1) {
                int size = this.factories.size();
                for (int i11 = indexOf + 1; i11 < size; i11++) {
                    JsonAdapter<?> create = this.factories.get(i11).create(removeSubtypeWildcard, set, this);
                    if (create != null) {
                        return create;
                    }
                }
                throw new IllegalArgumentException("No next JsonAdapter for " + Util.typeAnnotatedWithAnnotations(removeSubtypeWildcard, set));
            }
            throw new IllegalArgumentException("Unable to skip past unknown factory " + factory);
        }
        throw new NullPointerException("annotations == null");
    }

    @CheckReturnValue
    public <T> JsonAdapter<T> adapter(Class<T> cls) {
        return adapter((Type) cls, (Set<? extends Annotation>) Util.NO_ANNOTATIONS);
    }

    @CheckReturnValue
    public <T> JsonAdapter<T> adapter(Type type, Class<? extends Annotation> cls) {
        if (cls != null) {
            return adapter(type, (Set<? extends Annotation>) Collections.singleton(Types.b(cls)));
        }
        throw new NullPointerException("annotationType == null");
    }

    @CheckReturnValue
    public <T> JsonAdapter<T> adapter(Type type, Class<? extends Annotation>... clsArr) {
        if (clsArr.length == 1) {
            return adapter(type, clsArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(clsArr.length);
        for (Class<? extends Annotation> b11 : clsArr) {
            linkedHashSet.add(Types.b(b11));
        }
        return adapter(type, (Set<? extends Annotation>) Collections.unmodifiableSet(linkedHashSet));
    }

    @CheckReturnValue
    public <T> JsonAdapter<T> adapter(Type type, Set<? extends Annotation> set) {
        return adapter(type, set, (String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r1 = r4.lookupChainThreadLocal.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r1 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        r1 = new com.squareup.moshi.Moshi.LookupChain(r4);
        r4.lookupChainThreadLocal.set(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r7 = r1.d(r5, r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r7 == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        r1.c(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r7 = r4.factories.size();
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r2 >= r7) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        r3 = r4.factories.get(r2).create(r5, r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r3 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        r1.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
        r1.c(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007b, code lost:
        throw new java.lang.IllegalArgumentException("No JsonAdapter for " + com.squareup.moshi.internal.Util.typeAnnotatedWithAnnotations(r5, r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007e, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        throw r1.b(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0084, code lost:
        r1.c(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        throw r5;
     */
    @javax.annotation.CheckReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> com.squareup.moshi.JsonAdapter<T> adapter(java.lang.reflect.Type r5, java.util.Set<? extends java.lang.annotation.Annotation> r6, @javax.annotation.Nullable java.lang.String r7) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0093
            if (r6 == 0) goto L_0x008b
            java.lang.reflect.Type r5 = com.squareup.moshi.internal.Util.canonicalize(r5)
            java.lang.reflect.Type r5 = com.squareup.moshi.internal.Util.removeSubtypeWildcard(r5)
            java.lang.Object r0 = r4.cacheKey(r5, r6)
            java.util.Map<java.lang.Object, com.squareup.moshi.JsonAdapter<?>> r1 = r4.adapterCache
            monitor-enter(r1)
            java.util.Map<java.lang.Object, com.squareup.moshi.JsonAdapter<?>> r2 = r4.adapterCache     // Catch:{ all -> 0x0088 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0088 }
            com.squareup.moshi.JsonAdapter r2 = (com.squareup.moshi.JsonAdapter) r2     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x001f
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            return r2
        L_0x001f:
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            java.lang.ThreadLocal<com.squareup.moshi.Moshi$LookupChain> r1 = r4.lookupChainThreadLocal
            java.lang.Object r1 = r1.get()
            com.squareup.moshi.Moshi$LookupChain r1 = (com.squareup.moshi.Moshi.LookupChain) r1
            if (r1 != 0) goto L_0x0034
            com.squareup.moshi.Moshi$LookupChain r1 = new com.squareup.moshi.Moshi$LookupChain
            r1.<init>()
            java.lang.ThreadLocal<com.squareup.moshi.Moshi$LookupChain> r2 = r4.lookupChainThreadLocal
            r2.set(r1)
        L_0x0034:
            com.squareup.moshi.JsonAdapter r7 = r1.d(r5, r7, r0)
            r0 = 0
            if (r7 == 0) goto L_0x003f
            r1.c(r0)
            return r7
        L_0x003f:
            java.util.List<com.squareup.moshi.JsonAdapter$Factory> r7 = r4.factories     // Catch:{ IllegalArgumentException -> 0x007e }
            int r7 = r7.size()     // Catch:{ IllegalArgumentException -> 0x007e }
            r2 = r0
        L_0x0046:
            if (r2 >= r7) goto L_0x0061
            java.util.List<com.squareup.moshi.JsonAdapter$Factory> r3 = r4.factories     // Catch:{ IllegalArgumentException -> 0x007e }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ IllegalArgumentException -> 0x007e }
            com.squareup.moshi.JsonAdapter$Factory r3 = (com.squareup.moshi.JsonAdapter.Factory) r3     // Catch:{ IllegalArgumentException -> 0x007e }
            com.squareup.moshi.JsonAdapter r3 = r3.create(r5, r6, r4)     // Catch:{ IllegalArgumentException -> 0x007e }
            if (r3 != 0) goto L_0x0059
            int r2 = r2 + 1
            goto L_0x0046
        L_0x0059:
            r1.a(r3)     // Catch:{ IllegalArgumentException -> 0x007e }
            r5 = 1
            r1.c(r5)
            return r3
        L_0x0061:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x007e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x007e }
            r2.<init>()     // Catch:{ IllegalArgumentException -> 0x007e }
            java.lang.String r3 = "No JsonAdapter for "
            r2.append(r3)     // Catch:{ IllegalArgumentException -> 0x007e }
            java.lang.String r5 = com.squareup.moshi.internal.Util.typeAnnotatedWithAnnotations(r5, r6)     // Catch:{ IllegalArgumentException -> 0x007e }
            r2.append(r5)     // Catch:{ IllegalArgumentException -> 0x007e }
            java.lang.String r5 = r2.toString()     // Catch:{ IllegalArgumentException -> 0x007e }
            r7.<init>(r5)     // Catch:{ IllegalArgumentException -> 0x007e }
            throw r7     // Catch:{ IllegalArgumentException -> 0x007e }
        L_0x007c:
            r5 = move-exception
            goto L_0x0084
        L_0x007e:
            r5 = move-exception
            java.lang.IllegalArgumentException r5 = r1.b(r5)     // Catch:{ all -> 0x007c }
            throw r5     // Catch:{ all -> 0x007c }
        L_0x0084:
            r1.c(r0)
            throw r5
        L_0x0088:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            throw r5
        L_0x008b:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "annotations == null"
            r5.<init>(r6)
            throw r5
        L_0x0093:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "type == null"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.Moshi.adapter(java.lang.reflect.Type, java.util.Set, java.lang.String):com.squareup.moshi.JsonAdapter");
    }
}
