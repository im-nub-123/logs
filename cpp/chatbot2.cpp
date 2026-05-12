#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

// Function to convert text into lowercase
string toLower(string str) {
    transform(str.begin(), str.end(), str.begin(), ::tolower);
    return str;
}

int main() {

    string userInput;

    cout << "=========================================\n";
    cout << "        MEDICAL ENQUIRY CHATBOT 🏥\n";
    cout << "=========================================\n";
    cout << "Ask your medical-related queries.\n";
    cout << "Type 'exit' to end the conversation.\n\n";

    while (true) {

        cout << "You : ";
        getline(cin, userInput);

        string query = toLower(userInput);

        // Exit condition
        if (query == "exit") {
            cout << "Bot : Take care! Stay healthy 😊\n";
            break;
        }

        // Greetings
        else if (query.find("hello") != string::npos ||
                 query.find("hi") != string::npos ||
                 query.find("hey") != string::npos) {

            cout << "Bot : Hello! I am your medical assistant chatbot.\n";
        }

        // Fever
        else if (query.find("fever") != string::npos) {

            cout << "Bot : Fever may occur due to infection.\n";
            cout << "Bot : Drink plenty of water and take proper rest.\n";
            cout << "Bot : Consult a doctor if fever continues for more than 2 days.\n";
        }

        // Cold / cough
        else if (query.find("cold") != string::npos ||
                 query.find("cough") != string::npos) {

            cout << "Bot : Common cold and cough can improve with rest and warm fluids.\n";
            cout << "Bot : If symptoms become severe, consult a doctor.\n";
        }

        // Headache
        else if (query.find("headache") != string::npos) {

            cout << "Bot : Headaches can happen due to stress, dehydration, or lack of sleep.\n";
            cout << "Bot : Drink water and take proper rest.\n";
        }

        // Stomach pain
        else if (query.find("stomach") != string::npos ||
                 query.find("abdominal") != string::npos) {

            cout << "Bot : Stomach pain may occur due to indigestion or infection.\n";
            cout << "Bot : Eat light food and stay hydrated.\n";
        }

        // Diabetes
        else if (query.find("diabetes") != string::npos) {

            cout << "Bot : Diabetes patients should monitor blood sugar regularly.\n";
            cout << "Bot : Maintain a healthy diet and exercise daily.\n";
        }

        // Blood pressure
        else if (query.find("blood pressure") != string::npos ||
                 query.find("bp") != string::npos) {

            cout << "Bot : High blood pressure can be controlled with proper diet and exercise.\n";
            cout << "Bot : Avoid excess salt and stress.\n";
        }

        // Appointment
        else if (query.find("appointment") != string::npos) {

            cout << "Bot : Doctor appointments are available from 10 AM to 5 PM.\n";
        }

        // Emergency
        else if (query.find("emergency") != string::npos ||
                 query.find("serious") != string::npos) {

            cout << "Bot : Please contact emergency medical services immediately.\n";
        }

        // Thank you
        else if (query.find("thank") != string::npos) {

            cout << "Bot : You're welcome! Stay healthy 😊\n";
        }

        // Unknown query
        else {

            cout << "Bot : Sorry, I could not understand your medical query.\n";
            cout << "Bot : Please describe symptoms like fever, headache, cough, stomach pain, etc.\n";
        }
    }

    return 0;
}