package com.example.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	public void advice(View v){
		EditText editip =(EditText)findViewById(R.id.editText1);
		EditText editport =(EditText)findViewById(R.id.editText2);
		new MyAsyncTask().execute(editip.getText().toString(),editport.getText().toString());
	}

	public class MyAsyncTask extends AsyncTask<String, Integer, String>{

		protected void onPreExecute() {
			Toast.makeText(getApplicationContext(), "Starting Async task to get advice", Toast.LENGTH_SHORT).show();
		}
		protected String doInBackground(String... params) {
			String advice="";
			try{
				Socket socket=new Socket(params[0],Integer.parseInt(params[1]));
				BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				reader.close();
				socket.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
			return advice;
		}
		protected void onPostExecute(String result) {
			Toast.makeText(getApplicationContext(), "Finished Async task to get advice\n" + result,Toast.LENGTH_SHORT).show();
		}
	}

}
