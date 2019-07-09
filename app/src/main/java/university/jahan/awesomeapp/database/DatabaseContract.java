package university.jahan.awesomeapp.database;

import android.provider.BaseColumns;

public final class DatabaseContract  {


    private DatabaseContract(){

    }

    public static class TableDetails implements BaseColumns{

        public static final String TABLE_NAME = "students";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_EMAIL = "email";

    }



}
