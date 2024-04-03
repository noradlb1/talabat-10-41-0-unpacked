package com.tekartik.sqflite;

import com.tekartik.sqflite.dev.Debug;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlCommand {
    private final List<Object> rawArguments;
    private final String sql;

    public SqlCommand(String str, List<Object> list) {
        this.sql = str;
        this.rawArguments = list == null ? new ArrayList<>() : list;
    }

    private static Map<String, Object> fixMap(Map<Object, Object> map) {
        Object obj;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof Map) {
                obj = fixMap((Map) value);
            } else {
                obj = toString(value);
            }
            hashMap.put(toString(next.getKey()), obj);
        }
        return hashMap;
    }

    private String[] getQuerySqlArguments(List<Object> list) {
        return (String[]) getStringQuerySqlArguments(list).toArray(new String[0]);
    }

    private Object[] getSqlArguments(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Object value : list) {
                arrayList.add(toValue(value));
            }
        }
        return arrayList.toArray(new Object[0]);
    }

    private List<String> getStringQuerySqlArguments(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Object sqlCommand : list) {
                arrayList.add(toString(sqlCommand));
            }
        }
        return arrayList;
    }

    private static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            ArrayList arrayList = new ArrayList();
            for (byte valueOf : (byte[]) obj) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList.toString();
        } else if (obj instanceof Map) {
            return fixMap((Map) obj).toString();
        } else {
            return obj.toString();
        }
    }

    private static Object toValue(Object obj) {
        if (obj == null) {
            return null;
        }
        if (Debug.EXTRA_LOGV) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("arg ");
            sb2.append(obj.getClass().getCanonicalName());
            sb2.append(" ");
            sb2.append(toString(obj));
        }
        if (obj instanceof List) {
            List list = (List) obj;
            byte[] bArr = new byte[list.size()];
            for (int i11 = 0; i11 < list.size(); i11++) {
                bArr[i11] = (byte) ((Integer) list.get(i11)).intValue();
            }
            obj = bArr;
        }
        if (Debug.EXTRA_LOGV) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("arg ");
            sb3.append(obj.getClass().getCanonicalName());
            sb3.append(" ");
            sb3.append(toString(obj));
        }
        return obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SqlCommand)) {
            return false;
        }
        SqlCommand sqlCommand = (SqlCommand) obj;
        String str = this.sql;
        if (str != null) {
            if (!str.equals(sqlCommand.sql)) {
                return false;
            }
        } else if (sqlCommand.sql != null) {
            return false;
        }
        if (this.rawArguments.size() != sqlCommand.rawArguments.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.rawArguments.size(); i11++) {
            if (!(this.rawArguments.get(i11) instanceof byte[]) || !(sqlCommand.rawArguments.get(i11) instanceof byte[])) {
                if (!this.rawArguments.get(i11).equals(sqlCommand.rawArguments.get(i11))) {
                    return false;
                }
            } else if (!Arrays.equals((byte[]) this.rawArguments.get(i11), (byte[]) sqlCommand.rawArguments.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public List<Object> getRawSqlArguments() {
        return this.rawArguments;
    }

    public String getSql() {
        return this.sql;
    }

    public int hashCode() {
        String str = this.sql;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public SqlCommand sanitizeForQuery() {
        if (this.rawArguments.size() == 0) {
            return this;
        }
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int length = this.sql.length();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            char charAt = this.sql.charAt(i13);
            if (charAt == '?') {
                int i14 = i13 + 1;
                if (i14 < length && Character.isDigit(this.sql.charAt(i14))) {
                    return this;
                }
                i11++;
                if (i12 >= this.rawArguments.size()) {
                    return this;
                }
                int i15 = i12 + 1;
                Object obj = this.rawArguments.get(i12);
                if ((obj instanceof Integer) || (obj instanceof Long)) {
                    sb2.append(obj.toString());
                    i12 = i15;
                } else {
                    arrayList.add(obj);
                    i12 = i15;
                }
            }
            sb2.append(charAt);
        }
        if (i11 != this.rawArguments.size()) {
            return this;
        }
        return new SqlCommand(sb2.toString(), arrayList);
    }

    public String[] getQuerySqlArguments() {
        return getQuerySqlArguments(this.rawArguments);
    }

    public Object[] getSqlArguments() {
        return getSqlArguments(this.rawArguments);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.sql);
        List<Object> list = this.rawArguments;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            str = " " + getStringQuerySqlArguments(this.rawArguments);
        }
        sb2.append(str);
        return sb2.toString();
    }
}
