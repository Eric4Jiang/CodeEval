#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include <string>
#include <cstring>

using namespace std;

int main(int argc, char** argv) {

    ifstream infile(argv[1]);
    string line;

    while(getline(infile, line)) {
        string s = line;
        vector<int> nums;
        int isSelfDescribing = 1;
        for (int i = 0; i < line.size(); i++) {
            int digit = line[i] - '0';
            int occurrences = 0;
            for(int j = 0; j < line.size(); j++) {
                int digit = line[j] - '0';
                if(i == digit)
                    occurrences++;
            }

            if(digit != occurrences) {
                isSelfDescribing = 0;
                break;
            }
        }
        cout << isSelfDescribing << endl;
    }

    return 0;
}