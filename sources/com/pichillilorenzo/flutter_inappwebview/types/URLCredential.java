package com.pichillilorenzo.flutter_inappwebview.types;

import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class URLCredential {

    /* renamed from: id  reason: collision with root package name */
    private Long f52879id;
    private String password;
    private Long protectionSpaceId;
    private String username;

    public URLCredential(Long l11, String str, String str2, Long l12) {
        this.f52879id = l11;
        this.username = str;
        this.password = str2;
        this.protectionSpaceId = l12;
    }

    public URLCredential(String str, String str2) {
        this.username = str;
        this.password = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        URLCredential uRLCredential = (URLCredential) obj;
        String str = this.username;
        if (str == null ? uRLCredential.username != null : !str.equals(uRLCredential.username)) {
            return false;
        }
        String str2 = this.password;
        String str3 = uRLCredential.password;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public Long getId() {
        return this.f52879id;
    }

    public String getPassword() {
        return this.password;
    }

    public Long getProtectionSpaceId() {
        return this.protectionSpaceId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.username;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.password;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public void setId(Long l11) {
        this.f52879id = l11;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setProtectionSpaceId(Long l11) {
        this.protectionSpaceId = l11;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("username", this.username);
        hashMap.put("password", this.password);
        return hashMap;
    }

    public String toString() {
        return "URLCredential{username='" + this.username + '\'' + ", password='" + this.password + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
