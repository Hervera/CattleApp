package com.andikasoft.rwandacattle.rwandacattle.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.andikasoft.rwandacattle.rwandacattle.model.User;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Name
    public static final String DATABASE_NAME = "rwandacattle.db";

    // Table Names
    private static final String TABLE_USER = "users";
    private static final String TABLE_MESSAGE = "messages";
    private static final String TABLE_MESSAGE_USER = "message_user";
    private static final String TABLE_ANIMAL = "animals";

    // Common column names
    private static final String COL_ID = "id";
    private static final String COL_CREATED_AT = "created_at";
    private static final String COL_UPDATED_AT = "updated_at";

    // USERS Table - column names
    private static final String COL_NAME = "name";
    private static final String COL_EMAIL = "email";
    private static final String COL_PHONE = "phone_number";
    private static final String COL_PROFILE_IMAGE = "profile_image";
    private static final String COL_PASSWORD = "password";

    // MESSAGES Table - column names
    private static final String COL_MESSAGE_USER_ID = "user_id";
    private static final String COL_TITLE = "title";
    private static final String COL_MESSAGE = "message";

    // MESSAGE_USER Table - column names
    private static final String COL_MESSAGE_ID = "message_id";
    private static final String COL_USER_ID = "user_id";

    // ANIMALS Table - column names
    private static final String COL_ANIMAL_USER_ID = "user_id";
    private static final String COL_ANIMAL_CATEGORY = "category";
    private static final String COL_ANIMAL_NAME = "name";
    private static final String COL_ANIMAL_GENDER = "gender";
    private static final String COL_ANIMAL_AGE = "age";
    private static final String COL_ANIMAL_WEIGHT = "weight";
    private static final String COL_ANIMAL_SIZE = "size";
    private static final String COL_ANIMAL_IMAGE = "image";


    // Table Create Statements
    // users table create statement
    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + " TEXT NOT NULL,"
            + COL_EMAIL + " VARCHAR," + COL_PHONE + " INTEGER NOT NULL," + COL_PROFILE_IMAGE + " TEXT,"
            + COL_PASSWORD + " VARCHAR NOT NULL," + COL_CREATED_AT + " DATETIME," + COL_UPDATED_AT + " DATETIME"
            + ")";

    // messages table create statement
    private static final String CREATE_TABLE_MESSAGE = "CREATE TABLE " + TABLE_MESSAGE
            + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_MESSAGE_USER_ID + " INTEGER NOT NULL,"+ COL_TITLE + " TEXT NOT NULL," + COL_MESSAGE + " TEXT NOT NULL,"
            + COL_CREATED_AT + " DATETIME," + COL_UPDATED_AT + " DATETIME,"
            + "FOREIGN KEY(" + COL_MESSAGE_USER_ID + ") REFERENCES " + TABLE_USER + "(id)"
            + ")";

    // message_user table create statement
    private static final String CREATE_TABLE_MESSAGE_USER = "CREATE TABLE "
            + TABLE_MESSAGE_USER + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_MESSAGE_ID + " INTEGER NOT NULL," + COL_USER_ID + " INTEGER NOT NULL,"
            + "FOREIGN KEY(" + COL_MESSAGE_ID + ") REFERENCES " + TABLE_MESSAGE + "(id),"
            + "FOREIGN KEY(" + COL_USER_ID + ") REFERENCES " + TABLE_USER + "(id)"
            + ")";

    // animals table create statement
    private static final String CREATE_TABLE_ANIMAL = "CREATE TABLE "
            + TABLE_ANIMAL + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_ANIMAL_USER_ID + " INTEGER NOT NULL,"
            + COL_ANIMAL_CATEGORY + " TEXT NOT NULL,"
            + COL_ANIMAL_NAME + " TEXT," + COL_ANIMAL_GENDER + " BOOLEAN NOT NULL,"
            + COL_ANIMAL_AGE + " INTEGER," + COL_ANIMAL_WEIGHT + " DOUBLE," + COL_ANIMAL_SIZE + " TEXT,"
            + COL_ANIMAL_IMAGE + " VARCHAR," + COL_CREATED_AT + " DATETIME," + COL_UPDATED_AT + " DATETIME,"
            + "FOREIGN KEY(" + COL_ANIMAL_USER_ID + ") REFERENCES " + TABLE_USER + "(id)"
            + ")";


    SQLiteDatabase db;
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null, 3);
//        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_MESSAGE);
        db.execSQL(CREATE_TABLE_MESSAGE_USER);
        db.execSQL(CREATE_TABLE_ANIMAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANIMAL);

        // create new tables
        onCreate(db);
    }

    public void insertUser(User user){
        db = this.getWritableDatabase();

        ContentValues values=  new ContentValues();
        String query = "select * from users";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COL_ID, count);
        values.put(COL_NAME, user.getName());
        values.put(COL_EMAIL, user.getEmail());
        values.put(COL_PHONE, user.getPhone_number());
        String default_image = "default_avatar.png";
        values.put(COL_PROFILE_IMAGE, default_image);

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public String searchPass(String uemail){
        db = this.getWritableDatabase();

        String query = "select email, password from "+TABLE_USER;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{

                a = cursor.getString(0);

                if(a.equals(uemail))
                {
                    b = cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());
        }

        return b;
    }


}
