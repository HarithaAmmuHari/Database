package com.adarsh.runtimedb;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.security.DomainCombiner;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
	EditText name,place;
	String name1,place1;
	ListView lv;
	dbhandler dbh;
	ArrayList<String> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		name=(EditText)findViewById(R.id.editText);
		place=(EditText)findViewById(R.id.editText1);
		lv=(ListView)findViewById(R.id.listView);

	}
	public void submitclick(View v)
	{
		name1=name.getText().toString();
		place1=place.getText().toString();
		dbh=new dbhandler(getApplicationContext());
		long g=dbh.insertdata(name1,place1);
		if(g>0)
		{
			Toast.makeText(MainActivity.this,"Inserted",Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
		}
	}
	public void viewclick(View v)
	{
		dbh=new dbhandler(getApplicationContext());
		Cursor c=null;
		data=new ArrayList<String>();
		c=dbh.viewdata();
		if(c!=null)
		{
			if(c.moveToFirst())
			{
				do {

					int i=c.getInt(c.getColumnIndex("ID"));
					String n=c.getString(c.getColumnIndex("NAME"));
					String p=c.getString(c.getColumnIndex("PLACE"));
					data.add("Id:"+i+"\n Name:"+n+"\nPlace:"+p);

				}while(c.moveToNext());
			}
			else
			{
				Toast.makeText(getApplicationContext(),"Empty database",Toast.LENGTH_SHORT).show();
			}
		}
		else
		{
			Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_SHORT).show();
		}
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
		lv.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main,menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
		case R.id.action_settings:
			Toast.makeText(getApplicationContext(),"Not Available",Toast.LENGTH_SHORT).show();
			break;
		case R.id.exit:
			MainActivity.this.finish();
			break;
		default:
		}

		return super.onOptionsItemSelected(item);
	}
}
