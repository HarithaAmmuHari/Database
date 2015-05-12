package com.example.egapp;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	ArrayList<String>adviceList;
	ArrayAdapter<String>adapter;
	ServerSocket serverSocket;
	public final static Random random=new Random();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		adviceList=new ArrayList<String>();
		adviceList.add("Hii");
		adviceList.add("hi sir what we are do for u");
		adviceList.add("Welcome");
		adviceList.add("ThankYou");
		adviceList.add("Hii");
		adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,adviceList);
		((ListView)findViewById(R.id.listView1)).setAdapter(adapter);
		new MyAsyncTask().execute("");
	}
	public void addClicked(View v){
		EditText editadvice=(EditText)findViewById(R.id.editText1);
		adviceList.add(editadvice.getText().toString());
		adapter.notifyDataSetInvalidated();
		adapter.notifyDataSetChanged();

	}
	public class MyAsyncTask extends AsyncTask<String, Integer, String> {
		protected void onPreExecute(){
			Toast.makeText(getApplicationContext(), "starting to server", Toast.LENGTH_SHORT).show();
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... params) {
			try{
				serverSocket=new ServerSocket(8888);
				while(!serverSocket.isClosed()){
					System.out.println("waiting for connection");
					Socket socket=serverSocket.accept();
					System.out.println("connected");
					PrintWriter writer=new PrintWriter(socket.getOutputStream());
					String advice=getAdvice();
					System.out.println("Sending advice:"+advice);
					socket.close();
				}
				serverSocket.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		private String getAdvice() {
			return adviceList.get(random.nextInt(adviceList.size()));

		}
	}

}
