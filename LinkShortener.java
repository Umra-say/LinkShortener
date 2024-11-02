package motionCutWork;

import java.util.Scanner;

public class LinkShortener {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		URLMapping urlMapping = new URLMapping("http://abcde.xz");
		
		while(true) {
			System.out.println("1. Shorten URL");
            System.out.println("2. Retrieve Original URL");
            System.out.println("3. Display All URLs");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice) {
            case 1:
                System.out.print("Enter long URL: ");
                String longURL = scanner.nextLine();
                String shortURL = urlMapping.shortenURL(longURL);
                System.out.println("Short URL: " + shortURL);
                break;
            case 2:
                System.out.print("Enter short URL: ");
                String inputShortURL = scanner.nextLine();
                String originalURL = urlMapping.getOriginalURL(inputShortURL);
                System.out.println("Original URL: " + originalURL);
                break;
            case 3:
                urlMapping.displayURLs();
                break;
            case 4:
            	scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Try again.");
        
            }
		}
	}
}
