package cis3334.simpletext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.util.GregorianCalendar;

public class SecondActivity extends Activity {

	String eventNum;		// number of the event from mainActivity
	TextView tvTitle, tvSum, tvLoc, tvDate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_second);

		tvTitle = (TextView) findViewById(R.id.txtTitle);
		tvSum = (TextView) findViewById(R.id.txtSummary);
		tvLoc = (TextView) findViewById(R.id.txtLocation);
		tvDate = (TextView) findViewById(R.id.txtDate);

		// get the data passed from the main activity using extras
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			// grab the event number as a string from the main activity using extras
			eventNum = extras.getString("eventNum");
		}
		//depending on the event number, display different information on this form
		if (eventNum.equals("1")) {
			tvTitle.setText("Twin Ports Choral Project: Spirit Moving Over Chaos");
			tvSum.setText("Join the Twin Ports Choral Project as they explore music choral composed in remembrance of people and places torn apart by poverty, disaster, and war.");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("FRIDAY, FEBRUARY 26, 2016");
		}
		if (eventNum.equals("2")) {
			tvTitle.setText("An Evening with The Voice");
			tvSum.setText("NBC’s The Voice’s Madi Davis and twins Andi & Alex Peot will perform in concert at Mitchell Auditorium in Duluth, MN on Sunday");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("Sunday, February 28, 2016");
		}
		if (eventNum.equals("3")) {
			tvTitle.setText("Thistles & Shamrocks");
			tvSum.setText("An Evening of Scottish & Irish Music and Dance sponsored by the Duluth Scottish Heritage Association");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("Friday, March 7, 2016");
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layout_second, menu);
		return true;
	}

	public void onClickSendText (View v) {

		if (eventNum.equals("1")) {

			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Twin Ports Choral Project: Spirit Moving Over Chaos");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			GregorianCalendar begDate = new GregorianCalendar(2016, 1, 26, 19, 30);
			GregorianCalendar endDate = new GregorianCalendar(2016, 1, 26, 21, 30);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					begDate.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endDate.getTimeInMillis());
			startActivity(calIntent);
		}
		if (eventNum.equals("2")) {
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "An Evening with The Voice");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			GregorianCalendar begDate = new GregorianCalendar(2016, 1, 28, 16, 00);
			GregorianCalendar endDate = new GregorianCalendar(2016, 1, 28, 18, 30);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					begDate.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endDate.getTimeInMillis());
			startActivity(calIntent);
		}
		if (eventNum.equals("3")) {
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Thistles & Shamrocks");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			GregorianCalendar begDate = new GregorianCalendar(2016, 2, 4, 19, 00);
			GregorianCalendar endDate = new GregorianCalendar(2016, 2, 4, 21, 30);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					begDate.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endDate.getTimeInMillis());
			startActivity(calIntent);

		}


	}


}
