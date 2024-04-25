package com.example.worldcup2022;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.worldcup2022.R;
import com.example.worldcup2022.Team;

public class TeamActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_detail_activity);

        // Retrieve the Team object passed from MainActivity
        Team team = (Team) getIntent().getSerializableExtra("team");

        // Set the team details to the corresponding views
        TextView teamNameTextView = findViewById(R.id.teamName);
        TextView teamParticipationTextView = findViewById(R.id.teamParticipation);
        TextView teamWinnerTextView = findViewById(R.id.teamWinner);
        TextView teamNicknameTextView = findViewById(R.id.teamNickname);
        ImageView teamLogoImageView = findViewById(R.id.teamLogo);
        ImageView teamPhotoImageView = findViewById(R.id.teamPhoto);
        TextView teamDescriptionTextView = findViewById(R.id.teamDescription);

        // Set team details to views
        teamNameTextView.setText(team.getName());
        teamParticipationTextView.setText("Participation: " + team.getParticipation());
        teamWinnerTextView.setText("Winner: " + team.getWinner());
        teamNicknameTextView.setText("Nickname: " + team.getNickname());
        teamLogoImageView.setImageResource(team.getIcon());
        teamPhotoImageView.setImageResource(team.getPhoto());
        teamDescriptionTextView.setText(team.getDescription());
    }
}
