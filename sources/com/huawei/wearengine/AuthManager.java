package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.wearengine.auth.AuthListener;
import com.huawei.wearengine.auth.Permission;

public interface AuthManager extends IInterface {

    public static class Default implements AuthManager {
        public IBinder asBinder() {
            return null;
        }

        public boolean checkPermission(Permission permission) {
            return false;
        }

        public boolean[] checkPermissions(Permission[] permissionArr) {
            return null;
        }

        public String preStartAuth(AuthListener authListener) {
            return null;
        }

        public int requestPermission(AuthListener authListener, Permission[] permissionArr) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements AuthManager {
        private static final String DESCRIPTOR = "com.huawei.wearengine.AuthManager";

        public static class Proxy implements AuthManager {
            public static AuthManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean checkPermission(Permission permission) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z11 = true;
                    if (permission != null) {
                        obtain.writeInt(1);
                        permission.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().checkPermission(permission);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z11 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z11;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean[] checkPermissions(Permission[] permissionArr) {
                boolean[] createBooleanArray;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedArray(permissionArr, 0);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        createBooleanArray = obtain2.createBooleanArray();
                    } else {
                        createBooleanArray = Stub.getDefaultImpl().checkPermissions(permissionArr);
                    }
                    return createBooleanArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public String preStartAuth(AuthListener authListener) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(authListener != null ? authListener.asBinder() : null);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().preStartAuth(authListener);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int requestPermission(AuthListener authListener, Permission[] permissionArr) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(authListener != null ? authListener.asBinder() : null);
                    obtain.writeTypedArray(permissionArr, 0);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().requestPermission(authListener, permissionArr);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static AuthManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AuthManager)) ? new Proxy(iBinder) : (AuthManager) queryLocalInterface;
        }

        public static AuthManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(AuthManager authManager) {
            if (Proxy.sDefaultImpl != null || authManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = authManager;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int requestPermission = requestPermission(AuthListener.Stub.asInterface(parcel.readStrongBinder()), (Permission[]) parcel.createTypedArray(Permission.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(requestPermission);
                return true;
            } else if (i11 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean checkPermission = checkPermission(parcel.readInt() != 0 ? Permission.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(checkPermission ? 1 : 0);
                return true;
            } else if (i11 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean[] checkPermissions = checkPermissions((Permission[]) parcel.createTypedArray(Permission.CREATOR));
                parcel2.writeNoException();
                parcel2.writeBooleanArray(checkPermissions);
                return true;
            } else if (i11 != 4) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                String preStartAuth = preStartAuth(AuthListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeString(preStartAuth);
                return true;
            }
        }
    }

    boolean checkPermission(Permission permission);

    boolean[] checkPermissions(Permission[] permissionArr);

    String preStartAuth(AuthListener authListener);

    int requestPermission(AuthListener authListener, Permission[] permissionArr);
}
