#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <math.h>
#include <string.h>

using namespace std;

int main(int argc, char** argv) {

    ifstream infile(argv[1]);
    string line;

    while(getline(infile, line)) {

        stringstream ss(line);
        string s;
        vector<string> v1;
        string binary = "";

        while(ss >> s)
            v1.push_back(s);

        //get binary value
        for(size_t i = 0; i < v1.size(); i+=2) {

            string sequence = v1[i + 1];

            if(strncmp(v1[i].c_str(), "0", v1[i].length()) == 0)
                binary += sequence;
            else {
                for (size_t j = 0; j < sequence.length(); j++) {
                    binary += "1";
                }
            }
        }
        //convert binary to int
        long decimalValue = 0;
        int exp = 0;
        for(int i = binary.length() - 1; i >=0; i--) {
            char c = binary[i];
            if(c == '1')
                decimalValue += pow(2, exp);
            exp++;
        }

        cout << decimalValue << endl;
    }
    return 0;
}