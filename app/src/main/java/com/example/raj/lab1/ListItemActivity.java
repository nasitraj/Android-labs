package com.example.raj.lab1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "ListItemActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        ImageButton image = (ImageButton) findViewById(R.id.imagebuttom);
        image.setOnClickListener(
                new ImageButton.OnClickListener(){
                    public void onClick(View v){
                        final int REQUEST_IMAGE_CAPTURE = 1;
                        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                        }
                    }
                }
        );
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(
               new CompoundButton.OnCheckedChangeListener(){
                   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                       CharSequence text = isChecked ? "Switch is On" : "Switch is Off" ;
                       int duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off

                       Toast toast = Toast.makeText(getApplicationContext() ,text, duration); //this is the ListActivity
                       toast.show(); //display your message box

                   }

               }
        );
        CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkbox1);
        checkBox1.setOnCheckedChangeListener(
                new CheckBox.OnCheckedChangeListener(){
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                        AlertDialog.Builder builder = new AlertDialog.Builder(ListItemActivity.this);
                        // 2. Chain together various setter methods to set the dialog characteristics

                        builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                                .setTitle(R.string.dialog_title)
                                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent resultIntent = new Intent(  );
                                        resultIntent.putExtra("Response", "My information to share");
                                        setResult(Activity.RESULT_OK, resultIntent);
                                        finish();

                                    }
                                })
                                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // User cancelled the dialog
                                    }
                                })
                                .show();

                    }
                }
        );
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      ImageButton image = (ImageButton) findViewById(R.id.imagebuttom);
    if(resultCode == RESULT_OK) {
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        image.setImageBitmap(imageBitmap);
    }
    }

    protected void	onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME , "in onResume");
    }

    protected void	onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME , "in onStart");
    }

    protected void	onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME , "in onPause");
    }

    protected void	onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME , "in onStop");
    }

    protected void	onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME , "in onDestroy");
    }

    }


