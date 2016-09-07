#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <math.h>

using namespace std;

int main(int argc, char** argv) {

    ifstream infile(argv[1]);
    string line;

    while(getline(infile, line)) {
        int sum = 0;
        int n = line.size();

        for (int i = 0; i < line.size(); i++) {
            int digit = line[i] - '0';
            sum += pow(digit, n);
        }

        if(sum == stoi(line))
            cout << "True" << endl;
        else
            cout << "False" << endl;
    }

    return 0;
}