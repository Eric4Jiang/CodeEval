#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char** argv) {

    ifstream infile(argv[1]);
    string line;

    while(getline(infile, line)) {

        stringstream ss (line);
        string s;
        vector<int> v;
        while(getline(ss, s, ',')) {
            v.push_back(stoi(s));
        }
        int l = v.size()/2;

        bool found = false;

        sort(v.begin(), v.end(), greater<int>());
        int previous = v[0], freq = 1;
        for(size_t i = 1; i < v.size(); i++) {
            if (v[i] == previous) {
                freq++;
            }
            else {
                freq = 1;
            }
            if(freq >= l) {
                found = true;
                cout << previous;
                break;
            }
            previous = v[i];
        }
        if(!found) {
            cout << "None";
        }
        cout << endl;

    }

    return 0;
}