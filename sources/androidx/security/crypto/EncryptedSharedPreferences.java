package androidx.security.crypto;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTemplates;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import com.google.crypto.tink.subtle.Base64;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class EncryptedSharedPreferences implements SharedPreferences {
    private static final String KEY_KEYSET_ALIAS = "__androidx_security_crypto_encrypted_prefs_key_keyset__";
    private static final String NULL_VALUE = "__NULL__";
    private static final String VALUE_KEYSET_ALIAS = "__androidx_security_crypto_encrypted_prefs_value_keyset__";

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f37571a;

    /* renamed from: b  reason: collision with root package name */
    public final CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> f37572b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f37573c;

    /* renamed from: d  reason: collision with root package name */
    public final String f37574d;

    /* renamed from: e  reason: collision with root package name */
    public final Aead f37575e;

    /* renamed from: f  reason: collision with root package name */
    public final DeterministicAead f37576f;

    /* renamed from: androidx.security.crypto.EncryptedSharedPreferences$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37577a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType[] r0 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f37577a = r0
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f37577a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.INT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f37577a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.LONG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f37577a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f37577a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f37577a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.security.crypto.EncryptedSharedPreferences$EncryptedType r1 = androidx.security.crypto.EncryptedSharedPreferences.EncryptedType.STRING_SET     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.security.crypto.EncryptedSharedPreferences.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Editor implements SharedPreferences.Editor {
        private AtomicBoolean mClearRequested = new AtomicBoolean(false);
        private final SharedPreferences.Editor mEditor;
        private final EncryptedSharedPreferences mEncryptedSharedPreferences;
        private final List<String> mKeysChanged;

        public Editor(EncryptedSharedPreferences encryptedSharedPreferences, SharedPreferences.Editor editor) {
            this.mEncryptedSharedPreferences = encryptedSharedPreferences;
            this.mEditor = editor;
            this.mKeysChanged = new CopyOnWriteArrayList();
        }

        private void clearKeysIfNeeded() {
            if (this.mClearRequested.getAndSet(false)) {
                for (String next : this.mEncryptedSharedPreferences.getAll().keySet()) {
                    if (!this.mKeysChanged.contains(next) && !this.mEncryptedSharedPreferences.d(next)) {
                        this.mEditor.remove(this.mEncryptedSharedPreferences.b(next));
                    }
                }
            }
        }

        private void notifyListeners() {
            Iterator<SharedPreferences.OnSharedPreferenceChangeListener> it = this.mEncryptedSharedPreferences.f37572b.iterator();
            while (it.hasNext()) {
                SharedPreferences.OnSharedPreferenceChangeListener next = it.next();
                for (String onSharedPreferenceChanged : this.mKeysChanged) {
                    next.onSharedPreferenceChanged(this.mEncryptedSharedPreferences, onSharedPreferenceChanged);
                }
            }
        }

        private void putEncryptedObject(String str, byte[] bArr) {
            if (!this.mEncryptedSharedPreferences.d(str)) {
                this.mKeysChanged.add(str);
                if (str == null) {
                    str = EncryptedSharedPreferences.NULL_VALUE;
                }
                try {
                    Pair<String, String> c11 = this.mEncryptedSharedPreferences.c(str, bArr);
                    this.mEditor.putString((String) c11.first, (String) c11.second);
                } catch (GeneralSecurityException e11) {
                    throw new SecurityException("Could not encrypt data: " + e11.getMessage(), e11);
                }
            } else {
                throw new SecurityException(str + " is a reserved key for the encryption keyset.");
            }
        }

        public void apply() {
            clearKeysIfNeeded();
            this.mEditor.apply();
            notifyListeners();
            this.mKeysChanged.clear();
        }

        @NonNull
        public SharedPreferences.Editor clear() {
            this.mClearRequested.set(true);
            return this;
        }

        public boolean commit() {
            clearKeysIfNeeded();
            try {
                return this.mEditor.commit();
            } finally {
                notifyListeners();
                this.mKeysChanged.clear();
            }
        }

        @NonNull
        public SharedPreferences.Editor putBoolean(@Nullable String str, boolean z11) {
            ByteBuffer allocate = ByteBuffer.allocate(5);
            allocate.putInt(EncryptedType.BOOLEAN.getId());
            allocate.put(z11 ? (byte) 1 : 0);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        @NonNull
        public SharedPreferences.Editor putFloat(@Nullable String str, float f11) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.FLOAT.getId());
            allocate.putFloat(f11);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        @NonNull
        public SharedPreferences.Editor putInt(@Nullable String str, int i11) {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(EncryptedType.INT.getId());
            allocate.putInt(i11);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        @NonNull
        public SharedPreferences.Editor putLong(@Nullable String str, long j11) {
            ByteBuffer allocate = ByteBuffer.allocate(12);
            allocate.putInt(EncryptedType.LONG.getId());
            allocate.putLong(j11);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        @NonNull
        public SharedPreferences.Editor putString(@Nullable String str, @Nullable String str2) {
            if (str2 == null) {
                str2 = EncryptedSharedPreferences.NULL_VALUE;
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            ByteBuffer allocate = ByteBuffer.allocate(length + 8);
            allocate.putInt(EncryptedType.STRING.getId());
            allocate.putInt(length);
            allocate.put(bytes);
            putEncryptedObject(str, allocate.array());
            return this;
        }

        @NonNull
        public SharedPreferences.Editor putStringSet(@Nullable String str, @Nullable Set<String> set) {
            if (set == null) {
                set = new ArraySet<>();
                set.add(EncryptedSharedPreferences.NULL_VALUE);
            }
            ArrayList<byte[]> arrayList = new ArrayList<>(set.size());
            int size = set.size() * 4;
            for (String bytes : set) {
                byte[] bytes2 = bytes.getBytes(StandardCharsets.UTF_8);
                arrayList.add(bytes2);
                size += bytes2.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(size + 4);
            allocate.putInt(EncryptedType.STRING_SET.getId());
            for (byte[] bArr : arrayList) {
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            putEncryptedObject(str, allocate.array());
            return this;
        }

        @NonNull
        public SharedPreferences.Editor remove(@Nullable String str) {
            if (!this.mEncryptedSharedPreferences.d(str)) {
                this.mEditor.remove(this.mEncryptedSharedPreferences.b(str));
                this.mKeysChanged.add(str);
                return this;
            }
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
    }

    public enum EncryptedType {
        STRING(0),
        STRING_SET(1),
        INT(2),
        LONG(3),
        FLOAT(4),
        BOOLEAN(5);
        
        private final int mId;

        private EncryptedType(int i11) {
            this.mId = i11;
        }

        @Nullable
        public static EncryptedType fromId(int i11) {
            if (i11 == 0) {
                return STRING;
            }
            if (i11 == 1) {
                return STRING_SET;
            }
            if (i11 == 2) {
                return INT;
            }
            if (i11 == 3) {
                return LONG;
            }
            if (i11 == 4) {
                return FLOAT;
            }
            if (i11 != 5) {
                return null;
            }
            return BOOLEAN;
        }

        public int getId() {
            return this.mId;
        }
    }

    public enum PrefKeyEncryptionScheme {
        AES256_SIV("AES256_SIV");
        
        private final String mDeterministicAeadKeyTemplateName;

        private PrefKeyEncryptionScheme(String str) {
            this.mDeterministicAeadKeyTemplateName = str;
        }

        public KeyTemplate a() throws GeneralSecurityException {
            return KeyTemplates.get(this.mDeterministicAeadKeyTemplateName);
        }
    }

    public enum PrefValueEncryptionScheme {
        AES256_GCM("AES256_GCM");
        
        private final String mAeadKeyTemplateName;

        private PrefValueEncryptionScheme(String str) {
            this.mAeadKeyTemplateName = str;
        }

        public KeyTemplate a() throws GeneralSecurityException {
            return KeyTemplates.get(this.mAeadKeyTemplateName);
        }
    }

    public EncryptedSharedPreferences(@NonNull String str, @NonNull String str2, @NonNull SharedPreferences sharedPreferences, @NonNull Aead aead, @NonNull DeterministicAead deterministicAead) {
        this.f37573c = str;
        this.f37571a = sharedPreferences;
        this.f37574d = str2;
        this.f37575e = aead;
        this.f37576f = deterministicAead;
    }

    @NonNull
    public static SharedPreferences create(@NonNull Context context, @NonNull String str, @NonNull MasterKey masterKey, @NonNull PrefKeyEncryptionScheme prefKeyEncryptionScheme, @NonNull PrefValueEncryptionScheme prefValueEncryptionScheme) throws GeneralSecurityException, IOException {
        return create(str, masterKey.a(), context, prefKeyEncryptionScheme, prefValueEncryptionScheme);
    }

    private Object getDecryptedObject(String str) throws SecurityException {
        if (!d(str)) {
            if (str == null) {
                str = NULL_VALUE;
            }
            try {
                String b11 = b(str);
                String string = this.f37571a.getString(b11, (String) null);
                if (string == null) {
                    return null;
                }
                boolean z11 = false;
                ByteBuffer wrap = ByteBuffer.wrap(this.f37575e.decrypt(Base64.decode(string, 0), b11.getBytes(StandardCharsets.UTF_8)));
                wrap.position(0);
                int i11 = wrap.getInt();
                EncryptedType fromId = EncryptedType.fromId(i11);
                if (fromId != null) {
                    switch (AnonymousClass1.f37577a[fromId.ordinal()]) {
                        case 1:
                            int i12 = wrap.getInt();
                            ByteBuffer slice = wrap.slice();
                            wrap.limit(i12);
                            String charBuffer = StandardCharsets.UTF_8.decode(slice).toString();
                            if (charBuffer.equals(NULL_VALUE)) {
                                return null;
                            }
                            return charBuffer;
                        case 2:
                            return Integer.valueOf(wrap.getInt());
                        case 3:
                            return Long.valueOf(wrap.getLong());
                        case 4:
                            return Float.valueOf(wrap.getFloat());
                        case 5:
                            if (wrap.get() != 0) {
                                z11 = true;
                            }
                            return Boolean.valueOf(z11);
                        case 6:
                            ArraySet arraySet = new ArraySet();
                            while (wrap.hasRemaining()) {
                                int i13 = wrap.getInt();
                                ByteBuffer slice2 = wrap.slice();
                                slice2.limit(i13);
                                wrap.position(wrap.position() + i13);
                                arraySet.add(StandardCharsets.UTF_8.decode(slice2).toString());
                            }
                            if (arraySet.size() != 1 || !NULL_VALUE.equals(arraySet.valueAt(0))) {
                                return arraySet;
                            }
                            return null;
                        default:
                            throw new SecurityException("Unhandled type for encrypted pref value: " + fromId);
                    }
                } else {
                    throw new SecurityException("Unknown type ID for encrypted pref value: " + i11);
                }
            } catch (GeneralSecurityException e11) {
                throw new SecurityException("Could not decrypt value. " + e11.getMessage(), e11);
            }
        } else {
            throw new SecurityException(str + " is a reserved key for the encryption keyset.");
        }
    }

    public String a(String str) {
        try {
            String str2 = new String(this.f37576f.decryptDeterministically(Base64.decode(str, 0), this.f37573c.getBytes()), StandardCharsets.UTF_8);
            if (str2.equals(NULL_VALUE)) {
                return null;
            }
            return str2;
        } catch (GeneralSecurityException e11) {
            throw new SecurityException("Could not decrypt key. " + e11.getMessage(), e11);
        }
    }

    public String b(String str) {
        if (str == null) {
            str = NULL_VALUE;
        }
        try {
            return Base64.encode(this.f37576f.encryptDeterministically(str.getBytes(StandardCharsets.UTF_8), this.f37573c.getBytes()));
        } catch (GeneralSecurityException e11) {
            throw new SecurityException("Could not encrypt key. " + e11.getMessage(), e11);
        }
    }

    public Pair<String, String> c(String str, byte[] bArr) throws GeneralSecurityException {
        String b11 = b(str);
        return new Pair<>(b11, Base64.encode(this.f37575e.encrypt(bArr, b11.getBytes(StandardCharsets.UTF_8))));
    }

    public boolean contains(@Nullable String str) {
        if (!d(str)) {
            return this.f37571a.contains(b(str));
        }
        throw new SecurityException(str + " is a reserved key for the encryption keyset.");
    }

    public boolean d(String str) {
        if (KEY_KEYSET_ALIAS.equals(str) || VALUE_KEYSET_ALIAS.equals(str)) {
            return true;
        }
        return false;
    }

    @NonNull
    public SharedPreferences.Editor edit() {
        return new Editor(this, this.f37571a.edit());
    }

    @NonNull
    public Map<String, ?> getAll() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f37571a.getAll().entrySet()) {
            if (!d((String) next.getKey())) {
                String a11 = a((String) next.getKey());
                hashMap.put(a11, getDecryptedObject(a11));
            }
        }
        return hashMap;
    }

    public boolean getBoolean(@Nullable String str, boolean z11) {
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject == null || !(decryptedObject instanceof Boolean)) {
            return z11;
        }
        return ((Boolean) decryptedObject).booleanValue();
    }

    public float getFloat(@Nullable String str, float f11) {
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject == null || !(decryptedObject instanceof Float)) {
            return f11;
        }
        return ((Float) decryptedObject).floatValue();
    }

    public int getInt(@Nullable String str, int i11) {
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject == null || !(decryptedObject instanceof Integer)) {
            return i11;
        }
        return ((Integer) decryptedObject).intValue();
    }

    public long getLong(@Nullable String str, long j11) {
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject == null || !(decryptedObject instanceof Long)) {
            return j11;
        }
        return ((Long) decryptedObject).longValue();
    }

    @Nullable
    public String getString(@Nullable String str, @Nullable String str2) {
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject == null || !(decryptedObject instanceof String)) {
            return str2;
        }
        return (String) decryptedObject;
    }

    @Nullable
    public Set<String> getStringSet(@Nullable String str, @Nullable Set<String> set) {
        Set<String> set2;
        Object decryptedObject = getDecryptedObject(str);
        if (decryptedObject instanceof Set) {
            set2 = (Set) decryptedObject;
        } else {
            set2 = new ArraySet<>();
        }
        if (set2.size() > 0) {
            return set2;
        }
        return set;
    }

    public void registerOnSharedPreferenceChangeListener(@NonNull SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f37572b.add(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(@NonNull SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f37572b.remove(onSharedPreferenceChangeListener);
    }

    @NonNull
    @Deprecated
    public static SharedPreferences create(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull PrefKeyEncryptionScheme prefKeyEncryptionScheme, @NonNull PrefValueEncryptionScheme prefValueEncryptionScheme) throws GeneralSecurityException, IOException {
        DeterministicAeadConfig.register();
        AeadConfig.register();
        Context applicationContext = context.getApplicationContext();
        AndroidKeysetManager.Builder withSharedPref = new AndroidKeysetManager.Builder().withKeyTemplate(prefKeyEncryptionScheme.a()).withSharedPref(applicationContext, KEY_KEYSET_ALIAS, str);
        KeysetHandle keysetHandle = withSharedPref.withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + str2).build().getKeysetHandle();
        AndroidKeysetManager.Builder withSharedPref2 = new AndroidKeysetManager.Builder().withKeyTemplate(prefValueEncryptionScheme.a()).withSharedPref(applicationContext, VALUE_KEYSET_ALIAS, str);
        Aead aead = (Aead) withSharedPref2.withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + str2).build().getKeysetHandle().getPrimitive(Aead.class);
        return new EncryptedSharedPreferences(str, str2, applicationContext.getSharedPreferences(str, 0), aead, (DeterministicAead) keysetHandle.getPrimitive(DeterministicAead.class));
    }
}
