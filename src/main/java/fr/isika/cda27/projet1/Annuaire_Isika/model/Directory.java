package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.util.ArrayList;

public class Directory {
	
	private ArrayList<Stagiaire> listStagiaires = new ArrayList<Stagiaire>();
	
	public void addStagiaire(Stagiaire stagiaire) {
		System.out.println("directory----------"+stagiaire);
        listStagiaires.add(stagiaire);
        for (Stagiaire stag: listStagiaires) {
			System.out.println("directory----4--"+stag.toString());
		}
    }

	@Override
	public String toString() {
		for (Stagiaire stag: this.listStagiaires) {
			System.out.println("directory----222222--"+stag.toString());
		}
		return "" ;
	}
}
