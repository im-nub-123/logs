import java.util.Scanner;

public class EcommerceChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println(" Welcome to E-Commerce Chatbot ");
        System.out.println("===================================");
        System.out.println("Type 'exit' to end chat.\n");

        while (true) {

            System.out.print("You: ");
            String userInput = sc.nextLine().toLowerCase();

            // Exit condition
            if (userInput.equals("exit")) {
                System.out.println("Bot: Thank you for visiting our store!");
                break;
            }

            // Product Information
            else if (userInput.contains("product") ||
                     userInput.contains("mobile") ||
                     userInput.contains("laptop")) {

                System.out.println("Bot: We offer mobiles, laptops, headphones, and smart watches.");
            }

            // Price Query
            else if (userInput.contains("price") ||
                     userInput.contains("cost")) {

                System.out.println("Bot: Prices vary depending on the product and brand.");
            }

            // Delivery Query
            else if (userInput.contains("delivery") ||
                     userInput.contains("shipping")) {

                System.out.println("Bot: Delivery usually takes 3-5 business days.");
            }

            // Return Policy
            else if (userInput.contains("return") ||
                     userInput.contains("refund")) {

                System.out.println("Bot: Products can be returned within 7 days of delivery.");
            }

            // Payment Methods
            else if (userInput.contains("payment") ||
                     userInput.contains("upi") ||
                     userInput.contains("card")) {

                System.out.println("Bot: We accept UPI, Credit Card, Debit Card, and Cash on Delivery.");
            }

            // Customer Support
            else if (userInput.contains("support") ||
                     userInput.contains("help")) {

                System.out.println("Bot: Customer support is available 24/7.");
            }

            // FAQ
            else if (userInput.contains("faq")) {

                System.out.println("Bot: Frequently Asked Questions:");
                System.out.println("1. Delivery Time");
                System.out.println("2. Return Policy");
                System.out.println("3. Payment Options");
            }

            // Default Response
            else {
                System.out.println("Bot: Sorry, I could not understand your query.");
            }
        }

        sc.close();
    }
}