package com.example.worldcup2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ArrayTeamAdapter extends ArrayAdapter<Team> {

    private ArrayList<Team> teams;
    private LayoutInflater inflater;

    // Constructeur
    public ArrayTeamAdapter(Context context, ArrayList<Team> teams) {
        super(context, 0, teams);
        this.teams = teams;
        inflater = LayoutInflater.from(context);
    }

    // ViewHolder pattern
    private static class ViewHolder {
        TextView name;
        TextView nickname;
        ImageView icon;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // Si convertView est nulle, nous devons créer une nouvelle vue
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_equipe, null);

            // Initialisation des vues dans le holder
            holder.name = convertView.findViewById(R.id.name);
            holder.nickname = convertView.findViewById(R.id.nickname);
            holder.icon = convertView.findViewById(R.id.logo);

            // Stockage du holder comme tag de la vue convertView
            convertView.setTag(holder);
        } else {
            // Si convertView n'est pas nulle, réutilisez le ViewHolder existant
            holder = (ViewHolder) convertView.getTag();
        }

        // Mettre à jour les vues avec les données de l'élément actuel de la liste
        holder.name.setText(teams.get(position).getName());
        holder.nickname.setText(teams.get(position).getNickname());
        holder.icon.setImageResource(teams.get(position).getIcon());

        // Retourner la vue mise à jour
        return convertView;
    }
}

