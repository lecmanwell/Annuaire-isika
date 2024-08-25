package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.util.LinkedList;

public class Node {

	private Student data;
	private Node leftChild;
	private Node rightChild;
	private LinkedList<Student> listDoublon;

	public Node(Student data, Node leftChild, Node rightChild) {
		super();
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public Student getData() {
		return data;
	}

	public void setData(Student data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public LinkedList<Student> getListDoublon() {
		
		return listDoublon;
	}

	public void setListDoublon(LinkedList listDoublon) {
		this.listDoublon = listDoublon;
	}

	public void afficher() {
		System.err.println(data);
	}

	public void inserer(Student student) {
		// Si la valeur du noeud qu'on veut insérer
		// est plus petite que la valeur du noeud courant
		int result = student.compareTo(data);
		if (result < 0) {
			// Si le noeud courant n'a pas de fils gauche
			// le nouveau noeud devient son fils gauche
			if (this.leftChild == null) {
				this.leftChild = new Node(student, null, null);
			} else {
				// Le noeud courant possède un fils gauche
				// donc on refait l'appel récursif
				// mais en partant du fils gauche
				this.leftChild.inserer(student);
			}

		}
		// Si la valeur du noeud qu'on veut insérer
		// est plus grande (ou égale) que la valeur du noeud courant
		else if (result > 0) {
			if (rightChild == null) {
				// Le noeud courant n'a pas de fils droit
				this.rightChild = new Node(student, null, null);
			} else {
				// Le noeud courant possède un fils droit
				// donc on refait l'appel récursif
				// mais en partant du fils droit
				this.rightChild.inserer(student);
			}
		}

		else if (result == 0) {
			if (this.getListDoublon() == null) {
				this.listDoublon = new LinkedList<Student>();
				this.listDoublon.add(student);
				this.data.setListDoublon(new LinkedList<Student>());
				this.data.getListDoublon().add(student);
				
			} else {
				this.listDoublon.add(student);
				this.data.getListDoublon().add(student);
			}
			System.out.println("Ajout Doublon:" +this.listDoublon.toString());
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Noeud [data=");
		builder.append(data);
		builder.append(", filsGauche=");
		builder.append(leftChild);
		builder.append(", filsDroit=");
		builder.append(rightChild);
		if (this.getListDoublon() != null) {
			builder.append(", ------------***************------------------");
			builder.append(", listDoublon=");
			builder.append(listDoublon.toString());
			builder.append("]");
		}
		builder.append("]");
		return builder.toString();
	}

}
