package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\t\u0010\n\u001a?\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003¢\u0006\u0002\u0010\u0016\u001a;\u0010\u0017\u001a\u0002H\u0018\"\u0010\b\u0000\u0010\u0019*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0018\"\u0004\b\u0001\u0010\u0018*\u0002H\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u001e\u001aG\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00150 \"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180 0\u0003¢\u0006\u0002\u0010!\u0002\u0007\n\u0005\b20\u0001¨\u0006\""}, d2 = {"contentDeepEqualsImpl", "", "T", "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/ArraysKt")
class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepEquals")
    public static final <T> boolean contentDeepEquals(@Nullable T[] tArr, @Nullable T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == null || tArr2 == null || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            T t11 = tArr[i11];
            T t12 = tArr2[i11];
            if (t11 != t12) {
                if (t11 == null || t12 == null) {
                    return false;
                }
                if (!(t11 instanceof Object[]) || !(t12 instanceof Object[])) {
                    if (!(t11 instanceof byte[]) || !(t12 instanceof byte[])) {
                        if (!(t11 instanceof short[]) || !(t12 instanceof short[])) {
                            if (!(t11 instanceof int[]) || !(t12 instanceof int[])) {
                                if (!(t11 instanceof long[]) || !(t12 instanceof long[])) {
                                    if (!(t11 instanceof float[]) || !(t12 instanceof float[])) {
                                        if (!(t11 instanceof double[]) || !(t12 instanceof double[])) {
                                            if (!(t11 instanceof char[]) || !(t12 instanceof char[])) {
                                                if (!(t11 instanceof boolean[]) || !(t12 instanceof boolean[])) {
                                                    if (!(t11 instanceof UByteArray) || !(t12 instanceof UByteArray)) {
                                                        if (!(t11 instanceof UShortArray) || !(t12 instanceof UShortArray)) {
                                                            if (!(t11 instanceof UIntArray) || !(t12 instanceof UIntArray)) {
                                                                if (!(t11 instanceof ULongArray) || !(t12 instanceof ULongArray)) {
                                                                    if (!Intrinsics.areEqual((Object) t11, (Object) t12)) {
                                                                        return false;
                                                                    }
                                                                } else if (!UArraysKt___UArraysKt.m6901contentEqualslec5QzE(((ULongArray) t11).m6569unboximpl(), ((ULongArray) t12).m6569unboximpl())) {
                                                                    return false;
                                                                }
                                                            } else if (!UArraysKt___UArraysKt.m6897contentEqualsKJPZfPQ(((UIntArray) t11).m6491unboximpl(), ((UIntArray) t12).m6491unboximpl())) {
                                                                return false;
                                                            }
                                                        } else if (!UArraysKt___UArraysKt.m6896contentEqualsFGO6Aew(((UShortArray) t11).m6673unboximpl(), ((UShortArray) t12).m6673unboximpl())) {
                                                            return false;
                                                        }
                                                    } else if (!UArraysKt___UArraysKt.m6899contentEqualskV0jMPg(((UByteArray) t11).m6413unboximpl(), ((UByteArray) t12).m6413unboximpl())) {
                                                        return false;
                                                    }
                                                } else if (!Arrays.equals((boolean[]) t11, (boolean[]) t12)) {
                                                    return false;
                                                }
                                            } else if (!Arrays.equals((char[]) t11, (char[]) t12)) {
                                                return false;
                                            }
                                        } else if (!Arrays.equals((double[]) t11, (double[]) t12)) {
                                            return false;
                                        }
                                    } else if (!Arrays.equals((float[]) t11, (float[]) t12)) {
                                        return false;
                                    }
                                } else if (!Arrays.equals((long[]) t11, (long[]) t12)) {
                                    return false;
                                }
                            } else if (!Arrays.equals((int[]) t11, (int[]) t12)) {
                                return false;
                            }
                        } else if (!Arrays.equals((short[]) t11, (short[]) t12)) {
                            return false;
                        }
                    } else if (!Arrays.equals((byte[]) t11, (byte[]) t12)) {
                        return false;
                    }
                } else if (!contentDeepEquals((Object[]) t11, (Object[]) t12)) {
                    return false;
                }
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    @JvmName(name = "contentDeepToString")
    public static final <T> String contentDeepToString(@Nullable T[] tArr) {
        if (tArr == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder((RangesKt___RangesKt.coerceAtMost(tArr.length, 429496729) * 5) + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt(tArr, sb2, new ArrayList());
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] tArr, StringBuilder sb2, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb2.append("[...]");
            return;
        }
        list.add(tArr);
        sb2.append('[');
        int length = tArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 != 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            T t11 = tArr[i11];
            if (t11 == null) {
                sb2.append("null");
            } else if (t11 instanceof Object[]) {
                contentDeepToStringInternal$ArraysKt__ArraysKt((Object[]) t11, sb2, list);
            } else if (t11 instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) t11);
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                sb2.append(arrays);
            } else if (t11 instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) t11);
                Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
                sb2.append(arrays2);
            } else if (t11 instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) t11);
                Intrinsics.checkNotNullExpressionValue(arrays3, "toString(this)");
                sb2.append(arrays3);
            } else if (t11 instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) t11);
                Intrinsics.checkNotNullExpressionValue(arrays4, "toString(this)");
                sb2.append(arrays4);
            } else if (t11 instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) t11);
                Intrinsics.checkNotNullExpressionValue(arrays5, "toString(this)");
                sb2.append(arrays5);
            } else if (t11 instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) t11);
                Intrinsics.checkNotNullExpressionValue(arrays6, "toString(this)");
                sb2.append(arrays6);
            } else if (t11 instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) t11);
                Intrinsics.checkNotNullExpressionValue(arrays7, "toString(this)");
                sb2.append(arrays7);
            } else if (t11 instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) t11);
                Intrinsics.checkNotNullExpressionValue(arrays8, "toString(this)");
                sb2.append(arrays8);
            } else if (t11 instanceof UByteArray) {
                sb2.append(UArraysKt___UArraysKt.m6913contentToString2csIQuQ(((UByteArray) t11).m6413unboximpl()));
            } else if (t11 instanceof UShortArray) {
                sb2.append(UArraysKt___UArraysKt.m6917contentToStringd6D3K8(((UShortArray) t11).m6673unboximpl()));
            } else if (t11 instanceof UIntArray) {
                sb2.append(UArraysKt___UArraysKt.m6916contentToStringXUkPCBk(((UIntArray) t11).m6491unboximpl()));
            } else if (t11 instanceof ULongArray) {
                sb2.append(UArraysKt___UArraysKt.m6919contentToStringuLth9ew(((ULongArray) t11).m6569unboximpl()));
            } else {
                sb2.append(t11.toString());
            }
        }
        sb2.append(AbstractJsonLexerKt.END_LIST);
        list.remove(CollectionsKt__CollectionsKt.getLastIndex(list));
    }

    @NotNull
    public static final <T> List<T> flatten(@NotNull T[][] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i11 = 0;
        for (T[] length : tArr) {
            i11 += length.length;
        }
        ArrayList arrayList = new ArrayList(i11);
        for (T[] addAll : tArr) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, addAll);
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [R, C] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.internal.InlineOnly
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <C extends java.lang.Object & R, R> R ifEmpty(C r1, kotlin.jvm.functions.Function0<? extends R> r2) {
        /*
            java.lang.String r0 = "defaultValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            int r0 = r1.length
            if (r0 != 0) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            if (r0 == 0) goto L_0x0011
            java.lang.Object r1 = r2.invoke()
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArraysKt__ArraysKt.ifEmpty(java.lang.Object[], kotlin.jvm.functions.Function0):java.lang.Object");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean isNullOrEmpty(Object[] objArr) {
        if (objArr == null) {
            return true;
        }
        return objArr.length == 0;
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull Pair<? extends T, ? extends R>[] pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "<this>");
        ArrayList arrayList = new ArrayList(pairArr.length);
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<? extends T, ? extends R> pair : pairArr) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }
}
