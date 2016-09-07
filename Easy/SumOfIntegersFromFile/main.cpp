#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>

using namespace std;

int main(int argc, char** argv) {

    ifstream infile(argv[1]);
    string line;
    int sum = 0;
    while(getline(infile, line)) {
        sum += stoi(line);
    }
    cout << sum << endl;

    return 0;
}