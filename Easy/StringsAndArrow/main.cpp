#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

int main(int argc, char** argv) {

    char leftArrow[] = {'>', '>' ,'-' , '-',  '>'};
    char rightArrow[] = {'<', '-' , '-', '<' , '<'};

    ifstream infile(argv[1]);
    string line;

    while(getline(infile, line)) {
        int arrowsFound = 0;
        //loop through chas

        for(int i = 0; i < line.length(); i++) {
            char c = line[i];
            //detected beginning of left arrow
            if(c == '>') {
                for(int j = 1; j < 5 && i + j < line.length(); j++) {
                    if(line[i + j] != leftArrow[j])
                        break;
                    if(j == 4) // found left arrow
                        arrowsFound++;
                }
            }
            else if(c == '<') {
                for(int j = 1; j < 5 && i + j < line.length(); j++) {
                    char a = line[i + j], b = rightArrow[j];
                    if(a != b)
                        break;
                    if(j == 4) // found left arrow
                        arrowsFound++;
                }
            }
        }

        cout << arrowsFound << endl;
    }
    return 0;
}