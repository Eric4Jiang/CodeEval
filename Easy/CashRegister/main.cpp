#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <math.h>

using namespace std;

int main(int argc, char** argv) {
    ifstream infile(argv[1]);
    string line;

    int money[] = {1, 5, 10, 25, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
    string coin[] = {"PENNY", "NICKEL", "DIME", "QUARTER", "HALF DOLLAR", "ONE", "TWO", "FIVE", "TEN", "TWENTY",
                     "FIFTY", "ONE HUNDRED"};

    while(getline(infile, line)) {
        stringstream ss(line);
        string s;
        vector<string> vs;
        while(getline(ss, s, ';'))
            vs.push_back(s);

        int pp = stod(vs[0]) * 100;
        int cash = stod(vs[1]) * 100;

        int change = cash - pp;
        if(change == 0) {
            cout << "ZERO";
        }
        else if(round(change) < 0) {
            cout << "ERROR";

        } else { // there was change

            bool firstPrint = true;
            for(int i = 11; i >= 0; i--) {
                int moneys = money[i];
                while (moneys <= change) {

                    if(firstPrint) {
                        cout << coin[i];
                        firstPrint = false;
                    }
                    else {
                        cout << "," << coin[i];
                    }
                    change -= moneys;
                }
            }
        }
        cout << endl;
    }

    return 0;
}