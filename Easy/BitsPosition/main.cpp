#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>

using namespace std;

int main(int argc, char** argv) {

    ifstream infile(argv[1]);
    string line;

    while(getline(infile, line)) {
        stringstream ss(line);
        string s;
        vector<string> v1;

        while (getline(ss, s, ',')) v1.push_back(s);

        int num = stoi(v1[0]), b1 = stoi(v1[1]), b2 = stoi(v1[2]);

        vector<int> binary;
        while(num != 0) {
            int r = num % 2;
            binary.push_back(r);
            num = num/2;
        }

        if(binary[b1 - 1] == binary[b2 - 1])
            cout << "true";
        else
            cout << "false";


        cout << endl;
    }
    return 0;
}