package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u0018\u0010)\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u0018\u0010)\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u0018\u0010)\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u0018\u0010)\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a@\u00102\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a@\u00102\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a@\u00102\u001a\u0004\u0018\u00010\n\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a@\u00102\u001a\u0004\u0018\u00010\u000e\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a4\u0010?\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`BH\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a4\u0010?\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0006`BH\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a4\u0010?\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\n0Aj\n\u0012\u0006\b\u0000\u0012\u00020\n`BH\u0007ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001a4\u0010?\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000e`BH\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a\u0018\u0010K\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\bL\u0010+\u001a\u0018\u0010K\u001a\u0004\u0018\u00010\u0006*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010-\u001a\u0018\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\bN\u0010/\u001a\u0018\u0010K\u001a\u0004\u0018\u00010\u000e*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\bO\u00101\u001a@\u0010P\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H306H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u00108\u001a@\u0010P\u001a\u0004\u0018\u00010\u0006\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H306H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010:\u001a@\u0010P\u001a\u0004\u0018\u00010\n\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H306H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010<\u001a@\u0010P\u001a\u0004\u0018\u00010\u000e\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H306H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010>\u001a4\u0010U\u001a\u0004\u0018\u00010\u0002*\u00020\u00032\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`BH\u0007ø\u0001\u0000¢\u0006\u0004\bV\u0010D\u001a4\u0010U\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00060Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0006`BH\u0007ø\u0001\u0000¢\u0006\u0004\bW\u0010F\u001a4\u0010U\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\n0Aj\n\u0012\u0006\b\u0000\u0012\u00020\n`BH\u0007ø\u0001\u0000¢\u0006\u0004\bX\u0010H\u001a4\u0010U\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000e0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000e`BH\u0007ø\u0001\u0000¢\u0006\u0004\bY\u0010J\u001a.\u0010Z\u001a\u00020[*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020[06H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a.\u0010Z\u001a\u00020^*\u00020\u00032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020^06H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b_\u0010`\u001a.\u0010Z\u001a\u00020[*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020[06H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010a\u001a.\u0010Z\u001a\u00020^*\u00020\u00072\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020^06H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b_\u0010b\u001a.\u0010Z\u001a\u00020[*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020[06H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010c\u001a.\u0010Z\u001a\u00020^*\u00020\u000b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020^06H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b_\u0010d\u001a.\u0010Z\u001a\u00020[*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020[06H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010e\u001a.\u0010Z\u001a\u00020^*\u00020\u000f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020^06H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b_\u0010f\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006g"}, d2 = {"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "max", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max--ajY-9A", "([I)Lkotlin/UInt;", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min-GBYM_sE", "min--ajY-9A", "min-QwZRm1k", "min-rL5Bavg", "minBy", "minBy-JOV_ifY", "minBy-jgv0xPQ", "minBy-MShoTSo", "minBy-xTcfx_M", "minWith", "minWith-XMRcp5o", "minWith-YmdZ_VM", "minWith-zrEWJaI", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, pn = "kotlin.collections", xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
class UArraysKt___UArraysJvmKt {
    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: asList--ajY-9A  reason: not valid java name */
    public static final List<UInt> m6796asListajY9A(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1(iArr);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: asList-GBYM_sE  reason: not valid java name */
    public static final List<UByte> m6797asListGBYM_sE(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3(bArr);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: asList-QwZRm1k  reason: not valid java name */
    public static final List<ULong> m6798asListQwZRm1k(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2(jArr);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: asList-rL5Bavg  reason: not valid java name */
    public static final List<UShort> m6799asListrL5Bavg(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4(sArr);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: binarySearch-2fe2U9s  reason: not valid java name */
    public static final int m6800binarySearch2fe2U9s(@NotNull int[] iArr, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(iArr, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i12, i13, UIntArray.m6483getSizeimpl(iArr));
        int i14 = i13 - 1;
        while (i12 <= i14) {
            int i15 = (i12 + i14) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(iArr[i15], i11);
            if (uintCompare < 0) {
                i12 = i15 + 1;
            } else if (uintCompare <= 0) {
                return i15;
            } else {
                i14 = i15 - 1;
            }
        }
        return -(i12 + 1);
    }

    /* renamed from: binarySearch-2fe2U9s$default  reason: not valid java name */
    public static /* synthetic */ int m6801binarySearch2fe2U9s$default(int[] iArr, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i12 = 0;
        }
        if ((i14 & 4) != 0) {
            i13 = UIntArray.m6483getSizeimpl(iArr);
        }
        return m6800binarySearch2fe2U9s(iArr, i11, i12, i13);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: binarySearch-EtDCXyQ  reason: not valid java name */
    public static final int m6802binarySearchEtDCXyQ(@NotNull short[] sArr, short s11, int i11, int i12) {
        Intrinsics.checkNotNullParameter(sArr, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i11, i12, UShortArray.m6665getSizeimpl(sArr));
        short s12 = s11 & UShort.MAX_VALUE;
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(sArr[i14], s12);
            if (uintCompare < 0) {
                i11 = i14 + 1;
            } else if (uintCompare <= 0) {
                return i14;
            } else {
                i13 = i14 - 1;
            }
        }
        return -(i11 + 1);
    }

    /* renamed from: binarySearch-EtDCXyQ$default  reason: not valid java name */
    public static /* synthetic */ int m6803binarySearchEtDCXyQ$default(short[] sArr, short s11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = UShortArray.m6665getSizeimpl(sArr);
        }
        return m6802binarySearchEtDCXyQ(sArr, s11, i11, i12);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: binarySearch-K6DWlUc  reason: not valid java name */
    public static final int m6804binarySearchK6DWlUc(@NotNull long[] jArr, long j11, int i11, int i12) {
        Intrinsics.checkNotNullParameter(jArr, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i11, i12, ULongArray.m6561getSizeimpl(jArr));
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int ulongCompare = UnsignedKt.ulongCompare(jArr[i14], j11);
            if (ulongCompare < 0) {
                i11 = i14 + 1;
            } else if (ulongCompare <= 0) {
                return i14;
            } else {
                i13 = i14 - 1;
            }
        }
        return -(i11 + 1);
    }

    /* renamed from: binarySearch-K6DWlUc$default  reason: not valid java name */
    public static /* synthetic */ int m6805binarySearchK6DWlUc$default(long[] jArr, long j11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = ULongArray.m6561getSizeimpl(jArr);
        }
        return m6804binarySearchK6DWlUc(jArr, j11, i11, i12);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    /* renamed from: binarySearch-WpHrYlw  reason: not valid java name */
    public static final int m6806binarySearchWpHrYlw(@NotNull byte[] bArr, byte b11, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bArr, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i11, i12, UByteArray.m6405getSizeimpl(bArr));
        byte b12 = b11 & 255;
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(bArr[i14], b12);
            if (uintCompare < 0) {
                i11 = i14 + 1;
            } else if (uintCompare <= 0) {
                return i14;
            } else {
                i13 = i14 - 1;
            }
        }
        return -(i11 + 1);
    }

    /* renamed from: binarySearch-WpHrYlw$default  reason: not valid java name */
    public static /* synthetic */ int m6807binarySearchWpHrYlw$default(byte[] bArr, byte b11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = UByteArray.m6405getSizeimpl(bArr);
        }
        return m6806binarySearchWpHrYlw(bArr, b11, i11, i12);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: elementAt-PpDY95g  reason: not valid java name */
    private static final byte m6808elementAtPpDY95g(byte[] bArr, int i11) {
        Intrinsics.checkNotNullParameter(bArr, "$this$elementAt");
        return UByteArray.m6404getw2LRezQ(bArr, i11);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: elementAt-nggk6HY  reason: not valid java name */
    private static final short m6809elementAtnggk6HY(short[] sArr, int i11) {
        Intrinsics.checkNotNullParameter(sArr, "$this$elementAt");
        return UShortArray.m6664getMh2AYeg(sArr, i11);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: elementAt-qFRl0hI  reason: not valid java name */
    private static final int m6810elementAtqFRl0hI(int[] iArr, int i11) {
        Intrinsics.checkNotNullParameter(iArr, "$this$elementAt");
        return UIntArray.m6482getpVg5ArA(iArr, i11);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: elementAt-r7IrZao  reason: not valid java name */
    private static final long m6811elementAtr7IrZao(long[] jArr, int i11) {
        Intrinsics.checkNotNullParameter(jArr, "$this$elementAt");
        return ULongArray.m6560getsVKNKU(jArr, i11);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @InlineOnly
    /* renamed from: maxBy-JOV_ifY  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m6816maxByJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UByteArray.m6407isEmptyimpl(bArr)) {
            return null;
        }
        byte b11 = UByteArray.m6404getw2LRezQ(bArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(bArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) function1.invoke(UByte.m6341boximpl(b11));
            IntIterator it = new IntRange(1, lastIndex).iterator();
            while (it.hasNext()) {
                byte b12 = UByteArray.m6404getw2LRezQ(bArr, it.nextInt());
                Comparable comparable2 = (Comparable) function1.invoke(UByte.m6341boximpl(b12));
                if (comparable.compareTo(comparable2) < 0) {
                    b11 = b12;
                    comparable = comparable2;
                }
            }
        }
        return UByte.m6341boximpl(b11);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @InlineOnly
    /* renamed from: maxBy-MShoTSo  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m6817maxByMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (ULongArray.m6563isEmptyimpl(jArr)) {
            return null;
        }
        long j11 = ULongArray.m6560getsVKNKU(jArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(jArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) function1.invoke(ULong.m6495boximpl(j11));
            IntIterator it = new IntRange(1, lastIndex).iterator();
            while (it.hasNext()) {
                long j12 = ULongArray.m6560getsVKNKU(jArr, it.nextInt());
                Comparable comparable2 = (Comparable) function1.invoke(ULong.m6495boximpl(j12));
                if (comparable.compareTo(comparable2) < 0) {
                    j11 = j12;
                    comparable = comparable2;
                }
            }
        }
        return ULong.m6495boximpl(j11);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @InlineOnly
    /* renamed from: maxBy-jgv0xPQ  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m6818maxByjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UIntArray.m6485isEmptyimpl(iArr)) {
            return null;
        }
        int i11 = UIntArray.m6482getpVg5ArA(iArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(iArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) function1.invoke(UInt.m6417boximpl(i11));
            IntIterator it = new IntRange(1, lastIndex).iterator();
            while (it.hasNext()) {
                int i12 = UIntArray.m6482getpVg5ArA(iArr, it.nextInt());
                Comparable comparable2 = (Comparable) function1.invoke(UInt.m6417boximpl(i12));
                if (comparable.compareTo(comparable2) < 0) {
                    i11 = i12;
                    comparable = comparable2;
                }
            }
        }
        return UInt.m6417boximpl(i11);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @InlineOnly
    /* renamed from: maxBy-xTcfx_M  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m6819maxByxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UShortArray.m6667isEmptyimpl(sArr)) {
            return null;
        }
        short s11 = UShortArray.m6664getMh2AYeg(sArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(sArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) function1.invoke(UShort.m6601boximpl(s11));
            IntIterator it = new IntRange(1, lastIndex).iterator();
            while (it.hasNext()) {
                short s12 = UShortArray.m6664getMh2AYeg(sArr, it.nextInt());
                Comparable comparable2 = (Comparable) function1.invoke(UShort.m6601boximpl(s12));
                if (comparable.compareTo(comparable2) < 0) {
                    s11 = s12;
                    comparable = comparable2;
                }
            }
        }
        return UShort.m6601boximpl(s11);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    /* renamed from: maxWith-XMRcp5o  reason: not valid java name */
    public static final /* synthetic */ UByte m6820maxWithXMRcp5o(byte[] bArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m7196maxWithOrNullXMRcp5o(bArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    /* renamed from: maxWith-YmdZ_VM  reason: not valid java name */
    public static final /* synthetic */ UInt m6821maxWithYmdZ_VM(int[] iArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m7197maxWithOrNullYmdZ_VM(iArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    /* renamed from: maxWith-eOHTfZs  reason: not valid java name */
    public static final /* synthetic */ UShort m6822maxWitheOHTfZs(short[] sArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m7198maxWithOrNulleOHTfZs(sArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    /* renamed from: maxWith-zrEWJaI  reason: not valid java name */
    public static final /* synthetic */ ULong m6823maxWithzrEWJaI(long[] jArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m7199maxWithOrNullzrEWJaI(jArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @InlineOnly
    /* renamed from: minBy-JOV_ifY  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m6828minByJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UByteArray.m6407isEmptyimpl(bArr)) {
            return null;
        }
        byte b11 = UByteArray.m6404getw2LRezQ(bArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(bArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) function1.invoke(UByte.m6341boximpl(b11));
            IntIterator it = new IntRange(1, lastIndex).iterator();
            while (it.hasNext()) {
                byte b12 = UByteArray.m6404getw2LRezQ(bArr, it.nextInt());
                Comparable comparable2 = (Comparable) function1.invoke(UByte.m6341boximpl(b12));
                if (comparable.compareTo(comparable2) > 0) {
                    b11 = b12;
                    comparable = comparable2;
                }
            }
        }
        return UByte.m6341boximpl(b11);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @InlineOnly
    /* renamed from: minBy-MShoTSo  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m6829minByMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (ULongArray.m6563isEmptyimpl(jArr)) {
            return null;
        }
        long j11 = ULongArray.m6560getsVKNKU(jArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(jArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) function1.invoke(ULong.m6495boximpl(j11));
            IntIterator it = new IntRange(1, lastIndex).iterator();
            while (it.hasNext()) {
                long j12 = ULongArray.m6560getsVKNKU(jArr, it.nextInt());
                Comparable comparable2 = (Comparable) function1.invoke(ULong.m6495boximpl(j12));
                if (comparable.compareTo(comparable2) > 0) {
                    j11 = j12;
                    comparable = comparable2;
                }
            }
        }
        return ULong.m6495boximpl(j11);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @InlineOnly
    /* renamed from: minBy-jgv0xPQ  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m6830minByjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UIntArray.m6485isEmptyimpl(iArr)) {
            return null;
        }
        int i11 = UIntArray.m6482getpVg5ArA(iArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(iArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) function1.invoke(UInt.m6417boximpl(i11));
            IntIterator it = new IntRange(1, lastIndex).iterator();
            while (it.hasNext()) {
                int i12 = UIntArray.m6482getpVg5ArA(iArr, it.nextInt());
                Comparable comparable2 = (Comparable) function1.invoke(UInt.m6417boximpl(i12));
                if (comparable.compareTo(comparable2) > 0) {
                    i11 = i12;
                    comparable = comparable2;
                }
            }
        }
        return UInt.m6417boximpl(i11);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @InlineOnly
    /* renamed from: minBy-xTcfx_M  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m6831minByxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (UShortArray.m6667isEmptyimpl(sArr)) {
            return null;
        }
        short s11 = UShortArray.m6664getMh2AYeg(sArr, 0);
        int lastIndex = ArraysKt___ArraysKt.getLastIndex(sArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) function1.invoke(UShort.m6601boximpl(s11));
            IntIterator it = new IntRange(1, lastIndex).iterator();
            while (it.hasNext()) {
                short s12 = UShortArray.m6664getMh2AYeg(sArr, it.nextInt());
                Comparable comparable2 = (Comparable) function1.invoke(UShort.m6601boximpl(s12));
                if (comparable.compareTo(comparable2) > 0) {
                    s11 = s12;
                    comparable = comparable2;
                }
            }
        }
        return UShort.m6601boximpl(s11);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    /* renamed from: minWith-XMRcp5o  reason: not valid java name */
    public static final /* synthetic */ UByte m6832minWithXMRcp5o(byte[] bArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m7252minWithOrNullXMRcp5o(bArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    /* renamed from: minWith-YmdZ_VM  reason: not valid java name */
    public static final /* synthetic */ UInt m6833minWithYmdZ_VM(int[] iArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m7253minWithOrNullYmdZ_VM(iArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    /* renamed from: minWith-eOHTfZs  reason: not valid java name */
    public static final /* synthetic */ UShort m6834minWitheOHTfZs(short[] sArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m7254minWithOrNulleOHTfZs(sArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    /* renamed from: minWith-zrEWJaI  reason: not valid java name */
    public static final /* synthetic */ ULong m6835minWithzrEWJaI(long[] jArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt___UArraysKt.m7255minWithOrNullzrEWJaI(jArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    private static final BigDecimal sumOfBigDecimal(int[] iArr, Function1<? super UInt, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        int r12 = UIntArray.m6483getSizeimpl(iArr);
        for (int i11 = 0; i11 < r12; i11++) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(UInt.m6417boximpl(UIntArray.m6482getpVg5ArA(iArr, i11))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    private static final BigInteger sumOfBigInteger(int[] iArr, Function1<? super UInt, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        int r12 = UIntArray.m6483getSizeimpl(iArr);
        for (int i11 = 0; i11 < r12; i11++) {
            valueOf = valueOf.add((BigInteger) function1.invoke(UInt.m6417boximpl(UIntArray.m6482getpVg5ArA(iArr, i11))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    private static final BigDecimal sumOfBigDecimal(long[] jArr, Function1<? super ULong, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        int r12 = ULongArray.m6561getSizeimpl(jArr);
        for (int i11 = 0; i11 < r12; i11++) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(ULong.m6495boximpl(ULongArray.m6560getsVKNKU(jArr, i11))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    private static final BigInteger sumOfBigInteger(long[] jArr, Function1<? super ULong, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        int r12 = ULongArray.m6561getSizeimpl(jArr);
        for (int i11 = 0; i11 < r12; i11++) {
            valueOf = valueOf.add((BigInteger) function1.invoke(ULong.m6495boximpl(ULongArray.m6560getsVKNKU(jArr, i11))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    private static final BigDecimal sumOfBigDecimal(byte[] bArr, Function1<? super UByte, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        int r12 = UByteArray.m6405getSizeimpl(bArr);
        for (int i11 = 0; i11 < r12; i11++) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(UByte.m6341boximpl(UByteArray.m6404getw2LRezQ(bArr, i11))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    private static final BigInteger sumOfBigInteger(byte[] bArr, Function1<? super UByte, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        int r12 = UByteArray.m6405getSizeimpl(bArr);
        for (int i11 = 0; i11 < r12; i11++) {
            valueOf = valueOf.add((BigInteger) function1.invoke(UByte.m6341boximpl(UByteArray.m6404getw2LRezQ(bArr, i11))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    private static final BigDecimal sumOfBigDecimal(short[] sArr, Function1<? super UShort, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        int r12 = UShortArray.m6665getSizeimpl(sArr);
        for (int i11 = 0; i11 < r12; i11++) {
            valueOf = valueOf.add((BigDecimal) function1.invoke(UShort.m6601boximpl(UShortArray.m6664getMh2AYeg(sArr, i11))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    private static final BigInteger sumOfBigInteger(short[] sArr, Function1<? super UShort, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sumOf");
        Intrinsics.checkNotNullParameter(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        int r12 = UShortArray.m6665getSizeimpl(sArr);
        for (int i11 = 0; i11 < r12; i11++) {
            valueOf = valueOf.add((BigInteger) function1.invoke(UShort.m6601boximpl(UShortArray.m6664getMh2AYeg(sArr, i11))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
        }
        return valueOf;
    }
}
