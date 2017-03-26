package fr.esilv.jcdecaux.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fr.esilv.jcdecaux.R;
import fr.esilv.jcdecaux.models.Example;
import fr.esilv.jcdecaux.models.Item;
import fr.esilv.jcdecaux.models.Station;

public class StationsViewHolder extends RecyclerView.ViewHolder {

	private TextView titre;
	private TextView description;

	public StationsViewHolder(View itemView) {
		super(itemView);
		titre = (TextView) itemView.findViewById(R.id.name);
		description = (TextView) itemView.findViewById(R.id.address);
	}

	public void bind(Item item) {
		titre.setText(item.getSnippet().getTitle());
		description.setText(item.getSnippet().getDescription());
	}
}
