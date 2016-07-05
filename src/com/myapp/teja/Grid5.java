package com.myapp.teja;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Grid5 extends Activity{

	private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;
    Bitmap yourSelectedImage = null,bit0,bit1,bit2,bit3,bit4,bit5;
    ImageView imgView;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid5);
        
        Button btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener(){

    		@Override
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			try{
    			ImageView i0=(ImageView)findViewById(R.id.imageView0);
    			ImageView i1=(ImageView)findViewById(R.id.imageView1);	
    			ImageView i2=(ImageView)findViewById(R.id.imageView2);	
    			ImageView i3=(ImageView)findViewById(R.id.imageView3);	
    			ImageView i4=(ImageView)findViewById(R.id.imageView4);	
    			ImageView i5=(ImageView)findViewById(R.id.imageView5);	
    			bit0 = ((BitmapDrawable) i0.getBackground()).getBitmap();
    			bit1 = ((BitmapDrawable) i1.getBackground()).getBitmap();
    			bit2 = ((BitmapDrawable) i2.getBackground()).getBitmap();
    			bit3 = ((BitmapDrawable) i3.getBackground()).getBitmap();
    			bit4 = ((BitmapDrawable) i4.getBackground()).getBitmap();
    			bit5 = ((BitmapDrawable) i5.getBackground()).getBitmap();  
    			Bitmap b0=Bitmap.createScaledBitmap(bit0, i0.getWidth(), i0.getHeight(),true);
    			Bitmap b1=Bitmap.createScaledBitmap(bit1, i1.getWidth(), i1.getHeight(),true);
    			Bitmap b2=Bitmap.createScaledBitmap(bit2, i2.getWidth(), i2.getHeight(),true);
    			Bitmap b3=Bitmap.createScaledBitmap(bit3, i3.getWidth(), i3.getHeight(),true);
    			Bitmap b4=Bitmap.createScaledBitmap(bit4, i4.getWidth(), i4.getHeight(),true);
    			Bitmap b5=Bitmap.createScaledBitmap(bit5, i5.getWidth(), i5.getHeight(),true);
    			combineImages(b0,b1,b2,b3,b4,b5);
    			}
    	        catch(NullPointerException e2){
    	        	Toast.makeText(getApplicationContext(), "Add images before saving!", Toast.LENGTH_SHORT).show();
    	        }
    			
    		}
        	
        });
        findViewById(R.id.imageView1).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                imgView = (ImageView) findViewById(R.id.imageView1);
             // Create intent to Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
			}
        	
        });
        
        findViewById(R.id.imageView2).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                imgView = (ImageView) findViewById(R.id.imageView2);
             // Create intent to Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
			}
        	
        });
        
        findViewById(R.id.imageView3).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                imgView = (ImageView) findViewById(R.id.imageView3);
             // Create intent to Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
			}
        	
        });
        
        findViewById(R.id.imageView4).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                imgView = (ImageView) findViewById(R.id.imageView4);
             // Create intent to Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
			}
        	
        });
        
        findViewById(R.id.imageView5).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                imgView = (ImageView) findViewById(R.id.imageView5);
             // Create intent to Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
			}
        	
        });
    }

 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                // Set the Image in ImageView after decoding the String
                yourSelectedImage=BitmapFactory.decodeFile(imgDecodableString);
                Drawable d=new BitmapDrawable(yourSelectedImage);
                imgView.setBackground(d);
            }
       }catch(Exception e){
        	e.printStackTrace();
        }
    }
    
    public Bitmap combineImages(Bitmap a, Bitmap b,Bitmap c,Bitmap d,Bitmap e,Bitmap f) { 
        Bitmap cs = null; 
        try{
			ImageView i0=(ImageView)findViewById(R.id.imageView0);
			ImageView i1=(ImageView)findViewById(R.id.imageView1);	
			ImageView i2=(ImageView)findViewById(R.id.imageView2);	
			ImageView i3=(ImageView)findViewById(R.id.imageView3);	
			ImageView i4=(ImageView)findViewById(R.id.imageView4);	
			ImageView i5=(ImageView)findViewById(R.id.imageView5);
			
        cs = Bitmap.createBitmap(((ImageView) findViewById(R.id.imageView0)).getWidth(), ((ImageView) findViewById(R.id.imageView0)).getHeight(), Bitmap.Config.ARGB_8888); 
     
        Canvas comboImage = new Canvas(cs); 
     
        comboImage.drawBitmap(a, i0.getLeft(), i0.getTop(), null); 
        comboImage.drawBitmap(b, i1.getLeft(), i1.getTop(), null);
        comboImage.drawBitmap(c, i2.getLeft(), i2.getTop(), null);
        comboImage.drawBitmap(d, i3.getLeft(), i3.getTop(), null);
        comboImage.drawBitmap(e, i4.getLeft(), i4.getTop(), null);
        comboImage.drawBitmap(f, i5.getLeft(), i5.getTop(), null);
        MediaStore.Images.Media.insertImage(getContentResolver(), cs, "blah" , "yeah");
        Toast.makeText(getApplicationContext(), "Image Saved!", Toast.LENGTH_SHORT).show();
        Intent openMenu= new Intent("com.myapp.teja.MENU");
		startActivity(openMenu);
        }
        catch(NullPointerException e2){
        	Toast.makeText(getApplicationContext(), "Add images before saving", Toast.LENGTH_SHORT).show();
        }
        return cs; 
      }
}
