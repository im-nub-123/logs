import java.util.Scanner;

public class CustomerChatbot {

    // Method to generate bot response
    public static String getResponse(String input) {

        input = input.toLowerCase();

        // Greetings
        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! Welcome to our E-Commerce Store.";
        }

        // Product Information
        else if (input.contains("product") ||
                 input.contains("mobile") ||
                 input.contains("laptop")) {

            return "We provide mobiles, laptops, headphones, and smart watches.";
        }

        // Price Details
        else if (input.contains("price") ||
                 input.contains("cost")) {

            return "Please visit the product page for exact pricing details.";
        }

        // Order Status
        else if (input.contains("order")) {

            return "You can track your order in the 'My Orders' section.";
        }

        // Delivery Information
        else if (input.contains("delivery") ||
                 input.contains("shipping")) {

            return "Delivery takes around 3 to 5 working days.";
        }

        // Return and Refund
        else if (input.contains("return") ||
                 input.contains("refund")) {

            return "Products can be returned within 7 days after delivery.";
        }

        // Payment Methods
        else if (input.contains("payment") ||
                 input.contains("upi") ||
                 input.contains("card")) {

            return "We accept UPI, Debit Card, Credit Card, and Cash on Delivery.";
        }

        // Customer Support
        else if (input.contains("support") ||
                 input.contains("help")) {

            return "Our customer support team is available 24/7.";
        }

        // Thank You Message
        else if (input.contains("thank")) {

            return "You're welcome! Happy shopping.";
        }

        // Exit Message
        else if (input.contains("bye")) {

            return "Thank you for visiting our store!";
        }

        // Default Response
        else {
            return "Sorry, I could not understand your query.";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println(" Customer Interaction Chatbot ");
        System.out.println("====================================");
        System.out.println("Type 'bye' to end the chat.\n");

        while (true) {

            System.out.print("You: ");
            String userInput = sc.nextLine();

            String response = getResponse(userInput);

            System.out.println("Bot: " + response);

            // Exit condition
            if (userInput.equalsIgnoreCase("bye")) {
                break;
            }
        }

        sc.close();
    }
}