package com.example.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class ProfileActivity extends ActionBarActivity {
	public static String CURRENT_USER_EMAIL="";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_logout:
			startActivity(new Intent(getApplicationContext(), LoginActivity.class));
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
