package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.wearengine.ClientToken;
import com.huawei.wearengine.IdentityStoreCallback;

public interface BinderService extends IInterface {

    public static class Default implements BinderService {
        public IBinder asBinder() {
            return null;
        }

        public void checkPermissionIdentity(String str, String str2, IdentityStoreCallback identityStoreCallback) {
        }

        public int exchangeApiLevel(int i11) {
            return 0;
        }

        public IBinder getBinder(int i11) {
            return null;
        }

        public void registerToken(String str, ClientToken clientToken) {
        }
    }

    public static abstract class Stub extends Binder implements BinderService {
        private static final String DESCRIPTOR = "com.huawei.wearengine.BinderService";

        public static class Proxy implements BinderService {
            public static BinderService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void checkPermissionIdentity(String str, String str2, IdentityStoreCallback identityStoreCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(identityStoreCallback != null ? identityStoreCallback.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().checkPermissionIdentity(str, str2, identityStoreCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int exchangeApiLevel(int i11) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().exchangeApiLevel(i11);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder getBinder(int i11) {
                IBinder readStrongBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readStrongBinder = obtain2.readStrongBinder();
                    } else {
                        readStrongBinder = Stub.getDefaultImpl().getBinder(i11);
                    }
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void registerToken(String str, ClientToken clientToken) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(clientToken != null ? clientToken.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().registerToken(str, clientToken);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BinderService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof BinderService)) ? new Proxy(iBinder) : (BinderService) queryLocalInterface;
        }

        public static BinderService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(BinderService binderService) {
            if (Proxy.sDefaultImpl != null || binderService == null) {
                return false;
            }
            Proxy.sDefaultImpl = binderService;
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
                IBinder binder = getBinder(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(binder);
                return true;
            } else if (i11 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                registerToken(parcel.readString(), ClientToken.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i11 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                checkPermissionIdentity(parcel.readString(), parcel.readString(), IdentityStoreCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i11 != 4) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                int exchangeApiLevel = exchangeApiLevel(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(exchangeApiLevel);
                return true;
            }
        }
    }

    void checkPermissionIdentity(String str, String str2, IdentityStoreCallback identityStoreCallback);

    int exchangeApiLevel(int i11);

    IBinder getBinder(int i11);

    void registerToken(String str, ClientToken clientToken);
}
