package com.example.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}
	public void registerNewUser(View v) {
		startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
		finish();
	}
	public void loginUser(View v) {
		EditText username,password;
		String user,pass;
		String use="";
		String pas="";
		username=(EditText)findViewById(R.id.editUser);
		password=(EditText)findViewById(R.id.editPass);
		user=username.getText().toString();
		pass=password.getText().toString();
		
				if(user.contains("@")&&user.contains(".")&&pass.equals(pas)){
			Toast.makeText(getApplicationContext(), "please inserted values", Toast.LENGTH_SHORT).show();
		}
		else
		{
		Toast.makeText(getApplicationContext(), "inserted", Toast.LENGTH_SHORT).show();
		}
		MyDatabaseHelper mydb=new MyDatabaseHelper(getApplicationContext());
		mydb.checkLogin( user, pass);
		Toast.makeText(LoginActivity.this, "inserted", Toast.LENGTH_SHORT).show();

	}
}
