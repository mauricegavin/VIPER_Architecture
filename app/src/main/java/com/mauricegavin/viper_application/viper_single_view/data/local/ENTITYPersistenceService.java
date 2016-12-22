package com.mauricegavin.viper_application.viper_single_view.data.local;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.mauricegavin.viper_application.viper_single_view.data.entities.ENTITY;

import rx.Observable;

/**
 * Created by maurice on 30/09/2016.
 */
public final class ENTITYPersistenceService {

    private final String TAG = getClass().getName();

    //todo uncomment this
    //private ENTITYDao ENTITYDao;

    public ENTITYPersistenceService(Application application) {
        setupDatabase(application);
    }

    private void setupDatabase(Context context) {
        //todo uncomment this
        /*DaoMaster.DevOpenHelper helper = new UpgradableDaoMaster.DevOpenHelper(context, Constants.Database.ORALEYE_DB, null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        ENTITYDao = daoSession.getENTITYDao();*/
    }

    /**
     * ****************** DAO MANAGEMENT ******************************
     */

    public Observable<ENTITY> loadENTITY(@NonNull final String id) {
        return null;
    }

    private ENTITY readENTITY(final String id) {
        return null;
    }

    public Observable<ENTITY> saveENTITY(ENTITY ENTITY) {
        return null;
    }

    private ENTITY writeENTITY(ENTITY ENTITY) {
        return null;
    }

    //todo uncomment this
/*    public Observable<ENTITY> loadENTITY(@NonNull final String id) {
        return Observable.fromCallable(() -> readENTITY(id));
    }

    private ENTITY readENTITY(final String id) {
        return ENTITYDao.load(id);
    }

    public Observable<ENTITY> saveENTITY(ENTITY ENTITY) {
        return Observable.fromCallable(() -> writeENTITY(ENTITY));
    }

    private ENTITY writeENTITY(ENTITY ENTITY) {
        ENTITYDao.insertOrReplaceInTx(ENTITY);
        return ENTITY;
    }*/

}


