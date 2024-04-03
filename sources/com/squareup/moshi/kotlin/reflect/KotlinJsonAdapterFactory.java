package com.squareup.moshi.kotlin.reflect;

import com.squareup.moshi.JsonAdapter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapterFactory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "()V", "create", "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "reflect"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinJsonAdapterFactory implements JsonAdapter.Factory {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: com.squareup.moshi.Json} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: com.squareup.moshi.Json} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v8, resolved type: java.lang.annotation.Annotation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: com.squareup.moshi.Json} */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01e9, code lost:
        if (r9 == null) goto L_0x01eb;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.squareup.moshi.JsonAdapter<?> create(@org.jetbrains.annotations.NotNull java.lang.reflect.Type r28, @org.jetbrains.annotations.NotNull java.util.Set<? extends java.lang.annotation.Annotation> r29, @org.jetbrains.annotations.NotNull com.squareup.moshi.Moshi r30) {
        /*
            r27 = this;
            r1 = r28
            r2 = r30
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "annotations"
            r3 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "moshi"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = r29.isEmpty()
            r3 = 1
            r0 = r0 ^ r3
            r4 = 0
            if (r0 == 0) goto L_0x0020
            return r4
        L_0x0020:
            java.lang.Class r5 = com.squareup.moshi._MoshiKotlinTypesExtensionsKt.getRawType(r28)
            boolean r0 = r5.isInterface()
            if (r0 == 0) goto L_0x002b
            return r4
        L_0x002b:
            boolean r0 = r5.isEnum()
            if (r0 == 0) goto L_0x0032
            return r4
        L_0x0032:
            java.lang.Class r0 = com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterKt.KOTLIN_METADATA
            boolean r0 = r5.isAnnotationPresent(r0)
            if (r0 != 0) goto L_0x003d
            return r4
        L_0x003d:
            boolean r0 = com.squareup.moshi.internal.Util.isPlatformType(r5)
            if (r0 == 0) goto L_0x0044
            return r4
        L_0x0044:
            com.squareup.moshi.JsonAdapter r0 = com.squareup.moshi.internal.Util.generatedAdapter(r2, r1, r5)     // Catch:{ RuntimeException -> 0x004b }
            if (r0 == 0) goto L_0x0055
            return r0
        L_0x004b:
            r0 = move-exception
            r6 = r0
            java.lang.Throwable r0 = r6.getCause()
            boolean r0 = r0 instanceof java.lang.ClassNotFoundException
            if (r0 == 0) goto L_0x0487
        L_0x0055:
            boolean r0 = r5.isLocalClass()
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x0468
            kotlin.reflect.KClass r0 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(r5)
            boolean r6 = r0.isAbstract()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x0449
            boolean r6 = r0.isInner()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x042a
            java.lang.Object r6 = r0.getObjectInstance()
            if (r6 != 0) goto L_0x0076
            r6 = r3
            goto L_0x0077
        L_0x0076:
            r6 = 0
        L_0x0077:
            if (r6 == 0) goto L_0x040b
            boolean r6 = r0.isSealed()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x03e7
            kotlin.reflect.KFunction r6 = kotlin.reflect.full.KClasses.getPrimaryConstructor(r0)
            if (r6 != 0) goto L_0x0087
            return r4
        L_0x0087:
            java.util.List r8 = r6.getParameters()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            r9 = 10
            int r10 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r8, r9)
            int r10 = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(r10)
            r11 = 16
            int r10 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((int) r10, (int) r11)
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>(r10)
            java.util.Iterator r8 = r8.iterator()
        L_0x00a6:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x00bb
            java.lang.Object r10 = r8.next()
            r12 = r10
            kotlin.reflect.KParameter r12 = (kotlin.reflect.KParameter) r12
            java.lang.String r12 = r12.getName()
            r11.put(r12, r10)
            goto L_0x00a6
        L_0x00bb:
            kotlin.reflect.jvm.KCallablesJvm.setAccessible(r6, r3)
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
            java.util.Collection r0 = kotlin.reflect.full.KClasses.getMemberProperties(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x00cb:
            boolean r10 = r0.hasNext()
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            if (r10 == 0) goto L_0x030b
            java.lang.Object r10 = r0.next()
            kotlin.reflect.KProperty1 r10 = (kotlin.reflect.KProperty1) r10
            java.lang.String r13 = r10.getName()
            java.lang.Object r13 = r11.get(r13)
            r15 = r13
            kotlin.reflect.KParameter r15 = (kotlin.reflect.KParameter) r15
            kotlin.reflect.jvm.KCallablesJvm.setAccessible(r10, r3)
            java.util.List r13 = r10.getAnnotations()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r13 = r13.iterator()
        L_0x00f1:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x0105
            java.lang.Object r14 = r13.next()
            r4 = r14
            java.lang.annotation.Annotation r4 = (java.lang.annotation.Annotation) r4
            boolean r4 = r4 instanceof com.squareup.moshi.Json
            if (r4 == 0) goto L_0x0103
            goto L_0x0106
        L_0x0103:
            r4 = 0
            goto L_0x00f1
        L_0x0105:
            r14 = 0
        L_0x0106:
            com.squareup.moshi.Json r14 = (com.squareup.moshi.Json) r14
            java.util.List r4 = r10.getAnnotations()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r4)
            if (r15 == 0) goto L_0x0144
            r13 = r4
            java.util.Collection r13 = (java.util.Collection) r13
            java.util.List r16 = r15.getAnnotations()
            r9 = r16
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(r13, r9)
            if (r14 != 0) goto L_0x0144
            java.util.List r9 = r15.getAnnotations()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x012e:
            boolean r13 = r9.hasNext()
            if (r13 == 0) goto L_0x0140
            java.lang.Object r13 = r9.next()
            r14 = r13
            java.lang.annotation.Annotation r14 = (java.lang.annotation.Annotation) r14
            boolean r14 = r14 instanceof com.squareup.moshi.Json
            if (r14 == 0) goto L_0x012e
            goto L_0x0141
        L_0x0140:
            r13 = 0
        L_0x0141:
            r14 = r13
            com.squareup.moshi.Json r14 = (com.squareup.moshi.Json) r14
        L_0x0144:
            java.lang.reflect.Field r9 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaField(r10)
            if (r9 == 0) goto L_0x014f
            int r9 = r9.getModifiers()
            goto L_0x0150
        L_0x014f:
            r9 = 0
        L_0x0150:
            boolean r9 = java.lang.reflect.Modifier.isTransient(r9)
            if (r9 == 0) goto L_0x0184
            if (r15 == 0) goto L_0x0161
            boolean r4 = r15.isOptional()
            if (r4 == 0) goto L_0x015f
            goto L_0x0161
        L_0x015f:
            r4 = 0
            goto L_0x0162
        L_0x0161:
            r4 = r3
        L_0x0162:
            if (r4 == 0) goto L_0x0169
        L_0x0164:
            r4 = 0
            r9 = 10
            goto L_0x00cb
        L_0x0169:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "No default value for transient constructor "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0184:
            if (r14 == 0) goto L_0x018e
            boolean r9 = r14.ignore()
            if (r9 != r3) goto L_0x018e
            r9 = r3
            goto L_0x018f
        L_0x018e:
            r9 = 0
        L_0x018f:
            if (r9 == 0) goto L_0x01bb
            if (r15 == 0) goto L_0x019c
            boolean r4 = r15.isOptional()
            if (r4 == 0) goto L_0x019a
            goto L_0x019c
        L_0x019a:
            r4 = 0
            goto L_0x019d
        L_0x019c:
            r4 = r3
        L_0x019d:
            if (r4 == 0) goto L_0x01a0
            goto L_0x0164
        L_0x01a0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "No default value for ignored constructor "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x01bb:
            if (r15 == 0) goto L_0x01ce
            kotlin.reflect.KType r9 = r15.getType()
            kotlin.reflect.KType r13 = r10.getReturnType()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r13)
            if (r9 == 0) goto L_0x01cc
            goto L_0x01ce
        L_0x01cc:
            r9 = 0
            goto L_0x01cf
        L_0x01ce:
            r9 = r3
        L_0x01cf:
            if (r9 == 0) goto L_0x02cb
            boolean r9 = r10 instanceof kotlin.reflect.KMutableProperty1
            if (r9 != 0) goto L_0x01d7
            if (r15 == 0) goto L_0x0164
        L_0x01d7:
            if (r14 == 0) goto L_0x01eb
            java.lang.String r9 = r14.name()
            if (r9 == 0) goto L_0x01eb
            java.lang.String r13 = "\u0000"
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r13)
            if (r13 != 0) goto L_0x01e8
            goto L_0x01e9
        L_0x01e8:
            r9 = 0
        L_0x01e9:
            if (r9 != 0) goto L_0x01ef
        L_0x01eb:
            java.lang.String r9 = r10.getName()
        L_0x01ef:
            r14 = r9
            kotlin.reflect.KType r9 = r10.getReturnType()
            kotlin.reflect.KClassifier r9 = r9.getClassifier()
            boolean r13 = r9 instanceof kotlin.reflect.KClass
            if (r13 == 0) goto L_0x026b
            kotlin.reflect.KClass r9 = (kotlin.reflect.KClass) r9
            boolean r13 = r9.isValue()
            if (r13 == 0) goto L_0x0262
            java.lang.Class r9 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r9)
            kotlin.reflect.KType r13 = r10.getReturnType()
            java.util.List r13 = r13.getArguments()
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x0217
            goto L_0x0277
        L_0x0217:
            kotlin.reflect.KType r13 = r10.getReturnType()
            java.util.List r13 = r13.getArguments()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r13 = r13.iterator()
        L_0x022a:
            boolean r16 = r13.hasNext()
            if (r16 == 0) goto L_0x024a
            java.lang.Object r16 = r13.next()
            kotlin.reflect.KTypeProjection r16 = (kotlin.reflect.KTypeProjection) r16
            kotlin.reflect.KType r16 = r16.getType()
            if (r16 == 0) goto L_0x0243
            java.lang.reflect.Type r16 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaType(r16)
            r7 = r16
            goto L_0x0244
        L_0x0243:
            r7 = 0
        L_0x0244:
            if (r7 == 0) goto L_0x022a
            r3.add(r7)
            goto L_0x022a
        L_0x024a:
            r7 = 0
            java.lang.reflect.Type[] r13 = new java.lang.reflect.Type[r7]
            java.lang.Object[] r3 = r3.toArray(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r12)
            java.lang.reflect.Type[] r3 = (java.lang.reflect.Type[]) r3
            int r7 = r3.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r7)
            java.lang.reflect.Type[] r3 = (java.lang.reflect.Type[]) r3
            java.lang.reflect.ParameterizedType r9 = com.squareup.moshi.Types.newParameterizedType(r9, r3)
            goto L_0x0277
        L_0x0262:
            kotlin.reflect.KType r3 = r10.getReturnType()
            java.lang.reflect.Type r9 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaType(r3)
            goto L_0x0277
        L_0x026b:
            boolean r3 = r9 instanceof kotlin.reflect.KTypeParameter
            if (r3 == 0) goto L_0x02bf
            kotlin.reflect.KType r3 = r10.getReturnType()
            java.lang.reflect.Type r9 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaType(r3)
        L_0x0277:
            java.lang.reflect.Type r3 = com.squareup.moshi.internal.Util.resolve(r1, r5, r9)
            java.util.Collection r4 = (java.util.Collection) r4
            r7 = 0
            java.lang.annotation.Annotation[] r9 = new java.lang.annotation.Annotation[r7]
            java.lang.Object[] r4 = r4.toArray(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r12)
            java.lang.annotation.Annotation[] r4 = (java.lang.annotation.Annotation[]) r4
            java.util.Set r4 = com.squareup.moshi.internal.Util.jsonAnnotations((java.lang.annotation.Annotation[]) r4)
            java.lang.String r7 = r10.getName()
            com.squareup.moshi.JsonAdapter r3 = r2.adapter(r3, r4, r7)
            java.lang.String r4 = r10.getName()
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r7 = new com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding
            java.lang.String r9 = "adapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.reflect.KProperty1<kotlin.Any, kotlin.Any?>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r9)
            if (r15 == 0) goto L_0x02ac
            int r9 = r15.getIndex()
            goto L_0x02ad
        L_0x02ac:
            r9 = -1
        L_0x02ad:
            r18 = r9
            r13 = r7
            r9 = r15
            r15 = r3
            r16 = r10
            r17 = r9
            r13.<init>(r14, r15, r16, r17, r18)
            r8.put(r4, r7)
            r3 = 1
            goto L_0x0164
        L_0x02bf:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Not possible!"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x02cb:
            r9 = r15
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 39
            r0.append(r1)
            java.lang.String r1 = r10.getName()
            r0.append(r1)
            java.lang.String r1 = "' has a constructor parameter of type "
            r0.append(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            kotlin.reflect.KType r1 = r9.getType()
            r0.append(r1)
            java.lang.String r1 = " but a property of type "
            r0.append(r1)
            kotlin.reflect.KType r1 = r10.getReturnType()
            r0.append(r1)
            r1 = 46
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x030b:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r1 = r6.getParameters()
            java.util.Iterator r1 = r1.iterator()
        L_0x0318:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x035f
            java.lang.Object r2 = r1.next()
            kotlin.reflect.KParameter r2 = (kotlin.reflect.KParameter) r2
            java.lang.String r3 = r2.getName()
            java.util.Map r4 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r8)
            java.lang.Object r3 = r4.remove(r3)
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r3 = (com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding) r3
            if (r3 != 0) goto L_0x033d
            boolean r4 = r2.isOptional()
            if (r4 == 0) goto L_0x033b
            goto L_0x033d
        L_0x033b:
            r7 = 0
            goto L_0x033e
        L_0x033d:
            r7 = 1
        L_0x033e:
            if (r7 == 0) goto L_0x0344
            r0.add(r3)
            goto L_0x0318
        L_0x0344:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "No property for required constructor "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x035f:
            int r1 = r0.size()
            java.util.Set r2 = r8.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x036b:
            r24 = r1
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x0397
            java.lang.Object r1 = r2.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getValue()
            r19 = r1
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r19 = (com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding) r19
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            int r1 = r24 + 1
            r25 = 15
            r26 = 0
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r3 = com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding.copy$default(r19, r20, r21, r22, r23, r24, r25, r26)
            r0.add(r3)
            goto L_0x036b
        L_0x0397:
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r0)
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r2, r4)
            r3.<init>(r4)
            java.util.Iterator r2 = r2.iterator()
        L_0x03ad:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x03c1
            java.lang.Object r4 = r2.next()
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r4 = (com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding) r4
            java.lang.String r4 = r4.getJsonName()
            r3.add(r4)
            goto L_0x03ad
        L_0x03c1:
            r4 = 0
            java.lang.String[] r2 = new java.lang.String[r4]
            java.lang.Object[] r2 = r3.toArray(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r12)
            java.lang.String[] r2 = (java.lang.String[]) r2
            int r3 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)
            java.lang.String[] r2 = (java.lang.String[]) r2
            com.squareup.moshi.JsonReader$Options r2 = com.squareup.moshi.JsonReader.Options.of(r2)
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter r3 = new com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter
            java.lang.String r4 = "options"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r3.<init>(r6, r0, r1, r2)
            com.squareup.moshi.JsonAdapter r0 = r3.nullSafe()
            return r0
        L_0x03e7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot reflectively serialize sealed class "
            r0.append(r1)
            java.lang.String r1 = r5.getName()
            r0.append(r1)
            java.lang.String r1 = ". Please register an adapter."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x040b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot serialize object declaration "
            r0.append(r1)
            java.lang.String r1 = r5.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x042a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot serialize inner class "
            r0.append(r1)
            java.lang.String r1 = r5.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0449:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot serialize abstract class "
            r0.append(r1)
            java.lang.String r1 = r5.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0468:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot serialize local class or object expression "
            r0.append(r1)
            java.lang.String r1 = r5.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0487:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory.create(java.lang.reflect.Type, java.util.Set, com.squareup.moshi.Moshi):com.squareup.moshi.JsonAdapter");
    }
}
