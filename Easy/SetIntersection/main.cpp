#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <string.h>
using namespace std;

int main(int argc, char** argv) {

    ifstream infile(argv[1]);
    string line;
    while(getline(infile, line)) {
        vector<string> vs;
        vector<string> v1, v2;

        stringstream ss(line);
        string s;
        while(getline(ss, s, ';'))
            vs.push_back(s);

        stringstream s1(vs[0]);

        while(getline(s1, s, ','))
            v1.push_back(s);

        stringstream s2(vs[1]);

        while(getline(s2, s, ','))
            v2.push_back(s);

        bool beginning = true;

        for(int i = 0; i < v1.size(); i++) {
            for(int j = 0; j < v2.size(); j++) {
                if(strcmp(v1[i].c_str(), v2[j].c_str()) == 0) {
                    if (beginning) {
                        cout << v1[i];
                        beginning = false;
                    }
                    else
                        cout << "," << v1[i];
                    break;
                }
            }
        }
        cout << endl;
    }

    return 0;
}