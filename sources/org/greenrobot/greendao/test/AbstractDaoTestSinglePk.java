package org.greenrobot.greendao.test;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.room.RoomMasterTable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import junit.framework.TestCase;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.SqlUtils;

@Instrumented
public abstract class AbstractDaoTestSinglePk<D extends AbstractDao<T, K>, T, K> extends AbstractDaoTest<D, T, K> {

    /* renamed from: h  reason: collision with root package name */
    public Set<K> f27961h = new HashSet();
    private Property pkColumn;

    public AbstractDaoTestSinglePk(Class<D> cls) {
        super(cls);
    }

    public boolean c() {
        if (d((Object) null) != null) {
            return true;
        }
        DaoLog.d("Test is not available for entities with non-null keys");
        return false;
    }

    public abstract T d(K k11);

    public T e() {
        return d(g());
    }

    public abstract K f();

    public K g() {
        for (int i11 = 0; i11 < 100000; i11++) {
            K f11 = f();
            if (this.f27961h.add(f11)) {
                return f11;
            }
        }
        throw new IllegalStateException("Could not find a new PK");
    }

    public Cursor h(int i11, String str, K k11) {
        Cursor cursor;
        StringBuilder sb2 = new StringBuilder("SELECT ");
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            sb2.append(str);
            sb2.append(",");
        }
        SqlUtils.appendColumns(sb2, "T", this.f27958e.getAllColumns()).append(" FROM ");
        sb2.append('\"');
        sb2.append(this.f27958e.getTablename());
        sb2.append('\"');
        sb2.append(" T");
        if (k11 != null) {
            sb2.append(" WHERE ");
            TestCase.assertEquals(1, this.f27958e.getPkColumns().length);
            sb2.append(this.f27958e.getPkColumns()[0]);
            sb2.append("=");
            DatabaseUtils.appendValueToSql(sb2, k11);
        }
        String sb3 = sb2.toString();
        Database database = this.f27964c;
        if (!(database instanceof SQLiteDatabase)) {
            cursor = database.rawQuery(sb3, (String[]) null);
        } else {
            cursor = SQLiteInstrumentation.rawQuery((SQLiteDatabase) database, sb3, (String[]) null);
        }
        TestCase.assertTrue(cursor.moveToFirst());
        while (i12 < i11) {
            try {
                TestCase.assertEquals(str, cursor.getString(i12));
                i12++;
            } catch (RuntimeException e11) {
                cursor.close();
                throw e11;
            }
        }
        if (k11 != null) {
            TestCase.assertEquals(1, cursor.getCount());
        }
        return cursor;
    }

    public void i(int i11) {
        Object g11 = g();
        this.f27958e.insert(d(g11));
        Cursor h11 = h(i11, RoomMasterTable.DEFAULT_ID, g11);
        try {
            TestCase.assertEquals(g11, (Object) this.f27959f.readKey(h11, i11));
        } finally {
            h11.close();
        }
    }

    public void setUp() throws Exception {
        super.setUp();
        for (Property property : this.f27959f.getProperties()) {
            if (property.primaryKey) {
                if (this.pkColumn == null) {
                    this.pkColumn = property;
                } else {
                    throw new RuntimeException("Test does not work with multiple PK columns");
                }
            }
        }
        if (this.pkColumn == null) {
            throw new RuntimeException("Test does not work without a PK column");
        }
    }

    public void testCount() {
        this.f27958e.deleteAll();
        TestCase.assertEquals(0, this.f27958e.count());
        this.f27958e.insert(e());
        TestCase.assertEquals(1, this.f27958e.count());
        this.f27958e.insert(e());
        TestCase.assertEquals(2, this.f27958e.count());
    }

    public void testDelete() {
        Object g11 = g();
        this.f27958e.deleteByKey(g11);
        this.f27958e.insert(d(g11));
        TestCase.assertNotNull(this.f27958e.load(g11));
        this.f27958e.deleteByKey(g11);
        TestCase.assertNull(this.f27958e.load(g11));
    }

    public void testDeleteAll() {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < 10; i11++) {
            arrayList.add(e());
        }
        this.f27958e.insertInTx(arrayList);
        this.f27958e.deleteAll();
        TestCase.assertEquals(0, this.f27958e.count());
        for (Object key : arrayList) {
            K key2 = this.f27959f.getKey(key);
            TestCase.assertNotNull(key2);
            TestCase.assertNull(this.f27958e.load(key2));
        }
    }

    public void testDeleteByKeyInTx() {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 10; i11++) {
            arrayList.add(e());
        }
        this.f27958e.insertInTx(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f27959f.getKey(arrayList.get(0)));
        arrayList2.add(this.f27959f.getKey(arrayList.get(3)));
        arrayList2.add(this.f27959f.getKey(arrayList.get(4)));
        arrayList2.add(this.f27959f.getKey(arrayList.get(8)));
        this.f27958e.deleteByKeyInTx(arrayList2);
        TestCase.assertEquals((long) (arrayList.size() - arrayList2.size()), this.f27958e.count());
        for (Object next : arrayList2) {
            TestCase.assertNotNull(next);
            TestCase.assertNull(this.f27958e.load(next));
        }
    }

    public void testDeleteInTx() {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 10; i11++) {
            arrayList.add(e());
        }
        this.f27958e.insertInTx(arrayList);
        ArrayList<Object> arrayList2 = new ArrayList<>();
        arrayList2.add(arrayList.get(0));
        arrayList2.add(arrayList.get(3));
        arrayList2.add(arrayList.get(4));
        arrayList2.add(arrayList.get(8));
        this.f27958e.deleteInTx(arrayList2);
        TestCase.assertEquals((long) (arrayList.size() - arrayList2.size()), this.f27958e.count());
        for (Object key : arrayList2) {
            K key2 = this.f27959f.getKey(key);
            TestCase.assertNotNull(key2);
            TestCase.assertNull(this.f27958e.load(key2));
        }
    }

    public void testInsertAndLoad() {
        Object g11 = g();
        Object d11 = d(g11);
        this.f27958e.insert(d11);
        TestCase.assertEquals(g11, (Object) this.f27959f.getKey(d11));
        Object load = this.f27958e.load(g11);
        TestCase.assertNotNull(load);
        TestCase.assertEquals((Object) this.f27959f.getKey(d11), (Object) this.f27959f.getKey(load));
    }

    public void testInsertInTx() {
        this.f27958e.deleteAll();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 20; i11++) {
            arrayList.add(e());
        }
        this.f27958e.insertInTx(arrayList);
        TestCase.assertEquals((long) arrayList.size(), this.f27958e.count());
    }

    public void testInsertOrReplaceInTx() {
        this.f27958e.deleteAll();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < 20; i11++) {
            Object e11 = e();
            if (i11 % 2 == 0) {
                arrayList.add(e11);
            }
            arrayList2.add(e11);
        }
        this.f27958e.insertOrReplaceInTx(arrayList);
        this.f27958e.insertOrReplaceInTx(arrayList2);
        TestCase.assertEquals((long) arrayList2.size(), this.f27958e.count());
    }

    public void testInsertOrReplaceTwice() {
        Object e11 = e();
        long insert = this.f27958e.insert(e11);
        long insertOrReplace = this.f27958e.insertOrReplace(e11);
        if (this.f27958e.getPkProperty().type == Long.class) {
            TestCase.assertEquals(insert, insertOrReplace);
        }
    }

    public void testInsertTwice() {
        Object d11 = d(g());
        this.f27958e.insert(d11);
        try {
            this.f27958e.insert(d11);
            TestCase.fail("Inserting twice should not work");
        } catch (SQLException unused) {
        }
    }

    public void testLoadAll() {
        this.f27958e.deleteAll();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 15; i11++) {
            arrayList.add(d(g()));
        }
        this.f27958e.insertInTx(arrayList);
        TestCase.assertEquals(arrayList.size(), this.f27958e.loadAll().size());
    }

    public void testLoadPk() {
        i(0);
    }

    public void testLoadPkWithOffset() {
        i(10);
    }

    public void testQuery() {
        this.f27958e.insert(e());
        Object g11 = g();
        this.f27958e.insert(d(g11));
        this.f27958e.insert(e());
        List queryRaw = this.f27958e.queryRaw("WHERE " + this.f27958e.getPkColumns()[0] + "=?", g11.toString());
        TestCase.assertEquals(1, queryRaw.size());
        TestCase.assertEquals(g11, (Object) this.f27959f.getKey(queryRaw.get(0)));
    }

    public void testReadWithOffset() {
        Object g11 = g();
        this.f27958e.insert(d(g11));
        Cursor h11 = h(5, RoomMasterTable.DEFAULT_ID, g11);
        try {
            TestCase.assertEquals(g11, (Object) this.f27959f.getKey(this.f27959f.readEntity(h11, 5)));
        } finally {
            h11.close();
        }
    }

    public void testRowId() {
        boolean z11;
        if (this.f27958e.insert(e()) != this.f27958e.insert(e())) {
            z11 = true;
        } else {
            z11 = false;
        }
        TestCase.assertTrue(z11);
    }

    public void testSave() {
        if (c()) {
            this.f27958e.deleteAll();
            Object d11 = d((Object) null);
            if (d11 != null) {
                this.f27958e.save(d11);
                this.f27958e.save(d11);
                TestCase.assertEquals(1, this.f27958e.count());
            }
        }
    }

    public void testSaveInTx() {
        if (c()) {
            this.f27958e.deleteAll();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < 20; i11++) {
                Object d11 = d((Object) null);
                if (i11 % 2 == 0) {
                    arrayList.add(d11);
                }
                arrayList2.add(d11);
            }
            this.f27958e.saveInTx(arrayList);
            this.f27958e.saveInTx(arrayList2);
            TestCase.assertEquals((long) arrayList2.size(), this.f27958e.count());
        }
    }

    public void testUpdate() {
        this.f27958e.deleteAll();
        Object e11 = e();
        this.f27958e.insert(e11);
        this.f27958e.update(e11);
        TestCase.assertEquals(1, this.f27958e.count());
    }
}
