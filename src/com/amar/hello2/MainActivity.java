package com.amar.hello2;

import wyf.zcl.DBActivity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{
	private Button btn1 = null;

	private Button btn2 = null;

	private Button btn3 = null;

	private Button btn4 = null;

	private Button btn5 = null;

	private Button btn6 = null;

	private EditText editText1 = null;

	private EditText editText2 = null;

	public static final int REQUEST_CODE = 501;

	private OnClickListener onClicklistener = new OnClickListener()
	{
		public void onClick( View v )
		{
			Intent intent = null;
			switch ( v.getId() )
			{
			case R.id.button1:
				Toast.makeText( MainActivity.this , editText1.getText() , Toast.LENGTH_LONG ).show();
				break;
			case R.id.button2:
				intent = new Intent();
				intent.setAction( Intent.ACTION_CALL );
				Toast.makeText( MainActivity.this , editText2.getText() , Toast.LENGTH_LONG ).show();
				intent.setData( Uri.parse( "tel:" + editText2.getText() ) );
				startActivity( intent );
				break;
			case R.id.button3:
				intent = new Intent();
				intent.setClass( MainActivity.this , SecondActivity.class );
				intent.putExtra( "username" , editText1.getText() + "" );
				intent.putExtra( "number" , editText2.getText() + "" );
				// startActivity( intent );//无返回值
				startActivityForResult( intent , REQUEST_CODE );
				break;
			case R.id.button4:
				intent = new Intent();
				intent.setClass( MainActivity.this , ThirdActivity.class );
				startActivity( intent );
				break;
			case R.id.button5:
				intent = new Intent();
				intent.setClass( MainActivity.this , DBActivity.class );
				startActivity( intent );
				break;
			case R.id.button6:
				intent = new Intent();
				intent.setClass( MainActivity.this , NetWorkActivity.class );
				startActivity( intent );
				break;
			}
		}
	};

	@Override
	protected void onActivityResult( int requestCode , int resultCode , Intent data )
	{
		if ( REQUEST_CODE == requestCode )
		{
			if ( resultCode == SecondActivity.RESULT_CODE )
			{
				Bundle bundle = data.getExtras();
				Toast.makeText( MainActivity.this , bundle.getString( SecondActivity.RESULT_CONTENT ) , Toast.LENGTH_LONG ).show();
			}
		}
	}

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );

		setContentView( R.layout.activity_main );

		initUI();

		uiFunction();
	}

	public void initUI()
	{
		btn1 = ( Button ) this.findViewById( R.id.button1 );

		btn2 = ( Button ) this.findViewById( R.id.button2 );

		btn3 = ( Button ) this.findViewById( R.id.button3 );

		btn4 = ( Button ) this.findViewById( R.id.button4 );

		btn5 = ( Button ) this.findViewById( R.id.button5 );

		btn6 = ( Button ) this.findViewById( R.id.button6 );

		editText1 = ( EditText ) this.findViewById( R.id.editText1 );

		editText2 = ( EditText ) this.findViewById( R.id.editText2 );
	}

	public void uiFunction()
	{
		btn1.setOnClickListener( onClicklistener );

		btn2.setOnClickListener( onClicklistener );

		btn3.setOnClickListener( onClicklistener );

		btn4.setOnClickListener( onClicklistener );

		btn5.setOnClickListener( onClicklistener );

		btn6.setOnClickListener( onClicklistener );
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate( R.menu.main , menu );
		return true;
	}

	@Override
	protected Dialog onCreateDialog( int id )
	{
		Log.i( this.getClass().getName() , "in onCreateDialog" );
		return super.onCreateDialog( id );
	}

	@Override
	protected void onDestroy()
	{
		Log.i( this.getClass().getName() , "in onDestroy" );
		super.onDestroy();
	}

	@Override
	protected void onPause()
	{
		Log.i( this.getClass().getName() , "in onPause" );
		super.onPause();
	}

	@Override
	protected void onRestart()
	{
		Log.i( this.getClass().getName() , "in onRestart" );
		super.onRestart();
	}

	@Override
	protected void onResume()
	{
		Log.i( this.getClass().getName() , "in onResume" );
		super.onResume();
	}

	@Override
	protected void onStart()
	{
		Log.i( this.getClass().getName() , "in onStart" );
		super.onStart();
	}

	@Override
	protected void onStop()
	{
		Log.i( this.getClass().getName() , "in onStop" );
		super.onStop();
	}

	@Override
	protected void onSaveInstanceState( Bundle outState )
	{
		super.onSaveInstanceState( outState );
		Log.i( this.getClass().getName() , "in onSaveInstanceState" );
	}

	@Override
	protected void onRestoreInstanceState( Bundle savedInstanceState )
	{
		super.onRestoreInstanceState( savedInstanceState );
		Log.i( this.getClass().getName() , "in onRestoreInstanceState" );
	}

}
