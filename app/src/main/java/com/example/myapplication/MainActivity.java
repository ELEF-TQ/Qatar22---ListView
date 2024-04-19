package com.example.myapplication;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import android.widget.Toast;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends ListActivity implements OnItemClickListener {

	ListView teamsListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		teamsListView = (ListView)findViewById(android.R.id.list);
		List<Team> teams = getTeams();
		if (teams != null) {
			teamsListView.setAdapter(new ArrayTeamAdapter(this, teams));
		}
		teamsListView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)  { 

		Team team = (Team) teamsListView.getAdapter().getItem(position);

		Intent intent = new Intent(this, TeamActivity.class);
		intent.putExtra("Team", team);
		startActivity(intent);

				Toast.makeText(this, "Vous avez cliqu� sur l'�quipe : " + team.getName(),
						 Toast.LENGTH_LONG).show();


	}



	private List<Team> getTeams() {
		List<Team> teams = null ;
		AssetManager assetManager = getBaseContext().getAssets();
		try {
			InputStream is = assetManager.open("teams_infos.xml");
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();
			TeamXMLHandler myXMLHandler = new TeamXMLHandler(this);
			xr.setContentHandler(myXMLHandler);
			InputSource inStream = new InputSource(is);
			xr.parse(inStream);
			teams = myXMLHandler.getCartList();
			is.close();
		} catch (Exception e) {
			Log.getStackTraceString(e);
		}
		return teams;
	}



}
