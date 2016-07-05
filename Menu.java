package com.myapp.teja;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;

public class Menu extends Activity{
	
	private Integer[] pics={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f};
	private ImageView imageView;
	Button go;
	int count=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		
		
		Gallery gallery=(Gallery) findViewById(R.id.gallery1);
		gallery.setAdapter(new ImageAdapter(this));
		imageView=(ImageView)findViewById(R.id.imageView1);
		gallery.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				imageView.setImageResource(pics[position]);
				count=position;
			}
			
		});
		
		go=(Button) findViewById(R.id.button1);
		go.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openGrid= new Intent("com.myapp.teja.GRID"+(count+1));
				startActivity(openGrid);
			}
			
		});
	}
	
	
	public class ImageAdapter extends BaseAdapter{
		private Context context;
		int imageBackground;
		
		public ImageAdapter(Context context){
			this.context=context;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return pics.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageView=new ImageView(context);
			imageView.setPadding(20, 20, 20, 20);
			imageView.setImageResource(pics[position]);
			return imageView;
		}
	}
}
