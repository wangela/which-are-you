package codepath.apps.whichareyou;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class QuizzesActivity extends Activity {
	QuizzesAdapter adapter = new QuizzesAdapter(this, arrayOfQuizzes);
	ListView quizList = (ListView) findViewById(R.id.lvQuizzes);
	quizList.setAdapter(adapter);

	class Quiz extends View {
		public String name;
		public String description;
		public String image;
	}
	
	public class QuizzesAdapter extends ArrayAdapter<Quiz> {
		// View lookup cache
		private static class ViewHolder {
			TextView vhName;
			TextView vhDescription;
			ImageView vhImage;
		}
		
		public QuizzesAdapter(Context context, ArrayList<Quiz> quizzes) {
			super(context,R.layout.item_quiz, quizzes);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// Get the data item for this position
			Quiz quiz = getItem(position);
			// Check if an existing view is being reused, otherwise inflate the view
			ViewHolder viewHolder; // view lookup cache stored in tag
			if (convertView == null) {
				viewHolder = new ViewHolder();
				LayoutInflater inflater = LayoutInflater.from(getContext());
				convertView = inflater.inflate(R.layout.item_quiz, null);
				viewHolder.vhName = (TextView) convertView.findViewById(R.id.quizName);
				viewHolder.vhDescription = (TextView) convertView.findViewById(R.id.quizDescription);
				viewHolder.vhImage = (ImageView) convertView.findViewById(R.id.quizImage);
				convertView.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) convertView.getTag();
			}
			// Populate the data into the template view using the data object
			viewHolder.vhName.setText(quiz.name);
			viewHolder.vhDescription.setText(quiz.description);
			viewHolder.vhImage.setImageResource(quiz.image);
			// Return the completed view to render on screen
			return convertView;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quizzes);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quizzes, menu);
		return true;
	}

}
