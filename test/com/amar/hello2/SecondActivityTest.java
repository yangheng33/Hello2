package com.amar.hello2;

import android.test.AndroidTestCase;
import android.util.Log;

public class SecondActivityTest extends AndroidTestCase
{

	public void testAdd()
	{
		
		Log.i("SecondActivityTest",getContext().getClass()+"");
		SecondActivity s = (SecondActivity)getContext();
		AndroidTestCase.assertNotNull( s );
		
		//AndroidTestCase.assertEquals( 4 , s.add( 1 , 3 ) );
		fail( "Not yet implemented" );
	}

}
