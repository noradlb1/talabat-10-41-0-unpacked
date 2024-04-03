package com.huawei.hms.analytics;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import datamodels.TypesAliasesKt;
import java.util.ArrayList;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.DaoConfig;

@Instrumented
public final class bk {
    @SafeVarargs
    public static void klm(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        for (int i11 = 0; i11 <= 0; i11++) {
            String str = new DaoConfig(database, clsArr[0]).tablename;
            String str2 = "ALTER TABLE " + str + " RENAME TO " + (str + "_TEMP");
            if (!(database instanceof SQLiteDatabase)) {
                database.execSQL(str2);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) database, str2);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r0 == null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (r0 == 0) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        return new java.util.ArrayList();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.lang.String> lmn(org.greenrobot.greendao.database.Database r3, java.lang.String r4) {
        /*
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003c }
            java.lang.String r2 = "SELECT * FROM "
            r1.<init>(r2)     // Catch:{ Exception -> 0x003c }
            r1.append(r4)     // Catch:{ Exception -> 0x003c }
            java.lang.String r4 = " limit 1"
            r1.append(r4)     // Catch:{ Exception -> 0x003c }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x003c }
            boolean r1 = r3 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x003c }
            if (r1 != 0) goto L_0x001d
            android.database.Cursor r3 = r3.rawQuery(r4, r0)     // Catch:{ Exception -> 0x003c }
            goto L_0x0023
        L_0x001d:
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ Exception -> 0x003c }
            android.database.Cursor r3 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r3, r4, r0)     // Catch:{ Exception -> 0x003c }
        L_0x0023:
            r0 = r3
            if (r0 == 0) goto L_0x0037
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x003c }
            java.lang.String[] r4 = r0.getColumnNames()     // Catch:{ Exception -> 0x003c }
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ Exception -> 0x003c }
            r3.<init>(r4)     // Catch:{ Exception -> 0x003c }
            r0.close()
            return r3
        L_0x0037:
            if (r0 == 0) goto L_0x0048
            goto L_0x0045
        L_0x003a:
            r3 = move-exception
            goto L_0x004e
        L_0x003c:
            java.lang.String r3 = "MigrationDB"
            java.lang.String r4 = "rawQuery Exception."
            com.huawei.hms.analytics.core.log.HiLog.w(r3, r4)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0048
        L_0x0045:
            r0.close()
        L_0x0048:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            return r3
        L_0x004e:
            if (r0 == 0) goto L_0x0053
            r0.close()
        L_0x0053:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.bk.lmn(org.greenrobot.greendao.database.Database, java.lang.String):java.util.List");
    }

    @SafeVarargs
    public static void lmn(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        String str;
        for (int i11 = 0; i11 <= 0; i11++) {
            DaoConfig daoConfig = new DaoConfig(database, clsArr[i11]);
            String str2 = daoConfig.tablename;
            String str3 = str2 + "_TEMP";
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int length = daoConfig.properties.length;
            for (int i12 = 0; i12 < length; i12++) {
                String str4 = daoConfig.properties[i12].columnName;
                if (lmn(database, str3).contains(str4)) {
                    arrayList.add(str4);
                    arrayList2.add(str4);
                } else {
                    try {
                        Class<?> cls = daoConfig.properties[i12].type;
                        if (cls.equals(String.class)) {
                            str = "TEXT";
                        } else {
                            if (!cls.equals(Long.class) && !cls.equals(Integer.class) && !cls.equals(Long.TYPE)) {
                                if (!cls.equals(Integer.TYPE)) {
                                    if (!cls.equals(Boolean.class)) {
                                        if (!cls.equals(Boolean.TYPE)) {
                                            throw new Exception("Migration Helper types does not match current parameter");
                                        }
                                    }
                                    str = "BOOLEAN";
                                }
                            }
                            str = "INTEGER";
                        }
                        if (str.equals("INTEGER")) {
                            arrayList2.add("0 as ".concat(String.valueOf(str4)));
                            arrayList.add(str4);
                        }
                    } catch (Exception e11) {
                        HiLog.w("MigrationDB", e11.getMessage());
                    }
                }
            }
            String str5 = "INSERT INTO " + str2 + " (" + TextUtils.join(",", arrayList) + ") SELECT " + TextUtils.join(",", arrayList2) + " FROM " + str3 + TypesAliasesKt.separator;
            boolean z11 = database instanceof SQLiteDatabase;
            if (!z11) {
                database.execSQL(str5);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) database, str5);
            }
            String concat = "DROP TABLE ".concat(String.valueOf(str3));
            if (!z11) {
                database.execSQL(concat);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) database, concat);
            }
        }
    }
}
