package org.greenrobot.greendao.query;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;

public interface WhereCondition {
    void appendTo(StringBuilder sb2, String str);

    void appendValuesTo(List<Object> list);

    public static class StringCondition extends AbstractCondition {

        /* renamed from: d  reason: collision with root package name */
        public final String f27902d;

        public StringCondition(String str) {
            this.f27902d = str;
        }

        public void appendTo(StringBuilder sb2, String str) {
            sb2.append(this.f27902d);
        }

        public StringCondition(String str, Object obj) {
            super(obj);
            this.f27902d = str;
        }

        public StringCondition(String str, Object... objArr) {
            super(objArr);
            this.f27902d = str;
        }
    }

    public static class PropertyCondition extends AbstractCondition {

        /* renamed from: op  reason: collision with root package name */
        public final String f27901op;
        public final Property property;

        public PropertyCondition(Property property2, String str) {
            this.property = property2;
            this.f27901op = str;
        }

        private static Object checkValueForType(Property property2, Object obj) {
            if (obj == null || !obj.getClass().isArray()) {
                Class<?> cls = property2.type;
                if (cls != Date.class) {
                    if (cls == Boolean.TYPE || cls == Boolean.class) {
                        if (obj instanceof Boolean) {
                            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                        }
                        if (obj instanceof Number) {
                            int intValue = ((Number) obj).intValue();
                            if (!(intValue == 0 || intValue == 1)) {
                                throw new DaoException("Illegal boolean value: numbers must be 0 or 1, but was " + obj);
                            }
                        } else if (obj instanceof String) {
                            String str = (String) obj;
                            if ("TRUE".equalsIgnoreCase(str)) {
                                return 1;
                            }
                            if ("FALSE".equalsIgnoreCase(str)) {
                                return 0;
                            }
                            throw new DaoException("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insensitive), but was " + obj);
                        }
                    }
                    return obj;
                } else if (obj instanceof Date) {
                    return Long.valueOf(((Date) obj).getTime());
                } else {
                    if (obj instanceof Long) {
                        return obj;
                    }
                    throw new DaoException("Illegal date value: expected java.util.Date or Long for value " + obj);
                }
            } else {
                throw new DaoException("Illegal value: found array, but simple object required");
            }
        }

        private static Object[] checkValuesForType(Property property2, Object[] objArr) {
            for (int i11 = 0; i11 < objArr.length; i11++) {
                objArr[i11] = checkValueForType(property2, objArr[i11]);
            }
            return objArr;
        }

        public void appendTo(StringBuilder sb2, String str) {
            SqlUtils.appendProperty(sb2, str, this.property).append(this.f27901op);
        }

        public PropertyCondition(Property property2, String str, Object obj) {
            super(checkValueForType(property2, obj));
            this.property = property2;
            this.f27901op = str;
        }

        public PropertyCondition(Property property2, String str, Object[] objArr) {
            super(checkValuesForType(property2, objArr));
            this.property = property2;
            this.f27901op = str;
        }
    }

    public static abstract class AbstractCondition implements WhereCondition {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f27898a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f27899b;

        /* renamed from: c  reason: collision with root package name */
        public final Object[] f27900c;

        public AbstractCondition() {
            this.f27898a = false;
            this.f27899b = null;
            this.f27900c = null;
        }

        public void appendValuesTo(List<Object> list) {
            if (this.f27898a) {
                list.add(this.f27899b);
                return;
            }
            Object[] objArr = this.f27900c;
            if (objArr != null) {
                for (Object add : objArr) {
                    list.add(add);
                }
            }
        }

        public AbstractCondition(Object obj) {
            this.f27899b = obj;
            this.f27898a = true;
            this.f27900c = null;
        }

        public AbstractCondition(Object[] objArr) {
            this.f27899b = null;
            this.f27898a = false;
            this.f27900c = objArr;
        }
    }
}
