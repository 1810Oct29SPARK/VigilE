package CodeChallenge;

import java.util.Scanner;

public class MutationsDriver {

	public static void main(String[] args) {
		
		MinimumMutations newMinMut = new MinimumMutations();
		
		System.out.println("Enter a starting gene: ");
		Scanner reader = new Scanner (System.in);
		String start = reader.nextLine();
		
		System.out.println("Enter the ending gene: ");
		String end = reader.nextLine();
		
		System.out.println("Enter the number of valid genes in gene bank : ");
		int numGenes = Integer.parseInt(reader.nextLine());
		
		String[] bank = new String[numGenes];
		
		for (int i = 0; i < bank.length; i++) {
			System.out.println("Enter a gene: ");
			bank[i] = reader.nextLine();
		}

		reader.close();			
	} 



	public static int getNumofMutations(String start, String end, String[] bank) {

		String startGene = start;
		String endGene = end;
		String[] geneBank = bank;
		int isPresent = -1;
		for (int j = 0; j < geneBank.length; j++) {
			if (isPresent == 1) {
				geneBank[j] = endGene;
				return isPresent;
			}
			else if (endGene == geneBank[j]) {
				isPresent = 1;
				break;
			} 
			else if (isPresent == -1 && j == geneBank.length-1 && endGene != geneBank[j]) {
				return isPresent;
			}
				
		}
		
		int counter = 0;
		
		for (int k = 0; k < endGene.length(); k++) {
			if (startGene.charAt(k) != endGene.charAt(k)) {
				counter++;
			}
		}
		
		return counter;
	}
}



