package com.example.worldcup2022;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private ArrayList<Team> teamsList;
    private ArrayTeamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the list of teams
        teamsList = getTeams();

        // Initialize the adapter with the list of teams
        adapter = new ArrayTeamAdapter(this, teamsList);

        // Bind the adapter to the ListView
        setListAdapter(adapter);
    }

    // Method to get the list of teams
    private ArrayList<Team> getTeams() {
        ArrayList<Team> teams = new ArrayList<>();

        // Add sample teams
        teams.add(new Team("Argentina", "L'Albiceleste", R.drawable.argentine, R.drawable.argentine_equipe, 17, 2, "The Argentina national football team, known as L'Albiceleste, is one of the most successful teams in South America. They have won the FIFA World Cup twice and have a rich footballing history."));
        teams.add(new Team("Morocco", "Lions de l'Atlas", R.drawable.maroc, R.drawable.maroc_equipe, 5, 0, "The Morocco national football team, also known as Lions de l'Atlas, is a strong team from Africa. They have participated in multiple FIFA World Cups and have a passionate fan base."));
        teams.add(new Team("France", "Les Bleus", R.drawable.france, R.drawable.france_equipe, 2, 1, "The France national football team, known as Les Bleus, is one of the most successful teams in the world. They have won the FIFA World Cup twice and have produced many legendary players."));
        teams.add(new Team("Ghana", "Black Stars", R.drawable.ghana, R.drawable.ghana_equipe, 3, 0, "The Ghana national football team, known as the Black Stars, is one of the powerhouses of African football. They have had success in both continental and international competitions."));
        teams.add(new Team("Croatia", "Vatreni", R.drawable.croitia, R.drawable.croitia_equipe, 5, 0, "The Croatia national football team, known as Vatreni (The Blazers), has a strong footballing tradition. They achieved great success by reaching the finals of the FIFA World Cup in 2018."));
        teams.add(new Team("Brazil", "Seleção", R.drawable.brazil, R.drawable.brazil_equipe, 21, 5, "The Brazil national football team, known as Seleção, is the most successful team in FIFA World Cup history, having won the tournament a record five times. They are known for their samba style of play and have produced some of the greatest footballers of all time."));
        teams.add(new Team("Germany", "Die Mannschaft", R.drawable.germany, R.drawable.germany_equipe, 19, 4, "The Germany national football team, known as Die Mannschaft, is one of the powerhouses of international football. They have won the FIFA World Cup four times and have a reputation for their disciplined and efficient style of play."));
        teams.add(new Team("Spain", "La Furia Roja", R.drawable.spain, R.drawable.spain_equipe, 15, 1, "The Spain national football team, known as La Furia Roja, has established itself as a dominant force in international football in recent years. They won their first FIFA World Cup in 2010 and are known for their possession-based style of play."));
        teams.add(new Team("Algeria", "Les Fennecs", R.drawable.algeria, R.drawable.algeria_equipe, 4, 0, "The Algeria national football team, known as Les Fennecs, is a competitive team from North Africa. They have won the African Cup of Nations once and have a talented squad."));

        return teams;
    }

    // Override the onListItemClick() method to handle clicks on list items
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // Get the selected Team object
        Team selectedTeam = (Team) getListAdapter().getItem(position);

        // Create an intent to start the TeamActivity
        Intent intent = new Intent(this, TeamActivity.class);

        // Pass the data of the selected team to the TeamActivity
        intent.putExtra("team", selectedTeam);

        // Start the TeamActivity
        startActivity(intent);
    }
}
