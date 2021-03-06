package com.example.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class RegisterActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}

	public void submitRegister(View v){
		RadioButton rb1,rb2,rb3;
		EditText first,last,mail,pass,passn,month,day,yr,phno;
		String fname,lname,mn,pass1,pass2,email, d, year,phn;
		int gender=0;
		first=(EditText)findViewById(R.id.editText1);
		last=(EditText)findViewById(R.id.editText2);
		mail=(EditText)findViewById(R.id.editText3);
		pass=(EditText)findViewById(R.id.editText4);
		passn=(EditText)findViewById(R.id.editText5);
		month=(EditText)findViewById(R.id.editText6);
		day=(EditText)findViewById(R.id.editText7);
		yr=(EditText)findViewById(R.id.editText8);
		phno=(EditText)findViewById(R.id.editText9);
		rb1=(RadioButton)findViewById(R.id.radio0);
		rb2=(RadioButton)findViewById(R.id.radio1);
		rb3=(RadioButton)findViewById(R.id.radio2);

		fname=first.getText().toString();
		lname=last.getText().toString();
		email=mail.getText().toString();
		pass1=pass.getText().toString();
		pass2=passn.getText().toString();
		mn=month.getText().toString();
		d=day.getText().toString();
		year=yr.getText().toString();
		phn=phno.getText().toString();

		//validation
		if(!pass1.equals(pass2)){
			Toast.makeText(RegisterActivity.this, "Passwords Missmatch!", Toast.LENGTH_SHORT).show();
			return;
		}
		if (rb1.isChecked()) {
			gender=1;	
		}else if(rb2.isChecked()){
			gender=2;
		}else if(rb3.isChecked()){
			gender=3;
		}else{
			Toast.makeText(RegisterActivity.this, "gender not selected!", Toast.LENGTH_SHORT).show();
			return;
		}
		if(fname==null || lname== null || email== null || pass1==null || pass2 ==null || mn==null || d==null || year== null ||phn==null || gender==0){
			Toast.makeText(RegisterActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
			return;

		}


		MyDatabaseHelper mydb=new MyDatabaseHelper(getApplicationContext());
		mydb.doRegistration(fname, lname, email, pass1, Integer.parseInt(d), Integer.parseInt(mn), Integer.parseInt(year),gender, phn);
		Toast.makeText(RegisterActivity.this, "inserted", Toast.LENGTH_SHORT).show();
		
		startActivity(new Intent(getApplicationContext(),LoginActivity.class));
		finish();
	}
}
