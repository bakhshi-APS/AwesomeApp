package university.jahan.awesomeapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import university.jahan.awesomeapp.database.MySqliteHelper;


import static android.support.design.widget.Snackbar.LENGTH_LONG;
import static university.jahan.awesomeapp.database.DatabaseContract.TableDetails.*;
public class LoginActivity extends AppCompatActivity {


    EditText username,password;


    MySqliteHelper mySqliteHelper;

    SQLiteDatabase db;

    LinearLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        mySqliteHelper = new MySqliteHelper(this);

        db = mySqliteHelper.getReadableDatabase();

        parent = findViewById(R.id.parent_login_layout);

    }

    public void Register(View view) {

        startActivity(new Intent(this,RegisterActivity.class));

    }

    public void Login(View view) {


        CheckDetails(username.getText().toString(),password.getText().toString());

    }

    public void CheckDetails(String name,String password){


        String[] projection = {
                _ID,
                COLUMN_NAME,
                COLUMN_PASSWORD
        };


        String selection = COLUMN_NAME + " = ? AND "+ COLUMN_PASSWORD +" = ? ";
        String[] selectionArgs = {name,password};


        Cursor cursor = db.query(TABLE_NAME,
                                projection,
                                selection,
                                selectionArgs,
                                null,
                                null,
                                null);

        if(cursor.moveToNext()){
            // user is registered
            Snackbar snackbar = Snackbar.make(parent, "Login Success", LENGTH_LONG)
                    .setAction("Okay", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                        }
                    });

            View snackView = snackbar.getView();
            snackView.setBackgroundColor(ContextCompat.getColor(this,R.color.success_color));

            snackbar.show();

        }
        else{

            Snackbar snackbar = Snackbar.make(parent, "User Not Found", LENGTH_LONG)
                    .setAction("Okay", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                        }
                    });

            View snackView = snackbar.getView();
            snackView.setBackgroundColor(ContextCompat.getColor(this,R.color.failed_color));

            snackbar.show();
        }

    }



}
