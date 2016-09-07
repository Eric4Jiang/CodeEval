#include <iostream>
#include <fstream>
#include <math.h>

using namespace std;

int main(int argc, char** argv) {
    ifstream infile (argv[1]);
    string line;

    while(getline(infile, line)) {
        int sum = 0;
        int exp = 0;

        for (int i = line.size() - 1; i >= 0; i--) {
            char c = line[i];
            int digit;
            if(isalpha(c) && c <= 102) { // 102 = f
                digit = c - 'a' + 10;
            }
            else  // number
                digit = c - '0';

            sum +=  pow(16, exp) * digit;
            exp++;
        }
        cout << sum << endl;

    }
    return 0;
}