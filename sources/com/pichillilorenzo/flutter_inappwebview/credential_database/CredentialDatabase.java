package com.pichillilorenzo.flutter_inappwebview.credential_database;

import android.content.Context;
import com.pichillilorenzo.flutter_inappwebview.types.URLCredential;
import com.pichillilorenzo.flutter_inappwebview.types.URLProtectionSpace;
import java.util.ArrayList;
import java.util.List;

public class CredentialDatabase {
    public static final String DATABASE_NAME = "CredentialDatabase.db";
    public static final int DATABASE_VERSION = 2;
    static final String LOG_TAG = "CredentialDatabase";
    private static CredentialDatabase instance;
    public URLCredentialDao credentialDao;

    /* renamed from: db  reason: collision with root package name */
    public CredentialDatabaseHelper f52871db;
    public URLProtectionSpaceDao protectionSpaceDao;

    private CredentialDatabase() {
    }

    private CredentialDatabase(CredentialDatabaseHelper credentialDatabaseHelper, URLProtectionSpaceDao uRLProtectionSpaceDao, URLCredentialDao uRLCredentialDao) {
        this.f52871db = credentialDatabaseHelper;
        this.protectionSpaceDao = uRLProtectionSpaceDao;
        this.credentialDao = uRLCredentialDao;
    }

    public static CredentialDatabase getInstance(Context context) {
        CredentialDatabase credentialDatabase = instance;
        if (credentialDatabase != null) {
            return credentialDatabase;
        }
        CredentialDatabaseHelper credentialDatabaseHelper = new CredentialDatabaseHelper(context);
        CredentialDatabase credentialDatabase2 = new CredentialDatabase(credentialDatabaseHelper, new URLProtectionSpaceDao(credentialDatabaseHelper), new URLCredentialDao(credentialDatabaseHelper));
        instance = credentialDatabase2;
        return credentialDatabase2;
    }

    public void clearAllAuthCredentials() {
        CredentialDatabaseHelper credentialDatabaseHelper = this.f52871db;
        credentialDatabaseHelper.clearAllTables(credentialDatabaseHelper.getWritableDatabase());
    }

    public List<URLCredential> getHttpAuthCredentials(String str, String str2, String str3, Integer num) {
        ArrayList arrayList = new ArrayList();
        URLProtectionSpace find = this.protectionSpaceDao.find(str, str2, str3, num);
        return find != null ? this.credentialDao.getAllByProtectionSpaceId(find.getId()) : arrayList;
    }

    public void removeHttpAuthCredential(String str, String str2, String str3, Integer num, String str4, String str5) {
        URLProtectionSpace find = this.protectionSpaceDao.find(str, str2, str3, num);
        if (find != null) {
            this.credentialDao.delete(this.credentialDao.find(str4, str5, find.getId()));
        }
    }

    public void removeHttpAuthCredentials(String str, String str2, String str3, Integer num) {
        URLProtectionSpace find = this.protectionSpaceDao.find(str, str2, str3, num);
        if (find != null) {
            this.protectionSpaceDao.delete(find);
        }
    }

    public void setHttpAuthCredential(String str, String str2, String str3, Integer num, String str4, String str5) {
        Long l11;
        boolean z11;
        URLProtectionSpace find = this.protectionSpaceDao.find(str, str2, str3, num);
        if (find == null) {
            l11 = Long.valueOf(this.protectionSpaceDao.insert(new URLProtectionSpace((Long) null, str, str2, str3, num.intValue())));
        } else {
            l11 = find.getId();
        }
        URLCredential find2 = this.credentialDao.find(str4, str5, l11);
        if (find2 != null) {
            boolean z12 = true;
            if (!find2.getUsername().equals(str4)) {
                find2.setUsername(str4);
                z11 = true;
            } else {
                z11 = false;
            }
            if (!find2.getPassword().equals(str5)) {
                find2.setPassword(str5);
            } else {
                z12 = z11;
            }
            if (z12) {
                this.credentialDao.update(find2);
                return;
            }
            return;
        }
        URLCredential uRLCredential = new URLCredential((Long) null, str4, str5, l11);
        uRLCredential.setId(Long.valueOf(this.credentialDao.insert(uRLCredential)));
    }
}
