#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

using namespace std;

int main(int argc, char** argv) {

    ifstream infile(argv[1]);
    string line;

    while(getline(infile, line)) {
        bool none = true;
        for(int i = 0; i < line.length(); i++) {
            char c = line[i];

            if(isdigit(c)) {
                cout << c;
                none = false;
            }
            switch(c) {
                case 'a':
                    none = false;
                    cout << "0";
                    break;
                case 'b':
                    none = false;
                    cout << "1";
                    break;
                case 'c':
                    none = false;
                    cout << "2";
                    break;
                case 'd':
                    none = false;
                    cout << "3";
                    break;
                case 'e':
                    none = false;
                    cout << "4";
                    break;
                case 'f':
                    none = false;
                    cout << "5";
                    break;
                case 'g':
                    none = false;
                    cout << "6";
                    break;
                case 'h':
                    none = false;
                    cout << "7";
                    break;
                case 'i':
                    none = false;
                    cout << "8";
                    break;
                case 'j':
                    none = false;
                    cout << "9";
                    break;
            }
        }
        if(none)
            cout << "NONE";
        cout << endl;
    }
    return 0;
}