package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzet;
import com.google.android.gms.internal.vision.zzew;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzet<MessageType extends zzet<MessageType, BuilderType>, BuilderType extends zzew<MessageType, BuilderType>> implements zzic {
    protected int zzri = 0;

    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzgt.checkNotNull(iterable);
        if (iterable instanceof zzhj) {
            List<?> zzgx = ((zzhj) iterable).zzgx();
            zzhj zzhj = (zzhj) list;
            int size = list.size();
            for (Object next : zzgx) {
                if (next == null) {
                    StringBuilder sb2 = new StringBuilder(37);
                    sb2.append("Element at index ");
                    sb2.append(zzhj.size() - size);
                    sb2.append(" is null.");
                    String sb3 = sb2.toString();
                    for (int size2 = zzhj.size() - 1; size2 >= size; size2--) {
                        zzhj.remove(size2);
                    }
                    throw new NullPointerException(sb3);
                } else if (next instanceof zzfh) {
                    zzhj.zzc((zzfh) next);
                } else {
                    zzhj.add((String) next);
                }
            }
        } else if (iterable instanceof zzio) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    StringBuilder sb4 = new StringBuilder(37);
                    sb4.append("Element at index ");
                    sb4.append(list.size() - size3);
                    sb4.append(" is null.");
                    String sb5 = sb4.toString();
                    for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                        list.remove(size4);
                    }
                    throw new NullPointerException(sb5);
                }
                list.add(next2);
            }
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzgf()];
            zzga zze = zzga.zze(bArr);
            zzb(zze);
            zze.zzfh();
            return bArr;
        } catch (IOException e11) {
            String name2 = getClass().getName();
            StringBuilder sb2 = new StringBuilder(name2.length() + 62 + "byte array".length());
            sb2.append("Serializing ");
            sb2.append(name2);
            sb2.append(" to a ");
            sb2.append("byte array");
            sb2.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e11);
        }
    }

    public void zzad(int i11) {
        throw new UnsupportedOperationException();
    }

    public final zzfh zzdk() {
        try {
            zzfp zzap = zzfh.zzap(zzgf());
            zzb(zzap.zzew());
            return zzap.zzev();
        } catch (IOException e11) {
            String name2 = getClass().getName();
            StringBuilder sb2 = new StringBuilder(name2.length() + 62 + "ByteString".length());
            sb2.append("Serializing ");
            sb2.append(name2);
            sb2.append(" to a ");
            sb2.append("ByteString");
            sb2.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e11);
        }
    }

    public int zzdl() {
        throw new UnsupportedOperationException();
    }
}
