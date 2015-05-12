package com.example.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends ActionBarActivity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);

	}
	public void submit(View v){
		EditText name= (EditText)findViewById(R.id.editText1);
		EditText email1= (EditText)findViewById(R.id.editText2);
		EditText password= (EditText)findViewById(R.id.editText3);
		EditText address= (EditText)findViewById(R.id.editText4);
		String n=name.getText().toString();
		String e=email1.getText().toString();
		String p=password.getText().toString();
		String ad=address.getText().toString();
		Editor ed= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
		ed.putString("name", n);
		ed.putString("email1", e);
		ed.putString("password", p);
		ed.putString("address", ad);
		ed.commit();
		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		String nam=sp.getString("name", "null");
		String em=sp.getString("email1", "null");
		String pas=sp.getString("password", "null");
		String add=sp.getString("address", "null");
		Toast.makeText(getApplicationContext(), "name"+nam+"email"+em+"password"+pas+"address"+add, Toast.LENGTH_SHORT).show();
		startActivity(new Intent(getApplicationContext(),MainActivity.class));
		String user=nam+","+em+","+pas+","+add;
		ed.putString("userdetails",user);
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
