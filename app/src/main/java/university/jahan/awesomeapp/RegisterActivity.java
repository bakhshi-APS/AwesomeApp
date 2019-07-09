package university.jahan.awesomeapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import university.jahan.awesomeapp.database.DatabaseContract;
import university.jahan.awesomeapp.database.MySqliteHelper;

public class RegisterActivity extends AppCompatActivity {


    EditText name,password,email;


    MySqliteHelper mySqliteHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        name = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email_id);

        mySqliteHelper = new MySqliteHelper(this);


        db =  mySqliteHelper.getWritableDatabase();

    }

    public void Register(View view) {

        // Store the data into DB


        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseContract.TableDetails.COLUMN_NAME,
                name.getText().toString());

        contentValues.put(DatabaseContract.TableDetails.COLUMN_PASSWORD,
                password.getText().toString());
        contentValues.put(DatabaseContract.TableDetails.COLUMN_EMAIL,
                email.getText().toString());


        long rowId =  db.insert(DatabaseContract.TableDetails.TABLE_NAME,null,contentValues);

        Toast.makeText(this,"Register Success : "+rowId,Toast.LENGTH_LONG).show();




    }
}
