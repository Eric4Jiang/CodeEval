#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include <string>

using namespace std;

int main(int argc, char** argv) {

    ifstream infile(argv[1]);
    string line;

    while(getline(infile, line)) {
        stringstream ss(line);
        vector<string> v1;
        string s;

        while (ss>>s) v1.push_back(s);

        cout << v1[v1.size() - 2] << endl;
    }

    return 0;
}