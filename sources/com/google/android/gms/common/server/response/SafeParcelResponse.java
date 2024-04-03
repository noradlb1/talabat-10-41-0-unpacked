package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@KeepForSdk
@SafeParcelable.Class(creator = "SafeParcelResponseCreator")
@VisibleForTesting
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zaq();
    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
    private final int zaa;
    @SafeParcelable.Field(getter = "getParcel", id = 2)
    private final Parcel zab;
    private final int zac;
    @SafeParcelable.Field(getter = "getFieldMappingDictionary", id = 3)
    private final zan zad;
    @Nullable
    private final String zae;
    private int zaf;
    private int zag;

    @SafeParcelable.Constructor
    public SafeParcelResponse(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) Parcel parcel, @SafeParcelable.Param(id = 3) zan zan) {
        this.zaa = i11;
        this.zab = (Parcel) Preconditions.checkNotNull(parcel);
        this.zac = 2;
        this.zad = zan;
        this.zae = zan == null ? null : zan.zaa();
        this.zaf = 2;
    }

    @NonNull
    @KeepForSdk
    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(@NonNull T t11) {
        zan zan = new zan(t11.getClass());
        zaF(zan, t11);
        zan.zac();
        zan.zad();
        return new SafeParcelResponse((SafeParcelable) t11, zan, (String) Preconditions.checkNotNull(t11.getClass().getCanonicalName()));
    }

    private static void zaF(zan zan, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (!zan.zaf(cls)) {
            Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
            zan.zae(cls, fieldMappings);
            for (String str : fieldMappings.keySet()) {
                FastJsonResponse.Field field = fieldMappings.get(str);
                Class cls2 = field.zag;
                if (cls2 != null) {
                    try {
                        zaF(zan, (FastJsonResponse) cls2.newInstance());
                    } catch (InstantiationException e11) {
                        throw new IllegalStateException("Could not instantiate an object of type ".concat(String.valueOf(((Class) Preconditions.checkNotNull(field.zag)).getCanonicalName())), e11);
                    } catch (IllegalAccessException e12) {
                        throw new IllegalStateException("Could not access object of type ".concat(String.valueOf(((Class) Preconditions.checkNotNull(field.zag)).getCanonicalName())), e12);
                    }
                }
            }
        }
    }

    private final void zaG(FastJsonResponse.Field field) {
        if (field.zaf != -1) {
            Parcel parcel = this.zab;
            if (parcel != null) {
                int i11 = this.zaf;
                if (i11 == 0) {
                    this.zag = SafeParcelWriter.beginObjectHeader(parcel);
                    this.zaf = 1;
                } else if (i11 != 1) {
                    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                }
            } else {
                throw new IllegalStateException("Internal Parcel object is null.");
            }
        } else {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
    }

    private final void zaH(StringBuilder sb2, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry.getValue()).getSafeParcelableFieldId(), entry);
        }
        sb2.append(AbstractJsonLexerKt.BEGIN_OBJ);
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z11 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.getFieldId(readHeader));
            if (entry2 != null) {
                if (z11) {
                    sb2.append(",");
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb2.append("\"");
                sb2.append((String) entry2.getKey());
                sb2.append("\":");
                if (field.zaj()) {
                    int i11 = field.zac;
                    switch (i11) {
                        case 0:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, Integer.valueOf(SafeParcelReader.readInt(parcel, readHeader))));
                            break;
                        case 1:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.createBigInteger(parcel, readHeader)));
                            break;
                        case 2:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, Long.valueOf(SafeParcelReader.readLong(parcel, readHeader))));
                            break;
                        case 3:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, Float.valueOf(SafeParcelReader.readFloat(parcel, readHeader))));
                            break;
                        case 4:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, Double.valueOf(SafeParcelReader.readDouble(parcel, readHeader))));
                            break;
                        case 5:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.createBigDecimal(parcel, readHeader)));
                            break;
                        case 6:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, Boolean.valueOf(SafeParcelReader.readBoolean(parcel, readHeader))));
                            break;
                        case 7:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.createString(parcel, readHeader)));
                            break;
                        case 8:
                        case 9:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.createByteArray(parcel, readHeader)));
                            break;
                        case 10:
                            Bundle createBundle = SafeParcelReader.createBundle(parcel, readHeader);
                            HashMap hashMap = new HashMap();
                            for (String next : createBundle.keySet()) {
                                hashMap.put(next, (String) Preconditions.checkNotNull(createBundle.getString(next)));
                            }
                            zaJ(sb2, field, FastJsonResponse.zaD(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + i11);
                    }
                } else if (field.zad) {
                    sb2.append("[");
                    switch (field.zac) {
                        case 0:
                            ArrayUtils.writeArray(sb2, SafeParcelReader.createIntArray(parcel, readHeader));
                            break;
                        case 1:
                            ArrayUtils.writeArray(sb2, (T[]) SafeParcelReader.createBigIntegerArray(parcel, readHeader));
                            break;
                        case 2:
                            ArrayUtils.writeArray(sb2, SafeParcelReader.createLongArray(parcel, readHeader));
                            break;
                        case 3:
                            ArrayUtils.writeArray(sb2, SafeParcelReader.createFloatArray(parcel, readHeader));
                            break;
                        case 4:
                            ArrayUtils.writeArray(sb2, SafeParcelReader.createDoubleArray(parcel, readHeader));
                            break;
                        case 5:
                            ArrayUtils.writeArray(sb2, (T[]) SafeParcelReader.createBigDecimalArray(parcel, readHeader));
                            break;
                        case 6:
                            ArrayUtils.writeArray(sb2, SafeParcelReader.createBooleanArray(parcel, readHeader));
                            break;
                        case 7:
                            ArrayUtils.writeStringArray(sb2, SafeParcelReader.createStringArray(parcel, readHeader));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] createParcelArray = SafeParcelReader.createParcelArray(parcel, readHeader);
                            int length = createParcelArray.length;
                            for (int i12 = 0; i12 < length; i12++) {
                                if (i12 > 0) {
                                    sb2.append(",");
                                }
                                createParcelArray[i12].setDataPosition(0);
                                zaH(sb2, field.zah(), createParcelArray[i12]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb2.append("]");
                } else {
                    switch (field.zac) {
                        case 0:
                            sb2.append(SafeParcelReader.readInt(parcel, readHeader));
                            break;
                        case 1:
                            sb2.append(SafeParcelReader.createBigInteger(parcel, readHeader));
                            break;
                        case 2:
                            sb2.append(SafeParcelReader.readLong(parcel, readHeader));
                            break;
                        case 3:
                            sb2.append(SafeParcelReader.readFloat(parcel, readHeader));
                            break;
                        case 4:
                            sb2.append(SafeParcelReader.readDouble(parcel, readHeader));
                            break;
                        case 5:
                            sb2.append(SafeParcelReader.createBigDecimal(parcel, readHeader));
                            break;
                        case 6:
                            sb2.append(SafeParcelReader.readBoolean(parcel, readHeader));
                            break;
                        case 7:
                            String createString = SafeParcelReader.createString(parcel, readHeader);
                            sb2.append("\"");
                            sb2.append(JsonUtils.escapeString(createString));
                            sb2.append("\"");
                            break;
                        case 8:
                            byte[] createByteArray = SafeParcelReader.createByteArray(parcel, readHeader);
                            sb2.append("\"");
                            sb2.append(Base64Utils.encode(createByteArray));
                            sb2.append("\"");
                            break;
                        case 9:
                            byte[] createByteArray2 = SafeParcelReader.createByteArray(parcel, readHeader);
                            sb2.append("\"");
                            sb2.append(Base64Utils.encodeUrlSafe(createByteArray2));
                            sb2.append("\"");
                            break;
                        case 10:
                            Bundle createBundle2 = SafeParcelReader.createBundle(parcel, readHeader);
                            Set<String> keySet = createBundle2.keySet();
                            sb2.append("{");
                            boolean z12 = true;
                            for (String next2 : keySet) {
                                if (!z12) {
                                    sb2.append(",");
                                }
                                sb2.append("\"");
                                sb2.append(next2);
                                sb2.append("\":\"");
                                sb2.append(JsonUtils.escapeString(createBundle2.getString(next2)));
                                sb2.append("\"");
                                z12 = false;
                            }
                            sb2.append("}");
                            break;
                        case 11:
                            Parcel createParcel = SafeParcelReader.createParcel(parcel, readHeader);
                            createParcel.setDataPosition(0);
                            zaH(sb2, field.zah(), createParcel);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z11 = true;
            }
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            sb2.append(AbstractJsonLexerKt.END_OBJ);
            return;
        }
        throw new SafeParcelReader.ParseException("Overread allowed size end=" + validateObjectHeader, parcel);
    }

    private static final void zaI(StringBuilder sb2, int i11, @Nullable Object obj) {
        switch (i11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb2.append(obj);
                return;
            case 7:
                sb2.append("\"");
                sb2.append(JsonUtils.escapeString(Preconditions.checkNotNull(obj).toString()));
                sb2.append("\"");
                return;
            case 8:
                sb2.append("\"");
                sb2.append(Base64Utils.encode((byte[]) obj));
                sb2.append("\"");
                return;
            case 9:
                sb2.append("\"");
                sb2.append(Base64Utils.encodeUrlSafe((byte[]) obj));
                sb2.append("\"");
                return;
            case 10:
                MapUtils.writeStringMapToJson(sb2, (HashMap) Preconditions.checkNotNull(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i11);
        }
    }

    private static final void zaJ(StringBuilder sb2, FastJsonResponse.Field field, Object obj) {
        if (field.zab) {
            ArrayList arrayList = (ArrayList) obj;
            sb2.append("[");
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (i11 != 0) {
                    sb2.append(",");
                }
                zaI(sb2, field.zaa, arrayList.get(i11));
            }
            sb2.append("]");
            return;
        }
        zaI(sb2, field.zaa, obj);
    }

    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList<T> arrayList) {
        zaG(field);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList2.add(((SafeParcelResponse) ((FastJsonResponse) arrayList.get(i11))).zaE());
        }
        SafeParcelWriter.writeParcelList(this.zab, field.getSafeParcelableFieldId(), arrayList2, true);
    }

    public final <T extends FastJsonResponse> void addConcreteTypeInternal(@NonNull FastJsonResponse.Field field, @NonNull String str, @NonNull T t11) {
        zaG(field);
        SafeParcelWriter.writeParcel(this.zab, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t11).zaE(), true);
    }

    @Nullable
    public final Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zan zan = this.zad;
        if (zan == null) {
            return null;
        }
        return zan.zab((String) Preconditions.checkNotNull(this.zae));
    }

    @NonNull
    public final Object getValueObject(@NonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final boolean isPrimitiveFieldSet(@NonNull String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final void setBooleanInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, boolean z11) {
        zaG(field);
        SafeParcelWriter.writeBoolean(this.zab, field.getSafeParcelableFieldId(), z11);
    }

    public final void setDecodedBytesInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable byte[] bArr) {
        zaG(field);
        SafeParcelWriter.writeByteArray(this.zab, field.getSafeParcelableFieldId(), bArr, true);
    }

    public final void setIntegerInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, int i11) {
        zaG(field);
        SafeParcelWriter.writeInt(this.zab, field.getSafeParcelableFieldId(), i11);
    }

    public final void setLongInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, long j11) {
        zaG(field);
        SafeParcelWriter.writeLong(this.zab, field.getSafeParcelableFieldId(), j11);
    }

    public final void setStringInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable String str2) {
        zaG(field);
        SafeParcelWriter.writeString(this.zab, field.getSafeParcelableFieldId(), str2, true);
    }

    public final void setStringMapInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable Map<String, String> map) {
        zaG(field);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) Preconditions.checkNotNull(map)).keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        SafeParcelWriter.writeBundle(this.zab, field.getSafeParcelableFieldId(), bundle, true);
    }

    public final void setStringsInternal(@NonNull FastJsonResponse.Field<?, ?> field, @NonNull String str, @Nullable ArrayList<String> arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        String[] strArr = new String[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = arrayList.get(i11);
        }
        SafeParcelWriter.writeStringArray(this.zab, field.getSafeParcelableFieldId(), strArr, true);
    }

    @NonNull
    public final String toString() {
        Preconditions.checkNotNull(this.zad, "Cannot convert to JSON on client side.");
        Parcel zaE = zaE();
        zaE.setDataPosition(0);
        StringBuilder sb2 = new StringBuilder(100);
        zaH(sb2, (Map) Preconditions.checkNotNull(this.zad.zab((String) Preconditions.checkNotNull(this.zae))), zaE);
        return sb2.toString();
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i11) {
        zan zan;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeParcel(parcel, 2, zaE(), false);
        int i12 = this.zac;
        if (i12 == 0) {
            zan = null;
        } else if (i12 != 1) {
            zan = this.zad;
        } else {
            zan = this.zad;
        }
        SafeParcelWriter.writeParcelable(parcel, 3, zan, i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final Parcel zaE() {
        int i11 = this.zaf;
        if (i11 == 0) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(this.zab);
            this.zag = beginObjectHeader;
            SafeParcelWriter.finishObjectHeader(this.zab, beginObjectHeader);
            this.zaf = 2;
        } else if (i11 == 1) {
            SafeParcelWriter.finishObjectHeader(this.zab, this.zag);
            this.zaf = 2;
        }
        return this.zab;
    }

    public final void zab(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable BigDecimal bigDecimal) {
        zaG(field);
        SafeParcelWriter.writeBigDecimal(this.zab, field.getSafeParcelableFieldId(), bigDecimal, true);
    }

    public final void zad(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i11 = 0; i11 < size; i11++) {
            bigDecimalArr[i11] = (BigDecimal) arrayList.get(i11);
        }
        SafeParcelWriter.writeBigDecimalArray(this.zab, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    public final void zaf(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable BigInteger bigInteger) {
        zaG(field);
        SafeParcelWriter.writeBigInteger(this.zab, field.getSafeParcelableFieldId(), bigInteger, true);
    }

    public final void zah(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i11 = 0; i11 < size; i11++) {
            bigIntegerArr[i11] = (BigInteger) arrayList.get(i11);
        }
        SafeParcelWriter.writeBigIntegerArray(this.zab, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    public final void zak(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i11 = 0; i11 < size; i11++) {
            zArr[i11] = ((Boolean) arrayList.get(i11)).booleanValue();
        }
        SafeParcelWriter.writeBooleanArray(this.zab, field.getSafeParcelableFieldId(), zArr, true);
    }

    public final void zan(@NonNull FastJsonResponse.Field field, @NonNull String str, double d11) {
        zaG(field);
        SafeParcelWriter.writeDouble(this.zab, field.getSafeParcelableFieldId(), d11);
    }

    public final void zap(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        double[] dArr = new double[size];
        for (int i11 = 0; i11 < size; i11++) {
            dArr[i11] = ((Double) arrayList.get(i11)).doubleValue();
        }
        SafeParcelWriter.writeDoubleArray(this.zab, field.getSafeParcelableFieldId(), dArr, true);
    }

    public final void zar(@NonNull FastJsonResponse.Field field, @NonNull String str, float f11) {
        zaG(field);
        SafeParcelWriter.writeFloat(this.zab, field.getSafeParcelableFieldId(), f11);
    }

    public final void zat(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        float[] fArr = new float[size];
        for (int i11 = 0; i11 < size; i11++) {
            fArr[i11] = ((Float) arrayList.get(i11)).floatValue();
        }
        SafeParcelWriter.writeFloatArray(this.zab, field.getSafeParcelableFieldId(), fArr, true);
    }

    public final void zaw(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        int[] iArr = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        SafeParcelWriter.writeIntArray(this.zab, field.getSafeParcelableFieldId(), iArr, true);
    }

    public final void zaz(@NonNull FastJsonResponse.Field field, @NonNull String str, @Nullable ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) Preconditions.checkNotNull(arrayList)).size();
        long[] jArr = new long[size];
        for (int i11 = 0; i11 < size; i11++) {
            jArr[i11] = ((Long) arrayList.get(i11)).longValue();
        }
        SafeParcelWriter.writeLongArray(this.zab, field.getSafeParcelableFieldId(), jArr, true);
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, zan zan, String str) {
        this.zaa = 1;
        Parcel obtain = Parcel.obtain();
        this.zab = obtain;
        safeParcelable.writeToParcel(obtain, 0);
        this.zac = 1;
        this.zad = (zan) Preconditions.checkNotNull(zan);
        this.zae = (String) Preconditions.checkNotNull(str);
        this.zaf = 2;
    }

    public SafeParcelResponse(zan zan, String str) {
        this.zaa = 1;
        this.zab = Parcel.obtain();
        this.zac = 0;
        this.zad = (zan) Preconditions.checkNotNull(zan);
        this.zae = (String) Preconditions.checkNotNull(str);
        this.zaf = 0;
    }
}
