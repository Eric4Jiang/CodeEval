#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>

using namespace std;

int main(int argc, char** argv) {

    ifstream infile(argv[1]);

    string line;

    while(getline(infile, line)) {
        stringstream ss(line);

        vector<string> words;
        string s;
        while (ss >> s) words.push_back(s);

        string longestWord = words[0];
        for(int i = 1; i < words.size(); i++) {
            if(words[i].length() > longestWord.length())
                longestWord = words[i];
        }

        for(int i = 0; i < longestWord.length(); i++) {
            for(int j = 0; j < i; j++)
                cout << "*";
            cout << longestWord.at(i) << " ";
        }
        cout << endl;
    }
    return 0;
}