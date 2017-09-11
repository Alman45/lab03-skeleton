package course.labs.activitylab;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";


		TextView tvCreate, tvStart, tvResume, tvPause, tvDestroy, tvStop, tvRestart;

		int onCreateCounter = 0 ;
		int onStartCounter = 0 ;
		int onResumeCounter = 0 ;
		int onPauseCounter = 0 ;
		int onStopCounter = 0 ;
		int onDestroyCounter = 0 ;
		int onRestartCounter = 0 ;


	// lifecycle counts
		//TODO: Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
		//TODO:  increment the variables' values when their corresponding lifecycle methods get called.
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);

			if((savedInstanceState != null)){
				onCreateCounter = savedInstanceState.getInt("onCreateCounter") ;
				onStartCounter = savedInstanceState.getInt("onStartCounter") ;
				onResumeCounter = savedInstanceState.getInt("onResumeCounter")  ;
				onPauseCounter = savedInstanceState.getInt("onPauseCounter")  ;
				onStopCounter = savedInstanceState.getInt("onStopCounter")  ;
				onDestroyCounter = savedInstanceState.getInt("onDestroyCounter")  ;
				onRestartCounter = savedInstanceState.getInt("onRestartCounter")  ;
			}

			onCreateCounter++;
			//Log cat print out
			Log.i(TAG, "onCreate called ");

			tvCreate = (TextView)findViewById(R.id.create);
			tvStart = (TextView)findViewById(R.id.start);
			tvResume = (TextView)findViewById(R.id.resume);
			tvPause = (TextView)findViewById(R.id.pause);
			tvDestroy = (TextView)findViewById(R.id.destroy);
			tvStop = (TextView)findViewById(R.id.stop);
			tvRestart = (TextView)findViewById(R.id.restart);

			tvCreate.setText("onCreate calls: " + Integer.toString(onCreateCounter));
			//TODO: update the appropriate count variable & update the view
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}
		
		// lifecycle callback overrides
		
		@Override
		public void onStart(){
			super.onStart();

			onStartCounter++;
			tvStart.setText("onStart() calls: " +Integer.toString(onStartCounter));

			//Log cat print out
			Log.i(TAG, "onStart called");
			
			//TODO:  update the appropriate count variable & update the view
		}

		@Override
		public void onResume(){
			super.onResume();
			onResumeCounter++;
			tvResume.setText("onResume() calls: " +Integer.toString(onResumeCounter));
			Log.i(TAG, "onResume called ");
		}

		@Override
		public void onPause(){
			super.onPause();
			onPauseCounter++;
			tvPause.setText("onPause() calls: " +Integer.toString(onPauseCounter));

			Log.i(TAG, "onPause called ");
		}

		@Override
		public void onStop(){
			super.onStop();
			onStopCounter++;
			tvStop.setText("onStop() calls: " +Integer.toString(onStopCounter));

			Log.i(TAG, "onStop called " );
		}

		@Override
		public void onDestroy(){
			super.onDestroy();
			onDestroyCounter++;
			tvDestroy.setText("onDestroy() calls: " +Integer.toString(onDestroyCounter));

			Log.i(TAG, "onDestroy called " );
		}

		@Override
		public void onRestart(){
			super.onRestart();
			onRestartCounter++;
			tvRestart.setText("onRestart() calls: " + Integer.toString(onRestartCounter));

			Log.i(TAG, "onRestart called ");
		}


		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			super.onSaveInstanceState(savedInstanceState);
			savedInstanceState.putInt("onCreateCounter", onCreateCounter);
			savedInstanceState.putInt("onStartCounter", onStartCounter);
			savedInstanceState.putInt("onResumeCounter", onResumeCounter);
			savedInstanceState.putInt("onPauseCounter", onPauseCounter);
			savedInstanceState.putInt("onStopCounter", onStopCounter);
			savedInstanceState.putInt("onDestroyCounter", onDestroyCounter);
			savedInstanceState.putInt("onRestartCounter", onRestartCounter);
		}


		public void launchActivityTwo(View view) {
			startActivity(new Intent(this, ActivityTwo.class));
		}
		

}
