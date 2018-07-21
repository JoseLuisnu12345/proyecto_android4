package d.edu.itla.taskapp.Repositorio.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ConexionDb extends SQLiteOpenHelper {

    private static final String LOG_TAG = "ConexionDb";
    private static final String NOMBRE_DB = "taskapp.db";
    private static final int VERSION_DB = 1;

    public ConexionDb(Context context)
    {
        super(context, NOMBRE_DB, null, VERSION_DB);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG_TAG, "Creando la base de datos");
        //db
        db.execSQL(EstructuraDb.TABLA_CATEGORIA);


        //tabla
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO: lo veremos una segunda etapa DB upgrade
        db.execSQL("DROP TABLE categoria");
        this.onCreate(db);
    }
}
