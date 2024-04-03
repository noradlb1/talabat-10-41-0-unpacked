package com.newrelic.agent.android.stores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressLint({"NewApi"})
public abstract class SharedPrefsStore {
    protected static final Charset ENCODING = Charset.forName("ISO-8859-1");
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    protected final SharedPreferences sharedPrefs;
    protected final String storeFilename;

    public SharedPrefsStore(Context context, String str) {
        this.sharedPrefs = context.getSharedPreferences(str, 0);
        this.storeFilename = str;
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean applyOrCommitEditor(SharedPreferences.Editor editor) {
        try {
            editor.apply();
            return true;
        } catch (Exception e11) {
            log.error("SharedPrefsStore.applyOrCommitEditor(SharedPreferences.Editor): ", e11);
            return true;
        }
    }

    public void clear() {
        try {
            synchronized (this) {
                SharedPreferences.Editor edit = this.sharedPrefs.edit();
                edit.clear();
                applyOrCommitEditor(edit);
            }
        } catch (Exception e11) {
            log.error("SharedPrefsStore.clear(): ", e11);
        }
    }

    public int count() {
        int size;
        try {
            synchronized (this.sharedPrefs) {
                size = this.sharedPrefs.getAll().size();
            }
            return size;
        } catch (Exception e11) {
            log.error("SharedPrefsStore.count(): ", e11);
            return 0;
        }
    }

    public String decodeBytesToString(byte[] bArr) {
        try {
            return new String(bArr, ENCODING);
        } catch (Exception e11) {
            log.error("SharedPrefsStore.decodeBytesToString(byte[]): ", e11);
            return null;
        }
    }

    public byte[] decodeStringToBytes(String str) {
        try {
            return Base64.decode(str, 0);
        } catch (Exception e11) {
            log.error("SharedPrefsStore.decodeStringToBytes(String): ", e11);
            return null;
        }
    }

    public void delete(String str) {
        try {
            synchronized (this) {
                SharedPreferences.Editor edit = this.sharedPrefs.edit();
                edit.remove(str);
                applyOrCommitEditor(edit);
            }
        } catch (Exception e11) {
            log.error("SharedPrefsStore.delete(): ", e11);
        }
    }

    public String encodeBytes(byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 2);
        } catch (Exception e11) {
            log.error("SharedPrefsStore.encodeBytes(byte[]): ", e11);
            return null;
        }
    }

    public List<?> fetchAll() {
        ArrayList arrayList = new ArrayList();
        try {
            synchronized (this) {
                arrayList.addAll(this.sharedPrefs.getAll().values());
            }
        } catch (Exception e11) {
            log.error("SharedPrefsStore.fetchAll(): ", e11);
        }
        return arrayList;
    }

    public String getStoreFilename() {
        return this.storeFilename;
    }

    public boolean store(String str, byte[] bArr) {
        try {
            SharedPreferences.Editor edit = this.sharedPrefs.edit();
            edit.putString(str, decodeBytesToString(bArr));
            return applyOrCommitEditor(edit);
        } catch (Exception e11) {
            log.error("SharedPrefsStore.store(String, byte[]): ", e11);
            return false;
        }
    }

    public boolean store(String str, Set<String> set) {
        try {
            SharedPreferences.Editor edit = this.sharedPrefs.edit();
            edit.putStringSet(str, set);
            return applyOrCommitEditor(edit);
        } catch (Exception e11) {
            log.error("SharedPrefsStore.store(String, Set<String>): ", e11);
            return false;
        }
    }

    public boolean store(String str, String str2) {
        try {
            SharedPreferences.Editor edit = this.sharedPrefs.edit();
            edit.putString(str, str2);
            return applyOrCommitEditor(edit);
        } catch (Exception e11) {
            log.error("SharedPrefsStore.store(String, String): ", e11);
            return false;
        }
    }
}
