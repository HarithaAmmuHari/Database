package com.example.app;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	public  void logIn(View v) {
EditText email=(EditText)findViewById(R.id.editText1);
EditText pass=(EditText)findViewById(R.id.editText2);
String mail =email.getText().toString();
String pss =pass.getText().toString();

if(mail .contains("@")&&mail .contains(".")){
	Toast.makeText(getApplicationContext(), "insert values", Toast.LENGTH_SHORT).show();
	}
else{
	Toast.makeText(getApplicationContext(), "please inserted values", Toast.LENGTH_SHORT).show();

}
startActivity(new Intent(getApplicationContext(),HomepageActivity.class));
Editor ed=PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
ed.putString("email", mail);
ed.putString("pass", pss);
ed.commit();
SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
String em=sp.getString("email", "null");
String ps=sp.getString("pass", "null");

Toast.makeText(getApplicationContext(), "email"+em+"pass"+ps, Toast.LENGTH_SHORT).show();
	}
	public void createAccount(View v) {
		startActivity(new Intent(getApplicationContext(),CreateActivity.class));
	}
	public void cancel(View v) {
		startActivity(new Intent(getApplicationContext(),MainActivity.class));
		Toast.makeText(getApplicationContext(), "cancel", Toast.LENGTH_SHORT).show();
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
