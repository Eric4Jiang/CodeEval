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

        while (ss >> s) v1.push_back(s);

        for(int i = 0; i < v1.size(); i++) {
            char ch = v1[i].at(0);

            if (ch >= 'a' && ch <= 'z')
                v1[i].at(0) = ch - 32;

            cout << v1[i] << " ";

        }
        cout << endl;
    }
    return 0;
}