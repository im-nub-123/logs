#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

// Function to convert input to lowercase
string toLowerCase(string text) {
    transform(text.begin(), text.end(), text.begin(), ::tolower);
    return text;
}

int main() {

    cout << "=====================================\n";
    cout << "   Welcome to Customer Chatbot 🤖\n";
    cout << "=====================================\n";
    cout << "Type your query.\n";
    cout << "Type 'exit' to end the chat.\n\n";

    string userInput;

    while (true) {

        cout << "You: ";
        getline(cin, userInput);

        string query = toLowerCase(userInput);

        // Exit condition
        if (query == "exit") {
            cout << "Bot: Thank you for chatting with us!\n";
            break;
        }

        // Greetings
        else if (query.find("hello") != string::npos ||
                 query.find("hi") != string::npos ||
                 query.find("hey") != string::npos) {

            cout << "Bot: Hello! How can I help you today?\n";
        }

        // Product information
        else if (query.find("product") != string::npos) {

            cout << "Bot: We offer laptops, smartphones, headphones, and smartwatches.\n";
        }

        // Price query
        else if (query.find("price") != string::npos ||
                 query.find("cost") != string::npos) {

            cout << "Bot: Prices start from Rs. 999 depending on the product.\n";
        }

        // Service details
        else if (query.find("service") != string::npos ||
                 query.find("repair") != string::npos) {

            cout << "Bot: We provide repair, replacement, and maintenance services.\n";
        }

        // Delivery query
        else if (query.find("delivery") != string::npos ||
                 query.find("shipping") != string::npos) {

            cout << "Bot: Delivery usually takes 3-5 business days.\n";
        }

        // Refund policy
        else if (query.find("refund") != string::npos ||
                 query.find("return") != string::npos) {

            cout << "Bot: Products can be returned within 7 days with a valid bill.\n";
        }

        // Contact information
        else if (query.find("contact") != string::npos ||
                 query.find("support") != string::npos) {

            cout << "Bot: You can contact us at support@example.com\n";
        }

        // FAQ Example
        else if (query.find("working hours") != string::npos ||
                 query.find("timing") != string::npos) {

            cout << "Bot: Our customer support is available from 9 AM to 6 PM.\n";
        }
        else if (query.find("ok") != string::npos ||
                 query.find("okay") != string::npos) {

            cout << "Bot: Yes, do you have any more queries ? .\n";
        }

        // Unknown query
        else {

            cout << "Bot: Sorry, I couldn't understand your query.\n";
            cout << "Bot: Please ask about products, services, delivery, refund, or support.\n";
        }
    }

    return 0;
}