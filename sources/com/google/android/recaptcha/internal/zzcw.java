package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

public final class zzcw implements zzca {
    @NotNull
    public static final zzcw zza = new zzcw();

    private zzcw() {
    }

    public final void zza(int i11, @NotNull zzbh zzbh, @NotNull zznl... zznlArr) throws zzs {
        if (zznlArr.length == 2) {
            Object zza2 = zzbh.zze().zza(zznlArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                Object zza3 = zzbh.zze().zza(zznlArr[1]);
                if (true != (zza3 instanceof Object)) {
                    zza3 = null;
                }
                if (zza3 != null) {
                    zzbh.zze().zzf(i11, zzb(zza2, zza3));
                    return;
                }
                throw new zzs(4, 5, (Throwable) null);
            }
            throw new zzs(4, 5, (Throwable) null);
        }
        throw new zzs(4, 3, (Throwable) null);
    }

    @NotNull
    public final Object zzb(@NotNull Object obj, @NotNull Object obj2) throws zzs {
        boolean z11 = obj instanceof Byte;
        if (z11 && (obj2 instanceof Byte)) {
            return Byte.valueOf((byte) (((Number) obj).byteValue() ^ ((Number) obj2).byteValue()));
        }
        boolean z12 = obj instanceof Short;
        if (z12 && (obj2 instanceof Short)) {
            return Short.valueOf((short) (((Number) obj).shortValue() ^ ((Number) obj2).shortValue()));
        }
        boolean z13 = obj instanceof Integer;
        if (z13 && (obj2 instanceof Integer)) {
            return Integer.valueOf(((Number) obj).intValue() ^ ((Number) obj2).intValue());
        }
        boolean z14 = obj instanceof Long;
        if (!z14 || !(obj2 instanceof Long)) {
            int i11 = 0;
            if (obj instanceof String) {
                if (obj2 instanceof Byte) {
                    byte[] bytes = ((String) obj).getBytes(Charsets.UTF_8);
                    int length = bytes.length;
                    ArrayList arrayList = new ArrayList(length);
                    while (i11 < length) {
                        arrayList.add(Byte.valueOf((byte) (bytes[i11] ^ ((Number) obj2).byteValue())));
                        i11++;
                    }
                    return CollectionsKt___CollectionsKt.toByteArray(arrayList);
                } else if (obj2 instanceof Integer) {
                    char[] charArray = ((String) obj).toCharArray();
                    int length2 = charArray.length;
                    ArrayList arrayList2 = new ArrayList(length2);
                    while (i11 < length2) {
                        arrayList2.add(Integer.valueOf(charArray[i11] ^ ((Number) obj2).intValue()));
                        i11++;
                    }
                    return CollectionsKt___CollectionsKt.toIntArray(arrayList2);
                }
            }
            if (z11 && (obj2 instanceof byte[])) {
                ArrayList arrayList3 = new ArrayList(r0);
                for (byte byteValue : (byte[]) obj2) {
                    arrayList3.add(Byte.valueOf((byte) (byteValue ^ ((Number) obj).byteValue())));
                }
                return arrayList3.toArray(new Byte[0]);
            } else if (z12 && (obj2 instanceof short[])) {
                ArrayList arrayList4 = new ArrayList(r0);
                for (short shortValue : (short[]) obj2) {
                    arrayList4.add(Short.valueOf((short) (shortValue ^ ((Number) obj).shortValue())));
                }
                return arrayList4.toArray(new Short[0]);
            } else if (z13 && (obj2 instanceof int[])) {
                ArrayList arrayList5 = new ArrayList(r0);
                for (int intValue : (int[]) obj2) {
                    arrayList5.add(Integer.valueOf(intValue ^ ((Number) obj).intValue()));
                }
                return arrayList5.toArray(new Integer[0]);
            } else if (!z14 || !(obj2 instanceof long[])) {
                boolean z15 = obj instanceof byte[];
                if (!z15 || !(obj2 instanceof Byte)) {
                    boolean z16 = obj instanceof short[];
                    if (!z16 || !(obj2 instanceof Short)) {
                        boolean z17 = obj instanceof int[];
                        if (!z17 || !(obj2 instanceof Integer)) {
                            boolean z18 = obj instanceof long[];
                            if (z18 && (obj2 instanceof Long)) {
                                ArrayList arrayList6 = new ArrayList(r0);
                                for (long longValue : (long[]) obj) {
                                    arrayList6.add(Long.valueOf(longValue ^ ((Number) obj2).longValue()));
                                }
                                return arrayList6.toArray(new Long[0]);
                            } else if (z15 && (obj2 instanceof byte[])) {
                                byte[] bArr = (byte[]) obj;
                                int length3 = bArr.length;
                                byte[] bArr2 = (byte[]) obj2;
                                zzbz.zzb(this, length3, bArr2.length);
                                IntRange until = RangesKt___RangesKt.until(0, length3);
                                ArrayList arrayList7 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10));
                                Iterator it = until.iterator();
                                while (it.hasNext()) {
                                    int nextInt = ((IntIterator) it).nextInt();
                                    arrayList7.add(Byte.valueOf((byte) (bArr2[nextInt] ^ bArr[nextInt])));
                                }
                                return arrayList7.toArray(new Byte[0]);
                            } else if (z16 && (obj2 instanceof short[])) {
                                short[] sArr = (short[]) obj;
                                int length4 = sArr.length;
                                short[] sArr2 = (short[]) obj2;
                                zzbz.zzb(this, length4, sArr2.length);
                                IntRange until2 = RangesKt___RangesKt.until(0, length4);
                                ArrayList arrayList8 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until2, 10));
                                Iterator it2 = until2.iterator();
                                while (it2.hasNext()) {
                                    int nextInt2 = ((IntIterator) it2).nextInt();
                                    arrayList8.add(Short.valueOf((short) (sArr2[nextInt2] ^ sArr[nextInt2])));
                                }
                                return arrayList8.toArray(new Short[0]);
                            } else if (z17 && (obj2 instanceof int[])) {
                                int[] iArr = (int[]) obj;
                                int length5 = iArr.length;
                                int[] iArr2 = (int[]) obj2;
                                zzbz.zzb(this, length5, iArr2.length);
                                IntRange until3 = RangesKt___RangesKt.until(0, length5);
                                ArrayList arrayList9 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until3, 10));
                                Iterator it3 = until3.iterator();
                                while (it3.hasNext()) {
                                    int nextInt3 = ((IntIterator) it3).nextInt();
                                    arrayList9.add(Integer.valueOf(iArr2[nextInt3] ^ iArr[nextInt3]));
                                }
                                return arrayList9.toArray(new Integer[0]);
                            } else if (!z18 || !(obj2 instanceof long[])) {
                                throw new zzs(4, 5, (Throwable) null);
                            } else {
                                long[] jArr = (long[]) obj;
                                int length6 = jArr.length;
                                long[] jArr2 = (long[]) obj2;
                                zzbz.zzb(this, length6, jArr2.length);
                                IntRange until4 = RangesKt___RangesKt.until(0, length6);
                                ArrayList arrayList10 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until4, 10));
                                Iterator it4 = until4.iterator();
                                while (it4.hasNext()) {
                                    int nextInt4 = ((IntIterator) it4).nextInt();
                                    arrayList10.add(Long.valueOf(jArr[nextInt4] ^ jArr2[nextInt4]));
                                }
                                return arrayList10.toArray(new Long[0]);
                            }
                        } else {
                            ArrayList arrayList11 = new ArrayList(r0);
                            for (int intValue2 : (int[]) obj) {
                                arrayList11.add(Integer.valueOf(intValue2 ^ ((Number) obj2).intValue()));
                            }
                            return arrayList11.toArray(new Integer[0]);
                        }
                    } else {
                        ArrayList arrayList12 = new ArrayList(r0);
                        for (short shortValue2 : (short[]) obj) {
                            arrayList12.add(Short.valueOf((short) (shortValue2 ^ ((Number) obj2).shortValue())));
                        }
                        return arrayList12.toArray(new Short[0]);
                    }
                } else {
                    ArrayList arrayList13 = new ArrayList(r0);
                    for (byte byteValue2 : (byte[]) obj) {
                        arrayList13.add(Byte.valueOf((byte) (byteValue2 ^ ((Number) obj2).byteValue())));
                    }
                    return arrayList13.toArray(new Byte[0]);
                }
            } else {
                ArrayList arrayList14 = new ArrayList(r0);
                for (long longValue2 : (long[]) obj2) {
                    arrayList14.add(Long.valueOf(longValue2 ^ ((Number) obj).longValue()));
                }
                return arrayList14.toArray(new Long[0]);
            }
        } else {
            return Long.valueOf(((Number) obj2).longValue() ^ ((Number) obj).longValue());
        }
    }
}
