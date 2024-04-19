package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle; 
import android.widget.ImageView;
import android.widget.TextView;

public class TeamActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_team); 
		Team  team = (Team)this.getIntent().getExtras().get("Team");
		((TextView) findViewById(R.id.teamName)).setText(team.getName());
		((TextView) findViewById(R.id.teamParticipation)).setText("Participation: "+team.getParticipation());
		((TextView) findViewById(R.id.teamWinner)).setText("Participation: "+team.getWinner());
		((TextView) findViewById(R.id.teamNickname)).setText("Surnom: "+ team.getNickname());
		((ImageView) findViewById(R.id.teamLogo)).setImageResource(team.getIcon());
		((ImageView) findViewById(R.id.teamPhoto)).setImageResource(team.getPhoto());  
		((TextView) findViewById(R.id.teamDescription)).setText(team.getDescription());
 
	} 
 
}
