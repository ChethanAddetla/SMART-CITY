#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <string>

using namespace std;

// Forward declarations
class Home;
class Admin;
class User;

class ReadWrite {
public:
    void read(const string& filename);
    void write(const string& filename);
    void adding();
    void reading();
    bool checkCredentials(const string& filePath, const string& loginUsername, const string& loginPassword);
    bool writeCredentials(const string& filePath, const string& username, const string& password);
    void append1();
    void newRegister(const string& filename, const string& n, const string& p, const string& g, const string& m, const string& em, const string& lo);
};

class Admin : public ReadWrite {
public:
    void display2();
};

class User : public ReadWrite {
public:
    void display3();
};

class Home {
public:
    void callUser();
};

void ReadWrite::read(const string& filename) {
    cout << "************** DATA IN THE FILE IS THIS ***************" << endl;
    ifstream file(filename);
    if (file.is_open()) {
        stringstream buffer;
        buffer << file.rdbuf();
        cout << buffer.str() << endl;
        file.close();
    } else {
        cerr << "Error opening file " << filename << endl;
    }
}

void ReadWrite::write(const string& filename) {
    ofstream file(filename, ios::app);
    if (file.is_open()) {
        string n, c, dec, address, mobile, email;
        cout << "Enter name of BUSINESS: ";
        cin >> n;
        cout << "Enter the CATEGORY: ";
        cin >> c;
        cout << "Enter the DESCRIPTION: ";
        cin >> dec;
        cout << "Enter the ADDRESS: ";
        cin >> address;

        cout << "Enter the MOBILE NO: ";
        cin >> mobile;
        cout << "Enter the EMAIL ID: ";
        cin >> email;
        cout << "********* DATA SAVED SUCCESSFULLY **********" << endl;

        file << n << "\t\t\t\t" << c << "\t\t\t\t" << dec << "\t\t\t\t" << address << "\t\t\t\t" << mobile << "\t\t\t\t" << email << endl;
        file.close();

        cout << "Enter '*' to Add new Features in Same City" << endl;
        cout << "Enter '$' to Add new Features in New City" << endl;
        cout << "Enter '#' to Change Portal" << endl;
        char x;
        cin >> x;

        if (x == '*') {
            cout << "***************** YOU CAN ADD NEW DETAILS NOW *****************" << endl;
            write(filename);
        } else if (x == '#') {
            Home obj;
            obj.callUser();
        } else if (x == '$') {
            cout << "***************** YOU CAN CHANGE YOUR CITY NOW *****************" << endl;
            adding();
        } else {
            cout << "************ WRONG ENTRY ***********" << endl;
        }
    } else {
        cerr << "Error opening file " << filename << endl;
    }
}

void ReadWrite::adding() {
    cout << "Type 'ADD' to add features in New City" << endl;
    cout << "Type 'VIEW' to view features of Cities" << endl;
    cout << "Type 'USERS' to see USER details" << endl;
    string opt;
    cin >> opt;

    if (opt == "ADD") {
        cout << ".......ENTER YOUR LOCATION TO ADD DETAILS........" << endl;
        cout << "Type 'AMR' to add features of Amritsar" << endl;
        cout << "Type 'GOA' to add features of Goa" << endl;
        cout << "Type 'LOC' to add features of Lucknow" << endl;
        cout << "Type 'MBI' to add features of Mumbai" << endl;
        cout << "Type 'HYD' to add features of Hyderabad" << endl;
        string aloc;
        cin >> aloc;

        if (aloc == "HYD") {
            cout << "you can add details of Hyderabad" << endl;
            write("hyderabad.txt");
        } else if (aloc == "AMR") {
            cout << "you can add details of Amritsar" << endl;
            write("Amritsar.txt");
        } else if (aloc == "GOA") {
            cout << "you can add details of Goa" << endl;
            write("Goa.txt");
        } else if (aloc == "LOC") {
            cout << "you can add details of Lucknow" << endl;
            write("Lucknow.txt");
        } else if (aloc == "MBI") {
            cout << "you can add details of Mumbai" << endl;
            write("Mumbai.txt");
        } else {
            cout << "****************** INVALID ENTRY ******************" << endl;
            cout << "****************** TRY AGAIN ******************" << endl;
            adding();
        }
    } else if (opt == "VIEW") {
        append1();
    } else if (opt == "USERS") {
        read("newregisters.txt");
        cout << "***************************************************** DATA DISPLAYED SUCCESSFULLY *************************************************" << endl;
        adding();
    } else {
        cout << "****************** INVALID ENTRY ******************" << endl;
        cout << "****************** TRY AGAIN ******************" << endl;
        adding();
    }
}

void ReadWrite::reading() {
    cout << ".......ENTER YOUR LOCATION TO KNOW DETAILS........" << endl;
    cout << "Type 'AMR' to Know Details of Amritsar" << endl;
    cout << "Type 'GOA' to Know Details of Goa" << endl;
    cout << "Type 'LOC' to Know Details of Lucknow" << endl;
    cout << "Type 'MBI' to Know Details of Mumbai" << endl;
    cout << "Type 'HYD' to Know Details of Hyderabad" << endl;
    string aloc;
    cin >> aloc;

    if (aloc == "HYD") {
        cout << "you can read details of Hyderabad" << endl;
        read("hyderabad.txt");
    } else if (aloc == "AMR") {
        cout << "you can read details of Amritsar" << endl;
        read("Amritsar.txt");
    } else if (aloc == "GOA") {
        cout << "you can read details Goa" << endl;
        read("Goa.txt");
    } else if (aloc == "LOC") {
        cout << "you can read details of Lucknow" << endl;
        read("Lucknow.txt");
    } else if (aloc == "MBI") {
        cout << "you can read details of Mumbai" << endl;
        read("Mumbai.txt");
    } else {
        cout << "****************** INVALID ENTRY ******************" << endl;
        cout << "****************** TRY AGAIN ******************" << endl;
        reading();
    }
}

bool ReadWrite::checkCredentials(const string& filePath, const string& loginUsername, const string& loginPassword) {
    ifstream file(filePath);
    if (file.is_open()) {
        string line;
        while (getline(file, line)) {
            stringstream ss(line);
            string username, password;
            getline(ss, username, ',');
            getline(ss, password, ',');
            // string pass =" ";
            // pass= pass+loginPassword;

            // cout<<username<<endl;
            // cout<<password<<endl;
            if (username == loginUsername && password == loginPassword) {
                return true;
            }
        }
        file.close();
    }
    return false;
}

bool ReadWrite::writeCredentials(const string& filePath, const string& username, const string& password) {
    ofstream file(filePath, ios::app);
    if (file.is_open()) {
        file << username << "," << password << endl;
        file.close();
        return true;
    }
    return false;
}

void ReadWrite::append1() {
    try {
        ofstream outputFile("alldata.txt", ios::app);
        vector<string> filesToAppend = { "Hyderabad.txt", "Mumbai.txt", "Lucknow.txt", "Goa.txt", "Amritsar.txt" };
        for (const auto& file : filesToAppend) {
            ifstream inputFile(file);
            if (inputFile.is_open()) {
                string line;
                while (getline(inputFile, line)) {
                    outputFile << line << endl;
                }
                inputFile.close();
            }
        }
        outputFile.close();
        read("alldata.txt");
        cout << "***************************************************** DATA DISPLAYED SUCCESSFULLY *************************************************" << endl;
        adding();
    } catch (const exception& e) {
        cerr << "DATA NOT FOUND" << endl;
    }
}

void ReadWrite::newRegister(const string& filename, const string& n, const string& p, const string& g, const string& m, const string& em, const string& lo) {
    ofstream file(filename, ios::app);
    if (file.is_open()) {
        file << n << "\t\t\t\t" << p << "\t\t\t\t" << g << "\t\t\t\t" << m << "\t\t\t\t" << em << "\t\t\t\t" << lo << endl;
        file.close();
    } else {
        cerr << "Error opening file " << filename << endl;
    }
}

void Home::callUser() {
    cout << "************ HOME PORTAL ************" << endl;
    cout << "ENTER '1' FOR ADMIN LOGIN" << endl;
    cout << "ENTER '2' FOR USER LOGIN" << endl;
    int x;
    cin >> x;
    if (x == 1) {
        Admin obj1;
        obj1.display2();
    } else if (x == 2) {
        User obj1;
        obj1.display3();
    } else {
        cout << "************ WRONG ENTRY ***********" << endl;
        callUser();
    }
}

void Admin::display2() {
    cout << endl;
    cout << "******************** ADMIN LOGIN ********************" << endl;
    cout << endl;
    string username, password;
    cout << "ENTER USERNAME: ";
    cin >> username;
    cout << "ENTER PASSWORD: ";
    cin >> password;
    if ((username == "chethan" && password == "12345") ||
        (username == "sai" && password == "12345") ||
        (username == "sanjay" && password == "12345")) {
        cout << "*************** LOGIN SUCCESSFUL ******************" << endl;
        adding();
    } else {
        cout << "**************** Invalid Credentials ****************" << endl;
        cout << "**************** TRY AGAIN ****************" << endl;
        display2();
    }
}

void User::display3() {
    cout << endl;
    cout << "******************** USER LOGIN ********************" << endl;
    cout << endl;
    cout << "ENTER '!' FOR LOGIN" << endl;
    cout << "ENTER '%' FOR NEW REGISTRATION" << endl;
    char str;
    cin >> str;
    if (str == '!') {
        string username, password;
        cout << "ENTER USERNAME: ";
        cin >> username;
        cout << "ENTER PASSWORD: ";
        cin >> password;
        string filePath = "userdetails.txt";
        if (checkCredentials(filePath, username, password)) {
            cout << "*************** LOGIN SUCCESSFUL ******************" << endl;
            reading();
            cout << "***************************************************** DATA DISPLAYED SUCCESSFULLY *************************************************" << endl;
            cout << "Enter '$' to Change the City" << endl;
            cout << "Enter '#' to LOGOUT" << endl;
            char x;
            cin >> x;
            if (x == '$') {
                reading();
            } else if (x == '#') {
                cout << "*************** LOGOUT SUCCESSFUL ******************" << endl;
                Home obj;
                obj.callUser();
            } else {
                cout << "************ WRONG ENTRY ***********" << endl;
            }
        } else {
            cout << "**************** Invalid Credentials Try Again ****************" << endl;
            display3();
        }
    } else if (str == '%') {
        string username, password, gender, mobile, email, location;
        cout << "ENTER USERNAME: ";
        cin >> username;
        cout << "ENTER PASSWORD: ";
        cin >> password;
        cout << "ENTER GENDER: ";
        cin >> gender;
        cout << "ENTER MOBILE NO: ";
        cin >> mobile;
        cout << "ENTER EMAIL ID: ";
        cin >> email;
        cout << "ENTER LOCATION: ";
        cin >> location;
        newRegister("newregisters.txt", username, password, gender, mobile, email, location);
        string filePath = "userdetails.txt";
        if (writeCredentials(filePath, username, password)) {
            cout << "*************** Registration Successful! ***************" << endl;
            cout << "*************** PLEASE LOGIN AGAIN ***************" << endl;
            display3();
        } else {
            cout << "*************** Registration Failed! ***************" << endl;
            cout << "*************** Try Again ***************" << endl;
            display3();
        }
    }
}

int main() {
    cout << endl;
    cout << "************************** WELCOME TO SMARTCITY MANAGEMENT SYSTEM **************************" << endl;
    cout << endl;
    cout << "ENTER '1' FOR OPENING HOME PORTAL" << endl;
    cout << "ENTER '2' TO LOGIN AS AN ADMIN" << endl;
    cout << "ENTER '3' TO LOGIN AS A USER" << endl;
    cout << "Type Here......." << endl;
    int x;
    cin >> x;
    Home obj1;
    Admin obj2;
    User obj3;
    if (x == 1) {
        obj1.callUser();
    } else if (x == 2) {
        obj2.display2();
    } else if (x == 3) {
        obj3.display3();
    } else {
        cout << "INVALID INPUT" << endl;
    }
    return 0;
}
