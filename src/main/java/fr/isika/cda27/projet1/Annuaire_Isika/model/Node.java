package fr.isika.cda27.projet1.Annuaire_Isika.model;

public class Node {

	private Student data;
	private Node leftChild;
	private Node rightChild;

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
		// to do
		// implémenter dans le cas où les student ont le memem nom de famille
		// proposition, affectation au leftChild
		else if (result == 0) {
			System.out.println("DOUBLON");

			if (this.leftChild == null) {
				this.leftChild = new Node(student, null, null);
				System.out.println("INSERT DOUBLON LEFT");

			} else if (this.rightChild == null) {
				this.rightChild = new Node(student, null, null);
				System.out.println("INSERT DOUBLON Right");

			} else {
				System.out.println("Problème");
				Node temp = this.leftChild;
				this.leftChild = new Node(student, temp, null);

			}

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
		builder.append("]");
		return builder.toString();
	}

}
