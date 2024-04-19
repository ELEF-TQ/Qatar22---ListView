package com.example.myapplication;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ArrayTeamAdapter extends ArrayAdapter<Team> { 
	
	private LayoutInflater inflater; 
	private List<Team> teams;
	
	@SuppressLint("ResourceType")
	public ArrayTeamAdapter(Context context, List<Team> teams) {
		 super(context, R.id.rowTeamList, teams); 
		  this.inflater = LayoutInflater.from(context);
		  this.teams = teams;
	} 
	
	@SuppressLint("UseCompatLoadingForDrawables")
	@Override
	 public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		if(convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.row_list, null); 
			holder.name = (TextView)convertView.findViewById(R.id.name);
			holder.nickname = (TextView)convertView.findViewById(R.id.nickname);
			holder.icon = (ImageView) convertView.findViewById(R.id.logo); 
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.name.setText(teams.get(position).getName());
		holder.nickname.setText(teams.get(position).getNickname());
		holder.icon.setImageDrawable(parent.getResources().getDrawable(teams.get(position).getIcon()));
		
		return convertView; 
		
	}

	static class ViewHolder {
		  public TextView name ;
		  public TextView nickname;
		  public ImageView icon; 
		 }
	
}
