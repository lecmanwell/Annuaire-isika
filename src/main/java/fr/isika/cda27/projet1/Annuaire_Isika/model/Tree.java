package fr.isika.cda27.projet1.Annuaire_Isika.model;

import java.util.ArrayList;

public class Tree {

	private Node root;

	public Tree() {
	}

	public Node getRoot() {
		return root;
	}

	public void setRacine(Node root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return (this.root == null);
	}

	public void insert(Student student) {

		// Si l'arbre n'a pas de racine
		if (root == null) {
			this.root = new Node(student, null, null);
		} else {
			this.root.inserer(student);
		}
	}

	public void getListFromTree(Node node, ArrayList<Student> list) {

		if (node == null) {
			return;
		}

		getListFromTree(node.getLeftChild(), list);

		list.add(node.getData());
		if (node.getListDoublon() != null) {
			System.out.println("Doublon : " + node.getListDoublon().toString());
			list.addAll(node.getListDoublon());
		}

		getListFromTree(node.getRightChild(), list);
	}

	public ArrayList<Student> treeAlphabeticalSorted() {
		ArrayList<Student> studentArrayList = new ArrayList<Student>();
		getListFromTree(this.getRoot(), studentArrayList);
		studentArrayList.toString();
		return studentArrayList;
	}

	public Node searchFromNode(Student student, Node node) {

		int result = student.compareTo(node.getData());
		// Si la valeur est égale au noeud courant
		if (node == null || result == 0) {
			return node;
		}
		// Si la valeur est plus petite que le noeud courant -> recherche récursife dans
		// le SAG
		if (result < 0) {
			return searchFromNode(student, node.getLeftChild());
		} else {
			// Si la valeur est plus grande que le noeud courant -> recherche récursife dans
			// le SAD
			return searchFromNode(student, node.getRightChild());
		}
	}

	public void infixeToString(Node node) {

		if (node == null) {
			return;
		}

		// Algo Parcours infixe =>
		// On parcours la partie sous arbre gauche
		// Ensuite le noeud courant
		// Ensuite la partie sous arbre droit

		infixeToString(node.getLeftChild());

		System.out.println(node.getData().toString());
		if (node.getListDoublon() != null) {
			System.out.println("Doublon : " + node.getListDoublon().toString());
		}

		infixeToString(node.getRightChild());
	}

}
