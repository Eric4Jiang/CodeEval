#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <vector>

using namespace std;

int main(int argc, char** argv) {

    ifstream inFile(argv[1]);
    string line;

    while(getline(inFile, line)) {
        stringstream ss(line);
        string token;

        vector<string> v1;
        while(ss >> token) v1.push_back(token);

        vector<int> nums;
        for(int i = 0; i < v1.size() - 2; i++) {
            nums.push_back(atoi(v1[i].c_str()));
        }
        int iterations = atoi(v1[v1.size() - 1].c_str());

        for(int i = 0; i < iterations; i++) {
            for (int j = 0; j < nums.size() - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    break;
                }
            }
        }

        for (std::vector<int>::const_iterator i = nums.begin(); i != nums.end(); ++i)
            std::cout << *i << ' ';

        cout << endl;
    }

    return 0;
}