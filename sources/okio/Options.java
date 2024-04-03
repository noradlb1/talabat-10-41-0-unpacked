package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final ByteString[] byteStrings;
    @NotNull
    private final int[] trie;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void buildTrieRecursive(long j11, Buffer buffer, int i11, List<? extends ByteString> list, int i12, int i13, List<Integer> list2) {
            boolean z11;
            int i14;
            int i15;
            int i16;
            boolean z12;
            int i17;
            int i18;
            Buffer buffer2;
            boolean z13;
            Buffer buffer3 = buffer;
            int i19 = i11;
            List<? extends ByteString> list3 = list;
            int i21 = i12;
            int i22 = i13;
            List<Integer> list4 = list2;
            if (i21 < i22) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i21 < i22) {
                    int i23 = i21;
                    while (true) {
                        int i24 = i23 + 1;
                        if (((ByteString) list3.get(i23)).size() >= i19) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (!z13) {
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        } else if (i24 >= i22) {
                            break;
                        } else {
                            i23 = i24;
                        }
                    }
                }
                ByteString byteString = (ByteString) list.get(i12);
                ByteString byteString2 = (ByteString) list3.get(i22 - 1);
                int i25 = -1;
                if (i19 == byteString.size()) {
                    int intValue = list4.get(i21).intValue();
                    int i26 = i21 + 1;
                    i14 = i26;
                    i15 = intValue;
                    byteString = (ByteString) list3.get(i26);
                } else {
                    i14 = i21;
                    i15 = -1;
                }
                if (byteString.getByte(i19) != byteString2.getByte(i19)) {
                    int i27 = i14 + 1;
                    int i28 = 1;
                    if (i27 < i22) {
                        while (true) {
                            int i29 = i27 + 1;
                            if (((ByteString) list3.get(i27 - 1)).getByte(i19) != ((ByteString) list3.get(i27)).getByte(i19)) {
                                i28++;
                            }
                            if (i29 >= i22) {
                                break;
                            }
                            i27 = i29;
                        }
                    }
                    long intCount = j11 + getIntCount(buffer3) + ((long) 2) + ((long) (i28 * 2));
                    buffer3.writeInt(i28);
                    buffer3.writeInt(i15);
                    if (i14 < i22) {
                        int i31 = i14;
                        while (true) {
                            int i32 = i31 + 1;
                            byte b11 = ((ByteString) list3.get(i31)).getByte(i19);
                            if (i31 == i14 || b11 != ((ByteString) list3.get(i31 - 1)).getByte(i19)) {
                                buffer3.writeInt((int) b11 & 255);
                            }
                            if (i32 >= i22) {
                                break;
                            }
                            i31 = i32;
                        }
                    }
                    Buffer buffer4 = new Buffer();
                    while (i14 < i22) {
                        byte b12 = ((ByteString) list3.get(i14)).getByte(i19);
                        int i33 = i14 + 1;
                        if (i33 < i22) {
                            int i34 = i33;
                            while (true) {
                                int i35 = i34 + 1;
                                if (b12 != ((ByteString) list3.get(i34)).getByte(i19)) {
                                    i17 = i34;
                                    break;
                                } else if (i35 >= i22) {
                                    break;
                                } else {
                                    i34 = i35;
                                }
                            }
                        }
                        i17 = i22;
                        if (i33 == i17 && i19 + 1 == ((ByteString) list3.get(i14)).size()) {
                            buffer3.writeInt(list4.get(i14).intValue());
                            i18 = i17;
                            buffer2 = buffer4;
                        } else {
                            buffer3.writeInt(((int) (intCount + getIntCount(buffer4))) * i25);
                            i18 = i17;
                            buffer2 = buffer4;
                            buildTrieRecursive(intCount, buffer4, i19 + 1, list, i14, i17, list2);
                        }
                        buffer4 = buffer2;
                        i14 = i18;
                        i25 = -1;
                    }
                    buffer3.writeAll(buffer4);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                if (i19 < min) {
                    int i36 = i19;
                    i16 = 0;
                    while (true) {
                        int i37 = i36 + 1;
                        if (byteString.getByte(i36) != byteString2.getByte(i36)) {
                            break;
                        }
                        i16++;
                        if (i37 >= min) {
                            break;
                        }
                        i36 = i37;
                    }
                } else {
                    i16 = 0;
                }
                long intCount2 = j11 + getIntCount(buffer3) + ((long) 2) + ((long) i16) + 1;
                buffer3.writeInt(-i16);
                buffer3.writeInt(i15);
                int i38 = i19 + i16;
                if (i19 < i38) {
                    while (true) {
                        int i39 = i19 + 1;
                        buffer3.writeInt((int) byteString.getByte(i19) & 255);
                        if (i39 >= i38) {
                            break;
                        }
                        i19 = i39;
                    }
                }
                if (i14 + 1 == i22) {
                    if (i38 == ((ByteString) list3.get(i14)).size()) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        buffer3.writeInt(list4.get(i14).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer5 = new Buffer();
                buffer3.writeInt(((int) (getIntCount(buffer5) + intCount2)) * -1);
                buildTrieRecursive(intCount2, buffer5, i38, list, i14, i13, list2);
                buffer3.writeAll(buffer5);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j11, Buffer buffer, int i11, List list, int i12, int i13, List list2, int i14, Object obj) {
            long j12;
            int i15;
            int i16;
            int i17;
            if ((i14 & 1) != 0) {
                j12 = 0;
            } else {
                j12 = j11;
            }
            if ((i14 & 4) != 0) {
                i15 = 0;
            } else {
                i15 = i11;
            }
            if ((i14 & 16) != 0) {
                i16 = 0;
            } else {
                i16 = i12;
            }
            if ((i14 & 32) != 0) {
                i17 = list.size();
            } else {
                i17 = i13;
            }
            companion.buildTrieRecursive(j12, buffer, i15, list, i16, i17, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }

        @JvmStatic
        @NotNull
        public final Options of(@NotNull ByteString... byteStringArr) {
            boolean z11;
            boolean z12;
            boolean z13;
            ByteString[] byteStringArr2 = byteStringArr;
            Intrinsics.checkNotNullParameter(byteStringArr2, "byteStrings");
            int i11 = 0;
            if (byteStringArr2.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return new Options(new ByteString[0], new int[]{0, -1}, (DefaultConstructorMarker) null);
            }
            List mutableList = ArraysKt___ArraysKt.toMutableList((T[]) byteStringArr);
            CollectionsKt__MutableCollectionsJVMKt.sort(mutableList);
            ArrayList arrayList = new ArrayList(byteStringArr2.length);
            for (ByteString byteString : byteStringArr2) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array != null) {
                Integer[] numArr = (Integer[]) array;
                List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Arrays.copyOf(numArr, numArr.length));
                int length = byteStringArr2.length;
                int i12 = 0;
                int i13 = 0;
                while (i12 < length) {
                    mutableListOf.set(CollectionsKt__CollectionsKt.binarySearch$default(mutableList, (Comparable) byteStringArr2[i12], 0, 0, 6, (Object) null), Integer.valueOf(i13));
                    i12++;
                    i13++;
                }
                if (((ByteString) mutableList.get(0)).size() > 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    int i14 = 0;
                    while (i14 < mutableList.size()) {
                        ByteString byteString2 = (ByteString) mutableList.get(i14);
                        int i15 = i14 + 1;
                        int i16 = i15;
                        while (i16 < mutableList.size()) {
                            ByteString byteString3 = (ByteString) mutableList.get(i16);
                            if (!byteString3.startsWith(byteString2)) {
                                continue;
                                break;
                            }
                            if (byteString3.size() != byteString2.size()) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            if (!z13) {
                                throw new IllegalArgumentException(Intrinsics.stringPlus("duplicate option: ", byteString3).toString());
                            } else if (((Number) mutableListOf.get(i16)).intValue() > ((Number) mutableListOf.get(i14)).intValue()) {
                                mutableList.remove(i16);
                                mutableListOf.remove(i16);
                            } else {
                                i16++;
                            }
                        }
                        i14 = i15;
                    }
                    Buffer buffer = new Buffer();
                    buildTrieRecursive$default(this, 0, buffer, 0, mutableList, 0, 0, mutableListOf, 53, (Object) null);
                    int[] iArr = new int[((int) getIntCount(buffer))];
                    while (!buffer.exhausted()) {
                        iArr[i11] = buffer.readInt();
                        i11++;
                    }
                    Object[] copyOf = Arrays.copyOf(byteStringArr2, byteStringArr2.length);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                    return new Options((ByteString[]) copyOf, iArr, (DefaultConstructorMarker) null);
                }
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    @NotNull
    public static final Options of(@NotNull ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ByteString)) {
            return false;
        }
        return contains((ByteString) obj);
    }

    @NotNull
    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    public int getSize() {
        return this.byteStrings.length;
    }

    @NotNull
    public final int[] getTrie$okio() {
        return this.trie;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return indexOf((ByteString) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return lastIndexOf((ByteString) obj);
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains(byteString);
    }

    @NotNull
    public ByteString get(int i11) {
        return this.byteStrings[i11];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf(byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }
}
