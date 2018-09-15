package com.adamding.android.smartschedule.database;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "BookDB";

    //table name
    private static final String TABLE_NAME = "books";

    private static final String KEY_ID = "id";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_TITLES = "titles";

    private static final String[] COLUMNS = {KEY_ID, KEY_TITLES, KEY_AUTHOR};

    public dbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CR_BOOK_TBL = "CREATE TABLE books ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "title TEXT,"+
                "author TEXT)";

        db.execSQL(CR_BOOK_TBL);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS books");

        this.onCreate(db);
    }

    public Book defineBook(Cursor c){
        Book book = new Book();
        book.setId(Integer.parseInt(c.getString(0)));
        book.setTitle(c.getString(1));
        book.setAuthor(c.getString(2));
        return book;
    }

    public void addBook(Book book){
        //for logging
        Log.d("addbook", book.toString());

        //1. get reference to writable database
        SQLiteDatabase db = this.getWritableDatabase();

        //2. create content values
        ContentValues values = new ContentValues();
        values.put(KEY_TITLES, book.getTitle());
        values.put(KEY_AUTHOR, book.getAuthor());

        //3. insert
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Book getBook(int id){
        //1. get reference to readable db
        SQLiteDatabase db = this.getReadableDatabase();

        //2. build query
        Cursor c = db.query(TABLE_NAME, COLUMNS, " id = ?", new String[] {String.valueOf(id)}, null, null, null, null);
        if(c!=null){
            c.moveToFirst();
        }
        Book book = new Book();
        book.setId(Integer.parseInt(c.getString(0)));
        book.setTitle(c.getString(1));
        book.setAuthor(c.getString(2));
        Log.d("getbook("+id+")",book.toString());
        return book;
    }

    public List<Book> getAllBooks(){
        List<Book> books = new LinkedList<Book>();

        //1. build the query
        String query = "SELECT * FROM"+TABLE_NAME;

        //.2 get reference to writable db
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery(query, null);

        Book book = null;

        if(c.moveToFirst()){
            do{
                book = defineBook(c);
                books.add(book);
            }while(c.moveToNext());
        }
    }
}
