package com.google.firebase.appindexing.builders;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.IndexableBuilder;
import com.google.firebase.appindexing.internal.Thing;
import com.google.firebase.appindexing.internal.zzac;
import com.google.firebase.appindexing.internal.zzw;
import java.util.Arrays;

public abstract class IndexableBuilder<T extends IndexableBuilder<?>> {
    private final Bundle zza = new Bundle();
    private final String zzb;
    private zzac zzc;
    private String zzd;

    public IndexableBuilder(@NonNull String str) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
    }

    public static void zza(@NonNull Bundle bundle, @NonNull String str, @NonNull String... strArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(strArr);
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        if (strArr2.length > 0) {
            int i11 = 0;
            for (int i12 = 0; i12 < Math.min(strArr2.length, 100); i12++) {
                String str2 = strArr2[i12];
                strArr2[i11] = str2;
                if (strArr2[i12] == null) {
                    StringBuilder sb2 = new StringBuilder(59);
                    sb2.append("String at ");
                    sb2.append(i12);
                    sb2.append(" is null and is ignored by put method.");
                    zzw.zza(sb2.toString());
                } else {
                    int i13 = 20000;
                    if (str2.length() > 20000) {
                        StringBuilder sb3 = new StringBuilder(53);
                        sb3.append("String at ");
                        sb3.append(i12);
                        sb3.append(" is too long, truncating string.");
                        zzw.zza(sb3.toString());
                        String str3 = strArr2[i11];
                        if (str3.length() > 20000) {
                            if (Character.isHighSurrogate(str3.charAt(19999)) && Character.isLowSurrogate(str3.charAt(20000))) {
                                i13 = 19999;
                            }
                            str3 = str3.substring(0, i13);
                        }
                        strArr2[i11] = str3;
                    }
                    i11++;
                }
            }
            if (i11 > 0) {
                bundle.putStringArray(str, (String[]) zzf((String[]) Arrays.copyOfRange(strArr2, 0, i11)));
                return;
            }
            return;
        }
        zzw.zza("String array is empty and is ignored by put method.");
    }

    public static void zzb(@NonNull Bundle bundle, @NonNull String str, @NonNull Indexable... indexableArr) throws FirebaseAppIndexingInvalidArgumentException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(indexableArr);
        Thing[] thingArr = new Thing[indexableArr.length];
        int i11 = 0;
        while (i11 < indexableArr.length) {
            Thing thing = indexableArr[i11];
            if (thing == null || (thing instanceof Thing)) {
                thingArr[i11] = thing;
                i11++;
            } else {
                throw new FirebaseAppIndexingInvalidArgumentException("Invalid Indexable encountered. Use Indexable.Builder or convenience methods under Indexables to create the Indexable.");
            }
        }
        zze(bundle, str, thingArr);
    }

    public static void zzc(@NonNull Bundle bundle, @NonNull String str, @NonNull boolean... zArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zArr);
        int length = zArr.length;
        if (length > 0) {
            if (length >= 100) {
                zzw.zza("Input Array of elements is too big, cutting off.");
                zArr = Arrays.copyOf(zArr, 100);
            }
            bundle.putBooleanArray(str, zArr);
            return;
        }
        zzw.zza("Boolean array is empty and is ignored by put method.");
    }

    public static void zzd(@NonNull Bundle bundle, @NonNull String str, @NonNull long... jArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(jArr);
        int length = jArr.length;
        if (length > 0) {
            if (length >= 100) {
                zzw.zza("Input Array of elements is too big, cutting off.");
                jArr = Arrays.copyOf(jArr, 100);
            }
            bundle.putLongArray(str, jArr);
            return;
        }
        zzw.zza("Long array is empty and is ignored by put method.");
    }

    private static void zze(@NonNull Bundle bundle, @NonNull String str, @NonNull Thing... thingArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(thingArr);
        if (thingArr.length > 0) {
            int i11 = 0;
            for (int i12 = 0; i12 < thingArr.length; i12++) {
                thingArr[i11] = thingArr[i12];
                if (thingArr[i12] == null) {
                    StringBuilder sb2 = new StringBuilder(58);
                    sb2.append("Thing at ");
                    sb2.append(i12);
                    sb2.append(" is null and is ignored by put method.");
                    zzw.zza(sb2.toString());
                } else {
                    i11++;
                }
            }
            if (i11 > 0) {
                bundle.putParcelableArray(str, (Parcelable[]) zzf((Thing[]) Arrays.copyOfRange(thingArr, 0, i11)));
                return;
            }
            return;
        }
        zzw.zza("Thing array is empty and is ignored by put method.");
    }

    private static <S> S[] zzf(S[] sArr) {
        if (sArr.length < 100) {
            return sArr;
        }
        zzw.zza("Input Array of elements is too big, cutting off.");
        return Arrays.copyOf(sArr, 100);
    }

    @NonNull
    public final Indexable build() {
        Bundle bundle = new Bundle(this.zza);
        zzac zzac = this.zzc;
        if (zzac == null) {
            zzac = new Indexable.Metadata.Builder().zza();
        }
        return new Thing(bundle, zzac, this.zzd, this.zzb);
    }

    @NonNull
    public T put(@NonNull String str, @NonNull long... jArr) {
        zzd(this.zza, str, jArr);
        return this;
    }

    @NonNull
    public T setAlternateName(@NonNull String... strArr) {
        Preconditions.checkNotNull(strArr);
        return put("alternateName", strArr);
    }

    @NonNull
    public final T setDescription(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return put("description", str);
    }

    @NonNull
    public T setId(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return put("id", str);
    }

    @NonNull
    public final T setImage(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return put("image", str);
    }

    @NonNull
    public final <S extends IndexableBuilder> T setIsPartOf(@NonNull S... sArr) {
        Preconditions.checkNotNull(sArr);
        return put("isPartOf", sArr);
    }

    @NonNull
    public final T setKeywords(@NonNull String... strArr) {
        return put("keywords", strArr);
    }

    @NonNull
    public T setMetadata(@NonNull Indexable.Metadata.Builder builder) {
        boolean z11;
        if (this.zzc == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "setMetadata may only be called once");
        Preconditions.checkNotNull(builder);
        this.zzc = builder.zza();
        return this;
    }

    @NonNull
    public final T setName(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return put("name", str);
    }

    @NonNull
    public final T setSameAs(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return put("sameAs", str);
    }

    @NonNull
    public final T setUrl(@NonNull String str) {
        Preconditions.checkNotNull(str);
        this.zzd = str;
        return this;
    }

    @NonNull
    public T put(@NonNull String str, @NonNull Indexable... indexableArr) throws FirebaseAppIndexingInvalidArgumentException {
        zzb(this.zza, str, indexableArr);
        return this;
    }

    @NonNull
    public <S extends IndexableBuilder> T put(@NonNull String str, @NonNull S... sArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(sArr);
        int length = sArr.length;
        if (length > 0) {
            Thing[] thingArr = new Thing[length];
            for (int i11 = 0; i11 < sArr.length; i11++) {
                S s11 = sArr[i11];
                if (s11 == null) {
                    StringBuilder sb2 = new StringBuilder(60);
                    sb2.append("Builder at ");
                    sb2.append(i11);
                    sb2.append(" is null and is ignored by put method.");
                    zzw.zza(sb2.toString());
                } else {
                    thingArr[i11] = (Thing) s11.build();
                }
            }
            zze(this.zza, str, thingArr);
        } else {
            zzw.zza("Builder array is empty and is ignored by put method.");
        }
        return this;
    }

    @NonNull
    public T put(@NonNull String str, @NonNull String... strArr) {
        zza(this.zza, str, strArr);
        return this;
    }

    @NonNull
    public T put(@NonNull String str, @NonNull boolean... zArr) {
        zzc(this.zza, str, zArr);
        return this;
    }
}
