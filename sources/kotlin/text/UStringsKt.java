package kotlin.text;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0007*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0014\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000\u001a\u0014\u0010\u0018\u001a\u00020\n*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u0018\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0011\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0019\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001c\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0011\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007ø\u0001\u0000\u001a\u0019\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "UStringsKt")
public final class UStringsKt {
    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: toString-JSWoG40  reason: not valid java name */
    public static final String m7599toStringJSWoG40(long j11, int i11) {
        return UnsignedKt.ulongToString(j11, CharsKt__CharJVMKt.checkRadix(i11));
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: toString-LxnNnR4  reason: not valid java name */
    public static final String m7600toStringLxnNnR4(byte b11, int i11) {
        String num = Integer.toString(b11 & 255, CharsKt__CharJVMKt.checkRadix(i11));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: toString-V7xB4Y4  reason: not valid java name */
    public static final String m7601toStringV7xB4Y4(int i11, int i12) {
        String l11 = Long.toString(((long) i11) & 4294967295L, CharsKt__CharJVMKt.checkRadix(i12));
        Intrinsics.checkNotNullExpressionValue(l11, "toString(this, checkRadix(radix))");
        return l11;
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: toString-olVBNx4  reason: not valid java name */
    public static final String m7602toStringolVBNx4(short s11, int i11) {
        String num = Integer.toString(s11 & UShort.MAX_VALUE, CharsKt__CharJVMKt.checkRadix(i11));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte toUByte(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UByte uByteOrNull = toUByteOrNull(str);
        if (uByteOrNull != null) {
            return uByteOrNull.m6396unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UByte toUByteOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUByteOrNull(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int toUInt(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            return uIntOrNull.m6474unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UInt toUIntOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUIntOrNull(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long toULong(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULong uLongOrNull = toULongOrNull(str);
        if (uLongOrNull != null) {
            return uLongOrNull.m6552unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULong toULongOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toULongOrNull(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short toUShort(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UShort uShortOrNull = toUShortOrNull(str);
        if (uShortOrNull != null) {
            return uShortOrNull.m6656unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UShort toUShortOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUShortOrNull(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte toUByte(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UByte uByteOrNull = toUByteOrNull(str, i11);
        if (uByteOrNull != null) {
            return uByteOrNull.m6396unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UByte toUByteOrNull(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str, i11);
        if (uIntOrNull == null) {
            return null;
        }
        int r12 = uIntOrNull.m6474unboximpl();
        if (UnsignedKt.uintCompare(r12, UInt.m6423constructorimpl(255)) > 0) {
            return null;
        }
        return UByte.m6341boximpl(UByte.m6347constructorimpl((byte) r12));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int toUInt(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str, i11);
        if (uIntOrNull != null) {
            return uIntOrNull.m6474unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UInt toUIntOrNull(@NotNull String str, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int unused = CharsKt__CharJVMKt.checkRadix(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i13 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            i12 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            i12 = 0;
        }
        int r32 = UInt.m6423constructorimpl(i11);
        int i14 = 119304647;
        while (i12 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i12), i11);
            if (digitOf < 0) {
                return null;
            }
            if (UnsignedKt.uintCompare(i13, i14) > 0) {
                if (i14 == 119304647) {
                    i14 = UnsignedKt.m6676uintDivideJ1ME1BU(-1, r32);
                    if (UnsignedKt.uintCompare(i13, i14) > 0) {
                    }
                }
                return null;
            }
            int r22 = UInt.m6423constructorimpl(i13 * r32);
            int r72 = UInt.m6423constructorimpl(UInt.m6423constructorimpl(digitOf) + r22);
            if (UnsignedKt.uintCompare(r72, r22) < 0) {
                return null;
            }
            i12++;
            i13 = r72;
        }
        return UInt.m6417boximpl(i13);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long toULong(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULong uLongOrNull = toULongOrNull(str, i11);
        if (uLongOrNull != null) {
            return uLongOrNull.m6552unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULong toULongOrNull(@NotNull String str, int i11) {
        String str2 = str;
        int i12 = i11;
        Intrinsics.checkNotNullParameter(str2, "<this>");
        int unused = CharsKt__CharJVMKt.checkRadix(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i13 = 0;
        char charAt = str2.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            i13 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        }
        long r52 = ULong.m6501constructorimpl((long) i12);
        long j11 = 0;
        long j12 = 512409557603043100L;
        while (i13 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str2.charAt(i13), i12);
            if (digitOf < 0) {
                return null;
            }
            if (UnsignedKt.ulongCompare(j11, j12) > 0) {
                if (j12 == 512409557603043100L) {
                    j12 = UnsignedKt.m6678ulongDivideeb3DHEI(-1, r52);
                    if (UnsignedKt.ulongCompare(j11, j12) > 0) {
                    }
                }
                return null;
            }
            long r92 = ULong.m6501constructorimpl(j11 * r52);
            long r13 = ULong.m6501constructorimpl(ULong.m6501constructorimpl(((long) UInt.m6423constructorimpl(digitOf)) & 4294967295L) + r92);
            if (UnsignedKt.ulongCompare(r13, r92) < 0) {
                return null;
            }
            i13++;
            j11 = r13;
        }
        return ULong.m6495boximpl(j11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short toUShort(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UShort uShortOrNull = toUShortOrNull(str, i11);
        if (uShortOrNull != null) {
            return uShortOrNull.m6656unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UShort toUShortOrNull(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str, i11);
        if (uIntOrNull == null) {
            return null;
        }
        int r12 = uIntOrNull.m6474unboximpl();
        if (UnsignedKt.uintCompare(r12, UInt.m6423constructorimpl(65535)) > 0) {
            return null;
        }
        return UShort.m6601boximpl(UShort.m6607constructorimpl((short) r12));
    }
}
