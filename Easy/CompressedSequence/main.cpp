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
        vector<string> v;

        while(ss >> s) v.push_back(s);

        int freq = 1;
        for(size_t i = 0; i < v.size() - 1; i++) {
            if(strncmp(v[i].c_str(), v[i + 1].c_str(), v.size()) == 0)
                freq++;
            else {
                cout << freq << " " << v[i] << " ";
                freq = 1; // reset freq for new int
            }
        }

        cout << freq << " " << v[v.size() - 1] << endl;
    }
    return 0;
}