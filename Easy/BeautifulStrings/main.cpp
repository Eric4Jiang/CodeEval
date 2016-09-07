#include <iostream>
#include <fstream>
#include <deque>
#include <sstream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char** argv) {

    ifstream infile(argv[1]);
    string line;

    while(getline(infile, line)) {
        int n = 26;
        int hash[n];
        for(int i = 0; i < n; i++) {
            hash[i] = 0;
        }

        //find occurence of each letter
        for(size_t i = 0; i < line.size(); i++) {
            char c = line[i];
            if (isalpha(c)) {
                int index = (int) c;
                if (index >= 97) // lowercase
                    hash[index - 97]++;
                else // uppercase
                    hash[index - 65]++;
            }
        }
        vector<int> occurences;

        for(int i = 0; i < n; i++) {
            int occ = hash[i];
            occurences.push_back(occ);
        }

        sort(occurences.begin(), occurences.end(), greater<int>());

        int sum = 0, num = 26;
        for(size_t i = 0; i < occurences.size(); i++) {
            sum += num * occurences[i];
            num--;
        }

        cout << sum << endl;
    }


    return 0;
}