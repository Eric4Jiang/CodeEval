#include <iostream>
#include <sstream>
#include <fstream>

int money = 0;
int count = 0;
int coins[] = {1, 5, 10, 25, 50};

void findAlt(int moneyLeft, int coinUsedLast) {
    if(moneyLeft == 0) {
        count = count + 1;
        return;
    }

    for(int i = coinUsedLast; i >=0; i--) {
        if(coins[i] <= moneyLeft) {
            findAlt(moneyLeft - coins[i], i);
        }
    }
}

int main(int argc, char** argv) {

    std::ifstream infile (argv[1]);
    std::string line;

    while(getline(infile, line)) {
        count = 0;
        money = stoi(line);

        findAlt(money, 4);

        std::cout << count;
        std::cout << std::endl;
    }

    return 0;
}